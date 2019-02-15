package com.cist.personalentry.model;

import java.io.Serializable;
import java.sql.Date;

public class AppraiseInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer pk_id;//id
	private Double fk_dept_id;//管理部门ID
	private String topic_name;//评定栏目
	private Integer default_value;//默认分值
	private String topic_explain;//栏目说明
	private char enabled_state;//启用状态（0：禁用；1：启用）
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Double getFk_dept_id() {
		return fk_dept_id;
	}
	public void setFk_dept_id(Double fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}
	public String getTopic_name() {
		return topic_name;
	}
	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}
	public Integer getDefault_value() {
		return default_value;
	}
	public void setDefault_value(Integer default_value) {
		this.default_value = default_value;
	}
	public String getTopic_explain() {
		return topic_explain;
	}
	public void setTopic_explain(String topic_explain) {
		this.topic_explain = topic_explain;
	}
	public char getEnabled_state() {
		return enabled_state;
	}
	public void setEnabled_state(char enabled_state) {
		this.enabled_state = enabled_state;
	}
	
	

}
