package com.cist.carInfo.mapper;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cist.carInfo.model.CKreisCode;
import com.cist.carInfo.model.DeptInfo;
import com.cist.carInfo.model.ZdclCarInfo;
import com.cist.carInfo.model.ZdclCompanyInfo;
import com.cist.carInfo.model.Sys_frm_code;

public interface CarInfoMapper {
	
	//所属公司信息插入
	Integer saveCompany(HashMap<String,Object> map);
	
	//驾驶人信息插入
	Integer saveDrivers(HashMap<String,Object> map);
		
	//根据pk删除菜单
	Integer delete(HashMap<String,Object> map);
	
	//新增接口使用申请
	Integer save(HashMap<String,Object> map);
	
	//新增接口使用申请时新增接口使用列表
	Integer saveList(HashMap<String,Object> map);
	
	//条件分页查询
	List<ZdclCarInfo> list(HashMap<String,Object> map); 
	
	//更新菜单内容
	Integer update(HashMap<String,Object> map);
	
	/**
	 * 使用单位树
	 * @param dept_superior
	 * @return
	 */
	List<DeptInfo> depart_infolist(Integer dept_superior);
	
	//更新接口使用列表
	Integer updateInterface(HashMap<String,Object> map);
	
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
	
	  /**
	 	 * 查询所属公司信息
	 	 * @return  List<ZdclCompanyInfo>
	 	 */
	List<ZdclCompanyInfo> selectCompany(HashMap<String,Object> map);
}
