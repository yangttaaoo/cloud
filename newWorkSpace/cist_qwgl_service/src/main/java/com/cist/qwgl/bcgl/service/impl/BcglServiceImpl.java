package com.cist.qwgl.bcgl.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.qwgl.bcgl.mapper.BcglMapper;
import com.cist.qwgl.bcgl.model.DeptInfo;
import com.cist.qwgl.bcgl.model.Qw_type;
import com.cist.qwgl.bcgl.model.Qwgl_bc_info;
import com.cist.qwgl.bcgl.service.BcglService;
@Service
public class BcglServiceImpl implements BcglService {
	@Autowired
	private BcglMapper mapper;
	
	public Object querybcpageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.querybc(map);
	}

	public List<Qwgl_bc_info> querybc(HashMap<String, Object> map) {
		return mapper.querybc(map);
	}

	public List<Qw_type> queryqwlx(HashMap<String, Object> map) {
		return mapper.queryqwlx(map);
	}

	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	public Integer querymaxpk() {
		return mapper.querymaxpk();
	}

	public Integer addbcinfo(HashMap<String, Object> map) {
		return mapper.addbcinfo(map);
	}

	public Integer updatebcinfo(HashMap<String, Object> map) {
		return mapper.updatebcinfo(map);
	}

	public Integer deletebcinfo(HashMap<String, Object> map) {
		return mapper.deletebcinfo(map);
	}

	@Override
	public String querydept(String dept_pk) {
		return mapper.querydept(dept_pk);
	}



}
