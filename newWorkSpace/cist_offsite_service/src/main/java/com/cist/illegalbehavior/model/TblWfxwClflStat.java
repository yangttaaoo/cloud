package com.cist.illegalbehavior.model;

import java.util.Date;

public class TblWfxwClflStat {
	private Long pk;// ID

	private String cllxmc;// 车辆分类名称

	private Integer wfxwzs;// 违法行为总数

	private String wfxwzb;// 占比

	private Date tjsj;// 统计时间（格式：YYYY-MM-dd）

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getCllxmc() {
		return cllxmc;
	}

	public void setCllxmc(String cllxmc) {
		this.cllxmc = cllxmc == null ? null : cllxmc.trim();
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