package com.cist.earlymanagement.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.earlymanagement.mapper.EarlyManagementMapper;
import com.cist.earlymanagement.service.EarlyManagementService;
import com.cist.frame.page.PageInfo;

@Service("EarlyManagementService")
public class EarlyManagementServiceImpl implements EarlyManagementService{

	@Autowired
	private EarlyManagementMapper mapper;
	
	@Override
	public Object earlyminfopageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.earlyminfopageList(map);
	}

}
