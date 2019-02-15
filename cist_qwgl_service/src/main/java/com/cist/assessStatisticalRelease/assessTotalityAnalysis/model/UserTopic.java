package com.cist.assessStatisticalRelease.assessTotalityAnalysis.model;

public class UserTopic {
	private Long fk_user_id;
	private Long fk_topic_id;

	private String fk_user_name;
	private String fk_topic_name;

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

	public String getFk_user_name() {
		return fk_user_name;
	}

	public void setFk_user_name(String fk_user_name) {
		this.fk_user_name = fk_user_name;
	}

	public String getFk_topic_name() {
		return fk_topic_name;
	}

	public void setFk_topic_name(String fk_topic_name) {
		this.fk_topic_name = fk_topic_name;
	}

}
