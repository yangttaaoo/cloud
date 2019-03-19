package com.cist.warningmanagement.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.devmanagement.model.SssbEquipmentRegister;
import com.cist.frame.page.PageInfo;
import com.cist.warningmanagement.mapper.WarningManagementMapper;
import com.cist.warningmanagement.service.WarningManagementService;

@Service(value = "WarningManagementService")
public class WarningManagementServiceImpl implements WarningManagementService {

	@Autowired
	private WarningManagementMapper mapper;

	@Override
	public Object listpageList(HashMap<String, Object> map, PageInfo p) {
		return mapper.list(map);
	}

	@Override
	public Integer deleteWarning(HashMap<String, Object> map) {
		return mapper.deleteWarning(map);
	}

	@Override
	public List<SssbEquipmentRegister> selectDev(HashMap<String, Object> map) {
		return mapper.selectByDev(map);
	}

	@Override
	public List<SssbEquipmentRegister> selectPc(HashMap<String, Object> map) {
		return mapper.selectByPc(map);
	}

	

}
