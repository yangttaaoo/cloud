package com.cist.earlyewarningpost.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
/***
 * 9.32. GPS设备历史定位信息表
 * @author wangtao
 *
 */
public class Qw_gps_history implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer	gpsid;//gps设备标识符
	private String	ywbh;//业务编号（设备类型为2时业务编号为车牌号，其它类型为警员编号）
	private String	sim;//手机号码
	private Date	gpstime;//gps定位时间
	private BigDecimal	jd;//经度
	private BigDecimal	wd;//纬度
	private String	dqwz;//当前位置
	private String	e_w;//e东经 w西经
	private String	n_s;//n北纬 s南纬
	private String	ydsd;//速度
	private String	gpssd;//相对位移速度
	private String	fx;//相对位移方向
	private String	hbgd;//海拔高度
	private String	wyjl;//相对位移距离
	private Date	rksj;//sysdate	入库时间
	private Integer	sblx;//设备类型（1-手机，2-警车，3-警务通，4-350m）
	private String	sbwybm;//gps设备唯一编码
	private String	zwdz;//中文地址
	private String police_name;//警员姓名
	public Integer getGpsid() {
		return gpsid;
	}
	public void setGpsid(Integer gpsid) {
		this.gpsid = gpsid;
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
	public String getDqwz() {
		return dqwz;
	}
	public void setDqwz(String dqwz) {
		this.dqwz = dqwz;
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
	public Integer getSblx() {
		return sblx;
	}
	public void setSblx(Integer sblx) {
		this.sblx = sblx;
	}
	public String getSbwybm() {
		return sbwybm;
	}
	public void setSbwybm(String sbwybm) {
		this.sbwybm = sbwybm;
	}
	public String getZwdz() {
		return zwdz;
	}
	public void setZwdz(String zwdz) {
		this.zwdz = zwdz;
	}
	public Qw_gps_history(Integer gpsid, String ywbh, String sim, Date gpstime, BigDecimal jd, BigDecimal wd, String dqwz,
			String e_w, String n_s, String ydsd, String gpssd, String fx, String hbgd, String wyjl, Date rksj,
			Integer sblx, String sbwybm, String zwdz) {
		super();
		this.gpsid = gpsid;
		this.ywbh = ywbh;
		this.sim = sim;
		this.gpstime = gpstime;
		this.jd = jd;
		this.wd = wd;
		this.dqwz = dqwz;
		this.e_w = e_w;
		this.n_s = n_s;
		this.ydsd = ydsd;
		this.gpssd = gpssd;
		this.fx = fx;
		this.hbgd = hbgd;
		this.wyjl = wyjl;
		this.rksj = rksj;
		this.sblx = sblx;
		this.sbwybm = sbwybm;
		this.zwdz = zwdz;
	}
	public Qw_gps_history() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getPolice_name() {
		if(2 != this.sblx) {
			police_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_JY, ywbh);
		}
		return police_name;
	}

	public void setPolice_name(String police_name) {
		this.police_name = police_name;
	}
    
}
