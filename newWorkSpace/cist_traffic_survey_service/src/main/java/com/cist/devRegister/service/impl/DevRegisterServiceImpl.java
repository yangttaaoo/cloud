package com.cist.devRegister.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.devRegister.mapper.DevRegisterMapper;
import com.cist.devRegister.model.AdministrativeAreasTree;
import com.cist.devRegister.model.Ckreiscode;
import com.cist.devRegister.model.DeptTree;
import com.cist.devRegister.model.Device;
import com.cist.devRegister.model.DeviceAuditProcess;
import com.cist.devRegister.model.DeviceBayonetLane;
import com.cist.devRegister.model.DeviceBayonetRelevance;
import com.cist.devRegister.model.DeviceCameraParam;
import com.cist.devRegister.model.DeviceEventAct;
import com.cist.devRegister.model.DeviceFlowAct;
import com.cist.devRegister.model.RoadTree;
import com.cist.devRegister.service.DevRegisterService;
import com.cist.devRegister.util.TempModel;
import com.cist.frame.page.PageInfo;
import com.cist.roadsection.model.DeptInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DevRegisterServiceImpl implements DevRegisterService {
	@Autowired
	private DevRegisterMapper mapper;

	@Override
	public String initDeptTree(HttpServletRequest request) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();
		List<DeptTree> dept = topDept(request);
//				mapper.queryDeptParent();
		for (DeptTree deptTree : dept) {
			map.put("key", deptTree.getKey());
			map.put("title", deptTree.getTitle());
			map.put("selectable", true);
			map.put("isLeaf", false);
			map.put("expanded", true);
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

		return mapper.queryRoadList();
	}

	@Override
	public List<TempModel> queryOffenceList() {

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
		int addDeviceCameraGb28181 = mapper.addDeviceCameraGb28181(paramMap);
		return cameraParam > 0 ? addDeviceCameraGb28181 : 0;
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
					if (IllegalActList != null && IllegalActList.size() != 0) {
						// 添加具有违法抓拍的电警设备的抓拍行为
						HashMap<String, Object> IllegalActMap = new HashMap<String, Object>();
						IllegalActMap.put("pk_id", paramMap.get("pk_id"));
						IllegalActMap.put("list", IllegalActList);
						int DO = mapper.addDevOffeCate(IllegalActMap);
						if (DO <= 0)
							SUCCESS = false;
					}

				}
				// 视频 =》摄像头国标参数
				if ("SP".equals(fun.get("code"))) {
					int addDeviceCameraGb28181 = mapper.addDeviceCameraGb28181(paramMap);
					if (addDeviceCameraGb28181 <= 0)
						SUCCESS = false;
				}
				// 事件检测
				// if ("SJJC".equals(fun.get("code"))) {
				// @SuppressWarnings("unchecked")
				// // 获取事件检测的检测标记List
				// List<HashMap<String, Object>> actlist = (List<HashMap<String, Object>>)
				// paramMap
				// .get("fk_event_act_id");
				//
				// // 根据checked属性筛选选中的标记 => paramSJJCList
				// List<Object> paramSJJCList = new ArrayList<Object>();
				// for (HashMap<String, Object> funJC : actlist) {
				// if ((boolean) funJC.get("checked")) {
				// paramSJJCList.add(funJC.get("value"));
				// }
				// }
				// // 当有选中标记的情况 对设备进行添加事件检测标记
				// if (paramSJJCList.size() > 0) {
				// HashMap<String, Object> IllegalActMap = new HashMap<String, Object>();
				// IllegalActMap.put("pk_id", paramMap.get("pk_id"));
				// IllegalActMap.put("list", paramSJJCList);
				// int DA = mapper.addDevEventAct(IllegalActMap);
				// if (DA <= 0)
				// SUCCESS = false;
				// }
				// }
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
	public Object queryDevicepageList(HashMap<String, Object> paramMap, PageInfo pageInfo) {
		return mapper.SecurityByfk_dept_idTocode(paramMap);
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
			if ("SP".equals(model.getCode()))
				resultMap.put("SP", mapper.getDevRelationSPInfo(paramMap));
		}
		return resultMap;
	}

	@Override
	public int updateDeviceInfo(HashMap<String, Object> paramMap) {

		return mapper.updateDeviceInfo(paramMap);
	}

	@Override
	public HashMap<String, Object> getDevRelationJKInfo(HashMap<String, Object> paramMap) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		// 获取设备监控参数
		DeviceCameraParam deviceCameraParam = mapper.getDeviceCameraParam(paramMap);
		resultMap.put("DC", deviceCameraParam);
		// 视频国标参数
		resultMap.put("SP", mapper.getDevRelationSPInfo(paramMap));
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
		return mapper.getDeviceAuditProcessByDevId(paramMap);
	}

	@Override
	public int auditDev(HashMap<String, Object> paramMap) {

		return mapper.auditDev(paramMap);
	}

	@Override
	public TempModel getDeptName(HashMap<String, Object> paramMap) {

		return mapper.getDeptName(paramMap);
	}

	@Override
	public List<TempModel> queryDeviceInfo(HashMap<String, Object> paramMap) {

		return mapper.queryDeviceInfo(paramMap);
	}

	@Override
	public int addDevRelationKKInfo(HashMap<String, Object> paramMap) {
		// 添加卡口参数 => 卡口类型、卡口性质等...
		boolean SUCCESS = true;
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
		HashMap<String, Object> cardRoadDirection = new HashMap<String, Object>();

		if ("1".equals(nature) || "3".equals(nature)) {
			// 收集上行车道的参数
			@SuppressWarnings("unchecked")
			List<HashMap<String, Object>> object = (List<HashMap<String, Object>>) paramMap.get("topRoad");
			@SuppressWarnings("unchecked")
			HashMap<String, Object> topDirectionObject = (HashMap<String, Object>) paramMap.get("topDirectionObject");
			cardRoadDirection.putAll(topDirectionObject);
			cardRoadList.addAll(object);
		}
		if ("2".equals(nature) || "3".equals(nature)) {
			// 收集下行车道的参数
			@SuppressWarnings("unchecked")
			List<HashMap<String, Object>> object = (List<HashMap<String, Object>>) paramMap.get("bottomRoad");
			@SuppressWarnings("unchecked")
			HashMap<String, Object> bottomDirectionObject = (HashMap<String, Object>) paramMap
					.get("bottomDirectionObject");
			cardRoadDirection.putAll(bottomDirectionObject);

			cardRoadList.addAll(object);
		}

		Object bayonet_type = paramMap.get("bayonet_type");
		cardRoadDirection.put("bayonet_nature", nature);
		if (bayonet_type instanceof HashMap) {
			cardRoadDirection.put("bayonet_type", ((HashMap<?, ?>) bayonet_type).get("code"));
		} else if (bayonet_type instanceof String) {
			cardRoadDirection.put("bayonet_type", null);
		}
		if ("-1".equals((String) paramMap.get("bayonet_nature"))) {
			cardRoadDirection.put("bayonet_nature", null);
		}
		cardRoadDirection.put("pk_id", paramMap.get("pk_id"));
		// 添加卡口参数信息
		int DBP = mapper.addDeviceBayonetParam(cardRoadDirection);
		if (DBP <= 0)
			SUCCESS = false;
		else
			SUCCESS = true;
		// 包含车道信息及关联设备的IDs<Param:devList> =>cardRoadList
		for (HashMap<String, Object> hashMap : cardRoadList) {
			hashMap.put("device_id", paramMap.get("pk_id"));
			// 添加一条车道信息
			int DBL = mapper.addDeviceBayonetLane1(hashMap);
			// 添加关联设备
			if (DBL > 0) {
				if (((List) hashMap.get("devList")).size() != 0) {
					int DBR = mapper.addDeviceBayonetRelevance(hashMap);
					if (DBR <= 0)
						SUCCESS = false;
					else
						SUCCESS = true;
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
		return mapper.getCardRoadInfobyDevId(paramMap);
	}

	@Override
	public List<DeviceBayonetRelevance> getConnectDevIds(HashMap<String, Object> paramMap) {
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
		return mapper.deleteDeviceInfo(paramMap);
	}

	@Override
	public int deleteDevMaintenance(HashMap<String, Object> paramMap) {
		return mapper.deleteDevMaintenance(paramMap);
	}

	@Override
	public int deleteDeviceRelationJKInfo(HashMap<String, Object> paramMap) {
		mapper.deleteSPParam(paramMap);
		mapper.deleteCameraParam(paramMap);
		return 0;
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
		mapper.deleteSPParam(paramMap);
		mapper.deleteDevHaveFunction(paramMap);
		return 0;
	}

	@Override
	public int deleteDevRelationYDInfo(HashMap<String, Object> paramMap) {
		return mapper.deleteDevRelationYDInfo(paramMap);
	}

	@Override
	public int deleteDevRelationXHDInfo(HashMap<String, Object> paramMap) {
		return mapper.deleteDevRelationXHDInfo(paramMap);
	}

	@Override
	public Device getDevice(HashMap<String, Object> paramMap) {
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
		return mapper.deleteDeviceAuditProcess(paramMap);
	}

	@Override
	public TempModel getDeviceType(HashMap<String, Object> paramMap) {
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
		return mapper.queryImminentExpiryDevList(paramMap);
	}

	@Override
	public List<TempModel> searchRoadSegite(HashMap<String, Object> paramMap) {

		return mapper.searchRoadSegite(paramMap);
	}

	@Override
	public Device queryDeviceById(HashMap<String, Object> paramMap) {
		return mapper.queryDeviceById(paramMap);
	}

	@Override
	public List<Ckreiscode> kerscodexia(HashMap<String, Object> paramMap) {
		return mapper.kerscodexia(paramMap);
	}

	@Override
	public TempModel getCreatePersonDeptName(HashMap<String, Object> paramMap) {
		return mapper.getCreatePersonDeptName(paramMap);
	}

	@Override
	public int initRoadSegiteTree(HashMap<String, Object> paramMap, RoadTree currentArea) {
		int roadSegiteSize = 0;
		paramMap.put("tbek_code", currentArea.getKey());
		List<RoadTree> allRoad = mapper.queryAllRoad(paramMap);
		// currentArea.getChildren().addAll(allRoad);72035
		for (RoadTree road : allRoad) {
			if (mapper.queryExistRoad(road.getKey(), (String) paramMap.get("deviceFlag")) > 0) {
				road.setIsLeaf(false);
				road.setIsRoad(true);
				paramMap.put("code", road.getKey());
				road.setChildren(mapper.queryRoadSegiteByRoadCode(paramMap));
				// select
				// substr('64046-64041',0,instr('64046-64041','-')-1),substr('64046-64041',instr('64046-64041','-')+1,length('64046-64041'))
				// from dual;
				int tempSize = road.getChildren().size();
				roadSegiteSize += tempSize;
				if (tempSize > 0) {

					currentArea.getChildren().add(road);
				}
			}
		}

		return roadSegiteSize;
	}

	@Override
	public List<AdministrativeAreasTree> initAdministrativeAreasTree() {
		try {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("parent_pk", null);
			List<AdministrativeAreasTree> perentList = mapper.queryAdministrativeAreas(paramMap);
			this.getAdministrativeAreasChildren(perentList, paramMap);
			return perentList;
		} catch (Exception e) {
			return new ArrayList<AdministrativeAreasTree>();
		}
	}

	@Override
	public void getAdministrativeAreasChildren(List<AdministrativeAreasTree> perentList,
			HashMap<String, Object> paramMap) {
		for (AdministrativeAreasTree area : perentList) {
			paramMap.put("parent_pk", area.getPk());
			List<AdministrativeAreasTree> childrenNodes = mapper.queryAdministrativeAreas(paramMap);
			area.setChildren(childrenNodes);
			if (childrenNodes.size() != 0) {
				this.getAdministrativeAreasChildren(childrenNodes, paramMap);
			} else {
				area.setIsLeaf(true);
			}
		}

	}

	@Override
	public int gettAreaRoadChildren(RoadTree currentNode, List<RoadTree> childrenList, HashMap<String, Object> paramMap,
			int currentNodeChildNums) {
		for (RoadTree area : childrenList) {
			if (null != area.getPk()) {
				if (currentNode == null)
					area.setExpanded(true);
				area.setIsArea(true);
				area.setIsLeaf(false);
				paramMap.put("tbek_code", null);
				paramMap.put("parent_pk", area.getPk());
				List<RoadTree> childrenNodes = mapper.queryAdministrativeAreas1(paramMap);
				if (null == area.getChildren())
					area.setChildren(new ArrayList<RoadTree>());
				int currentNodeLoukouSize = this.initRoadSegiteTree(paramMap, area);
				if (childrenNodes.size() != 0) {
					if (currentNode != null) {
						if (currentNodeLoukouSize > 0) {//该子部门有设备就直接添加为父部门children
							if (currentNode.getChildren() == null) {
								currentNode.setChildren(new ArrayList<RoadTree>());
							}
							currentNode.getChildren().add(area);
						}
						}
					int childrenDeviceNum = this.gettAreaRoadChildren(area, childrenNodes, paramMap, 0);
					if (childrenDeviceNum > 0) {
						if (currentNode != null) {
							if (currentNode.getChildren() == null) {
								currentNode.setChildren(new ArrayList<RoadTree>());
							}
							//判断是否已经添加为children,若没有就添加
							List<RoadTree> children = currentNode.getChildren();
							boolean contains = children.contains(area);
							if(!contains) 
								currentNode.getChildren().add(area);
						}
					}
				} else {
					area.setIsLeaf(false);
					currentNodeChildNums += currentNodeLoukouSize;
					if (currentNodeLoukouSize > 0) {
						if (currentNode != null) {
							if (currentNode != null && currentNode.getChildren() == null) {
								currentNode.setChildren(new ArrayList<RoadTree>());
							}
							currentNode.getChildren().add(area);
						}
					}
				}
			}
		}
		return 0;
	}

	@Override
	public List<TempModel> queryRoadList1(HashMap<String, Object> paramMap) {
		return mapper.queryRoadList1(paramMap);
	}

	@Override
	public List<RoadTree> initAreaRoadTree(HashMap<String, Object> paramMap) {
		List<RoadTree> areas = mapper.queryAdministrativeAreas1(paramMap);
		this.gettAreaRoadChildren(null, areas, paramMap, 0);
		return areas;
	}

	@Override
	public Long queryDeviceByDeviceNum(HashMap<String, Object> paramMap) {
		return mapper.queryDeviceByDeviceNum(paramMap);
	}

	@Override
	public List<DeptTree> topDept(HttpServletRequest request) {
		// 当前用户的部门 用于部门权限设置
		HttpSession session = request.getSession();
		Map<String,Object> map = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		List<DeptTree> departinfo = new ArrayList<DeptTree>();
		DeptTree  dept = new DeptTree();
		dept.setKey(map.get("sypi_dept_code")==null?null:map.get("sypi_dept_code").toString());
		dept.setDept_pk(map.get("sypi_dept_pk")==null?null:Integer.valueOf(map.get("sypi_dept_pk").toString()));
		dept.setTitle(map.get("sypi_dept_name")==null?null:map.get("sypi_dept_name").toString());
		departinfo.add(dept);
		return departinfo;
	}

}
