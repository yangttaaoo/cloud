package com.cist.systemparam.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.systemparam.mapper.StmParamMapper;
import com.cist.systemparam.model.Sys_cfg_info;
import com.cist.systemparam.model.Sys_config;
import com.cist.systemparam.service.StmParamService;

@Service
public class StmParamServiceImpl implements StmParamService{
	
	@Autowired
	private StmParamMapper mapper;

	@Override
	public List<Sys_config> queryCfg(Map<String, Object> map) {
		return mapper.queryCfg(map);
	}

	@Override
	public Integer updateCfg(Map<String, Object> map) {
		return mapper.updateCfg(map);
	}
}
