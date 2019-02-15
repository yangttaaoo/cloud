package com.cist.home.model;

import java.io.Serializable;
import java.util.Date;

public class Sysfrmcode implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer fc_pk;//id
	private String fct_code;//代码类别（关联SYS_FRM _CODE_TYPE表中FCT_CODE字段）
	private String fc_code;//代码值
	private String fc_name;//代码说明
	private String fc_num;//顺序号
	private String fc_attr;//代码属性，0-不可维护，1-可维护）
	private String fc_status;//状态，0-无效，1-有效
	private String fc_flag;//状态标记，0-删除，1-正常
	private String fc_des;//代码说明
	
	private String syhi_holiday;//节假日期
	private String syhi_work_day;//调休上班日期
	private Date syhi_stime;//节日开始时间（包含,格式：YYYY-MM-dd 00:00:00）
	private Date syhi_etime;//节日结束时间（包含,格式：YYYY-MM-dd 23:59:59）
	
	public String getSyhi_holiday() {
		return syhi_holiday;
	}
	public void setSyhi_holiday(String syhi_holiday) {
		this.syhi_holiday = syhi_holiday;
	}
	public String getSyhi_work_day() {
		return syhi_work_day;
	}
	public void setSyhi_work_day(String syhi_work_day) {
		this.syhi_work_day = syhi_work_day;
	}
	public Date getSyhi_stime() {
		return syhi_stime;
	}
	public void setSyhi_stime(Date syhi_stime) {
		this.syhi_stime = syhi_stime;
	}
	public Date getSyhi_etime() {
		return syhi_etime;
	}
	public void setSyhi_etime(Date syhi_etime) {
		this.syhi_etime = syhi_etime;
	}
	public Integer getFc_pk() {
		return fc_pk;
	}
	public void setFc_pk(Integer fc_pk) {
		this.fc_pk = fc_pk;
	}
	public String getFct_code() {
		return fct_code;
	}
	public void setFct_code(String fct_code) {
		this.fct_code = fct_code;
	}
	public String getFc_code() {
		return fc_code;
	}
	public void setFc_code(String fc_code) {
		this.fc_code = fc_code;
	}
	public String getFc_name() {
		return fc_name;
	}
	public void setFc_name(String fc_name) {
		this.fc_name = fc_name;
	}
	public String getFc_num() {
		return fc_num;
	}
	public void setFc_num(String fc_num) {
		this.fc_num = fc_num;
	}
	public String getFc_attr() {
		return fc_attr;
	}
	public void setFc_attr(String fc_attr) {
		this.fc_attr = fc_attr;
	}
	public String getFc_status() {
		return fc_status;
	}
	public void setFc_status(String fc_status) {
		this.fc_status = fc_status;
	}
	public String getFc_flag() {
		return fc_flag;
	}
	public void setFc_flag(String fc_flag) {
		this.fc_flag = fc_flag;
	}
	public String getFc_des() {
		return fc_des;
	}
	public void setFc_des(String fc_des) {
		this.fc_des = fc_des;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Sysfrmcode(Integer fc_pk, String fct_code, String fc_code, String fc_name, String fc_num, String fc_attr,
			String fc_status, String fc_flag, String fc_des) {
		super();
		this.fc_pk = fc_pk;
		this.fct_code = fct_code;
		this.fc_code = fc_code;
		this.fc_name = fc_name;
		this.fc_num = fc_num;
		this.fc_attr = fc_attr;
		this.fc_status = fc_status;
		this.fc_flag = fc_flag;
		this.fc_des = fc_des;
	}
	public Sysfrmcode() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
