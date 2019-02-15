package com.cist.qwkhgrfb.model;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class Publish {
	/**
	 * 导出数据
	 */
	private String  khbh;//考核人编号/考核单位编号
	private String  khzb;//考核指标
	private String  zhzb;//综合指标
	private String  sfhg;//是否合格，0-不合格 1-合格
	private String zbrq;//指标日期
	private String  zbnf;//指标年份
	private String  gldw;//管理单位编码
	public String getKhbh() {
		if(khbh!=null){
			khbh=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER,khbh ); ;
			return khbh;
		}
		return khbh;
	}
	public void setKhbh(String khbh) {
		this.khbh = khbh;
	}
	public String getKhzb() {
		return khzb;
	}
	public void setKhzb(String khzb) {
		this.khzb = khzb;
	}
	public String getZhzb() {
		return zhzb;
	}
	public void setZhzb(String zhzb) {
		this.zhzb = zhzb;
	}
	public String getSfhg() {
		return "1".equals(sfhg)?"合格":"不合格";
	}
	public void setSfhg(String sfhg) {
		this.sfhg = sfhg;
	}
	public String getZbrq() {
		return zbrq;
	}
	public void setZbrq(String zbrq) {
		this.zbrq = zbrq;
	}
	public String getZbnf() {
		return zbnf;
	}
	public void setZbnf(String zbnf) {
		this.zbnf = zbnf;
	}
	public String getGldw() {
		if(gldw!=null){
			gldw=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT_PK, gldw);
		}
		return gldw;
	}
	public void setGldw(String gldw) {
		this.gldw = gldw;
	}
    
}
