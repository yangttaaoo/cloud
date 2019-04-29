package com.cist.yjgl.infoStatistics.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.yjgl.infoStatistics.service.InfoStatisticsService;

@RestController
@RequestMapping("infoStatistics")
public class InfoStatisticsController {
	@Autowired
	private InfoStatisticsService service;

	@RequestMapping("tableSta")
	public HashMap<String, Object> tableSta(@RequestBody HashMap<String, Object> paramMap) {
		 HashMap<String, Object> resultMap = new HashMap<String, Object>();
		 resultMap.put("tableSta", service.getTableStaSum(paramMap));
		return resultMap;

	}
	@RequestMapping("reportForm")
	public HashMap<String, Object> reportForm(@RequestBody HashMap<String, Object> paramMap) {
		 HashMap<String, Object> resultMap = new HashMap<String, Object>();
		 resultMap.put("one", service.getEarlyWarnSum(paramMap));
		 resultMap.put("two", service.getSignInSum(paramMap));
		 resultMap.put("three_yj", service.getYJSum(paramMap));
		 resultMap.put("three_qs", service.getQSSum(paramMap));
		return resultMap;

	}
}
