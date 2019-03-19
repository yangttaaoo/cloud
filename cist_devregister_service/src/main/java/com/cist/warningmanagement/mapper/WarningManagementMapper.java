package com.cist.warningmanagement.mapper;

import java.util.HashMap;
import java.util.List;
import com.cist.devmanagement.model.SssbEquipmentRegister;
import com.cist.warningmanagement.model.SssbEquipmentWarning;



/***
 * 
 * @Title:WarningManagementMapper.java
 * @Package:com.cist.warningmanagement.mapper
 * @Description:TODO
 * @author:YT
 * @date:2019年3月12日
 * @version V1.0
 */
public interface WarningManagementMapper {
   
	
	//预警信息分页查询
	List<SssbEquipmentWarning> list(HashMap<String,Object> map);
	
	//删除预警信息
	Integer deleteWarning(HashMap<String,Object> map);
	
	//查询预警信息关联的设备
	List<SssbEquipmentRegister> selectByDev(HashMap<String,Object> map);
	
	//查询预警信息关联的设备
	List<SssbEquipmentRegister> selectByPc(HashMap<String,Object> map);
}