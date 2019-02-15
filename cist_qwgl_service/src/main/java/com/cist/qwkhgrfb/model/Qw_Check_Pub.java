package com.cist.qwkhgrfb.model;

import java.io.Serializable;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class Qw_Check_Pub implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pk;//id
	private String  khbh;//考核人编号/考核单位编号
	private String  khzb;//考核指标
	private String  zhzb;//综合指标
	private String  sfhg;//是否合格，0-不合格 1-合格
	private String zbrq;//指标日期
	private String  zbnf;//指标年份
	private String  gldw;//管理单位编码
    private Date zbkssj;//指标开始时间
    private Date zbjssj;//指标结束时间
    private String  khlx;//考核类型，1-个人 2-单位
    private String deptname;
    
    public String getDeptname() {
    	if(khbh!=null){
    		deptname=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT,khbh); ;
			return deptname;
		}
    	return khbh;
	}
    
    public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
    
	public Integer getPk() {
		return pk;
	}
	public void setPk(Integer pk) {
		this.pk = pk;
	}
	public String getKhbh() {
		if(khbh!=null){
			khbh=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER,khbh); ;
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
		return sfhg;
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
			gldw=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT, gldw);
		}
		return gldw;
	}
	public void setGldw(String gldw) {
		this.gldw = gldw;
	}
	public Date getZbkssj() {
		return zbkssj;
	}
	public void setZbkssj(Date zbkssj) {
		this.zbkssj = zbkssj;
	}
	public Date getZbjssj() {
		return zbjssj;
	}
	public void setZbjssj(Date zbjssj) {
		this.zbjssj = zbjssj;
	}
	public String getKhlx() {
		return khlx;
	}
	public void setKhlx(String khlx) {
		this.khlx = khlx;
	}
    
    
}
