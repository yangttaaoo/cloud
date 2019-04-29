package com.cist.xxtj.sjwxyytj.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 数据无效原因统计表（按无效原因）
 * @author Hy
 *
 */
public class TBL_WFXW_INVALID_STAT implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1229691015018809923L;
	private Integer pk;//ID
    private String glbm;//管理部门（中文）
    private Integer wxzs;//无效总数
    private String wfxwtj;//无效原因（JSON格式，{无效原因代码：数量}）
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date tjsj;//统计时间
    private String tjnf;//年份
    private String tjyf;//月份
    private String tjrq;//日
	public Integer getPk() {
		return pk;
	}
	public void setPk(Integer pk) {
		this.pk = pk;
	}
	public String getGlbm() {
		return glbm;
	}
	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}
	public Integer getWxzs() {
		return wxzs;
	}
	public void setWxzs(Integer wxzs) {
		this.wxzs = wxzs;
	}
	public String getWfxwtj() {
		return wfxwtj;
	}
	public void setWfxwtj(String wfxwtj) {
		this.wfxwtj = wfxwtj;
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
