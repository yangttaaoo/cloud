package com.cist.BaseInfo.model;

import java.io.Serializable;
public class BaseDataInfo implements Serializable{

	private static final long serialVersionUID = 20180806L;
		
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

	/**
	 * @return the fc_name
	 */
	public String getFc_name() {
		return fc_name;
	}

	/**
	 * @param fc_name
	 *            the fc_name to set
	 */
	public void setFc_name(String fc_name) {
		this.fc_name = fc_name;
	}

	/**
	 * @return the fc_code
	 */
	public String getFc_code() {
		return fc_code;
	}

	/**
	 * @param fc_code
	 *            the fc_code to set
	 */
	public void setFc_code(String fc_code) {
		this.fc_code = fc_code;
	}

	/**
	 * @return the fc_pk
	 */
	public Long getFc_pk() {
		return fc_pk;
	}

	/**
	 * @param fc_pk
	 *            the fc_pk to set
	 */
	public void setFc_pk(Long fc_pk) {
		this.fc_pk = fc_pk;
	}

	/**
	 * @return the fc_num
	 */
	public int getFc_num() {
		return fc_num;
	}

	/**
	 * @param fc_num
	 *            the fc_num to set
	 */
	public void setFc_num(int fc_num) {
		this.fc_num = fc_num;
	}

	/**
	 * @return the fct_code
	 */
	public String getFct_code() {
		return fct_code;
	}

	/**
	 * @param fct_code
	 *            the fct_code to set
	 */
	public void setFct_code(String fct_code) {
		this.fct_code = fct_code;
	}

	/**
	 * @return the fc_attr
	 */
	public String getFc_attr() {
		return fc_attr;
	}

	/**
	 * @param fc_attr
	 *            the fc_attr to set
	 */
	public void setFc_attr(String fc_attr) {
		this.fc_attr = fc_attr;
	}

	/**
	 * @return the fc_status
	 */
	public String getFc_status() {
		return fc_status;
	}

	/**
	 * @param fc_status
	 *            the fc_status to set
	 */
	public void setFc_status(String fc_status) {
		this.fc_status = fc_status;
	}

	/**
	 * @return the fc_flag
	 */
	public String getFc_flag() {
		return fc_flag;
	}

	/**
	 * @param fc_flag
	 *            the fc_flag to set
	 */
	public void setFc_flag(String fc_flag) {
		this.fc_flag = fc_flag;
	}

	/**
	 * @return the fct_name
	 */
	public String getFct_name() {
		return fct_name;
	}

	/**
	 * @param fct_name
	 *            the fct_name to set
	 */
	public void setFct_name(String fct_name) {
		this.fct_name = fct_name;
	}

	/**
	 * @return the fct_des
	 */
	public String getFct_des() {
		return fct_des;
	}

	/**
	 * @param fct_des
	 *            the fct_des to set
	 */
	public void setFct_des(String fct_des) {
		this.fct_des = fct_des;
	}

}
