package com.cist.patrolplan.model;

public class UpdateData {
	private Integer vcf_pk;
	private Integer vcf_num;
	private String device_num;
	private String device_name;
	private Integer vcf_prest_sign;
	private Integer vcf_rest_sign;
	private Integer pk_id;
	
	public Integer getVcf_pk() {
		return vcf_pk;
	}
	
	public void setVcf_pk(Integer vcf_pk) {
		this.vcf_pk = vcf_pk;
	}

	public Integer getVcf_num() {
		return vcf_num;
	}

	public void setVcf_num(Integer vcf_num) {
		this.vcf_num = vcf_num;
	}

	public String getDevice_num() {
		return device_num;
	}

	public void setDevice_num(String device_num) {
		this.device_num = device_num;
	}

	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

	public Integer getVcf_prest_sign() {
		return vcf_prest_sign;
	}

	public void setVcf_prest_sign(Integer vcf_prest_sign) {
		this.vcf_prest_sign = vcf_prest_sign;
	}

	public Integer getVcf_rest_sign() {
		return vcf_rest_sign;
	}

	public void setVcf_rest_sign(Integer vcf_rest_sign) {
		this.vcf_rest_sign = vcf_rest_sign;
	}
	
	public Integer getPk_id() {
		return pk_id;
	}
	
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}

}
