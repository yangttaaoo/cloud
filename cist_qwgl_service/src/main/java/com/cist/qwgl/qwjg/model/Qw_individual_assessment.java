package com.cist.qwgl.qwjg.model;

import java.io.Serializable;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 个人勤务考核
 * 
 * @author Hy
 *
 */
public class Qw_individual_assessment implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -8499669086753015306L;
	private Integer pk_id;// ID
	private String fk_dept_id;// 管理部门ID
	private Integer data_sources_type;// 数据来源（0：系统录入；用户ID）
	private String assessment_type;// 考核类型（1：勤务考核；2：非现考核；3：其他）
	private Integer fk_user_id;// 考核人ID
	private Integer fk_report_id;// 勤务报备ID
	private Integer assessment_num;// 考核条数
	private Integer verify_num;// 审核条数
	private Integer fk_patrol_area_id;// 执勤区域ID
	private String own_guns;// 是否配枪（0：否；1：是）
	private Integer fk_topic_id;// 考核栏目ID
	private Integer fk_regulations_id;// 考核条例ID
	private String explain;// 说明
	private String input_person;// 录入人ID
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date input_time;// 录入时间
	private String verify_status;// 审核状态（0：未审核；1：已审核；2：审核不通过；3：作废）
	private Integer fk_verify_person_id;// 审核人ID
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date verify_time;// 审核时间
	private String record_invalid_reason;// 记录作废原因
	private String verify_not_pass_reason;// 审核不通过原因
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date start_date;// 执勤开始日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date end_date;// 执勤结束日期

	private String sypi_name;// 审核人名字
	private String fk_dept_name;// 管理单位名称
	private String area_name;//执勤区域
	private String topic_name;//考核栏目
	private String input_person_name;//录入人姓名
	private String fksm;//反馈说明
	private String hfsm;//回复说明
	private String fkr;//反馈人
	private String hfr;//回复人
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date fksj;//反馈时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date hfsj;//回复时间

	private String regulations_name;// 条例名称
	private String fkzt;// 反馈状态
	private String fkzt_name;// 反馈状态名称
	private String hfzt;// 回复状态
	private String hfzt_name;// 回复状态名称
	private String verify_status_name;// 审核状态名称
	private String assessment_type_name;// 考核类型名称
	private String own_guns_name;//是否配枪
	private String fkr_name;//反馈人姓名
	private String hfr_name;//回复人姓名

	
	private String xm;//
	private String dept_name;//
	private String dept_pk;//
	private String rybh;//
	private String sypi_names;//
	private String sypi_code;//
	
	public String getSypi_names() {
		return sypi_names;
	}

	public void setSypi_names(String sypi_names) {
		this.sypi_names = sypi_names;
	}

	public String getSypi_code() {
		return sypi_code;
	}

	public void setSypi_code(String sypi_code) {
		this.sypi_code = sypi_code;
	}

	public String getRybh() {
		return rybh;
	}

	public void setRybh(String rybh) {
		this.rybh = rybh;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDept_pk() {
		return dept_pk;
	}

	public void setDept_pk(String dept_pk) {
		this.dept_pk = dept_pk;
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

	public Integer getData_sources_type() {
		return data_sources_type;
	}

	public void setData_sources_type(Integer data_sources_type) {
		this.data_sources_type = data_sources_type;
	}

	public String getAssessment_type() {
		return assessment_type;
	}

	public void setAssessment_type(String assessment_type) {
		this.assessment_type = assessment_type;
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

	public Integer getFk_patrol_area_id() {
		return fk_patrol_area_id;
	}

	public void setFk_patrol_area_id(Integer fk_patrol_area_id) {
		this.fk_patrol_area_id = fk_patrol_area_id;
	}

	public String getOwn_guns() {
		return own_guns;
	}

	public void setOwn_guns(String own_guns) {
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

	public String getInput_person() {
		return input_person;
	}

	public void setInput_person(String input_person) {
		this.input_person = input_person;
	}

	public Date getInput_time() {
		return input_time;
	}

	public void setInput_time(Date input_time) {
		this.input_time = input_time;
	}

	public String getVerify_status() {
		return verify_status;
	}

	public void setVerify_status(String verify_status) {
		this.verify_status = verify_status;
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

	public String getVerify_not_pass_reason() {
		return verify_not_pass_reason;
	}

	public void setVerify_not_pass_reason(String verify_not_pass_reason) {
		this.verify_not_pass_reason = verify_not_pass_reason;
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

	public String getRegulations_name() {
		return regulations_name;
	}

	public void setRegulations_name(String regulations_name) {
		this.regulations_name = regulations_name;
	}

	public String getFkzt() {
		return fkzt;
	}

	public void setFkzt(String fkzt) {
		this.fkzt = fkzt;
	}

	public String getFkzt_name() {
		if ("0".equals(fkzt)) {
			return "未反馈";
		} else if ("1".equals(fkzt)) {
			return "已反馈";
		} else {
			return "未知";
		}
	}

	public void setFkzt_name(String fkzt_name) {
		this.fkzt_name = fkzt_name;
	}

	public String getHfzt() {
		return hfzt;
	}

	public void setHfzt(String hfzt) {
		this.hfzt = hfzt;
	}

	public String getHfzt_name() {
		if ("0".equals(hfzt)) {
			return "未回复";
		} else if ("1".equals(hfzt)) {
			return "已回复";
		} else {
			return "未知";
		}
	}

	public void setHfzt_name(String hfzt_name) {
		this.hfzt_name = hfzt_name;
	}

	public String getVerify_status_name() {
		if ("0".equals(verify_status)) {
			return "未审核";
		} else if ("1".equals(verify_status)) {
			return "已审核";
		} else if ("2".equals(verify_status)) {
			return "审核不通过";
		} else if ("3".equals(verify_status)) {
			return "作废";
		} else {
			return "未知";
		}
	}

	public void setVerify_status_name(String verify_status_name) {
		this.verify_status_name = verify_status_name;
	}

	public String getSypi_name() {
		return sypi_name;
	}

	public void setSypi_name(String sypi_name) {
		this.sypi_name = sypi_name;
	}

	public String getFk_dept_name() {
		return fk_dept_name;
	}

	public void setFk_dept_name(String fk_dept_name) {
		this.fk_dept_name = fk_dept_name;
	}

	public String getAssessment_type_name() {
		if ("1".equals(assessment_type)) {
			return "勤务考核";
		} else if ("2".equals(assessment_type)) {
			return "非现考核";
		} else if ("3".equals(assessment_type)) {
			return "其他";
		} else {
			return "未知";
		}
	}

	public void setAssessment_type_name(String assessment_type_name) {
		this.assessment_type_name = assessment_type_name;
	}

	public String getOwn_guns_name() {
		if("1".equals(own_guns)){
			return "是";
		}else if("0".equals(own_guns)){
			return "否";
		}else{
			return "未知";
		}
	}

	public void setOwn_guns_name(String own_guns_name) {
		this.own_guns_name = own_guns_name;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public String getTopic_name() {
		return topic_name;
	}

	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}

	public String getInput_person_name() {
		if(input_person!=null){
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, input_person);
		}else{
			return "";
		}
	}

	public void setInput_person_name(String input_person_name) {
		this.input_person_name = input_person_name;
	}

	public String getFksm() {
		return fksm;
	}

	public void setFksm(String fksm) {
		this.fksm = fksm;
	}

	public String getHfsm() {
		return hfsm;
	}

	public void setHfsm(String hfsm) {
		this.hfsm = hfsm;
	}

	public String getFkr() {
		return fkr;
	}

	public void setFkr(String fkr) {
		this.fkr = fkr;
	}

	public String getHfr() {
		return hfr;
	}

	public void setHfr(String hfr) {
		this.hfr = hfr;
	}

	public Date getFksj() {
		return fksj;
	}

	public void setFksj(Date fksj) {
		this.fksj = fksj;
	}

	public Date getHfsj() {
		return hfsj;
	}

	public void setHfsj(Date hfsj) {
		this.hfsj = hfsj;
	}

	public String getFkr_name() {
		if(fkr!=null){
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, fkr);
		}else{
			return "";
		}
	}

	public void setFkr_name(String fkr_name) {
		this.fkr_name = fkr_name;
	}

	public String getHfr_name() {
		if(hfr!=null){
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, hfr);
		}else{
			return "";
		}
	}

	public void setHfr_name(String hfr_name) {
		this.hfr_name = hfr_name;
	}

}
