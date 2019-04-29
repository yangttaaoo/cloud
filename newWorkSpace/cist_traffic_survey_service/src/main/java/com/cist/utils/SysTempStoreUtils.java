package com.cist.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cist.devRegister.model.DeviceAuditProcess;
import com.cist.devRegister.model.DeviceBayonetLane;
import com.cist.devRegister.model.DeviceBayonetRelevance;
import com.cist.devRegister.service.DevRegisterService;
import com.cist.devRegister.util.TempModel;
import com.cist.intersection.model.CRoadSegitemInfo;
import com.cist.intersection.model.C_road_item;
import com.cist.intersection.model.TblSegitemSignal;
import com.cist.intersection.model.TblSigcaseSegitem;
import com.cist.intersection.service.IntersectionService;
import com.cist.roadsection.model.CKreisCode;
import com.cist.roadsection.model.SysDepartInfo;
import com.cist.roadsection.model.Sys_frm_code;
import com.cist.roadsection.service.RoadSectionService;
import com.cist.trafficSign.service.TrafficSignService;

@Component
public final class SysTempStoreUtils {
	static HashMap<String, Object> modelMap = new LinkedHashMap<String, Object>();
	@Autowired
	RoadSectionService rService;

	@Autowired
	IntersectionService iService;
	@Autowired
	DevRegisterService devRegisterService;
	@Autowired
	TrafficSignService trafficSignService;

