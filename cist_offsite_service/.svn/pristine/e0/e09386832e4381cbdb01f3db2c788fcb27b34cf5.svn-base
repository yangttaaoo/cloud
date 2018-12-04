package com.cist.statistics.validdata.model;

import java.text.NumberFormat;

public class DataStatic {
	/**
	 * 数量统计
	 */
	private String sssj;//开始时间
	private Integer shzs;//审核总数
	private Integer fstg;//复审通过
	private Integer fszf;//复审作废
	@SuppressWarnings("unused")
	private  String  shxl;//审核效率
	public String getSssj() {
		return sssj;
	}
	public void setSssj(String sssj) {
		this.sssj = sssj;
	}
	public Integer getShzs() {
		return shzs;
	}
	public void setShzs(Integer shzs) {
		this.shzs = shzs;
	}
	public Integer getFstg() {

		return fstg;
	}
	public void setFstg(Integer fstg) {
		
		this.fstg = fstg;
	}
	public Integer getFszf() {
		return fszf;
	}
	public void setFszf(Integer fszf) {
		this.fszf = fszf;
	}
	
	public String getShxl() {
		NumberFormat  format= NumberFormat.getInstance();
		format.setMaximumFractionDigits(0);
		return shxl= format.format(((float)fstg/(float)shzs)*100)+"%";
	}
	public void setShxl(String shxl) {
		this.shxl = shxl;
	}
}
