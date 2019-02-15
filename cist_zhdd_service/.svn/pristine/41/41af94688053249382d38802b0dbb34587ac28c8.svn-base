package com.cist.specialTask.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cist.frame.page.PageInfo;
import com.cist.specialTask.mapper.SpecialTaskMapper;
import com.cist.specialTask.model.CRoadItemInfo;
import com.cist.specialTask.model.JcsjDeviceInfo;
import com.cist.specialTask.model.JcsjPoliceResPerson;
import com.cist.specialTask.model.JcsjPoliceResources;
import com.cist.specialTask.model.ZhddMissionGrade;
import com.cist.specialTask.model.ZhddMissionParticipant;
import com.cist.specialTask.model.ZhddMissionRoute;
import com.cist.specialTask.service.SpecialTaskService;

@Service
public class SpecialTaskServiceImpl implements SpecialTaskService {
	@Autowired
	private SpecialTaskMapper mapper;

	@Override
	public Object listpageList(HashMap<String, Object> map, PageInfo p) {
		return mapper.list(map);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public Integer delete(HashMap<String, Object> map) {
		Integer delete = mapper.delete(map);
		deleteParticipant(map);// 删除参与者
		deleteRoute(map);// 删除路线
		return delete;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public Integer update(HashMap<String, Object> map) {
		Integer update = mapper.update(map);
		mapper.deleteParticipant(map);
		mapper.deleteRoute(map);
		mapper.insertRoute(map);
		mapper.insertParticipant(map);
		return update;
	}

	@Override
	public List<ZhddMissionGrade> selectGrade(HashMap<String, Object> map) {
		return mapper.selectGrade(map);
	}

	@Override
	public List<JcsjPoliceResources> selectPoliceCar(HashMap<String, Object> map) {
		return mapper.selectPoliceCar(map);
	}

	@Override
	public List<JcsjPoliceResPerson> selectPolice(HashMap<String, Object> map) {
		return mapper.selectPolice(map);
	}

	@Override
	public Integer deleteRoute(HashMap<String, Object> map) {
		return mapper.deleteRoute(map);
	}

	@Override
	public Integer deleteParticipant(HashMap<String, Object> map) {
		return mapper.deleteParticipant(map);
	}

	@Override
	public List<ZhddMissionParticipant> selectParticipant(HashMap<String, Object> map) {
		return mapper.selectParticipant(map);
	}

	@Override
	public List<ZhddMissionRoute> selectRoute(HashMap<String, Object> map) {
		return mapper.selectRoute(map);
	}

	@Override
	public List<CRoadItemInfo> selectRoad(HashMap<String, Object> map) {
		return mapper.selectRoad(map);
	}

	@Override
	public List<JcsjDeviceInfo> selectDevice(HashMap<String, Object> map) {
		return mapper.selectDevice(map);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public Integer save(HashMap<String, Object> map) {
		Integer save = mapper.save(map);
		if (save > 0) {
			if (((ArrayList) map.get("lineList")).size() > 0) {
				mapper.insertRoute(map);// 特勤任务路线新增
			}
			if (((ArrayList) map.get("list")).size() > 0) {
				mapper.insertParticipant(map);// 特勤任务参与者新增
			}

		}
		return save;
	}

	@Override
	public List<JcsjPoliceResPerson> selecteParPolice(HashMap<String, Object> map) {
		return mapper.selecteParPolice(map);
	}

	@Override
	public List<JcsjPoliceResources> selecteParCar(HashMap<String, Object> map) {
		return mapper.selecteParCar(map);
	}

	@Override
	public List<JcsjDeviceInfo> selecteParDevice(HashMap<String, Object> map) {
		return mapper.selecteParDevice(map);
	}
}
