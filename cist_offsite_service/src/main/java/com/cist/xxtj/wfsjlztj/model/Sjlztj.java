package com.cist.xxtj.wfsjlztj.model;

import java.io.Serializable;
/**
 * 数据流转统计
 * @author Hy
 *
 */
public class Sjlztj implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7554897389393000943L;
	private String rq;//日期
	private Integer cjzs;//抓拍总数
	private Integer shzs;//审核总数
	private Integer sczs;//上传总数
	public String getRq() {
		return rq;
	}
	public void setRq(String rq) {
		this.rq = rq;
	}
	public Integer getCjzs() {
		return cjzs;
	}
	public void setCjzs(Integer cjzs) {
		this.cjzs = cjzs;
	}
	public Integer getShzs() {
		return shzs;
	}
	public void setShzs(Integer shzs) {
		this.shzs = shzs;
	}
	public Integer getSczs() {
		return sczs;
	}
	public void setSczs(Integer sczs) {
		this.sczs = sczs;
	}
	
}
