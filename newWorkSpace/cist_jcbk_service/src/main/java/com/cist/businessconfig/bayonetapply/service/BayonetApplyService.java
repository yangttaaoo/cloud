package com.cist.businessconfig.bayonetapply.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cist.businessconfig.bayonetapply.model.Jcbk_control_vehicle;
import com.cist.businessconfig.bayonetapply.model.Sys_frm_code;
import com.cist.frame.page.PageInfo;

public interface BayonetApplyService {
	/**
	 * 查询车辆布控管理信息
	 * @param map
	 * @return
	 */
	public List<Jcbk_control_vehicle> queryBayonetApplyinfo(HashMap<String,Object> map);
	/**
	 * 查询车辆布控管理信息(分页)
	 * @param map
	 * @param info
	 * @return
	 */
	public Object queryBayonetApplyinfopageList(HashMap<String,Object> map,PageInfo info);
	/**
	 * 添加车辆布控管理信息
	 * @param map
	 * @return
	 */
	public Integer addBayonetApply(Map<String,Object> map);
	/**
	 * 修改车辆布控管理信息
	 * @param map
	 * @return
	 */
	public Integer updateBayonetApply(Map<String,Object> map);
	/**
	 * 删除车辆布控管理信息
	 * @param map
	 * @return
	 */
	public Integer deleteBayonetApply(HashMap<String,Object> map);
	/**
	 * 查询基础信息
	 * @param map
	 * @return
	 */
	public List<Sys_frm_code> querySys_frm_code(HashMap<String,Object> map);
}
