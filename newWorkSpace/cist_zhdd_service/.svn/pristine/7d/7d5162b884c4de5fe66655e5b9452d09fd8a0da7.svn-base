package com.cist.home.model;

import java.io.Serializable;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;


public class PoliceInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer sypi_pk;//ID
	private String sypi_code;//	警号/协警号
	private String sypi_name;//姓名
	private String sypi_sex;//性别（关联SYS_FRM_CODE表中FC_CODE字段）
	private String sypi_sex_name;//性别中文名称
	private String sypi_post;//职位（关联SYS_FRM_CODE表中FC_CODE字段）
	private String sypi_post_name;//职位中文名称
	private String sypi_dept;//	部门ID（关联SYS_DEPART_INFO表中DEPT_PK字段）
	private String sypi_dept_name;//部门中文名称
	private String sypi_tel;//	办公电话
	private String sypi_mobial;//移动电话
	private String sypi_caller;//对讲机号
	private Integer sypi_status;//状态，0-停用 1-启用
	private String sypi_status_name;//状态中文名称
	private String sypi_inter;//主机号
	
	
	public String getSypi_status_name() {
		return sypi_status_name;
	}
	public void setSypi_status_name(Integer sypi_status_name) {
		if(sypi_status_name==1){
			this.sypi_status_name = "在职";
		}else{
			this.sypi_status_name = "离职";
		}
	}
	public String getSypi_sex_name() {
		if(null!=sypi_sex){
			 String sex_name =  SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_SEX,sypi_sex);
			 return sex_name;
		} else{
			return "";
		}
	}
	public void setSypi_sex_name(String sypi_sex_name) {
		this.sypi_sex_name = sypi_sex_name;
	}
	public String getSypi_post_name() {
		if(null!=sypi_post){
			 String post_name =  SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_POST,sypi_post);
			 return post_name;
		} else{
			return "";
		}
	}
	public void setSypi_post_name(String sypi_post_name) {
		this.sypi_post_name = sypi_post_name;
	}
	public String getSypi_dept_name() {
		if(null!=sypi_dept){
			 String dept_name =  SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT_PK,sypi_dept);
			 return dept_name;
		} else{
			return "";
		}
	}
	public void setSypi_dept_name(String sypi_dept_name) {
		this.sypi_dept_name = sypi_dept_name;
	}
	public Integer getSypi_pk() {
		return sypi_pk;
	}
	public void setSypi_pk(Integer sypi_pk) {
		this.sypi_pk = sypi_pk;
	}
	public String getSypi_code() {
		return sypi_code;
	}
	public void setSypi_code(String sypi_code) {
		this.sypi_code = sypi_code;
	}
	public String getSypi_name() {
		return sypi_name;
	}
	public void setSypi_name(String sypi_name) {
		this.sypi_name = sypi_name;
	}
	public String getSypi_sex() {
		return sypi_sex;
	}
	public void setSypi_sex(String sypi_sex) {
		this.sypi_sex = sypi_sex;
	}
	public String getSypi_post() {
		return sypi_post;
	}
	public void setSypi_post(String sypi_post) {
		this.sypi_post = sypi_post;
	}
	public String getSypi_dept() {
		return sypi_dept;
	}
	public void setSypi_dept(String sypi_dept) {
		this.sypi_dept = sypi_dept;
	}
	public String getSypi_tel() {
		return sypi_tel;
	}
	public void setSypi_tel(String sypi_tel) {
		this.sypi_tel = sypi_tel;
	}
	public String getSypi_mobial() {
		return sypi_mobial;
	}
	public void setSypi_mobial(String sypi_mobial) {
		this.sypi_mobial = sypi_mobial;
	}
	public String getSypi_caller() {
		return sypi_caller;
	}
	public void setSypi_caller(String sypi_caller) {
		this.sypi_caller = sypi_caller;
	}
	public Integer getSypi_status() {
		return sypi_status;
	}
	public void setSypi_status(Integer sypi_status) {
		this.sypi_status = sypi_status;
		this.setSypi_status_name(sypi_status);
	}
	public String getSypi_inter() {
		return sypi_inter;
	}
	public void setSypi_inter(String sypi_inter) {
		this.sypi_inter = sypi_inter;
	}
	
	
}
