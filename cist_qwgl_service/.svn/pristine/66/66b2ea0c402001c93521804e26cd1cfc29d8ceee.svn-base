package com.cist.myDuty.myAssess.model;

import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 9.35.个人勤务考核(QW_INDIVIDUAL_ASSESSMENT)
 * 
 * @author xh
 *
 */
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
	// 记录作废原因
	private String record_invalid_reason;
	// 审核不通过原因
	private String verify_not_pass_reason;
	// 临时=>管理单位名字
	private String fk_dept_name;
	// 临时=>数据来源名字
	private String data_sources_name;
	// 临时=>审核状态名字
	private String verify_status_name;
	// 临时=>考核条例名字
	private String fk_regulations_name;
	// 临时=>考核栏目名字
	private String fk_topic_name;
	// 临时=>考核人按考核类型拼接显示的名字
	private String fk_user_name;
	// 临时=>考核人纯名字
	private String assess_person_name;
	// 临时=>录入人名字
	private String input_person_name;
	// 临时=>报备人Id
	private long report_person_id;
	// 临时=>报备人名字
	private String report_person_name;
	// 临时=>勤务巡区名称
	private String fk_patrol_area_name;
	// 临时=>修改原因
	private String edit_reason;
	// 临时=>修改时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date edit_time;
	// 临时=>修改人ID
	private Long fk_edit_user_id;
	// 临时=>修改人名字
	private String fk_edit_user_name;
	// 临时=>反馈状态
	private String feedback_state;
	// 临时=>回复状态
	private String reply_state;
	// 临时=>报备类型(勤务报备QW_REPORT)
	private Character report_type;
	//警车、警车关联人员集合，存放json对象（冗余数据）
	private String car_list_str;
	//关联人员集合，存放人员类型、姓名、警号、呼号、电话号码json对象（冗余数据）
	private String personnel_list_str;
	
	
	
	
	
	public String getCar_list_str() {
		return car_list_str;
	}

	public void setCar_list_str(String car_list_str) {
		this.car_list_str = car_list_str;
	}

	public String getPersonnel_list_str() {
		return personnel_list_str;
	}

	public void setPersonnel_list_str(String personnel_list_str) {
		this.personnel_list_str = personnel_list_str;
	}

	public String getAssess_person_name() {
		return assess_person_name;
	}

	public void setAssess_person_name(String assess_person_name) {
		this.assess_person_name = assess_person_name;
	}

	public String getFk_dept_name() {
		return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT, Long.toString(fk_dept_id));
	}

	public Character getReport_type() {
		return report_type;
	}

	public void setReport_type(Character report_type) {
		this.report_type = report_type;
	}

	public String getFeedback_state() {
		if ("1".equals(feedback_state))
			return "已反馈";

		return "未反馈";
	}

	public void setFeedback_state(String feedback_state) {
		this.feedback_state = feedback_state;
	}

	public String getReply_state() {
		if ("1".equals(reply_state))
			return "已回复";

		return "未回复";
	}

	public void setReply_state(String reply_state) {
		this.reply_state = reply_state;
	}

	public String getFk_edit_user_name() {
		if (fk_edit_user_id != null) {
			StringBuffer strBuf = new StringBuffer();
			strBuf.append(SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, Long.toString(fk_edit_user_id)));
			strBuf.append("(").append(fk_edit_user_id).append(")");
			return strBuf.toString();
		}
		return null;
	}

	public String getEdit_reason() {
		return edit_reason;
	}

	public void setEdit_reason(String edit_reason) {
		this.edit_reason = edit_reason;
	}

	public Date getEdit_time() {
		return edit_time;
	}

	public void setEdit_time(Date edit_time) {
		this.edit_time = edit_time;
	}

	public Long getFk_edit_user_id() {
		return fk_edit_user_id;
	}

	public void setFk_edit_user_id(Long fk_edit_user_id) {
		this.fk_edit_user_id = fk_edit_user_id;
	}

	public String getFk_patrol_area_name() {
		return fk_patrol_area_name;
	}

	public void setFk_patrol_area_name(String fk_patrol_area_name) {
		this.fk_patrol_area_name = fk_patrol_area_name;
	}

	public long getReport_person_id() {
		return report_person_id;
	}

	public void setReport_person_id(long report_person_id) {
		this.report_person_id = report_person_id;
	}

	public String getReport_person_name() {
		StringBuffer strBuf = new StringBuffer();
		strBuf.append(SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, Long.toString(report_person_id)));
		strBuf.append("(").append(report_person_id).append(")");

		return strBuf.toString();
	}

	public String getData_sources_name() {
		String name = "系统录入";
		if (data_sources_type != 0) {
			StringBuffer strBuf = new StringBuffer();
			strBuf.append(SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, Long.toString(data_sources_type)));
			strBuf.append("(").append(data_sources_type).append(")录入");
			name = strBuf.toString();
		}
		return name;
	}

	public String getVerify_status_name() {
		return verify_status_name;
	}

	public void setVerify_status_name(String verify_status_name) {
		this.verify_status_name = verify_status_name;
	}

	public String getFk_regulations_name() {
		return fk_regulations_name;
	}

	public void setFk_regulations_name(String fk_regulations_name) {
		this.fk_regulations_name = fk_regulations_name;
	}

	public String getFk_topic_name() {
		return fk_topic_name;
	}

	public void setFk_topic_name(String fk_topic_name) {
		this.fk_topic_name = fk_topic_name;
	}

	public String getFk_user_name() {
		return fk_user_name;
	}

	public void setFk_user_name(String fk_user_name) {
		this.fk_user_name = fk_user_name;
	}

	public String getInput_person_name() {
		StringBuffer strBuf = new StringBuffer();
		strBuf.append(SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, Long.toString(input_person)));
		strBuf.append("(").append(input_person).append(")");
		return strBuf.toString();
	}

	public void setInput_person_name(String input_person_name) {
		this.input_person_name = input_person_name;
	}

	public IndividualAssessment() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getRecord_invalid_reason() {
		return record_invalid_reason;
	}

	public void setRecord_invalid_reason(String record_invalid_reason) {
		this.record_invalid_reason = record_invalid_reason;
	}

	public String getVerify_not_pass_reason() {
		return verify_not_pass_reason;
	}

	public void setVerify_not_pass_reason(String verify_not_pass_reason) {
		this.verify_not_pass_reason = verify_not_pass_reason;
	}

}
