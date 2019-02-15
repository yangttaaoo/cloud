package com.cist.eventmanagement.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cist.eventmanagement.model.DeptInfo;
import com.cist.eventmanagement.model.VW_EVENT_INFO;
import com.cist.eventmanagement.model.Zhdd_event_acceptance;
import com.cist.eventmanagement.model.Zhdd_event_attachment;
import com.cist.eventmanagement.model.Zhdd_event_dispatch;
import com.cist.eventmanagement.model.Zhdd_event_flow;
import com.cist.eventmanagement.model.Zhdd_event_personnel;
import com.cist.eventmanagement.model.Zhdd_event_preselection;
import com.cist.eventmanagement.model.Zhdd_event_result;
import com.cist.eventmanagement.model.Zhdd_event_source;
import com.cist.eventmanagement.model.Zhdd_event_type;
import com.cist.eventmanagement.model.Zhdd_work_flow;
import com.cist.eventmanagement.model.Zhdd_work_flow_detail;
import com.cist.frame.page.PageInfo;

public interface EventManagementService {
	/**
	 * 查询事件详细信息(不分页)
	 * @param map
	 * @return
	 */
	public List<VW_EVENT_INFO> queryeventinfo(HashMap<String,Object> map);
	/**
	 * 查询事件详细信息(分页)
	 * @param map
	 * @return
	 */
	public Object queryeventinfopageList(HashMap<String,Object> map,PageInfo info);
	/**
	 * 删除事件详细信息
	 * @param map
	 * @return
	 */
	public Integer deleteeventinfo(HashMap<String,Object> map);
	/**
	 * 更新事件详细信息
	 * @param map
	 * @return
	 */
	public Integer updateeventinfo(HashMap<String,Object> map);
	List<DeptInfo> depart_infolist(Integer dept_superior);
	/**
	 * 根据条件查询事件来源
	 * @param map
	 * @return
	 */
	public List<Zhdd_event_source> querysjly(HashMap<String,Object> map);
	/**
	 * 根据条件查询事件类型
	 * @param map
	 * @return
	 */
	public List<Zhdd_event_type> querysjtype(HashMap<String,Object> map);
	/**
	 * 添加事件信息
	 * @param map
	 * @return
	 */
	public Integer addsj(HashMap<String,Object> map);
	/**
	 * 添加事件受理信息
	 * @param map
	 * @return
	 */
	public Integer addslinfo(HashMap<String,Object> map);
	/**
	 * 删除受理信息
	 * @param map
	 * @return
	 */
	public Integer delZhdd_event_acceptance(HashMap<String,Object> map);
	/**
	 * 根据事件id查询调度信息
	 * @param map
	 * @return
	 */
	public List<Zhdd_event_dispatch> queryddinfo(HashMap<String,Object> map);
	/**
	 * 根据事件id查询受理信息
	 * @param map
	 * @return
	 */
	public List<Zhdd_event_acceptance> queryslinfo(HashMap<String,Object> map);
	
	/**
	 * 根据事件id查询事件处置流程
	 * @param map
	 * @return
	 */
	public List<Zhdd_event_flow> querylcinfo(HashMap<String,Object> map);
	
	/**
	 * 查询预选项
	 * @param map
	 * @return
	 */
	public List<Zhdd_event_preselection> queryyxx(HashMap<String,Object> map);
	/**
	 * 查询事件处置人员
	 * @param map
	 * @return
	 */
	public List<Zhdd_event_personnel> querypeople(HashMap<String,Object> map);
	/**
	 * 根据事件id查询事件附件
	 * @param map
	 * @return
	 */
	public List<Zhdd_event_attachment> querysjfj(HashMap<String,Object> map);
	/**
	 * 根究事件id查询事件处置结果
	 * @param map
	 * @return
	 */
	public Zhdd_event_result querysjjg(HashMap<String,Object> map);
	/**
	 * 更新事件信息
	 * @param map
	 * @return
	 */
	public Integer updateZhdd_event_information(HashMap<String,Object> map);
	/**
	 * 更新受理信息
	 * @param map
	 * @return
	 */
	public Integer updateZhdd_event_acceptance(HashMap<String,Object> map);
	/**
	 * 更新事件处置结果
	 * @param map
	 * @return
	 */
	public Integer updateZhdd_event_result(Map<String,Object> map);
	/**
	 * 更新事件处置流程
	 * @param map
	 * @return
	 */
	public Integer updateZhdd_event_flow(Map<String,Object> map);
	/**
	 * 根据事件id查询工作流程
	 * @param map
	 * @return
	 */
	public Zhdd_work_flow queryZhdd_work_flow(HashMap<String,Object> map);
	/**
	 * 根据流程id查询流程明细
	 * @param map
	 * @return
	 */
	public List<Zhdd_work_flow_detail> queryZhdd_work_flow_detail(HashMap<String,Object> map);
	/**
	 * 添加事件处置流程
	 * @param map
	 * @return
	 */
	Integer addflow(Map<String, Object> map);
	/**
	 * 添加事件处置结果
	 * @param map
	 * @return
	 */
	Integer addresult(Map<String,Object> map);
	/**
	 * 根据id删除附件信息
	 * @param map
	 * @return
	 */
	Integer delZhdd_event_attachment(HashMap<String,Object> map);
	/**
	 * 添加附件信息
	 * @param map
	 * @return
	 */
	Integer addZhdd_event_attachment(Zhdd_event_attachment attachment);
	/**
	 * 根据id查询附件信息
	 * @param map
	 * @return
	 */
	List<Zhdd_event_attachment> queryZhdd_event_attachment(HashMap<String,Object> map);
	
	/**
	 * 更新事件回访结果
	 * @param map
	 * @return
	 */
	Integer updateResult(HashMap<String,Object> map);
	
}
