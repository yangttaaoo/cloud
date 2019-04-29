package com.cist.warnCountAnalyze.model;

import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 预警统计分析表
 * 
 * @author 57150
 *
 */
public class CarAlarmStat {
	private long pk;// ID
	private String glbm;// 管理单位
	private long yjsl;// 预警数
	private long xds;// 下达数
	private String bxds;// 不下达数（JSON格式，{不下达原因:数量}）
	private long qss;// 签收数
	private String dks;// 档口数（JSON格式，{嫌疑:数量,非嫌疑:数量}）
	private long asxds;// 按时下达数
	private long asqss;// 按时签收数
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date tjsj;// 统计时间
	private String tjnf;// 年份
	private String tjyf;// 月份
	private String tjrq;// 日

	private String glbm_name;
	
	

	public String getGlbm_name() {
		return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT, glbm);
	}

	public void setGlbm_name(String glbm_name) {
		this.glbm_name = glbm_name;
	}

	public long getPk() {
		return pk;
	}

	public void setPk(long pk) {
		this.pk = pk;
	}

	public String getGlbm() {
		return glbm;
	}

	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}

	public long getYjsl() {
		return yjsl;
	}

	public void setYjsl(long yjsl) {
		this.yjsl = yjsl;
	}

	public long getXds() {
		return xds;
	}

	public void setXds(long xds) {
		this.xds = xds;
	}

	public String getBxds() {
		return bxds;
	}

	public void setBxds(String bxds) {
		this.bxds = bxds;
	}

	public long getQss() {
		return qss;
	}

	public void setQss(long qss) {
		this.qss = qss;
	}

	public String getDks() {
		return dks;
	}

	public void setDks(String dks) {
		this.dks = dks;
	}

	public long getAsxds() {
		return asxds;
	}

	public void setAsxds(long asxds) {
		this.asxds = asxds;
	}

	public long getAsqss() {
		return asqss;
	}

	public void setAsqss(long asqss) {
		this.asqss = asqss;
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

}
