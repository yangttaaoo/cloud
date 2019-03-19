package com.cist.devmanagement.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cist.devmanagement.model.CKreisCode;
import com.cist.devmanagement.model.DeptInfo;
import com.cist.devmanagement.model.JcsjDevice;
import com.cist.devmanagement.model.RoadTree;
import com.cist.devmanagement.model.SssbEquipmentRegister;
import com.cist.devmanagement.model.Sys_frm_code;

/***
 * 
 * @Title:DevManagementMapper.java
 * @Package:com.cist.devmanagement.mapper
 * @Description:TODO
 * @author:YT
 * @date:2019年3月6日
 * @version V1.0
 */
public interface DevManagementMapper {
   
		//管理部门树
	List<DeptInfo> depart_infolist(Integer dept_superior);
	  /**
	 	 * 基础代码表中的下拉列表
	 	 * @return  List<Sys_frm_code>
	 	 */
	List<Sys_frm_code> selectSysFrmCode(String fct_code);
	
	//设备入网登记
	List<SssbEquipmentRegister> list(HashMap<String,Object> map);
	
	//新增设备注册信息
	Integer addRegister(HashMap<String,Object> map);
	
	//新增设备信息
	Integer addGather(HashMap<String,Object> map);
	
	//删除设备注册信息
	Integer deleteRegister(HashMap<String,Object> map);
	
	//删除设备信息
	Integer deleteGather(HashMap<String,Object> map);
	
	//更新设备注册信息
	Integer updateRegister(HashMap<String,Object> map);
	
	//更新设备信息
	Integer updateGather(HashMap<String,Object> map);
	
	//审核
	Integer examineRegister(HashMap<String,Object> map);
	
	//查询已备案设备信息
	List<JcsjDevice> selectDev(HashMap<String,Object> map);
	
	//新增设备信息
	Integer batchAdd(List<SssbEquipmentRegister> list);
	
	//新增设备信息
	Integer batchAddRegister(HashMap<String,Object> map);
	
	//新增设备信息
	Integer batchAddGather(HashMap<String,Object> map);
	
	//查询部门id
	List<DeptInfo>selectDeptId(HashMap<String,Object> map);
	
	/**
	 *  根据条件获取下级行政区域 返回 RoadTree
	 * @param paramMap
	 * @return
	 */
	public List<RoadTree> queryAdministrativeAreas1(HashMap<String, Object> paramMap);
	
	/**
	 * 查询所有道路
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<RoadTree> queryAllRoad(HashMap<String, Object> paramMap);

	/**
	 * 根据道路Code查询路口、路段
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<RoadTree> queryRoadSegiteByRoadCode(HashMap<String, Object> paramMap);
	
	/**
	 * 行政区划树
	 * @return
	 */
	List<CKreisCode> kreis(Map<String, Object> map);
	
	/**
	 * 行政区划树
	 * @return
	 */
	List<CKreisCode> kreisList(Integer bigDecimal);
	
}