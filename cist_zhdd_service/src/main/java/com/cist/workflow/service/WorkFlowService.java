package com.cist.workflow.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.workflow.model.Syspoliceinfo;
import com.cist.workflow.model.Zhdd_wflow_detall;

@Service(value="WorkFlowServiceImpl")
public interface WorkFlowService {
	
	/**
	 * 工作流程条件查询及分页
	 * @param map
	 * @param p
	 * @return
	 */
	Object selectWorkpageList(Map<String, Object> map,PageInfo p);
	
	/**
	 * 根据登录人ID获取详情
	 * @param map
	 * @return
	 */
	List<Syspoliceinfo> selectPolice(String sypi_code);
	
	/**
	 * 工作流程明细详情
	 * @return
	 */
	List<Zhdd_wflow_detall> selectWorkfDetall();
	
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
	
	Integer deleteWorkFlowList(Map<String, Object> map);
	
	List<Zhdd_wflow_detall> selectWorkName(Map<String, Object> map);
	List<Zhdd_wflow_detall> selectWorkNames();
	
	//根据工作流程查询工作流程明细
	List<Zhdd_wflow_detall> selectDetail(Map<String, Object> map);
}
