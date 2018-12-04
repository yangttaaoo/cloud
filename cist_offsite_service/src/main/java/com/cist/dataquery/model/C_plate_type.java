/**
 * 
 */
package com.cist.dataquery.model;

import java.io.Serializable;

/**
 * 号牌种类
 *
 */
public class C_plate_type implements Serializable{
	private static final long serialVersionUID = 8191657114561941159L;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public C_plate_type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public C_plate_type(Integer pk, String code, String name) {
		super();
		this.pk = pk;
		this.code = code;
		this.name = name;
	}

}
