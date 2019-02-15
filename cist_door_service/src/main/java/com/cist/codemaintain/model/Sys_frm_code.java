package com.cist.codemaintain.model;

/**
 * 基础代码
 * @author Administrator
 *
 */
public class Sys_frm_code {
	private Integer fc_pk;
	private String fct_code;
	private String fc_code;
	private String fct_code_name;
	private String fc_name;
	private Integer fc_num;
	private String fc_attr;
	private String fc_attr_name;
	private String fc_status;
	private String fc_status_name;
	private String fc_flag;
	
	private String fct_name;
	public Integer getFc_pk() {
		return fc_pk;
	}
	public void setFc_pk(Integer fc_pk) {
		this.fc_pk = fc_pk;
	}
	public String getFct_code() {
		return fct_code;
	}
	public void setFct_code(String fct_code) {
		this.fct_code = fct_code;
	}
	public String getFc_code() {
		return fc_code;
	}
	public void setFc_code(String fc_code) {
		this.fc_code = fc_code;
	}
	public String getFc_name() {
		return fc_name;
	}
	public void setFc_name(String fc_name) {
		this.fc_name = fc_name;
	}
	public Integer getFc_num() {
		return fc_num;
	}
	public void setFc_num(Integer fc_num) {
		this.fc_num = fc_num;
	}
	
	public String getFc_attr_name() {
		if (fc_attr.equals("0")){
			return "不可维护";
		}else if (fc_attr.equals("1")){
			return "可维护";
		}
		return fc_attr_name;
	}
	public void setFc_attr_name(String fc_attr_name) {
		
		this.fc_attr_name = fc_attr_name;
	}
	public String getFc_attr() {

		return fc_attr;
	}
	public void setFc_attr(String fc_attr) {
		this.fc_attr = fc_attr;
	}

	public String getFc_flag() {
		return fc_flag;
	}
	public void setFc_flag(String fc_flag) {
		this.fc_flag = fc_flag;
	}
	
	public String getFc_status_name() {
		if (fc_status.equals("1")){
			return "有效";
		}else if (fc_status.equals("0")){
			return "无效";
		}
		return fc_status_name;
	}
	public void setFc_status_name(String fc_status_name) {
		this.fc_status_name = fc_status_name;
	}
	public String getFc_status() {

		return fc_status;
	}
	public void setFc_status(String fc_status) {
		this.fc_status = fc_status;
	}

	public String getFct_code_name() {
		return fct_code_name;
	}
	public void setFct_code_name(String fct_code_name) {
		this.fct_code_name = fct_code_name;
	}
	public String getFct_name() {
		return fct_name;
	}
	public void setFct_name(String fct_name) {
		this.fct_name = fct_name;
	}
	
	
}
