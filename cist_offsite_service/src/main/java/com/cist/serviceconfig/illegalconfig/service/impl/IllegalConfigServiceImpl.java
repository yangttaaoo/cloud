package com.cist.serviceconfig.illegalconfig.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.recheck.model.TblOffeCateInfo;
import com.cist.serviceconfig.illegalconfig.mapper.IllegalConfigMapper;
import com.cist.serviceconfig.illegalconfig.service.IllegalConfigService;

@Service
public class IllegalConfigServiceImpl implements IllegalConfigService{
		
	@Autowired
	private IllegalConfigMapper mapper;

	public Object selectNameCodepageList(Map<String, Object> map, PageInfo info) {
		return mapper.selectNameCode(map);
	}

	public List<TblOffeCateInfo> selectAll() {
		return mapper.selectAll();
	}

	public Integer updateWfxw(HashMap<String, Object> map) {
		return mapper.updateWfxw(map);
	}

	public Integer insertWfxw(HashMap<String, Object> map) {
		return mapper.insertWfxw(map);
	}

	public Integer deleteWfxw(HashMap<String, Object> map) {
		return mapper.deleteWfxw(map);
	}

	@Override
	public List<TblOffeCateInfo> queryForm(HashMap<String, Object> map) {
		return mapper.queryForm(map);
	}

	public TblOffeCateInfo verifyCode(HashMap<String,Object> map) {
		return mapper.verifyCode(map);
	}

	public Integer deleteAll(String[] pk) {
		return mapper.deleteAll(pk);
	}

	@Override
	public Integer selectCode(HashMap<String, Object> map) {
		return mapper.selectCode(map);
	}





	

	
}
