package com.cist.illegalbehavior.model;

import java.util.Date;

public class TblWfxwXwStat {
	private Long pk;// ID

	private String wfxwmc;// 违法行为名称简称

	private Integer wfxwzs;// 违法行为总数

	private String wfxwzb;// 占比

	private Date tjsj;// 统计时间（格式：YYYY-MM-dd）

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getWfxwmc() {
		return wfxwmc;
	}

	public void setWfxwmc(String wfxwmc) {
		this.wfxwmc = wfxwmc == null ? null : wfxwmc.trim();
	}

	public Integer getWfxwzs() {
		return wfxwzs;
	}

	public void setWfxwzs(Integer wfxwzs) {
		this.wfxwzs = wfxwzs;
	}

	public String getWfxwzb() {
		return wfxwzb;
	}

	public void setWfxwzb(String wfxwzb) {
		this.wfxwzb = wfxwzb == null ? null : wfxwzb.trim();
	}

	public Date getTjsj() {
		return tjsj;
	}

	public void setTjsj(Date tjsj) {
		this.tjsj = tjsj;
	}
}