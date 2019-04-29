package com.cist.devRegister.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.cist.devRegister.model.AdministrativeAreasTree;
import com.cist.devRegister.model.Ckreiscode;
import com.cist.devRegister.model.DeptTree;
import com.cist.devRegister.model.Device;
import com.cist.devRegister.model.DeviceAuditProcess;
import com.cist.devRegister.model.DeviceBayonetLane;
import com.cist.devRegister.model.DeviceBayonetRelevance;
import com.cist.devRegister.model.RoadTree;
import com.cist.devRegister.util.TempModel;
import com.cist.frame.page.PageInfo;

public interface DevRegisterService {

	/**
	 * 初始化部门Tree
	 * 
	 * @return
	 */
	public String initDeptTree(HttpServletRequest request) throws Exception;
	/**
	 * 初始化行政区划Tree
	 * 
	 * @return
	 */
	public List<AdministrativeAreasTree> initAdministrativeAreasTree();
	/**
	 * 初始化行政区划-道路-路口Tree
	 * @param paramMap
	 * @return
	 */
	public List<RoadTree> initAreaRoadTree(HashMap<String,Object> paramMap);
	
	
	/**
	 * 初始化行政区划Tree
	 * 
	 * @return
	 */
	public void getAdministrativeAreasChildren(List<AdministrativeAreasTree> perentList,HashMap<String, Object> paramMap);
	/**
	 * 初始化行政区划-道路-路口 子节点Tree
	 * @param perentList
	 * @param paramMap
	 */
	public int gettAreaRoadChildren(RoadTree currentList,List<RoadTree> childrenList,HashMap<String, Object> paramMap,int currentNodeChildNums);

	/**
	 * 设备具有功能(卡口、电警)具有功能类型LIST
	 * 
	 * @param FCT_CODE
	 *            例如G999
	 * @return
	 */
	public List<TempModel> queryDevFunType(String FCT_CODE);

	public List<TempModel> queryDeviceInfo(HashMap<String, Object> paramMap);

	/**
	 * 查询设备类型List
	 * 
	 * @param FCT_CODE
	 *            例如M001
	 * @return
	 */
	public List<TempModel> queryDevType(String FCT_CODE);

	/**
	 * 违法行为List
	 * 
	 * @return
	 */
	public List<TempModel> queryOffenceList();

	/**
	 * 添加设备信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addDeviceInfo(HashMap<String, Object> paramMap);

	/**
	 * 道路List
	 * 
	 * @return
	 */
	public List<TempModel> queryRoadList();
	/**
	 * 根据部门和行政区域获取道路list
	 * @param paramMap
	 * @return
	 */
	public List<TempModel> queryRoadList1(HashMap<String, Object> paramMap);

	/**
	 * 添加设备厂商维护信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addDevMaintenance(HashMap<String, Object> paramMap);

	public int addDevRelationKKInfo(HashMap<String, Object> paramMap);

	public HashMap<String, Object> getDevRelationKKInfo(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID查询设备信息表
	 * 
	 * @param paramMap
	 * @return
	 */
	public Device getDevice(HashMap<String, Object> paramMap);

	/**
	 * 更新设备基础信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int updateDeviceInfo(HashMap<String, Object> paramMap);

	/**
	 * 更新设备厂商维护信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int updateDevMaintenance(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID删除基础设备备案信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteDeviceInfo(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID删除设备厂商信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteDevMaintenance(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID删除类型为<卡口>的设备相关信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteDeviceRelationKKInfo(HashMap<String, Object> paramMap);

	/**
	 * 添加保存与<监控>设备关联表的数据
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addDeviceRelationJKInfo(HashMap<String, Object> paramMap);

	/**
	 * 添加保存与电警关联表的数据
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addDevRelationDJInfo(HashMap<String, Object> paramMap);

	/**
	 * 添加摄像头(监控)事件监听标记
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addDevEventAct(HashMap<String, Object> paramMap);

	/**
	 * 关联流量监测
	 */
	public int addDevFlowMonitor(HashMap<String, Object> paramMap);

	public int addDevRelationXHDInfo(HashMap<String, Object> paramMap);

	/**
	 * 添加保存与诱导屏关联表的数据
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addDevRelationYDInfo(HashMap<String, Object> paramMap);
	/**
	 * 分页查询设备
	 * @param paramMap
	 * @param pageInfo
	 * @return
	 */
	public Object queryDevicepageList(HashMap<String, Object> paramMap, PageInfo pageInfo);

