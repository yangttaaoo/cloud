package com.cist.assessStatisticalRelease.assessTotalityAnalysis.model;
/**
 * 9.34.个人/单位指标(QW_I_C_METRICS)
 * @author 57150
 *
 */

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ICMetrics implements Comparator<ICMetrics>{
	// ID
	private Long pk_id;
	// 管理部门ID
	private Long fk_dept_id;
	// 指标类型（1：个人；2：单位）
	private Character metrics_type;
	// 人员/单位ID
	private Long fk_user_id;
	// 评定日期类型（1：年；2：季度；3：月）
	private Character evaluate_date_type;
	// 评定日期开始
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date evaluate_date_start;
	// 评定日期结束
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date evaluate_date_end;
	// 备注
	private String remarks;
	// 评价指标
	private List<EvaluateMetrics> evaluateMetricsList;
	// 考核栏目
	// private AppraiseTopic appraiseTopicList;

	private String topic_name;

	@Override
	public int compare(ICMetrics o1, ICMetrics o2) {
		// TODO Auto-generated method stub
		return o1.getFk_user_id().compareTo(o2.getFk_user_id());
	}
	public String getTopic_name() {
		return topic_name;
	}

	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}

	// public AppraiseTopic getAppraiseTopicList() {
	// return appraiseTopicList;
	// }
	// public void setAppraiseTopicList(AppraiseTopic appraiseTopicList) {
	// this.appraiseTopicList = appraiseTopicList;
	// }
	public List<EvaluateMetrics> getEvaluateMetricsList() {
		return evaluateMetricsList;
	}

	public void setEvaluateMetricsList(List<EvaluateMetrics> evaluateMetricsList) {
		this.evaluateMetricsList = evaluateMetricsList;
	}

	public Long getPk_id() {
		return pk_id;
	}

	public void setPk_id(Long pk_id) {
		this.pk_id = pk_id;
	}

	public Long getFk_dept_id() {
		return fk_dept_id;
	}

	public void setFk_dept_id(Long fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}

	public Character getMetrics_type() {
		return metrics_type;
	}

	public void setMetrics_type(Character metrics_type) {
		this.metrics_type = metrics_type;
	}

	public Long getFk_user_id() {
		return fk_user_id;
	}

	public void setFk_user_id(Long fk_user_id) {
		this.fk_user_id = fk_user_id;
	}

	public Character getEvaluate_date_type() {
		return evaluate_date_type;
	}

	public void setEvaluate_date_type(Character evaluate_date_type) {
		this.evaluate_date_type = evaluate_date_type;
	}

	public Date getEvaluate_date_start() {
		return evaluate_date_start;
	}

	public void setEvaluate_date_start(Date evaluate_date_start) {
		this.evaluate_date_start = evaluate_date_start;
	}

	public Date getEvaluate_date_end() {
		return evaluate_date_end;
	}

	public void setEvaluate_date_end(Date evaluate_date_end) {
		this.evaluate_date_end = evaluate_date_end;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}




}
