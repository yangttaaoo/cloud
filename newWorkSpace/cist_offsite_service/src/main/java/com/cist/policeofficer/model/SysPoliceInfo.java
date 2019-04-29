/**
 * 
 */
package com.cist.policeofficer.model;

import java.io.Serializable;

/**
 * 警员信息
 *
 */
public class SysPoliceInfo implements Serializable{
	private static final long serialVersionUID = 7358217240965000889L;
    private Integer sypi_pk;//ID
    private String sypi_code;//警号
    private String sypi_name;//姓名
    private String sypi_sex;//警员性别
    private String sypi_post;//职务关联sys_post
    private String sypi_duty;//职责关联sys_police_duty
    private String sypi_dept;//部门关联sys_depart_info
    private String sypi_tel;//联系电话
    private String sypi_mobial;//手机号码
    private String sypi_caller;//呼号
    private String sypi_kind;//警员类型关联sys_police_type
    private String sypi_status;//警员状态关联sys_police_status
    private String sypi_v_no;//v网号
    private String sypi_order;//
    private String sypi_id;//身份证号码
    private String sypi_image;//图片
    private String sypi_comp;//
	
	public SysPoliceInfo(Integer sypi_pk, String sypi_code, String sypi_name,
			String sypi_sex, String sypi_post, String sypi_duty,
			String sypi_dept, String sypi_tel, String sypi_mobial,
			String sypi_caller, String sypi_kind, String sypi_status,
			String sypi_v_no, String sypi_order, String sypi_id,
			String sypi_image, String sypi_comp) {
		super();
		this.sypi_pk = sypi_pk;
		this.sypi_code = sypi_code;
		this.sypi_name = sypi_name;
		this.sypi_sex = sypi_sex;
		this.sypi_post = sypi_post;
		this.sypi_duty = sypi_duty;
		this.sypi_dept = sypi_dept;
		this.sypi_tel = sypi_tel;
		this.sypi_mobial = sypi_mobial;
		this.sypi_caller = sypi_caller;
		this.sypi_kind = sypi_kind;
		this.sypi_status = sypi_status;
		this.sypi_v_no = sypi_v_no;
		this.sypi_order = sypi_order;
		this.sypi_id = sypi_id;
		this.sypi_image = sypi_image;
		this.sypi_comp = sypi_comp;
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

	public String getSypi_duty() {
		return sypi_duty;
	}

	public void setSypi_duty(String sypi_duty) {
		this.sypi_duty = sypi_duty;
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

	public String getSypi_kind() {
		return sypi_kind;
	}

	public void setSypi_kind(String sypi_kind) {
		this.sypi_kind = sypi_kind;
	}

	public String getSypi_status() {
		return sypi_status;
	}

	public void setSypi_status(String sypi_status) {
		this.sypi_status = sypi_status;
	}

	public String getSypi_v_no() {
		return sypi_v_no;
	}

	public void setSypi_v_no(String sypi_v_no) {
		this.sypi_v_no = sypi_v_no;
	}

	public String getSypi_order() {
		return sypi_order;
	}

	public void setSypi_order(String sypi_order) {
		this.sypi_order = sypi_order;
	}

	public String getSypi_id() {
		return sypi_id;
	}

	public void setSypi_id(String sypi_id) {
		this.sypi_id = sypi_id;
	}

	public String getSypi_image() {
		return sypi_image;
	}

	public void setSypi_image(String sypi_image) {
		this.sypi_image = sypi_image;
	}

	public String getSypi_comp() {
		return sypi_comp;
	}

	public void setSypi_comp(String sypi_comp) {
		this.sypi_comp = sypi_comp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SysPoliceInfo() {
		super();
	}
}
