package com.cist.patrolplan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.patrolplan.model.Dept;
import com.cist.patrolplan.model.Device;
import com.cist.patrolplan.model.SYS_CONFIG;
import com.cist.patrolplan.model.SpjkVioPrestConfig;
import com.cist.patrolplan.model.Sys_frm_code;
import com.cist.patrolplan.model.UpdateData;
import com.cist.realTimeMonitor.model.DeptDeviceTree;
import com.cist.realTimeMonitor.model.VideoDeviceTypeStatus;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CASE;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CONFIG;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service(value="PatrolplanServiceImpl")
public interface PatrolplanService {
	/**
	 * 查询所有数据详情
	 * @param map
	 * @param info
	 * @return
	 */
	Object selectAllpageList(HashMap<String, Object> map,PageInfo info);
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
	
	public void delectVcc(HashMap<String, Object> map) throws Exception;
	
	/**
	 * 查询部门设备Tree
	 * 
	 * @return
	 * @throws JsonProcessingException 
	 */
	public  HashMap<String, Object> initDeptDeviceTree() throws JsonProcessingException;
	/**
	 * 初始化部门设备Tree子节点
	 * 
	 * @return
	 */
	public int getchildrenNode(List<DeptDeviceTree> deptList, List<DeptDeviceTree> DeviceList,
			DeptDeviceTree parentDept, int sizeNum);
	
	/**
	 * 查询设备节点
	 * 
	 * @param 部门节点对象
	 */
	public int initDeviceTree(DeptDeviceTree dept,List<DeptDeviceTree> DeviceList);
	
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
	
	
	/**
	 *更新巡逻方案相关摄像机信息
	 * @param map
	 * @return
	 */
	Integer updateTblVioCruiseConfig(HashMap<String, Object> map);
	
	
	
	
	
}
