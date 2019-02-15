package com.cist.trafficControl.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.trafficControl.model.TempModel;
import com.cist.trafficControl.model.TrafficControl;
import com.cist.trafficControl.service.TrafficControlService;

@RestController
@RequestMapping("trafficControl")
public class TrafficControlController {
	@Autowired
	private TrafficControlService service;

	@RequestMapping("initFrameTab")
	public HashMap<String, Object> initFrameTab() {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<TempModel> rule = service.getTrafficControlRule();
		resultMap.put("rule", rule);
		return resultMap;

	}

	@RequestMapping("insert")
	public int insert(@RequestBody HashMap<String, Object> paramMap) {
		int insert = service.insert(paramMap);
		return insert;

	}

	@RequestMapping("queryList")
	public PageInfo<TrafficControl> queryList(@RequestBody HashMap<String, Object> paramMap) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		pageInfo.setPageNum(Integer.parseInt(paramMap.get("currentPage").toString()));
		PageInfo<TrafficControl> queryTrafficControlPageList = (PageInfo<TrafficControl>) service.queryTrafficControlpageList(paramMap, pageInfo);
		return queryTrafficControlPageList;

	}
	@RequestMapping("update")
	public int update(@RequestBody HashMap<String, Object> paramMap) {
		int update = service.update(paramMap);
		return update;

	}
	@RequestMapping("delete")
	public int delete(@RequestBody HashMap<String, Object> paramMap) {
		int delete = service.delete(paramMap);
		return delete;
		
	}
}
