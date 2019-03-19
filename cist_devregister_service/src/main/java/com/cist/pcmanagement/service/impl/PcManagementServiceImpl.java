package com.cist.pcmanagement.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cist.devmanagement.mapper.DevManagementMapper;
import com.cist.devmanagement.model.DeptInfo;
import com.cist.devmanagement.model.Sys_frm_code;
import com.cist.devmanagement.service.DevManagementService;
import com.cist.frame.page.PageInfo;
import com.cist.pcmanagement.mapper.PcManagementMapper;
import com.cist.pcmanagement.service.PcManagementService;

@Service(value = "PcManagementService")
public class PcManagementServiceImpl implements PcManagementService {

	@Autowired
	private PcManagementMapper mapper;
	
	@Autowired
	private DevManagementMapper devMapper;



	@Override
	public Object pcListpageList(HashMap<String, Object> map, PageInfo p) {
		return mapper.pcList(map);
	}



	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public Integer addPc(HashMap<String, Object> map) {
		Integer addRegister = devMapper.addRegister(map);
		mapper.addPc(map);
		return addRegister;
	}



	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public Integer updatePC(HashMap<String, Object> map) {
		Integer updateRegister = devMapper.updateRegister(map);
		mapper.updatePC(map);
		return updateRegister;
	}



	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public Integer deletePc(HashMap<String, Object> map) {
		Integer deleteRegister = devMapper.deleteRegister(map);
		mapper.deletePc(map);
		return deleteRegister;
	}

}
