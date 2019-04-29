package com.cist.yjgl.ljqygl.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.yjgl.ljqygl.mapper.LjqyglMapper;
import com.cist.yjgl.ljqygl.model.Jcbk_Ljqy;
import com.cist.yjgl.ljqygl.service.LjqyglService;
@Service
public class LjqyglServiceImpl implements LjqyglService {
	@Autowired
	private LjqyglMapper mapper;

	@Override
	public List<Jcbk_Ljqy> queryljqygl(HashMap<String, Object> map) {
		return mapper.queryljqygl(map);
	}

	@Override
	public Object queryljqyglpageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.queryljqygl(map);
	}

	@Override
	public Integer addljqygl(HashMap<String, Object> map) {
		return mapper.addljqygl(map);
	}

	@Override
	public Integer delljqygl(HashMap<String, Object> map) {
		return mapper.delljqygl(map);
	}

	@Override
	public Integer updateljqygl(HashMap<String, Object> map) {
		return mapper.updateljqygl(map);
	}

	@Override
	public String querydept_name(String dept_pk) {
		return mapper.querydept_name(dept_pk);
	}

	@Override
	public String querypolicename(String sypi_code) {
		return mapper.querypolicename(sypi_code);
	}

}
