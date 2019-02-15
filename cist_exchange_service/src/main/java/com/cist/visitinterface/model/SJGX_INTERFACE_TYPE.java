package com.cist.visitinterface.model;

import java.io.Serializable;

public class SJGX_INTERFACE_TYPE implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6623173575309258737L;
	private Integer pk_id;//id
	private String interface_type_name;//接口类型名称
	private String interface_type_describe;//接口类型描述
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public String getInterface_type_name() {
		return interface_type_name;
	}
	public void setInterface_type_name(String interface_type_name) {
		this.interface_type_name = interface_type_name;
	}
	public String getInterface_type_describe() {
		return interface_type_describe;
	}
	public void setInterface_type_describe(String interface_type_describe) {
		this.interface_type_describe = interface_type_describe;
	}
	
}
