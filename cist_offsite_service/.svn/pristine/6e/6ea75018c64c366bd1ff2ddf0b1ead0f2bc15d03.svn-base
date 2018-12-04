package com.cist.serviceconfig.warningconfig.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.serviceconfig.warningconfig.model.DeptInfo;
import com.cist.serviceconfig.warningconfig.model.TBL_OFFE_VIO_ALARM;
import com.cist.serviceconfig.warningconfig.model.VideoMonitorTree;

public interface WarningconfigMapper {
	List<DeptInfo> depart_infolist(Integer dept_superior);
	 List<DeptInfo> Monitorpoint(String tbmp_dept_code);
	 List<DeptInfo> Device(String tbmp_id);
	 List<TBL_OFFE_VIO_ALARM> queryyjyz(HashMap<String, Object> map);
	Integer addyjyz(HashMap<String, Object> map); 
	Integer updateyjyz(HashMap<String, Object> map);
	Integer delyjyz(HashMap<String, Object> map);
	
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
}
