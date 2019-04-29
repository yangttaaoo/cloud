package com.cist.audit.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.audit.model.DeviceGroup;
import com.cist.audit.model.OffeInfo;
import com.cist.audit.model.PoliceInfo;
import com.cist.device.model.DeptInfo;

public interface AuditMapper {
	List<PoliceInfo> querypol();
	List<OffeInfo> querywfxw();
	List<PoliceInfo> querv();
	int editaudit(HashMap<String,Object> map);
	int addaudie(HashMap<String,Object> map);
	List<DeptInfo> depart_infolist(Integer dept_superior);
	List<DeptInfo> Monitorpoint(String tbmp_dept_code);
	List<DeptInfo> Device(String tbmp_id);
	List<DeptInfo> azdw(String tbmp_dept_code);
	List<DeviceGroup> querygoulist();
	List<DeviceGroup> queryusergroud(String tbvg_pk);
	DeviceGroup querydept(String dvc_pk);
	int addgroup(HashMap<String,Object> map);
	int delPol(HashMap<String,Object> map);
	int delUserGroud(HashMap<String,Object> map);
	int addUserGroud(HashMap<String,Object> map);
	int addPolGroud(HashMap<String,Object> map);
	int addauthority(HashMap<String,Object> map);
	List<PoliceInfo> polgroud(Integer dept_superior);
	List<PoliceInfo> usergroud(Integer dept_superior);
	int delgoulist(HashMap<String,Object> map);
	List<DeviceGroup> querysbsl();
	int deldve();
	PoliceInfo querytbvg(String sypi_pk);
	List<PoliceInfo> querywsb();
	/**
	 * 复审权限配置
	 */
	 List<PoliceInfo> querypol2();
	 List<PoliceInfo> querywsb2();
	 List<DeviceGroup> querysbsl2();
	 List<PoliceInfo> querv2();
	 PoliceInfo querytbvg2(String sypi_pk);
	 int addauthority2(HashMap<String,Object> map);
	 int editaudit2(HashMap<String,Object> map);
	 int addaudie2(HashMap<String,Object> map);
	 List<DeviceGroup> querygoulist2();
	 int addgroup2(HashMap<String,Object> map);
}
