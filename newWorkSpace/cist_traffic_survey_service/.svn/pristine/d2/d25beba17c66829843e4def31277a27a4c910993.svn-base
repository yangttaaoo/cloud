package com.cist.roadsection.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cist.frame.page.PageInfo;
import com.cist.roadsection.mapper.RoadSectionMapper;
import com.cist.roadsection.model.CKreisCode;
import com.cist.roadsection.model.DeptInfo;
import com.cist.roadsection.model.SysDepartInfo;
import com.cist.roadsection.model.Sys_frm_code;
import com.cist.roadsection.service.RoadSectionService;

@Service
public class RoadSectionServiceImpl implements RoadSectionService {
	@Autowired
	private RoadSectionMapper mapper;

	@Override
	public Object listpageList(HashMap<String, Object> map, PageInfo p) {
		return mapper.list(map);
	}

	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Override
	public Integer delete(HashMap<String, Object> map) {
		return mapper.delete(map);
	}

	@Override
	public List<CKreisCode> kreis(Map<String, Object> map) {
		return mapper.kreis(map);
	}

	@Override
	public List<Sys_frm_code> selectSysFrmCode(String fct_code) {
		return mapper.selectSysFrmCode(fct_code);
	}

	@Override
	public List<CKreisCode> kreisList(Integer bigDecimal) {
		return mapper.kreisList(bigDecimal);
	}

	@Override
	public Integer save(Map<String, Object> map) {
		return mapper.save(map);
	}

	@Override
	public Integer update(Map<String, Object> map) {
		return mapper.update(map);
	}

	@Override
	public CKreisCode selectKreis(HashMap<String, Object> map) {
		return mapper.selectKreis(map);
	}

	@Override
	public SysDepartInfo selectDept(HashMap<String, Object> map) {
		return mapper.selectDept(map);
	}

	@Override
	public Sys_frm_code selectLjlx(HashMap<String, Object> map) {
		return mapper.selectLjlx(map);
	}

	@Override
	public Integer getroimcode(HashMap<String, Object> map) {
		return mapper.getroimcode(map);
	}



}
