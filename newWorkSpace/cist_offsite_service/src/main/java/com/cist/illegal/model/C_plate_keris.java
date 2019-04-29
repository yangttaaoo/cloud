package com.cist.illegal.model;

import java.io.Serializable;
/**
 * 车牌号
 * @author hy
 *
 */
public class C_plate_keris implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4196602812323473435L;
	private Integer pk;
	private String code;
	private String name;
	public Integer getPk() {
		return pk;
	}
	public void setPk(Integer pk) {
		this.pk = pk;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
