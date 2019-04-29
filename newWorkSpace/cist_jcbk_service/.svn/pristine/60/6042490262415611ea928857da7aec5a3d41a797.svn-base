package com.cist.yjgl.infoStatistics.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.yjgl.infoStatistics.mapper.InfoStatisticsMapper;
import com.cist.yjgl.infoStatistics.model.StaModel;
import com.cist.yjgl.infoStatistics.model.TableStaModel;
import com.cist.yjgl.infoStatistics.service.InfoStatisticsService;
@Service
public class InfoStatisticsServiceImpl implements   InfoStatisticsService{
	@Autowired
	private InfoStatisticsMapper mapper;
	@Override
	public List<TableStaModel> getTableStaSum(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.getTableStaSum(paramMap);
	}
	@Override
	public List<StaModel> getEarlyWarnSum(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.getEarlyWarnSum(paramMap);
	}

	@Override
	public List<StaModel> getSignInSum(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.getSignInSum(paramMap);
	}
	@Override
	public List<StaModel> getYJSum(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.getYJSum(paramMap);
	}
	@Override
	public List<StaModel> getQSSum(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.getQSSum(paramMap);
	}

	
}
