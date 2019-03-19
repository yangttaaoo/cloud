package com.cist.businessconfig.bayonetapply.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cist.businessconfig.bayonetapply.model.Jcbk_control_vehicle;
import com.cist.businessconfig.bayonetapply.model.Sys_frm_code;
import com.cist.businessconfig.bayonetapply.service.BayonetApplyService;
import com.cist.businessconfig.bayonetmanage.model.Jcbk_control_bayonet;
import com.cist.configUrl.model.FileUtil;
import com.cist.frame.page.PageInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/bayonetapply")
public class BayonetApplyController {
	@Autowired
	private BayonetApplyService service;
	/**
	 * 首页分页查询车辆布控管理信息
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("index")
	public PageInfo<Jcbk_control_vehicle> index(@RequestBody HashMap<String, Object> map,HttpServletRequest request){
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Jcbk_control_vehicle> pageinfo = (PageInfo<Jcbk_control_vehicle>)service.queryBayonetApplyinfopageList(map, info);
		return pageinfo;
	}
	/**
	 * 添加车辆布控管理信息
	 * @param files
	 * @param data
	 * @return
	 */
	@RequestMapping("add")
	public Integer addbayonetapply(List<MultipartFile> files,List<MultipartFile> scanfile,String data){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> map=new HashMap<String,Object>();
			map = objectMapper.readValue(data, Map.class); //JSON转Map
			int a=0;
			int b=0;
			for (MultipartFile multipartFile : files) {
				 if (!multipartFile.isEmpty()){
					 a++;
					 System.err.println(multipartFile.getOriginalFilename());
					 String uploadService = FileUtil.FileUploadService(multipartFile);
					 System.err.println(uploadService);
					 map.put("xyctp"+a, uploadService);
					 
				 }
			}
			for (MultipartFile multipartFile : scanfile) {
				 if (!multipartFile.isEmpty()){
					 System.err.println(multipartFile.getOriginalFilename());
					 String uploadService = FileUtil.FileUploadService(multipartFile);
					 System.err.println(uploadService);
					 map.put("fjtp"+a, uploadService);
				 }
			}
			service.addBayonetApply(map);
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
	
	/**
	 * 添加页面初始化
	 * @param map
	 * @return
	 */
	@RequestMapping("addpageinit")
	public HashMap<String,Object> addpageinit(@RequestBody HashMap<String, Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		
		map.put("fct_code", "C001");//号牌种类
		List<Sys_frm_code> hpzl =  service.querySys_frm_code(map);
		ModelMap.put("hpzl", hpzl);
		
		map.put("fct_code", "C002");//车辆类型
		List<Sys_frm_code> cllx =  service.querySys_frm_code(map);
		ModelMap.put("cllx", cllx);
		
		map.put("fct_code", "C003");//车身颜色
		List<Sys_frm_code> csys =  service.querySys_frm_code(map);
		ModelMap.put("csys", csys);
		
		map.put("fct_code", "C110");//车辆品牌
		List<Sys_frm_code> clpp =  service.querySys_frm_code(map);
		ModelMap.put("clpp", clpp);
		
		map.put("fct_code", "BKLX");//布控类型
		List<Sys_frm_code> bklx =  service.querySys_frm_code(map);
		ModelMap.put("bklx", bklx);
		
		map.put("fct_code", "C009");//号牌前2位
		List<Sys_frm_code> hpprefix =  service.querySys_frm_code(map);
		ModelMap.put("hpprefix", hpprefix);
		
		map.put("fct_code", "BKLY");//布控数据来源
		List<Sys_frm_code> sjly =  service.querySys_frm_code(map);
		ModelMap.put("sjly", sjly);
		
		return ModelMap;
	}
	
	/**
	 * 更新车辆布控管理信息
	 * @param files
	 * @param data
	 * @return
	 */
	@RequestMapping("update")
	public Integer updatebayonetapply(List<MultipartFile> files,List<MultipartFile> scanfile,String data){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> map=new HashMap<String,Object>();
			map = objectMapper.readValue(data, Map.class); //JSON转Map
			int a=0;
			int b=0;
			for (MultipartFile multipartFile : files) {
				 if (!multipartFile.isEmpty()){
					 a++;
					 System.err.println(multipartFile.getOriginalFilename());
					 String uploadService = FileUtil.FileUploadService(multipartFile);
					 System.err.println(uploadService);
					 map.put("xyctp"+a, uploadService);
				 }
			}
			for(int i=3;i>=3-files.size();i--){
				map.put("xyctp"+i, "");
			}
			for (MultipartFile multipartFile : scanfile) {
				 if (!multipartFile.isEmpty()){
					 System.err.println(multipartFile.getOriginalFilename());
					 String uploadService = FileUtil.FileUploadService(multipartFile);
					 System.err.println(uploadService);
					 map.put("fjtp"+a, uploadService);
				 }
			}
			for(int j=3;j>=3-scanfile.size();j--){
				map.put("fjtp"+j, "");
			}
			service.updateBayonetApply(map);
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
	
	/**
	 * 删除车辆布控卡口信息
	 * @param map
	 * @return
	 */
	@RequestMapping("delete")
	public Integer delbayonet(@RequestBody HashMap<String, Object> map){
		try {
			service.deleteBayonetApply(map);
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
}
