package com.cist.alarm.logquery.service.impl;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cist.alarm.logquery.mapper.LogMapper;
import com.cist.alarm.logquery.service.LogService;
import com.cist.frame.page.PageInfo;
@Service
public class LogServiceImpl implements LogService {
@Autowired 
private LogMapper mapper;
	@Override
	public Object selectDatapageList(HashMap<String, Object> map,PageInfo page) {
		return mapper.selectData(map);
	}
	@Override
	public Integer deleteAll(String[] pk) {
		return mapper.deleteAll(pk);
	}
	@Override
	public Integer deleteOne(Integer pk) {
		return mapper.deleteOne(pk);
	}

}
