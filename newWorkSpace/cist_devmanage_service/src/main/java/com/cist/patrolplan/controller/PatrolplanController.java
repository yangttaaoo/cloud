package com.cist.patrolplan.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.page.PageInfo;
import com.cist.patrolplan.model.Dept;
import com.cist.patrolplan.model.Device;
import com.cist.patrolplan.model.Need;
import com.cist.patrolplan.model.SYS_CONFIG;
import com.cist.patrolplan.model.SpjkVioPrestConfig;
import com.cist.patrolplan.model.Sys_frm_code;
import com.cist.patrolplan.service.PatrolplanService;
import com.cist.realTimeMonitor.model.VideoDeviceTypeStatus;
import com.cist.realTimeMonitor.service.RealTimeMonitorService;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CASE;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CONFIG;
import com.fasterxml.jackson.core.JsonProcessingException;

@RequestMapping("patrolplan")
@RestController
public class PatrolplanController {
	@Autowired
	private PatrolplanService pService;
	
	@Autowired
	private RealTimeMonitorService service;

	@RequestMapping("allist")
	public PageInfo<Need> indexAll(@RequestBody HashMap<String, Object> map/*, HttpServletRequest request*/) {
		PageInfo pInfo = new PageInfo();
		pInfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pInfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Need> pageInfo = (PageInfo<Need>) pService.selectAllpageList(map, pInfo);
		List<Need> list = pageInfo.getList();
		List<Need> newList = new ArrayList<>();
		Set<Need> set = new HashSet<>();// 提出数据一样的对象，
		for (int i = 0; i < list.size(); i++) {
			set.add(list.get(i));
		}
		for (Need need : set) {
			newList.add(need);
		}
		pageInfo.setList(newList);
		pageInfo.setTotal(newList.size());
		return pageInfo;
	}

	/**
	 * 获取管理部门
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("depts")
	public List<Dept> getDepts(@RequestBody HashMap<String, Object> map) {
		return pService.selectDept(map);
	}
	
	/**
	 * 查询巡逻分类下拉列表
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("selectBaseDate")
	public HashMap<String,Object> selectBaseDate(@RequestBody HashMap<String, Object> map) {
		map.put("fct_code", SysBaseDataCode.SYS_XLFL);
		List<Sys_frm_code> selectBaseDate = pService.selectBaseDate(map);
		map.put("xlfl", selectBaseDate);
		return map;
	}

	/**
	 * 删除单条数据，先删除巡逻方案下的摄像机，在删除巡逻方案
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("delete")
	public Integer delete(@RequestBody HashMap<String, Object> map) {
		try {
			pService.delectVcc(map);
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 批量删除，先删除巡逻方案下的摄像机，在删除巡逻方案
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("deleteArray")
	public Integer deleteArray(@RequestBody HashMap<String, Object> map) {
		ArrayList<String> vcc_pks = (ArrayList<String>) map.get("vccpkArr");
		try {
			for (int i = 0; i < vcc_pks.size(); i++) {
				map.put("vcc_pk", vcc_pks.get(i));
				pService.delectVcc(map);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}

	/**
	 * 根据树的根节点查找设备备案数据
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("info")
	public Map<String, Object> getVideoMonitorInfo(@RequestBody HashMap<String, Object> paramMap) {
		Device tInfo = pService.getVideoMonitorInfo(paramMap);
		
		if (tInfo == null) {
			return null;
		}
		paramMap.put("pk_id", tInfo.getPk_id());//设备id查询对应的预制点位列表
		List<SpjkVioPrestConfig> selectPoint = pService.selectPoint(paramMap);
		paramMap.put("Tbl_Dev_Info", tInfo);
		paramMap.put("pointList", selectPoint);//摄像机预置点位列表
		return paramMap;
	}

	/**
	 * 更新或者添加
	 * 
	 * @param paramMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("insert")
	public Integer insert(@RequestBody HashMap<String, Object> paramMap) {
		
		ArrayList<String> vcc_times = (ArrayList<String>) paramMap.get("vcc_time");
		String vcc_time = "";
		for (int i = 0; i < vcc_times.size(); i++) {
			vcc_time += vcc_times.get(i) + ",";
		}
		paramMap.put("vcc_time", vcc_time);
		if("1".equals(paramMap.get("operation").toString())) {
			//新增操作
			Integer addTblVioCruiseCase = pService.addTblVioCruiseCase(paramMap);
			if(addTblVioCruiseCase>0) {
				return 1;
			}else {
				return 0;
			}
		}else {
			//更新操作
			String vcc_time1 = (String) paramMap.get("vcc_time");
			paramMap.put("vcc_time", vcc_time1.substring(0, 50));
			Integer insertTblVioCruiseConfig = pService.updateTblVioCruiseCase(paramMap);// 更新视频巡逻方案
			if(insertTblVioCruiseConfig>0) {
				return 1;
			}else {
				return 0;
			}
		}


	}

	/**
	 * 点击修改查询出巡逻方案信息和摄像机信息
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("showdata")
	public Map<String, Object> showData(@RequestBody HashMap<String, Object> paramMap) {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("tvcc", pService.selectTvcc(paramMap));
		String dvc_names ="";
             if(paramMap.get("dvc_name")!=null){
            	dvc_names = paramMap.get("dvc_name").toString();
             }
		
		if (null != dvc_names && dvc_names != "") {
			String dvc[] = dvc_names.split(",");
			List<String> list = Arrays.asList(dvc);
			paramMap.put("dvc_name", list);
		}
		modelMap.put("updatedatas", pService.getUpdatedata(paramMap));

		return modelMap;
	}
	
	/**
	 * 视频实时监控
	 * 
	 * @param paramMap
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("initRealTimeMonitor")
	public HashMap<String, Object> queryStatusTotalByVideoDeviceType1(@RequestBody HashMap<String, Object> paramMap)
			throws JsonProcessingException {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		// 根据视频设备类型分组统计离线在线总数
		List<VideoDeviceTypeStatus> deviceTypeTotalNum = pService.queryStatusTotalByVideoDeviceType(paramMap);
		// pie数据拼接 横向数据 crosswise 在线数 online_total 离线数 offline_total
		List<String> crosswiseData = new ArrayList<String>();
		List<Long> onlineTotalData = new ArrayList<Long>();
		List<Long> offlineTotalData = new ArrayList<Long>();
		Long onlineTotal = 0L;
		Long offlineTotal = 0L;
		for (VideoDeviceTypeStatus model : deviceTypeTotalNum) {
			Long online_total = model.getDevice_type_online_total();
			Long offline_total = model.getDevice_type_offline_total();
			crosswiseData.add(model.getDevice_type_name());
			onlineTotalData.add(online_total);
			offlineTotalData.add(offline_total);
			onlineTotal += online_total;
			offlineTotal += offline_total;
		}
		resultMap.put("crosswise", crosswiseData);
		resultMap.put("online_total", onlineTotalData);
		resultMap.put("offline_total", offlineTotalData);
		// 视频设备统计离线在线总数
		resultMap.put("onlineTotal", "{\"name\":\"在线\",\"value\":\"" + onlineTotal + "\"}");
		resultMap.put("offlineTotal", "{\"name\":\"离线\",\"value\":\"" + offlineTotal + "\"}");
		// 部门设备Tree
		HashMap<String, Object> initDeptDeviceTree = pService.initDeptDeviceTree();
//		resultMap.put("device", this.queryDeviceList(paramMap));
		resultMap.putAll(initDeptDeviceTree);
//		resultMap.putAll(service.initAdministrativeAreasTree());
		return resultMap;
	}
	
	/**
	 * 查询国标视频地址
	 * 
	 * @param map
	 * @return
	 * @throws JsonProcessingException 
	 */
	@RequestMapping("selectConfig")
	public HashMap<String, Object> selectConfig(@RequestBody HashMap<String, Object> map) throws JsonProcessingException {
	    
		map.put("syci_key", "GBVIDEOURL");
		SYS_CONFIG selectConfig = pService.selectConfig(map);
	    map.put("config", selectConfig);
		return map;
	}
	
