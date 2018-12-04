package com.cist.dataquery.model;

import java.io.Serializable;

public class Direction implements Serializable {
	/**
	 * 方向表
	 */
	private static final long serialVersionUID = 1L;
	private Integer PK;
	private String dir_code;
	private String dir_name;

	public Integer getPK() {
		return PK;
	}

	public void setPK(Integer pK) {
		PK = pK;
	}

	public String getDir_code() {
		return dir_code;
	}

	public void setDir_code(String dir_code) {
		this.dir_code = dir_code;
	}

	public String getDir_name() {
		return dir_name;
	}

	public void setDir_name(String dir_name) {
		this.dir_name = dir_name;
	}
}
