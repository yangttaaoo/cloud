package com.cist.myDuty.myAssess.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 勤务考核反馈回复(QW_APPRAISE_FEEDBACK_RESPONSE)
 * @author 57150
 *
 */
public class FeedbackResponse {
	// id
	private long pk_id;
	// 勤务考核id（个人或者单位考核id）
	private long fk_assessment_id;
	// 勤务考核类型（1：个人；2：单位）
	private char assessment_type;
	// 说明类型（1：反馈说明；2：回复说明）
	private char explain_type;
	// 反馈/回复内容
	private String explain_content;
	// 反馈/回复人id
	private Long fk_user_id;
	// 反馈/回复时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date f_r_time;
	//临时=>反馈人姓名
	private String fk_user_name;
	
	
	public String getFk_user_name() {
		return fk_user_name;
	}
	public void setFk_user_name(String fk_user_name) {
		this.fk_user_name = fk_user_name;
	}
	public long getPk_id() {
		return pk_id;
	}
	public void setPk_id(long pk_id) {
		this.pk_id = pk_id;
	}
	public long getFk_assessment_id() {
		return fk_assessment_id;
	}
	public void setFk_assessment_id(long fk_assessment_id) {
		this.fk_assessment_id = fk_assessment_id;
	}
	public char getAssessment_type() {
		return assessment_type;
	}
	public void setAssessment_type(char assessment_type) {
		this.assessment_type = assessment_type;
	}
	public char getExplain_type() {
		return explain_type;
	}
	public void setExplain_type(char explain_type) {
		this.explain_type = explain_type;
	}
	public String getExplain_content() {
		return explain_content;
	}
	public void setExplain_content(String explain_content) {
		this.explain_content = explain_content;
	}
	public Long getFk_user_id() {
		return fk_user_id;
	}
	public void setFk_user_id(Long fk_user_id) {
		this.fk_user_id = fk_user_id;
	}
	public Date getF_r_time() {
		return f_r_time;
	}
	public void setF_r_time(Date f_r_time) {
		this.f_r_time = f_r_time;
	}
	
	
	

}
