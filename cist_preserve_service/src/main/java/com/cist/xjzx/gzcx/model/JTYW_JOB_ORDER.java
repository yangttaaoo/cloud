package com.cist.xjzx.gzcx.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 工单信息
 * @author Hy
 *
 */
public class JTYW_JOB_ORDER implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8901626589420191009L;
	private Integer pk_id;
	private Integer fk_dept_id;//管理部门
	private Integer job_num;//工单号
	private String job_name;//工单名称
	private String job_contents;//工单内容
	private String job_status;//工单状态
	private Integer complete_percentage;//完成百分比
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date complete_time_limit;//完成时限
	private String job_feedback;//反馈信息
	private Integer fk_company_id;//接收公司id
	private Integer fk_group_id;//接收小组id
	private Integer fk_device_list_id;//设备列表id 
	private String remarks;//备注
	
	private String fk_d_operator_id;//派发人
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date distribution_time;//派发时间
	private String job_status_name;//工单状态名称
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Integer getFk_dept_id() {
		return fk_dept_id;
	}
	public void setFk_dept_id(Integer fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}
	public Integer getJob_num() {
		return job_num;
	}
	public void setJob_num(Integer job_num) {
		this.job_num = job_num;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getJob_contents() {
		return job_contents;
	}
	public void setJob_contents(String job_contents) {
		this.job_contents = job_contents;
	}
	public String getJob_status() {
		return job_status;
	}
	public void setJob_status(String job_status) {
		this.job_status = job_status;
	}
	public Integer getComplete_percentage() {
		return complete_percentage;
	}
	public void setComplete_percentage(Integer complete_percentage) {
		this.complete_percentage = complete_percentage;
	}
	public Date getComplete_time_limit() {
		return complete_time_limit;
	}
	public void setComplete_time_limit(Date complete_time_limit) {
		this.complete_time_limit = complete_time_limit;
	}
	public String getJob_feedback() {
		return job_feedback;
	}
	public void setJob_feedback(String job_feedback) {
		this.job_feedback = job_feedback;
	}
	public Integer getFk_company_id() {
		return fk_company_id;
	}
	public void setFk_company_id(Integer fk_company_id) {
		this.fk_company_id = fk_company_id;
	}
	public Integer getFk_group_id() {
		return fk_group_id;
	}
	public void setFk_group_id(Integer fk_group_id) {
		this.fk_group_id = fk_group_id;
	}
	public Integer getFk_device_list_id() {
		return fk_device_list_id;
	}
	public void setFk_device_list_id(Integer fk_device_list_id) {
		this.fk_device_list_id = fk_device_list_id;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getFk_d_operator_id() {
		return fk_d_operator_id;
	}
	public void setFk_d_operator_id(String fk_d_operator_id) {
		this.fk_d_operator_id = fk_d_operator_id;
	}
	public Date getDistribution_time() {
		return distribution_time;
	}
	public void setDistribution_time(Date distribution_time) {
		this.distribution_time = distribution_time;
	}
	public String getJob_status_name() {
		if("0".equals(job_status)) {
			return "已派发";
		}else if("1".equals(job_status)) {
			return "未接收";
		}else if("2".equals(job_status)) {
			return "已接收";
		}else {
			return "已完成";
		}
	}
	public void setJob_status_name(String job_status_name) {
		this.job_status_name = job_status_name;
	}
	
}
