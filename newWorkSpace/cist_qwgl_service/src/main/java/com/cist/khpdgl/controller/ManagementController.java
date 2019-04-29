package com.cist.khpdgl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.khpdgl.model.Qw_AppraiseTopic;
import com.cist.khpdgl.model.Qw_Appraise_Reculations;
import com.cist.khpdgl.service.ManagementService;

@RestController
@RequestMapping("check")
public class ManagementController {

	@Autowired
	private ManagementService sManagementService;

	/**
	 * 考核评定规则管理分页及条件查询
	 * @param map
	 * @return
	 */
	@RequestMapping("index")
	public PageInfo<Qw_Appraise_Reculations> selectCheckAll(@RequestBody Map<String, Object> map){
		PageInfo pInfo = new PageInfo();
		pInfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pInfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Qw_Appraise_Reculations> pageInfo = (PageInfo<Qw_Appraise_Reculations>)sManagementService.selectAllpageList(map, pInfo);
		return pageInfo;
	}




	/**
	 * 考核评定规则管理 添加
	 * @param map
	 * @return
	 */
	@RequestMapping("add")
	public Integer insertCheck(@RequestBody Map<String, Object> map){
		//Integer isAdd = sManagementService.insertCheckTopic(map);
		//if(isAdd != null){
		Integer isAdd =	sManagementService.insertCheck(map);
	//	}
		return isAdd;
	}

	/**
	 * 考核评定规则管理 修改
	 * @param map
	 * @return
	 */
	@RequestMapping("update")
	public Integer updateCheck(@RequestBody Map<String, Object> map){
		Integer isUpdate = sManagementService.updateCheck(map);
		if (isUpdate != null){
			sManagementService.updateCheckTopic(map);
		}
		return isUpdate;
	}

	/**
	 * 考核评定规则管理 删除
	 * @param map
	 * @return
	 */
	@RequestMapping("delete")
	public Integer deleteCheck(@RequestBody Map<String, Object> map){
		Integer isDelete = sManagementService.deleteCheck(map);
		return isDelete;
	}

	/**
	 * 考核评定规则管理 批量删除
	 * @param pk
	 * @return
	 */
	@RequestMapping("deleteAll")
	public Integer deleteCheckAll(@RequestParam("pk") String[] pk){
		Integer isAll = sManagementService.deleteCheckAll(pk);
		return isAll;
	}

	@RequestMapping("deleteAlllist")
	public Integer deleteChecklistAll(@RequestBody Map<String, Object> map){
		Integer isAll = sManagementService.deleteCheckListAll(map);
		return isAll;
	}

	
	@RequestMapping("selecttopic")
	public List<Qw_AppraiseTopic> selectTopic(  ){
		return sManagementService.selectTopic();
	}
	
	@RequestMapping("selecttolist")
	public List<Qw_AppraiseTopic> selectTopicList(@RequestBody Integer pk_id){
		return sManagementService.selectTopicList(pk_id);
	}
	
	@RequestMapping("selecttolists")
	public List<Qw_AppraiseTopic> selectTopicLists(@RequestBody Integer pk_id){
		return sManagementService.selectTopicLists(pk_id);
	}
	
	/**
	 * 基础数据
	 * @param map
	 * @return
	 */
	@RequestMapping("selectlist")
	public Map<String,Object> selectList() {
		HashMap<String, Object> modelMap=new HashMap<String, Object>();	
		modelMap.put("assessmentList",sManagementService.selectSysFrmCode("QW05"));//条例规则
		modelMap.put("zbList",sManagementService.selectSysFrmCode("QW01"));
		return modelMap;
	}
	
	
	@RequestMapping("selectrecula")
	public List<Qw_Appraise_Reculations> selectRecula(@RequestBody Integer pk_id){
		return sManagementService.selectReculations(pk_id);
	}
	
}
