package com.cist.interfaceajk.model;

import java.util.Date;

/***
 * 使用接口调用信息
 * @author wt
 *
 */
public class Sjgxinterfaceconnect {
   private Integer pk_id;//使用接口调用信息
   private Integer interface_id;//接口ID
   private Integer connect_dept_id;//调用单位
   private Date connect_time;//调用时间
   private Integer connect_status;//调用结果0不成功1成功
public Integer getPk_id() {
	return pk_id;
}
public void setPk_id(Integer pk_id) {
	this.pk_id = pk_id;
}
public Integer getInterface_id() {
	return interface_id;
}
public void setInterface_id(Integer interface_id) {
	this.interface_id = interface_id;
}
public Integer getConnect_dept_id() {
	return connect_dept_id;
}
public void setConnect_dept_id(Integer connect_dept_id) {
	this.connect_dept_id = connect_dept_id;
}
public Date getConnect_time() {
	return connect_time;
}
public void setConnect_time(Date connect_time) {
	this.connect_time = connect_time;
}
public Integer getConnect_status() {
	return connect_status;
}
public void setConnect_status(Integer connect_status) {
	this.connect_status = connect_status;
}
public Sjgxinterfaceconnect(Integer pk_id, Integer interface_id, Integer connect_dept_id, Date connect_time,
		Integer connect_status) {
	super();
	this.pk_id = pk_id;
	this.interface_id = interface_id;
	this.connect_dept_id = connect_dept_id;
	this.connect_time = connect_time;
	this.connect_status = connect_status;
}
public Sjgxinterfaceconnect() {
	super();
}
   
}
