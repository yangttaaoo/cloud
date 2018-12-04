package com.cist.myDuty.myAssess.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GpsRecord {
	// GPS设备标识符
	private long gspid;
	// 业务编号（设备类型为2时业务编号为车牌号，其它类型为警员编号）
	private String ywbh;
	// 手机号码
	private String sim;
	// GPS定位时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date gpstime;
	// 经度
	private BigDecimal jd;
	// 纬度
	private BigDecimal wd;
	// E东经 W西经
	private String e_w;
	// N北纬 S南纬
	private String n_s;
	// 速度
	private String ydsd;
	// 相对位移速度
	private String gpssd;
	// 相对位移方向
	private String fx;
	// 海拔高度
	private String hbgd;
	// 相对位移距离
	private String wyjl;
	// 入库时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date rksj;
	// 设备类型（1-手机，2-警车，3-警务通，4-350M）
	private char sblx;
	
	
	
	
	
	
	
	public GpsRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getGspid() {
		return gspid;
	}
	public void setGspid(long gspid) {
		this.gspid = gspid;
	}
	public String getYwbh() {
		return ywbh;
	}
	public void setYwbh(String ywbh) {
		this.ywbh = ywbh;
	}
	public String getSim() {
		return sim;
	}
	public void setSim(String sim) {
		this.sim = sim;
	}
	public Date getGpstime() {
		return gpstime;
	}
	public void setGpstime(Date gpstime) {
		this.gpstime = gpstime;
	}
	public BigDecimal getJd() {
		return jd;
	}
	public void setJd(BigDecimal jd) {
		this.jd = jd;
	}
	public BigDecimal getWd() {
		return wd;
	}
	public void setWd(BigDecimal wd) {
		this.wd = wd;
	}
	public String getE_w() {
		return e_w;
	}
	public void setE_w(String e_w) {
		this.e_w = e_w;
	}
	public String getN_s() {
		return n_s;
	}
	public void setN_s(String n_s) {
		this.n_s = n_s;
	}
	public String getYdsd() {
		return ydsd;
	}
	public void setYdsd(String ydsd) {
		this.ydsd = ydsd;
	}
	public String getGpssd() {
		return gpssd;
	}
	public void setGpssd(String gpssd) {
		this.gpssd = gpssd;
	}
	public String getFx() {
		return fx;
	}
	public void setFx(String fx) {
		this.fx = fx;
	}
	public String getHbgd() {
		return hbgd;
	}
	public void setHbgd(String hbgd) {
		this.hbgd = hbgd;
	}
	public String getWyjl() {
		return wyjl;
	}
	public void setWyjl(String wyjl) {
		this.wyjl = wyjl;
	}
	public Date getRksj() {
		return rksj;
	}
	public void setRksj(Date rksj) {
		this.rksj = rksj;
	}
	public char getSblx() {
		return sblx;
	}
	public void setSblx(char sblx) {
		this.sblx = sblx;
	}
	
	
	
}