	/**
	 * 路口下的协调路口
	 */
	public static List<TblSigcaseSegitem> getXtlk(Long xkfa) {
		modelMap.put("xkid", xkfa);
		List<TblSigcaseSegitem> selectXtlk = new ArrayList<TblSigcaseSegitem>();
		try {
			selectXtlk = sysTempStoreUtils.iService.selectXtlk(modelMap);
			if (selectXtlk.size() > 0) {
				return selectXtlk;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectXtlk;

	}

	/**
	 * 路口下的协调路口名称
	 */
	public static String getXtlkName(Long lkxx) {
		modelMap.put("lkxx", lkxx);
		try {
			CRoadSegitemInfo selectXtlkName = sysTempStoreUtils.iService.selectXtlkName(modelMap);
			if (selectXtlkName != null) {
				return selectXtlkName.getLkmc();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "未知";

	}

	/**
	 * 路口下的信控方案信控设备名称查询
	 */
	public static String getXksbName(Long xksb) {
		modelMap.put("xksb", xksb);
		try {
			TblSegitemSignal selectXksbName = sysTempStoreUtils.iService.selectXksbName(modelMap);
			if (selectXksbName != null) {
				return selectXksbName.getDevice_name();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "未知";

	}

	/**
	 * 路口下的信控方案查询
	 */
	public static List<TblSegitemSignal> getXkfa(Long lkid) {
		modelMap.put("lkid", lkid);
		try {
			List<TblSegitemSignal> selectSignal = sysTempStoreUtils.iService.selectSignal(modelMap);
			return selectSignal;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 所属道路名称
	 */
	public static String getDlName(String dldm) {
		modelMap.put("dldm", dldm);
		try {
			C_road_item selectRoadName = sysTempStoreUtils.iService.selectRoadName(modelMap);
			if (selectRoadName != null) {
				return selectRoadName.getRoim_name();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "未知";

	}

	/**
	 * 行政区划名称
	 */
	public static String getTbekName(String tbek_code) {
		modelMap.put("tbek_code", tbek_code);
		try {
			CKreisCode selectKreis = sysTempStoreUtils.rService.selectKreis(modelMap);
			if (selectKreis != null) {
				return selectKreis.getTbek_name();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "未知";

	}

	/**
	 * 路肩类型名称
	 */
	public static String getLjlx(String roim_ljlx) {
		modelMap.put("roim_ljlx", roim_ljlx);
		try {
			Sys_frm_code selectLjlx = sysTempStoreUtils.rService.selectLjlx(modelMap);
			if (selectLjlx != null) {
				return selectLjlx.getFc_name();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "未知";
	}

	/**
	 * 管理单位名称
	 */
	public static String getDeptName(String dept_code) {
		modelMap.put("dept_code", dept_code);
		try {
			SysDepartInfo selectDept = sysTempStoreUtils.rService.selectDept(modelMap);
			if (selectDept != null) {
				return selectDept.getDept_name();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "未知";

	}

	public static String getDeviceName(String device_code) {
		if (device_code.equals("QJCS"))
			return "区间测速";
		modelMap.put("fc_code", device_code);
		try {
			TempModel deviceType = sysTempStoreUtils.devRegisterService.getDeviceType(modelMap);
			if (deviceType != null) {
				return deviceType.getName();
			}
		} catch (Exception e) {
			return null;
		}

		return null;

	}

	// 设备是否审核
	public static HashMap<String, Object> IsDevAudit(int devId) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		modelMap.put("pk_id", devId);
		try {
			DeviceAuditProcess daPro = sysTempStoreUtils.devRegisterService.IsDevAudit(modelMap);
			if (daPro != null) {
				resultMap.put("IsDevAudit", true);
				resultMap.put("devAuditInfo", daPro);
				return resultMap;
			}
		} catch (Exception e) {
			resultMap.put("IsDevAudit", false);
			resultMap.put("devAuditInfo", null);
			return resultMap;
		}
		resultMap.put("IsDevAudit", false);
		resultMap.put("devAuditInfo", null);
		return resultMap;

	}

	// 获取套路信息
	public static List<DeviceBayonetLane> getCardRoadInfobyDevId(long devId) {
		List<DeviceBayonetLane> daPro = null;
		modelMap.put("pk_id", devId);
		try {
			daPro = sysTempStoreUtils.devRegisterService.getCardRoadInfobyDevId(modelMap);
			if (daPro != null) {

				return daPro;
			}
		} catch (Exception e) {
			return daPro;
		}
		return daPro;
	}

	// 区间可以关联的卡口
	public static List<Long> getConnectDevIds(long roadId, long deviceId) {
		List<Long> daPro = new ArrayList<Long>();
		modelMap.put("lane_id", roadId);
		modelMap.put("device_id", deviceId);
		try {
			List<DeviceBayonetRelevance> devRel = sysTempStoreUtils.devRegisterService.getConnectDevIds(modelMap);
			if (devRel != null) {
				for (DeviceBayonetRelevance deviceBayonetRelevance : devRel) {
					daPro.add(deviceBayonetRelevance.getRelevance_device_id());
				}
				return daPro;
			}
		} catch (Exception e) {
			return daPro;
		}
		return daPro;
	}

	// 获取单位名称
	public static String getDeptName1(long check_person_dept_id) {
		modelMap.put("check_person_dept_id", check_person_dept_id);
		String deptName = null;
		try {
			TempModel temp = sysTempStoreUtils.devRegisterService.getDeptName(modelMap);
			if (null != temp) {
				deptName = temp.getName();
			}
		} catch (Exception e) {
			return deptName;
		}
		return deptName;

	}

	// 设备备案、卡口备案 获取审核人单位名称
	public static String getCreatePersonDeptName(long create_person) {
		modelMap.put("create_person", create_person);
		String deptName = null;
		try {
			TempModel temp = sysTempStoreUtils.devRegisterService.getCreatePersonDeptName(modelMap);
			if (null != temp) {
				deptName = temp.getName();
			}
		} catch (Exception e) {
			return deptName;
		}
		return deptName;

	}
	// 设备备案、卡口备案 获取审核人单位名称
	public static String queryBaseDateName(String FCT_CODE,String fc_code) {
		String deptName = "未知";
		try {
			TempModel temp = sysTempStoreUtils.trafficSignService.queryBaseDateName(FCT_CODE, fc_code);
			if (null != temp) {
				deptName = temp.getName();
			}
		} catch (Exception e) {
			return deptName;
		}
		return deptName;
		
	}

	public static SysTempStoreUtils sysTempStoreUtils;

	@PostConstruct
	public void init() {
		sysTempStoreUtils = this;
	}

}
