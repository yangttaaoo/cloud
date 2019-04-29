package com.cist.serviceconfig.unlimitedcar.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.cist.frame.page.PageInfo;
import com.cist.serviceconfig.unlimitedcar.mapper.UnlimitedCarMapper;
import com.cist.serviceconfig.unlimitedcar.model.CarManage;
import com.cist.serviceconfig.unlimitedcar.model.Didels;
import com.cist.serviceconfig.unlimitedcar.model.NoLimited;
import com.cist.serviceconfig.unlimitedcar.service.UnlimitedService;
@Service("unlimitedServiceImpl")
public class UnlimitedServiceImpl implements UnlimitedService{
    @Autowired
    private UnlimitedCarMapper mapper;
	@Override
	public Object selectNoCarpageList(HashMap<String, Object> map ,PageInfo page) {
		return mapper.selectNoCar(map);
	}
	@Override
	public Integer delectInfo(@RequestParam HashMap<String, Object> map) {
		return mapper.delectInfo(map);
	}

	@Override
	public Integer insertInfo(HashMap<String, Object> map) {
		return mapper.insertInfo(map);
	}

	@Override
	public Didels selectById(HashMap<String, Object> map) {
		return mapper.selectById(map);
	}

	@Override
	public Integer updateById(HashMap<String, Object> map) {
		return mapper.updateById(map);
	}
	@Override
	public Integer deleteAll(String[] pk) {
		return mapper.deleteAll(pk);
	}
	@Override
	public List<NoLimited> selectAll(HashMap<String, Object> map) {
		return mapper.selectAll(map);
	}

}
