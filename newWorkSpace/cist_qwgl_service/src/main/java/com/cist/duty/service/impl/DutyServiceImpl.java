package com.cist.duty.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.duty.mapper.DutyMapper;
import com.cist.duty.model.DutyInfo;
import com.cist.duty.model.EchartsInfo;
import com.cist.duty.model.Rule_info;
import com.cist.duty.model.TlInfo;
import com.cist.duty.service.DutyService;
import com.cist.frame.page.PageInfo;
import com.cist.duty.model.DeptInfo;

@Service("duty")
public class DutyServiceImpl implements DutyService{
	
	@Autowired
	private DutyMapper mapper;
	
	@Override
	public List<Rule_info> rulelist(HashMap<String, Object> modelMap) {
		return mapper.rulelist(modelMap);
	}

	@Override
	public Object dutyInfopageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.dutyInfopageList(map);
	}

	@Override
	public List<Rule_info> infolist() {
		return mapper.infolist();
	}
	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Override
	public DutyInfo getSypideptname(Integer sypi_pk) {
		return mapper.getSypideptname(sypi_pk);
	}

	@Override
	public List<TlInfo> tllist(HashMap<String, Object> modelMap) {
		return mapper.tllist(modelMap);
	}

	@Override
	public EchartsInfo hgecharts(HashMap<String, Object> modelMap) {
		return mapper.hgecharts(modelMap);
	}

	@Override
	public List<EchartsInfo> tlecharts(HashMap<String, Object> modelMap) {
		return mapper.tlecharts(modelMap);
	}

	@Override
	public List<EchartsInfo> lmecharts(HashMap<String, Object> modelMap) {
		return mapper.lmecharts(modelMap);
	}

	@Override
	public List<DutyInfo> dutyInfo(HashMap<String, Object> map) {
		return mapper.dutyInfo(map);
	}

}
