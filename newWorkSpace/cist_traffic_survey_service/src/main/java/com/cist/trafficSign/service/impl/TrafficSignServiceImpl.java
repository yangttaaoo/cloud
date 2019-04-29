package com.cist.trafficSign.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.cist.devRegister.util.TempModel;
import com.cist.frame.page.PageInfo;
import com.cist.trafficSign.mapper.TrafficSignMapper;
import com.cist.trafficSign.service.TrafficSignService;
import org.springframework.stereotype.Service;

@Service
public class TrafficSignServiceImpl implements TrafficSignService {
	@Autowired
	private TrafficSignMapper mapper;

	@Override
	public Object querypageList(HashMap<String, Object> paramMap, PageInfo pageInfo) {
		// TODO Auto-generated method stub
		return mapper.SecurityByglbmTocode(paramMap);
	}

	@Override
	public int deleteById(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.deleteById(paramMap);
	}

	@Override
	public int addTrafficSign(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.addTrafficSign(paramMap);
	}

	@Override
	public int updateTrafficSignById(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.updateTrafficSignById(paramMap);
	}

	@Override
	public TempModel queryBaseDateName(String FCT_CODE, String fc_code) {
		// TODO Auto-generated method stub
		return mapper.queryBaseDateName(FCT_CODE, fc_code);
	}
}