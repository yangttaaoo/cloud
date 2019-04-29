package com.cist.dutyAssess.PerAssessResultFeedback.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.configManage.areaPlan.service.AreaPlanService;
import com.cist.frame.page.PageInfo;
import com.cist.myDuty.myAssess.model.IndividualAssessment;
import com.cist.myDuty.myAssess.service.MyAssessService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("perAssessResultFeedback")
public class PerAssessResultFeedbackController {

	@Autowired
	private MyAssessService myAssessService;
	@Autowired
	private AreaPlanService areaPlanService;

	/**
	 * 初始化个人勤务考核结果反馈-查询界面需要的初始数据
	 * 
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("initPerAssessResultFeedback")
	public HashMap<String, Object> initMyAssessPageData(@RequestBody HashMap<String, Object> paramMap)
			throws Exception {

		ObjectMapper obj = new ObjectMapper();
		String dept = obj.writeValueAsString(areaPlanService.initDeptTree());
		paramMap.put("dept", dept);
		return paramMap;

	}

	/**
	 * 查询我的考核信息列表
	 * 
	 * @param paramMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("queryAssessList")
	public PageInfo<IndividualAssessment> queryAssessInfoList(@RequestBody HashMap<String, Object> paramMap) {
		@SuppressWarnings("rawtypes")
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		pageInfo.setPageNum(Integer.parseInt(paramMap.get("currentPage").toString()));
		return (PageInfo<IndividualAssessment>) myAssessService.queryAssesspageList(paramMap, pageInfo);

	}
}
