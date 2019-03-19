package com.cist.businessconfig.bayonetmanage.model;

import java.io.Serializable;

public class Jcbk_control_bayonet implements Serializable{
	
	private String pk;//主键
	private String kkbh;//卡口编号
	private String kkmc;//卡口名称
	private String dlmc;//道路名称
	private String fxlx;//方向类型 1-上行 2-下行
	private String sbfx;//设备方向
	private String xsfx;//行驶方向
	private String jd;//经度
	private String wd;//纬度
	private String enable;//是否启用（1-启用 0-禁用）
	private String ms;//描述
	private String glbm;//所属部门
	
	private String glbm_name;//管理部门名称
	private String sfqy;//是否启用
	private String fxlx_name;//方向类型名称
	private String kk;
	

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getKkbh() {
		return kkbh;
	}

	public void setKkbh(String kkbh) {
		this.kkbh = kkbh;
	}

	public String getKkmc() {
		return kkmc;
	}

	public void setKkmc(String kkmc) {
		this.kkmc = kkmc;
	}

	public String getDlmc() {
		return dlmc;
	}

	public void setDlmc(String dlmc) {
		this.dlmc = dlmc;
	}

	public String getFxlx() {
		return fxlx;
	}

	public void setFxlx(String fxlx) {
		this.fxlx = fxlx;
	}

	public String getSbfx() {
		return sbfx;
	}

	public void setSbfx(String sbfx) {
		this.sbfx = sbfx;
	}

	public String getXsfx() {
		return xsfx;
	}

	public void setXsfx(String xsfx) {
		this.xsfx = xsfx;
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

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public String getGlbm() {
		return glbm;
	}

	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}

	public String getGlbm_name() {
		return glbm_name;
	}

	public void setGlbm_name(String glbm_name) {
		this.glbm_name = glbm_name;
	}

	public String getSfqy() {
		if("1".equals(enable)){
			return "启用";
		}else if("0".equals(enable)){
			return "禁用";
		}else{
			return "未知";
		}
		
	}

	public void setSfqy(String sfqy) {
		this.sfqy = sfqy;
	}

	public String getFxlx_name() {//1-上行 2-下行
		if("1".equals(fxlx)){
			return "上行";
		}else if("2".equals(fxlx)){
			return "下行";
		}else{
			return "未知";
		}
		
	}

	public void setFxlx_name(String fxlx_name) {
		this.fxlx_name = fxlx_name;
	}

	public String getKk() {
		return kk;
	}

	public void setKk(String kk) {
		this.kk = kk;
	}
	
}
