package com.cist.reviewthrough.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.reviewthrough.mapper.ReviewThroughMapper;
import com.cist.reviewthrough.model.Creason;
import com.cist.reviewthrough.service.ReviewThroughService;

@Service("ReviewThroughService")
public class ReviewThroughServiceImpl implements ReviewThroughService{
	
	@Autowired
	private ReviewThroughMapper mapper;
	
	@Override
	public Object reviewThroughpageList(HashMap<String, Object> map, PageInfo p) {
		return mapper.reviewThroughpageList(map);
	}

	@Override
	public Integer updateByWfpk(HashMap<String, Object> map) {
		return mapper.updateByWfpk(map);
	}

	@Override
	public List<Creason> selectByCReasonInfo() {
		return mapper.selectByCReasonInfo();
	}
	
}
