package com.cist.qwgl.qwpb.model;

import java.io.Serializable;
/**
 * 警车信息
 * @author Administrator
 *
 */
public class QWGL_POLICE_CAR implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7142405077507470483L;
	private Integer car_pk;
	private String car_name;
	public Integer getCar_pk() {
		return car_pk;
	}
	public void setCar_pk(Integer car_pk) {
		this.car_pk = car_pk;
	}
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	
}
