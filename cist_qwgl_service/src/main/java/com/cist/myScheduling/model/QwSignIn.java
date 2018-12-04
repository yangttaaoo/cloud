package com.cist.myScheduling.model;

import java.math.BigDecimal;
import java.util.Date;

public class QwSignIn {
    private BigDecimal pk_id;//

    private BigDecimal fk_dept_id;//

    private BigDecimal fk_ssign_in_user_id;//

    private String sign_in_user_name;//

    private String sign_in_user_unit;//

    private Date sign_time;//

    private BigDecimal longitude;//

    private BigDecimal latitude;//

    private String sign_in_type;//

    private BigDecimal fk_report_id;//

    private String sign_in_addr;//

	public BigDecimal getPk_id() {
		return pk_id;
	}

	public void setPk_id(BigDecimal pk_id) {
		this.pk_id = pk_id;
	}

	public BigDecimal getFk_dept_id() {
		return fk_dept_id;
	}

	public void setFk_dept_id(BigDecimal fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}

	public BigDecimal getFk_ssign_in_user_id() {
		return fk_ssign_in_user_id;
	}

	public void setFk_ssign_in_user_id(BigDecimal fk_ssign_in_user_id) {
		this.fk_ssign_in_user_id = fk_ssign_in_user_id;
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

	public String getSign_in_type() {
		return sign_in_type;
	}

	public void setSign_in_type(String sign_in_type) {
		this.sign_in_type = sign_in_type;
	}

	public BigDecimal getFk_report_id() {
		return fk_report_id;
	}

	public void setFk_report_id(BigDecimal fk_report_id) {
		this.fk_report_id = fk_report_id;
	}

	public String getSign_in_addr() {
		return sign_in_addr;
	}

	public void setSign_in_addr(String sign_in_addr) {
		this.sign_in_addr = sign_in_addr;
	}

    
}