	/**
	 * 获取与设备关联的参数信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public HashMap<String, Object> getDevRelationJKInfo(HashMap<String, Object> paramMap);

	public HashMap<String, Object> getDevRelationDJInfo(HashMap<String, Object> paramMap);

	/**
	 * 查询设备关联的事件监测
	 * 
	 * @param paramMap
	 * @return
	 */
	public HashMap<String, Object> getDevRelationSJJCInfo(HashMap<String, Object> paramMap);

	/**
	 * 查询设备关联的流量监测
	 * 
	 * @param paramMap
	 * @return
	 */
	public HashMap<String, Object> getDevRelationLLJCInfo(HashMap<String, Object> paramMap);

	public HashMap<String, Object> getDevRelationYDInfo(HashMap<String, Object> paramMap);

	public HashMap<String, Object> getDevRelationXHDInfo(HashMap<String, Object> paramMap);

	/**
	 * 根据设备类型CODE获取设备类型INFO
	 * 
	 * @param paramMap
	 * @return
	 */
	public TempModel getDeviceType(HashMap<String, Object> paramMap);

	/**
	 * 在修改设备参数之前根据设备类型判断应该删除哪些与之有关联的表 然后=>根据设备ID删除对应关联的参数信息
	 * 
	 * @param devType
	 * @param paramMap
	 * @return
	 */
	public int deleteDevConnectInfo(String devType, HashMap<String, Object> paramMap);

	/**
	 * 更新事件监测设备信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int updateSJJCDevInfo(HashMap<String, Object> paramMap);

	public int updateLLJCDevInfo(HashMap<String, Object> paramMap);

	public int auditDev(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID删除类型为<监控>的设备相关信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteDeviceRelationJKInfo(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID删除类型为<电警>的设备相关信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteDeviceRelationDJInfo(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID删除类型为<诱导>的设备相关信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteDevRelationYDInfo(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID删除类型为<信号灯>的设备相关信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteDevRelationXHDInfo(HashMap<String, Object> paramMap);

	public DeviceAuditProcess IsDevAudit(HashMap<String, Object> paramMap);

	/**
	 * 获取部门名称
	 * 
	 * @param paramMap
	 * @return
	 */
	public TempModel getDeptName(HashMap<String, Object> paramMap);

	/**
	 * 获取创建人部门名称
	 * 
	 * @param paramMap
	 * @return
	 */
	public TempModel getCreatePersonDeptName(HashMap<String, Object> paramMap);

	public List<DeviceBayonetLane> getCardRoadInfobyDevId(HashMap<String, Object> paramMap);

	public List<DeviceBayonetRelevance> getConnectDevIds(HashMap<String, Object> paramMap);

	/**
	 * 删除对设备审核的记录
	 * 
	 * @param devType
	 * @param paramMap
	 * @return
	 */
	public int deleteDeviceAuditProcess(HashMap<String, Object> paramMap);

	/**
	 * 分页查询即将过期设备
	 * 
	 * @param paramMap
	 * @return
	 */

	public Object queryImminentExpiryDevpageList(HashMap<String, Object> paramMap, PageInfo pageInfo);

	/**
	 * 根据路段查询路口
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<TempModel> searchRoadSegite(HashMap<String, Object> paramMap);
	// ——————————————————————————————————————————————————————————————————————————

	public int updateDevRelationXHDInfo(HashMap<String, Object> paramMap);

	public Device queryDeviceById(HashMap<String, Object> paramMap);

	/** 获取下级行政区域 */
	public List<Ckreiscode> kerscodexia(HashMap<String, Object> paramMap);
	/**
	 * 生成路口路段Tree
	 * 
	 * @param dept
	 * @param DeviceList
	 */

	public int initRoadSegiteTree(HashMap<String, Object> paramMap,RoadTree currentArea);
	/**
	 * 查询设备是否存在该设备编号
	 * @param rodCode
	 * @return
	 */
	public Long queryDeviceByDeviceNum(HashMap<String, Object> paramMap);
	
	/**
	 * 根据当前用户的部门信息组装部门树的顶级部门
	 * @param HashMap<String, Object>
	 * @return List<DeptTree>
	 */
	public List<DeptTree> topDept(HttpServletRequest request);
}