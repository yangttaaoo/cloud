package com.cist.alarm.config.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.alarm.config.mapper.ConfigMapper;
import com.cist.alarm.config.model.AlarmConfig;
import com.cist.alarm.config.service.ConfigService;
@Service
public class ConfigServiceImpl implements ConfigService {
@Autowired
private ConfigMapper mapper;
	@Override
	public Integer addData(HashMap<String, Object> map) {
		return mapper.addData(map);
	}
	@Override
	public List<AlarmConfig> selectData() {
		return mapper.selectData();
	}

}
