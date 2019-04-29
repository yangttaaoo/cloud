package com.cist.patrolplan.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.patrolplan.model.Dept;
import com.cist.patrolplan.model.Device;
import com.cist.patrolplan.model.Need;
import com.cist.patrolplan.model.SYS_CONFIG;
import com.cist.patrolplan.model.SpjkVioPrestConfig;
import com.cist.patrolplan.model.Sys_frm_code;
import com.cist.patrolplan.model.UpdateData;
import com.cist.realTimeMonitor.model.DeptDeviceTree;
import com.cist.realTimeMonitor.model.VideoDeviceTypeStatus;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CASE;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CONFIG;

public interface PatrolplanMapper {
	/**
	 * 查询所有数据详情
	 * @param map
	 * @return
	 */
	List<Need> selectAll(HashMap<String, Object> map);
	/**
	 * 查询部门
	 * @param map
	 * @return
	 */
	List<Dept> selectDept(HashMap<String, Object> map);
	/**
	 * 通过巡逻方案名称删除巡逻方案
	 * @param map
	 * @return
	 */
	Integer deleteByVccname(HashMap<String, Object> map);
	/**
	 * 通过视频巡逻方案id删除摄像机表
	 * @param map
	 * @return
	 */
	Integer deleteByVccpk(HashMap<String, Object> map);
	/**
	 * 查询出视频巡逻方案的主键
	 * @param map
	 * @return
	 */
	TBL_VIO_CRUISE_CASE selectTvcc(HashMap<String, Object> map);
	/**
	 * 添加巡逻方案
	 * @param map
	 * @return
	 */
	Integer addTblVioCruiseCase(HashMap<String, Object> map);
	/**
	 * 添加摄像机
	 * @param map
	 * @return
	 */
	Integer insertTblVioCruiseConfig(HashMap<String, Object> map);
	/**
	 * 查询设备备案数据
	 * @param map
	 * @return
	 */
	Device getVideoMonitorInfo(HashMap<String, Object> map);
	/**
	 * 查询摄像机信息
	 * @param map
	 * @return
	 */
	List<TBL_VIO_CRUISE_CONFIG> getTblVioCruiseConfig(HashMap<String, Object> map);
	/**
	 * 根据摄像机名称查询出对应的摄像机信息
	 * @param map
	 * @return
	 */
	List<UpdateData> getUpdatedata(HashMap<String, Object> map);
	/**
	 * 更新视频巡逻方案
	 * @param map
	 * @return
	 */
	Integer updateTblVioCruiseCase(HashMap<String, Object> map);
	/**
	 * 删除摄像机
	 * @param map
	 * @return
	 */
	Integer deleteVccpk(HashMap<String, Object> map);
	
	/**
	 * 根据部门ID、设备类型code查询设备信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<DeptDeviceTree> queryVideoDevice(HashMap<String,Object> paramMap);
	
	//查询巡逻分类下拉列表
	List<Sys_frm_code> selectBaseDate(HashMap<String,Object> map);
	
	/**
	 * 视频设备分类统计(根据视频设备类型分组统计离线在线数)
	 * @param paramMap
	 * @return
	 */
	public List<VideoDeviceTypeStatus>  queryStatusTotalByVideoDeviceType(HashMap<String,Object> paramMap);
	
	/**
	 * 查询视频国标地址
	 * @param map
	 * @return
	 */
	public SYS_CONFIG  selectConfig(HashMap<String,Object> map);
	
	/**
	 * 新增摄像头预置点位
	 * @param map
	 * @return 
	 * @return
	 */
	public Integer insertPoint(HashMap<String,Object> map);
	
	/**
	 * 查询摄像机预置位
	 * @param map
	 * @return 
	 * @return
	 */
	public List<SpjkVioPrestConfig> selectPoint(HashMap<String,Object> map);
	
	/**
	 * 删除预制点位信息
	 * @param map
	 * @return 
	 * @return
	 */
	public Integer deletePoint(HashMap<String,Object> map);
}
