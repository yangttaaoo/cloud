package com.cist.warningmanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cist.devmanagement.model.SssbEquipmentRegister;
import com.cist.frame.page.PageInfo;
import com.cist.pcmanagement.service.PcManagementService;
import com.cist.warningmanagement.model.SssbEquipmentWarning;
import com.cist.warningmanagement.service.WarningManagementService;



/***
 * 
 * @Title:WarningManagementController.java
 * @Package:com.cist.warningmanagement.controller
 * @Description:TODO
 * @author:YT
 * @date:2019年3月12日
 * @version V1.0
 */
@RestController
@RequestMapping("warningManagement")
public class WarningManagementController {

	@Autowired
	WarningManagementService service;

	
	
	/**
	 * PC终端入网登记查询
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="list")
	public PageInfo<SssbEquipmentWarning> list(@RequestBody HashMap<String,Object> map) {
	
		PageInfo pinfo = new PageInfo();
		    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<SssbEquipmentWarning> pageinfo = (PageInfo<SssbEquipmentWarning>)service.listpageList(map,pinfo);
			return pageinfo;
	}
	
	/**
	 * PC终端 信息删除
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value ="delete")
	public String delete(@RequestBody HashMap<String,Object> map){
		Integer deletePc = service.deleteWarning(map);
		if(deletePc>0) {
			return "{\"result\":\"删除成功\"}";
		}else {
			return "{\"result\":\"删除失败\"}";
		}
		
	}
	
	/**
	 * 预警信息关联的设备信息查询
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value ="selectDev")
	public Map<String,Object> selectDev(@RequestBody HashMap<String,Object> map){
		Map<String,Object> modelMap= new HashMap<String,Object>();
		//先查询是否有采集设备信息，若无关联设备信息则查询是否有PC终端设备信息
		List<SssbEquipmentRegister> selectDev = service.selectDev(map);
		if(selectDev.size()>0) {
			modelMap.put("sbInfo", selectDev);
			modelMap.put("sbFlag", "cjsb");//标识 页面显示采集设备
			return modelMap;
		}else {
			//不存在采集设备关联信息  查询是否有PC终端关联设备信息
			List<SssbEquipmentRegister> selectPc = service.selectPc(map);
			if(selectPc.size()>0) {
				modelMap.put("sbInfo", selectPc);
				modelMap.put("sbFlag", "pczd");//标识 页面显示pc终端
				return modelMap;
			}
		}
		return modelMap;
		
	}
	
}
