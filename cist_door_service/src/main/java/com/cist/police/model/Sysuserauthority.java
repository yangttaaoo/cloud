package com.cist.police.model;

import java.util.List;

/***
 * 用户授权表
 * @author asus
 *
 */
public class Sysuserauthority {
   private Integer sypi_pk;//用户id
   private Integer symi_pk;//菜单id
   private String dept_pk_lev;//树结构
   
public String getDept_pk_lev() {
	return dept_pk_lev;
}
public void setDept_pk_lev(String dept_pk_lev) {
	this.dept_pk_lev = dept_pk_lev;
}
public Integer getSypi_pk() {
	return sypi_pk;
}
public void setSypi_pk(Integer sypi_pk) {
	this.sypi_pk = sypi_pk;
}
public Integer getSymi_pk() {
	return symi_pk;
}
public void setSymi_pk(Integer symi_pk) {
	this.symi_pk = symi_pk;
}
public Sysuserauthority(Integer sypi_pk, Integer symi_pk) {
	super();
	this.sypi_pk = sypi_pk;
	this.symi_pk = symi_pk;
}
public Sysuserauthority() {
	super();
}
   
}
