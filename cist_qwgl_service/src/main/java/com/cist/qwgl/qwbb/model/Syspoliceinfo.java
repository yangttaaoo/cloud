package com.cist.qwgl.qwbb.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 警员信息
 *
 */
public class Syspoliceinfo implements Serializable{
	private static final long serialVersionUID = 7358217240965000889L;
    private Integer sypi_pk;//ID
    private String sypi_code;//警号
    private String sypi_name;//姓名 
    private String sypi_namecode;//姓名(警号)
    private String sypi_sex;//警员性别
    private String sypi_post;//职务关联sys_post
    private String sypi_duty;//职责关联sys_police_duty
    private String sypi_dept;//部门关联sys_depart_info
    private String sypi_tel;//联系电话
    private String sypi_mobial;//手机号码
    private String sypi_caller;//呼号
    private String sypi_kind;//警员类型关联sys_police_type
    private String sypi_status;//警员状态关联sys_police_status
    private String sypi_status_name;
    private String sypi_v_no;//v网号
    private String sypi_order;//
    private String sypi_id;//身份证号码
    private String sypi_image;//图片
    private String sypi_comp;//1负责人2 民警 3协警
    private String fk_police_team_id;//警组ID
    private String sypi_inter;//对讲机号
    private String sypi_ips;//ip起始地址
    private String sypi_ipe;//ip结束地址
    private String sypi_mac;//mac地址
    private String sypi_fixedip1;//固定ip地址1
    private String sypi_fixedip2;//固定ip地址2
    private String sypi_fixedip3;//固定ip地址3
    private Date sypi_pvp;//密码有效期
    private Date sypi_avp;//账户有效期
    
    private String dept_name;//部门名称
    private String syps_name;//警员状态
    
    public String getFk_police_team_id() {
		return fk_police_team_id;
	}

	public void setFk_police_team_id(String fk_police_team_id) {
		this.fk_police_team_id = fk_police_team_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getSyps_name() {
		return syps_name;
	}

	public void setSyps_name(String syps_name) {
		this.syps_name = syps_name;
	}

	public String getSypi_inter() {
		return sypi_inter;
	}

	public void setSypi_inter(String sypi_inter) {
		this.sypi_inter = sypi_inter;
	}

	public String getSypi_ips() {
		return sypi_ips;
	}

	public void setSypi_ips(String sypi_ips) {
		this.sypi_ips = sypi_ips;
	}

	public String getSypi_ipe() {
		return sypi_ipe;
	}

	public void setSypi_ipe(String sypi_ipe) {
		this.sypi_ipe = sypi_ipe;
	}

	public String getSypi_mac() {
		return sypi_mac;
	}

	public void setSypi_mac(String sypi_mac) {
		this.sypi_mac = sypi_mac;
	}

	public String getSypi_fixedip1() {
		return sypi_fixedip1;
	}

	public void setSypi_fixedip1(String sypi_fixedip1) {
		this.sypi_fixedip1 = sypi_fixedip1;
	}

	public String getSypi_fixedip2() {
		return sypi_fixedip2;
	}

	public void setSypi_fixedip2(String sypi_fixedip2) {
		this.sypi_fixedip2 = sypi_fixedip2;
	}

	public String getSypi_fixedip3() {
		return sypi_fixedip3;
	}

	public void setSypi_fixedip3(String sypi_fixedip3) {
		this.sypi_fixedip3 = sypi_fixedip3;
	}

	public Date getSypi_pvp() {
		return sypi_pvp;
	}

	public void setSypi_pvp(Date sypi_pvp) {
		this.sypi_pvp = sypi_pvp;
	}

	public Date getSypi_avp() {
		return sypi_avp;
	}

	public void setSypi_avp(Date sypi_avp) {
		this.sypi_avp = sypi_avp;
	}

	private String sypi_dept_name;

	public String getSypi_namecode() {
		if(null!=sypi_name&&null!=sypi_code) {
			return sypi_name+"("+sypi_code+")";
		}
		return sypi_namecode;
	}

	public void setSypi_namecode(String sypi_namecode) {
		this.sypi_namecode = sypi_namecode;
	}

	public String getSypi_status_name() {
		if(this.sypi_status!=null){
			if(this.sypi_status.equals("1")){
				return "启用";
			}else{
				return "停用";
			}
		}
		return sypi_status_name;
	}

	public void setSypi_status_name(String sypi_status_name) {
		this.sypi_status_name = sypi_status_name;
	}

	public String getSypi_dept_name() {
		return sypi_dept_name;
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

	public Syspoliceinfo() {
		super();
	}
}
