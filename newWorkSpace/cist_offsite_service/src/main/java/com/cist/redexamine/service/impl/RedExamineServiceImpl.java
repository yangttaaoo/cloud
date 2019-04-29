package com.cist.redexamine.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.redexamine.mapper.RedExamineMapper;
import com.cist.redexamine.service.RedExamineService;

@Service("RedExamineService")
public class RedExamineServiceImpl implements RedExamineService{

	@Autowired
	private RedExamineMapper mapper;
	
	@Override
	public int examineRedInfo(HashMap<String, Object> map) {
		return mapper.examineRedInfo(map);
	}

}
