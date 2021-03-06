package com.cist.devRegister.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.devRegister.model.Ckreiscode;
import com.cist.devRegister.model.DeptTree;
import com.cist.devRegister.model.Device;
import com.cist.devRegister.model.DeviceAuditProcess;
import com.cist.devRegister.model.DeviceBayonetLane;
import com.cist.devRegister.model.DeviceBayonetParam;
import com.cist.devRegister.model.DeviceBayonetRelevance;
import com.cist.devRegister.model.DeviceCameraParam;
import com.cist.devRegister.model.DeviceEventAct;
import com.cist.devRegister.model.DeviceFlowAct;
import com.cist.devRegister.model.DeviceIllegalAct;
import com.cist.devRegister.model.DeviceLedParam;
import com.cist.devRegister.model.DeviceList;
import com.cist.devRegister.model.DeviceSignalParam;
import com.cist.devRegister.model.DeviceSpeedLimit;
import com.cist.devRegister.util.TempModel;

public interface DevRegisterMapper {
	/**
	 * 查询部门<父级>
	 * @return
	 */
	public List<DeptTree> queryDeptParent();
	/**
	 * 根据父级部门ID查询<子部门>
	 * @return
	 */
	public List<DeptTree> queryDeptChildren(int parentId);
	/**
	 * 在数据字典中根据<索引>找到对应的设备类型
	 * @return
	 */
	public List<TempModel> queryBaseDateByFct_Code(String FCT_CODE);
	public List<TempModel> queryDevType(String FCT_CODE);
	/**
	 * 获取卡口可关联的设备List
	 * @return
	 */
	public List<TempModel> queryDeviceInfo();
	/**
	 * 获取所有道路List
	 * 
	 * @return
	 */
	public List<TempModel> queryRoadList();
	/**
	 * 添加设备基础信息<JCSJ_Device>
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addDeviceInfo(HashMap<String, Object> paramMap);
	/**
	 * 添加基础设备厂商维护信息<JCSJ_DEVICE_MAINTENANCE>
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addDevMaintenance(HashMap<String, Object> paramMap);
	/**
	 * 分页查询设备√
	 * 
	 * @param paramMap
	 * @return
	 */

	public List<Device> queryList(HashMap<String, Object> paramMap);



	public List<DeviceList> queryDeviceList(HashMap<String, Object> paramMap);

	/**
	 * <违法行为>List√
	 * 
	 * @return
	 */
	public List<TempModel> queryOffenceList();



	// 设备备案-添加
	



