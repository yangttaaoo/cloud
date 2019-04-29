package com.cist.device.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cist.device.mapper.DeviceMapper;
import com.cist.device.model.DeptInfo;
import com.cist.device.model.PoliceInfo;
import com.cist.device.model.Sys_device_grouping;
import com.cist.device.service.DeviceService;
import com.cist.frame.page.PageInfo;

@Service("DeviceService")
public class DeviceServiceImpl implements DeviceService{
	
	@Autowired
	private DeviceMapper mapper;
	@Override
	public List<Sys_device_grouping> querylist() {
		return mapper.querylist();
	}
	@Override
	public Object querypolpageList(HashMap<String, Object> map,PageInfo p) {
		return mapper.querypolpageList(map);
	}
	@Override
	public Sys_device_grouping querydept(String groud_dev) {
		return mapper.querydept(groud_dev);
	}
	@Override
	public List<Sys_device_grouping> querydev() {
		return mapper.querydev();
	}
	@Override
	public List<Sys_device_grouping> querypolice() {
		return mapper.querypolice();
	}
	@Transactional(rollbackFor=Exception.class)
	@Override
	public int addDevInfo(HashMap<String,Object> map) {
		return mapper.addDevInfo(map);
	}
	@Transactional(rollbackFor=Exception.class)
	@Override
	public int addDevGroud(HashMap<String,Object> map) {
		return mapper.addDevGroud(map);
	}
	@Override
	public Sys_device_grouping querydeptpol(HashMap<String,Object> map) {
		return mapper.querydevpol(map);
	}
	@Override
	public Sys_device_grouping querydevicegro(HashMap<String, Object> map) {
		return mapper.querydevicegro(map);
	}
	@Transactional(rollbackFor=Exception.class)
	@Override
	public int delPol(HashMap<String, Object> map) {
		return mapper.delPol(map);
	}
	@Transactional(rollbackFor=Exception.class)
	@Override
	public int delUserGroud(HashMap<String, Object> map) {
		return mapper.delUserGroud(map);
	}
	@Transactional(rollbackFor=Exception.class)
	@Override
	public int addPolGroud(HashMap<String, Object> map) {
		return mapper.addPolGroud(map);
	}
	@Transactional(rollbackFor=Exception.class)
	@Override
	public int addUserGroud(HashMap<String, Object> map) {
		return mapper.addUserGroud(map);
	}
	@Override
	public List<Sys_device_grouping> querypolgroud(String sypi_code) {
		return mapper.querypolgroud(sypi_code);
	}
	@Override
	public List<Sys_device_grouping> queryusergroud(String sypi_pk) {
		return mapper.queryusergroud(sypi_pk);
	}
	@Override
	public List<Sys_device_grouping> querydevgroud(String groud_code) {
		return mapper.querydevgroud(groud_code);
	}
	@Override
	public int delDev(HashMap<String, Object> map) {
		return mapper.delDev(map);
	}
	@Override
	public int editDev(HashMap<String, Object> map) {
		return mapper.editDev(map);
	}
	@Override
	public int delDevInfo(HashMap<String, Object> map) {
		return mapper.delDevInfo(map);
	}
	@Override
	public Sys_device_grouping querygroudcode(String groud_code) {
		return mapper.querygroudcode(groud_code);
	}
	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		
		return mapper.depart_infolist(dept_superior);
	}
	@Override
	public List<DeptInfo> Monitorpoint(String tbmp_dept_code) {
		return mapper.Monitorpoint(tbmp_dept_code);
	}
	@Override
	public List<Sys_device_grouping> querydeptlist() {
		return mapper.querydeptlist();
	}
	@Override
	public List<DeptInfo> Device(String tbmp_id) {
		return mapper.Device(tbmp_id);
	}
	@Override
	public List<PoliceInfo> police_infolist(Integer dept_superior) {
		
		return mapper.police_infolist(dept_superior);
	}
	@Override
	public List<PoliceInfo> Police(Integer dept_pk) {
		return mapper.Police(dept_pk);
	}
	@Override
	public int delpolall(List<String> list) {
		return mapper.delpolall(list);
	}
}
