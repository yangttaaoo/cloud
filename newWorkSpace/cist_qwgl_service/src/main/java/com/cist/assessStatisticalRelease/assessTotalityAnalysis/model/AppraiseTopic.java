package com.cist.assessStatisticalRelease.assessTotalityAnalysis.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AppraiseTopic {
	// ID
	private Long pk_id;
	// 管理部门ID
	private Long fk_dept_id;
	// 评定栏目
	private String topic_name;
	// 默认分值
	private Long default_value;
	// 栏目说明
	private String topic_explain;
	// 启用状态（0：禁用；1：启用）
	private Character enabled_state;
	// 创建人
	private Long create_person_id;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date create_time;
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
	public String getTopic_name() {
		return topic_name;
	}
	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}
	public Long getDefault_value() {
		return default_value;
	}
	public void setDefault_value(Long default_value) {
		this.default_value = default_value;
	}
	public String getTopic_explain() {
		return topic_explain;
	}
	public void setTopic_explain(String topic_explain) {
		this.topic_explain = topic_explain;
	}
	public Character getEnabled_state() {
		return enabled_state;
	}
	public void setEnabled_state(Character enabled_state) {
		this.enabled_state = enabled_state;
	}
	public Long getCreate_person_id() {
		return create_person_id;
	}
	public void setCreate_person_id(Long create_person_id) {
		this.create_person_id = create_person_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

}
