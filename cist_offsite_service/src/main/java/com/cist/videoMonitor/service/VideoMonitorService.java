package com.cist.videoMonitor.service;

import java.util.HashMap;
import java.util.List;

import com.cist.patrolplan.model.Tbl_Dev_Info;
import com.cist.videoMonitor.model.Tbl_VioPrestConfig;

public interface VideoMonitorService {
	/**
	 * 初始化视频监控的Tree
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initTree() throws Exception;

	/**
	 * 获取视频监控设备的信息
	 * 
	 * @param paramMap
	 * @return
	 */

	public Tbl_Dev_Info getVideoMonitorInfo(HashMap<String, Object> paramMap);
	/**
	 * 根据设备ID查询摄像机预置点列表信息
	 * @param paramMap
	 * @return
	 */
	public List<Tbl_VioPrestConfig> getVioPrestConfig(int devId);
	/**
	 * 根据预置点是否存在对预置位进行对应的编辑
	 * @param paramMap
	 * @return
	 */
	public int   EditPrest(HashMap<String, Object> paramMap);
	/**
	 * 删除预置位
	 * @param paramList
	 * @return
	 */
	public int delPrest(HashMap<String, List<Integer>> paramMap);
}
