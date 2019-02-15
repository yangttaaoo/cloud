package com.cist.softexploitdev.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.softexploitdev.mapper.SoftExploitDevMapper;
import com.cist.softexploitdev.service.SoftExploitDevService;
import com.cist.visitinterface.model.SjgxDevCompany;
@Service
public class SoftExploitDevServiceImpl implements SoftExploitDevService {
	@Autowired
	private SoftExploitDevMapper mapper;

	@Override
	public Object querylistpageList(HashMap<String,Object> map,PageInfo info) {
		return mapper.querylist(map);
	}

	@Override
	public Integer add(HashMap<String, Object> map) {
		return mapper.add(map);
	}

	@Override
	public Integer queryid() {
		return mapper.queryid();
	}

	@Override
	public Integer update(HashMap<String, Object> map) {
		return mapper.update(map);
	}
	@Override
	public Integer del(HashMap<String, Object> map) {
		return mapper.del(map);
	}
}
