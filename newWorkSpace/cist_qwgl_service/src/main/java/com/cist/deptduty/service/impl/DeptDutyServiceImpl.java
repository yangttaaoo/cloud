package com.cist.deptduty.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.deptduty.mapper.DeptDutyMapper;
import com.cist.deptduty.service.DeptDutyService;
import com.cist.duty.model.DutyInfo;
import com.cist.duty.model.EchartsInfo;
import com.cist.duty.model.Rule_info;
import com.cist.duty.model.TlInfo;
import com.cist.frame.page.PageInfo;
@Service("deptduty")
public class DeptDutyServiceImpl implements DeptDutyService{
	@Autowired
	private DeptDutyMapper mapper;

	@Override
	public Object deptdutyInfopageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.deptdutyInfopageList(map);
	}

	@Override
	public List<Rule_info> infolist() {
		return mapper.infolist();
	}

	@Override
	public List<Rule_info> rulelist(HashMap<String, Object> modelMap) {
		return mapper.rulelist(modelMap);
	}

	@Override
	public List<TlInfo> tllist(HashMap<String, Object> modelMap) {
		return mapper.tllist(modelMap);
	}

	@Override
	public List<DutyInfo> deptdutyInfo(HashMap<String, Object> map) {
		return mapper.deptdutyInfo(map);
	}
	@Override
	public EchartsInfo hgecharts(HashMap<String, Object> modelMap) {
		return mapper.hgecharts(modelMap);
	}
	@Override
	public List<EchartsInfo> tlecharts(HashMap<String, Object> modelMap) {
		return mapper.tlecharts(modelMap);
	}
}
