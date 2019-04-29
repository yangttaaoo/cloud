package com.cist.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cist.user.mapper.FirstMapper;
import com.cist.user.model.PlateColor;
import com.cist.user.service.FirstService;

@Service
public class FirstServiceImpl implements FirstService  {

	@Autowired
	private FirstMapper mapper;


	public Object querylistpageList() {
		List<PlateColor> list =  mapper.querylist();
		return list;
	}

}
