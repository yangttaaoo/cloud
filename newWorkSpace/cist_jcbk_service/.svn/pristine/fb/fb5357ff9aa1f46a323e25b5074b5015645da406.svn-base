package com.cist.warningmanagement.controlcar.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.warningmanagement.bayonet.model.DeptInfo;
import com.cist.warningmanagement.bayonet.model.Qylx;
import com.cist.warningmanagement.controlcar.mapper.CarMapper;
import com.cist.warningmanagement.controlcar.model.Kklx;
import com.cist.warningmanagement.controlcar.model.Police;
import com.cist.warningmanagement.controlcar.model.Sys_frm_code;
import com.cist.warningmanagement.controlcar.model.Tbl_control_vehicle;
import com.cist.warningmanagement.controlcar.service.CarService;
@Service
public class CarServiceImpl implements CarService {
@Autowired
private CarMapper mapper;
	@Override
	public Object selectAllpageList(HashMap<String, Object> map, PageInfo page) {
		return mapper.selectAll(map);
	}
	@Override
	public List<Sys_frm_code> selectHpzl(HashMap<String, Object> map) {
		return mapper.selectHpzl(map);
	}
	@Override
	public List<Sys_frm_code> selectCsys(HashMap<String, Object> map) {
		return mapper.selectCsys(map);
	}
	@Override
	public List<Sys_frm_code> selectCllx(HashMap<String, Object> map) {
		return mapper.selectCllx(map);
	}
	@Override
	public Integer deleteData(HashMap<String, Object> map) {
		return mapper.deleteData(map);
	}
	@Override
	public Integer addData(HashMap<String, Object> map) {
		return mapper.addData(map);
	}
	@Override
	public Integer updateData(HashMap<String, Object> map) {
		return mapper.updateData(map);
	}
	@Override
	public List<Sys_frm_code> selectClpp(HashMap<String, Object> map) {
		return mapper.selectClpp(map);
	}
	@Override
	public Sys_frm_code selectName(HashMap<String, Object> map) {
		return mapper.selectName(map);
	}
	@Override
	public Integer deleteAll(String[] pk) {
		return mapper.deleteAll(pk);
	}
	@Override
	public List<Kklx> selectKklx(HashMap<String, Object> map) {
		return mapper.selectKklx(map);
	}
	@Override
	public DeptInfo selectDepat(HashMap<String, Object> map) {
		return mapper.selectDepat(map);
	}
	@Override
	public Tbl_control_vehicle selectHphm(HashMap<String, Object> map) {
		return mapper.selectHphm(map);
	}
	@Override
	public Qylx selectQy(HashMap<String, Object> map) {
		return mapper.selectQy(map);
	}
	@Override
	public Police selectPolice(HashMap<String, Object> map) {
		return mapper.selectPolice(map);
	}
}
