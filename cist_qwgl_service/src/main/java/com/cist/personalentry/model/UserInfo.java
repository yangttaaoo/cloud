package com.cist.personalentry.model;

import java.io.Serializable;

public class UserInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String sypi_pk;
	private String sypi_name;
	private String sypi_date;
	public String getSypi_pk() {
		return sypi_pk;
	}
	public void setSypi_pk(String sypi_pk) {
		this.sypi_pk = sypi_pk;
	}
	public String getSypi_name() {
		return sypi_name;
	}
	public void setSypi_name(String sypi_name) {
		this.sypi_name = sypi_name;
	}
	public String getSypi_date() {
		return sypi_date;
	}
	public void setSypi_date(String sypi_date) {
		this.sypi_date = sypi_date;
	}
	
	
}
