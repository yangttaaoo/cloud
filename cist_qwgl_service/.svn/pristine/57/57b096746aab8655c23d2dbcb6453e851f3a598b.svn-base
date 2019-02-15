package com.cist.khpdlmgl.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.khpdlmgl.mapper.LmglMapper;
import com.cist.khpdlmgl.service.LmglService;
@Service
public class LmglServiceimpl implements LmglService {
@Autowired
private LmglMapper mapper;
	@Override
	public Object selectDatapageList(HashMap<String, Object> map, PageInfo page) {
		return mapper.selectData(map);
	}
	
	@Override
	public Integer addData(HashMap<String, Object> map) {
		return mapper.addData(map);
	}
	@Override
	public Integer updateData(HashMap<String, Object> map) {
		return mapper.updateData(map);
	}
	@Override
	public Integer deleteData(String[] pk) {
		return mapper.deleteData(pk);
	}

	@Override
	public Integer deletOneData(HashMap<String, Object> map) {
		return mapper.deletOneData(map);
	}

}
