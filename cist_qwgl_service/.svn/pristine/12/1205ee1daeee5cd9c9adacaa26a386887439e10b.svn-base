package com.cist.khpdgl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.khpdgl.mapper.ManagementMapper;
import com.cist.khpdgl.model.Qw_AppraiseTopic;
import com.cist.khpdgl.model.Qw_Appraise_Reculations;
import com.cist.khpdgl.model.Sys_frm_code;
import com.cist.khpdgl.service.ManagementService;

@Service
public class ManagementServiceImpl implements ManagementService{

	@Autowired
	private ManagementMapper mapper;

	@Override
	public Object selectAllpageList(Map<String, Object> map, PageInfo p) {
		return mapper.selectCheckAll(map);
	}

	@Override
	public Integer insertCheck(Map<String, Object> map) {
		return mapper.insertCheck(map);
	}

	@Override
	public Integer updateCheck(Map<String, Object> map) {
		return mapper.updateCheck(map);
	}

	@Override
	public Integer deleteCheck(Map<String, Object> map) {
		return mapper.deleteCheck(map);
	}

	@Override
	public Integer deleteCheckAll(String[] pk) {
		return mapper.deleteCheckAll(pk);
	}

	@Override
	public List<Qw_AppraiseTopic> selectTopic() {
		return mapper.selectTopic();
	}

	@Override
	public Integer insertCheckTopic(Map<String, Object> map) {
		return mapper.insertCheckTopic(map);
	}

	@Override
	public List<Sys_frm_code> selectSysFrmCode(String fct_code) {
		return mapper.selectSysFrmCode(fct_code);
	}

	@Override
	public List<Qw_Appraise_Reculations> selectReculations(Integer pk_id) {
		return mapper.selectReculations(pk_id);
	}

	@Override
	public List<Qw_AppraiseTopic> selectTopicList(Integer pk_id) {
		return mapper.selectTopicList(pk_id);
	}

	@Override
	public Integer updateCheckTopic(Map<String, Object> map) {
		return mapper.updateCheckTopic(map);
	}

	@Override
	public Integer deleteCheckListAll(Map<String, Object> map) {
		return mapper.deleteCheckListAll(map);
	}

	@Override
	public List<Qw_AppraiseTopic> selectTopicLists(Integer pk_id) {
		return mapper.selectTopicLists(pk_id);
	}
	
}
