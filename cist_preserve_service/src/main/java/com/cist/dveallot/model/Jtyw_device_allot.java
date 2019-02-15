package com.cist.dveallot.model;

public class Jtyw_device_allot {
	
	private Integer pk_id;//id
	private Integer fk_comp_id;//维护公司ID
	private String fk_comp_name;//维护公司名称
	private Integer fk_group_id;//维护组ID
	private String fk_group_name;//维护组名字
	private String fk_device_id;//设备ID
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Integer getFk_comp_id() {
		return fk_comp_id;
	}
	public void setFk_comp_id(Integer fk_comp_id) {
		this.fk_comp_id = fk_comp_id;
	}
	public Integer getFk_group_id() {
		return fk_group_id;
	}
	public void setFk_group_id(Integer fk_group_id) {
		this.fk_group_id = fk_group_id;
	}
	public String getFk_device_id() {
		return fk_device_id;
	}
	public void setFk_device_id(String fk_device_id) {
		this.fk_device_id = fk_device_id;
	}
	public String getFk_group_name() {
		return fk_group_name;
	}
	public void setFk_group_name(String fk_group_name) {
		this.fk_group_name = fk_group_name;
	}
	public String getFk_comp_name() {
		return fk_comp_name;
	}
	public void setFk_comp_name(String fk_comp_name) {
		this.fk_comp_name = fk_comp_name;
	}
	
	
}
