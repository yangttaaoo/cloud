package com.cist.audit.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.audit.mapper.AuditMapper;
import com.cist.audit.model.DeviceGroup;
import com.cist.audit.model.OffeInfo;
import com.cist.audit.model.PoliceInfo;
import com.cist.audit.service.AuditService;
import com.cist.device.model.DeptInfo;

@Service("AuditService")
public class AuditServiceImpl implements AuditService{
	
	@Autowired
	private AuditMapper mapper;

	@Override
	public List<PoliceInfo> querypol() {
		return mapper.querypol();
	}

	@Override
	public List<OffeInfo> querywfxw() {
		return mapper.querywfxw();
	}

	@Override
	public List<PoliceInfo> querv() {
		return mapper.querv();
	}

	@Override
	public int editaudit(HashMap<String, Object> map) {
		return mapper.editaudit(map);
	}

	@Override
	public int addaudie(HashMap<String, Object> map) {
		return mapper.addaudie(map);
	}

	@Override
	public List<PoliceInfo> polgroud(Integer dept_superior) {
		return mapper.polgroud(dept_superior);
	}

	@Override
	public List<PoliceInfo> usergroud(Integer dept_superior) {
		return mapper.usergroud(dept_superior);
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
	public List<DeptInfo> Device(String tbmp_id) {
		return mapper.Device(tbmp_id);
	}

	@Override
	public List<DeptInfo> azdw(String tbmp_dept_code) {
		return mapper.azdw(tbmp_dept_code);
	}

	@Override
	public List<DeviceGroup> querygoulist() {
		return mapper.querygoulist();
	}

	@Override
	public List<DeviceGroup> queryusergroud(String tbvg_pk) {
		return mapper.queryusergroud(tbvg_pk);
	}

	@Override
	public DeviceGroup querydept(String dvc_pk) {
		return mapper.querydept(dvc_pk);
	}

	@Override
	public int addgroup(HashMap<String, Object> map) {
		return mapper.addgroup(map);
	}

	@Override
	public int delPol(HashMap<String, Object> map) {
		return mapper.delPol(map);
	}

	@Override
	public int delUserGroud(HashMap<String, Object> map) {
		return mapper.delUserGroud(map);
	}

	@Override
	public int addUserGroud(HashMap<String, Object> map) {
		return mapper.addUserGroud(map);
	}

	@Override
	public int addPolGroud(HashMap<String, Object> map) {
		return mapper.addPolGroud(map);
	}

	@Override
	public int addauthority(HashMap<String, Object> map) {
		return mapper.addauthority(map);
	}

	@Override
	public int delgoulist(HashMap<String, Object> map) {
		return mapper.delgoulist(map);
	}

	@Override
	public List<DeviceGroup> querysbsl() {
		return mapper.querysbsl();
	}

	@Override
	public int deldve() {
		return mapper.deldve();
	}

	@Override
	public PoliceInfo querytbvg(String sypi_pk) {
		return mapper.querytbvg(sypi_pk);
	}

	@Override
	public List<PoliceInfo> querywsb() {
		return mapper.querywsb();
	}
	/**
	 * 复审权限配置
	 */

	@Override
	public List<PoliceInfo> querypol2() {
		return mapper.querypol2();
	}

	@Override
	public List<DeviceGroup> querysbsl2() {
		return mapper.querysbsl2();
	}

	@Override
	public List<PoliceInfo> querywsb2() {
		return mapper.querywsb2();
	}

	@Override
	public List<PoliceInfo> querv2() {
		return mapper.querv2();
	}

	@Override
	public PoliceInfo querytbvg2(String sypi_pk) {
		return mapper.querytbvg2(sypi_pk);
	}

	@Override
	public int addauthority2(HashMap<String, Object> map) {
		return mapper.addauthority2(map);
	}

	@Override
	public int editaudit2(HashMap<String, Object> map) {
		return mapper.editaudit2(map);
	}

	@Override
	public int addaudie2(HashMap<String, Object> map) {
		return mapper.addaudie2(map);
	}

	@Override
	public List<DeviceGroup> querygoulist2() {
		return mapper.querygoulist2();
	}

	@Override
	public int addgroup2(HashMap<String, Object> map) {
		return mapper.addgroup2(map);
	}
}
