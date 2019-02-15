package com.cist.logquery.bizoperate.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.logquery.bizoperate.mapper.BizMapper;
import com.cist.logquery.bizoperate.service.BizService;
@Service
public class BizServiceImpl implements BizService{
@Autowired
private BizMapper  mapper;
	@Override
	public Object selectBizpageList(HashMap<String, Object> map, PageInfo page) {
		return mapper.selectBiz(map);
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
