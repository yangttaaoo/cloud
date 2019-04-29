package com.cist.qwgrfx.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
public class IndividualInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer pk_id;//ID
	private Double fk_dept_id;//管理部门ID
	private String fk_dept_name;//管理部门中文名
	private char data_sources_type;//数据来源（0：系统录入；1：其他）
	private String data_sources_name;//数据来源中文名称
	private char assessment_type;//考核类型（1：勤务考核；2：非现考核；3：其他）
	private String assessment_name;//考核类型中文名称
	private Integer fk_user_id;//考核人ID	
	private String fk_user_name;//考核人姓名
	private Integer fk_report_id;//勤务报备ID
	private String fk_report_name;
	private String assessment_rules;
	private Integer num;//
	private String regulations_name;
	private Integer assessment_num;//考核条数
	private Integer verify_num;//审核条数
	private Date start_date;//执勤开始日期
	private String start_date_name;
	private Date end_date;//执勤结束日期
	private String end_date_name;
	private String daterng;
	private Integer fk_patrol_area_id;//执勤区域ID
	private String fk_patrol_area_name;//执勤区域名称
	private char own_guns;//是否配枪（0：否；1：是）
	private String own_guns_name;
	private Integer fk_topic_id;//考核栏目ID
	private String fk_topic_name;
	private Integer fk_regulations_id;//考核条例ID
	private String fk_regulations_name;
	
	private String explain;//说明
	private Integer input_person;//录入人ID
	private String input_name;
	private Date input_time;//录入时间
	private String input_time_name;//录入时间中文
	private char verify_status;//审核状态（0：未审核、1：已审核）

	private String verify_name;//审核状态中文名
	private Integer fk_verify_person_id;//审核人ID
	private Date verify_time;//审核时间
	private String record_invalid_reason;//作废原因
	private Integer att_pk_id;//附件表ID
	private Integer fk_relation_id;//关联表ID
	private String attachment_source;//附件路径
	private List<IndividualInfo> tp;//图片List

	
	
	public String getFk_patrol_area_name() {
		return fk_patrol_area_name;
	}

	public void setFk_patrol_area_name(String fk_patrol_area_name) {
		this.fk_patrol_area_name = fk_patrol_area_name;
	}

	public String getFk_report_name() {
		return fk_report_name;
	}

	public void setFk_report_name(String fk_report_name) {
		this.fk_report_name = fk_report_name;
	}

	public String getFk_topic_name() {
		return fk_topic_name;
	}

	public void setFk_topic_name(String fk_topic_name) {
		this.fk_topic_name = fk_topic_name;
	}

	public String getFk_regulations_name() {
		return fk_regulations_name;
	}

	public void setFk_regulations_name(String fk_regulations_name) {
		this.fk_regulations_name = fk_regulations_name;
	}

	public String getInput_name() {
		
		if (input_person != null){
			
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, input_person.toString()); 
		}
		
		return input_name;
	}

	public void setInput_name(String input_name) {
		this.input_name = input_name;
	}

	public String getDaterng() {
		return daterng;
	}

	public void setDaterng(String daterng) {
		this.daterng = daterng;
	}

	public String getStart_date_name() {
		return start_date_name;
	}

	public void setStart_date_name(String start_date_name) {
		this.start_date_name = start_date_name;
	}

	public String getEnd_date_name() {
		return end_date_name;
	}

	public void setEnd_date_name(String end_date_name) {
		this.end_date_name = end_date_name;
	}

	public String getFk_dept_name() {
		if (fk_dept_id != null){
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT, fk_dept_id.toString()); 
		}
		return fk_dept_name;
	}

	public void setFk_dept_name(String fk_dept_name) {
		this.fk_dept_name = fk_dept_name;
	}


	public String getAssessment_name() {
		return assessment_name;
	}

	public void setAssessment_name(char assessment_name) {
		if(assessment_name == '1'){
			this.assessment_name = "勤务考核";
		}else if(assessment_name == '2'){
			this.assessment_name = "非现考核";
		}else{
			this.assessment_name = "其他";
		}
	}



	public String getData_sources_name() {
		return data_sources_name;
	}



	public void setData_sources_name(char data_sources_name) {
		if(data_sources_name == '0'){
			this.data_sources_name = "系统录入";
		}else{
			this.data_sources_name = "录入";
		}
	}



	public String getInput_time_name() {
		return input_time_name;
	}



	public void setInput_time_name(String input_time_name) {
		this.input_time_name = input_time_name;
	}



	public String getVerify_name() {
		return verify_name;
	}



	public void setVerify_name(char verify_name) {
		if(verify_name=='1'){
			this.verify_name = "已审核";
		}else if(verify_name == '0'){
			this.verify_name = "未审核";
		}else{
			this.verify_name = "审核作废";
		}
		 
	}



	public String getFk_user_name() {
		
	if (fk_user_id != null){
			
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, fk_user_id.toString()); 
		}
		return fk_user_name;
	}



	public void setFk_user_name(String fk_user_name) {
		this.fk_user_name = fk_user_name;
	}



	public List<IndividualInfo> getTp() {
		return tp;
	}
	public void setTp(List<IndividualInfo> tp) {
		this.tp = tp;
	}
	public Integer getAtt_pk_id() {
		return att_pk_id;
	}
	public void setAtt_pk_id(Integer att_pk_id) {
		this.att_pk_id = att_pk_id;
	}
	public Integer getFk_relation_id() {
		return fk_relation_id;
	}
	public void setFk_relation_id(Integer fk_relation_id) {
		this.fk_relation_id = fk_relation_id;
	}
	public String getAttachment_source() {
		return attachment_source;
	}
	public void setAttachment_source(String attachment_source) {
		this.attachment_source = attachment_source;
	}
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
	public char getData_sources_type() {
		return data_sources_type;
	}
	public void setData_sources_type(char data_sources_type) {
		this.setData_sources_name(data_sources_type);
		this.data_sources_type = data_sources_type;
	}
	public char getAssessment_type() {
		return assessment_type;
	}
	public void setAssessment_type(char assessment_type) {
		this.assessment_type = assessment_type;
		this.setAssessment_name(assessment_type);
	}
	public Integer getFk_user_id() {
		return fk_user_id;
	}
	public void setFk_user_id(Integer fk_user_id) {
		this.fk_user_id = fk_user_id;
	}
	public Integer getFk_report_id() {
		return fk_report_id;
	}
	public void setFk_report_id(Integer fk_report_id) {
		this.fk_report_id = fk_report_id;
	}
	public Integer getAssessment_num() {
		return assessment_num;
	}
	public void setAssessment_num(Integer assessment_num) {
		this.assessment_num = assessment_num;
	}
	public Integer getVerify_num() {
		return verify_num;
	}
	public void setVerify_num(Integer verify_num) {
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
	public Integer getFk_patrol_area_id() {
		return fk_patrol_area_id;
	}
	public void setFk_patrol_area_id(Integer fk_patrol_area_id) {
		this.fk_patrol_area_id = fk_patrol_area_id;
	}
	public char getOwn_guns() {
		return own_guns;
	}
	public void setOwn_guns(char own_guns) {
		this.own_guns = own_guns;
	}
	public Integer getFk_topic_id() {
		return fk_topic_id;
	}
	public void setFk_topic_id(Integer fk_topic_id) {
		this.fk_topic_id = fk_topic_id;
	}
	public Integer getFk_regulations_id() {
		return fk_regulations_id;
	}
	public void setFk_regulations_id(Integer fk_regulations_id) {
		this.fk_regulations_id = fk_regulations_id;
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
		this.setVerify_name(verify_status);
	}
	public Integer getFk_verify_person_id() {
		return fk_verify_person_id;
	}
	public void setFk_verify_person_id(Integer fk_verify_person_id) {
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

	public String getOwn_guns_name() {
		if (own_guns=='1'){
			return "是";
		}else{
			return  "否";
		}
		
	}

	public void setOwn_guns_name(String own_guns_name) {
		this.own_guns_name = own_guns_name;
	}

	public String getRegulations_name() {
		return regulations_name;
	}

	public void setRegulations_name(String regulations_name) {
		this.regulations_name = regulations_name;
	}

	public String getAssessment_rules() {
		return assessment_rules;
	}

	public void setAssessment_rules(String assessment_rules) {
		this.assessment_rules = assessment_rules;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
	
}
