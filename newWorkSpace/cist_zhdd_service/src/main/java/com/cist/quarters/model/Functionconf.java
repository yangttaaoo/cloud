package com.cist.quarters.model;

import java.io.Serializable;
/***
 * 配置基础信息
 * @author admin
 *
 */
public class Functionconf implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer pk_id;
	private String fk_function_type_id;//配置类型ID
	private String function_content;//配置内容（接处警、设备告警、警员、警车、电警、卡口、诱导屏、信号灯、摄像头、机柜、施工占道、交通管制、交通流量）
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public String getFk_function_type_id() {
		return fk_function_type_id;
	}
	public void setFk_function_type_id(String fk_function_type_id) {
		this.fk_function_type_id = fk_function_type_id;
	}
	public String getFunction_content() {
		return function_content;
	}
	public void setFunction_content(String function_content) {
		this.function_content = function_content;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Functionconf(Integer pk_id, String fk_function_type_id, String function_content) {
		super();
		this.pk_id = pk_id;
		this.fk_function_type_id = fk_function_type_id;
		this.function_content = function_content;
	}
	public Functionconf() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
