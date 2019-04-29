package com.cist.xxtj.sbyjfztj.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 设备预警阈值统计
 * @author Administrator
 *
 */
public class TBL_OFFE_VIO_ALARM_STAT implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7672673991130439228L;
	private Integer pk;
    private String sbmc;//设备名称
    private String sbfx;//方向（中文）
    private Integer zccjsl;//最后一次正常数量
    private Integer sbcjmax;//最大预警阀值
    private Integer sbcjmin;//最小预警阀值
    private Integer cjsl;//采集数量
    private String sbdd;//安装地点（中文）
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date tjsj;//统计时间
    private String tjnf;//年份
    private String tjyf;//月份
    private String tjrq;//日
    private String tjxs;//小时	
    
    private String zzl;//增长率
    private String yjlx;//预警类型
    private Integer szcjsl;//上周的这个时间的采集量
	public Integer getPk() {
		return pk;
	}
	public void setPk(Integer pk) {
		this.pk = pk;
	}
	public String getSbmc() {
		return sbmc;
	}
	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}
	public String getSbfx() {
		return sbfx;
	}
	public void setSbfx(String sbfx) {
		this.sbfx = sbfx;
	}
	public Integer getZccjsl() {
		return zccjsl;
	}
	public void setZccjsl(Integer zccjsl) {
		this.zccjsl = zccjsl;
	}
	public Integer getSbcjmax() {
		return sbcjmax;
	}
	public void setSbcjmax(Integer sbcjmax) {
		this.sbcjmax = sbcjmax;
	}
	public Integer getSbcjmin() {
		return sbcjmin;
	}
	public void setSbcjmin(Integer sbcjmin) {
		this.sbcjmin = sbcjmin;
	}
	public Integer getCjsl() {
		return cjsl;
	}
	public void setCjsl(Integer cjsl) {
		this.cjsl = cjsl;
	}
	public String getSbdd() {
		return sbdd;
	}
	public void setSbdd(String sbdd) {
		this.sbdd = sbdd;
	}
	public Date getTjsj() {
		return tjsj;
	}
	public void setTjsj(Date tjsj) {
		this.tjsj = tjsj;
	}
	public String getTjnf() {
		return tjnf;
	}
	public void setTjnf(String tjnf) {
		this.tjnf = tjnf;
	}
	public String getTjyf() {
		return tjyf;
	}
	public void setTjyf(String tjyf) {
		this.tjyf = tjyf;
	}
	public String getTjrq() {
		return tjrq;
	}
	public void setTjrq(String tjrq) {
		this.tjrq = tjrq;
	}
	public String getTjxs() {
		return tjxs;
	}
	public void setTjxs(String tjxs) {
		this.tjxs = tjxs;
	}
	public String getZzl() {
		return ((float)(cjsl-zccjsl)/zccjsl)*100+"%";
	}
	public void setZzl(String zzl) {
		this.zzl = zzl;
	}
	public String getYjlx() {
		if(cjsl>sbcjmax) {
			return "超出最大阈值";
		}else if(cjsl<sbcjmin){
			return "低于最小阈值";
		}else {
			return "正常";
		}
	}
	public void setYjlx(String yjlx) {
		this.yjlx = yjlx;
	}
	public Integer getSzcjsl() {
		return szcjsl;
	}
	public void setSzcjsl(Integer szcjsl) {
		this.szcjsl = szcjsl;
	}

    
}
