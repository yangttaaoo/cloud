package com.cist.holidays.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.holidays.mapper.HolidaysMapper;
import com.cist.holidays.service.HolidaysService;

@Service
public class HolidaysServiceImpl implements HolidaysService {
	@Autowired
	private HolidaysMapper mapper;

	public Object querypageList(HashMap<String, Object> paramMap, PageInfo pageInfo) {
		// TODO Auto-generated method stub
		return mapper.queryList(paramMap);
	}

	public int insert(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.insert(paramMap);
	}

	public int update(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return  mapper.update(paramMap);
	}

	public int delete(List<Object> paramList) {
		// TODO Auto-generated method stub
		return mapper.delete(paramList);
	}

	
	
}
