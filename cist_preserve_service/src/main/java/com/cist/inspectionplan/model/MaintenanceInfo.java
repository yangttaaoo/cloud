package com.cist.inspectionplan.model;

import java.io.Serializable;

public class MaintenanceInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer key;
	private String title;
	private String direction = "left";
	
	
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
