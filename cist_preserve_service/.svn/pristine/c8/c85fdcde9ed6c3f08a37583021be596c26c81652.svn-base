package com.cist.dveallot.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.dveallot.mapper.DveAllotMapper;
import com.cist.dveallot.model.C_road_item;
import com.cist.dveallot.model.Jtyw_device_allot;
import com.cist.dveallot.model.Sys_frm_code;
import com.cist.dveallot.model.Vw_dev_info;
import com.cist.dveallot.service.DveAllotService;
import com.cist.frame.page.PageInfo;
import com.cist.opsflow.model.Jtyw_company;
import com.cist.opsvdt.model.Jtyw_group;

@Service
public class DveAllotServiceImpl implements DveAllotService{
	
	@Autowired
	private DveAllotMapper mapper;

	@Override
	public List<Jtyw_device_allot> querylist(Map<String, Object> map) {
		return mapper.querylist(map);
	}

	@Override
	public Jtyw_group skGroupName(Map<String, Object> map) {
		return mapper.skGroupName(map);
	}

	@Override
	public List<Vw_dev_info> queryInfo(Map<String, Object> map) {
		return mapper.queryInfo(map);
	}

	@Override
	public List<C_road_item> queryRoad(Map<String, Object> map) {
		return mapper.queryRoad(map);
	}

	@Override
	public Object queryInfopageList(Map<String, Object> map, PageInfo pinfo) {
		return mapper.queryInfo(map);
	}

	@Override
	public Integer addList(Map<String, Object> map) {
		return mapper.addList(map);
	}

	@Override
	public List<Jtyw_company> queryComp(Map<String, Object> map) {
		return mapper.queryComp(map);
	}

	@Override
	public List<Jtyw_group> queryGroup(Map<String, Object> map) {
		return mapper.queryGroup(map);
	}

	@Override
	public List<Sys_frm_code> selectDevList(String fct_code) {
		return mapper.selectDevList(fct_code);
	}
	
}
