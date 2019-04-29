package com.cist.qwgl.qwpb.model;

import java.io.Serializable;
/**
 * 警员详细信息
 * @author Administrator
 *
 */
public class SYS_POLICE_INFO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7550183970434751705L;
	private Integer sypi_pk;
	private String sypi_name;//姓名
	private String sypi_caller;//呼号
	public Integer getSypi_pk() {
		return sypi_pk;
	}
	public void setSypi_pk(Integer sypi_pk) {
		this.sypi_pk = sypi_pk;
	}
	public String getSypi_name() {
		return sypi_name;
	}
	public void setSypi_name(String sypi_name) {
		this.sypi_name = sypi_name;
	}
	public String getSypi_caller() {
		return sypi_caller;
	}
	public void setSypi_caller(String sypi_caller) {
		this.sypi_caller = sypi_caller;
	}
	
}
