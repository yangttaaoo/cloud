package com.cist.dwqwkhcx.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Qw_company implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 66666L;
	private Integer pk_id;// ID
	
	private String fk_dept_id;// 考核单位ID

	private String data_sources_type;// 数据来源（0：系统录入；1：其他）

	private String assessment_type;// 考核类型（1：勤务考核；2：非现考核；3：其他）

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
	private Date start_date;// 考核开始日期

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
	private Date end_date;// 考核结束日期

	private String explain;// 说明

	private String input_person;// 录入人ID

	private Date input_time;// 录入时间
	private String input_time_name;
	private String verify_status;// 审核状态（0：未审核；1：已审核；2：审核不通过；3：作废）
	private String verify_status_name;
	private Integer fk_verify_person_id;// 审核人ID

	private Date verify_time;// 审核时间

	private String record_invalid_reason;// 记录作废原因

	private String verify_not_pass_reason;// 审核不通过原因

	private String dept_name;// 单位名称

	private String pdlm_name;// 评定栏目

	private String user_name;// 数据来源的用户姓名
	
	private String explain_type;//反馈 回复状态 逗号分隔的数据，如果存在两个则表示是已回复和一反馈的数据
	
	private String explain_type_name;
	private String explain_type_name1;
	private Integer fk_topic_id;// 栏目ID

	private int metrics_num;// 指标分值
	
	private Integer metrics_pk;//评定栏目id用于更新
	
	private List<String> explain_type_list=new ArrayList<String>();
	
	private String input_person_name;// 录入人ID

	public Integer getPk_id() {
		return pk_id;
	}

	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}

	public String getFk_dept_id() {
		if (fk_dept_id != null){
			return fk_dept_id;
		}
		return "0";
	}

	public void setFk_dept_id(String fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}

	public String getData_sources_type() {
		return data_sources_type;
	}

	public void setData_sources_type(String data_sources_type) {
		this.data_sources_type = data_sources_type;
	}

	public String getAssessment_type() {
		return assessment_type;
	}

	public void setAssessment_type(String assessment_type) {
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

	public String getDept_name() {
		if (fk_dept_id != null){
			String input_name = fk_dept_id.toString();
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT, input_name); 
		}
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getPdlm_name() {
		/*if (fk_topic_id!=null) {
			pdlm_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_PDLM, fk_topic_id.toString());
		} else {
			pdlm_name = "无";
		}*/

		return pdlm_name;
	}

	public void setPdlm_name(String pdlm_name) {
		this.pdlm_name = pdlm_name;
	}

	public String getUser_name() {
		if (data_sources_type!=null && ("0").compareTo(data_sources_type)!=0) {
			user_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, data_sources_type.toString()) + "("
					+ data_sources_type + ")";
		}
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getExplain_type() {
		return explain_type;
	}

	public void setExplain_type(String explain_type) {
		this.explain_type = explain_type;
	}

	public Integer getFk_topic_id() {
		return fk_topic_id;
	}

	public void setFk_topic_id(Integer fk_topic_id) {
		this.fk_topic_id = fk_topic_id;
	}

	public int getMetrics_num() {
		return metrics_num;
	}

	public void setMetrics_num(int metrics_num) {
		this.metrics_num = metrics_num;
	}

	public Integer getMetrics_pk() {
		return metrics_pk;
	}

	public void setMetrics_pk(Integer metrics_pk) {
		this.metrics_pk = metrics_pk;
	}

	public List<String> getExplain_type_list() {
		if(explain_type!=null&&!("".equals(explain_type))){
			String[] split = explain_type.split(",");
			for (String string : split) {
				explain_type_list.add(string);
			}
		}
		return explain_type_list;
	}

	public void setExplain_type_list(List<String> explain_type_list) {
		this.explain_type_list = explain_type_list;
	}

	public String getInput_person_name() {
	
		if (input_person != null){
			String input_name = input_person.toString();
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, input_name); 
		}
		
		return input_person_name;
	}

	public void setInput_person_name(String input_person_name) {
		this.input_person_name = input_person_name;
	}
	//0：未审核；1：已审核；2：审核不通过；3：作废
	public String getVerify_status_name() {
		if (verify_status != null){
			
		
		if (verify_status.equals("0")){
			return "未审核";
		}else if (verify_status.equals("1")) {
			return "已审核";
		}else if (verify_status.equals("2")) {
			return "审核不通过";
		}else if (verify_status.equals("3")) {
			return "作废";
		}
		}
		return verify_status_name;
	}

	public void setVerify_status_name(String verify_status_name) {
		this.verify_status_name = verify_status_name;
	}

	public String getInput_time_name() {
		if (input_time != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			input_time_name = sdf.format(input_time);
		}
		
		return input_time_name;
	}

	public void setInput_time_name(String input_time_name) {
		this.input_time_name = input_time_name;
	}

	public String getExplain_type_name() {
		if (explain_type != null){
			
			if (explain_type_list.size()==2||(explain_type_list.size()==1 && "2".equals(explain_type_list.get(0)))){
				return "已回复";
			}
			if (explain_type_list.size()==0||(explain_type_list.size()==1 && !"2".equals(explain_type_list.get(0)))){
				return "未回复";
			}
			
		}else{
			return "未回复";
		}
		return explain_type_name;
	}

	public void setExplain_type_name(String explain_type_name) {
		this.explain_type_name = explain_type_name;
	}

	public String getExplain_type_name1() {
		if (explain_type == null ){
			if (explain_type_list.size()==0||(explain_type_list.size()==1 && !"1".equals(explain_type_list.get(0)))){
				return "未反馈";
			}
			if (explain_type_list.size()==2||(explain_type_list.size()==1 && "1".equals(explain_type_list.get(0)))){
				return "已反馈";
			}
		}else{
			return "未反馈";
		}
		return explain_type_name1;
	}

	public void setExplain_type_name1(String explain_type_name1) {
		this.explain_type_name1 = explain_type_name1;
	}
	
	
	
	
}
