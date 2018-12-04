package com.cist.xxtj.sbyjfztj.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 违法抓拍趋势
 * @author Administrator
 *
 */
public class Wfzpqs implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8179925925492713576L;
	private String sj;
	private Integer cjsl;//小时采集数量
	private Integer zccjsl;//最后一次正常数量
	private Date tjsj;//统计时间
	private Integer szzccjsl;//上一周正常采集数量
	private String dept_name;//单位
	private String sbdd;//设备地点
	public String getSj() {
		return sj;
	}
	public void setSj(String sj) {
		this.sj = sj;
	}
	public Integer getCjsl() {
		return cjsl;
	}
	public void setCjsl(Integer cjsl) {
		this.cjsl = cjsl;
	}
	public Integer getZccjsl() {
		return zccjsl;
	}
	public void setZccjsl(Integer zccjsl) {
		this.zccjsl = zccjsl;
	}
	public Integer getSzzccjsl() {
		return szzccjsl;
	}
	public void setSzzccjsl(Integer szzccjsl) {
		this.szzccjsl = szzccjsl;
	}
	public Date getTjsj() {
		return tjsj;
	}
	public void setTjsj(Date tjsj) {
		this.tjsj = tjsj;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getSbdd() {
		return sbdd;
	}
	public void setSbdd(String sbdd) {
		this.sbdd = sbdd;
	}
	
	
}
