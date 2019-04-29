package com.cist.mymetrics.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.mymetrics.mapper.MyMetricsMapper;
import com.cist.mymetrics.model.Regulations;
import com.cist.mymetrics.service.MyMetricsService;
@Service
public class MyMetricsServiceImpl implements MyMetricsService{
	@Autowired
	private MyMetricsMapper mapper;

	@Override
	public Object selectOwnMetricspageList(HashMap<String, Object> map, PageInfo pInfo) {
		return mapper.selectOwnMetrics(map);
	}

	@Override
	public List<Regulations> selectRegulations(HashMap<String, Object> map) {
		return mapper.selectRegulations(map);
	}

	
}
