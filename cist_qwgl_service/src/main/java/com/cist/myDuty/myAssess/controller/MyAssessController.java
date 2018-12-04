package com.cist.myDuty.myAssess.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.cist.configManage.areaPlan.service.AreaPlanService;
import com.cist.frame.page.PageInfo;
import com.cist.myDuty.myAssess.model.FeedbackResponse;
import com.cist.myDuty.myAssess.model.GpsRecord;
import com.cist.myDuty.myAssess.model.IndividualAssessment;
import com.cist.myDuty.myAssess.model.OffSiteQuery;
import com.cist.myDuty.myAssess.model.QwAssessmentAttachment;
import com.cist.myDuty.myAssess.model.SignIn;
import com.cist.myDuty.myAssess.service.MyAssessService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("myAssess")
public class MyAssessController {
	@Autowired
	private AreaPlanService areaPlanService;
	@Autowired
	private MyAssessService service;

	/**
	 * 初始化我的考核-反馈页面需要的初始数据
	 * 
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("initMyAssessFeedback")
	public HashMap<String, Object> initMyAssessPageData(@RequestBody HashMap<String, Object> paramMap)
			throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		ObjectMapper obj = new ObjectMapper();
		String dept = obj.writeValueAsString(areaPlanService.initDeptTree());
		resultMap.put("dept", dept);
		resultMap.put("assessType", areaPlanService.queryBaseDateByFct_Code("QW06"));
		resultMap.put("assessItem", service.queryAssessItem());
		resultMap.put("assessAttachment", service.queryAssessAttachment(paramMap));
		if ("已反馈".equals(paramMap.get("feedback_state").toString())) {
			paramMap.put("fk_assessment_id", paramMap.get("fk_relation_id"));
			paramMap.put("assessment_type", 1);
			paramMap.put("explain_type", 1);
			resultMap.put("feedback", service.queryHaveFeedback(paramMap));
		}
		if ("已回复".equals(paramMap.get("reply_state").toString())) {
			paramMap.put("fk_assessment_id", paramMap.get("fk_relation_id"));
			paramMap.put("assessment_type", 1);
			paramMap.put("explain_type", 2);
			resultMap.put("reply", service.queryHaveFeedback(paramMap));
		}
		return resultMap;

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
		return (PageInfo<IndividualAssessment>) service.queryAssesspageList(paramMap, pageInfo);

	}

	/**
	 * 增加一条个人考核的反馈信息
	 * 
	 * @param paramMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("addfeedback")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public HashMap<String, Object> addfeedback(@RequestParam HashMap<String, Object> paramMap,
			List<MultipartFile> files, HttpServletRequest request) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("flag", 1);
		resultMap.put("title", "反馈成功!");
		try {
			int addfeedback = service.addfeedback(paramMap);
			if (addfeedback > 0) {
				// 获取 设置关联为我的考核报备ID fk_relation_id
				String relation_id = paramMap.get("fk_assessment_id").toString();
				// 获取当前登陆用户Id
				HttpSession session = request.getSession();
				Map<String, Object> userInfo = (Map<String, Object>) session.getAttribute("userInfo" + session.getId());
				String user_id = userInfo.get("sypi_pk") == null ? null : userInfo.get("sypi_pk").toString();
				String upload = service.addAssessAttachment(files, relation_id, user_id,"wdfkfj");
				if (!"1".equals(upload)) {
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					resultMap.put("flag", 0);
					resultMap.put("title", upload);
					return resultMap;
				}
			} else {
				resultMap.put("flag", 1);
				resultMap.put("title", "反馈成功!");
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultMap.put("flag", 0);
			resultMap.put("title", "反馈异常!");
		}
		return resultMap;

	}

	/**
	 * 查询个人考核已反馈的详细信息
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("queryHaveFeedback")
	public FeedbackResponse queryHaveFeedback(@RequestBody HashMap<String, Object> paramMap) {

		return service.queryHaveFeedback(paramMap);

	}

	/**
	 * 查询报备勤务考核中考核类型为街面勤务的执勤情况页需要的数据
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("queryReportStreet")
	public HashMap<String, Object> queryReportStreet(@RequestBody HashMap<String, Object> paramMap) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("reportStreet", service.queryReportStreet(paramMap));
		List<SignIn> signInfo = service.querySignIn(paramMap);
		for (SignIn sign : signInfo) {
			// 签到
			if (sign.getSign_in_type() == '1')
				resultMap.put("signIn", sign);
			// 签退
			if (sign.getSign_in_type() == '2')
				resultMap.put("signBack", sign);
		}

		return resultMap;

	}

	/**
	 * 查询报备勤务考核中考核类型为街面勤务的执勤情况页需要的数据
	 * 
	 * @param paramMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("queryOffSiteQueryList")
	public PageInfo<OffSiteQuery> queryOffSiteQueryList(@RequestBody HashMap<String, Object> paramMap) {
		@SuppressWarnings("rawtypes")
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		pageInfo.setPageNum(Integer.parseInt(paramMap.get("currentPage").toString()));
		return (PageInfo<OffSiteQuery>) service.queryOffSiteQuerypageList(paramMap, pageInfo);

	}

	/**
	 * 根据警员Id查询某段时间的巡逻轨迹信息
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("queryTrackPlayback")
	public List<GpsRecord> queryTrackPlayback(@RequestBody HashMap<String, Object> paramMap) {
		return service.queryTrackPlayback(paramMap);

	}

	/**
	 * 查询我的考核上传的附件信息
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("queryAssessAttachment")
	public List<QwAssessmentAttachment> queryAssessAttachment(@RequestBody HashMap<String, Object> paramMap) {
		return service.queryAssessAttachment(paramMap);

	}
}
