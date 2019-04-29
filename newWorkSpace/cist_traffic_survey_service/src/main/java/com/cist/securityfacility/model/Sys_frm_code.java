package com.cist.securityfacility.model;

import java.io.Serializable;

/**
 * 
 * @author Hy
 *
 */
public class Sys_frm_code implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2780977150592044065L;
	private String fc_name;
	private String fc_code;
	private Long fc_pk;
	private int fc_num;
	private String fct_code;
	private String fc_attr;
	private String fc_status;
	private String fc_flag;
	private String fct_name;
	private String fct_des;
	public String getFc_name() {
		return fc_name;
	}
	public void setFc_name(String fc_name) {
		this.fc_name = fc_name;
	}
	public String getFc_code() {
		return fc_code;
	}
	public void setFc_code(String fc_code) {
		this.fc_code = fc_code;
	}
	public Long getFc_pk() {
		return fc_pk;
	}
	public void setFc_pk(Long fc_pk) {
		this.fc_pk = fc_pk;
	}
	public int getFc_num() {
		return fc_num;
	}
	public void setFc_num(int fc_num) {
		this.fc_num = fc_num;
	}
	public String getFct_code() {
		return fct_code;
	}
	public void setFct_code(String fct_code) {
		this.fct_code = fct_code;
	}
	public String getFc_attr() {
		return fc_attr;
	}
	public void setFc_attr(String fc_attr) {
		this.fc_attr = fc_attr;
	}
	public String getFc_status() {
		return fc_status;
	}
	public void setFc_status(String fc_status) {
		this.fc_status = fc_status;
	}
	public String getFc_flag() {
		return fc_flag;
	}
	public void setFc_flag(String fc_flag) {
		this.fc_flag = fc_flag;
	}
	public String getFct_name() {
		return fct_name;
	}
	public void setFct_name(String fct_name) {
		this.fct_name = fct_name;
	}
	public String getFct_des() {
		return fct_des;
	}
	public void setFct_des(String fct_des) {
		this.fct_des = fct_des;
	}
	
}
