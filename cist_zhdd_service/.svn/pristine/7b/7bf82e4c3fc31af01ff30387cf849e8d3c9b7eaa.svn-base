package com.cist.workflow.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cist.frame.page.PageInfo;
import com.cist.workflow.mapper.WorkFlowMapper;
import com.cist.workflow.model.Syspoliceinfo;
import com.cist.workflow.model.Zhdd_wflow_detall;
import com.cist.workflow.service.WorkFlowService;

@Service
public class WorkFlowServiceImpl implements WorkFlowService{

	@Autowired
	private WorkFlowMapper mapper;

	@Override
	public Object selectWorkpageList(Map<String, Object> map, PageInfo p) {
		return mapper.selectWorkFlow(map);
	}

	@Override
	public Integer insertWorkFolw(Map<String, Object> map) {
		return mapper.insertWorkFolw(map);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public Integer deleteWorkFlow(Map<String, Object> map) {
		Integer deleteWorkFlow = mapper.deleteWorkFlow(map);
		mapper.deleteWorkFlowList(map);
		return deleteWorkFlow;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public Integer updateWorkFlow(Map<String, Object> map) {
		Integer updateWorkFlow = mapper.updateWorkFlow(map);
		mapper.deleteWorkFlowList(map);
		if(map.get("list")!=null&&((ArrayList)map.get("list")).size() > 0){
			mapper.insertWorkfDetall(map);
		}
		
		return updateWorkFlow;
	}

	@Override
	public List<Zhdd_wflow_detall> selectWorkfDetall() {
		return mapper.selectWorkfDetall();
	}

	@Override
	public Integer insertWorkfDetall(Map<String, Object> map) {
		return mapper.insertWorkfDetall(map);
	}

	@Override
	public List<Syspoliceinfo> selectPolice(String sypi_code) {
		return mapper.selectPolice(sypi_code);
	}

	@Override
	public List<Zhdd_wflow_detall> selectWorkName(Map<String, Object> map) {
		return mapper.selectWorkName(map);
	}

	@Override
	public List<Zhdd_wflow_detall> selectWorkNames() {
		return mapper.selectWorkNames();
	}

	@Override
	public Integer deleteWorkFlowList(Map<String, Object> map) {
		return mapper.deleteWorkFlowList(map);
	}

	@Override
	public List<Zhdd_wflow_detall> selectDetail(Map<String, Object> map) {
		return mapper.selectDetail(map);
	}
	
	
	
}