	/**
	 * 新增摄像机预置点位
	 * 
	 * @param map
	 * @return
	 * @throws JsonProcessingException 
	 */
	@RequestMapping("insertPoint")
	public String insertPoint(@RequestBody HashMap<String, Object> map) throws JsonProcessingException {
		
		Integer insertPoint = pService.insertPoint(map);
		if(insertPoint>0) {
			return "{\"result\":\"成功\"}";
		}else {
			return "{\"result\":\"失败\"}";
		}
		
	}
	
	/**
	 * 移除摄像机预置位
	 * 
	 * @param map
	 * @return
	 * @throws JsonProcessingException 
	 */
	@RequestMapping("deletepoint")
	public String deletepoint(@RequestBody HashMap<String, Object> map) throws JsonProcessingException {
		
		Integer insertPoint = pService.deletePoint(map);
		if(insertPoint>0) {
			return "{\"result\":\"成功\"}";
		}else {
			return "{\"result\":\"失败\"}";
		}
		
	}
	
	/**
	 * 查询摄像机预置点位
	 * 
	 * @param map
	 * @return
	 * @throws JsonProcessingException 
	 */
	@RequestMapping("selectPoint")
	public HashMap<String, Object> selectPoint(@RequestBody HashMap<String, Object> map) throws JsonProcessingException {
		
		List<SpjkVioPrestConfig> selectPoint = pService.selectPoint(map);
		map.put("pointList", selectPoint);
		return map;
	}
	
	/**
	 * 查询摄像机是否已经关联巡逻方案
	 * 
	 * @param map
	 * @return
	 * @throws JsonProcessingException 
	 */
	@RequestMapping("selectDevice")
	public List<TBL_VIO_CRUISE_CONFIG> selectDevice(@RequestBody HashMap<String, Object> map) throws JsonProcessingException {
		
		// 禁止添加已经关联巡逻方案的摄像机
		List<TBL_VIO_CRUISE_CONFIG> list = pService.getTblVioCruiseConfig(map);
		return list;
	}


}
