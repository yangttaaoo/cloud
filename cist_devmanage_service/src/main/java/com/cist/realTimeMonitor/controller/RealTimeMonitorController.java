package com.cist.realTimeMonitor.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.realTimeMonitor.model.DeptDeviceTree;
import com.cist.realTimeMonitor.model.VideoDeviceTypeStatus;
import com.cist.realTimeMonitor.service.RealTimeMonitorService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("realTimeMonitor")
public class RealTimeMonitorController {
	@Autowired
	private RealTimeMonitorService service;

	/**
	 * 视频实时监控
	 * 
	 * @param paramMap
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("initRealTimeMonitor")
	public HashMap<String, Object> queryStatusTotalByVideoDeviceType(@RequestBody HashMap<String, Object> paramMap)
			throws JsonProcessingException {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		// 根据视频设备类型分组统计离线在线总数
		List<VideoDeviceTypeStatus> deviceTypeTotalNum = service.queryStatusTotalByVideoDeviceType(paramMap);
		// pie数据拼接 横向数据 crosswise 在线数 online_total 离线数 offline_total
		List<String> crosswiseData = new ArrayList<String>();
		List<Long> onlineTotalData = new ArrayList<Long>();
		List<Long> offlineTotalData = new ArrayList<Long>();
		Long onlineTotal = 0L;
		Long offlineTotal = 0L;
		for (VideoDeviceTypeStatus model : deviceTypeTotalNum) {
			Long online_total = model.getDevice_type_online_total();
			Long offline_total = model.getDevice_type_offline_total();
			crosswiseData.add(model.getDevice_type_name());
			onlineTotalData.add(online_total);
			offlineTotalData.add(offline_total);
			onlineTotal += online_total;
			offlineTotal += offline_total;
		}
		resultMap.put("crosswise", crosswiseData);
		resultMap.put("online_total", onlineTotalData);
		resultMap.put("offline_total", offlineTotalData);
		// 视频设备统计离线在线总数
		resultMap.put("onlineTotal", "{\"name\":\"在线\",\"value\":\"" + onlineTotal + "\"}");
		resultMap.put("offlineTotal", "{\"name\":\"离线\",\"value\":\"" + offlineTotal + "\"}");
		// 部门设备Tree
		HashMap<String, Object> initDeptDeviceTree = service.initDeptDeviceTree();
		resultMap.put("device", this.queryDeviceList(paramMap));
		resultMap.putAll(initDeptDeviceTree);
		resultMap.putAll(service.initAdministrativeAreasTree());
		paramMap.put("configKey", "VIDEOINFO");//配置信息
		resultMap.put("MapConfig",service.queryMineMapBaseConfig(paramMap));
		paramMap.put("configKey", "GBVIDEOURL");//视频国标平台地址
		resultMap.put("VideoUrl",service.queryMineMapBaseConfig(paramMap));
		return resultMap;
	}

	@RequestMapping("queryDeviceList")
	public PageInfo<DeptDeviceTree> queryDeviceList(@RequestBody HashMap<String, Object> paramMap) {
		@SuppressWarnings("rawtypes")
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		pageInfo.setPageNum(Integer.parseInt(paramMap.get("currentPage").toString()));
		@SuppressWarnings("unchecked")
		PageInfo<DeptDeviceTree> queryDeviceList = (PageInfo<DeptDeviceTree>) service.queryDevicepageList(paramMap,
				pageInfo);

		return queryDeviceList;
	}

}
