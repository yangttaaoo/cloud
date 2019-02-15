package com.cist.assetstatis.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.assetstatis.mapper.AssetStatisMapper;
import com.cist.assetstatis.model.JksbzcInfo;
import com.cist.assetstatis.service.AssetStatisService;

import java.util.HashMap;
import java.util.List;


@Service("assetstatis")
public class AssetStatisServiceImpl implements AssetStatisService{

	@Autowired
	private AssetStatisMapper mapper;
	
	@Override
	public List<JksbzcInfo> devtotal() {
		return mapper.devtotal();
	}

	@Override
	public List<JksbzcInfo> typeinfo(HashMap<String, Object> modelMap) {
		return mapper.typeinfo(modelMap);
	}

	@Override
	public List<JksbzcInfo> dateinfo(HashMap<String, Object> modelMap) {
		return mapper.dateinfo(modelMap);
	}

	@Override
	public List<JksbzcInfo> dateinfo1(HashMap<String, Object> modelMap) {
		return mapper.dateinfo1(modelMap);
	}
	@Override
	public List<JksbzcInfo> dateinfo2(HashMap<String, Object> modelMap) {
		return mapper.dateinfo2(modelMap);
	}
	@Override
	public List<JksbzcInfo> dateinfo3(HashMap<String, Object> modelMap) {
		return mapper.dateinfo3(modelMap);
	}

	@Override
	public List<JksbzcInfo> dateinfo4(HashMap<String, Object> modelMap) {
		return mapper.dateinfo4(modelMap);
	}
}
