package com.cist.wobacklog.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VwJtywDbgd {
    private Integer pk_id;

    private Integer fk_dept_id;

    private Integer job_num;

    private String job_name;

    private String job_contents;

    private String job_status;

    private int complete_percentage;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date complete_time_limit;

    private String job_feedback;

    private Integer fk_cmpany_id;

    private Integer fk_group_id;

    private Integer fk_device_list_id;

    private String remarks;

    private Integer fk_job_num;

    private Integer fk_d_operator_id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date distribution_time;

    private Integer fk_r_operator_id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date receive_time;

    private Integer fk_c_operator_id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date complete_time;

    private Integer fk_comp_id;

    private String staff_name;

    private String staff_contacts_num; 
    
    private int allCount;
    
    private int weekCount;
    
    private int avg;
    
    private String d_operator_name;

    private String r_operator_name;

    private String c_operator_name;
    
    private String comp_name;
    
    private String group_name;
    
    private String comp_contacts;
    
    private String comp_contacts_num;

    
    
	public String getComp_name() {
		return comp_name;
	}

	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public String getComp_contacts_num() {
		return comp_contacts_num;
	}

	public void setComp_contacts_num(String comp_contacts_num) {
		this.comp_contacts_num = comp_contacts_num;
	}

	public void setComplete_percentage(int complete_percentage) {
		this.complete_percentage = complete_percentage;
	}

	public String getD_operator_name() {
		return d_operator_name;
	}

	public void setD_operator_name(String d_operator_name) {
		this.d_operator_name = d_operator_name;
	}

	public String getR_operator_name() {
		return r_operator_name;
	}

	public void setR_operator_name(String r_operator_name) {
		this.r_operator_name = r_operator_name;
	}

	public String getC_operator_name() {
		return c_operator_name;
	}

	public void setC_operator_name(String c_operator_name) {
		this.c_operator_name = c_operator_name;
	}

	public void setFk_job_num(Integer fk_job_num) {
		this.fk_job_num = fk_job_num;
	}

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

	public int getWeekCount() {
		return weekCount;
	}

	public void setWeekCount(int weekCount) {
		this.weekCount = weekCount;
	}

	public int getAvg() {
	
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
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

	public Integer getFk_cmpany_id() {
		return fk_cmpany_id;
	}

	public void setFk_cmpany_id(Integer fk_cmpany_id) {
		this.fk_cmpany_id = fk_cmpany_id;
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

	public Integer getFk_job_num() {
		return fk_job_num;
	}

	public void setFkJob_num(Integer fk_job_num) {
		this.fk_job_num = fk_job_num;
	}

	public Integer getFk_d_operator_id() {
		return fk_d_operator_id;
	}

	public void setFk_d_operator_id(Integer fk_d_operator_id) {
		this.fk_d_operator_id = fk_d_operator_id;
	}

	public Date getDistribution_time() {
		return distribution_time;
	}

	public void setDistribution_time(Date distribution_time) {
		this.distribution_time = distribution_time;
	}

	public Integer getFk_r_operator_id() {
		return fk_r_operator_id;
	}

	public void setFk_r_operator_id(Integer fk_r_operator_id) {
		this.fk_r_operator_id = fk_r_operator_id;
	}

	public Date getReceive_time() {
		return receive_time;
	}

	public void setReceive_time(Date receive_time) {
		this.receive_time = receive_time;
	}

	public Integer getFk_c_operator_id() {
		return fk_c_operator_id;
	}

	public void setFk_c_operator_id(Integer fk_c_operator_id) {
		this.fk_c_operator_id = fk_c_operator_id;
	}

	public Date getComplete_time() {
		return complete_time;
	}

	public void setComplete_time(Date complete_time) {
		this.complete_time = complete_time;
	}

	public Integer getFk_comp_id() {
		return fk_comp_id;
	}

	public void setFk_comp_id(Integer fk_comp_id) {
		this.fk_comp_id = fk_comp_id;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getStaff_contacts_num() {
		return staff_contacts_num;
	}

	public void setStaff_contacts_num(String staff_contacts_num) {
		this.staff_contacts_num = staff_contacts_num;
	}

	public String getComp_contacts() {
		return comp_contacts;
	}

	public void setComp_contacts(String comp_contacts) {
		this.comp_contacts = comp_contacts;
	}

   
}