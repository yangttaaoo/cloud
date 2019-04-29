package com.cist.videopatrol.service;

import java.util.HashMap;
import java.util.List;

import com.cist.patrolplan.model.Tbl_Dev_Info;
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
}
