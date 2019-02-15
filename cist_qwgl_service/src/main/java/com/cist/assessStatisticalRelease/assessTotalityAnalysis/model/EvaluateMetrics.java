package com.cist.assessStatisticalRelease.assessTotalityAnalysis.model;

import java.util.List;

/**
 * EvaluateMetrics 9.35.评价指标(QW_EVALUATE_METRICS)
 * 
 * @author 57150
 *
 */
public class EvaluateMetrics {
	// ID
	private Long pk_id;
	// 个人/单位ID
	private Long fk_relation_id;
	// 栏目ID
	private Long fk_topic_id;
	// 指标分值
	private Long metrics_num;
	private List<TempSore> tempSoreList;



	public List<TempSore> getTempSoreList() {
		return tempSoreList;
	}

	public void setTempSoreList(List<TempSore> tempSoreList) {
		this.tempSoreList = tempSoreList;
	}

	/*
	 * private IndividualAssessment individualAssessment;
	 * 
	 * 
	 * 
	 * public IndividualAssessment getIndividualAssessment() { return
	 * individualAssessment; } public void
	 * setIndividualAssessment(IndividualAssessment individualAssessment) {
	 * this.individualAssessment = individualAssessment; }
	 */
	public Long getPk_id() {
		return pk_id;
	}

	public void setPk_id(Long pk_id) {
		this.pk_id = pk_id;
	}

	public Long getFk_relation_id() {
		return fk_relation_id;
	}

	public void setFk_relation_id(Long fk_relation_id) {
		this.fk_relation_id = fk_relation_id;
	}

	public Long getFk_topic_id() {
		return fk_topic_id;
	}

	public void setFk_topic_id(Long fk_topic_id) {
		this.fk_topic_id = fk_topic_id;
	}

	public Long getMetrics_num() {
		return metrics_num;
	}

	public void setMetrics_num(Long metrics_num) {
		this.metrics_num = metrics_num;
	}

}
