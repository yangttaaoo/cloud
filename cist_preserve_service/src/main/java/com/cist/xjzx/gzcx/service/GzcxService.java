package com.cist.xjzx.gzcx.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.xjzx.gzcx.model.JTYW_JOB_ORDER;
import com.cist.xjzx.gzcx.model.JTYW_MAINTENANCE_COMPANY;
import com.cist.xjzx.gzcx.model.JTYW_MAINTENANCE_GROUP;
import com.cist.xjzx.gzcx.model.VW_SBGZ_INFO;

public interface GzcxService {
	/**
	 * 查询故障
	 * @param map
	 * @return
	 */
	public List<VW_SBGZ_INFO> querygz(HashMap<String,Object> map);
	/**
	 * 分页 查询故障
	 * @param map
	 * @param info
	 * @return
	 */
	public Object querygzpageList(HashMap<String,Object> map,PageInfo info);
	/**
	 * 添加工单
	 * @param map
	 * @return
	 */
	public Integer addgd(HashMap<String,Object> map);
	/**
	 * 添加工单管理信息
	 * @param map
	 * @return
	 */
	public Integer addgdgl(HashMap<String,Object> map);
	/**
	 * 删除故障设备信息
	 * @param map
	 * @return
	 */
	public Integer del(HashMap<String,Object> map);
	/**
	 * 添加工单流程
	 * @param map
	 * @return
	 */
	public Integer addgdlc(HashMap<String,Object> map);
	/**
	 * 查询工单
	 * @param map
	 * @return
	 */
	public List<JTYW_JOB_ORDER> querygd(HashMap<String,Object> map);
	/**
	 * 分页查询工单
	 * @param map
	 * @return
	 */
	public Object querygdpageList(HashMap<String,Object> map,PageInfo info);
	/**
	 * 更新工单详情
	 * @param map
	 * @return
	 */
	public Integer updategd(HashMap<String,Object> map);
//	/**
//	 * 更新工单流程
//	 * @param map
//	 * @return
//	 */
//	public Integer updategdlc(HashMap<String,Object> map);
	/**
	 * 查询维护单位
	 * @param map
	 * @return
	 */
	public List<JTYW_MAINTENANCE_COMPANY> querycompany(HashMap<String,Object> map);
	/**
	 * 查询维护组
	 * @param map
	 * @return
	 */
	public List<JTYW_MAINTENANCE_GROUP> querygroup(HashMap<String,Object> map);
}