	/**
	 * 添加摄像头<监控>参数√
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addCameraParam(HashMap<String, Object> paramMap);

	/**
	 * 添加摄像头<监控><事件监听>标记√
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addDevEventAct(HashMap<String, Object> paramMap);

	/**
	 * 添加<设备>具有的<功能>√
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addDevHaveFunction1(HashMap<String, Object> paramMap);

	/* public int addDevHaveFunction(HashMap<String, Object> paramMap); */
	/**
	 * 添加<卡口>相关<参数>√
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addDeviceBayonetParam(HashMap<String, Object> paramMap);

	/**
	 * 添加与<卡口>相关联的<车道>信息√
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addDeviceBayonetLane1(HashMap<String, Object> paramMap);

	/**
	 * 添加与<卡口>相关联的某一条<车道>所关联的<设备>List<Param:devList>√
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addDeviceBayonetRelevance(HashMap<String, Object> paramMap);

	/**
	 * 添加具有<测速>功能设备<电警>的<测速参数>√
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addDevSpeedLimit(HashMap<String, Object> paramMap);

	/**
	 * 添加具有<抓拍违反行为>功能设备<电警>的抓拍的<违法行为>√
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addDevOffeCate(HashMap<String, Object> paramMap);

	/**
	 * 添加<诱导屏>类型的设备的<参数>信息√
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addDevLedParam(HashMap<String, Object> paramMap);

	/**
	 * 添加<信号灯>类型的设备的<参数>信息√
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addDevRelationXHDInfo(HashMap<String, Object> paramMap);

	// 获取详情查询信息
	/**
	 * 获取<监控>类型的设备的<参数>信息√
	 * 
	 * @param paramMap
	 * @return
	 */
	public DeviceCameraParam getDeviceCameraParam(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID获取事件检测List√
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<DeviceEventAct> getDevRelationSJJCInfo(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID获取卡口参数信息√
	 * 
	 * @param paramMap
	 * @return
	 */
	public DeviceBayonetParam getKKDevParamInfo(HashMap<String, Object> paramMap);

	/**
	 * 根据卡口ID获取与之关联的车道信息√
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<DeviceBayonetLane> getCardRoadInfobyDevId(HashMap<String, Object> paramMap);

	/**
	 * 根据卡口Id和车道ID获取与之关联的设备IDs√
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<DeviceBayonetRelevance> getConnectDevIds(HashMap<String, Object> paramMap);

	/**
	 * 根据设备Id获取设备具有的功能信息√
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<TempModel> getBaseinfo(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID获取测速参数信息√
	 * 
	 * @param paramMap
	 * @return
	 */
	public DeviceSpeedLimit getDeviceRelationCSInfo(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID获取违法抓拍违反行为的参数信息√
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<DeviceIllegalAct> getDevRelationWFZPInfo(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID获取诱导屏参数信息√
	 * 
	 * @param paramMap
	 * @return
	 */
	public DeviceLedParam getDevRelationYDInfo(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID获取信号灯参数信息√
	 * 
	 * @param paramMap
	 * @return
	 */
	public DeviceSignalParam getDevRelationXHDInfo(HashMap<String, Object> paramMap);

	/**
	 * 根据部门ID获取部门信息√
	 * 
	 * @param paramMap
	 * @return
	 */
	public TempModel getDeptName(HashMap<String, Object> paramMap);

	// 更新信息删除旧数据
	/**
	 * 更新设备基础信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int updateDeviceInfo(HashMap<String, Object> paramMap);

	/**
	 * 更新设备厂商维护信息√
	 * 
	 * @param paramMap
	 * @return
	 */
	public int updateDevMaintenance(HashMap<String, Object> paramMap);

	/**
	 * 更新设备<监控>相关信息√
	 * 
	 * @param paramMap
	 * @return
	 */
	public int updateCameraParam(HashMap<String, Object> paramMap);

	/**
	 * 更新设备测速参数信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int updateDevSpeedLimit(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID删除设备违法抓拍的违法行为IDS
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteDevOffeCate(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID更新诱导参数相关信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int updateDevRelationYDInfo(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID更新信号灯参数相关信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int updateDevRelationXHDInfo(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID获取审核过程记录
	 * 
	 * @param paramMap
	 * @return
	 */
	public DeviceAuditProcess getDeviceAuditProcessByDevId(HashMap<String, Object> paramMap);

	/**
	 * 审核设备备案信息 =>添加审核过程记录
	 * 
	 * @param paramMap
	 * @return
	 */
	public int auditDev(HashMap<String, Object> paramMap);

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
	 * 根据<监控>设备ID删除摄像头参数信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteCameraParam(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID删除事件检测信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteDevEventAct(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID删除<卡口>相关信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteDeviceKKParam(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID删除具备功能信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteDevHaveFunction(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID删除与卡口关联的车道信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteDevConnectCardRoad(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID删除与卡口关联的设备信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteCardRoadConnectDev(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID删除测速参数信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteCSParam(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID删除违法抓拍参数信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteWFZPParam(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID删除诱导信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteDevRelationYDInfo(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID删除信号灯信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteDevRelationXHDInfo(HashMap<String, Object> paramMap);

	/**
	 * 根据设备ID查询设备信息表
	 * 
	 * @param paramMap
	 * @return
	 */
	public Device getDevice(HashMap<String, Object> paramMap);

	/**
	 * 删除对设备审核的记录
	 * 
	 * @param devType
	 * @param paramMap
	 * @return
	 */
	public int deleteDeviceAuditProcess(HashMap<String, Object> paramMap);

	/**
	 * 根据设备类型CODE获取设备类型INFO
	 * 
	 * @param paramMap
	 * @return
	 */
	public TempModel getDeviceType(HashMap<String, Object> paramMap);

	/**
	 * 添加与<卡口>相关联的<车道>信息 =>废弃=>批量不成功 未启用
	 * 
	 * @param paramMap
	 * @return
	 */
	/* public int addDeviceBayonetLane(HashMap<String, Object> paramMap); */
	/**
	 * 获取KK信息废弃
	 * 
	 * @param paramMap
	 * @return
	 */
	/*
	 * public DeviceBayonetParam getKKParamInfo(HashMap<String, Object> paramMap);
	 */

	/*
	 * public List<DeviceBayonetLane> getKKCardRoadInfo(HashMap<String, Object>
	 * paramMap);
	 */

	/* public int updateDeviceKKParam(HashMap<String, Object> paramMap); */

	/* public int updateDeviceBayonetLane(HashMap<String, Object> paramMap); */

	/* public int updateDeviceBayonetRelevance(HashMap<String, Object> paramMap); */
	
	public int addDevFlowMonitor(HashMap<String, Object> paramMap);
	public int deleteDevFlowMonitor(HashMap<String, Object> paramMap);
	/**
	 * 根据设备ID获取流量检测List√
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<DeviceFlowAct> getDevRelationLLJCInfo(HashMap<String, Object> paramMap);
	/**
	 * 分页查询即将过期设备
	 * 
	 * @param paramMap
	 * @return
	 */

	public List<Device> queryImminentExpiryDevList(HashMap<String, Object> paramMap);
	/**
	 * 根据路段查询路口
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<TempModel>   searchRoadSegite(HashMap<String, Object> paramMap);
	
	
	public Device queryDeviceById(HashMap<String, Object> paramMap);
	/**获取下级行政区域*/
	public List<Ckreiscode> kerscodexia(HashMap<String, Object> paramMap);
}
