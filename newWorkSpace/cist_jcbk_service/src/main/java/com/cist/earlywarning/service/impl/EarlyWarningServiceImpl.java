package com.cist.earlywarning.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.earlywarning.mapper.EarlyWarningMapper;
import com.cist.earlywarning.model.DeptInfo;
import com.cist.earlywarning.model.WarningInfo;
import com.cist.earlywarning.service.EarlyWarningService;
import com.cist.frame.page.PageInfo;

@Service("EarlyWarningService")
public class EarlyWarningServiceImpl implements EarlyWarningService{

	@Autowired
	private EarlyWarningMapper mapper;
	
	@Override
	public Object earlyinfopageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.earlyinfopageList(map);
	}

	@Override
	public WarningInfo earlyone() {
		return mapper.earlyone();
	}

	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Override
	public List<DeptInfo> userlist(Integer dept_superior) {
		return mapper.userlist(dept_superior);
	}

	@Override
	public int addiss(HashMap<String, Object> map) {
		return mapper.addiss(map);
	}

	@Override
	public int addUserIss(HashMap<String, Object> map) {
		return mapper.addUserIss(map);
	}

	@Override
	public String getHpzlname(String hpzl) {
		return mapper.getHpzlname(hpzl);
	}

	@Override
	public String getSsbmname(String ssbm) {
		return mapper.getSsbmname(ssbm);
	}

}
