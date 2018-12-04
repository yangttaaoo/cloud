package com.cist.redlist.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.model.SysDepartInfo;
import com.cist.redlist.mapper.RedListMapper;
import com.cist.redlist.model.CarColorInfo;
import com.cist.redlist.model.CarTypeInfo;
import com.cist.redlist.model.DeptInfo;
import com.cist.redlist.model.RedListInfo;
import com.cist.redlist.service.RedListService;

@Service("RedListService")
public class RedListServiceImpl implements RedListService{

	@Autowired
	private RedListMapper mapper;
	
	@Override
	public List<RedListInfo> plateTypeList() {
		return mapper.plateTypeList();
	}

	@Override
	public List<RedListInfo> carTypeList() {
		return mapper.carTypeList();
	}

	@Override
	public List<RedListInfo> carColorList() {
		return mapper.carColorList();
	}

	@Override
	public Object redInfopageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.redInfopageList(map);
	}

	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Override
	public List<RedListInfo> carLogoList() {
		return mapper.carLogoList();
	}

	@Override
	public List<RedListInfo> plateColorList() {
		return mapper.plateColorList();
	}

	@Override
	public List<RedListInfo> plateKerisList() {
		return mapper.plateKerisList();
	}

	@Override
	public int addRedInfo(HashMap<String, Object> map) {
		return mapper.addRedInfo(map);
	}

	@Override
	public CarTypeInfo selectByCllx(HashMap<String, Object> map) {
		return mapper.selectByCllx(map);
	}

	@Override
	public CarColorInfo selectByCsys(HashMap<String, Object> map) {
		return mapper.selectByCsys(map);
	}

	@Override
	public SysDepartInfo selectBySsdw(HashMap<String, Object> map) {
		return mapper.selectBySsdw(map);
	}

	@Override
	public int delRedInfo(HashMap<String, Object> map) {
		return mapper.delRedInfo(map);
	}

	@Override
	public RedListInfo OneRedInfo(HashMap<String, Object> map) {
		return mapper.OneRedInfo(map);
	}

	@Override
	public int editRedInfo(HashMap<String, Object> map) {
		return mapper.editRedInfo(map);
	}
}
