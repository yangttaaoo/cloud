package com.cist.audit.service;

import java.util.HashMap;
import java.util.List;

import com.cist.audit.model.DeviceGroup;
import com.cist.audit.model.OffeInfo;
import com.cist.audit.model.PoliceInfo;
import com.cist.device.model.DeptInfo;

public interface AuditService {
	/**
	 * 警员列表及审核权限信息查询
	 */
	List<PoliceInfo> querypol();
	/**
	 * 违法行为信息查询
	 */
	List<OffeInfo> querywfxw();
	/**
	 * 权限主表信息查询
	 */
	List<PoliceInfo> querv();
	/**
	 * 修改权限主表信息查询
	 */
	int editaudit(HashMap<String,Object> map);
	/**
	 * 新增权限主表信息查询
	 */
	int addaudie(HashMap<String,Object> map);
	List<PoliceInfo> polgroud(Integer dept_superior);
	List<PoliceInfo> usergroud(Integer dept_superior);
	List<PoliceInfo> querywsb();
	/**
	 * 设备树结构查询：管理部门-道路-安装点位-设备
	 * @param dept_superior
	 * @return
	 */
	 List<DeptInfo> depart_infolist(Integer dept_superior);
	 List<DeptInfo> Monitorpoint(String tbmp_dept_code);
	 List<DeptInfo> azdw(String tbmp_dept_code);
	 List<DeptInfo> Device(String tbmp_id);
	 /**
	  * 设备分组查询
	  */
	 List<DeviceGroup> querygoulist();
	 List<DeviceGroup> queryusergroud(String tbvg_pk);
	 DeviceGroup querydept(String dvc_pk);
	 /**
	  * 设备分组新增、删除
	  */
	 int addgroup(HashMap<String,Object> map);
	 int delgoulist(HashMap<String,Object> map);
	 int deldve();
	 /**
	  * 新增用户设备权限
	  */
	 int delPol(HashMap<String,Object> map);//删除用户设备权限表信息
	 int delUserGroud(HashMap<String,Object> map);//删除用户设备分组表信息
	 int addUserGroud(HashMap<String,Object> map);//新增用户设备分组表信息
	 int addPolGroud(HashMap<String,Object> map);//新增用户设备权限表信息
	 int addauthority(HashMap<String,Object> map);
	 /**
	  * 用户设备数量查询
	  */
	 List<DeviceGroup> querysbsl();
	 PoliceInfo querytbvg(String sypi_pk);
	 
	 
	 
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
