package com.cist.khpdgl.model;

import java.io.Serializable;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

/**
 * 考核条例
 * @author Administrator
 *
 */
public class Qw_Appraise_Reculations implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3454L;
	private Integer pk_id;//ID
	private Integer fk_appraise_topic_id;//考核栏目ID
	private String regulations_name;//条例名称
	private String assessment_rules;//评定规则（0：零分；1：加分；2：减分）
	private String assessment_name;//评定规则（0：零分；1：加分；2：减分）
	private Integer assessment_num;//条例分值

	private String topic_explain;//条例说明
	private String enabled_state;//启用状态（0：禁用；1：启用）
	private String enabled_state_name;//启用状态（0：禁用；1：启用）
	private Integer create_person_id;//创建人
	private String create_person_name;//创建人
	private Date create_time;//创建时间
	private String create_tname;
	
	private String  topic_name;//评定栏目
	private Integer default_value;//默认分值
	
	
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
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
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
	public Integer getAssessment_num() {
		return assessment_num;
	}
	public void setAssessment_num(Integer assessment_num) {
		this.assessment_num = assessment_num;
	}
	public String getTopic_explain() {
		return topic_explain;
	}
	public void setTopic_explain(String topic_explain) {
		this.topic_explain = topic_explain;
	}
	public String getEnabled_state() {
		return enabled_state;
	}
	public void setEnabled_state(String enabled_state) {
		this.enabled_state = enabled_state;
	}
	public Integer getCreate_person_id() {
		return create_person_id;
	}
	public void setCreate_person_id(Integer create_person_id) {
		this.create_person_id = create_person_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Integer getFk_appraise_topic_id() {
		return fk_appraise_topic_id;
	}
	public void setFk_appraise_topic_id(Integer fk_appraise_topic_id) {
		this.fk_appraise_topic_id = fk_appraise_topic_id;
	}
	
	public String getCreate_person_name() {
		if (create_person_id != null){
			String create_person_names = create_person_id.toString();
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, create_person_names); 
		}
		return create_person_name;
	}
	public void setCreate_person_name(String create_person_name) {
		this.create_person_name = create_person_name;
	}
	

	
	
	
}
