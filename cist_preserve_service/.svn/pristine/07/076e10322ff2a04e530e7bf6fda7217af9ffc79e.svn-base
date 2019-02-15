package com.cist.opsflow.mapper;

import java.util.List;
import java.util.Map;

import com.cist.opsflow.model.DeptInfo;
import com.cist.opsflow.model.Jtyw_company;

public interface OpsFlowMapper {

	/**
	 * 维护单位管理详情
	 * @param map
	 * @return
	 */
	List<Jtyw_company> quertAll(Map<String, Object> map);
	
	/**
	 * 修改维护单位管理详情
	 * @param map
	 * @return
	 */
	Integer updateOps(Map<String, Object> map);
	
	/**
	 * 添加维护单位管理详情
	 * @param map
	 * @return
	 */
	Integer insertOps(Map<String, Object> map);
	
	/**
	 * 删除维护单位管理详情
	 * @param map
	 * @return
	 */
	Integer deleteOps(Map<String, Object> map);
	
	
	/**
	 * 批量删除
	 * @return
	 */
	Integer deleteAll(String[] pk);
	
	/**
	 * 管理单位树
	 * @param dept_superior
	 * @return
	 */
	List<DeptInfo> depart_infolist(Integer dept_superior);
}
