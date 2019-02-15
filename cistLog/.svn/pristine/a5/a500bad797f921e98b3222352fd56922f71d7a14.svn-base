package com.cist.log.logService.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.log.logService.LogService;
import com.cist.log.mapper.LogMapper;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogMapper mapper;
	public void insertLoginLog(Map<String, Object> map) {
		mapper.insertLoginLog(map);
	}

	public void insertOperLog(Map<String, Object> map) {
		mapper.insertOperLog(map);
	}

}
