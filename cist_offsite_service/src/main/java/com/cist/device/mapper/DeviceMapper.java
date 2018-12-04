package com.cist.device.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.device.model.DeptInfo;
import com.cist.device.model.PoliceInfo;
import com.cist.device.model.Sys_device_grouping;
import com.cist.frame.page.PageInfo;

public interface DeviceMapper {
	 List<Sys_device_grouping> querylist(); 
	 List<Sys_device_grouping> querypolpageList(HashMap<String,Object> map); 
	 Sys_device_grouping querydept(String groud_dev);
	 Sys_device_grouping querydevpol(HashMap<String,Object> map);
	 List<Sys_device_grouping> queryusergroud(String sypi_pk);
	 List<Sys_device_grouping> querydev();
	 List<Sys_device_grouping> querypolice();
	 int addDevInfo(HashMap<String,Object> map);
	 int addDevGroud(HashMap<String,Object> map);
	 int addUserGroud(HashMap<String,Object> map);
	 int delUserGroud(HashMap<String,Object> map);
	 Sys_device_grouping querydevicegro(HashMap<String,Object> map); 
	 int delPol(HashMap<String,Object> map);
	 int delpolall(List<String> list);
	 int addPolGroud(HashMap<String,Object> map);
	 List<Sys_device_grouping> querypolgroud(String sypi_code);
	 List<Sys_device_grouping> querydevgroud(String groud_code); 
	 int delDev(HashMap<String,Object> map);
	 int editDev(HashMap<String,Object> map);
	 int delDevInfo(HashMap<String,Object> map);
	 Sys_device_grouping querygroudcode(String groud_code); 
	 List<DeptInfo> depart_infolist(Integer dept_superior);
	 List<DeptInfo> Monitorpoint(String tbmp_dept_code);
	 List<DeptInfo> Device(String tbmp_id);
	 List<PoliceInfo> police_infolist(Integer dept_superior);
	 List<PoliceInfo> Police(Integer dept_pk);
	 List<Sys_device_grouping> querydeptlist();
}
