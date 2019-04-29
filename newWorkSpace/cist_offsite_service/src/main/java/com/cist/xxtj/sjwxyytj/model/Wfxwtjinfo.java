package com.cist.xxtj.sjwxyytj.model;

import java.io.Serializable;

public class Wfxwtjinfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3702550236446331739L;
	private String wfxwname;
	private String wfxwcode;
	private Integer num;
	private String wfzb;
	public String getWfxwname() {
		return wfxwname;
	}
	public void setWfxwname(String wfxwname) {
		this.wfxwname = wfxwname;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getWfzb() {
		return wfzb;
	}
	public void setWfzb(String wfzb) {
		this.wfzb = wfzb;
	}
	public String getWfxwcode() {
		return wfxwcode;
	}
	public void setWfxwcode(String wfxwcode) {
		this.wfxwcode = wfxwcode;
	}
}
