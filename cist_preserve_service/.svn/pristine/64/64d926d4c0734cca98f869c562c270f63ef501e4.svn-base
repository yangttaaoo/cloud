package com.cist.xjzx.gzcx.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.xjzx.gzcx.mapper.GzcxMapper;
import com.cist.xjzx.gzcx.model.JTYW_JOB_ORDER;
import com.cist.xjzx.gzcx.model.JTYW_MAINTENANCE_COMPANY;
import com.cist.xjzx.gzcx.model.JTYW_MAINTENANCE_GROUP;
import com.cist.xjzx.gzcx.model.VW_SBGZ_INFO;
import com.cist.xjzx.gzcx.service.GzcxService;
@Service
public class GzcxServiceImpl implements GzcxService {
	@Autowired
	private GzcxMapper mapper;

	@Override
	public List<VW_SBGZ_INFO> querygz(HashMap<String, Object> map) {
		return mapper.querygz(map);
	}

	@Override
	public Object querygzpageList(HashMap<String, Object> map,PageInfo info) {
		return mapper.querygz(map);
	}

	@Override
	public Integer addgd(HashMap<String, Object> map) {
		return mapper.addgd(map);
	}

	@Override
	public Integer addgdgl(HashMap<String, Object> map) {
		return mapper.addgdgl(map);
	}

	@Override
	public Integer del(HashMap<String, Object> map) {
		return mapper.del(map);
	}

	@Override
	public Integer addgdlc(HashMap<String, Object> map) {
		return mapper.addgdlc(map);
	}

	@Override
	public List<JTYW_JOB_ORDER> querygd(HashMap<String, Object> map) {
		return mapper.querygd(map);
	}

	@Override
	public Object querygdpageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.querygd(map);
	}

	@Override
	public Integer updategd(HashMap<String, Object> map) {
		return mapper.updategd(map);
	}

	@Override
	public List<JTYW_MAINTENANCE_COMPANY> querycompany(HashMap<String, Object> map) {
		return mapper.querycompany(map);
	}

	@Override
	public List<JTYW_MAINTENANCE_GROUP> querygroup(HashMap<String, Object> map) {
		return mapper.querygroup(map);
	}

//	@Override
//	public Integer updategdlc(HashMap<String, Object> map) {
//		return mapper.updategdlc(map);
//	}

}
