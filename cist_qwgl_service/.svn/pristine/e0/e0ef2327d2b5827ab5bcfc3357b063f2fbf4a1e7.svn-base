package com.cist.feedback.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cist.feedback.model.DeptInfo;
import com.cist.feedback.model.QWAppraiseFeedbackResponse;
import com.cist.feedback.model.QwAppraiseTopic;
import com.cist.feedback.model.QwAssessmentAttachment;
import com.cist.feedback.model.Sys_frm_code;
import com.cist.frame.page.PageInfo;

public interface FeedbackService {
	/**
	 * 查询所有
	 * 
	 * @param map
	 * @return
	 */
	Object listpageList(HashMap<String, Object> map, PageInfo page);

	/**
	 * 更新单位指标信息
	 * 
	 * @param map
	 * @return
	 */
	Integer update(HashMap<String, Object> map);

	/**
	 * 删除单位指标信息
	 * 
	 * @param map
	 * @return
	 */
	Integer delete(HashMap<String, Object> map);

	// 管理部门树
	List<DeptInfo> depart_infolist(Integer dept_superior);

	// 基础数据查询
	List<Sys_frm_code> selectBaseData(HashMap<String, Object> map);

	/**
	 * 保存单位指标信息
	 * 
	 * @param map
	 * @return
	 */
	Integer save(HashMap<String, Object> map, List<MultipartFile> files);

	/**
	 * 查询反馈信息详情
	 * 
	 * @param map
	 * @return
	 */
	List<QWAppraiseFeedbackResponse> selectResponse(HashMap<String, Object> map);

	/**
	 * 查询单位勤务考核对应的附件信息
	 * 
	 * @param map
	 * @return
	 */
	List<QwAssessmentAttachment> selectPicList(HashMap<String, Object> map);

	/**
	 * 反馈图片附件新增
	 * 
	 * @param map
	 * @return
	 */
	Integer savePic(HashMap<String, Object> map);
	
	/**
	 * 查询评定栏目列表
	 * 
	 * @param map
	 * @return
	 */
	List<QwAppraiseTopic> selectLm(HashMap<String, Object> map);
	
	

}
