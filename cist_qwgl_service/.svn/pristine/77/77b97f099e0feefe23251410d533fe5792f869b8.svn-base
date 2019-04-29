package com.cist.personalentry.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
public class IndividualInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer pk_id;//ID
	private String fk_dept_id;//管理部门ID
	private String fk_dept_name;//管理部门中文名
	private String data_sources_type;//数据来源（0：系统录入；1：其他）
	private String data_sources_name;//数据来源中文名称
	private String assessment_type;//考核类型（1：勤务考核；2：非现考核；3：其他）
	private String assessment_name;//考核类型中文名称
	private String fk_user_id;//考核人ID	
	private String fk_user_name;//考核人姓名
	private String fk_report_id;//勤务报备ID
	private String report_type;//勤务报备类型
	private String fk_report_name;
	private String assessment_num;//考核条数
	private String verify_num;//审核条数
	private String start_date;//执勤开始日期
	private String start_date_name;
	private String end_date;//执勤结束日期
	private String end_date_name;
	private String daterng;
	private String fk_patrol_area_id;//执勤区域ID
	private String fk_patrol_area_name;//执勤区域名称
	private String own_guns;//是否配枪（0：否；1：是）
	private String fk_topic_id;//考核栏目ID
	private String fk_topic_name;
	private String fk_regulations_id;//考核条例ID
	private String fk_regulations_name;
	private String explain;//说明
	private String input_person;//录入人ID
	private String input_name;
	private String input_time;//录入时间
	private String input_time_name;//录入时间中文
	private String verify_status;//审核状态（0：未审核、1：已审核）
	private String verify_name;//审核状态中文名
	private String fk_verify_person_id;//审核人ID
	private String verify_time;//审核时间
	private String record_invalid_reason;//作废原因
	private String att_pk_id;//附件表ID
	private String fk_relation_id;//关联表ID
	private String attachment_source;//附件路径
	private String xm;
	private String sypi_name;
	private List<IndividualInfo> tp;//图片List
	private String assessment_typename;
	private String input_timename;
	private String data_sources_typename;
	private String verify_statusname;
	private String dept_name;
	private String edit_reason;
	
	public String getEdit_reason() {
		return edit_reason;
	}
	public void setEdit_reason(String edit_reason) {
		this.edit_reason = edit_reason;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getVerify_statusname() {
		if(null!=verify_status) {
			if(verify_status.equals("0")) {
				return "未审核";
			}else if(verify_status.equals("1")) {
				return "已审核";
			}else if(verify_status.equals("2")) {
				return "审核不通过";
			}else if(verify_status.equals("3")) {
				return "作废";
			}
		}
		return verify_statusname;
	}
	public void setVerify_statusname(String verify_statusname) {
		this.verify_statusname = verify_statusname;
	}
	public String getData_sources_typename() {
		if(null!=data_sources_type) {
			if(data_sources_type.equals("0")) {
				return "系统录入";
			}else {
				return sypi_name;
			}
		}
		return data_sources_typename;
	}
	public void setData_sources_typename(String data_sources_typename) {
		this.data_sources_typename = data_sources_typename;
	}
	public String getInput_timename() {
		/*if(null!=input_time) {
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return df.format(input_time);
		}*/
		return input_timename;
	}
	public void setInput_timename(String input_timename) {
		this.input_timename = input_timename;
	}
	public String getAssessment_typename() {
		if(null!=assessment_type) {
			 if(assessment_type.equals("1")) {
				 return "勤务考核";
			 }else if(assessment_type.equals("2")) {
				 return "非现考核";
			 }else {
				 return "其他";
			 }
		}
		return assessment_typename;
	}
	public void setAssessment_typename(String assessment_typename) {
		this.assessment_typename = assessment_typename;
	}
	public String getSypi_name() {
		return sypi_name;
	}
	public void setSypi_name(String sypi_name) {
		this.sypi_name = sypi_name;
	}
	public String getXm() {
		if(null!=assessment_type) {
			if(assessment_type.equals("1")) {
				return fk_report_name;
			}
		}
		return xm;
	}
	public void setXm(String xm) {
		
		this.xm = xm;
	}
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public String getFk_dept_id() {
		return fk_dept_id;
	}
	public void setFk_dept_id(String fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}
	public String getFk_dept_name() {
		return fk_dept_name;
	}
	public void setFk_dept_name(String fk_dept_name) {
		this.fk_dept_name = fk_dept_name;
	}
	public String getData_sources_type() {
		return data_sources_type;
	}
	public void setData_sources_type(String data_sources_type) {
		this.data_sources_type = data_sources_type;
	}
	public String getData_sources_name() {
		if(null!=data_sources_type) {
			if(data_sources_type.equals("0")) {
				return "系统录入";
			}else {
				return "系统录入";
			}
		}
		return data_sources_name;
	}
	public void setData_sources_name(String data_sources_name) {
		this.data_sources_name = data_sources_name;
	}
	public String getAssessment_type() {
		return assessment_type;
	}
	public void setAssessment_type(String assessment_type) {
		this.assessment_type = assessment_type;
	}
	public String getAssessment_name() {
		if(null!=assessment_type) {
			if(assessment_type.equals("1")) {
				return "勤务考核";	
			}
			if(assessment_type.equals("2")) {
				return "非现考核";	
						}
			if(assessment_type.equals("3")) {
				return "其他";	
			}
		}
		return assessment_name;
	}
	public void setAssessment_name(String assessment_name) {
		this.assessment_name = assessment_name;
	}
	public String getFk_user_id() {
		return fk_user_id;
	}
	public void setFk_user_id(String fk_user_id) {
		this.fk_user_id = fk_user_id;
	}
	public String getFk_user_name() {
		return fk_user_name;
	}
	public void setFk_user_name(String fk_user_name) {
		this.fk_user_name = fk_user_name;
	}
	public String getFk_report_id() {
		return fk_report_id;
	}
	public void setFk_report_id(String fk_report_id) {
		this.fk_report_id = fk_report_id;
	}
	public String getReport_type() {
		return report_type;
	}
	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}
	public String getFk_report_name() {
		return fk_report_name;
	}
	public void setFk_report_name(String fk_report_name) {
		this.fk_report_name = fk_report_name;
	}
	public String getAssessment_num() {
		return assessment_num;
	}
	public void setAssessment_num(String assessment_num) {
		this.assessment_num = assessment_num;
	}
	public String getVerify_num() {
		return verify_num;
	}
	public void setVerify_num(String verify_num) {
		this.verify_num = verify_num;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getStart_date_name() {
		return start_date_name;
	}
	public void setStart_date_name(String start_date_name) {
		this.start_date_name = start_date_name;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getEnd_date_name() {
		return end_date_name;
	}
	public void setEnd_date_name(String end_date_name) {
		this.end_date_name = end_date_name;
	}
	public String getDaterng() {
		return daterng;
	}
	public void setDaterng(String daterng) {
		this.daterng = daterng;
	}
	public String getFk_patrol_area_id() {
		return fk_patrol_area_id;
	}
	public void setFk_patrol_area_id(String fk_patrol_area_id) {
		this.fk_patrol_area_id = fk_patrol_area_id;
	}
	public String getFk_patrol_area_name() {
		return fk_patrol_area_name;
	}
	public void setFk_patrol_area_name(String fk_patrol_area_name) {
		this.fk_patrol_area_name = fk_patrol_area_name;
	}
	public String getOwn_guns() {
		return own_guns;
	}
	public void setOwn_guns(String own_guns) {
		this.own_guns = own_guns;
	}
	public String getFk_topic_id() {
		return fk_topic_id;
	}
	public void setFk_topic_id(String fk_topic_id) {
		this.fk_topic_id = fk_topic_id;
	}
	public String getFk_topic_name() {
		return fk_topic_name;
	}
	public void setFk_topic_name(String fk_topic_name) {
		this.fk_topic_name = fk_topic_name;
	}
	public String getFk_regulations_id() {
		return fk_regulations_id;
	}
	public void setFk_regulations_id(String fk_regulations_id) {
		this.fk_regulations_id = fk_regulations_id;
	}
	public String getFk_regulations_name() {
		return fk_regulations_name;
	}
	public void setFk_regulations_name(String fk_regulations_name) {
		this.fk_regulations_name = fk_regulations_name;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public String getInput_person() {
		return input_person;
	}
	public void setInput_person(String input_person) {
		this.input_person = input_person;
	}
	public String getInput_name() {
		return input_name;
	}
	public void setInput_name(String input_name) {
		this.input_name = input_name;
	}
	public String getInput_time() {
		return input_time;
	}
	public void setInput_time(String input_time) {
		this.input_time = input_time;
	}
	public String getInput_time_name() {
		return input_time_name;
	}
	public void setInput_time_name(String input_time_name) {
		this.input_time_name = input_time_name;
	}
	public String getVerify_status() {
		return verify_status;
	}
	public void setVerify_status(String verify_status) {
		this.verify_status = verify_status;
	}
	public String getVerify_name() {
		return verify_name;
	}
	public void setVerify_name(String verify_name) {
		this.verify_name = verify_name;
	}
	public String getFk_verify_person_id() {
		return fk_verify_person_id;
	}
	public void setFk_verify_person_id(String fk_verify_person_id) {
		this.fk_verify_person_id = fk_verify_person_id;
	}
	public String getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(String verify_time) {
		this.verify_time = verify_time;
	}
	public String getRecord_invalid_reason() {
		return record_invalid_reason;
	}
	public void setRecord_invalid_reason(String record_invalid_reason) {
		this.record_invalid_reason = record_invalid_reason;
	}
	public String getAtt_pk_id() {
		return att_pk_id;
	}
	public void setAtt_pk_id(String att_pk_id) {
		this.att_pk_id = att_pk_id;
	}
	public String getFk_relation_id() {
		return fk_relation_id;
	}
	public void setFk_relation_id(String fk_relation_id) {
		this.fk_relation_id = fk_relation_id;
	}
	public String getAttachment_source() {
		return attachment_source;
	}
	public void setAttachment_source(String attachment_source) {
		this.attachment_source = attachment_source;
	}
	public List<IndividualInfo> getTp() {
		return tp;
	}
	public void setTp(List<IndividualInfo> tp) {
		this.tp = tp;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public IndividualInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
