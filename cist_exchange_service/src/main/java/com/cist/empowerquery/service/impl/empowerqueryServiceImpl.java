package com.cist.empowerquery.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.empowerquery.mapper.empowerqueryMapper;
import com.cist.empowerquery.service.empowerqueryService;
import com.cist.frame.page.PageInfo;
import com.cist.interfacecheck.mapper.InterCheckMapper;

@Service
public class empowerqueryServiceImpl implements empowerqueryService  {
	@Autowired
	private empowerqueryMapper mapper;

	@Override
	public Object listpageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.list(map);
	}


}
