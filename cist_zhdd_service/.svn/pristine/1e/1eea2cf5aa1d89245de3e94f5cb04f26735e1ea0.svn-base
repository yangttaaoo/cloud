package com.cist.keyarea.service.impl;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cist.frame.page.PageInfo;
import com.cist.keyarea.mapper.KeyAreaMapper;
import com.cist.keyarea.service.KeyAreaService;

@Service
public class KeyAreaServiceImpl implements KeyAreaService {
	@Autowired
	private KeyAreaMapper mapper;

	@Override
	public Object listpageList(HashMap<String, Object> map, PageInfo p) {
		return mapper.list(map);
	}

	@Override
	public Integer delete(HashMap<String, Object> map) {
		return mapper.delete(map);
	}

	@Override
	public Integer save(HashMap<String, Object> map) {
		return mapper.save(map);
	}

	@Override
	public Integer update(HashMap<String, Object> map) {
		return mapper.update(map);
	}
}
