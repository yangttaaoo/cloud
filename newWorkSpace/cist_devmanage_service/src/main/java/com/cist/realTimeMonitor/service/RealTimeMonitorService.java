package com.cist.realTimeMonitor.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.realTimeMonitor.model.AdministrativeAreasTree;
import com.cist.realTimeMonitor.model.DeptDeviceTree;
import com.cist.realTimeMonitor.model.SYS_CONFIG;
import com.cist.realTimeMonitor.model.VideoDeviceStatus;
import com.cist.realTimeMonitor.model.VideoDeviceTypeStatus;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface RealTimeMonitorService {
	/**
	 * 查询部门设备Tree
	 * 
	 * @return
	 * @throws JsonProcessingException 
	 */
	public  HashMap<String, Object> initDeptDeviceTree() ;
	/**
	 * 查询行政区域设备Tree
	 * @return
	 * @throws JsonProcessingException
	 */
	public  HashMap<String, Object> initAdministrativeAreasTree() throws JsonProcessingException;
	/**
	 * 初始化部门设备Tree子节点
	 * 
	 * @return
	 */
	public int getchildrenNode(List<DeptDeviceTree> deptList, List<DeptDeviceTree> DeviceList,
			DeptDeviceTree parentDept, int sizeNum);
	public int getAdministrativeAreasChildrenNode(List<AdministrativeAreasTree> deptList, List<AdministrativeAreasTree> DeviceList,
			AdministrativeAreasTree parentDept, int sizeNum,HashMap<String,Object> paramMap);
	/**
	 * 设置顶级部门的标题
	 * 
	 * @return
	 */
	public void setTopDeptTitle(DeptDeviceTree dept, List<DeptDeviceTree> DeviceList);
	/**
	 * 根据部门Id查询管理的设备中具有视频功能的设备类型List
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<DeptDeviceTree> queryDeviceType(String deptId);
	/**
	 * 查询设备节点
	 * 
	 * @param 部门节点对象
	 */
	public int initDeviceTree(DeptDeviceTree dept,List<DeptDeviceTree> DeviceList);
	public int initDeviceTree1(AdministrativeAreasTree administrativeAreas,List<AdministrativeAreasTree> DeviceList);
	/**
	 * 视频设备分类统计(根据视频设备类型分组统计离线在线数)
	 * @param paramMap
	 * @return
	 */
	public List<VideoDeviceTypeStatus>  queryStatusTotalByVideoDeviceType(HashMap<String,Object> paramMap);
	/**
	 * 视频设备在线统计(根据视频设备统计离线在线数)
	 * @param paramMap
	 * @return
	 */
	public List<VideoDeviceStatus>  queryStatusTotalByVideoDevice(HashMap<String,Object> paramMap);
	/**
	 * 分页查询设备
	 * @param paramMap
	 * @param pageInfo
	 * @return
	 */
	public Object queryDevicepageList(HashMap<String, Object> paramMap, PageInfo pageInfo);
	/**
	 * 根据索引key查询系统配置信息(查询MineDataMap基础配置信息)
	 * @param paramMap
	 * @return
	 */
	public SYS_CONFIG queryMineMapBaseConfig(HashMap<String, Object> paramMap);
	
}