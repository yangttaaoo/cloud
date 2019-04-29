package com.cist.redrevoke.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.redlist.model.RedListInfo;
import com.cist.redrevoke.mapper.RedRevokeMapper;
import com.cist.redrevoke.service.RedRevokeService;

@Service("RedRevokeService")
public class RedRevokeServiceImpl implements RedRevokeService{
	@Autowired
	private RedRevokeMapper mapper;
	@Override
	public Object redRevokepageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.redRevokepageList(map);
	}
	@Override
	public RedListInfo OneRedInfo(HashMap<String, Object> map) {
		return mapper.OneRedInfo(map);
	}
	@Override
	public int revokeRedInfo(HashMap<String, Object> map) {
		return mapper.revokeRedInfo(map);
	}

}
