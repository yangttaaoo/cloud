package com.cist.assessStatisticalRelease.assessTotalityAnalysis.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class IndividualAssessment {
	// ID
	private long pk_id;
	// 管理部门ID
	private long fk_dept_id;
	// 数据来源（0：系统录入；用户ID）
	private long data_sources_type;
	// 考核类型（1：勤务考核；2：非现考核；3：其他）
	private char assessment_type;
	// 考核人ID
	private long fk_user_id;
	// 勤务报备ID
	private long fk_report_id;
	// 考核条数
	private int assessment_num;
	// 审核条数
	private int verify_num;
	// 执勤开始日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date start_date;
	// 执勤结束日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date end_date;
	// 执勤区域ID
	private Long fk_patrol_area_id;
	// 是否配枪（0：否；1：是）
	private Character own_guns;
	// 考核栏目ID
	private long fk_topic_id;
	// 考核条例ID
	private long fk_regulations_id;
	// 说明
	private String explain;
	// 录入人ID
	private Long input_person;
	// 录入时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date input_time;
	// 审核状态（0：未审核、1：已审核）
	private Character verify_status;
	// 审核人ID
	private Long fk_verify_person_id;
	// 审核时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date verify_time;

	private AppraiseRegulations appraiseRegulations;
	private Long test;

	public Long getTest() {
		return test;
	}

	public void setTest(Long test) {
		this.test = test;
	}

	public long getPk_id() {
		return pk_id;
	}

	public void setPk_id(long pk_id) {
		this.pk_id = pk_id;
	}

	public long getFk_dept_id() {
		return fk_dept_id;
	}

	public void setFk_dept_id(long fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}

	public long getData_sources_type() {
		return data_sources_type;
	}

	public void setData_sources_type(long data_sources_type) {
		this.data_sources_type = data_sources_type;
	}

	public char getAssessment_type() {
		return assessment_type;
	}

	public void setAssessment_type(char assessment_type) {
		this.assessment_type = assessment_type;
	}

	public long getFk_user_id() {
		return fk_user_id;
	}

	public void setFk_user_id(long fk_user_id) {
		this.fk_user_id = fk_user_id;
	}

	public long getFk_report_id() {
		return fk_report_id;
	}

	public void setFk_report_id(long fk_report_id) {
		this.fk_report_id = fk_report_id;
	}

	public int getAssessment_num() {
		return assessment_num;
	}

	public void setAssessment_num(int assessment_num) {
		this.assessment_num = assessment_num;
	}

	public int getVerify_num() {
		return verify_num;
	}

	public void setVerify_num(int verify_num) {
		this.verify_num = verify_num;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Long getFk_patrol_area_id() {
		return fk_patrol_area_id;
	}

	public void setFk_patrol_area_id(Long fk_patrol_area_id) {
		this.fk_patrol_area_id = fk_patrol_area_id;
	}

	public Character getOwn_guns() {
		return own_guns;
	}

	public void setOwn_guns(Character own_guns) {
		this.own_guns = own_guns;
	}

	public long getFk_topic_id() {
		return fk_topic_id;
	}

	public void setFk_topic_id(long fk_topic_id) {
		this.fk_topic_id = fk_topic_id;
	}

	public long getFk_regulations_id() {
		return fk_regulations_id;
	}

	public void setFk_regulations_id(long fk_regulations_id) {
		this.fk_regulations_id = fk_regulations_id;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public Long getInput_person() {
		return input_person;
	}

	public void setInput_person(Long input_person) {
		this.input_person = input_person;
	}

	public Date getInput_time() {
		return input_time;
	}

	public void setInput_time(Date input_time) {
		this.input_time = input_time;
	}

	public Character getVerify_status() {
		return verify_status;
	}

	public void setVerify_status(Character verify_status) {
		this.verify_status = verify_status;
	}

	public Long getFk_verify_person_id() {
		return fk_verify_person_id;
	}

	public void setFk_verify_person_id(Long fk_verify_person_id) {
		this.fk_verify_person_id = fk_verify_person_id;
	}

	public Date getVerify_time() {
		return verify_time;
	}

	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}

	public AppraiseRegulations getAppraiseRegulations() {
		return appraiseRegulations;
	}

	public void setAppraiseRegulations(AppraiseRegulations appraiseRegulations) {
		this.appraiseRegulations = appraiseRegulations;
	}

}
