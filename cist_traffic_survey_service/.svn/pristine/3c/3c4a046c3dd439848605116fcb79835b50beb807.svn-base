package com.cist.intervalVelocity.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.devRegister.model.Device;
import com.cist.frame.page.PageInfo;
import com.cist.intervalVelocity.mapper.IntervalVelocityMapper;
import com.cist.intervalVelocity.model.DevBaseInfo;
import com.cist.intervalVelocity.model.DevConnectBayonet;
import com.cist.intervalVelocity.model.IntervalVelocity;
import com.cist.intervalVelocity.service.IntervalVelocityService;
@Service
public class IntervalVelocityServiceImpl implements IntervalVelocityService {
	@Autowired
	private IntervalVelocityMapper mapper;

	@Override
	public Object queryKKpageList(HashMap<String, Object> paramMap, PageInfo pageInfo) {
		return mapper.getKKInfoList(paramMap);
	}

	@Override
	public int addIntervalParam(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.addIntervalParam(paramMap);
	}

	@Override
	public int addDevConnectBayonet(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.addDevConnectBayonet(paramMap);
	}

	@Override
	public Object querypageList(HashMap<String, Object> paramMap, PageInfo pageInfo) {
		// TODO Auto-generated method stub
		return mapper.queryList(paramMap);
	}

	@Override
	public List<Device> getCheckKKDevice(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.getCheckKKDevice(paramMap);
	}

	@Override
	public List<Integer> getDevConnectBayonet(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.getDevConnectBayonet(paramMap);
	}

	@Override
	public int delDevConnectBayonet(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.delDevConnectBayonet(paramMap);
	}

	@Override
	public int updateIntervalParam(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.updateIntervalParam(paramMap);
	}

	@Override
	public int deleteParam(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.deleteParam(paramMap);
	}

	@Override
	public int deleteConnect(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.deleteConnect(paramMap);
	}

	@Override
	public int delDevByQJCS(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.delDevByQJCS(paramMap);
	}

	@Override
	public Object queryDevicepageList(HashMap<String, Object> paramMap, PageInfo pageInfo) {
		// TODO Auto-generated method stub
		return mapper.queryDeviceList(paramMap);
	}

	@Override
	public IntervalVelocity queryDeviceById(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.queryDeviceById(paramMap);
	}

}
