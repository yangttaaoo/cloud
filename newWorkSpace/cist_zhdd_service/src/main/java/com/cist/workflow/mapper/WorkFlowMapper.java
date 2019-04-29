package com.cist.workflow.mapper;

import java.util.List;
import java.util.Map;

import com.cist.workflow.model.Syspoliceinfo;
import com.cist.workflow.model.Zhdd_wflow_detall;
import com.cist.workflow.model.Zhdd_work_flow;

public interface WorkFlowMapper {

	/**
	 * 工作流程条件查询及分页
	 * @param map
	 * @return
	 */
	List<Zhdd_work_flow> selectWorkFlow(Map<String, Object> map);
	
	Integer deleteWorkFlowList(Map<String, Object> map);
	
	/**
	 * 工作流程明细详情
	 * @return
	 */
	List<Zhdd_wflow_detall> selectWorkfDetall();
	
	/**
	 * 根据登录人获取详情
	 * @param map
	 * @return
	 */
	List<Syspoliceinfo> selectPolice(String sypi_code);
	
	/**
	 * 添加工作明细详情
	 * @param map
	 * @return
	 */
	Integer insertWorkfDetall(Map<String, Object> map);
	
	/**
	 * 添加工作流程详情
	 * @param map
	 * @return
	 */
	Integer insertWorkFolw(Map<String, Object> map);
	
	/**
	 * 删除工作流程详情
	 * @param map
	 * @return
	 */
	Integer deleteWorkFlow(Map<String, Object> map);
	
	/**
	 * 修改工作流程详情
	 * @param map
	 * @return
	 */
	Integer updateWorkFlow(Map<String, Object> map);
	
	
	List<Zhdd_wflow_detall> selectWorkName(Map<String, Object> map);
	List<Zhdd_wflow_detall> selectWorkNames();
	
	
	//根据工作流程查询工作流程明细
	List<Zhdd_wflow_detall> selectDetail(Map<String, Object> map);
}
