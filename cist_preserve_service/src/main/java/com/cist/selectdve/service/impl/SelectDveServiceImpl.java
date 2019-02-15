package com.cist.selectdve.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.selectdve.mapper.SelectDveMapper;
import com.cist.selectdve.service.SelectDveService;

@Service
public class SelectDveServiceImpl implements SelectDveService{

	@Autowired
	private SelectDveMapper mapper;

	@Override
	public Object queryListpageList(Map<String, Object> map, PageInfo pinfo) {
		return mapper.queryList(map);
	}
	
}
