package com.cist.patrolplan.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.patrolplan.mapper.PatrolplanMapper;
import com.cist.patrolplan.model.Dept;
import com.cist.patrolplan.model.Tbl_Dev_Info;
import com.cist.patrolplan.model.UpdateData;
import com.cist.patrolplan.service.PatrolplanService;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CASE;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CONFIG;
@Service
public class PatrolplanServiceImpl implements PatrolplanService {
	@Autowired
	private PatrolplanMapper pMapper;
	
	@Override
	public Object selectAllpageList(HashMap<String, Object> map, PageInfo info) {
		return pMapper.selectAll(map);
	}

	@Override
	public List<Dept> selectDept(HashMap<String, Object> map) {
		return pMapper.selectDept(map);
	}

	@Override
	public Integer deleteByVccname(HashMap<String, Object> map) {
		return pMapper.deleteByVccname(map);
	}

	@Override
	public Integer deleteByVccpk(HashMap<String, Object> map) {
		return pMapper.deleteByVccpk(map);
	}

	@Override
	public TBL_VIO_CRUISE_CASE selectTvcc(HashMap<String, Object> map) {
		return pMapper.selectTvcc(map);
	}

	@Override
	public Integer addTblVioCruiseCase(HashMap<String, Object> map) {
		return pMapper.addTblVioCruiseCase(map);
	}

	@Override
	public Integer insertTblVioCruiseConfig(HashMap<String, Object> map) {
		return pMapper.insertTblVioCruiseConfig(map);
	}

	@Override
	public Tbl_Dev_Info getVideoMonitorInfo(HashMap<String, Object> map) {
		return pMapper.getVideoMonitorInfo(map);
	}

	@Override
	public List<TBL_VIO_CRUISE_CONFIG> getTblVioCruiseConfig(HashMap<String, Object> map) {
		return pMapper.getTblVioCruiseConfig(map);
	}

	@Override
	public List<UpdateData> getUpdatedata(HashMap<String, Object> map) {
		return pMapper.getUpdatedata(map);
	}

	@Override
	public Integer updateTblVioCruiseCase(HashMap<String, Object> map) {
		return pMapper.updateTblVioCruiseCase(map);
	}

	@Override
	public Integer deleteVccpk(HashMap<String, Object> map) {
		return pMapper.deleteVccpk(map);
	}
	
}
