package com.cist.qwgl.qwpb.model;

import java.io.Serializable;
import java.util.List;

public class DEPT implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -251902339924679001L;
	private String dept_name;
	private List<QWGL_QWPB_QWLX> qw_name;
	private Integer rownum;
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public List<QWGL_QWPB_QWLX> getQw_name() {
		return qw_name;
	}
	public void setQw_name(List<QWGL_QWPB_QWLX> qw_name) {
		this.qw_name = qw_name;
	}
	public Integer getRownum() {
		return rownum;
	}
	public void setRownum(Integer rownum) {
		this.rownum = rownum;
	}
	
}
