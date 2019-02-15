package com.cist.inspectionplan.model;

import java.io.Serializable;

public class RoadInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer roim_code;
	private String roim_name;
	public Integer getRoim_code() {
		return roim_code;
	}
	public void setRoim_code(Integer roim_code) {
		this.roim_code = roim_code;
	}
	public String getRoim_name() {
		return roim_name;
	}
	public void setRoim_name(String roim_name) {
		this.roim_name = roim_name;
	}
}
