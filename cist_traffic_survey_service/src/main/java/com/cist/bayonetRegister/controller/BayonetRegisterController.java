package com.cist.bayonetRegister.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.bayonetRegister.service.BayonetRegisterService;
import com.cist.devRegister.model.Device;
import com.cist.devRegister.model.DeviceList;
import com.cist.devRegister.service.DevRegisterService;
import com.cist.frame.page.PageInfo;

@RestController
@RequestMapping("/bayonetRegister")
public class BayonetRegisterController {
	@Autowired
	private DevRegisterService devService;
	@Autowired
	private BayonetRegisterService service;

	@RequestMapping("/initTabData")
	public HashMap<String, Object> initTabData() throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("dept", devService.initDeptTree());
		resultMap.put("KK67", devService.queryDevFunType("KK67"));
		resultMap.put("R401", devService.queryDevFunType("R401"));
		resultMap.put("R402", devService.queryDevFunType("R402"));
		resultMap.put("devInfo", devService.queryDeviceInfo());
		resultMap.put("road", devService.queryRoadList());
		resultMap.put("devFunType1", service.queryBayonetFunType("G999"));
		return resultMap;

	}
	@RequestMapping("queryList")
	public PageInfo<Device> queryList(@RequestBody HashMap<String, Object> paramMap) {
		@SuppressWarnings("rawtypes")
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		pageInfo.setPageNum(Integer.parseInt(paramMap.get("currentPage").toString()));
		@SuppressWarnings("unchecked")
		PageInfo<Device> querypageList = (PageInfo<Device>) service.querypageList(paramMap, pageInfo);

		return querypageList;

	}
	@RequestMapping("/addBayonet")
	@Transactional
	public int addDevRegister(@RequestBody HashMap<String, Object> paramMap) {
		paramMap.put("fk_device_type", "KK");
		int addD = devService.addDeviceInfo(paramMap);
		int addDM = devService.addDevMaintenance(paramMap);
		if (addD > 0 && addDM > 0) {
			return devService.addDevRelationKKInfo(paramMap);
		}
		return 1;

	}
	@RequestMapping("/getBayonetInfo")
	@Transactional
	public HashMap<String, Object> getBayonetInfo(@RequestBody HashMap<String, Object> paramMap) {
		 HashMap<String, Object> resultMap = new HashMap<String,Object>();
		 resultMap.put("baseParam", service.queryBayonetById(paramMap));
		 resultMap.put("devTypeParam",devService.getDevRelationKKInfo(paramMap));
		return resultMap;

	}
	@RequestMapping("/updateBayonetInfo")
	@Transactional
	public int updateBayonetInfo(@RequestBody HashMap<String, Object> paramMap) {
		Device device = devService.getDevice(paramMap);
		  devService.deleteDeviceAuditProcess(paramMap);
		if (null != device) {
			devService.deleteDeviceRelationKKInfo(paramMap);
		}
		paramMap.put("fk_device_type","KK");
		int updateD = devService.updateDeviceInfo(paramMap);
		int updateM	= devService.updateDevMaintenance(paramMap);
		if (updateD > 0 && updateM>0) {
			return devService.addDevRelationKKInfo(paramMap);
		}
		return 1;

	}
	@RequestMapping("deleteBayonet")
	@Transactional
	public int deleteBayonet(@RequestBody HashMap<String, Object> paramMap) {
		
		int delD = devService.deleteDeviceInfo(paramMap);
		int delDM =devService.deleteDevMaintenance(paramMap);
		devService.deleteDeviceAuditProcess(paramMap);
		paramMap.put("fk_device_type","KK");
		if (delD > 0 && delDM>0 ) {
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
	public PageInfo<DeviceList> queryDeviceList(@RequestBody HashMap<String, Object> paramMap) {
		@SuppressWarnings("rawtypes")
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		pageInfo.setPageNum(Integer.parseInt(paramMap.get("currentPage").toString()));
		@SuppressWarnings("unchecked")
		PageInfo<DeviceList> queryDeviceList = (PageInfo<DeviceList>) service.queryDevicepageList(paramMap, pageInfo);

		return queryDeviceList;
	}
}
