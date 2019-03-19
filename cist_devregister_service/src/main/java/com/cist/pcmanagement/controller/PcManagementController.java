package com.cist.pcmanagement.controller;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cist.devmanagement.model.SssbEquipmentRegister;
import com.cist.frame.page.PageInfo;
import com.cist.pcmanagement.service.PcManagementService;


/***
 * 
 * @Title:PcManagementController.java
 * @Package:com.cist.pcmanagement.controller
 * @Description:TODO
 * @author:YT
 * @date:2019年3月12日
 * @version V1.0
 */
@RestController
@RequestMapping("pcManagement")
public class PcManagementController {

	@Autowired
	PcManagementService service;

	
	
	/**
	 * PC终端入网登记查询
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="pcList")
	public PageInfo<SssbEquipmentRegister> pcList(@RequestBody HashMap<String,Object> map) {
	
		PageInfo pinfo = new PageInfo();
		    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<SssbEquipmentRegister> pageinfo = (PageInfo<SssbEquipmentRegister>)service.pcListpageList(map,pinfo);
			return pageinfo;
	}
	
	/**
	 * PC终端  信息新增 
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value ="addPc")
	public String addPc(@RequestBody HashMap<String,Object> map){
		Integer addPc = service.addPc(map);
		if(addPc>0) {
			return "{\"result\":\"成功\"}";
		}else {
			return "{\"result\":\"失败\"}";
		}
		
	}
	
	/**
	 * PC终端 信息更新
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value ="updatePc")
	public String updatePc(@RequestBody HashMap<String,Object> map){
		Integer updateRegister = service.updatePC(map);
		if(updateRegister>0) {
			return "{\"result\":\"更新成功\"}";
		}else {
			return "{\"result\":\"更新失败\"}";
		}
		
	}
	
	/**
	 * PC终端 信息删除
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value ="delete")
	public String delete(@RequestBody HashMap<String,Object> map){
		Integer deletePc = service.deletePc(map);
		if(deletePc>0) {
			return "{\"result\":\"删除成功\"}";
		}else {
			return "{\"result\":\"删除失败\"}";
		}
		
	}
	
}
