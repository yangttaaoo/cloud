package com.cist.patrolplan.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cist.frame.page.PageInfo;
import com.cist.patrolplan.mapper.PatrolplanMapper;
import com.cist.patrolplan.model.Dept;
import com.cist.patrolplan.model.Device;
import com.cist.patrolplan.model.SYS_CONFIG;
import com.cist.patrolplan.model.SpjkVioPrestConfig;
import com.cist.patrolplan.model.Sys_frm_code;
import com.cist.patrolplan.model.UpdateData;
import com.cist.patrolplan.service.PatrolplanService;
import com.cist.realTimeMonitor.mapper.RealTimeMonitorMapper;
import com.cist.realTimeMonitor.model.DeptDeviceTree;
import com.cist.realTimeMonitor.model.VideoDeviceTypeStatus;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CASE;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CONFIG;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class PatrolplanServiceImpl implements PatrolplanService {
	@Autowired
	private PatrolplanMapper pMapper;
	
	@Autowired
	private RealTimeMonitorMapper mapper;
	
	@Override
	public Object selectAllpageList(HashMap<String, Object> map, PageInfo info) {
		return pMapper.selectAll(map);
	}

	@Override
	public List<Dept> selectDept(HashMap<String, Object> map) {
		return pMapper.selectDept(map);
	}

	@Override
	public Integer deleteByVccname(HashMap<String, Object> map) {
		return pMapper.deleteByVccname(map);
	}

	@Override
	public Integer deleteByVccpk(HashMap<String, Object> map) {
		return pMapper.deleteByVccpk(map);
	}

	@Override
	public TBL_VIO_CRUISE_CASE selectTvcc(HashMap<String, Object> map) {
		return pMapper.selectTvcc(map);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public Integer addTblVioCruiseCase(HashMap<String, Object> map) {
		Integer addTblVioCruiseCase = pMapper.addTblVioCruiseCase(map);
		pMapper.insertTblVioCruiseConfig(map);// 添加摄像机信息
		return addTblVioCruiseCase;
	}

	@Override
	public Integer insertTblVioCruiseConfig(HashMap<String, Object> map) {
		
		return pMapper.insertTblVioCruiseConfig(map);
	}

	@Override
	public Device getVideoMonitorInfo(HashMap<String, Object> map) {
		return pMapper.getVideoMonitorInfo(map);
	}

	@Override
	public List<TBL_VIO_CRUISE_CONFIG> getTblVioCruiseConfig(HashMap<String, Object> map) {
		return pMapper.getTblVioCruiseConfig(map);
	}

	@Override
	public List<UpdateData> getUpdatedata(HashMap<String, Object> map) {
		return pMapper.getUpdatedata(map);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public Integer updateTblVioCruiseCase(HashMap<String, Object> map) {
		pMapper.deleteVccpk(map);//删除原关联摄像机信息
		Integer updateTblVioCruiseCase = pMapper.updateTblVioCruiseCase(map);
		pMapper.insertTblVioCruiseConfig(map);//添加摄像机信息
		return updateTblVioCruiseCase;
	}

	@Override
	public Integer deleteVccpk(HashMap<String, Object> map) {
		return pMapper.deleteVccpk(map);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void delectVcc(HashMap<String, Object> map) throws Exception{
		 this.deleteByVccpk(map);
		 this.deleteByVccname(map);
	}

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

		this.setTopDeptTitle(topDept, DeviceList);

		ObjectMapper obj = new ObjectMapper();
		String deptArea = obj.writeValueAsString(topDept);
		resultMap.put("deptDevice", deptArea);
		resultMap.put("deviceList", DeviceList);
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
	
	@Override
	public int getchildrenNode(List<DeptDeviceTree> deptList, List<DeptDeviceTree> DeviceList,
			DeptDeviceTree parentDept, int sizeNum) {
		for (DeptDeviceTree dept : deptList) {
			// 只有部门节点才会有pk
			if (null != dept.getPk()) {
				dept.setIsDept(true);
				dept.setIsDevice(false);
				dept.setSelectable(false);
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
			deptDeviceTree.setSelectable(false);
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

	@Override
	public List<Sys_frm_code> selectBaseDate(HashMap<String, Object> map) {
		return pMapper.selectBaseDate(map);
	}

	@Override
	public List<VideoDeviceTypeStatus> queryStatusTotalByVideoDeviceType(HashMap<String, Object> paramMap) {
		return mapper.queryStatusTotalByVideoDeviceType(paramMap);
	}

	@Override
	public SYS_CONFIG selectConfig(HashMap<String, Object> map) {
		return pMapper.selectConfig(map);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public Integer insertPoint(HashMap<String, Object> map) {
		pMapper.deletePoint(map);
		return pMapper.insertPoint(map);
	}

	@Override
	public List<SpjkVioPrestConfig> selectPoint(HashMap<String, Object> map) {
		return pMapper.selectPoint(map);
	}

	@Override
	public Integer deletePoint(HashMap<String, Object> map) {
		return pMapper.deletePoint(map);
	}

	@Override
	public Integer updateTblVioCruiseConfig(HashMap<String, Object> map) {
		return pMapper.insertTblVioCruiseConfig(map);
	}
}
