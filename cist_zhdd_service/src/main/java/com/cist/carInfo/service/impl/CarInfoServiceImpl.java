package com.cist.carInfo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cist.carInfo.mapper.CarInfoMapper;
import com.cist.carInfo.model.CKreisCode;
import com.cist.carInfo.model.DeptInfo;
import com.cist.carInfo.model.Sys_frm_code;
import com.cist.carInfo.service.CarInfoService;
import com.cist.frame.page.PageInfo;

@Service
public class CarInfoServiceImpl implements CarInfoService  {
	@Autowired
	private CarInfoMapper mapper;

	@Override
	public Integer delete(HashMap<String, Object> map) {
		return mapper.delete(map);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public Integer save(HashMap<String, Object> map) {
		Integer save = mapper.save(map);
		mapper.saveCompany(map);//所属公司插入
		mapper.saveDrivers(map);//驾驶人信息插入
		return save;
	}

	@Override
	public Object listpageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.list(map);
	}

	@Override
	public Integer update(HashMap<String, Object> map) {
		return mapper.update(map);
	}

	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Override
	public List<CKreisCode> kreis(Map<String, Object> map) {
		return mapper.kreis(map);
	}

	@Override
	public List<CKreisCode> kreisList(Integer bigDecimal) {
		return mapper.kreisList(bigDecimal);
	}

	@Override
	public List<Sys_frm_code> selectSysFrmCode(String fct_code) {
		return mapper.selectSysFrmCode(fct_code);
	}

	@Override
	public Object selectCompanypageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.selectCompany(map);
	}

}
