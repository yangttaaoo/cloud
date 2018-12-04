package com.cist.leavemanagment.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.leavemanagment.mapper.LeaveMapper;
import com.cist.leavemanagment.model.Dept;
import com.cist.leavemanagment.model.DeptInfo;
import com.cist.leavemanagment.model.Leave;
import com.cist.leavemanagment.service.LeaveService;
@Service
public class LeaveServiceImpl implements LeaveService{
	@Autowired
	private LeaveMapper lMapper;
	
	@Override
	public Object selectSelfpageList(HashMap<String, Object> map, PageInfo pageInfo) {
		return lMapper.selectSelf(map);
	}
	@Override
	public Object selectSelfoffpageList(HashMap<String, Object> map, PageInfo pageInfo) {
		return lMapper.selectSelfoff(map);
	}
	@Override
	public Integer insertLeave(HashMap<String, Object> map) {
		return lMapper.insertLeave(map);
	}

	@Override
	public Integer deleteById(HashMap<String, Object> map) {
		return lMapper.deleteById(map);
	}

	@Override
	public Integer updateLeave(HashMap<String, Object> map) {
		return lMapper.updateLeave(map);
	}

	@Override
	public List<Dept> selectDept(HashMap<String, Object> map) {
		return lMapper.selectDept(map);
	}

	@Override
	public Object selectNoAuditingpageList(HashMap<String, Object> map,PageInfo pageInfo) {
		return lMapper.selectNoAuditing(map);
	}

	@Override
	public Object selectAllpageList(HashMap<String, Object> map,PageInfo pageInfo) {
		return lMapper.selectAll(map);
	}

	@Override
	public Integer auditingLeave(HashMap<String, Object> map) {
		return lMapper.auditingLeave(map);
	}

	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return lMapper.depart_infolist(dept_superior);
	}

	

	@Override
	public Integer updateLeaveoff(HashMap<String, Object> map) {
		return lMapper.updateLeaveoff(map);
	}

}
