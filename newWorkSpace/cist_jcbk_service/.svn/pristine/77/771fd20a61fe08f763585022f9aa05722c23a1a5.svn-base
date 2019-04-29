package com.cist.warnCountAnalyze.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.warnCountAnalyze.mapper.WarnCountAnalyzeMapper;
import com.cist.warnCountAnalyze.model.BaseData;
import com.cist.warnCountAnalyze.model.CarAlarmStat;
import com.cist.warnCountAnalyze.service.WarnCountAnalyzeService;

@Service
public class WarnCountAnalyzeServiceImpl implements WarnCountAnalyzeService {
	@Autowired
	private WarnCountAnalyzeMapper mapper;

	@Override
	public List<CarAlarmStat> queryCarAlarmStatList(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.queryCarAlarmStatList(paramMap);
	}

	@Override
	public List<BaseData> queryBaseDataByFct_Code(String FCT_CODE) {
		// TODO Auto-generated method stub
		return mapper.queryBaseDataByFct_Code(FCT_CODE);
	}

	@Override
	public Object querypageList(HashMap<String, Object> paramMap, PageInfo info) {
		// TODO Auto-generated method stub
		return mapper.queryList(paramMap);
	}
}
