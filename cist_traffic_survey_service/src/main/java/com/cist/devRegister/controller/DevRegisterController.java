package com.cist.devRegister.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cist.devRegister.model.Ckreiscode;
import com.cist.devRegister.model.Device;
import com.cist.devRegister.model.DeviceList;
import com.cist.devRegister.service.DevRegisterService;
import com.cist.devRegister.util.TempModel;
import com.cist.frame.page.PageInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/devRegister")
public class DevRegisterController {
	@Autowired
	private DevRegisterService service;

	@RequestMapping("/initQueryCondition")
	public HashMap<String, Object> initQueryCondition() {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		String initDeptTree = null;
		try {
			initDeptTree = service.initDeptTree();
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultMap.put("devType", service.queryDevType("M001"));
		List<TempModel> queryDevFunType = service.queryDevFunType("G999");
		// 0 拦截 1 测速 2 视频 3 违法抓拍 4 特征图片 5 事件检测 6 流量检测 7 区间测速
		List<TempModel> KKSBNewlist = new ArrayList<TempModel>();
		List<TempModel> DJNewlist = new ArrayList<TempModel>();
		List<TempModel> WTNewlist = new ArrayList<TempModel>();
		if (null != queryDevFunType) {
			List<Object> KKSBList = Arrays.asList(new Object[] { 1, 2, 3, 4 });
			List<Object> DJList = Arrays.asList(new Object[] { 2, 3, 4 });
			List<Object> WTList = Arrays.asList(new Object[] { 2, 3 });
			for (int i = 0; i <= queryDevFunType.size(); i++) {
				if (KKSBList.contains(i))
					KKSBNewlist.add(queryDevFunType.get(i));
				if (DJList.contains(i))
					DJNewlist.add(queryDevFunType.get(i));
				if (WTList.contains(i))
					WTNewlist.add(queryDevFunType.get(i));
			}

		}
		resultMap.put("kksb_fun", KKSBNewlist);
		resultMap.put("dj_fun", DJNewlist);
		resultMap.put("wt_fun", WTNewlist);
		resultMap.put("eventType", service.queryDevFunType("S551"));
		resultMap.put("P010", service.queryDevFunType("P010"));
		resultMap.put("C011", service.queryDevFunType("C011"));
		resultMap.put("G012", service.queryDevFunType("G012"));
		resultMap.put("M013", service.queryDevFunType("M013"));
		resultMap.put("Y014", service.queryDevFunType("Y014"));
		resultMap.put("P015", service.queryDevFunType("P015"));
		resultMap.put("YY01", service.queryDevFunType("YY01"));
		resultMap.put("YF02", service.queryDevFunType("YF02"));
		resultMap.put("YD03", service.queryDevFunType("YD03"));
		resultMap.put("YX04", service.queryDevFunType("YX04"));
		resultMap.put("YX05", service.queryDevFunType("YX05"));
		resultMap.put("LLJC", service.queryDevFunType("L552"));
		resultMap.put("road", service.queryRoadList());
		resultMap.put("offence", service.queryOffenceList());
		resultMap.put("dept", initDeptTree);
		return resultMap;
	}

	@RequestMapping("/addDevRegister")
	@Transactional
	public int addDevRegister(@RequestBody HashMap<String, Object> paramMap) {
		int addD = service.addDeviceInfo(paramMap);
		int addDM = service.addDevMaintenance(paramMap);
		if (addD > 0 && addDM > 0) {
			String devType = (String) paramMap.get("fk_device_type");
			if (null != devType) {
				switch (devType) {
				case "JK":
					return service.addDeviceRelationJKInfo(paramMap);
				case "KKSB":
					return service.addDevRelationDJInfo(paramMap);
				case "DJ":
					return service.addDevRelationDJInfo(paramMap);
				case "WT":
					return service.addDevRelationDJInfo(paramMap);
				case "SJJC":
					return service.addDevEventAct(paramMap);
				case "LLJC":
					return service.addDevFlowMonitor(paramMap);
				case "XHD":
					return service.addDevRelationXHDInfo(paramMap);
				case "LED":
					return service.addDevRelationYDInfo(paramMap);
				default:
					return 1;
				}
			}
		}
		return 1;

	}

	@RequestMapping("queryList")
	public PageInfo<Device> queryList(@RequestBody HashMap<String, Object> paramMap) {
		@SuppressWarnings("rawtypes")
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		pageInfo.setPageNum(Integer.parseInt(paramMap.get("currentPage").toString()));
		@SuppressWarnings("unchecked")
		PageInfo<Device> querypageList = (PageInfo<Device>) service.querypageList(paramMap, pageInfo);

		return querypageList;

	}

	@RequestMapping("queryDeviceList")
	public PageInfo<DeviceList> queryDeviceList(@RequestBody HashMap<String, Object> paramMap) {
		@SuppressWarnings("rawtypes")
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		pageInfo.setPageNum(Integer.parseInt(paramMap.get("currentPage").toString()));
		@SuppressWarnings("unchecked")
		PageInfo<DeviceList> queryDeviceList = (PageInfo<DeviceList>) service.queryDevicepageList(paramMap, pageInfo);

		return queryDeviceList;
	}

	@RequestMapping("getDevTypeParam")
	@Transactional
	public HashMap<String, Object> getDevTypeParam(@RequestBody HashMap<String, Object> paramMap) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		// 获取设备类型CODE
		String devType = (String) paramMap.get("fk_device_type");
		if (null != paramMap.get("fk_device_type")) {
			switch (devType) {
			case "JK":
				return service.getDevRelationJKInfo(paramMap);
			case "KKSB":
				return service.getDevRelationDJInfo(paramMap);
			case "DJ":
				return service.getDevRelationDJInfo(paramMap);
			case "WT":
				return service.getDevRelationDJInfo(paramMap);
			case "SJJC":
				return service.getDevRelationSJJCInfo(paramMap);
			case "LLJC":
				return service.getDevRelationLLJCInfo(paramMap);
			case "LED":
				return service.getDevRelationYDInfo(paramMap);
			case "XHD":
				return service.getDevRelationXHDInfo(paramMap);
			default:
				break;
			}
		}
		return paramMap;

	}

