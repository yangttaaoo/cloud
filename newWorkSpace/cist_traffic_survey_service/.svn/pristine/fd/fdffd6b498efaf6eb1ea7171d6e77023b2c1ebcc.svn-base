package com.cist.intervalVelocity.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.devRegister.model.Device;
import com.cist.devRegister.model.DeviceList;
import com.cist.devRegister.service.DevRegisterService;
import com.cist.frame.page.PageInfo;
import com.cist.intervalVelocity.model.IntervalVelocity;
import com.cist.intervalVelocity.service.IntervalVelocityService;

@RequestMapping("intervalVelocity")
@RestController
public class IntervalVelocityController {
	@Autowired
	private DevRegisterService devRegisterService;
	@Autowired
	private IntervalVelocityService service;

	@RequestMapping("initIndexTab")
	public HashMap<String, Object> initIndexTab(@RequestBody HashMap<String, Object> paramMap,HttpServletRequest request) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		String initDeptTree = null;
		try {
			initDeptTree = devRegisterService.initDeptTree(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultMap.put("dept", initDeptTree);
		if(null!=paramMap.get("deviceFlag"))
		resultMap.put("roadSegite", devRegisterService.initAreaRoadTree(paramMap));
		resultMap.put("administrativeAreas", devRegisterService.initAdministrativeAreasTree());
		return resultMap;

	}
	@RequestMapping("/roadTreeSearch")
	public HashMap<String, Object> roadTreeSearch(@RequestBody HashMap<String, Object> paramMap) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("roadSegite", devRegisterService.initAreaRoadTree(paramMap));// 所属道路
		return resultMap;
	}
	@RequestMapping("queryKKList")
	public PageInfo<Device> queryKKList(@RequestBody HashMap<String, Object> paramMap) {
		@SuppressWarnings("rawtypes")
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		pageInfo.setPageNum(Integer.parseInt(paramMap.get("currentPage").toString()));
		@SuppressWarnings("unchecked")
		PageInfo<Device> querypageList = (PageInfo<Device>) service.queryKKpageList(paramMap, pageInfo);
		return querypageList;

	}

