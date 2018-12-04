package com.cist.configManage.areaPlan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.configManage.areaPlan.model.PatrolArea;
import com.cist.configManage.areaPlan.model.TempModel;
import com.cist.configManage.areaPlan.service.AreaPlanService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("areaPlan")
public class AreaPlanController {
	@Autowired
	private AreaPlanService service;

	/**
	 * 获取部门巡区Tree、部门Tree、巡区类别
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("initAreaPlan")
	public HashMap<String, Object> initAreaPlan(@RequestBody HashMap<String, Object> paramMap) {
		List<PatrolArea> initDeptAreaTree = service.initDeptAreaTree();
		List<PatrolArea> initDeptTree = service.initDeptTree();
		ObjectMapper obj = new ObjectMapper();
		String deptArea = "";
		String dept = "";
		try {
			deptArea = obj.writeValueAsString(initDeptAreaTree);
			dept = obj.writeValueAsString(initDeptTree);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(deptArea);
		paramMap.put("deptArea", deptArea);
		paramMap.put("dept", dept);
		List<TempModel> areaType = service.queryBaseDateByFct_Code("QW02");
		paramMap.put("areaType", areaType);
		return paramMap;

	}

	/**
	 * 新增巡区
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("insert")
	public int insert(@RequestBody HashMap<String, Object> paramMap) {
		paramMap.put("create_person", 4008);
		return service.insertArea(paramMap);

	}
	/**
	 * 更新巡区
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("update")
	public int update(@RequestBody HashMap<String, Object> paramMap) {

		return service.updateArea(paramMap);

	}
	/**
	 * 删除巡区
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("delete")
	public int delete(@RequestBody HashMap<String, Object> paramMap) {

		return service.deleteArea(paramMap);

	}
	/**
	 * 根据部门Id获取巡区Tree
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("queryAreaTreeByDeptId")
	public HashMap<String, Object> queryAreaTreeByDeptId(@RequestBody HashMap<String, Object> paramMap) {
		PatrolArea patrolArea = new PatrolArea();
		patrolArea.setChildren(new ArrayList<PatrolArea>());
		patrolArea.setKey(Long.parseLong((String) paramMap.get("deptId")));
		List<PatrolArea> initAreaTree = service.initAreaTree(patrolArea);
		ObjectMapper obj = new ObjectMapper();
		String area = "";
		try {
			area = obj.writeValueAsString(initAreaTree);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		paramMap.put("area", area);
		return paramMap;
	}

}
