package com.cist.realTimeMonitor.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.realTimeMonitor.model.AdministrativeAreasTree;
import com.cist.realTimeMonitor.model.DeptDeviceTree;
import com.cist.realTimeMonitor.model.SYS_CONFIG;
import com.cist.realTimeMonitor.model.VideoDeviceStatus;
import com.cist.realTimeMonitor.model.VideoDeviceTypeStatus;
public interface RealTimeMonitorMapper {
	/**
	 * 根据查询顶级部门
	 * 
	 * @param paramMap
	 * @return
	 */
	public DeptDeviceTree queryTopLevelDept();
	/**
	 * 根据部门Id查询子部门
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<DeptDeviceTree> querySubLevelDept(Long deptId);
	/**
	 * 根据部门Id查询管理的设备中具有视频功能的设备类型List
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<DeptDeviceTree> queryDeviceType(String deptId);
	/**
	 * 根据行政区域code查询管理的设备中具有视频功能的设备类型List
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<AdministrativeAreasTree> queryDeviceType1(String areaCode);
	/**
	 * 根据部门ID、设备类型code查询设备信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<DeptDeviceTree> queryVideoDevice(HashMap<String,Object> paramMap);
	/**
	 * 根据行政区域code、设备类型code查询设备信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<AdministrativeAreasTree> queryVideoDevice1(HashMap<String,Object> paramMap);
	/**
	 * 查询具有视频功能的设备
	 * @param paramMap
	 * @return
	 */
	public List<DeptDeviceTree> queryVideoDeviceList(HashMap<String,Object> paramMap);
	
	/**
	 * 视频设备在线统计(根据视频设备统计离线在线数)
	 * @param paramMap
	 * @return
	 */
	public List<VideoDeviceStatus>  queryStatusTotalByVideoDevice(HashMap<String,Object> paramMap);
	/**
	 * 视频设备分类统计(根据视频设备类型分组统计离线在线数)
	 * @param paramMap
	 * @return
	 */
	public List<VideoDeviceTypeStatus>  queryStatusTotalByVideoDeviceType(HashMap<String,Object> paramMap);
	/**
	 * 根据parent_pk查询所属辖下行政区域
	 * @param paramMap
	 * @return
	 */
	public List<AdministrativeAreasTree> queryAdministrativeAreas(HashMap<String, Object> paramMap);
	/**
	 * 根据索引key查询系统配置信息(查询MineDataMap基础配置信息)
	 * @param paramMap
	 * @return
	 */
	public SYS_CONFIG queryMineMapBaseConfig(HashMap<String, Object> paramMap);
}
