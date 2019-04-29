package com.cist.messagetemplateconfig.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Jcbk_sms_template implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4668993381189367063L;
	private Integer pk_id;// 主键
	private String fk_dept_id;// 部门Id
	private String temp_name;// 模板名称
	private String temp_contents;// 模板内容
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date create_time;// 创建时间
	private String fk_create_founder_id;// 创建人Id
	private String isdefault;//0:不是默认模板 1:是默认模板
	private String type;//模板类型 1-122短信模板 2-缉查布控短信模板
	
	private String deptname;
	private String pepolename;
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public String getFk_dept_id() {
		return fk_dept_id;
	}
	public void setFk_dept_id(String fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}
	public String getTemp_name() {
		return temp_name;
	}
	public void setTemp_name(String temp_name) {
		this.temp_name = temp_name;
	}
	public String getTemp_contents() {
		return temp_contents;
	}
	public void setTemp_contents(String temp_contents) {
		this.temp_contents = temp_contents;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getFk_create_founder_id() {
		return fk_create_founder_id;
	}
	public void setFk_create_founder_id(String fk_create_founder_id) {
		this.fk_create_founder_id = fk_create_founder_id;
	}
	public String getIsdefault() {
		return isdefault;
	}
	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getPepolename() {
		return pepolename;
	}
	public void setPepolename(String pepolename) {
		this.pepolename = pepolename;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
