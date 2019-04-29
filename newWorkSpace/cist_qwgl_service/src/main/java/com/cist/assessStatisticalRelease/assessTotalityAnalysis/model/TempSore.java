package com.cist.assessStatisticalRelease.assessTotalityAnalysis.model;

public class TempSore {
	// 评定分值
	private Long actual_num;
	// 加分
	private Long bonus_score;
	// 减分
	private Long buckle_score;
	// 栏目名
	private String appraise_topic_name;
	//默认分值
	private Long default_value;
	//评定指标
	private Long metrics_num;
	
	public TempSore() {
	}

	

	public TempSore(Long actual_num, Long bonus_score, Long buckle_score, String appraise_topic_name,
			Long default_value, Long metrics_num) {
		super();
		this.actual_num = actual_num;
		this.bonus_score = bonus_score;
		this.buckle_score = buckle_score;
		this.appraise_topic_name = appraise_topic_name;
		this.default_value = default_value;
		this.metrics_num = metrics_num;
	}



	public Long getDefault_value() {
		return default_value;
	}

	public Long getMetrics_num() {
		return metrics_num;
	}

	public void setMetrics_num(Long metrics_num) {
		this.metrics_num = metrics_num;
	}

	public void setDefault_value(Long default_value) {
		this.default_value = default_value;
	}

	public String getAppraise_topic_name() {
		return appraise_topic_name;
	}

	public void setAppraise_topic_name(String appraise_topic_name) {
		this.appraise_topic_name = appraise_topic_name;
	}

	public Long getActual_num() {
		return actual_num;
	}

	public void setActual_num(Long actual_num) {
		this.actual_num = actual_num;
	}

	public Long getBonus_score() {
		return bonus_score;
	}

	public void setBonus_score(Long bonus_score) {
		this.bonus_score = bonus_score;
	}

	public Long getBuckle_score() {
		return buckle_score;
	}

	public void setBuckle_score(Long buckle_score) {
		this.buckle_score = buckle_score;
	}

}
