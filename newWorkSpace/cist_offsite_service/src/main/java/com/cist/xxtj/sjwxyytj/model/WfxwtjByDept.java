package com.cist.xxtj.sjwxyytj.model;

import java.io.Serializable;
import java.util.List;

public class WfxwtjByDept implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6316274963365618803L;
	private String glbm;//部门名称
	private Integer wxzs;//无效总数
	private String wfxwtj;//违法行为统计  已'-'隔开的json字符串统计
	private List<Wfxwtjinfo> list;//存放违法行为统计详情
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
	public List<Wfxwtjinfo> getList() {
		return list;
	}
	public void setList(List<Wfxwtjinfo> list) {
		this.list = list;
	}
	
}
