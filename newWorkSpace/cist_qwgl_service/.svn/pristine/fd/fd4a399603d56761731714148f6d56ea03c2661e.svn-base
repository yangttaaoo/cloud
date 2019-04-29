package com.cist.myDuty.myAssess.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SignIn {
	// ID
	private Long pk_id;
	// 管理部门ID
	private Long fk_dept_id;
	// 勤务报备ID
	private Long fk_report_id;
	// 签到人ID
	private Long fk_sign_in_user_id;
	// 签到类型（1：签到；2：签退）
	private char sign_in_type;
	// 签到人姓名（冗余数据）
	private String sign_in_user_name;
	// 签到人单位（冗余数据）
	private String sign_in_user_unit;
	// 签到时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date sign_time;
	// 签到地点
	private String sign_in_addr;
	// 经度
	private BigDecimal longitude;
	// 纬度
	private BigDecimal latitude;
	public Long getPk_id() {
		return pk_id;
	}
	public void setPk_id(Long pk_id) {
		this.pk_id = pk_id;
	}
	public Long getFk_dept_id() {
		return fk_dept_id;
	}
	public void setFk_dept_id(Long fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}
	public Long getFk_report_id() {
		return fk_report_id;
	}
	public void setFk_report_id(Long fk_report_id) {
		this.fk_report_id = fk_report_id;
	}
	public Long getFk_sign_in_user_id() {
		return fk_sign_in_user_id;
	}
	public void setFk_sign_in_user_id(Long fk_sign_in_user_id) {
		this.fk_sign_in_user_id = fk_sign_in_user_id;
	}
	public char getSign_in_type() {
		return sign_in_type;
	}
	public void setSign_in_type(char sign_in_type) {
		this.sign_in_type = sign_in_type;
	}
	public String getSign_in_user_name() {
		return sign_in_user_name;
	}
	public void setSign_in_user_name(String sign_in_user_name) {
		this.sign_in_user_name = sign_in_user_name;
	}
	public String getSign_in_user_unit() {
		return sign_in_user_unit;
	}
	public void setSign_in_user_unit(String sign_in_user_unit) {
		this.sign_in_user_unit = sign_in_user_unit;
	}
	public Date getSign_time() {
		return sign_time;
	}
	public void setSign_time(Date sign_time) {
		this.sign_time = sign_time;
	}
	public String getSign_in_addr() {
		return sign_in_addr;
	}
	public void setSign_in_addr(String sign_in_addr) {
		this.sign_in_addr = sign_in_addr;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

}
