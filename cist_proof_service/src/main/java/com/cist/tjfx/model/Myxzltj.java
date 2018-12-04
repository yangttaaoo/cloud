package com.cist.tjfx.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 每月新增量统计
 * @author Hy
 *
 */
public class Myxzltj implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7882427305555774528L;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date yf;
	public Integer num;
	public String xq;
	private String []arr = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
	
	public String getXq() {
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(yf);
		return arr[calendar.get(calendar.DAY_OF_WEEK)-1];
	}
	public void setXq(String xq) {
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(this.yf);
		this.xq = arr[calendar.get(calendar.DAY_OF_WEEK)-1];
	}
	public Date getYf() {
		return yf;
	}
	public void setYf(Date yf) {
		this.yf = yf;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
}
