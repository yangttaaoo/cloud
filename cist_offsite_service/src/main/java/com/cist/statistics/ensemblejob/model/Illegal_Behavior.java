package com.cist.statistics.ensemblejob.model;

import java.io.Serializable;
/**
 * 违法行为
 * @author hy
 *
 */
public class Illegal_Behavior implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1616282139457448187L;
	private String wfxw_name;
	private String wfxw_id;
	private Integer sl;
	public String getWfxw_name() {
		return wfxw_name;
	}
	public void setWfxw_name(String wfxw_name) {
		this.wfxw_name = wfxw_name;
	}
	public String getWfxw_id() {
		return wfxw_id;
	}
	public void setWfxw_id(String wfxw_id) {
		this.wfxw_id = wfxw_id;
	}
	public Integer getSl() {
		return sl;
	}
	public void setSl(Integer sl) {
		this.sl = sl;
	}
	
}