	@RequestMapping("getDevTypeParam1")
	@Transactional
	public HashMap<String, Object> getDevTypeParam1(@RequestBody HashMap<String, Object> paramMap) {
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		Device device = service.queryDeviceById(paramMap);
		resultMap.put("baseParam", device);
		// 获取设备类型CODE
		String devType = device.getFk_device_type();
		if (null != devType) {
			switch (devType) {
			case "JK":
				resultMap.put("devTypeParam", service.getDevRelationJKInfo(paramMap));
				break;
			case "KKSB":
				resultMap.put("devTypeParam", service.getDevRelationDJInfo(paramMap));
				break;
			case "DJ":
				resultMap.put("devTypeParam", service.getDevRelationDJInfo(paramMap));
				break;
			case "WT":
				resultMap.put("devTypeParam", service.getDevRelationDJInfo(paramMap));
				break;
			case "SJJC":
				resultMap.put("devTypeParam", service.getDevRelationSJJCInfo(paramMap));
				break;
			case "LLJC":
				resultMap.put("devTypeParam", service.getDevRelationLLJCInfo(paramMap));
				break;
			case "LED":
				resultMap.put("devTypeParam", service.getDevRelationYDInfo(paramMap));
				break;
			case "XHD":
				resultMap.put("devTypeParam", service.getDevRelationXHDInfo(paramMap));
				break;
			default:
				resultMap.put("devTypeParam", null);
				break;
			}
		}
		return resultMap;

	}

	@RequestMapping("updateDevRegister")
	@Transactional
	public int updateDevRegister(@RequestBody HashMap<String, Object> paramMap) {
		Device device = service.getDevice(paramMap);
		service.deleteDeviceAuditProcess(paramMap);
		if (null != device.getFk_device_type()) {
			service.deleteDevConnectInfo(device.getFk_device_type(), paramMap);
		}

		int updateD = service.updateDeviceInfo(paramMap);
		int updateM = service.updateDevMaintenance(paramMap);
		if (updateD > 0 && updateM > 0) {
			String devType = (String) paramMap.get("fk_device_type");
			if (null != devType) {
				switch (devType) {
				case "JK":
					return service.addDeviceRelationJKInfo(paramMap);
				case "KKSB":
					return service.addDevRelationDJInfo(paramMap);
				case "DJ":
					return service.addDevRelationDJInfo(paramMap);
				case "WT":
					return service.addDevRelationDJInfo(paramMap);
				case "SJJC":
					return service.updateSJJCDevInfo(paramMap);
				case "LLJC":
					return service.updateLLJCDevInfo(paramMap);
				case "XHD":
					return service.addDevRelationXHDInfo(paramMap);
				case "LED":
					return service.addDevRelationYDInfo(paramMap);

				default:
					return 1;
				}
			}
		}
		return 1;

	}

