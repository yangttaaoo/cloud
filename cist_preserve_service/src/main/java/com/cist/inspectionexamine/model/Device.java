package com.cist.inspectionexamine.model;

import java.io.Serializable;

public class Device implements Serializable{

	private static final long serialVersionUID = 1L;
	private String contacts_person;//负责人
	private String device_name;//设备名称
	private String device_num;//设备编号
	private String road_name;//设备所属位置
	public String getContacts_person() {
		return contacts_person;
	}
	public void setContacts_person(String contacts_person) {
		this.contacts_person = contacts_person;
	}
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	public String getDevice_num() {
		return device_num;
	}
	public void setDevice_num(String device_num) {
		this.device_num = device_num;
	}
	public String getRoad_name() {
		return road_name;
	}
	public void setRoad_name(String road_name) {
		this.road_name = road_name;
	}
	
	
}
