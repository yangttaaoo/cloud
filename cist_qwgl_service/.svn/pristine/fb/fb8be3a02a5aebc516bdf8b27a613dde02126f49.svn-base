package com.cist.pdgrzb.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;



public class Qw_I_C_Metricr implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID =545656L;
	private Integer pk_id;//ID
	private Long fk_dept_id;//管理部门ID SYS_DEPT
	private String fk_dept;
	private String metricr_type;//指标类型（1：个人；2：单位）
	private String topic_name;
	private Integer fk_topic_id;
	private Integer default_value;//默认分值METRICS_NUM
	private Integer metrics_num;
	private String fk_user_id;//人员/单位ID
	private String  fk_user;//人员+
	private String evaluate_date_type;//评定日期类型（1：年；2：季度；3：月）
	private Date evaluate_date_start;//评定日期开始
	private Date evaluate_date_end;//评定日期结束
	private String remarks;//备注
	private String year;
	private String years;
	private Integer sypi_pk;
	private String sypi_name;
	private String sypi_code;
	private String dept_name;
	private Integer totalSocre;
	private String topicids;
	private String allsocre;
	private Integer defaultSocre;
	
	
	public Integer getSypi_pk() {
		return sypi_pk;
	}
	public void setSypi_pk(Integer sypi_pk) {
		this.sypi_pk = sypi_pk;
	}
	public String getSypi_name() {
		return sypi_name;
	}
	public void setSypi_name(String sypi_name) {
		this.sypi_name = sypi_name;
	}
	public String getSypi_code() {
		return sypi_code;
	}
	public void setSypi_code(String sypi_code) {
		this.sypi_code = sypi_code;
	}
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Long getFk_dept_id() {
		return fk_dept_id;
	}
	public void setFk_dept_id(Long fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}
	public String getMetricr_type() {
		return metricr_type;
	}
	public void setMetricr_type(String metricr_type) {
		this.metricr_type = metricr_type;
	}
	public String getEvaluate_date_type() {
		return evaluate_date_type;
	}
	public void setEvaluate_date_type(String evaluate_date_type) {
		this.evaluate_date_type = evaluate_date_type;
	}
	public Date getEvaluate_date_start() {
		return evaluate_date_start;
	}
	public void setEvaluate_date_start(Date evaluate_date_start) {
		this.evaluate_date_start = evaluate_date_start;
	}
	public Date getEvaluate_date_end() {
		return evaluate_date_end;
	}
	public void setEvaluate_date_end(Date evaluate_date_end) {
		this.evaluate_date_end = evaluate_date_end;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
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
	public Integer getMetrics_num() {
		return metrics_num;
	}
	public void setMetrics_num(Integer metrics_num) {
		this.metrics_num = metrics_num;
	}
	public String getYear() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		year = sdf.format(this.evaluate_date_end);
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getFk_user() {
		if (fk_user_id != null){
			String fk_user_name = fk_user_id.toString();
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, fk_user_name); 
		}
		return fk_user;
	}
	public void setFk_user(String fk_user) {
		this.fk_user = fk_user;
	}
	public String getFk_dept() {
		String  fk_dept_name = fk_dept_id.toString();
		if (fk_dept_id != null){
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT, fk_dept_name); 
		}
		
		return fk_dept;
	}
	public void setFk_dept(String fk_dept) {
		this.fk_dept = fk_dept;
	}
	public Integer getFk_topic_id() {
		return fk_topic_id;
	}
	public void setFk_topic_id(Integer fk_topic_id) {
		this.fk_topic_id = fk_topic_id;
	}
	public String getYears() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		years = sdf.format(this.evaluate_date_end);
		return years;
	}
	public void setYears(String years) {
		
		this.years = years;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public Integer getTotalSocre() {
		return totalSocre;
	}
	public void setTotalSocre(Integer totalSocre) {
		this.totalSocre = totalSocre;
	}
	public String getTopicids() {
		return topicids;
	}
	public void setTopicids(String topicids) {
		this.topicids = topicids;
	}
	public String getAllsocre() {
		return allsocre;
	}
	public void setAllsocre(String allsocre) {
		this.allsocre = allsocre;
	}
	public Integer getDefaultSocre() {
		return defaultSocre;
	}
	public void setDefaultSocre(Integer defaultSocre) {
		this.defaultSocre = defaultSocre;
	}
	public String getFk_user_id() {
		return fk_user_id;
	}
	public void setFk_user_id(String fk_user_id) {
		this.fk_user_id = fk_user_id;
	}
	
}
