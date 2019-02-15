package com.cist.police.model;

public class Sysuserdataqx {
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
public Sysuserdataqx(Integer sypi_pk, Integer sypi_pkx) {
	super();
	this.sypi_pk = sypi_pk;
	this.sypi_pkx = sypi_pkx;
}
public Sysuserdataqx() {
	super();
}
   
}
