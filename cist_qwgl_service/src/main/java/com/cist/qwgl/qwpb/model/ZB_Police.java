package com.cist.qwgl.qwpb.model;

import java.io.Serializable;
/**
 * 值班警员
 * @author Administrator
 *
 */
public class ZB_Police implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1808256454562578950L;

	private Integer sypi_pk;
	private String sypi_name;
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
	
}
