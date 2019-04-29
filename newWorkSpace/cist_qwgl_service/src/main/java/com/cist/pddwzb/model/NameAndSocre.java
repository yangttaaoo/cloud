package com.cist.pddwzb.model;

public class NameAndSocre {
	private String topic_name;
	private Integer score;
	private Integer pk_id;
	private Integer default_value;

	public String getTopic_name() {
		return topic_name;
	}
	
	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
	public Integer getPk_id() {
		return pk_id;
	}
	
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	
	public Integer getDefault_value() {
		return default_value;
	}
	
	public void setDefault_value(Integer default_value) {
		this.default_value = default_value;
	}

}
