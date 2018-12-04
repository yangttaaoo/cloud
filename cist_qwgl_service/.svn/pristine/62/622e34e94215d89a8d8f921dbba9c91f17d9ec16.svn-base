package com.cist.personageassess.model;

import java.io.Serializable;
import java.sql.Clob;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Qw_Opertion_Log implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1430616226282063383L;
	private Integer pk_id;
	private Integer fk_relation_id;//个人/单位勤务ID
	private String data_before;//原始数据
	private String data_after;//修改后数据
	private String edit_reason;//修改原因
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date edit_time;//修改时间
	private Integer fk_edit_user_id;//修改人ID
	private String ip_address;//IP地址
	private  String business_type;//业务类型（1：修改）
	
	private String fk_edit_user_name;//修改人姓名
	private String business_type_name;//业务类型名称
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Integer getFk_relation_id() {
		return fk_relation_id;
	}
	public void setFk_relation_id(Integer fk_relation_id) {
		this.fk_relation_id = fk_relation_id;
	}
	public String getData_before() {
		return data_before;
	}
	public void setData_before(String data_before) {
		this.data_before = data_before;
	}
	public String getData_after() {
		return data_after;
	}
	public void setData_after(String data_after) {
		this.data_after = data_after;
	}
	public String getEdit_reason() {
		return edit_reason;
	}
	public void setEdit_reason(String edit_reason) {
		this.edit_reason = edit_reason;
	}
	public Date getEdit_time() {
		return edit_time;
	}
	public void setEdit_time(Date edit_time) {
		this.edit_time = edit_time;
	}
	public Integer getFk_edit_user_id() {
		return fk_edit_user_id;
	}
	public void setFk_edit_user_id(Integer fk_edit_user_id) {
		this.fk_edit_user_id = fk_edit_user_id;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	public String getBusiness_type() {
		return business_type;
	}
	public void setBusiness_type(String business_type) {
		this.business_type = business_type;
	}
	public String getFk_edit_user_name() {
		if(fk_edit_user_id!=null){
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, fk_edit_user_id.toString());
		}else{
			return "";
		}
	}
	public void setFk_edit_user_name(String fk_edit_user_name) {
		this.fk_edit_user_name = fk_edit_user_name;
	}
	public String getBusiness_type_name() {
		if("1".equals(business_type)){
			return "修改";
		}else{
			return "未知";
		}
	}
	public void setBusiness_type_name(String business_type_name) {
		this.business_type_name = business_type_name;
	}
	
	
}
