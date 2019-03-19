package com.cist.devmanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.devmanagement.model.CKreisCode;
import com.cist.devmanagement.model.DeptInfo;
import com.cist.devmanagement.model.JcsjDevice;
import com.cist.devmanagement.model.SssbEquipmentRegister;
import com.cist.devmanagement.service.DevManagementService;
import com.cist.frame.page.PageInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/***
 * 
 * @Title:DevManagementController.java
 * @Package:com.cist.devmanagement.controller
 * @Description:采集设备入网登记
 * @author:YT
 * @date:2019年3月6日
 * @version V1.0
 */
@RestController
@RequestMapping("devManagement")
public class DevManagementController {

	@Autowired
	DevManagementService service;

	
	/**
	 * 采集设备入网登记查询
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="list")
	public PageInfo<SssbEquipmentRegister> list(@RequestBody HashMap<String,Object> map) {
	
		PageInfo pinfo = new PageInfo();
		    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<SssbEquipmentRegister> pageinfo = (PageInfo<SssbEquipmentRegister>)service.listpageList(map,pinfo);
			return pageinfo;
	}
	
	
	/**
	 * 已备案设备查询
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="selectDev")
	public PageInfo<JcsjDevice> selectDev(@RequestBody HashMap<String,Object> map) {
	
		PageInfo pinfo = new PageInfo();
		    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<JcsjDevice> pageinfo = (PageInfo<JcsjDevice>)service.selectDevpageList(map,pinfo);
			return pageinfo;
	}
	
	/**
	 * 通过部门code 查询部门pk
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="selectDeptId")
	public List<DeptInfo> selectDeptId(@RequestBody HashMap<String,Object> map) {
	
		    List<DeptInfo> selectDeptId = service.selectDeptId(map);
			return selectDeptId;
	}
	/**
	 * 基础数据下拉框查询 
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value ="baseData")
	public Map<String,Object> addList(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
			modelMap.put("sblxList", service.selectSysFrmCode(SysBaseDataCode.DEVICE_TYPE_CODE));//设备类型
			modelMap.put("zdList", service.selectSysFrmCode(SysBaseDataCode.SYS_ZDLX));//终端类型
		return modelMap;
		
	}
	
	/**
	 * 基础数据下拉框查询 
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value ="terminalList")
	public Map<String,Object> terminalList(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
			modelMap.put("zdList", service.selectSysFrmCode(SysBaseDataCode.SYS_ZDLX));//终端类型
		return modelMap;
		
	}
	
	/**
	 * 采集设备入网登记 信息新增 
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value ="add")
	public String add(@RequestBody HashMap<String,Object> map){
		Integer addRegister = service.addRegister(map);
		if(addRegister>0) {
			return "{\"result\":\"成功\"}";
		}else {
			return "{\"result\":\"失败\"}";
		}
		
	}
	
	/**
	 * 已备案设备批量导入 
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value ="batchAdd")
	public String batchAdd(@RequestBody HashMap<String,Object> map){
		
		Integer batchAddRegister = service.batchAddRegister(map);
		if(batchAddRegister>0) {
			return "{\"result\":\"成功\"}";
		}else {
			return "{\"result\":\"失败\"}";
		}
//		String listTxt = JSONArray.toJSONString((List)map.get("list")); 
//		List<SssbEquipmentRegister> demoList = JSON.parseArray(listTxt,SssbEquipmentRegister.class);
//		Integer batchAdd = service.batchAdd(demoList);
	}
	
	
	
	/**
	 * 采集设备入网登记 信息删除
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value ="delete")
	public String delete(@RequestBody HashMap<String,Object> map){
		Integer deleteRegister = service.deleteRegister(map);
		if(deleteRegister>0) {
			return "{\"result\":\"删除成功\"}";
		}else {
			return "{\"result\":\"删除失败\"}";
		}
		
	}
	
	/**
	 * 采集设备入网登记 信息更新
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value ="update")
	public String update(@RequestBody HashMap<String,Object> map){
		Integer updateRegister = service.updateGather(map);
		if(updateRegister>0) {
			return "{\"result\":\"更新成功\"}";
		}else {
			return "{\"result\":\"更新失败\"}";
		}
		
	}
	
	
	/**
	 * 更新注册信息 审核状态  采集设备 或PC终端
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value ="examineRegister")
	public String updateRegister(@RequestBody HashMap<String,Object> map){
		Integer updateRegister = service.examineRegister(map);
		if(updateRegister>0) {
			return "{\"result\":\"更新成功\"}";
		}else {
			return "{\"result\":\"更新失败\"}";
		}
		
	}
	/**
	 * 管理部门树
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptinfo")
	public String deptinfo() throws JsonProcessingException {
		// 顶级部门
		List<DeptInfo> departinfo = service.depart_infolist(null);
		ObjectMapper mapper = new ObjectMapper();
		List<DeptInfo> list = departinfodg(departinfo);
		String json = mapper.writeValueAsString(getdiwfdidian(list));
		return json.substring(1, json.length() - 1);
	}

	public List<HashMap<String, Object>> getdiwfdidian(List<DeptInfo> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (DeptInfo depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_pk());
			map.put("selectable", depart_info.getSelectable());
			map.put("isLeaf", depart_info.getIsLeaf());
			if (null != depart_info.getChildren()) {// 下级

				map.put("children", getdiwfdidian(depart_info.getChildren()));
				listmap.add(map);
			} else {
				listmap.add(map);
			}
		}
		return listmap;
	}

	public List<DeptInfo> departinfodg(List<DeptInfo> departinfo) {
		for (DeptInfo depart_info : departinfo) {
			// 部门
			List<DeptInfo> list = service.depart_infolist(depart_info.getDept_pk());
			if (list.size() != 0) {
				depart_info.setChildren(list);
				departinfodg(list);
			}
		}
		return departinfo;
	}
	/**
	 * 管理部门树 key为code
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptinfoCode")
	public String deptinfoCode() throws JsonProcessingException {
		// 顶级部门
		List<DeptInfo> departinfo = service.depart_infolist(null);
		ObjectMapper mapper = new ObjectMapper();
		List<DeptInfo> list = departinfodgCode(departinfo);
		String json = mapper.writeValueAsString(getdiwfdidianCode(list));
		return json.substring(1, json.length() - 1);
	}
	
	public List<HashMap<String, Object>> getdiwfdidianCode(List<DeptInfo> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (DeptInfo depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_code());
			map.put("selectable", depart_info.getSelectable());
			map.put("isLeaf", depart_info.getIsLeaf());
			if (null != depart_info.getChildren()) {// 下级

				map.put("children", getdiwfdidianCode(depart_info.getChildren()));
				listmap.add(map);
			} else {
				listmap.add(map);
			}
		}
		return listmap;
	}

	public List<DeptInfo> departinfodgCode(List<DeptInfo> departinfo) {
		for (DeptInfo depart_info : departinfo) {
			// 部门
			List<DeptInfo> list = service.depart_infolist(depart_info.getDept_pk());
			if (list.size() != 0) {
				depart_info.setChildren(list);
				departinfodgCode(list);
			}
		}
		return departinfo;
	}
	
	@RequestMapping("/roadTreeSearch")
	public HashMap<String, Object> roadTreeSearch(@RequestBody HashMap<String, Object> paramMap) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("roadSegite", service.initAreaRoadTree(paramMap));// 所属道路
		return resultMap;
	}
	
	//行政区划
	@RequestMapping("kreis")
	public String kreis()throws JsonProcessingException{
		//顶级行政区划
		List<CKreisCode> kreis = service.kreis(null);
		ObjectMapper mapper = new ObjectMapper();
		List<CKreisCode> list=kreisinfodg(kreis);
		String json=mapper.writeValueAsString(getxzxh(list));
		return json.substring(1, json.length()-1);
	}
	public List<CKreisCode> kreisinfodg(List<CKreisCode> kreis){
		for (CKreisCode kre : kreis) {
			//部门
			List<CKreisCode> list= service.kreisList(kre.getTbek_pk());
			if(list.size()!=0){
				kre.setChildren(list);
				kreisinfodg(list);
			}
		}
		return kreis;
	}
	
	public List<HashMap<String, Object>> getxzxh(List<CKreisCode> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (CKreisCode ckr : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title",ckr.getTbek_name());
			map.put("key", ckr.getTbek_code());
			map.put("disableCheckbox", false);
			if (null != ckr.getChildren()) {// 下级
				map.put("isLeaf", false);
				map.put("children", getxzxh(ckr.getChildren()));
				listmap.add(map);
			} else {
				map.put("isLeaf", true);
				listmap.add(map);
			}
		}
		return listmap;
	}

}
