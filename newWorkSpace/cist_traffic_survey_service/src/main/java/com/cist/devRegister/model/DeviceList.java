package com.cist.devRegister.model;

import com.cist.frame.utils.SysTempStoreUtils;

public class DeviceList {
	// ID
	private int pk_id;
	// 设备名称
	private String device_name;
	// 设备编号
	private String device_num;
	// 道路名称
	private String road_name;
	// 设备类型
	private String device_type_name;
	// 部门ID
	private String dept_name;
	
	private String validity_date;
	private String bayonet_type;
	private String bayonet_type_name;
	
	
	

	public String getBayonet_type_name() {
		if(null!=bayonet_type) 
		return SysTempStoreUtils.getFcName("KK67", bayonet_type);
		return bayonet_type_name;
	}

	public void setBayonet_type_name(String bayonet_type_name) {
		this.bayonet_type_name = bayonet_type_name;
	}

	public String getBayonet_type() {
		return bayonet_type;
	}

	public void setBayonet_type(String bayonet_type) {
		this.bayonet_type = bayonet_type;
	}

	public int getPk_id() {
		return pk_id;
	}

	public void setPk_id(int pk_id) {
		this.pk_id = pk_id;
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

	public String getDevice_type_name() {
		return device_type_name;
	}

	public void setDevice_type_name(String device_type_name) {
		this.device_type_name = device_type_name;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getValidity_date() {
		return validity_date;
	}

	public void setValidity_date(String validity_date) {
		this.validity_date = validity_date;
	}
	
	
	
}
