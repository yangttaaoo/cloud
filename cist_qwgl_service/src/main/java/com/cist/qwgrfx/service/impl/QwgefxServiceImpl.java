package com.cist.qwgrfx.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.khpdgl.model.Qw_Appraise_Reculations;
import com.cist.personageassess.model.Qw_individual_assessment;
import com.cist.qwgrfx.mapper.QwgefxMapper;
import com.cist.qwgrfx.model.Excels;
import com.cist.qwgrfx.model.NumList;
import com.cist.qwgrfx.model.SysPoliceInfo;
import com.cist.qwgrfx.service.QwgefxService;

@Service
public class QwgefxServiceImpl implements QwgefxService{

	@Autowired
	private QwgefxMapper mapper;

	@Override
	public Object selectAllpageList(Map<String, Object> map, PageInfo p) {
		return mapper.selectPersonAll(map);
	}

	@Override
	public List<SysPoliceInfo> selectPolice() {
		return mapper.selectPolice();
	}

	@Override
	public Object selectAllListpageList(Map<String, Object> map, PageInfo p) {
		return mapper.selectPersonAllList(map);
	}

	@Override
	public List<Qw_Appraise_Reculations> selectReculations(Integer pk_id) {
		return mapper.selectReculations(pk_id);
	}

	@Override
	public List<NumList> selectAll(HashMap<String, Object> map) {
		return mapper.selectAll(map);
	}

	@Override
	public List<Number> selectDesc(HashMap<String, Object> map) {
		return mapper.selectDesc(map);
	}

	@Override
	public Qw_individual_assessment querypersonageassessinfo(Integer pk_id) {
		return mapper.querypersonageassessinfo(pk_id);
	}

	@Override
	public List<Excels> selectAllList(HashMap<String, Object> map) {
		return mapper.selectAllList(map);
	}
	
}
