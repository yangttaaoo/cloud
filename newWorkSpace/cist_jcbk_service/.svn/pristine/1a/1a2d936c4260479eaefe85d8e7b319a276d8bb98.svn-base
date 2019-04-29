package com.cist.earlytrail.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.earlytrail.mapper.EarlyTrailMapper;
import com.cist.earlytrail.service.EarlyTrailService;
import com.cist.frame.page.PageInfo;

@Service("EarlyTrailService")
public class EarlyTrailServiceImpl implements EarlyTrailService{
	@Autowired
	private EarlyTrailMapper mapper;
	
	
	@Override
	public Object trailinfopageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.trailinfopageList(map);
	}

}
