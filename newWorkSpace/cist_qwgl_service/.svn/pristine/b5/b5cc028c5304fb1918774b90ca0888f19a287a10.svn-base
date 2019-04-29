package com.cist.pddwzb.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.khpdgl.model.Qw_AppraiseTopic;
import com.cist.pddwzb.mapper.DeptMapper;
import com.cist.pddwzb.model.NameAndSocre;
import com.cist.pddwzb.service.DeptService;
import com.cist.pdgrzb.model.DeptInfo;
@Service
public class DeptServiceImpl implements DeptService{
	@Autowired
	private DeptMapper dMapper;

	@Override
	public List<DeptInfo> depart_infolists(Integer dept_superior) {
		return dMapper.depart_infolists(dept_superior);
	}

	@Override
	public Object selectDeptAllpageList(HashMap<String, Object> map, PageInfo pageInfo) {
		return dMapper.selectDeptAll(map);
	}

	@Override
	public List<Qw_AppraiseTopic> selectTopic(HashMap<String, Object> map) {
		return dMapper.selectTopic(map);
	}

	@Override
	public List<NameAndSocre> selectTopicById(HashMap<String, Object> map) {
		return dMapper.selectTopicById(map);
	}

	@Override
	public Integer insertDept(HashMap<String, Object> map) {
		return dMapper.insertDept(map);
	}

	@Override
	public Integer selectMetricsId(HashMap<String, Object> map) {
		return dMapper.selectMetricsId(map);
	}

	@Override
	public Integer insertZb(HashMap<String, Object> map) {
		return dMapper.insertZb(map);
	}

	@Override
	public Integer deleteDept(HashMap<String, Object> map) {
		return dMapper.deleteDept(map);
	}

	@Override
	public Integer deleteMetrics(HashMap<String, Object> map) {
		return dMapper.deleteMetrics(map);
	}

	@Override
	public Integer deleteDeptAll(HashMap<String, Object> map) {
		return dMapper.deleteDeptAll(map);
	}

	@Override
	public Integer deleteMetricsAll(HashMap<String, Object> map) {
		return dMapper.deleteMetricsAll(map);
	}

	@Override
	public Integer updateDept(HashMap<String, Object> map) {
		return dMapper.updateDept(map);
	}

}
