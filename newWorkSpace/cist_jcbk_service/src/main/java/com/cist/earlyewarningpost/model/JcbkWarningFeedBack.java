package com.cist.earlyewarningpost.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

//反馈内容
public class JcbkWarningFeedBack {
    private BigDecimal pk_id;//ID

    private BigDecimal fk_warning_id;//预警ID

    private String disposal_location;//拦截处置位置

    private BigDecimal longitude;//拦截处置位置（经度）

    private BigDecimal latitude;//拦截处置位置（纬度）

    private String has_intercept_vehicles;//是否拦截到车辆（0：未拦截到、1：拦截到）

    private String not_intercepted_reason;//未拦截到原因（参考SYS_FRM_CODE中FCT_CODE=BK05）

    private String has_suspected_vehicle;//是否嫌疑车辆（0：否、1：是）

    private String not_suspected_vehicle_reason;//非嫌疑车辆原因（参考SYS_FRM_CODE中FCT_CODE=BK06）

    private String suspect_type;//嫌疑类型（02:套牌嫌疑、03:假牌、34:驾驶证信息异常。参考SYS_FRM_CODE中FCT_CODE=BK01）

    private String exception_type;//异常类型（A:实习期B:吸毒E:超分F:暂扣G:吊销H:注销I:逾期未换证J:逾期未审验K:扣押T:无证。参考SYS_FRM_CODE中FCT_CODE=BK04）

    private BigDecimal transfer_dept_id;//移交部门ID

    private String contacts;//移交部门联系人

    private String contact_number;//移交部门联系人电话

    private String disposal_description;//处置描述

    private BigDecimal feedback_person_id;//反馈人

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date feedback_time;//反馈时间
    
    private String sypi_name;//反馈人名称
    
    private String fkbmdm;//反馈部门代码

	public BigDecimal getPk_id() {
		return pk_id;
	}

	public void setPk_id(BigDecimal pk_id) {
		this.pk_id = pk_id;
	}

	public BigDecimal getFk_warning_id() {
		return fk_warning_id;
	}

	public void setFk_warning_id(BigDecimal fk_warning_id) {
		this.fk_warning_id = fk_warning_id;
	}

	public String getDisposal_location() {
		return disposal_location;
	}

	public void setDisposal_location(String disposal_location) {
		this.disposal_location = disposal_location;
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

	public String getHas_intercept_vehicles() {
		return has_intercept_vehicles;
	}

	public void setHas_intercept_vehicles(String has_intercept_vehicles) {
		this.has_intercept_vehicles = has_intercept_vehicles;
	}

	public String getNot_intercepted_reason() {
		return not_intercepted_reason;
	}

	public void setNot_intercepted_reason(String not_intercepted_reason) {
		this.not_intercepted_reason = not_intercepted_reason;
	}

	public String getHas_suspected_vehicle() {
		return has_suspected_vehicle;
	}

	public void setHas_suspected_vehicle(String has_suspected_vehicle) {
		this.has_suspected_vehicle = has_suspected_vehicle;
	}

	public String getNot_suspected_vehicle_reason() {
		return not_suspected_vehicle_reason;
	}

	public void setNot_suspected_vehicle_reason(String not_suspected_vehicle_reason) {
		this.not_suspected_vehicle_reason = not_suspected_vehicle_reason;
	}

	public String getSuspect_type() {
		return suspect_type;
	}

	public void setSuspect_type(String suspect_type) {
		this.suspect_type = suspect_type;
	}

	public String getException_type() {
		return exception_type;
	}

	public void setException_type(String exception_type) {
		this.exception_type = exception_type;
	}

	public BigDecimal getTransfer_dept_id() {
		return transfer_dept_id;
	}

	public void setTransfer_dept_id(BigDecimal transfer_dept_id) {
		this.transfer_dept_id = transfer_dept_id;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public String getDisposal_description() {
		return disposal_description;
	}

	public void setDisposal_description(String disposal_description) {
		this.disposal_description = disposal_description;
	}

	public BigDecimal getFeedback_person_id() {
		return feedback_person_id;
	}

	public void setFeedback_person_id(BigDecimal feedback_person_id) {
		this.feedback_person_id = feedback_person_id;
	}

	public Date getFeedback_time() {
		return feedback_time;
	}

	public void setFeedback_time(Date feedback_time) {
		this.feedback_time = feedback_time;
	}

	public String getSypi_name() {
		return sypi_name;
	}

	public void setSypi_name(String sypi_name) {
		this.sypi_name = sypi_name;
	}

	public String getFkbmdm() {
		return fkbmdm;
	}

	public void setFkbmdm(String fkbmdm) {
		this.fkbmdm = fkbmdm;
	}

}