	@RequestMapping("insert")
	@Transactional
	public int insert(@RequestBody HashMap<String, Object> paramMap) {
		if(devRegisterService.queryDeviceByDeviceNum(paramMap)<=0) {
		int addDevBaseInfo = devRegisterService.addDeviceInfo(paramMap);
		int addIntervalParam = service.addIntervalParam(paramMap);
		if (addDevBaseInfo > 0 && addIntervalParam > 0&&null!=paramMap.get("bayonetIds")&&paramMap.get("bayonetIds").toString().length()>2) {
			return service.addDevConnectBayonet(paramMap);
		}
		return addDevBaseInfo;
		}else {
			return -204;
		}
		

	}
	public boolean getExitsBoolean(List<Integer> list,Integer id) {
		for (Integer index : list) {
			if(index.equals(id)) {
				return true;
			}
		}
		
		return false;
		
	}
	@RequestMapping("update")
	@Transactional
	public int update(@RequestBody HashMap<String, Object> paramMap) {
		if(devRegisterService.queryDeviceByDeviceNum(paramMap)<=0) {
		int addDevBaseInfo = devRegisterService.updateDeviceInfo(paramMap);
		if(addDevBaseInfo>0) {
			int updateIntervalParam = service.updateIntervalParam(paramMap);
			if(updateIntervalParam>0) {
			//1 2 4
			List<Integer> devConnectBayonet = service.getDevConnectBayonet(paramMap);
			@SuppressWarnings("unchecked")
			//1 2  3
			List<Integer> relevance_device_ids = (List<Integer>) paramMap.get("bayonetIds");
			if(devConnectBayonet !=null) {
				//查询出来的ID在传入进来的ID集合中  不存在 表明不再关联  =>做删除操作
				 HashMap<String, Object> delMap = new HashMap<String,Object>();
				 List<Integer> delList = new ArrayList<Integer>();
				for (Integer dcb : devConnectBayonet) {
					//1   2   4
					if(getExitsBoolean(relevance_device_ids,dcb)) {
						//1 不管   2  不管
					}else {
						//  4  收集
						delList.add(dcb);
					}
				}
				if(delList.size()>0) {
				delMap.put("pk_id", paramMap.get("pk_id"));
				delMap.put("list", delList);
				service.delDevConnectBayonet(delMap);
				}
				//传入进来的ID集合在查询出来的集合中  不存在 表明是新增关联  =>做添加操作
				 HashMap<String, Object> addMap = new HashMap<String,Object>();
				 List<Integer> addList = new ArrayList<Integer>();
					for (Integer id : relevance_device_ids) {
						//1   2   3
						if(getExitsBoolean(devConnectBayonet,id)) {
							//1 不管   2  不管
						}else {
							//3 收集
							addList.add(id);
						}
					}
					if(addList.size()>0) {
						addMap.put("pk_id", paramMap.get("pk_id"));
						addMap.put("bayonetIds", addList);
						service.addDevConnectBayonet(addMap);
					}
			}else {
				HashMap<String, Object> map = new HashMap<String,Object>();
				map.put("pk_id", paramMap.get("pk_id"));
				map.put("bayonetIds", relevance_device_ids);
				service.addDevConnectBayonet(map);
			}
			}
		}
		}else {
			return -204;
		}

		return 1;

	}
	@RequestMapping("delete")
	public  int  delete(@RequestBody HashMap<String, Object> paramMap) {
		service.deleteParam(paramMap);
		service.deleteConnect(paramMap);
		service.delDevByQJCS(paramMap);
		
		return 1;
		
	}
	@RequestMapping("queryList")
	public PageInfo<IntervalVelocity> queryList(@RequestBody HashMap<String, Object> paramMap) {
		@SuppressWarnings("rawtypes")
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		pageInfo.setPageNum(Integer.parseInt(paramMap.get("currentPage").toString()));
		@SuppressWarnings("unchecked")
		PageInfo<IntervalVelocity> querypageList = (PageInfo<IntervalVelocity>) service.querypageList(paramMap, pageInfo);

		return querypageList;

	}
	@RequestMapping("getCheckKKDevice")
	public  HashMap<String, Object>  getCheckKKDevice(@RequestBody HashMap<String, Object> paramMap,HttpServletRequest request) {
		
		 HashMap<String, Object> resultMap = new HashMap<String,Object>();
		 String initDeptTree = null;
			try {
				initDeptTree = devRegisterService.initDeptTree(request);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resultMap.put("dept", initDeptTree);
			resultMap.put("administrativeAreas", devRegisterService.initAdministrativeAreasTree());
		IntervalVelocity velocity = service.queryDeviceById(paramMap);
		 resultMap.put("baseParam",velocity);
		 HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("dept_code", velocity.getFk_dept_id());
			hashMap.put("tbek_code", velocity.getXzqh());
			resultMap.put("road", devRegisterService.queryRoadList1(hashMap));
		if(null!=velocity) {
			 List<String> idList = velocity.getRelevance_device_id();
			 List<Integer> list = new ArrayList<Integer>();
				for (String id : idList) {
					list.add(Integer.parseInt(id));
				}
				if(list.size() >0) {
					paramMap.put("list", list);
				  List<Device> device = service.getCheckKKDevice(paramMap);
				  resultMap.put("dev", device);
				 }else {
					 resultMap.put("dev",null);
				 }
				
		}
		
		return resultMap;
		
	}
	@RequestMapping("queryDeviceList")
	public PageInfo<DeviceList> queryDeviceList(@RequestBody HashMap<String, Object> paramMap,HttpServletRequest request) {
		// 当前用户的部门 用于部门权限设置
		HttpSession session = request.getSession();
		Map<String,Object> map = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String deptCode = map.get("sypi_dept_code")==null?null:map.get("sypi_dept_code").toString();
		paramMap.put("dept", deptCode);//当前用户部门code 用于部门权限 
		@SuppressWarnings("rawtypes")
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		pageInfo.setPageNum(Integer.parseInt(paramMap.get("currentPage").toString()));
		@SuppressWarnings("unchecked")
		PageInfo<DeviceList> queryDeviceList = (PageInfo<DeviceList>) service.queryDevicepageList(paramMap, pageInfo);

		return queryDeviceList;
	}
}
