package com.cist.devmanagement.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cist.devmanagement.model.CKreisCode;
import com.cist.devmanagement.model.DeptInfo;
import com.cist.devmanagement.model.JcsjDevice;
import com.cist.devmanagement.model.RoadTree;
import com.cist.devmanagement.model.SssbEquipmentRegister;
import com.cist.devmanagement.model.Sys_frm_code;
import com.cist.frame.page.PageInfo;


/***
 * 
 * @Title:DevManagementService.java
 * @Package:com.cist.devmanagement.service
 * @Description:TODO
 * @author:YT
 * @date:2019年3月6日
 * @version V1.0
 */
public interface DevManagementService {

	//管理部门树
	List<DeptInfo> depart_infolist(Integer dept_superior);
	
	  /**
	 	 * 基础代码表中的下拉列表
	 	 * @return  List<Sys_frm_code>
	 	 */
	List<Sys_frm_code> selectSysFrmCode(String fct_code);
	

	//设备入网登记
	Object listpageList(HashMap<String,Object> map,PageInfo p);
	
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
	Object selectDevpageList(HashMap<String,Object> map,PageInfo p);
	
	//新增设备信息
	Integer batchAdd(List<SssbEquipmentRegister> list);
	
	//新增注册信息
	Integer batchAddRegister(HashMap<String,Object> map);
	
	//新增设备信息
	Integer batchAddGather(HashMap<String,Object> map);
	
	//查询部门id
	List<DeptInfo>selectDeptId(HashMap<String,Object> map);
	
	/**
	 * 初始化行政区划-道路-路口Tree
	 * @param paramMap
	 * @return
	 */
	public List<RoadTree> initAreaRoadTree(HashMap<String,Object> paramMap);
	
	/**
	 * 生成路口路段Tree
	 * 
	 * @param dept
	 * @param DeviceList
	 */

	public int initRoadSegiteTree(HashMap<String, Object> paramMap,RoadTree currentArea);
	/**
	 * 初始化行政区划-道路-路口 子节点Tree
	 * @param perentList
	 * @param paramMap
	 */
	public int gettAreaRoadChildren(RoadTree currentList,List<RoadTree> childrenList,HashMap<String, Object> paramMap,int currentNodeChildNums);

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
