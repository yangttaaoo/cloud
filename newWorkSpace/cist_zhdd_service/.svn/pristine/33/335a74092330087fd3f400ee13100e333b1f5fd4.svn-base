package com.cist.dj.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.dj.mapper.DJMapper;
import com.cist.dj.model.TblOffeEvdiInfo;
import com.cist.dj.service.DjService;
@Service
public class DjServiceImpl implements DjService{
	@Autowired
	private DJMapper dMapper;

	@Override
	public List<Date> selectAll(HashMap<String, Object> map) {
		return dMapper.selectAll(map);
	}

	@Override
	public Integer selectOneHourCount(HashMap<String, Object> map) {
		return dMapper.selectOneHourCount(map);
	}

	@Override
	public TblOffeEvdiInfo selectLastData(HashMap<String, Object> map) {
		return dMapper.selectLastData(map); 
	}

}
