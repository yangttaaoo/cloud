package com.cist.dutyall.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.duty.model.EchartsInfo;
import com.cist.dutyall.mapper.DutyAllMapper;
import com.cist.dutyall.model.DutyAllInfo;
import com.cist.dutyall.model.TlInfo;
import com.cist.dutyall.service.DutyAllService;
import com.cist.frame.page.PageInfo;

@Service("dutyall")
public class DutyAllServiceImpl implements DutyAllService{
	@Autowired
	private DutyAllMapper mapper;
	
	@Override
	public Object dutyAllInfopageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.dutyAllInfopageList(map);
	}

	@Override
	public List<DutyAllInfo> dutyAllInfo(HashMap<String, Object> map) {
		return mapper.dutyAllInfo(map);
	}
	@Override
	public EchartsInfo hgecharts(HashMap<String, Object> modelMap) {
		return mapper.hgecharts(modelMap);
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
