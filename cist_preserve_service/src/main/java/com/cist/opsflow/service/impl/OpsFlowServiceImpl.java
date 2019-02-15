package com.cist.opsflow.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.opsflow.mapper.OpsFlowMapper;
import com.cist.opsflow.model.DeptInfo;
import com.cist.opsflow.service.OpsFlowService;

@Service
public class OpsFlowServiceImpl implements OpsFlowService{

	@Autowired
	private OpsFlowMapper mapper;

	@Override
	public Object queryAllpageList(Map<String, Object> map, PageInfo pinfo) {
		return mapper.quertAll(map);
	}

	@Override
	public Integer updateOps(Map<String, Object> map) {
		return mapper.updateOps(map);
	}

	@Override
	public Integer deleteOps(Map<String, Object> map) {
		return mapper.deleteOps(map);
	}

	@Override
	public Integer insertOps(Map<String, Object> map) {
		return mapper.insertOps(map);
	}

	@Override
	public Integer deleteAll(String[] pk) {
		return mapper.deleteAll(pk);
	}

	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}
	
}
