package com.cist.redillegal.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.model.TblOffeEvdiInfo;
import com.cist.redillegal.mapper.RedIllegalMapper;
import com.cist.redillegal.service.RedIllegalService;

@Service("RedIllegalService")
public class RedIllegalServiceImpl implements RedIllegalService{
	@Autowired
	private RedIllegalMapper mapper;
	
	@Override
	public Object redIllegalpageList(HashMap<String, Object> map, PageInfo p) {
		return mapper.redIllegalpageList(map);
	}


}
