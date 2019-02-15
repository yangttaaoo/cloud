package com.cist.realTimeMonitor.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.realTimeMonitor.mapper.RealTimeMonitorMapper;
import com.cist.realTimeMonitor.model.AdministrativeAreasTree;
import com.cist.realTimeMonitor.model.DeptDeviceTree;
import com.cist.realTimeMonitor.model.SYS_CONFIG;
import com.cist.realTimeMonitor.model.VideoDeviceStatus;
import com.cist.realTimeMonitor.model.VideoDeviceTypeStatus;
import com.cist.realTimeMonitor.service.RealTimeMonitorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RealTimeMonitorServiceImpl implements RealTimeMonitorService {
	@Autowired
	private RealTimeMonitorMapper mapper;
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
		this.getchildrenNode(childrenDeptList, DeviceList, topDept, 0);
		this.initDeviceTree(topDept, DeviceList);

		this.setTopDeptTitle(topDept, DeviceList);

		ObjectMapper obj = new ObjectMapper();
		String deptArea = obj.writeValueAsString(topDept);
		resultMap.put("deptDevice", deptArea);
		resultMap.put("deviceList", DeviceList);
		return resultMap;
	}
	/**
	 * Tree层级为行政区域-设备类型-设备
	 */
	@Override
	public HashMap<String, Object> initAdministrativeAreasTree() throws JsonProcessingException {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("parent_pk", null);
		List<AdministrativeAreasTree> administrativeAreasList = mapper.queryAdministrativeAreas(paramMap);
		List<AdministrativeAreasTree> DeviceList = new ArrayList<AdministrativeAreasTree>();
		this.getAdministrativeAreasChildrenNode(administrativeAreasList, DeviceList, null, 0,paramMap);
		for (AdministrativeAreasTree administrativeAreasTree : administrativeAreasList) {
			int onlineNum = 0;
			// 在线设备
			for (AdministrativeAreasTree device : DeviceList) {
				if (1 == device.getStatus())
					onlineNum += 1;
			}
			administrativeAreasTree.setTitle(administrativeAreasTree.getTitle() + "(" + onlineNum + "/" + DeviceList.size() + ")");
			administrativeAreasTree.setExpanded(true);
		}
		resultMap.put("areasDevice", administrativeAreasList);
		return resultMap;
	}
	/**
	 * 设置部门-设备Tree的顶级标题(设置在线数和总设备数)
	 */
	public void setTopDeptTitle(DeptDeviceTree dept, List<DeptDeviceTree> DeviceList) {
		int onlineNum = 0;
		// 在线设备
		for (DeptDeviceTree device : DeviceList) {
			if (1 == device.getStatus())
				onlineNum += 1;
		}
		dept.setTitle(dept.getTitle() + "(" + onlineNum + "/" + DeviceList.size() + ")");
	}
	/**
	 * 设置部门-设备Tree中的设备类型、设备节点信息
	 */
	@Override
	public int initDeviceTree(DeptDeviceTree dept, List<DeptDeviceTree> DeviceList) {
		List<DeptDeviceTree> deviceType = mapper.queryDeviceType(dept.getKey());
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
				paramMap.put("dept_id", split[0]);
				paramMap.put("device_type_code", split[1]);
				List<DeptDeviceTree> queryVideoDevice = mapper.queryVideoDevice(paramMap);

				// 设备List
				DeviceList.addAll(queryVideoDevice);
				deptDeviceTree.setChildren(queryVideoDevice);
			}

		}
		return deviceType.size();
	}
	/**
	 * 设置行政区域-设备Tree中的设备类型、设备节点信息
	 */
	@Override
	public int initDeviceTree1(AdministrativeAreasTree administrativeAreas, List<AdministrativeAreasTree> DeviceList) {
		List<AdministrativeAreasTree> deviceType = mapper.queryDeviceType1(administrativeAreas.getKey());
		if (deviceType.size() != 0) {
			if (administrativeAreas.getChildren() == null) {
				administrativeAreas.setChildren(deviceType);
			} else {
				administrativeAreas.getChildren().addAll(deviceType);
			}

		}

		for (AdministrativeAreasTree deptDeviceTree : deviceType) {
			deptDeviceTree.setIsDevice(false);
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			// 设备类型节点返回的key 为'行政区域-设备类型'的形式.例:10086-KKSB
			String key = deptDeviceTree.getKey();
			String[] split = key.split("-");
			if (2 == split.length) {
				paramMap.put("areaCode", split[0]);
				paramMap.put("device_type_code", split[1]);
				List<AdministrativeAreasTree> queryVideoDevice = mapper.queryVideoDevice1(paramMap);

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
		// TODO Auto-generated method stub
		return mapper.queryDeviceType(deptId);
	}

	@Override
	public List<VideoDeviceTypeStatus> queryStatusTotalByVideoDeviceType(HashMap<String, Object> paramMap) {

		return mapper.queryStatusTotalByVideoDeviceType(paramMap);
	}

	@Override
	public List<VideoDeviceStatus> queryStatusTotalByVideoDevice(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.queryStatusTotalByVideoDevice(paramMap);
	}

	@Override
	public int getchildrenNode(List<DeptDeviceTree> deptList, List<DeptDeviceTree> DeviceList,
			DeptDeviceTree parentDept, int sizeNum) {
		for (DeptDeviceTree dept : deptList) {
			// 只有部门节点才会有pk
			if (null != dept.getPk()) {
				dept.setIsDept(true);
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
			}
		}
		return sizeNum;
	}

	@Override
	public int getAdministrativeAreasChildrenNode(List<AdministrativeAreasTree> administrativeAreasList,
			List<AdministrativeAreasTree> DeviceList, AdministrativeAreasTree parentAdministrativeAreas, int sizeNum,HashMap<String,Object> paramMap) {
		for (AdministrativeAreasTree areas : administrativeAreasList) {
			// 只有节点才会有pk
			if (null != areas.getPk()) {
				areas.setIsAdministrativeAreas(true);
				areas.setIsDevice(false);
				int deviceTypeSize = this.initDeviceTree1(areas, DeviceList);
				paramMap.put("parent_pk", areas.getPk());
				List<AdministrativeAreasTree> childrenDeptList = mapper.queryAdministrativeAreas(paramMap);
				if (childrenDeptList.size() != 0) {
					// 返回部门dept所有子部门具有设备数
					int childrenDeviceNum = this.getAdministrativeAreasChildrenNode(childrenDeptList, DeviceList, areas,
							0,paramMap);
					if (childrenDeviceNum > 0) {
						if (parentAdministrativeAreas != null) {
							if (parentAdministrativeAreas.getChildren() == null) {
								parentAdministrativeAreas.setChildren(new ArrayList<AdministrativeAreasTree>());
							}
							parentAdministrativeAreas.getChildren().add(areas);
						}
					}
				} else {
					// 该部门没有子部门时 sizeNum用于统计父部门下所有子部门设备总数
					sizeNum += deviceTypeSize;
					if (deviceTypeSize > 0) {
						if (parentAdministrativeAreas.getChildren() == null) {
							parentAdministrativeAreas.setChildren(new ArrayList<AdministrativeAreasTree>());
						}
						parentAdministrativeAreas.getChildren().add(areas);
					}

				}
			}
		}
		return 0;
	}

	@Override
	public Object queryDevicepageList(HashMap<String, Object> paramMap, PageInfo pageInfo) {
		// TODO Auto-generated method stub
		return mapper.queryVideoDeviceList(paramMap);
	}
	@Override
	public SYS_CONFIG queryMineMapBaseConfig(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.queryMineMapBaseConfig(paramMap);
	}
	

	

}
