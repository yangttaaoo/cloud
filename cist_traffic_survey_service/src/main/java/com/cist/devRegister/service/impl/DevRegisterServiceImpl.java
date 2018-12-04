package com.cist.devRegister.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.devRegister.mapper.DevRegisterMapper;
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
import com.cist.devRegister.model.DeviceLedParam;
import com.cist.devRegister.model.DeviceSignalParam;
import com.cist.devRegister.service.DevRegisterService;
import com.cist.devRegister.util.TempModel;
import com.cist.frame.page.PageInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DevRegisterServiceImpl implements DevRegisterService {
	@Autowired
	private DevRegisterMapper mapper;

	@Override
	public String initDeptTree() throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();
		List<DeptTree> dept = mapper.queryDeptParent();
		for (DeptTree deptTree : dept) {
			map.put("key", deptTree.getKey());
			map.put("title", deptTree.getTitle());
			map.put("selectable", true);
			map.put("isLeaf", false);
			List<DeptTree> childrenList = mapper.queryDeptChildren(deptTree.getDept_pk());
			getDeptChildrenNode(childrenList);
			map.put("children", childrenList);
		}
		return objMapper.writeValueAsString(map);
	}

	public void getDeptChildrenNode(List<DeptTree> childrenList) {

		for (DeptTree dept : childrenList) {
			List<DeptTree> children = mapper.queryDeptChildren(dept.getDept_pk());
			if (children.size() != 0) {
				dept.setChildren(children);
				getDeptChildrenNode(children);
			}
		}
	}

	@Override
	public List<TempModel> queryDevType(String FCT_CODE) {
		return mapper.queryDevType(FCT_CODE);
	}

	@Override
	public List<TempModel> queryDevFunType(String FCT_CODE) {
		return mapper.queryBaseDateByFct_Code(FCT_CODE);
	}

	@Override
	public List<TempModel> queryRoadList() {
		// TODO Auto-generated method stub
		return mapper.queryRoadList();
	}

	@Override
	public List<TempModel> queryOffenceList() {
		// TODO Auto-generated method stub
		return mapper.queryOffenceList();
	}

	@Override
	public int addDeviceInfo(HashMap<String, Object> paramMap) {
		return mapper.addDeviceInfo(paramMap);
	}

	@Override
	public int addDevMaintenance(HashMap<String, Object> paramMap) {
		return mapper.addDevMaintenance(paramMap);
	}

	@Override
	public int addDeviceRelationJKInfo(HashMap<String, Object> paramMap) {

		int cameraParam = mapper.addCameraParam(paramMap);
		return cameraParam;
	}

	@Override
	public int addDevEventAct(HashMap<String, Object> paramMap) {

		@SuppressWarnings("unchecked")
		List<HashMap<String, Object>> actlist = (List<HashMap<String, Object>>) paramMap.get("fk_have_function");
		List<Object> paramSJJCList = new ArrayList<Object>();
		for (HashMap<String, Object> funJC : actlist) {
			if ((boolean) funJC.get("checked")) {
				paramSJJCList.add(funJC.get("value"));
			}
		}
		HashMap<String, Object> IllegalActMap = new HashMap<String, Object>();
		IllegalActMap.put("pk_id", paramMap.get("pk_id"));
		IllegalActMap.put("list", paramSJJCList);
		return mapper.addDevEventAct(IllegalActMap);
	}

	@Override
	public int updateDevMaintenance(HashMap<String, Object> paramMap) {
		return mapper.updateDevMaintenance(paramMap);
	}


	@Override
	public int addDevRelationDJInfo(HashMap<String, Object> paramMap) {
		boolean SUCCESS = true;
		@SuppressWarnings("unchecked")
		// 具备功能 fk_have_function
		List<HashMap<String, Object>> list = (List<HashMap<String, Object>>) paramMap.get("fk_have_function");
		// 根据checked筛选选中的功能IDs => paramList
		List<Object> paramList = new ArrayList<Object>();
		for (HashMap<String, Object> fun : list) {
			if ((boolean) fun.get("checked")) {
				// 根据选中的功能的不同 添加对应功能可能要添加的参数
				// 测速
				if ("CS".equals(fun.get("code"))) {
					int DSL = mapper.addDevSpeedLimit(paramMap);
					if (DSL <= 0)
						SUCCESS = false;
				}
				// 违法抓拍
				if ("WFZP".equals(fun.get("code"))) {
					@SuppressWarnings("unchecked")
					// 获取违法抓拍的违法行为Id fk_illegal_act_id
					List<Integer> IllegalActList = (List<Integer>) paramMap.get("fk_illegal_act_id");
					if (IllegalActList != null&&IllegalActList.size()!=0) {
						// 添加具有违法抓拍的电警设备的抓拍行为
						HashMap<String, Object> IllegalActMap = new HashMap<String, Object>();
						IllegalActMap.put("pk_id", paramMap.get("pk_id"));
						IllegalActMap.put("list", IllegalActList);
						int DO = mapper.addDevOffeCate(IllegalActMap);
						if (DO <= 0)
							SUCCESS = false;
					}

				}
				// 事件检测
//				if ("SJJC".equals(fun.get("code"))) {
//					@SuppressWarnings("unchecked")
//					// 获取事件检测的检测标记List
//					List<HashMap<String, Object>> actlist = (List<HashMap<String, Object>>) paramMap
//							.get("fk_event_act_id");
//
//					// 根据checked属性筛选选中的标记 => paramSJJCList
//					List<Object> paramSJJCList = new ArrayList<Object>();
//					for (HashMap<String, Object> funJC : actlist) {
//						if ((boolean) funJC.get("checked")) {
//							paramSJJCList.add(funJC.get("value"));
//						}
//					}
//					// 当有选中标记的情况 对设备进行添加事件检测标记
//					if (paramSJJCList.size() > 0) {
//						HashMap<String, Object> IllegalActMap = new HashMap<String, Object>();
//						IllegalActMap.put("pk_id", paramMap.get("pk_id"));
//						IllegalActMap.put("list", paramSJJCList);
//						int DA = mapper.addDevEventAct(IllegalActMap);
//						if (DA <= 0)
//							SUCCESS = false;
//					}
//				}
				// 收集设备具有的功能
				paramList.add(fun.get("value"));
			}
		}
		// 添加设备具有的功能
		if (paramList.size() > 0) {
			HashMap<String, Object> FunMap = new HashMap<String, Object>();
			FunMap.put("list", paramList);
			FunMap.put("pk_id", paramMap.get("pk_id"));
			int DF = mapper.addDevHaveFunction1(FunMap);
			if (DF <= 0)
				SUCCESS = false;
		}
		if (SUCCESS)
			return 1;
		else
			return 0;
	}

	@Override
	public int addDevRelationYDInfo(HashMap<String, Object> paramMap) {
		return mapper.addDevLedParam(paramMap);
	}

	@Override
	public Object querypageList(HashMap<String, Object> paramMap, PageInfo pageInfo) {
		// TODO Auto-generated method stub
		return mapper.queryList(paramMap);
	}
	@Override
	public Object queryDevicepageList(HashMap<String, Object> paramMap, PageInfo pageInfo) {
		// TODO Auto-generated method stub
		return mapper.queryDeviceList(paramMap);
	}
	@Override
	public HashMap<String, Object> getDevRelationDJInfo(HashMap<String, Object> paramMap) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<TempModel> list = mapper.getBaseinfo(paramMap);
		resultMap.put("dev", list);
		for (TempModel model : list) {
			if ("CS".equals(model.getCode()))
				resultMap.put("CS", mapper.getDeviceRelationCSInfo(paramMap));
			if ("WFZP".equals(model.getCode())) {
				resultMap.put("WFZP", mapper.getDevRelationWFZPInfo(paramMap));
			}
			if ("SJJC".equals(model.getCode()))
				resultMap.put("SJJC", mapper.getDevRelationSJJCInfo(paramMap));
		}
		return resultMap;
	}

	@Override
	public int updateDeviceInfo(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.updateDeviceInfo(paramMap);
	}



	@Override
	public HashMap<String, Object> getDevRelationJKInfo(HashMap<String, Object> paramMap) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		// 获取设备监控参数
		DeviceCameraParam deviceCameraParam = mapper.getDeviceCameraParam(paramMap);
		resultMap.put("DC", deviceCameraParam);
		return resultMap;
	}

	@Override
	public HashMap<String, Object> getDevRelationYDInfo(HashMap<String, Object> paramMap) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("YdParam", mapper.getDevRelationYDInfo(paramMap));
		return resultMap;
	}

	@Override
	public int addDevRelationXHDInfo(HashMap<String, Object> paramMap) {
		return mapper.addDevRelationXHDInfo(paramMap);
	}

	@Override
	public HashMap<String, Object> getDevRelationXHDInfo(HashMap<String, Object> paramMap) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("XhdParam", mapper.getDevRelationXHDInfo(paramMap));
		return resultMap;
	}

	@Override
	public int updateDevRelationXHDInfo(HashMap<String, Object> paramMap) {
		return mapper.updateDevRelationXHDInfo(paramMap);
	}

	@Override
	public DeviceAuditProcess IsDevAudit(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.getDeviceAuditProcessByDevId(paramMap);
	}

	@Override
	public int auditDev(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.auditDev(paramMap);
	}

	@Override
	public TempModel getDeptName(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.getDeptName(paramMap);
	}

	@Override
	public List<TempModel> queryDeviceInfo() {

		return mapper.queryDeviceInfo();
	}

	@Override
	public int addDevRelationKKInfo(HashMap<String, Object> paramMap) {
		// 添加卡口参数 => 卡口类型、卡口性质等...
		boolean SUCCESS = true;
		Object bayonet_type = paramMap.get("bayonet_type");
		if(bayonet_type instanceof HashMap) {
			paramMap.put("bayonet_type", ((HashMap<?, ?>) bayonet_type).get("code"));
		}else if(bayonet_type instanceof String) {
			paramMap.put("bayonet_type", null);
		}
		if("-1".equals((String)paramMap.get("bayonet_nature"))) {
			paramMap.put("bayonet_nature", null);
		}
		int BP = mapper.addDeviceBayonetParam(paramMap);
		if (BP <= 0)
			SUCCESS = false;
		@SuppressWarnings("unchecked")
		// 具有的功能List fk_have_function
		List<HashMap<String, Object>> list = (List<HashMap<String, Object>>) paramMap.get("fk_have_function");
		// 根据checked筛选选中的功能IDs => paramList
		List<Object> paramList = new ArrayList<Object>();
		for (HashMap<String, Object> fun : list) {
			if ((boolean) fun.get("checked")) {
				paramList.add(fun.get("value"));
			}
		}
	
		// 根据设备ID和对应的功能ID 为设备添加功能
		if (paramList.size() > 0) {
			HashMap<String, Object> FunMap = new HashMap<String, Object>();
			FunMap.put("list", paramList);
			FunMap.put("pk_id", paramMap.get("pk_id"));
			int DF = mapper.addDevHaveFunction1(FunMap);
			if (DF <= 0)
				SUCCESS = false;
		}

		// 获取卡口性质参数的值 0 上行单向卡口 1 下行单向卡口 2 双向卡口
		String nature = (String) paramMap.get("bayonet_nature");
		List<HashMap<String, Object>> cardRoadList = new ArrayList<HashMap<String, Object>>();

		if ("0".equals(nature) || "2".equals(nature)) {
			// 收集上行车道的参数
			@SuppressWarnings("unchecked")
			List<HashMap<String, Object>> object = (List<HashMap<String, Object>>) paramMap.get("topRoad");
			cardRoadList.addAll(object);
		}
		if ("1".equals(nature) || "2".equals(nature)) {
			// 收集下行车道的参数
			@SuppressWarnings("unchecked")
			List<HashMap<String, Object>> object = (List<HashMap<String, Object>>) paramMap.get("bottomRoad");
			cardRoadList.addAll(object);
		}

		// 包含车道信息及关联设备的IDs<Param:devList> =>cardRoadList
		for (HashMap<String, Object> hashMap : cardRoadList) {
			hashMap.put("device_id", paramMap.get("pk_id"));
			// 添加一条车道信息
			int DBL = mapper.addDeviceBayonetLane1(hashMap);
			// 添加关联设备
			if (DBL > 0) {
				if( ((List) hashMap.get("devList")).size() !=0  ) {
					int DBR = mapper.addDeviceBayonetRelevance(hashMap);
					if (DBR <= 0)SUCCESS = false;
					else  SUCCESS = true;
				} 
				}
				
		}
		if (SUCCESS)
			return 1;
		else
			return 0;

	}

	@Override
	public List<DeviceBayonetLane> getCardRoadInfobyDevId(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.getCardRoadInfobyDevId(paramMap);
	}

	@Override
	public List<DeviceBayonetRelevance> getConnectDevIds(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.getConnectDevIds(paramMap);
	}

	@Override
	public HashMap<String, Object> getDevRelationKKInfo(HashMap<String, Object> paramMap) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("KKInfo", mapper.getKKDevParamInfo(paramMap));
		map.put("devFun", mapper.getBaseinfo(paramMap));
		return map;
	}


	

	@Override
	public int deleteDeviceInfo(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.deleteDeviceInfo(paramMap);
	}

	@Override
	public int deleteDevMaintenance(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.deleteDevMaintenance(paramMap);
	}

	@Override
	public int deleteDeviceRelationJKInfo(HashMap<String, Object> paramMap) {
		
		return mapper.deleteCameraParam(paramMap);
	}

	@Override
	public int deleteDeviceRelationKKInfo(HashMap<String, Object> paramMap) {
		mapper.deleteDeviceKKParam(paramMap);
		mapper.deleteDevHaveFunction(paramMap);
		mapper.deleteDevConnectCardRoad(paramMap);
		mapper.deleteCardRoadConnectDev(paramMap);
		return 0;
	}

	@Override
	public int deleteDeviceRelationDJInfo(HashMap<String, Object> paramMap) {
		mapper.deleteCSParam(paramMap);
		mapper.deleteWFZPParam(paramMap);
		mapper.deleteDevHaveFunction(paramMap);
		return 0;
	}

	@Override
	public int deleteDevRelationYDInfo(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.deleteDevRelationYDInfo(paramMap);
	}

	@Override
	public int deleteDevRelationXHDInfo(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.deleteDevRelationXHDInfo(paramMap);
	}

	@Override
	public Device getDevice(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.getDevice(paramMap);
	}

	@Override
	public int deleteDevConnectInfo(String devType, HashMap<String, Object> paramMap) {
		switch (devType) {
		case "JK":
			return this.deleteDeviceRelationJKInfo(paramMap);
		case "KKSB":
			return this.deleteDeviceRelationDJInfo(paramMap);
		case "DJ":
			return this.deleteDeviceRelationDJInfo(paramMap);
		case "WT":
			return this.deleteDeviceRelationDJInfo(paramMap);
		case "SJJC":
			return mapper.deleteDevEventAct(paramMap);
		case "LLJC":
			return mapper.deleteDevFlowMonitor(paramMap);	
		case "LED":
			return this.deleteDevRelationYDInfo(paramMap);
		case "XHD":
			return this.deleteDevRelationXHDInfo(paramMap);
		default:
			return 1;
		}
	}

	@Override
	public int deleteDeviceAuditProcess(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.deleteDeviceAuditProcess(paramMap);
	}

	@Override
	public TempModel getDeviceType(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.getDeviceType(paramMap);
	}

	@Override
	public int addDevFlowMonitor(HashMap<String, Object> paramMap) {


		@SuppressWarnings("unchecked")
		List<HashMap<String, Object>> actlist = (List<HashMap<String, Object>>) paramMap.get("fk_have_function");
		List<Object> paramSJJCList = new ArrayList<Object>();
		for (HashMap<String, Object> funJC : actlist) {
			if ((boolean) funJC.get("checked")) {
				paramSJJCList.add(funJC.get("value"));
			}
		}
		HashMap<String, Object> IllegalActMap = new HashMap<String, Object>();
		IllegalActMap.put("pk_id", paramMap.get("pk_id"));
		IllegalActMap.put("list", paramSJJCList);
		return mapper.addDevFlowMonitor(IllegalActMap);
	
	}

	@Override
	public HashMap<String, Object> getDevRelationSJJCInfo(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<DeviceEventAct> list = mapper.getDevRelationSJJCInfo(paramMap);
		resultMap.put("dev", list);
		return resultMap;
	}

	@Override
	public HashMap<String, Object> getDevRelationLLJCInfo(HashMap<String, Object> paramMap) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<DeviceFlowAct> list = mapper.getDevRelationLLJCInfo(paramMap);
		resultMap.put("dev", list);
		return resultMap;
	}

	@Override
	public int updateSJJCDevInfo(HashMap<String, Object> paramMap) {
		return this.addDevEventAct(paramMap);
	}
	@Override
	public int updateLLJCDevInfo(HashMap<String, Object> paramMap) {
	
		return this.addDevFlowMonitor(paramMap);
	}

	@Override
	public Object queryImminentExpiryDevpageList(HashMap<String, Object> paramMap, PageInfo pageInfo) {
		// TODO Auto-generated method stub
		return mapper.queryImminentExpiryDevList(paramMap);
	}

	@Override
	public List<TempModel> searchRoadSegite(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.searchRoadSegite(paramMap);
	}

	@Override
	public Device queryDeviceById(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.queryDeviceById(paramMap);
	}

	@Override
	public List<Ckreiscode> kerscodexia(HashMap<String, Object> paramMap) {
		return mapper.kerscodexia(paramMap);
	}
}
