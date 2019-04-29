package com.cist.feedbackRes.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cist.feedback.model.DeptInfo;
import com.cist.feedback.model.QWAppraiseFeedbackResponse;
import com.cist.feedback.model.QwAssessmentAttachment;
import com.cist.feedback.model.Sys_frm_code;
import com.cist.frame.page.PageInfo;

public interface FeedbackResService {
	/**
	 * 查询所有
	 * 
	 * @param map
	 * @return
	 */
	Object listpageList(HashMap<String, Object> map, PageInfo page);

	
	/**
	 * 反馈回复更新栏目分值
	 * 
	 * @param map
	 * @return
	 */
	Integer updateMetrics(HashMap<String, Object> map);
	
	/**
	 * 保存单位指标信息
	 * 
	 * @param map
	 * @return
	 */
	Integer save(HashMap<String, Object> map,List<MultipartFile> files);
}
