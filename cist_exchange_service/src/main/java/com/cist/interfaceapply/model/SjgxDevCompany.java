package com.cist.interfaceapply.model;

import java.math.BigDecimal;

public class SjgxDevCompany {
    private Integer pk_id;//ID

    private Integer fk_dept_id;//管理部门

    private String dev_comp_name;//单位名称

    private String dev_comp_address;//单位地址

    private String dev_comp_describe;//单位描述

    private String dev_comp_contacts;//联系人

    private String dev_comp_contacts_num;//联系人电话

	public Integer getPk_id() {
		return pk_id;
	}

	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}

	public Integer getFk_dept_id() {
		return fk_dept_id;
	}

	public void setFk_dept_id(Integer fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}

	public String getDev_comp_name() {
		return dev_comp_name;
	}

	public void setDev_comp_name(String dev_comp_name) {
		this.dev_comp_name = dev_comp_name;
	}

	public String getDev_comp_address() {
		return dev_comp_address;
	}

	public void setDev_comp_address(String dev_comp_address) {
		this.dev_comp_address = dev_comp_address;
	}

	public String getDev_comp_describe() {
		return dev_comp_describe;
	}

	public void setDev_comp_describe(String dev_comp_describe) {
		this.dev_comp_describe = dev_comp_describe;
	}

	public String getDev_comp_contacts() {
		return dev_comp_contacts;
	}

	public void setDev_comp_contacts(String dev_comp_contacts) {
		this.dev_comp_contacts = dev_comp_contacts;
	}

	public String getDev_comp_contacts_num() {
		return dev_comp_contacts_num;
	}

	public void setDev_comp_contacts_num(String dev_comp_contacts_num) {
		this.dev_comp_contacts_num = dev_comp_contacts_num;
	}

}