package com.cist.warningmonitor.model;

import java.io.Serializable;
import java.util.Date;

public class MonitorInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String hphm;//号牌号码
	private String gcsj_name;//过车时间
	private String jgdd;//经过地点
	private String yjsb;//预警设备
	private String bkkssj_name;//布控开始时间
	private String xfr="暂无";//下发人
	private String qsr="暂无";//签收人
	private String yjpk;//预警pk
	private String dksj="暂无";//档扣时间
	private String zt;//状态
	private String zt_name;//状态中文名
	private String zt_code;//状态前原点颜色
	private String sbmc;//设备名称
	private String xssd;//行驶速度
	private String jyaq;//简要案情
	private String ajly;//案件来源
	private String ssbm;//所属部门
	private String ssbm_name;//所属部门名称
	private String hpzl;//号牌种类
	private String hpzl_name;//号牌种类名称
	private String xfsj="暂无";
	private String gctp1;//过车图片1
	private String gctp2;//过车图片2
	private String qssj="暂无";//签收时间
	private String bkyy;//布控原因
	private Integer jd;//经度	
	private Integer wd;//维度
	
	
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
	public String getBkyy() {
		return bkyy;
	}
	public void setBkyy(String bkyy) {
		this.bkyy = bkyy;
	}
	public String getQssj() {
		return qssj;
	}
	public void setQssj(String qssj) {
		this.qssj = qssj;
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
	public String getDksj() {
		return dksj;
	}
	public void setDksj(String dksj) {
		this.dksj = dksj;
	}
	public String getXfsj() {
		return xfsj;
	}
	public void setXfsj(String xfsj) {
		this.xfsj = xfsj;
	}
	public String getHpzl() {
		return hpzl;
	}
	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}
	public String getHpzl_name() {
		return hpzl_name;
	}
	public void setHpzl_name(String hpzl_name) {
		this.hpzl_name = hpzl_name;
	}
	public String getSsbm() {
		return ssbm;
	}
	public void setSsbm(String ssbm) {
		this.ssbm = ssbm;
	}
	public String getSsbm_name() {
		return ssbm_name;
	}
	public void setSsbm_name(String ssbm_name) {
		this.ssbm_name = ssbm_name;
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
	public String getXssd() {
		return xssd;
	}
	public void setXssd(Float xssd) {
		this.xssd = xssd.toString()+"千米/小时";
	}
	public String getSbmc() {
		return sbmc;
	}
	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}
	public String getZt_code() {
		return zt_code;
	}
	public void setZt_code(String zt_code) {
		this.zt_code = zt_code;
	}
	public String getYjsb() {
		return yjsb;
	}
	public void setYjsb(String yjsb) {
		this.yjsb = yjsb;
	}
	public String getHphm() {
		return hphm;
	}
	public void setHphm(String hphm) {
		this.hphm = hphm;
	}
	public String getJgdd() {
		return jgdd;
	}
	public void setJgdd(String jgdd) {
		this.jgdd = jgdd;
	}

	public String getGcsj_name() {
		return gcsj_name;
	}
	public void setGcsj_name(String gcsj_name) {
		this.gcsj_name = gcsj_name;
	}
	public String getBkkssj_name() {
		return bkkssj_name;
	}
	public void setBkkssj_name(String bkkssj_name) {
		this.bkkssj_name = bkkssj_name;
	}
	public String getXfr() {
		return xfr;
	}
	public void setXfr(String xfr) {
			this.xfr = xfr;
	}
	public String getQsr() {
		return qsr;
	}
	public void setQsr(String qsr) {
			this.qsr = qsr;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		if(this.yjpk==null){
			this.zt = "1";
			this.setZt_name("未下达");
			this.setQsr("暂无");
			this.setXfr("暂无");
			this.setZt_code("default");
		}else if(!this.dksj.equals("暂无")){
			this.zt = "4";
			this.setZt_name("已完结");
			this.setZt_code("success");
		}else if(!this.qsr.equals("暂无")){
			this.zt = "3";
			this.setZt_name("已签收");
			this.setZt_code("processing");
		}else{
			this.zt = "2";
			this.setZt_name("已下达");
			this.setQsr("暂无");
			this.setZt_code("warning");
		}
	}
	public String getZt_name() {
		return zt_name;
	}
	public void setZt_name(String zt_name) {
		this.zt_name = zt_name;
	}
	public String getYjpk() {
		return yjpk;
	}
	public void setYjpk(String yjpk) {
		this.yjpk = yjpk;
	}
	
}
