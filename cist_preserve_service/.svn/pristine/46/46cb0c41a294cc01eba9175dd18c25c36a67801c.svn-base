package com.cist.workorderstats.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cist.workorderstats.mapper.WorkOrderStatsMapper;
import com.cist.workorderstats.model.JtywJobOrderInfo;
import com.cist.workorderstats.service.WorkOrderStatsService;


@Service
public class WorkOrderStatsServiceImpl implements WorkOrderStatsService  {
	@Autowired
	private WorkOrderStatsMapper mapper;

	@Override
	public JtywJobOrderInfo selectCount(HashMap<String,Object> map) {
		return mapper.selectCount(map);
	}

	@Override
	public List<JtywJobOrderInfo> selectCompany(HashMap<String,Object> map) {
		return mapper.selectCompany(map);
	}

	@Override
	public List<JtywJobOrderInfo> selectPercent(HashMap<String, Object> map) {
		return mapper.selectPercent(map);
	}

	@Override
	public JtywJobOrderInfo selectAvgMonth(HashMap<String, Object> map) {
		return mapper.selectAvgMonth(map);
	}

	@Override
	public JtywJobOrderInfo selectAvgday(HashMap<String, Object> map) {
		return mapper.selectAvgday(map);
	}


}
