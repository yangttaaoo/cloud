package com.cist.earlywarning.model;

import java.io.Serializable;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class WarningInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer pk;//主键
	private String hphm;//号牌号码
	private String hpzl;//号牌种类
	private String hpzl_name;//号牌种类名称
	private Date gcsj;//过车时间
	private Date yjsj;//预警时间
	private String yjsb;//预警设备
	private String xssd;//行驶速度
	private String ssbm;//所属部门
	private String ssbm_name;//所属部门名称
	private String jyaq;//简要案情
	private String ajly;//案件来源
	private String gctp1;//过车图片1
	private String gctp2;//过车图片2
	private String tpzj;//车辆图片
	private String bkyy;//布控原因
	private String xsfx;//行驶方向
	private String sbmc;//设备名称
	private String road_name;//经过地点
	private String gcsj_name;
	private String yjsj_name;
	private Integer jd;//经度
	private Integer wd;//纬度
	
	
	
	public Integer getJd() {
		return jd;
	}
	public void setJd(Integer jd) {
		this.jd = jd;
	}
	public Integer getWd() {
		return wd;
	}
	public void setWd(Integer wd) {
		this.wd = wd;
	}
	public String getSsbm_name() {
		if(ssbm!=null)
		{
			ssbm_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT, ssbm);
		}
		return ssbm_name;
	}
	public void setSsbm_name(String ssbm_name) {
		this.ssbm_name = ssbm_name;
	}
	public String getHpzl_name() {
		if(hpzl!=null) {
			hpzl_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_HPZL, hpzl);
		}
		return hpzl_name;
	}
	public void setHpzl_name(String hpzl_name) {
		
		this.hpzl_name = hpzl_name;
	}
	public String getRoad_name() {
		return road_name;
	}
	public void setRoad_name(String road_name) {
		this.road_name = road_name;
	}
	public String getXsfx() {
		return xsfx;
	}
	public void setXsfx(String xsfx) {
		this.xsfx = xsfx;
	}
	public String getSbmc() {
		return sbmc;
	}
	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}
	public String getGcsj_name() {
		return gcsj_name;
	}
	public void setGcsj_name(String gcsj_name) {
		this.gcsj_name = gcsj_name;
	}
	public String getYjsj_name() {
		return yjsj_name;
	}
	public void setYjsj_name(String yjsj_name) {
		this.yjsj_name = yjsj_name;
	}
	public String getBkyy() {
		return bkyy;
	}
	public void setBkyy(String bkyy) {
		this.bkyy = bkyy;
	}
	public String getTpzj() {
		return tpzj;
	}
	public void setTpzj(String tpzj) {
		this.tpzj = tpzj;
	}
	public Integer getPk() {
		return pk;
	}
	public void setPk(Integer pk) {
		this.pk = pk;
	}
	public String getHphm() {
		return hphm;
	}
	public void setHphm(String hphm) {
		this.hphm = hphm;
	}
	public String getHpzl() {
		return hpzl;
	}
	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}
	public Date getGcsj() {
		return gcsj;
	}
	public void setGcsj(Date gcsj) {
		this.gcsj = gcsj;
	}
	public Date getYjsj() {
		return yjsj;
	}
	public void setYjsj(Date yjsj) {
		this.yjsj = yjsj;
	}
	public String getYjsb() {
		return yjsb;
	}
	public void setYjsb(String yjsb) {
		this.yjsb = yjsb;
	}
	public String getXssd() {
		return xssd;
	}
	public void setXssd(Float xssd) {
		this.xssd = xssd.toString()+"千米/小时";
	}
	public String getSsbm() {
		return ssbm;
	}
	public void setSsbm(String ssbm) {
		this.ssbm = ssbm;
	}
	public String getJyaq() {
		return jyaq;
	}
	public void setJyaq(String jyaq) {
		this.jyaq = jyaq;
	}
	public String getAjly() {
		return ajly;
	}
	public void setAjly(String ajly) {
		this.ajly = ajly;
	}
	public String getGctp1() {
		return gctp1;
	}
	public void setGctp1(String gctp1) {
		this.gctp1 = gctp1;
	}
	public String getGctp2() {
		return gctp2;
	}
	public void setGctp2(String gctp2) {
		this.gctp2 = gctp2;
	}
	
	
}
