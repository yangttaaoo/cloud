package com.cist.bayonetRegister.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.bayonetRegister.service.BayonetRegisterService;
import com.cist.devRegister.model.DeptTree;
import com.cist.devRegister.model.Device;
import com.cist.devRegister.model.DeviceList;
import com.cist.devRegister.service.DevRegisterService;
import com.cist.frame.page.PageInfo;
import com.cist.roadsection.model.DeptInfo;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/bayonetRegister")
public class BayonetRegisterController {
	@Autowired
	private DevRegisterService devService;
	@Autowired
	private BayonetRegisterService service;

	/**
	 * 初始化弹出层参数
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/initTabData")
	public HashMap<String, Object> initTabData(@RequestBody HashMap<String, Object> paramMap,HttpServletRequest request) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("dept", devService.initDeptTree(request));
		resultMap.put("KK67", devService.queryDevFunType("KK67"));
		resultMap.put("R401", devService.queryDevFunType("R401"));
		resultMap.put("R402", devService.queryDevFunType("R402"));
		resultMap.put("devFunType1", service.queryBayonetFunType("G999"));
		// resultMap.put("roadSegite", devService.initRoadSegiteTree(new HashMap<String,
		// Object>()));
		resultMap.put("administrativeAreas", devService.initAdministrativeAreasTree());
		if(null!=paramMap.get("pk_id"))
		resultMap.putAll(this.getBayonetInfo(paramMap));
		return resultMap;

	}

	/**
	 * 初始化卡口备案Index页面查询表单参数值
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/initIndexQueryConditions")
	public HashMap<String, Object> initIndexQueryConditions(@RequestBody HashMap<String, Object> paramMap,HttpServletRequest request) throws Exception {

		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("administrativeAreas", devService.initAdministrativeAreasTree());// 行政区划
		resultMap.put("dept", devService.initDeptTree(request));// 管理部门
		resultMap.put("roadSegite", devService.initAreaRoadTree(paramMap));// 所属道路
		return resultMap;
	}

	@RequestMapping("/roadTreeSearch")
	public HashMap<String, Object> roadTreeSearch(@RequestBody HashMap<String, Object> paramMap) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("roadSegite", devService.initAreaRoadTree(paramMap));// 所属道路
		return resultMap;
	}

	@RequestMapping("/addBayonet")
	@Transactional
	public int addDevRegister(@RequestBody HashMap<String, Object> paramMap) {
		if(devService.queryDeviceByDeviceNum(paramMap)<=0) {
		if(paramMap.get("kilometre_num")!=null){
			paramMap.put("kilometre_num", getLenString(paramMap.get("kilometre_num").toString(),4));
		}else{
			paramMap.put("kilometre_num", "0000");
		}
		if(paramMap.get("meter_num")!=null){
			paramMap.put("meter_num", getLenString(paramMap.get("meter_num").toString(),3));
		}else{
			paramMap.put("meter_num", "000");
		}
		paramMap.put("fk_device_type", "KK");
		int addD = devService.addDeviceInfo(paramMap);
		int addDM = devService.addDevMaintenance(paramMap);
		if (addD > 0 && addDM > 0) {
			return devService.addDevRelationKKInfo(paramMap);
		}
		}else {
			return -204;
		}
		return 1;

	}

	@RequestMapping("/getBayonetInfo")
	@Transactional
	public HashMap<String, Object> getBayonetInfo(@RequestBody HashMap<String, Object> paramMap) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		Device device = service.queryBayonetById(paramMap);
		resultMap.put("baseParam", device);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("dept_code", device.getFk_dept_id());
		hashMap.put("tbek_code", device.getXzqh());
		resultMap.put("road", devService.queryRoadList1(hashMap));
		paramMap.put("belonged_road_id", device.getBelonged_road_id());
		paramMap.put("kilometre_num", device.getKilometre_num());
		paramMap.put("meter_num", device.getMeter_num());
		if(null!=paramMap.get("pk_id"))
		resultMap.put("devInfo", devService.queryDeviceInfo(paramMap));
		resultMap.put("devTypeParam", devService.getDevRelationKKInfo(paramMap));
		return resultMap;

	}
	@RequestMapping("/getBayonetInfoParam")
	@Transactional
	public HashMap<String, Object> getBayonetInfoParam(@RequestBody HashMap<String, Object> paramMap) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("devInfo", devService.queryDeviceInfo(paramMap));
		return resultMap;

	}
	@RequestMapping("/updateBayonetInfo")
	@Transactional
	public int updateBayonetInfo(@RequestBody HashMap<String, Object> paramMap) {
		if(devService.queryDeviceByDeviceNum(paramMap)<=0) {
		if(paramMap.get("kilometre_num")!=null){
			paramMap.put("kilometre_num", getLenString(paramMap.get("kilometre_num").toString(),4));
		}else{
			paramMap.put("kilometre_num", "0000");
		}
		if(paramMap.get("meter_num")!=null){
			paramMap.put("meter_num", getLenString(paramMap.get("meter_num").toString(),3));
		}else{
			paramMap.put("meter_num", "000");
		}
		Device device = devService.getDevice(paramMap);
		devService.deleteDeviceAuditProcess(paramMap);
		if (null != device) {
			devService.deleteDeviceRelationKKInfo(paramMap);
		}
		paramMap.put("fk_device_type", "KK");
		int updateD = devService.updateDeviceInfo(paramMap);
		int updateM = devService.updateDevMaintenance(paramMap);
		if (updateD > 0 && updateM > 0) {
			return devService.addDevRelationKKInfo(paramMap);
		}
		}else {
			return -204;
		}
		return 1;

	}
	
	private String getLenString(String val, int length) {
		
		if(val == null || "".equals(val))
		{
			val = "0";
		}
		String temp = val;
		int len = temp.length();
		int size = length - len;
		if (len < length) {
			for (int i = 0; i <size; i++) {
				temp = "0" + temp;
			}
		}
		return temp;
	}

	@RequestMapping("deleteBayonet")
	@Transactional
	public int deleteBayonet(@RequestBody HashMap<String, Object> paramMap) {

		int delD = devService.deleteDeviceInfo(paramMap);
		int delDM = devService.deleteDevMaintenance(paramMap);
		devService.deleteDeviceAuditProcess(paramMap);
		paramMap.put("fk_device_type", "KK");
		if (delD > 0 && delDM > 0) {
			return devService.deleteDeviceRelationKKInfo(paramMap);
		}
		return 1;
	}

	@RequestMapping("queryImminentExpiryList")
	public PageInfo<Device> queryImminentExpiryList(@RequestBody HashMap<String, Object> paramMap) {
		@SuppressWarnings("rawtypes")
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		pageInfo.setPageNum(Integer.parseInt(paramMap.get("currentPage").toString()));
		@SuppressWarnings("unchecked")
		PageInfo<Device> querypageList = (PageInfo<Device>) service.queryImminentExpirypageList(paramMap, pageInfo);

		return querypageList;

	}

	@RequestMapping("queryDeviceList")
	public PageInfo<DeviceList> queryDeviceList(@RequestBody HashMap<String, Object> paramMap,HttpServletRequest request) {
		// 当前用户的部门 用于部门权限设置
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String deptCode = userMap.get("sypi_dept_code")==null?null:userMap.get("sypi_dept_code").toString();
		paramMap.put("dept", deptCode);//当前用户部门code 用于部门权限 
		@SuppressWarnings("rawtypes")
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		pageInfo.setPageNum(Integer.parseInt(paramMap.get("currentPage").toString()));
		@SuppressWarnings("unchecked")
		PageInfo<DeviceList> queryDeviceList = (PageInfo<DeviceList>) service.queryDevicepageList(paramMap, pageInfo);

		return queryDeviceList;
	}
}
