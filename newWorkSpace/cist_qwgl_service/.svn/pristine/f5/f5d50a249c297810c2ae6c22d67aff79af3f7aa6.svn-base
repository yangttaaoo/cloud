package com.cist.myDuty.myAssess.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.configManage.areaPlan.model.TempModel;
import com.cist.myDuty.myAssess.model.FeedbackResponse;
import com.cist.myDuty.myAssess.model.GpsRecord;
import com.cist.myDuty.myAssess.model.IndividualAssessment;
import com.cist.myDuty.myAssess.model.OffSiteQuery;
import com.cist.myDuty.myAssess.model.QwAssessmentAttachment;
import com.cist.myDuty.myAssess.model.ReportStreet;
import com.cist.myDuty.myAssess.model.SignIn;

public interface MyAssessMapper {
	/**
	 * 查询考核信息列表
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<IndividualAssessment> queryAssessList(HashMap<String, Object> paramMap);

	/**
	 * 获取考核栏目下拉菜单
	 * 
	 * @return
	 */
	public List<TempModel> queryAssessItem();

	/**
	 * 增加一条个人反馈记录
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addfeedback(HashMap<String, Object> paramMap);
	/**
	 * 根据个人考核Id查询该考核信息的详细信息
	 *@param fk_assessment_id      勤务考核ID(个人ID)
	 * @param assessment_type   1 勤务考核类型 个人
	 * @param explain_type      1 说明类型 个人
	 * @return
	 */
	public FeedbackResponse queryHaveFeedback(HashMap<String, Object> paramMap);
	/**
	 * 根据勤务报备Id查询街面勤务报备信息
	 *@param fk_report_id     勤务报备Id
	 * @return
	 */
	public ReportStreet queryReportStreet(HashMap<String, Object> paramMap);
	/**
	 * 根据警员根据审核人的Id查询在当月第一天到当前时间的审核记录信息
	 * @param paramMap
	 * @return
	 */
	public  List<OffSiteQuery> getOffSiteQuerybyUserId(HashMap<String, Object> paramMap);
	 /**
	  * 根据勤务报备ID和考核人Id查询对应考核人签到信息
	  * @param paramMap
	  * @return
	  */
	public  List<SignIn> querySignIn(HashMap<String, Object> paramMap);
	 /**
	  * 根据警员Id查询某段时间的巡逻轨迹信息
	  * @param paramMap
	  * @return
	  */
	public  List<GpsRecord> queryTrackPlayback(HashMap<String, Object> paramMap);
	 /**
	  * 查询我的考核上传的附件信息
	  * @param paramMap
	  * @return
	  */
	public  List<QwAssessmentAttachment> queryAssessAttachment(HashMap<String, Object> paramMap);
	 /**
	  * 新增勤务考核附件
	  * @param paramMap
	  * @return
	  */
	public  int addAssessAttachment(HashMap<String, Object> paramMap);
}
