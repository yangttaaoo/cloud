package com.cist.role.model;

public class Sysroledataqx {
   private Integer sypi_pk;//用户
   private Integer sypi_pkx;//部门
public Integer getSypi_pk() {
	return sypi_pk;
}
public void setSypi_pk(Integer sypi_pk) {
	this.sypi_pk = sypi_pk;
}
public Integer getSypi_pkx() {
	return sypi_pkx;
}
public void setSypi_pkx(Integer sypi_pkx) {
	this.sypi_pkx = sypi_pkx;
}
public Sysroledataqx(Integer sypi_pk, Integer sypi_pkx) {
	super();
	this.sypi_pk = sypi_pk;
	this.sypi_pkx = sypi_pkx;
}
public Sysroledataqx() {
	super();
}
   
}
