package com.cist.deptdutyall.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.deptdutyall.mapper.DeptDutyAllMapper;
import com.cist.deptdutyall.service.DeptDutyAllService;
import com.cist.duty.model.EchartsInfo;
import com.cist.dutyall.model.DutyAllInfo;
import com.cist.dutyall.model.TlInfo;
import com.cist.frame.page.PageInfo;

@Service("deptdutyall")
public class DeptDutyAllServiceImpl implements DeptDutyAllService{
	
	@Autowired
	private DeptDutyAllMapper mapper;
	
	@Override
	public Object deptdutyAllInfopageList(HashMap<String, Object> map,PageInfo pinfo) {
		return mapper.deptdutyAllInfopageList(map);
	}

	@Override
	public List<DutyAllInfo> deptdutyAllInfo(HashMap<String, Object> map) {
		return mapper.deptdutyAllInfo(map);
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
	public List<TlInfo> tllist(Integer sypi_pk) {
		return mapper.tllist(sypi_pk);
	}

	@Override
	public List<TlInfo> tlcx() {
		return mapper.tlcx();
	}
}
