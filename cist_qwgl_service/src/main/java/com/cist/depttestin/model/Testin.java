package com.cist.depttestin.model;

import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class Testin {
	
	private int pk_id;// id
	private Integer fk_dept_id;// 部门id
	private String fk_dept_name;//部门名字
	private Integer data_sources_type;// 数据来源（0：系统录入；1：其他）
	private char assessment_type;// 考核类型（1：勤务考核；2：非现考核；3：其他）
	private Date start_date;// 考核开始日期
	private Date end_date;// 考核结束日期
	private String explain;// 说明
	private Integer input_person;// 录入人Id
	private String input_name;//录入人姓名
	private Date input_time;// 录入时间
	private char verify_status;// 审核状态审核状态（0：未审核；1：已审核；2：审核不通过；3：作废）
	private int fk_verify_person_id;// 审核人Id
	private Date verify_time;// 审核时间
	private String record_invalid_reason;//记录作废的原因
	private String verify_not_pass_reason;//审核不通过的原因
	private int fk_comp_assessment_id;//单位勤务考核Id
	private int fk_topic_id;//栏目ID
	private int metrics_num;//直标分值
	public int getPk_id() {
		return pk_id;
	}
	public void setPk_id(int pk_id) {
		this.pk_id = pk_id;
	}
	public Integer getFk_dept_id() {
		return fk_dept_id;
	}
	public void setFk_dept_id(Integer pk_dept_id) {
		this.fk_dept_id = pk_dept_id;
	}
	public Integer getData_sources_type() {
		return data_sources_type;
	}
	public void setData_sources_type(Integer data_sources_type) {
		this.data_sources_type = data_sources_type;
	}
	public char getAssessment_type() {
		return assessment_type;
	}
	public void setAssessment_type(char assessment_type) {
		this.assessment_type = assessment_type;
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
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public Integer getInput_person() {
		return input_person;
	}
	public void setInput_person(Integer input_person) {
		this.input_person = input_person;
	}
	public Date getInput_time() {
		return input_time;
	}
	public void setInput_time(Date input_time) {
		this.input_time = input_time;
	}
	public char getVerify_status() {
		return verify_status;
	}
	public void setVerify_status(char verify_status) {
		this.verify_status = verify_status;
	}
	public int getFk_verify_person_id() {
		return fk_verify_person_id;
	}
	public void setFk_verify_person_id(int fk_verify_person_id) {
		this.fk_verify_person_id = fk_verify_person_id;
	}
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
	public String getRecoro_invalid_reason() {
		return record_invalid_reason;
	}
	public void setRecoro_invalid_reason(String record_invalid_reason) {
		this.record_invalid_reason = record_invalid_reason;
	}
	public String getVerify_not_pass_reason() {
		return verify_not_pass_reason;
	}
	public void setVerify_not_pass_reason(String verify_not_pass_reason) {
		this.verify_not_pass_reason = verify_not_pass_reason;
	}
	public int getFk_comp_assessment_id() {
		return fk_comp_assessment_id;
	}
	public void setFk_comp_assessment_id(int fk_comp_assessment_id) {
		this.fk_comp_assessment_id = fk_comp_assessment_id;
	}
	public int getFk_topic_id() {
		return fk_topic_id;
	}
	public void setFk_topic_id(int fk_topic_id) {
		this.fk_topic_id = fk_topic_id;
	}
	public int getMetrics_num() {
		return metrics_num;
	}
	public void setMetrics_num(int metrics_num) {
		this.metrics_num = metrics_num;
	}
	public String getInput_name() {
		input_name=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, input_person.toString()); ;
		return input_name;
	}
	public void setInput_name(String input_name) {
		this.input_name = input_name;
	}
	public String getFk_dept_name() {
		fk_dept_name=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT_PK, fk_dept_id.toString());
		return fk_dept_name;
	}
	public void setFk_dept_name(String fk_dept_name) {
		this.fk_dept_name = fk_dept_name;
	}
	
}
