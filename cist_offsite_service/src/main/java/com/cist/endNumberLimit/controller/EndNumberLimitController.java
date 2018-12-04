package com.cist.endNumberLimit.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.endNumberLimit.model.CarLimtRules;
import com.cist.endNumberLimit.model.MountTree;
import com.cist.endNumberLimit.service.EndNumberLimitService;
import com.cist.frame.page.PageInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

//Service端
@RestController
@RequestMapping("endNumberLimit")
public class EndNumberLimitController {
	@Autowired
	private EndNumberLimitService service;

	@RequestMapping(value = "InitQueryDate")
	public HashMap<String, Object> initDate() throws Exception {
		
		return DateUtil.getDefultSeachTime();
	}

	@RequestMapping(value = "queryList")
	public PageInfo<CarLimtRules> queryList(@RequestBody HashMap<String, Object> paramMap) throws Exception {

		@SuppressWarnings("rawtypes")
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		pageInfo.setPageNum(Integer.parseInt(paramMap.get("currentPage").toString()));
		PageInfo<CarLimtRules> queryList = (PageInfo<CarLimtRules>) service.querypageList(paramMap, pageInfo);

		return queryList;
	}

	@RequestMapping(value = "queryParentNode")
	public String queryParentNode(@RequestBody HashMap<String, Object> paramMap) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<MountTree> mTree = service.queryParentNode();
		int mTreeSize = mTree.size();
		List<Object> list = new ArrayList<Object>();
		map.put("title", "选择设备");
		map.put("key", "-1");
		map.put("selectable", false);
		map.put("expanded", true);
		map.put("children", list);

		for (int i = 0; i < mTreeSize; i++) {

			String direIds = mTree.get(i).getTbmp_dire_id();
			String direNos = mTree.get(i).getTbmp_dire_no();
			if (null != direIds && direIds.contains(",")) {
				List<MountTree> oneTreeNode2 = getOneTreeNode(direIds, direNos, mTree.get(i).getKey());
				mTree.get(i).setChildren(oneTreeNode2);
			} else {
				/* OneTreeNode.put("children", null); */
			}
			list.add(mTree.get(i));
		}
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(map);
	}

	public List<MountTree> getOneTreeNode(String direIds, String direNos, String pointId) {
		List<MountTree> direlist = new ArrayList<MountTree>();

		List<String> direIdList = Arrays.asList(direIds.split(","));
		List<String> direNoList = Arrays.asList(direNos.split(","));
		int direIdSize = direIdList.size();

		for (int i = 0; i < direIdSize; i++) {
			MountTree mountTree = new MountTree();
			mountTree.setKey(direIdList.get(i)+","+pointId);
			mountTree.setTitle(direNoList.get(i));
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("direId", direIdList.get(i));
			hashMap.put("pointId", pointId);
			mountTree.setChildren(service.querChildrenNode(hashMap));
			direlist.add(mountTree);
		}
		return direlist;
	}

	@RequestMapping(value = "insertData")
	public HashMap<String, Object> insertData(@RequestBody HashMap<String, Object> paramMap) {
	/*	ArrayList<String> object = (ArrayList<String>) paramMap.get("tlr_point_ids");
	
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < object.size(); i++) {
			buff.append(object.get(i)).append(",");
		}
		paramMap.put("tlr_point_ids", buff.toString().substring(0,buff.toString().length()-1));*/
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			paramMap.put("tlr_start_time", DateUtil.tlr_start_time_Util(paramMap));
			paramMap.put("tlr_end_time", DateUtil.tlr_end_time_Util(paramMap));
			int insertData = service.insertData(paramMap);
			if (Setresult(insertData, resultMap))
				resultMap.put("content", "添加成功!");
			else
				resultMap.put("content", "添加失败!");
		} catch (Exception e) {
			resultMap.put("content", "添加异常");
		}
		return resultMap;
	}

	@RequestMapping(value = "delData")
	public HashMap<String, Object> delData(@RequestBody HashMap<String, Object> paramMap) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		int delData = service.delData(paramMap);
		if (Setresult(delData, resultMap))
			resultMap.put("content", "删除成功!");
		else
			resultMap.put("content", "删除失败!");
		return resultMap;
	}

	@RequestMapping(value = "delAllData")
	public HashMap<String, Object> delAllData(@RequestBody HashMap<String, Object> paramMap) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<String> list = (List<String>) paramMap.get("delIds");
		
		int delAllData = service.delAllData(list);
		if (Setresult(delAllData, resultMap))
			resultMap.put("content", "删除成功!");
		else
			resultMap.put("content", "删除成功!");
		return resultMap;
	}

	public boolean Setresult(int result, HashMap<String, Object> resultMap) {
	
		resultMap.put("title", "友情提示");
		if (result > 0)
			resultMap.put("flag", true);
		else
			resultMap.put("flag", false);
		return result > 0;

	}

	@RequestMapping(value = "update")
	public HashMap<String, Object> update(@RequestBody HashMap<String, Object> paramMap) throws Exception {
		paramMap.put("tlr_start_time", DateUtil.tlr_start_time_Util(paramMap));
		paramMap.put("tlr_end_time", DateUtil.tlr_end_time_Util(paramMap));
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		int update = service.update(paramMap);
		if (Setresult(update, resultMap))
			resultMap.put("content", "更新成功!");
		else
			resultMap.put("content", "更新失败!");
		return resultMap;
	}
}
