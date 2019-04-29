package com.cist.roadsection.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.cist.roadsection.model.CKreisCode;
import com.cist.roadsection.model.CRoadItemInfo;
import com.cist.roadsection.model.DeptInfo;
import com.cist.roadsection.model.SysDepartInfo;
import com.cist.roadsection.model.Sys_frm_code;

public interface RoadSectionMapper {
	
	//路段基本信息查询
	List<CRoadItemInfo> listSecurityBydept_codeTocode(HashMap<String,Object> map);
	
	//管理部门树
	List<DeptInfo> depart_infolist(Integer dept_superior);
	
	//根据pk删除路段基本信息
	Integer delete(HashMap<String,Object> map);
	
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
	
	  /**
	 	 * 基础代码表中的下拉列表
	 	 * @return  List<Sys_frm_code>
	 	 */
	List<Sys_frm_code> selectSysFrmCode(String fct_code);
	
	//保存道路基本信息
	Integer save(Map<String, Object> map);
	
	//更新道路基本信息
	Integer update(Map<String, Object> map);
	
	//行政区划名称查询
	CKreisCode selectKreis(HashMap<String, Object> map);
	
	//行政区划名称查询
	SysDepartInfo selectDept(HashMap<String, Object> map);
	
	//路肩类型名称
	Sys_frm_code selectLjlx(HashMap<String, Object> map);
	//道路代码是否存在
	Integer getroimcode(HashMap<String, Object> map);
}
