package com.cist.wobacklog.model;

import java.util.Date;

public class JtywJobOrderInfo {
    private Integer pk_id;//ID

    private Integer fk_dept_id;//管理部门

    private Integer job_num;//工单号

    private String job_name;//工单名称

    private String job_contents;//工单内容

    private String job_status;//0已派发1未接收2已接收 3已完成

    private Integer complete_percentage;//完成百分比

    private Date complete_time_limit;//完成时限

    private String job_feedback;//反馈信息

    private Integer fk_company_id;//接收公司ID

    private Integer fk_group_id;//接收小组ID

    private Integer fk_device_list_id;//设备列表ID

    private String remarks;//备注
    
    private Integer count;//工单总数
    
    private Integer wccount;//完成数量
    
    private Integer wwccount;//未完成数量
    
    private String comp_name;//公司名称
    
    private Integer oCount;//每个公司对应的count数
    
    private Integer lastCount;//同期数量

    
    
	public String getComp_name() {
		return comp_name;
	}

	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getWccount() {
		return wccount;
	}

	public void setWccount(Integer wccount) {
		this.wccount = wccount;
	}

	public Integer getWwccount() {
		return wwccount;
	}

	public void setWwccount(Integer wwccount) {
		this.wwccount = wwccount;
	}

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

	public Integer getoCount() {
		return oCount;
	}

	public void setoCount(Integer oCount) {
		this.oCount = oCount;
	}

	public Integer getLastCount() {
		return lastCount;
	}

	public void setLastCount(Integer lastCount) {
		this.lastCount = lastCount;
	}

    
}