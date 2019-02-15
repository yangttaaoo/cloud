package com.cist.qwgl.qwjg.model;

import java.io.Serializable;
import java.util.Date;

import com.cist.qwgl.qwbb.model.Qw_report_street;
/***
 * 9.42. 街面勤务异常日志
 * @author wangtao
 *
 */
public class Qw_patrol_alarm_log implements Serializable{
	private static final long serialVersionUID = 1L;
    private Integer pk;//
    private Integer jmqwbbid;//街面勤务报备id
    private String zqr;//执勤人（姓名（编号））
    private String sbwybm;//gps设备唯一编码
    private String yclx;//	异常类型（参考sys_frm_code表中fc_code=qw08）
    private String jd;//经度
    private String wd;//纬度
    private String yjdd;//异常地点
    private String kyfw;//跨域范围（跨辖区、跨中队、跨大队），当异常类型为未在辖区执勤时该字段有效
    private Date yjkssj;//异常开始时间
    private Date yjjssj;//异常结束时间
    private String cxsj;//持续时长（小时、分钟）
    private Integer rwid;//指挥调度派发任务id
    private Qw_report_street qw_report_street;//9.19. 街面勤务报备
    
	public Qw_report_street getQw_report_street() {
		return qw_report_street;
	}
	public void setQw_report_street(Qw_report_street qw_report_street) {
		this.qw_report_street = qw_report_street;
	}
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
	public String getJd() {
		return jd;
	}
	public void setJd(String jd) {
		this.jd = jd;
	}
	public String getWd() {
		return wd;
	}
	public void setWd(String wd) {
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Qw_patrol_alarm_log(Integer pk, Integer jmqwbbid, String zqr, String sbwybm, String yclx, String jd,
			String wd, String yjdd, String kyfw, Date yjkssj, Date yjjssj, String cxsj, Integer rwid) {
		super();
		this.pk = pk;
		this.jmqwbbid = jmqwbbid;
		this.zqr = zqr;
		this.sbwybm = sbwybm;
		this.yclx = yclx;
		this.jd = jd;
		this.wd = wd;
		this.yjdd = yjdd;
		this.kyfw = kyfw;
		this.yjkssj = yjkssj;
		this.yjjssj = yjjssj;
		this.cxsj = cxsj;
		this.rwid = rwid;
	}
	public Qw_patrol_alarm_log() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
