package com.cist.carInfo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cist.frame.page.PageInfo;
import com.cist.carInfo.model.Sys_frm_code;
import com.cist.carInfo.model.CKreisCode;
import com.cist.carInfo.model.DeptInfo;

public interface CarInfoService {
		//根据pk删除
		Integer delete(HashMap<String,Object> map);
		
		//新增接口使用申请
		Integer save(HashMap<String,Object> map);
		
		//条件分页查询
		Object listpageList(HashMap<String,Object> map,PageInfo pinfo); 
		
		//更新菜单内容
		Integer update(HashMap<String,Object> map);
		
		/**
		 * 使用单位树
		 * @param dept_superior
		 * @return
		 */
		List<DeptInfo> depart_infolist(Integer dept_superior);
		
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
		
		//条件分页查询
		Object selectCompanypageList(HashMap<String,Object> map,PageInfo pinfo); 
		
}
