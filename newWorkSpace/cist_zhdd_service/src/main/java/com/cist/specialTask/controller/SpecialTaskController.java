package com.cist.specialTask.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cist.frame.page.PageInfo;
import com.cist.specialTask.model.CRoadItemInfo;
import com.cist.specialTask.model.JcsjDeviceInfo;
import com.cist.specialTask.model.JcsjPoliceResPerson;
import com.cist.specialTask.model.JcsjPoliceResources;
import com.cist.specialTask.model.ZhddMissionGrade;
import com.cist.specialTask.model.ZhddSpecialMission;
import com.cist.specialTask.service.SpecialTaskService;

@RestController
@RequestMapping("/specialTask")
public class SpecialTaskController {
	@Autowired
	private SpecialTaskService service;

	/**
	 * 重点区域查询
	 * 
	 * @param request 请求
	 */
	@RequestMapping(value = "list")
	public PageInfo<ZhddSpecialMission> list(@RequestBody HashMap<String, Object> map) {

		PageInfo pinfo = new PageInfo();
		pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<ZhddSpecialMission> pageinfo = (PageInfo<ZhddSpecialMission>) service.listpageList(map, pinfo);
		return pageinfo;
	}

	/**
	 * 特勤任务等级
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value = "selectGrade")
	public Map<String, Object> selectGrade(@RequestBody HashMap<String, Object> map) {
		try {
			List<ZhddMissionGrade> selectGrade = service.selectGrade(map);
			map.put("gradeList", selectGrade);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	/**
	 * 特勤任务等级
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value = "selectPoliceCar")
	public Map<String, Object> selectPoliceCar(@RequestBody HashMap<String, Object> map) {
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		List<HashMap<String, Object>> listmap1=new ArrayList<HashMap<String, Object>>();
		try {
			List<JcsjPoliceResources> selectPoliceCar = service.selectPoliceCar(map);
			List<JcsjPoliceResPerson> selectPolice = service.selectPolice(map);
			for (JcsjPoliceResources car : selectPoliceCar) {
				HashMap<String, Object> modelMap=new HashMap();
				modelMap.put("title", car.getCar_num());
				modelMap.put("key", car);
				modelMap.put("selectable", false);
				listmap.add(modelMap);
			}
			for (JcsjPoliceResPerson police : selectPolice) {
				HashMap<String, Object> modelMap=new HashMap();
				modelMap.put("title", police.getXm());
				modelMap.put("key",police);
				modelMap.put("selectable", false);
				listmap1.add(modelMap);
			}
			map.put("car", listmap);
			map.put("police", listmap1);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	/**
	 * 特勤任务等级
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value = "selectEditList")
	public Map<String, Object> selectEditList(@RequestBody HashMap<String, Object> map) {
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		List<HashMap<String, Object>> listmap1=new ArrayList<HashMap<String, Object>>();
		try {
			List<JcsjPoliceResources> selectPoliceCar = service.selectPoliceCar(map);
			List<JcsjPoliceResPerson> selectPolice = service.selectPolice(map);
			for (JcsjPoliceResources car : selectPoliceCar) {
				HashMap<String, Object> modelMap=new HashMap();
				modelMap.put("title", car.getCar_num());
				modelMap.put("key", car.getPk_id());
				modelMap.put("info", car);
				modelMap.put("selectable", false);
				listmap.add(modelMap);
			}
			for (JcsjPoliceResPerson police : selectPolice) {
				HashMap<String, Object> modelMap=new HashMap();
				modelMap.put("title", police.getXm());
				modelMap.put("key",police.getId());
				modelMap.put("info", police);
				modelMap.put("selectable", false);
				listmap1.add(modelMap);
			}
			map.put("car", listmap);
			map.put("police", listmap1);
			map.put("checkList", service.selectParticipant(map));
			map.put("routeList", service.selectRoute(map));
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	/**
	 * 批量删除
	 * 
	 * @return Integer
	 */
	@RequestMapping(value = "delete")
	public String delete(@RequestBody HashMap<String, Object> modelMap) {
		Integer delete = service.delete(modelMap);
		if (delete > 0)// 1表示更新成功返回的行数
		{
			return "{\"result\":\"删除成功\"}";
		} else {
			return "{\"result\":\"删除失败\"}";
		}

	}

	/**
	 * 新增重点区域
	 * 
	 * @return String
	 */
	@RequestMapping(value = "save")
	public String save(@RequestBody HashMap<String, Object> map, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map<String, Object> userMap = (Map<String, Object>) session.getAttribute("userInfo" + session.getId());
		String userPk = userMap.get("sypi_pk") == null ? null : userMap.get("sypi_pk").toString();
		String deptCode = userMap.get("sypi_dept_pk") == null ? null : userMap.get("sypi_dept_pk").toString();
		map.put("fk_dept_id", deptCode);// 当前登录用户部门id
		map.put("fk_create_founder_id", userPk);// 当前登录用户id
		Integer save = service.save(map);
		if (save > 0)// 1表示更新成功返回的行数
		{
			return "{\"result\":\"保存成功\"}";
		} else {
			return "{\"result\":\"保存失败\"}";
		}

	}

	/**
	 * 更新重点区域
	 * 
	 * @return String
	 */
	@RequestMapping(value = "update")
	public String update(@RequestBody HashMap<String, Object> map) {
		Integer update = service.update(map);
		if (update > 0)// 1表示更新成功返回的行数
		{
			return "{\"result\":\"更新成功\"}";
		} else {
			return "{\"result\":\"更新失败\"}";
		}

	}

	/**
	 * 特勤任务查询自动关联的设备
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value = "selectDevice")
	public Map<String, Object> selectDevice(@RequestBody HashMap<String, Object> map) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			List<CRoadItemInfo> selectRoad = service.selectRoad(map);
			if (selectRoad.size() > 0) {
				map.put("codeList", selectRoad);
				List<JcsjDeviceInfo> selectDevice = service.selectDevice(map);// 查询设备信息
				modelMap.put("deviceList", selectDevice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelMap;

	}
	
	/**
	 * 特勤任务查询手关联的设备
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value = "selectHandDevice")
	public Map<String, Object> selectHandDevice(@RequestBody HashMap<String, Object> map) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
				List<JcsjDeviceInfo> selectDevice = service.selectDevice(map);// 查询设备信息
				modelMap.put("deviceList", selectDevice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelMap;

	}

	/**
	 * GIS信息查询
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value = "selectGis")
	public Map<String, Object> selectGis(@RequestBody HashMap<String, Object> map) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			modelMap.put("route", service.selectRoute(map));// 路线信息
			modelMap.put("car", service.selecteParCar(map));// 车辆信息
			modelMap.put("police", service.selecteParPolice(map));// 人员信息
			modelMap.put("device", service.selecteParDevice(map));// 设备信息
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelMap;

	}
}
