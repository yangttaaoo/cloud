package com.cist.personalexamine.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.personalexamine.mapper.PersonalExemineMapper;
import com.cist.personalexamine.service.PersonalExemineService;

@Service("PersonalExemineService")
public class PersonalExemineServiceImpl implements PersonalExemineService{

	@Autowired
	private PersonalExemineMapper mapper;
	
	@Override
	public Object ExamineInfopageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.ExamineInfopageList(map);
	}

	@Override
	public String getTopice(String a) {
		// TODO Auto-generated method stub
		return mapper.getTopice(a);
	}

	@Override
	public String getRegulations(String a) {
		// TODO Auto-generated method stub
		return mapper.getRegulations(a);
	}

	@Override
	public int examinepersonal(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.examinepersonal(map);
	}

	@Override
	public String getReport(String a) {
		// TODO Auto-generated method stub
		return mapper.getReport(a);
	}

}
