package com.cist.statistics.ensemblejob.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Statistics implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5604525572149769845L;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date tjsj;
	private Integer zpzs;//抓拍总数
	private Integer shzs;//审核总数
	private List datalist;//数据集合
	public Date getTjsj() {
		return tjsj;
	}
	public void setTjsj(Date tjsj) {
		this.tjsj = tjsj;
	}
	public Integer getZpzs() {
		if(zpzs==null) {
			zpzs=0;
		}
		return zpzs;
	}
	public void setZpzs(Integer zpzs) {
		this.zpzs = zpzs;
	}
	public Integer getShzs() {
		if(shzs==null) {
			shzs=0;
		}
		return shzs;
	}
	public void setShzs(Integer shzs) {
		this.shzs = shzs;
	}
	public List getDatalist() {
		return datalist;
	}
	public void setDatalist(List datalist) {
		this.datalist = datalist;
	}
	
}
