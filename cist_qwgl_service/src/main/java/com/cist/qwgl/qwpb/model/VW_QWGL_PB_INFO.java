package com.cist.qwgl.qwpb.model;

import java.io.Serializable;
import java.util.Date;

public class VW_QWGL_PB_INFO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6917104826184190277L;
	private Integer pb_pk;//排班PK
	private String qwname;//勤务名称
	private String qw_qy;//勤务区域
	private Date kssj;//开始时间
	private Date jssj;//结束时间
	private String zbld;//值班领导
	private String zbkz;//值班科长
	private String zbmj;//值班民警
	private String zbxj;//值班协警
	private String bycl;//备用车辆
	private String pdh;//频道号
	private String zbdh;//值班电话
	private String bxfzr;//步巡负责人
	private String zqmj;//执勤民警
	private String zqxj;//执勤协警
	private String zbbb;//装备报备
	private String cx;//车巡
	private String hh;//呼号
	private String bc_name;//班次名称
	private String sfqy;//是否启用
	private String dept_name;//单位名称
	private String qw_name;//勤务名称
	public Integer getPb_pk() {
		return pb_pk;
	}
	public void setPb_pk(Integer pb_pk) {
		this.pb_pk = pb_pk;
	}
	public String getQwname() {
		return qwname;
	}
	public void setQwname(String qwname) {
		this.qwname = qwname;
	}
	public String getQw_qy() {
		return qw_qy;
	}
	public void setQw_qy(String qw_qy) {
		this.qw_qy = qw_qy;
	}
	public Date getKssj() {
		return kssj;
	}
	public void setKssj(Date kssj) {
		this.kssj = kssj;
	}
	public Date getJssj() {
		return jssj;
	}
	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}
	public String getZbld() {
		return zbld;
	}
	public void setZbld(String zbld) {
		this.zbld = zbld;
	}
	public String getZbkz() {
		return zbkz;
	}
	public void setZbkz(String zbkz) {
		this.zbkz = zbkz;
	}
	public String getZbmj() {
		return zbmj;
	}
	public void setZbmj(String zbmj) {
		this.zbmj = zbmj;
	}
	public String getZbxj() {
		return zbxj;
	}
	public void setZbxj(String zbxj) {
		this.zbxj = zbxj;
	}
	public String getBycl() {
		return bycl;
	}
	public void setBycl(String bycl) {
		this.bycl = bycl;
	}
	public String getPdh() {
		return pdh;
	}
	public void setPdh(String pdh) {
		this.pdh = pdh;
	}
	public String getZbdh() {
		return zbdh;
	}
	public void setZbdh(String zbdh) {
		this.zbdh = zbdh;
	}
	public String getBxfzr() {
		return bxfzr;
	}
	public void setBxfzr(String bxfzr) {
		this.bxfzr = bxfzr;
	}
	public String getZqmj() {
		return zqmj;
	}
	public void setZqmj(String zqmj) {
		this.zqmj = zqmj;
	}
	public String getZqxj() {
		return zqxj;
	}
	public void setZqxj(String zqxj) {
		this.zqxj = zqxj;
	}
	public String getZbbb() {
		return zbbb;
	}
	public void setZbbb(String zbbb) {
		this.zbbb = zbbb;
	}
	public String getCx() {
		return cx;
	}
	public void setCx(String cx) {
		this.cx = cx;
	}
	public String getHh() {
		return hh;
	}
	public void setHh(String hh) {
		this.hh = hh;
	}
	public String getBc_name() {
		return bc_name;
	}
	public void setBc_name(String bc_name) {
		this.bc_name = bc_name;
	}
	public String getSfqy() {
		return sfqy;
	}
	public void setSfqy(String sfqy) {
		this.sfqy = sfqy;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getQw_name() {
		return qw_name;
	}
	public void setQw_name(String qw_name) {
		this.qw_name = qw_name;
	}
	
}
