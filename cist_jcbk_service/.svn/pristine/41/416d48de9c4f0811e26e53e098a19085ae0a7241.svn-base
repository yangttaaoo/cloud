package com.cist.businessconfig.bayonetmanage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.businessconfig.bayonetmanage.mapper.BayonetManageMapper;
import com.cist.businessconfig.bayonetmanage.model.BayonetTree;
import com.cist.businessconfig.bayonetmanage.model.DeptInfo;
import com.cist.businessconfig.bayonetmanage.model.Jcbk_bayonet_units;
import com.cist.businessconfig.bayonetmanage.model.Jcbk_control_bayonet;
import com.cist.businessconfig.bayonetmanage.model.Jcsj_device;
import com.cist.businessconfig.bayonetmanage.model.Jcsj_device_bayonet_param;
import com.cist.businessconfig.bayonetmanage.service.BayonetManageService;
import com.cist.frame.page.PageInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class BayonetManageServiceImpl implements BayonetManageService {

	@Autowired
	private BayonetManageMapper mapper;

	@Override
	public List<BayonetTree> getDeptNode() {
		return mapper.getDeptNode();
	}

	@Override
	public List<BayonetTree> getBayonetNode(String deptId) {
		return mapper.getBayonetNode(deptId);
	}

	@Override
	public List<BayonetTree> getNatureNode(String deviceid) {
		return mapper.getNatureNode(deviceid);
	}

	@Override
	public Jcsj_device querydevicebypkid(HashMap<String,Object> map) {
		return mapper.querydevicebypkid(map);
	}

	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Override
	public Jcsj_device_bayonet_param querykkinfo(String device_id) {
		return mapper.querykkinfo(device_id);
	}

	@Override
	public Object querybayonetinfopageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.querybayonetinfo(map);
	}

	@Override
	public List<Jcbk_control_bayonet> querybayonetinfo(HashMap<String, Object> map) {
		return mapper.querybayonetinfo(map);
	}

	@Override
	public Integer addcarbayonet(HashMap<String, Object> map) {
		return mapper.addcarbayonet(map);
	}

	@Override
	public Integer addbayonetunits(HashMap<String, Object> map) {
		return mapper.addbayonetunits(map);
	}

	@Override
	public Jcbk_control_bayonet isshow(HashMap<String,Object> map) {
		return mapper.isshow(map);
	}

	@Override
	public List<Jcbk_bayonet_units> querybayonetunitsinfo(HashMap<String, Object> map) {
		return mapper.querybayonetunitsinfo(map);
	}

	@Override
	public Integer delJcbk_control_bayonet(HashMap<String, Object> map) {
		return mapper.delJcbk_control_bayonet(map);
	}

	@Override
	public Integer delJcbk_bayonet_units(HashMap<String, Object> map) {
		return mapper.delJcbk_bayonet_units(map);
	}

	@Override
	public Integer updatebayonet(HashMap<String, Object> map) {
		return mapper.updatebayonet(map);
	}
	
	
	
}
