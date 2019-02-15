package com.cist.inspectionexamine.service.Impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.inspectionexamine.mapper.InspectionExamineMapper;
import com.cist.inspectionexamine.model.Device;
import com.cist.inspectionexamine.model.Maintenance;
import com.cist.inspectionexamine.service.InspectionExamineService;
import com.cist.inspectionplan.model.MaintenanceInfo;
@Service("InspectionExamineService")
public class InspectionExamineServiceImpl implements InspectionExamineService{
	
	@Autowired
	private InspectionExamineMapper mapper;
	
	@Override
	public Object insexapageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.insexapageList(map);
	}

	@Override
	public List<Maintenance> quemaint(HashMap<String,Object> map) {
		return mapper.quemaint(map);
	}

	@Override
	public List<Device> querydev(HashMap<String, Object> map) {
		return mapper.querydev(map);
	}

	@Override
	public int insexa(HashMap<String, Object> map) {
		return mapper.insexa(map);
	}

}
