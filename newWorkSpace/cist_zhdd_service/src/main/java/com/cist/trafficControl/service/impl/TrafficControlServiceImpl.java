package com.cist.trafficControl.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.trafficControl.mapper.TrafficControlMapper;
import com.cist.trafficControl.model.TempModel;
import com.cist.trafficControl.service.TrafficControlService;

@Service
public class TrafficControlServiceImpl implements TrafficControlService {
	@Autowired
	private TrafficControlMapper mapper;

	@Override
	public List<TempModel> getTrafficControlRule() {
		// TODO Auto-generated method stub
		return mapper.getTrafficControlRule();
	}

	@Override
	public int insert(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.insert(paramMap);
	}

	@Override
	public Object queryTrafficControlpageList(HashMap<String, Object> paramMap, PageInfo pageInf0) {
		// TODO Auto-generated method stub
		return mapper.queryTrafficControlList(paramMap);
	}

	@Override
	public int update(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.update(paramMap);
	}

	@Override
	public int delete(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.delete(paramMap);
	}



}
