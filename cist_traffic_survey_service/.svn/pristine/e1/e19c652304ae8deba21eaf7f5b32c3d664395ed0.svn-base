package com.cist.securityfacility.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cist.configUrl.model.FileUtil;
import com.cist.devRegister.service.DevRegisterService;
import com.cist.frame.page.PageInfo;
import com.cist.securityfacility.model.Jcsj_sps_facilities;
import com.cist.securityfacility.model.Sys_frm_code;
import com.cist.securityfacility.service.SecurityFacilityService;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
@RequestMapping("/securityfacility")
public class SecurityFacilityController {
	@Autowired
	private SecurityFacilityService service;
	
	@Autowired
	private DevRegisterService service1;
	
	/**
	 * 分页查询安防设施
	 * @param map
	 * @param request
	 * @return
	 * 
	 */
	@RequestMapping("querySecurityFacility")
	public PageInfo<Jcsj_sps_facilities> querySecurityFacility(@RequestBody HashMap<String, Object> map,HttpServletRequest request){
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Jcsj_sps_facilities> pageinfo = (PageInfo<Jcsj_sps_facilities>)service.querySecurityFacilitypageList(map, info);
		return pageinfo;
	}
	/**
	 * 安防设施添加页面初始化
	 * @param map
	 * @return
	 */
	@RequestMapping("SecurityFacilityAddPageInit")
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
		ModelMap.put("fct_code", "AFSS");
		List<Sys_frm_code> afsslx =  service.querySys_frm_code(ModelMap);
		ModelMap.put("afsslx", afsslx);//安防设施类型
		ModelMap.put("fct_code", "R007");
		List<Sys_frm_code> roadtype =  service.querySys_frm_code(ModelMap);
		ModelMap.put("roadtype", roadtype);//道路类型
		return ModelMap;
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
					 map.put("afsssjtp", uploadService);//上传图片路径
				 }
			 }
			service.insertSecurityFacility(map);
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
	
	/**
	 * 更新安防设施信息
	 * @param files
	 * @param data
	 * @return
	 */
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
					 map.put("afsssjtp", uploadService);//上传图片路径
				 }
			 }
			service.updateSecurityFacility(map);
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
	/**
	 * （单条/批量）删除安防设施信息
	 * @param map
	 * @return
	 */
	@RequestMapping("delete")
	public Integer deleteSecurityFacility(@RequestBody HashMap<String, Object> map){
		try {
			service.delSecurityFacility(map);
			return 1;
		} catch (Exception e) {
			return 2;
		}
	}
}
