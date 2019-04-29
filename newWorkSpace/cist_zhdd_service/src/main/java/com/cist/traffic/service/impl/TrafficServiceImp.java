package com.cist.traffic.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.traffic.mapper.TrafficMapper;
import com.cist.traffic.model.Event;
import com.cist.traffic.model.Traffic;
import com.cist.traffic.service.TrafficService;
@Service
public class TrafficServiceImp implements TrafficService {
@Autowired
 private TrafficMapper mapper;
	@Override
	public Traffic selectOnpolice() {
		return 	mapper.selectOnpolice();
	}

	@Override
	public Traffic selectTodayTrafficNumber(HashMap<String,Object> map) {
		return mapper.selectTodayTrafficNumber(map);
	}

	@Override
	public Traffic selectNowTrafficNumber() {
		return mapper.selectNowTrafficNumber();
	}

	@Override
	public Traffic selectAvgTrafficNumber() {
		return mapper.selectAvgTrafficNumber();
	}

	@Override
	public Traffic selectSgzdToal(HashMap<String,Object> map) {
		return mapper.selectSgzdToal(map);
	}

	@Override
	public Traffic selectMondayTrafficNumber() {
		return mapper.selectMondayTrafficNumber();
	}

	@Override
	public List<Event> selectOneNumber() {
		return mapper.selectOneNumber();
	}

}
