package com.cist.statistics.stataction.model;

import java.io.Serializable;

public class IllegalBehavior implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8265044017805672284L;
	private Integer pk;
	private String wfxw_name;
	private String wfxw_code;
	public Integer getPk() {
		return pk;
	}
	public void setPk(Integer pk) {
		this.pk = pk;
	}
	public String getWfxw_name() {
		return wfxw_name;
	}
	public void setWfxw_name(String wfxw_name) {
		this.wfxw_name = wfxw_name;
	}
	public String getWfxw_code() {
		return wfxw_code;
	}
	public void setWfxw_code(String wfxw_code) {
		this.wfxw_code = wfxw_code;
	}
}
