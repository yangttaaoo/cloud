package com.cist.khpd.resultback.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cist.frame.page.PageInfo;
import com.cist.khpd.resultback.mapper.ResultMapper;
import com.cist.khpd.resultback.service.ResultService;
import com.cist.khpd.resultback.model.Police;
@Service
public class ResultServiceImpl implements ResultService {
@Autowired
private ResultMapper mapper;
	@Override
	public Object selectDatapageList(HashMap<String, Object> map, PageInfo page) {
		return mapper.selectData(map);
	}
	@Override
	public Integer addData(HashMap<String, Object> map) {
		return mapper.addData(map);
	}
	@Override
	public Integer deleteData(HashMap<String, Object> map) {
		return mapper.deleteData(map);
	}
	@Override
	public Integer updateData(HashMap<String, Object> map) {
		return mapper.updateData(map);
	}
	@Override
	public Integer replyUser(HashMap<String, Object> map) {
		return mapper.replyUser(map);
	}
	@Override
	public Integer addPersonData(HashMap<String, Object> map) {
		return mapper.addPersonData(map);
	}
	@Override
	public Police selectPerson(String sypi_pk) {
		return mapper.selectPerson(sypi_pk);
	}
   
}
