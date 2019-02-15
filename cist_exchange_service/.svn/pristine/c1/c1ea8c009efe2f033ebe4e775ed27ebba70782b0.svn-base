package com.cist.interfacecheck.service.impl;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.interfacecheck.mapper.InterCheckMapper;
import com.cist.interfacecheck.service.InterCheckService;

@Service
public class InterCheckServiceImpl implements InterCheckService  {
	@Autowired
	private InterCheckMapper mapper;

	@Override
	public Integer pass(HashMap<String, Object> map) {
		return mapper.pass(map);
	}

	@Override
	public Integer notPass(HashMap<String, Object> map) {
		return mapper.notPass(map);
	}

	@Override
	public Object listpageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.list(map);
	}

}
