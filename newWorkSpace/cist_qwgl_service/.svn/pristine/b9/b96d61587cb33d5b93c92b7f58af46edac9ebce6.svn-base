package com.cist.feedbackRes.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cist.feedback.model.DeptInfo;
import com.cist.feedback.model.QWAppraiseFeedbackResponse;
import com.cist.feedback.model.QwCompanyAssessment;
import com.cist.feedback.model.Sys_frm_code;

public interface FeedbackResMapper {
	/**
	 * 查询所有
	 * 
	 * @param map
	 * @return
	 */
	List<QwCompanyAssessment> list(HashMap<String, Object> map);

	
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
	Integer save(HashMap<String, Object> map);
	
	/**
	 * 反馈回复图片附件新增
	 * 
	 * @param map
	 * @return
	 */
	Integer savePic(HashMap<String,Object> map);
}
