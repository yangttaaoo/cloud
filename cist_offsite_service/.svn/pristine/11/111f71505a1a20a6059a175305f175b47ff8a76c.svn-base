package com.cist.Illegalbusiness.service.impl;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.Illegalbusiness.mapper.IllegalBusinessMapper;
import com.cist.Illegalbusiness.model.DeptInfo;
import com.cist.Illegalbusiness.model.TblOffeVioWorkStat;
import com.cist.Illegalbusiness.model.TblWorkCardStatInfo;
import com.cist.Illegalbusiness.service.IllegalBusinessService;
import com.cist.personalstats.model.PersonalStats;

@Service
public class IllegalBusinessServiceImpl implements IllegalBusinessService  {

	@Autowired
	private IllegalBusinessMapper mapper;

	@Override
	public TblWorkCardStatInfo list(HashMap<String, Object> map) {
		return mapper.list(map);
	}
	
	@Override
	public List<TblOffeVioWorkStat> selectByPolice(HashMap<String, Object> map) {
		return mapper.selectByPolice(map);
	}

	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Override
	public TblOffeVioWorkStat selectIllegal(HashMap<String, Object> map) {
		return mapper.selectIllegal(map);
	}

	@Override
	public List<TblOffeVioWorkStat> selectWsh(HashMap<String, Object> map) {
		return mapper.selectWsh(map);
	}

	@Override
	public List<TblOffeVioWorkStat> selectShzl(HashMap<String, Object> map) {
		return mapper.selectShzl(map);
	}

	@Override
	public List<TblOffeVioWorkStat> selectByDept(HashMap<String, Object> map) {
		return mapper.selectByDept(map);
	}

	@Override
	public TblWorkCardStatInfo selectList(HashMap<String, Object> map) {
		return mapper.selectList(map);
	}

	@Override
	public List<TblOffeVioWorkStat> selectDay(HashMap<String, Object> map) {
		return mapper.selectDay(map);
	}

	@Override
	public List<TblOffeVioWorkStat> selectWeek(HashMap<String, Object> map) {
		return mapper.selectWeek(map);
	}

	@Override
	public List<TblOffeVioWorkStat> selectYear(HashMap<String, Object> map) {
		return mapper.selectYear(map);
	}

	@Override
	public List<TblOffeVioWorkStat> selectMonth(HashMap<String, Object> map) {
		return mapper.selectMonth(map);
	}

	@Override
	public List<PersonalStats> selectAllCount(HashMap<String, Object> map) {
		return mapper.selectAllCount(map);
	}
	
}
