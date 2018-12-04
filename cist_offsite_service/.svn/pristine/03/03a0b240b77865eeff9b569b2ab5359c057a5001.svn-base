package com.cist.videoMonitor.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.patrolplan.model.Tbl_Dev_Info;
import com.cist.videoMonitor.model.Tbl_VioPrestConfig;
import com.cist.videoMonitor.model.VideoMonitorTree;

public interface VideoMonitorMapper {
	/**
	 * 获取Tree需要的部门信息
	 * 
	 * @return
	 */
	public List<VideoMonitorTree> getDeptNode();

	/**
	 * 获取Tree需要的道路信息
	 * 
	 * @return
	 */
	public List<VideoMonitorTree> getRoadNode(HashMap<String, String> paramMap);

	/**
	 * 获取Tree需要的监控视频信息
	 * 
	 * @return
	 */
	public List<VideoMonitorTree> getVideoMonitorNode(HashMap<String, String> paramMap);

	/**
	 * 获取Tree需要的监控设备信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<VideoMonitorTree> getMonitorDevNode(HashMap<String,String> paramMap);

	/**
	 * 获取视频监控设备的信息
	 * 
	 * @param paramMap
	 * @return
	 */

	public Tbl_Dev_Info getVideoMonitorInfo(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID查询摄像机预置点列表信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<Tbl_VioPrestConfig> getVioPrestConfig(HashMap<String, Integer> paramMap);

	/**
	 * 根据预置点以及设备ID查询该预置点是否存在
	 * 
	 * @param paramMap
	 * @return
	 */
	public Tbl_VioPrestConfig getPrestByVpcPrest(HashMap<String, Object> paramMap);

	/**
	 * 添加预置位
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addPrest(HashMap<String, Object> paramMap);

	/**
	 * 更新预置位
	 * 
	 * @param paramMap
	 * @return
	 */
	public int updatePrest(HashMap<String, Object> paramMap);

	/**
	 * 删除预置位
	 * 
	 * @param paramList
	 * @return
	 */
	public int delPrest(List<Integer> paramList);
}
