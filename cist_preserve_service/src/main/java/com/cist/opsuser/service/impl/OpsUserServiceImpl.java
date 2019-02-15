package com.cist.opsuser.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.opsflow.model.Jtyw_company;
import com.cist.opsuser.mapper.OpsUserMapper;
import com.cist.opsuser.service.OpsUserService;
import com.cist.opsvdt.model.Jtyw_group;

@Service()
public class OpsUserServiceImpl implements OpsUserService{

	@Autowired OpsUserMapper mapper;
	


	@Override
	public Integer updateOps(Map<String, Object> map) {
		return mapper.updateOps(map);
	}

	@Override
	public Integer insertOps(Map<String, Object> map) {
		return mapper.insertOps(map);
	}

	@Override
	public Integer deleteOps(Map<String, Object> map) {
		return mapper.deleteOps(map);
	}

	@Override
	public Integer deleteAll(String[] pk) {
		return mapper.deleteAll(pk);
	}

	@Override
	public Object queryAllpageList(Map<String, Object> map, PageInfo pinfo) {
		return mapper.quertAll(map);
	}

	@Override
	public List<Jtyw_company> queryUser(Map<String, Object> map) {
		return mapper.queryUser(map);
	}

	@Override
	public List<Jtyw_group> queryGroup(Map<String, Object> map) {
		return mapper.queryGroup(map);
	}

	@Override
	public Jtyw_company skCompanyName(HashMap<String, Object> map) {
		return mapper.skCompanyName(map);
	}

	@Override
	public Jtyw_group skGroupName(HashMap<String, Object> map) {
		return mapper.skGroupName(map);
	}


	
	
}
