package com.cist.inspectiontalk.service.Impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.inspectiontalk.mapper.InspectionTalkMapper;
import com.cist.inspectiontalk.service.InspectionTalkService;

@Service("InspectionTalkService")
public class InspectionTalkServiceImpl implements InspectionTalkService{
	@Autowired
	private InspectionTalkMapper mapper;

	@Override
	public Object instalkpageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.instalkpageList(map);
	}

	@Override
	public int talkqr(HashMap<String, Object> map) {
		return mapper.talkqr(map);
	}

	@Override
	public int talking(HashMap<String, Object> map) {
		return mapper.talking(map);
	}

	@Override
	public String quebgr(Integer id) {
		return mapper.quebgr(id);
	}

}
