package com.cist.illegal.model;

import java.io.Serializable;

/**
 * 基础信息表
 * @author Hy
 *
 */
public class SYS_FRM_CODE implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -973881652436608126L;
	private Integer fc_pk;
	private String fct_code;//代码类别（关联SYS_FRM _CODE_TYPE表中FCT_CODE字段）
	private String fc_code;//代码值
	private String fc_name;//代码说明
	private Integer fc_num;//顺序号
	private String fc_attr;//代码属性，0-不可维护，1-可维护）
	private String fc_status;//状态，0-无效，1-有效
	private String fc_flag;//状态标记，0-删除，1-正常
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
	
}
