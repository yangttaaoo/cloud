package com.cist.warningmanagement.service;

import java.util.HashMap;
import java.util.List;

import com.cist.devmanagement.model.SssbEquipmentRegister;
import com.cist.frame.page.PageInfo;

/***
 * 
 * @Title:WarningManagementService.java
 * @Package:com.cist.warningmanagement.service
 * @Description:TODO
 * @author:YT
 * @date:2019年3月12日
 * @version V1.0
 */
public interface WarningManagementService {

	
	//预警信息查询
	Object listpageList(HashMap<String,Object> map,PageInfo p);
	
	//删除预警信息
	Integer deleteWarning(HashMap<String,Object> map);
	
	//查询预警信息关联的设备
	List<SssbEquipmentRegister> selectDev(HashMap<String,Object> map);
	
	//查询预警信息关联的设备
	List<SssbEquipmentRegister> selectPc(HashMap<String,Object> map);
}
