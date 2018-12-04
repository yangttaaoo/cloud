package com.cist.qwgl.qwpb.model;

import java.io.Serializable;

public class QWGL_PBGL_CXCL implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 768114090550324331L;
	private Integer pk;
	private String cx_pk;//与QWGL_PBGL_PBINFO中cx字段关联
	private String car_pk;//车辆id
	private String hphm;//号牌号码
	private String fzr;//负责人
	private String zqmj;//执勤民警
	private String zqxj;//执勤协警
	public Integer getPk() {
		return pk;
	}
	public void setPk(Integer pk) {
		this.pk = pk;
	}
	public String getCx_pk() {
		return cx_pk;
	}
	public void setCx_pk(String cx_pk) {
		this.cx_pk = cx_pk;
	}
	public String getHphm() {
		return hphm;
	}
	public void setHphm(String hphm) {
		this.hphm = hphm;
	}
	public String getFzr() {
		return fzr;
	}
	public void setFzr(String fzr) {
		this.fzr = fzr;
	}
	public String getZqmj() {
		return zqmj;
	}
	public void setZqmj(String zqmj) {
		this.zqmj = zqmj;
	}
	public String getZqxj() {
		return zqxj;
	}
	public void setZqxj(String zqxj) {
		this.zqxj = zqxj;
	}
	public String getCar_pk() {
		return car_pk;
	}
	public void setCar_pk(String car_pk) {
		this.car_pk = car_pk;
	}
	
}