	@RequestMapping("auditDev")
	@Transactional
	public int auditDev(@RequestBody HashMap<String, Object> paramMap) {

		return service.auditDev(paramMap);

	}

	@RequestMapping("deleteDevice")
	@Transactional
	public int deleteDevice(@RequestBody HashMap<String, Object> paramMap) {

		int delD = service.deleteDeviceInfo(paramMap);
		int delDM = service.deleteDevMaintenance(paramMap);
		service.deleteDeviceAuditProcess(paramMap);
		if (delD > 0 && delDM > 0) {

			String devType = (String) paramMap.get("fk_device_type");
			if (null != devType) {
				switch (devType) {
				case "JK":
					return service.deleteDeviceRelationJKInfo(paramMap);
				case "KK":
					return service.deleteDeviceRelationKKInfo(paramMap);
				case "KKSB":
					return service.deleteDeviceRelationDJInfo(paramMap);
				case "DJ":
					return service.deleteDeviceRelationDJInfo(paramMap);
				case "YD":
					return service.deleteDevRelationYDInfo(paramMap);
				case "XHD":
					return service.deleteDevRelationXHDInfo(paramMap);
				default:
					return 1;
				}
			}
		}
		return 1;

	}

	@RequestMapping("queryImminentExpiryDevList")
	public PageInfo<Device> queryImminentExpiryList(@RequestBody HashMap<String, Object> paramMap) {
		@SuppressWarnings("rawtypes")
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		pageInfo.setPageNum(Integer.parseInt(paramMap.get("currentPage").toString()));
		@SuppressWarnings("unchecked")
		PageInfo<Device> querypageList = (PageInfo<Device>) service.queryImminentExpiryDevpageList(paramMap, pageInfo);

		return querypageList;

	}

	@RequestMapping("searchRoadSegite")
	public HashMap<String, Object> searchRoadSegite(@RequestBody HashMap<String, Object> paramMap) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("roadSegite", service.searchRoadSegite(paramMap));
		return resultMap;

	}
	/***
	 * 
	 * @Title:  PictureController.java   
	 * @Package com.cist.picture.controller   
	 * @Description:    行政区域树
	 * @author: 王涛    
	 * @date:   2018年5月16日 上午9:13:10 
	 * @param: @return      
	 * @return: List<Depart_info>      
	 * @throws JsonProcessingException 
	 * @throws 
	 * @version V1.0
	 */
	@RequestMapping("kreisinfo")
	public String departinfo() throws JsonProcessingException{
    //顶级部门 null
	HashMap<String, Object> resultMap = new HashMap<String, Object>();
	//行政区域
	resultMap.put("tbek_parent", null);
	List<Ckreiscode>	departinfo=service.kerscodexia(resultMap);
	ObjectMapper mapper = new ObjectMapper();	
	List<Ckreiscode> list=departinfodg(departinfo);
	String json=mapper.writeValueAsString(getdiwfdidian(list));
	return json.substring(1, json.length()-1);
	}

	public List<Ckreiscode> departinfodg(List<Ckreiscode> departinfo){
	
		
		for (Ckreiscode depart_info : departinfo) {
			HashMap<String, Object> resultMap = new HashMap<String, Object>();
			//部门
			resultMap.put("tbek_parent", depart_info.getTbek_pk());
			List<Ckreiscode> list= service.kerscodexia(resultMap);
			depart_info.setChildren(list);
			if(null!=list){
				departinfodg(list);
			}
		}
		return departinfo;
	}
	public List<HashMap<String, Object>> getdiwfdidian(List<Ckreiscode> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Ckreiscode depart_info : list) {
			HashMap<String, Object> map=new HashMap<>();
			map.put("title", depart_info.getTbek_name());
			map.put("key", depart_info.getTbek_code());
			/*map.put("selectable", depart_info.getSelectable());
			map.put("isLeaf", depart_info.getIsLeaf());*/
			if(null!=depart_info.getChildren()&&depart_info.getChildren().size()!=0) {//下级
				
				map.put("children", getdiwfdidian(depart_info.getChildren()));
				listmap.add(map);
			}else {
				map.put("isLeaf",true);
				listmap.add(map);
			}
		}
		return listmap;
	}
}
