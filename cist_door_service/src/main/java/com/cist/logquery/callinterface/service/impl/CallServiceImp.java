package com.cist.logquery.callinterface.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cist.frame.page.PageInfo;
import com.cist.logquery.callinterface.mapper.CallMapper;
import com.cist.logquery.callinterface.model.CallType;
import com.cist.logquery.callinterface.service.CallService;
@Service
public class CallServiceImp implements CallService {
	@Autowired
   private CallMapper mapper;
	@Override
	public Object selecteAllpageList(HashMap<String, Object> map, PageInfo page) {
		return mapper.selecteAll(map);
	}
	@Override
	public Integer deleteAll(String[] pk) {

		return mapper.deleteAll(pk);
	}
	@Override
	public Integer deleteOne(Integer te) {
		return mapper.deleteOne(te);
	}
	@Override
	public List<CallType> selecteType() {
		return mapper.selecteType();
	}
}
