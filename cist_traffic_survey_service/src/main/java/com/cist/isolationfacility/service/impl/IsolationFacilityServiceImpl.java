package com.cist.isolationfacility.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.isolationfacility.mapper.IsolationFacilityMapper;
import com.cist.isolationfacility.model.Jcsj_barrier_facilities;
import com.cist.isolationfacility.service.IsolationFacilityService;
@Service
public class IsolationFacilityServiceImpl implements IsolationFacilityService {
	@Autowired
	private IsolationFacilityMapper mapper;

	@Override
	public Integer insertJcsj_barrier_facilities(Map<String, Object> map) {
		return mapper.insertJcsj_barrier_facilities(map);
	}

	@Override
	public List<Jcsj_barrier_facilities> queryJcsj_barrier_facilities(HashMap<String, Object> map) {
		return mapper.SecurityByglbmTocode(map);
	}

	@Override
	public Object queryJcsj_barrier_facilitiespageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.SecurityByglbmTocode(map);
	}

	@Override
	public Integer updateJcsj_barrier_facilities(Map<String, Object> map) {
		return mapper.updateJcsj_barrier_facilities(map);
	}

	@Override
	public Integer deleteJcsj_barrier_facilities(HashMap<String, Object> map) {
		return mapper.deleteJcsj_barrier_facilities(map);
	}
}
