package com.cist.duty.model;

import java.io.Serializable;

public class Rule_info implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String lmmc;
	private Integer pk;
	private String tlmc;
	
	public String getTlmc() {
		return tlmc;
	}
	public void setTlmc(String tlmc) {
		this.tlmc = tlmc;
	}
	public String getLmmc() {
		return lmmc;
	}
	public void setLmmc(String lmmc) {
		this.lmmc = lmmc;
	}
	public Integer getPk() {
		return pk;
	}
	public void setPk(Integer pk) {
		this.pk = pk;
	}
	
	

}
