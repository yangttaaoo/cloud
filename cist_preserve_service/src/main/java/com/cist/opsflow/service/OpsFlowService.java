package com.cist.opsflow.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.opsflow.model.DeptInfo;

@Service(value="OpsFlowServiceImpl")
public interface OpsFlowService {

	/**
	 * 维护单位管理详情
	 * @param map
	 * @param pinfo
	 * @return
	 */
	Object queryAllpageList(Map<String, Object> map,PageInfo pinfo);
	
	/**
	 * 修改维护单位管理详情
	 * @param map
	 * @return
	 */
	Integer updateOps(Map<String, Object> map);
	
	/**
	 * 删除维护单位管理详情
	 * @param map
	 * @return
	 */
	Integer deleteOps(Map<String, Object> map);
	
	/**
	 * 添加维护单位管理详情
	 * @param map
	 * @return
	 */
	Integer insertOps(Map<String, Object> map);
	
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
