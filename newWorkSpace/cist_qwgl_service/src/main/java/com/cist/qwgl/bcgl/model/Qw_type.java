package com.cist.qwgl.bcgl.model;

import java.io.Serializable;
/**
 * 勤务类型实体类
 * @author hy
 *
 */
public class Qw_type implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 999623688464176280L;
	private Integer qw_pk;
	private String qw_name;//勤务类型名称
	public Integer getQw_pk() {
		return qw_pk;
	}
	public void setQw_pk(Integer qw_pk) {
		this.qw_pk = qw_pk;
	}
	public String getQw_name() {
		return qw_name;
	}
	public void setQw_name(String qw_name) {
		this.qw_name = qw_name;
	}
	
}
