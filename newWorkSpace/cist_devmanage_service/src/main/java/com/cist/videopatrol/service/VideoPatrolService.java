package com.cist.videopatrol.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.patrolplan.model.Tbl_Dev_Info;
import com.cist.realTimeMonitor.model.SYS_CONFIG;
import com.cist.videopatrol.model.SYS_FRM_CODE;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CASE;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CONFIG;

public interface VideoPatrolService {
	/**
	 * 查询视频巡逻方案
	 * @param map
	 * @return
	 */
	public List<TBL_VIO_CRUISE_CASE> querycruise(HashMap<String,Object> map);
	/**
	 * 查询视频巡逻方案摄像机表
	 * @param map
	 * @return
	 */
	public List<TBL_VIO_CRUISE_CONFIG> querycruiseconf(HashMap<String,Object> map);
	/**
	 * 根据条件查询摄像机详细信息
	 * @param map
	 * @return
	 */
	public List<Tbl_Dev_Info> querydev(HashMap<String,Object> map);
	/**
	 * 关联查询摄像机相关信息
	 * @param map
	 * @return
	 */
	public List<TBL_VIO_CRUISE_CONFIG> queryinfo(HashMap<String,Object> map);
	
	public Object queryinfopageList(HashMap<String,Object> map,PageInfo info);
	/**
	 * 查询视频画面数量
	 * @param map
	 * @return
	 */
	public List<SYS_FRM_CODE> queryvideonum(HashMap<String,Object> map);
	
	/**
	 * 根据分类查询视频巡逻方案下的摄像机
	 * @param map
	 * @return
	 */
	public List<TBL_VIO_CRUISE_CASE> selectPatrol(HashMap<String,Object> map);
	
	/**
	 * 根据索引key查询系统配置信息(查询MineDataMap基础配置信息)
	 * @param paramMap
	 * @return
	 */
	public SYS_CONFIG queryMineMapBaseConfig(HashMap<String, Object> paramMap);
	
	
	/**
	 * 查询巡逻方案并查询下面的摄像机信息
	 * @param paramMap
	 * @return
	 */
	public List<TBL_VIO_CRUISE_CASE> selectPatrolList(HashMap<String, Object> paramMap);
	
	
}
