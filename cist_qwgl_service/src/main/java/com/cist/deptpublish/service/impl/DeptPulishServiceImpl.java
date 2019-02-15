package com.cist.deptpublish.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.deptpublish.mapper.DeptPulishMapper;
import com.cist.deptpublish.service.DeptPulishService;
import com.cist.frame.page.PageInfo;
import com.cist.qwkhgrfb.model.Publish;
@Service
public class DeptPulishServiceImpl implements DeptPulishService{
	@Autowired
	private DeptPulishMapper dMapper;
	
	@Override
	public Object selectDeptPubpageList(HashMap<String, Object> map, PageInfo pInfo) {
		return dMapper.selectDeptPub(map);
	}

	@Override
	public List<Publish> downloadList(HashMap<String, Object> map) {
		return dMapper.downloadList(map);
	}

}
