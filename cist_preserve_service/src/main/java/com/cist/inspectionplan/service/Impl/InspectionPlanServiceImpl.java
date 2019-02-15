package com.cist.inspectionplan.service.Impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.inspectionplan.mapper.InspectionPlanMapper;
import com.cist.inspectionplan.model.DeviceInfo;
import com.cist.inspectionplan.model.MaintenanceInfo;
import com.cist.inspectionplan.model.RoadInfo;
import com.cist.inspectionplan.model.UserInfo;
import com.cist.inspectionplan.service.InspectionPlanService;

@Service("InspectionPlanService")
public class InspectionPlanServiceImpl implements InspectionPlanService{

	@Autowired
	private InspectionPlanMapper mapper;
	
	@Override
	public Object inslistpageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.inslistpageList(map);
	}

	@Override
	public List<MaintenanceInfo> maintservice() {
		return mapper.maintservice();
	}

	@Override
	public List<RoadInfo> roadservice() {
		return mapper.roadservice();
	}
	@Override
	public Object devicelistpageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.devicelistpageList(map);
	}

	@Override
	public int insadd(HashMap<String, Object> map) {
		return mapper.insadd(map);
	}

	@Override
	public int gsadd(HashMap<String, Object> map) {
		return mapper.gsadd(map);
	}

	@Override
	public int sbadd(HashMap<String, Object> map) {
		return mapper.sbadd(map);
	}

	@Override
	public List<MaintenanceInfo> quemaint(int pk_id) {
		return mapper.quemaint(pk_id);
	}

	@Override
	public List<DeviceInfo> quedev(int pk_id) {
		return mapper.quedev(pk_id);
	}

	@Override
	public UserInfo queuser(int pk) {
		return mapper.queuser(pk);
	}

	@Override
	public int insedit(HashMap<String, Object> map) {
		return mapper.insedit(map);
	}

	@Override
	public int delgs(HashMap<String, Object> map) {
		return mapper.delgs(map);
	}

	@Override
	public int delsb(HashMap<String, Object> map) {
		return mapper.delsb(map);
	}

	@Override
	public int delIns(HashMap<String, Object> map) {
		return mapper.delIns(map);
	}

	@Override
	public int delInsmax(HashMap<String, Object> modelMap) {
		return mapper.delInsmax(modelMap);
	}

	@Override
	public int delgsmax(HashMap<String, Object> modelMap) {
		return mapper.delgsmax(modelMap);
	}

	@Override
	public int delsbmax(HashMap<String, Object> modelMap) {
		return mapper.delsbmax(modelMap);
	}
}
