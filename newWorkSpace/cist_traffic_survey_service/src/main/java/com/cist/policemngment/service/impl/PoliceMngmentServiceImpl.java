package com.cist.policemngment.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cist.frame.page.PageInfo;
import com.cist.policemngment.mapper.PoliceMngmentMapper;
import com.cist.policemngment.model.Depart_info;
import com.cist.policemngment.model.DeptDeviceTree;
import com.cist.policemngment.model.DeptInfo;
import com.cist.policemngment.model.Jcsj_P_R_Allot;
import com.cist.policemngment.model.Jcsj_P_R_Have;
import com.cist.policemngment.model.Jcsj_P_R_Relation;
import com.cist.policemngment.model.Jcsj_Police_Res_Person;
import com.cist.policemngment.model.Jcsj_police_resourc;
import com.cist.policemngment.model.SysPoliceInfo;
import com.cist.policemngment.model.Sys_frm_code;
import com.cist.policemngment.service.PoliceMngmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PoliceMngmentServiceImpl implements PoliceMngmentService{

	@Autowired
	private PoliceMngmentMapper mapper;

	@Override
	public Object selectByRespageList(Map<String, Object> map, PageInfo info) {
		return mapper.SecurityByfk_dept_idTopk(map);
	}


	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}


	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public Integer insetResourc(Map<String, Object> map) {
		 Integer insetResourc = mapper.insetResourc(map);
		String[] newCodeArray = {};
		if (map.get("codeString") != null&&!("".equals(map.get("codeString").toString()))) {
			String newCodeString = map.get("codeString").toString();
			newCodeArray = newCodeString.split(",");
			map.put("arrays", newCodeArray);
			insertHave(map);//插入具备功能
		}
		//分配信息插入
		if (map.get("array")!=null&&((ArrayList)map.get("array")).size() > 0) {
			allotPolice(map);
		}
		//GPS信息插入或者警车信息插入
		if(map.get("flag")!=null&&("1".equals(map.get("flag").toString())||"5".equals(map.get("resources_type").toString())||"6".equals(map.get("resources_type").toString()))&&map.get("fk_gps_id")!=null&&!("".equals(map.get("fk_gps_id").toString()))){
			allotPolicesss(map);//警车关联GPS
		}
		else if(map.get("flag")!=null&&"2".equals(map.get("flag").toString())&&map.get("fk_car_id")!=null&&!("".equals(map.get("fk_car_id").toString()))){
			insertCarToGps(map);//GPS关联警车
		}
			
			
		
		return insetResourc;
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public Integer updateResourc(Map<String, Object> map) {
		Integer isUpdate = mapper.updateResourc(map);
		//具备功能更新
		if (isUpdate != null) {
			if ((boolean) map.get("isType")) {
				Integer isHave = deleteHave(map);
				if (isHave != null) {
					String[] newCodeArray = {};
					if (map.get("codeString") != null&&!("".equals(map.get("codeString").toString()))) {
						String newCodeString = map.get("codeString").toString();
						newCodeArray = newCodeString.split(",");
						map.put("arrays", newCodeArray);
						insertHave(map);//插入具备功能
					}
				}
			}
			//分配人员信息更新
			Integer isPolices = deletePolice(map);
			
			
			if (isPolices != null&&map.get("array")!=null&&((ArrayList)map.get("array")).size()>0) {
				allotPolice(map);
			}
			if(map.get("flag")!=null&&"2".equals(map.get("flag").toString())){
				deleteCarByGps(map);
			}else if(map.get("flag")!=null&&("1".equals(map.get("flag").toString())||"8".equals(map.get("flag").toString())||"3".equals(map.get("flag").toString()))){
				deleteGps(map);//删除GPS信息
			}
			
			
			//GPS信息插入或者警车信息插入
			if(map.get("flag")!=null&&("1".equals(map.get("flag").toString())||"5".equals(map.get("resources_type").toString())||"6".equals(map.get("resources_type").toString()))&&map.get("fk_gps_id")!=null&&!("".equals(map.get("fk_gps_id").toString()))){
				allotPolicesss(map);//警车关联GPS
			}
			else if(map.get("flag")!=null&&"2".equals(map.get("flag").toString())&&map.get("fk_car_id")!=null&&!("".equals(map.get("fk_car_id").toString()))){
				insertCarToGps(map);//GPS关联警车
			}
		}
		return isUpdate;
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public Integer deleteResourc(Map<String, Object> map) {
		Integer isDelete = mapper.deleteResourc(map);
			deletePolice(map);//删除分配信息
			deleteHave(map);//删除具备功能
			deleteGps(map);//删除警车关联GPS
		return isDelete;
	}

	@Override
	public Integer allotPolice(Map<String, Object> map) {
		return mapper.allotPolice(map);
	}


	@Override
	public Integer insertHave(Map<String, Object> map) {
		return mapper.insertHave(map);
	}


	@Override
	public Integer updatePolicce(Map<String, Object> map) {
		return mapper.updatePolicce(map);
	}


	@Override
	public Integer updateHave(Map<String, Object> map) {
		return mapper.updateHave(map);
	}


	@Override
	public Integer deletePolice(Map<String, Object> map) {
		return mapper.deletePolice(map);
	}


	@Override
	public Integer deleteHave(Map<String, Object> map) {
		return mapper.deleteHave(map);
	}


	@Override
	public List<Sys_frm_code> selectSysFrmCode(String fct_code) {
		return mapper.selectSysFrmCode(fct_code);
	}


	@Override
	public List<SysPoliceInfo> selectCarGPS() {
		return mapper.selectCarGPS();
	}


	@Override
	public List<Jcsj_P_R_Have> selectHave(Map<String, Object> map) {
		return mapper.selectHave(map);
	}


	@Override
	public List<Jcsj_Police_Res_Person> selectPoliceCheck(Map<String, Object> map) {
		return mapper.selectPoliceCheck(map);
	}


	@Override
	public Object selectsByRespageList(Map<String, Object> map, PageInfo info) {
		return mapper.selectByResourcs(map);
	}


	@Override
	public Integer insertPolicePerson(Map<String, Object> map) {
		return mapper.insertPolicePerson(map);
	}


	@Override
	public Object selectByPolicepageList(Map<String, Object> map, PageInfo info) {
		return mapper.SecurityByglbmTocode(map);
	}


	@Override
	public Integer updatePolicePerson(Map<String, Object> map) {
		return mapper.updatePolicePerson(map);
	}


	@Override
	public List<Depart_info> selectPersons(Integer pk_id) {
		return mapper.selectPersons(pk_id);
	}


	@Override
	public List<Depart_info> depart_infolists() {
		return mapper.depart_infolists();
	}


	@Override
	public Integer allotPolicesss(Map<String, Object> map) {
		return mapper.allotPolicesss(map);
	}


	@Override
	public List<Depart_info> depart_infolistss() {
		return mapper.depart_infolistss();
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public Integer deletePersonAll(Map<String, Object> map) {
		Integer deletePersonAll = mapper.deletePersonAll(map);
		if("1".equals(map.get("flag"))){
				  mapper.deletePoliceList(map);
				 mapper.deleteGpsList(map);//删除警车关联GPS信息
		}
		else if("8".equals(map.get("flag"))||"3".equals(map.get("flag"))){
//			mapper.deleteHaveList(map);
			mapper.deleteGpsList(map);//删除警车关联GPS信息
			mapper.deletePoliceList(map);
		}
		else if("6".equals(map.get("flag"))||"7".equals(map.get("flag"))||"9".equals(map.get("flag"))){
			mapper.deleteHaveList(map);
			mapper.deletePoliceList(map);
		}
		else if("2".equals(map.get("flag"))){
			mapper.deleteHaveList(map);
			 mapper.deletePoliceList(map);
			 mapper.deleteCarList(map);
		}
		 
		return deletePersonAll;
	}


	@Override
	public List<Depart_info> deptTree(Integer dept_superior) {
		return mapper.deptTree(dept_superior);
	}


	@Override
	public List<Depart_info> selectGps(Integer dept_superior) {
		return mapper.selectGps(dept_superior);
	}


	@Override
	public Integer insertCarToGps(Map<String, Object> map) {
		return mapper.insertCarToGps(map);
	}



	@Override
	public List<Jcsj_P_R_Relation> selectCheck(HashMap<String, Object> map) {
		return mapper.selectCheck(map);
	}


	@Override
	public Integer deleteGps(Map<String, Object> map) {
		return mapper.deleteGps(map);
	}

	@Override
	public List<Jcsj_Police_Res_Person> selectPolice(Map<String, Object> map) {
		return mapper.selectPolice(map);
	}


	@Override
	public Integer deleteHaveList(Map<String, Object> map) {
		return mapper.deleteHaveList(map);
	}


	@Override
	public Integer deleteGpsList(Map<String, Object> map) {
		return mapper.deleteGpsList(map);
	}


	@Override
	public Integer deletePoliceList(Map<String, Object> map) {
		return mapper.deletePoliceList(map);
	}


	@Override
	public Integer deleteMJ(Map<String, Object> map) {
		return mapper.deleteMJ(map);
	}


	@Override
	public List<Depart_info> selectPoliceCarAll(Integer dept_superior) {
		return mapper.selectPoliceCarAll(dept_superior);
	}


	@Override
	public List<Depart_info> selectGpsAll(Integer dept_superior) {
		return mapper.selectGpsAll(dept_superior);
	}


	@Override
	public List<Jcsj_P_R_Relation> selectDataCheck(HashMap<String, Object> map) {
		return mapper.selectDataCheck(map);
	}


	@Override
	public Integer deletePerson(Map<String, Object> map) {
		return mapper.deletePerson(map);
	}


	@Override
	public List<Jcsj_Police_Res_Person> selectPoliceCode(Map<String, Object> map) {
		return mapper.selectPoliceCode(map);
	}


	@Override
	public List<Jcsj_Police_Res_Person> selectSfzhm(Map<String, Object> map) {
		return mapper.selectSfzhm(map);
	}


	@Override
	public List<Jcsj_police_resourc> selectDeviceCode(Map<String, Object> map) {
		return mapper.selectDeviceCode(map);
	}


	@Override
	public List<Jcsj_P_R_Allot> selectPoliceByCheck(Map<String, Object> map) {
		return mapper.selectPoliceByCheck(map);
	}


	@Override
	public Object selectByJWpageList(Map<String, Object> map, PageInfo info) {
		return mapper.selectByJWSecurityByfk_dept_idTopk(map);
	}


	@Override
	public Object selectByGpsCarpageList(Map<String, Object> map, PageInfo info) {
		return mapper.selectByGpsCarSecurityByfk_dept_idTopk(map);
	}


	@Override
	public Integer deleteCarByGps(Map<String, Object> map) {
		return mapper.deleteCarByGps(map);
	}

	/**
	 * Tree层级为部门-设备类型-设备
	 */
	@Override
	public HashMap<String, Object> initDeptDeviceTree() throws JsonProcessingException {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<DeptDeviceTree> DeviceList = new ArrayList<DeptDeviceTree>();
		DeptDeviceTree topDept = mapper.queryTopLevelDept();
		List<DeptDeviceTree> childrenDeptList = mapper.querySubLevelDept(topDept.getPk());
		topDept.setIsDept(true);
		topDept.setIsDevice(false);
		topDept.setExpanded(true);
		topDept.setSelectable(false);
		this.getchildrenNode(childrenDeptList, DeviceList, topDept, 0);
		this.initDeviceTree(topDept, DeviceList);
		ObjectMapper obj = new ObjectMapper();
		String deptArea = obj.writeValueAsString(topDept);
		resultMap.put("deptDevice", deptArea);
		resultMap.put("deviceList", DeviceList);
		return resultMap;
	}
	
	@Override
	public int getchildrenNode(List<DeptDeviceTree> deptList, List<DeptDeviceTree> DeviceList,
			DeptDeviceTree parentDept, int sizeNum) {
		for (DeptDeviceTree dept : deptList) {
			// 只有部门节点才会有pk
			if (null != dept.getPk()) {
				dept.setIsDept(true);
				dept.setSelectable(false);
				dept.setIsDevice(false);
				int deviceTypeSize = this.initDeviceTree(dept, DeviceList);
				List<DeptDeviceTree> childrenDeptList = mapper.querySubLevelDept(dept.getPk());
				if (childrenDeptList.size() != 0) {
					// 返回部门dept所有子部门具有设备数
					int childrenDeviceNum = this.getchildrenNode(childrenDeptList, DeviceList, dept, 0);
					if (childrenDeviceNum > 0) {
						if (parentDept != null) {
							if (parentDept.getChildren() == null) {
								parentDept.setChildren(new ArrayList<DeptDeviceTree>());
							}
							parentDept.getChildren().add(dept);
						}
					}
				} else {
					// 该部门没有子部门时 sizeNum用于统计父部门下所有子部门设备总数
					sizeNum += deviceTypeSize;
					if (deviceTypeSize > 0) {
						if (parentDept.getChildren() == null) {
							parentDept.setChildren(new ArrayList<DeptDeviceTree>());
						}
						parentDept.getChildren().add(dept);
					}

				}
			}else {
				dept.setIsLeaf(true);
			}
		}
		return sizeNum;
	}
	
	/**
	 * 设置部门-设备Tree中的设备类型、设备节点信息
	 */
	@Override
	public int initDeviceTree(DeptDeviceTree dept, List<DeptDeviceTree> DeviceList) {
		List<DeptDeviceTree> deviceType = mapper.selectGps(dept.getPk());
//		List<DeptDeviceTree> deviceType = mapper.queryDeviceType(dept.getKey());
		if (deviceType.size() != 0) {
			if (dept.getChildren() == null) {
				dept.setChildren(deviceType);
			} else {
				dept.getChildren().addAll(deviceType);
			}

		}

		for (DeptDeviceTree deptDeviceTree : deviceType) {
			deptDeviceTree.setIsDevice(false);
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			// 设备类型节点返回的key 为'管理部门-设备类型'的形式.例:510600000000-KKSB
			String key = deptDeviceTree.getKey();
			String[] split = key.split("-");
			if (2 == split.length) {
				List<DeptDeviceTree> queryVideoDevice = mapper.selectGps(dept.getPk());
//				paramMap.put("dept_id", split[0]);
//				paramMap.put("device_type_code", split[1]);
//				List<DeptDeviceTree> queryVideoDevice = mapper.queryVideoDevice(paramMap);

				// 设备List
				DeviceList.addAll(queryVideoDevice);
				deptDeviceTree.setChildren(queryVideoDevice);
			}

		}
		return deviceType.size();
	}


	/**
	 * 根据部门code查询该部门所管理的设备有那些设备类型
	 */
	@Override
	public List<DeptDeviceTree> queryDeviceType(String deptId) {
		return mapper.queryDeviceType(deptId);
	}

	
	
	
	/**
	 * Tree层级为部门-设备类型-设备
	 */
	@Override
	public HashMap<String, Object> initDeptCarTree() throws JsonProcessingException {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<DeptDeviceTree> DeviceList = new ArrayList<DeptDeviceTree>();
		DeptDeviceTree topDept = mapper.queryTopLevelDept();
		List<DeptDeviceTree> childrenDeptList = mapper.querySubLevelDept(topDept.getPk());
		topDept.setIsDept(true);
		topDept.setIsDevice(false);
		topDept.setExpanded(true);
		topDept.setSelectable(false);
		this.getchildrenNodeCar(childrenDeptList, DeviceList, topDept, 0);
		this.initCarTree(topDept, DeviceList);
		ObjectMapper obj = new ObjectMapper();
		String deptArea = obj.writeValueAsString(topDept);
		resultMap.put("deptDevice", deptArea);
		resultMap.put("deviceList", DeviceList);
		return resultMap;
	}
	
	@Override
	public int getchildrenNodeCar(List<DeptDeviceTree> deptList, List<DeptDeviceTree> DeviceList,
			DeptDeviceTree parentDept, int sizeNum) {
		for (DeptDeviceTree dept : deptList) {
			// 只有部门节点才会有pk
			if (null != dept.getPk()) {
				dept.setIsDept(true);
				dept.setSelectable(false);
				dept.setIsDevice(false);
				int deviceTypeSize = this.initCarTree(dept, DeviceList);
				List<DeptDeviceTree> childrenDeptList = mapper.querySubLevelDept(dept.getPk());
				if (childrenDeptList.size() != 0) {
					// 返回部门dept所有子部门具有设备数
					int childrenDeviceNum = this.getchildrenNodeCar(childrenDeptList, DeviceList, dept, 0);
					if (childrenDeviceNum > 0) {
						if (parentDept != null) {
							if (parentDept.getChildren() == null) {
								parentDept.setChildren(new ArrayList<DeptDeviceTree>());
							}
							parentDept.getChildren().add(dept);
						}
					}
				} else {
					// 该部门没有子部门时 sizeNum用于统计父部门下所有子部门设备总数
					sizeNum += deviceTypeSize;
					if (deviceTypeSize > 0) {
						if (parentDept.getChildren() == null) {
							parentDept.setChildren(new ArrayList<DeptDeviceTree>());
						}
						parentDept.getChildren().add(dept);
					}

				}
			}else {
				dept.setIsLeaf(true);
			}
		}
		return sizeNum;
	}
	
	/**
	 * 设置部门-设备Tree中的设备类型、设备节点信息
	 */
	@Override
	public int initCarTree(DeptDeviceTree dept, List<DeptDeviceTree> DeviceList) {
		List<DeptDeviceTree> deviceType = mapper.selectPoliceCar(dept.getPk());
//		List<DeptDeviceTree> deviceType = mapper.queryDeviceType(dept.getKey());
		if (deviceType.size() != 0) {
			if (dept.getChildren() == null) {
				dept.setChildren(deviceType);
			} else {
				dept.getChildren().addAll(deviceType);
			}

		}

		for (DeptDeviceTree deptDeviceTree : deviceType) {
			deptDeviceTree.setSelectable(false);
			deptDeviceTree.setIsDevice(false);
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			// 设备类型节点返回的key 为'管理部门-设备类型'的形式.例:510600000000-KKSB
			String key = deptDeviceTree.getKey();
			String[] split = key.split("-");
			if (2 == split.length) {
				List<DeptDeviceTree> queryVideoDevice = mapper.selectPoliceCarNum(dept.getPk());
//				paramMap.put("dept_id", split[0]);
//				paramMap.put("device_type_code", split[1]);
//				List<DeptDeviceTree> queryVideoDevice = mapper.queryVideoDevice(paramMap);

				// 设备List
				DeviceList.addAll(queryVideoDevice);
				deptDeviceTree.setChildren(queryVideoDevice);
			}

		}
		return deviceType.size();
	}
	
	/**
	 * 根据部门code查询该部门所管理的设备有那些设备类型
	 */
	@Override
	public List<DeptDeviceTree> queryCarType(String deptId) {
		return mapper.queryDeviceType(deptId);
	}


	@Override
	public List<DeptDeviceTree> selectPoliceCar(Long dept_superior) {
		return mapper.selectPoliceCar(dept_superior);
	}


	@Override
	public List<Depart_info> selectPoliceCar(Integer dept_superior) {
		return mapper.selectPoliceCar(dept_superior);
	}


	@Override
	public List<DeptDeviceTree> selectPoliceCarNum(Long dept_superior) {
		return mapper.selectPoliceCarNum(dept_superior);
	}


	@Override
	public List<Sys_frm_code> selectBaseDate(HashMap<String, Object> map) {
		return mapper.selectBaseDate(map);
	}


	@Override
	public List<DeptInfo> querydeptByCode(String dept_code) {
		return mapper.querydeptByCode(dept_code);
	}
	
}
