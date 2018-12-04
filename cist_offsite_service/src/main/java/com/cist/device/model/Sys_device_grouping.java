package com.cist.device.model;

import java.io.Serializable;

public class Sys_device_grouping implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer pk;//分组ID
	private String groud_name;//分组名称
	private String groud_code;//分组描述
	private String groud_dev;//分组设备
	private String dept_code;//部门编号
	private String dept_pk;//部门pk
	private String tbei_code;//设备编号
	private String tbei_name;//设备名称
	private String dept_name;//部门名称
	private String sypi_name;//警员姓名
	private String sypi_dept;//警员所属部门编号
	private String syai_pk;//警员pk
	private String sypi_code;//警员编号
	private String tbec_dept_id;//设备所属部门编号
	private String sypi_pk;//警员表pk
	private Boolean chaek = false;
	private String id;
	private String name;
	
	
	public Boolean getChaek() {
		return chaek;
	}
	public void setChaek(Boolean chaek) {
		this.chaek = chaek;
	}
	public String getGroud_dev() {
		return groud_dev;
	}
	public void setGroud_dev(String groud_dev) {
		this.groud_dev = groud_dev;
	}
	public String getSypi_pk() {
		return sypi_pk;
	}
	public void setSypi_pk(String sypi_pk) {
		this.sypi_pk = sypi_pk;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSypi_code() {
		return sypi_code;
	}
	public void setSypi_code(String sypi_code) {
		this.sypi_code = sypi_code;
	}
	public String getTbec_dept_id() {
		return tbec_dept_id;
	}
	public void setTbec_dept_id(String tbec_dept_id) {
		this.tbec_dept_id = tbec_dept_id;
	}
	public Integer getPk() {
		return pk;
	}
	public void setPk(Integer pk) {
		this.pk = pk;
	}
	public String getGroud_name() {
		return groud_name;
	}
	public void setGroud_name(String groud_name) {
		this.groud_name = groud_name;
	}
	public String getGroud_code() {
		return groud_code;
	}
	public void setGroud_code(String groud_code) {
		this.groud_code = groud_code;
	}
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}
	public String getDept_pk() {
		return dept_pk;
	}
	public void setDept_pk(String dept_pk) {
		this.dept_pk = dept_pk;
	}
	public String getTbei_code() {
		return tbei_code;
	}
	public void setTbei_code(String tbei_code) {
		this.tbei_code = tbei_code;
	}
	public String getTbei_name() {
		return tbei_name;
	}
	public void setTbei_name(String tbei_name) {
		this.tbei_name = tbei_name;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getSypi_name() {
		return sypi_name;
	}
	public void setSypi_name(String sypi_name) {
		this.sypi_name = sypi_name;
	}
	public String getSypi_dept() {
		return sypi_dept;
	}
	public void setSypi_dept(String sypi_dept) {
		this.sypi_dept = sypi_dept;
	}
	public String getSyai_pk() {
		return syai_pk;
	}
	public void setSyai_pk(String syai_pk) {
		this.syai_pk = syai_pk;
	}
	
	
}
