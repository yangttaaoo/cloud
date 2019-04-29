package com.cist.personageassess.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 街面勤务异常日志
 * @author Hy
 *
 */
public class Qw_patrol_alarm_log implements Serializable {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 328783039382568480L;
	private Integer pk;//ID
       private Integer jmqwbbid;//街面勤务报备ID
       private String zqr;//执勤人（姓名（编号））
       private String sbwybm;//GPS设备唯一编码
       private String yclx;//异常类型（参考SYS_FRM_CODE表中FC_CODE=QW08）
       private BigDecimal jd;//经度
       private BigDecimal wd;//纬度
       private String yjdd;//异常地点
       private String kyfw;//跨域范围（跨辖区、跨中队、跨大队），当异常类型为未在辖区执勤时该字段有效
       @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
       private Date yjkssj;//异常开始时间
       @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
       private Date yjjssj;//异常结束时间
       private String cxsj;//持续时长（小时、分钟）
       private Integer rwid;//指挥调度派发任务ID
	public Integer getPk() {
		return pk;
	}
	public void setPk(Integer pk) {
		this.pk = pk;
	}
	public Integer getJmqwbbid() {
		return jmqwbbid;
	}
	public void setJmqwbbid(Integer jmqwbbid) {
		this.jmqwbbid = jmqwbbid;
	}
	public String getZqr() {
		return zqr;
	}
	public void setZqr(String zqr) {
		this.zqr = zqr;
	}
	public String getSbwybm() {
		return sbwybm;
	}
	public void setSbwybm(String sbwybm) {
		this.sbwybm = sbwybm;
	}
	public String getYclx() {
		return yclx;
	}
	public void setYclx(String yclx) {
		this.yclx = yclx;
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
	public String getYjdd() {
		return yjdd;
	}
	public void setYjdd(String yjdd) {
		this.yjdd = yjdd;
	}
	public String getKyfw() {
		return kyfw;
	}
	public void setKyfw(String kyfw) {
		this.kyfw = kyfw;
	}
	public Date getYjkssj() {
		return yjkssj;
	}
	public void setYjkssj(Date yjkssj) {
		this.yjkssj = yjkssj;
	}
	public Date getYjjssj() {
		return yjjssj;
	}
	public void setYjjssj(Date yjjssj) {
		this.yjjssj = yjjssj;
	}
	public String getCxsj() {
		return cxsj;
	}
	public void setCxsj(String cxsj) {
		this.cxsj = cxsj;
	}
	public Integer getRwid() {
		return rwid;
	}
	public void setRwid(Integer rwid) {
		this.rwid = rwid;
	}
       
}
