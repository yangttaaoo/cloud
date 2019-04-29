package com.cist.dwqwkhcx.model;

import java.io.Serializable;
import java.sql.Clob;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class Qw_Opertion_Log implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1430616226282063383L;
	private Integer pk_id;
	private Integer fk_relation_id;//
	private String fk_edit_user_name;
	private String data_before;
	private String data_after;//修改原始数据
	private String data_after_name;
	private String edit_reason;
	private Date edit_time;//处理时间
	private String edit_time_name;
	private Integer fk_edit_user_id;
	private String ip_address;
	private  String business_type;//业务类型
	private  String business_type_name;
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
	public Integer getFk_deit_user_id() {
		return fk_edit_user_id;
	}
	public void setFk_deit_user_id(Integer fk_edit_user_id) {
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
	public String getEdit_time_name() {
		if (edit_time != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			edit_time_name = sdf.format(edit_time);
		}
		
		return edit_time_name;
	}
	public void setEdit_time_name(String edit_time_name) {
		this.edit_time_name = edit_time_name;
	}
	public String getBusiness_type_name() {
		if (business_type != null){
			if (business_type.equals("1")){
				return "修改";
			}else {
				return "回复";
			}
			
		}
		return business_type_name;
	}
	public void setBusiness_type_name(String business_type_name) {
		this.business_type_name = business_type_name;
	}
	public String getData_after_name() {
		if (data_after == null){
			return "已修改";
		}else{
			return "未修改";
		}
		
	}
	public void setData_after_name(String data_after_name) {
		this.data_after_name = data_after_name;
	}
	public String getFk_deit_user_name() {
		if (fk_edit_user_id != null){
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, fk_edit_user_id.toString());
		}
		return fk_edit_user_name;
	}
	public void setFk_deit_user_name(String fk_edit_user_name) {
		this.fk_edit_user_name = fk_edit_user_name;
	}
	
	
	
}
