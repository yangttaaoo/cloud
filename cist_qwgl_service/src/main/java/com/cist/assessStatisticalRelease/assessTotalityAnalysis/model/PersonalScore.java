package com.cist.assessStatisticalRelease.assessTotalityAnalysis.model;

public class PersonalScore {
private Long fk_user_id;
private Long fk_topic_id;
private Long indicator_score;
private Long fk_regulations_id;
private Long assess_score;
public Long getFk_user_id() {
	return fk_user_id;
}
public void setFk_user_id(Long fk_user_id) {
	this.fk_user_id = fk_user_id;
}
public Long getFk_topic_id() {
	return fk_topic_id;
}
public void setFk_topic_id(Long fk_topic_id) {
	this.fk_topic_id = fk_topic_id;
}
public Long getIndicator_score() {
	return indicator_score;
}
public void setIndicator_score(Long indicator_score) {
	this.indicator_score = indicator_score;
}

public Long getFk_regulations_id() {
	return fk_regulations_id;
}
public void setFk_regulations_id(Long fk_regulations_id) {
	this.fk_regulations_id = fk_regulations_id;
}
public Long getAssess_score() {
	return assess_score;
}
public void setAssess_score(Long assess_score) {
	this.assess_score = assess_score;
}



}
