package com.cist.isolationfacility.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cist.configUrl.model.FileUtil;
import com.cist.devRegister.service.DevRegisterService;
import com.cist.frame.page.PageInfo;
import com.cist.isolationfacility.model.Jcsj_barrier_facilities;
import com.cist.isolationfacility.service.IsolationFacilityService;
import com.cist.securityfacility.model.Sys_frm_code;
import com.cist.securityfacility.service.SecurityFacilityService;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
@RequestMapping("isolationfacility")
public class IsolationFacilityController {
	@Autowired
	private IsolationFacilityService service;
	
	@Autowired
	private DevRegisterService service1;
	
	@Autowired
	private SecurityFacilityService service2;
	/**
	 * 分页查询隔离设施信息
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("queryJcsj_barrier_facilities")
	public PageInfo<Jcsj_barrier_facilities> querySecurityFacility(@RequestBody HashMap<String, Object> map,HttpServletRequest request){
		// 当前用户的部门 用于部门权限设置
		HttpSession session = request.getSession();
		Map<String,Object> map1 = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String deptCode = map1.get("sypi_dept_code")==null?null:map1.get("sypi_dept_code").toString();
		map.put("dept", deptCode);//当前用户部门code 用于部门权限 
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Jcsj_barrier_facilities> pageinfo = (PageInfo<Jcsj_barrier_facilities>)service.queryJcsj_barrier_facilitiespageList(map, info);
		return pageinfo;
	}
	
	/**
	 * 隔离设施添加页面初始化
	 * @param map
	 * @return
	 */
	@RequestMapping("IsolationFacilityAddPageInit")
	public HashMap<String, Object> SecurityFacilityAddPageInit(@RequestBody HashMap<String, Object> map,HttpServletRequest request){
		HashMap<String, Object> ModelMap = new HashMap<String, Object>();
		String initDeptTree = null;
		try {
			initDeptTree = service1.initDeptTree(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelMap.put("xzqh", service1.initAdministrativeAreasTree());//行政区划
		ModelMap.put("dept", initDeptTree);
		ModelMap.put("fct_code", "GLLX");
		List<Sys_frm_code> glsslx =  service2.querySys_frm_code(ModelMap);
		ModelMap.put("glsslx", glsslx);//隔离设施类型
		ModelMap.put("fct_code", "GLCL");
		List<Sys_frm_code> glsscl =  service2.querySys_frm_code(ModelMap);
		ModelMap.put("glsscl", glsscl);//隔离设施材料
		ModelMap.put("fct_code", "R007");
		List<Sys_frm_code> roadtype =  service2.querySys_frm_code(ModelMap);
		ModelMap.put("roadtype", roadtype);//道路类型
		return ModelMap;
	}
	
	/**
	 * （单条/批量）删除隔离设施信息
	 * @param map
	 * @return
	 */
	@RequestMapping("delete")
	public Integer deleteJcsj_barrier_facilities(@RequestBody HashMap<String, Object> map){
		try {
			service.deleteJcsj_barrier_facilities(map);
			return 1;
		} catch (Exception e) {
			return 2;
		}
	}
	
	/**
	 * 添加安防设施信息
	 * @param map
	 * @return
	 */
	@RequestMapping("add")
	public Integer insertSecurityFacility(List<MultipartFile> files,String data){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> map=new HashMap<String,Object>();
			map = objectMapper.readValue(data, Map.class); //JSON转Map
			for (MultipartFile multipartFile : files) {
				 if (!multipartFile.isEmpty()){
					 System.err.println(multipartFile.getOriginalFilename());
					 String uploadService = FileUtil.FileUploadService(multipartFile);
					 System.err.println(uploadService);
					 map.put("glsssjtp", uploadService);//上传图片路径
				 }
			 }
			service.insertJcsj_barrier_facilities(map);
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
	
	@RequestMapping("update")
	public Integer updateSecurityFacility(List<MultipartFile> files,String data){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> map=new HashMap<String,Object>();
			map = objectMapper.readValue(data, Map.class); //JSON转Map
			for (MultipartFile multipartFile : files) {
				 if (!multipartFile.isEmpty()){
					 System.err.println(multipartFile.getOriginalFilename());
					 String uploadService = FileUtil.FileUploadService(multipartFile);
					 System.err.println(uploadService);
					 map.put("glsssjtp", uploadService);//上传图片路径
				 }
			 }
			service.updateJcsj_barrier_facilities(map);
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
}