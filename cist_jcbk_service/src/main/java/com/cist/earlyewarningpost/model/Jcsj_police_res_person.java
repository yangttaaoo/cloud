package com.cist.earlyewarningpost.model;

import java.io.Serializable;

/***
 *    警务资源信息-人员
 * @author yt
 *
 */
public class Jcsj_police_res_person implements Serializable{
	private static final long serialVersionUID = 1L;
	private  Integer id;//	id
	private  String glbm;//	管理部门代码
	private  String rybh;//	民警/辅警编号
	private  String xm;//	姓名
	private  String sfzhm	;//	身份证号码
	private  String xb;//	性别
	private  String ywgw;//	业务岗位
	private  String ryfl;//		人员分类（1-民警 2-辅警）
	private  String fjlx;//		人员类型（当rylx=2时有效）
	private  String bzlx;//	编制类型（当rylx=1时有效）
	private  String zj;//	职级（当rylx=1时有效）
	private  String zw;//职务（当rylx=1时有效）
	private  String zt;//状态，0-停用 1-启用
	private  String bgdh;//办公电话
	private  String yddh;//移动电话
	private  String dth;//电台号/对讲机号
	private  String zhh;//组呼号
	private  String vwh;//V网号
	
	private  String fk_dept_name;//部门名
	private  String car_brandname;//职务名
	private  String ywgwname;//业务岗位名
	private  String xbname;//性别名
	
	private  boolean checked=false;
	
	public String getFk_dept_name() {
		return fk_dept_name;
	}
	public void setFk_dept_name(String fk_dept_name) {
		this.fk_dept_name = fk_dept_name;
	}
	public String getCar_brandname() {
		return car_brandname;
	}
	public void setCar_brandname(String car_brandname) {
		this.car_brandname = car_brandname;
	}
	public String getYwgwname() {
		return ywgwname;
	}
	public void setYwgwname(String ywgwname) {
		this.ywgwname = ywgwname;
	}
	public String getXbname() {
		return xbname;
	}
	public void setXbname(String xbname) {
		this.xbname = xbname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGlbm() {
		return glbm;
	}
	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}
	public String getRybh() {
		return rybh;
	}
	public void setRybh(String rybh) {
		this.rybh = rybh;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getSfzhm() {
		return sfzhm;
	}
	public void setSfzhm(String sfzhm) {
		this.sfzhm = sfzhm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getYwgw() {
		return ywgw;
	}
	public void setYwgw(String ywgw) {
		this.ywgw = ywgw;
	}
	public String getRyfl() {
		return ryfl;
	}
	public void setRyfl(String ryfl) {
		this.ryfl = ryfl;
	}
	public String getFjlx() {
		return fjlx;
	}
	public void setFjlx(String fjlx) {
		this.fjlx = fjlx;
	}
	public String getBzlx() {
		return bzlx;
	}
	public void setBzlx(String bzlx) {
		this.bzlx = bzlx;
	}
	public String getZj() {
		return zj;
	}
	public void setZj(String zj) {
		this.zj = zj;
	}
	public String getZw() {
		return zw;
	}
	public void setZw(String zw) {
		this.zw = zw;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public String getBgdh() {
		return bgdh;
	}
	public void setBgdh(String bgdh) {
		this.bgdh = bgdh;
	}
	public String getYddh() {
		return yddh;
	}
	public void setYddh(String yddh) {
		this.yddh = yddh;
	}
	public String getDth() {
		return dth;
	}
	public void setDth(String dth) {
		this.dth = dth;
	}
	public String getZhh() {
		return zhh;
	}
	public void setZhh(String zhh) {
		this.zhh = zhh;
	}
	public String getVwh() {
		return vwh;
	}
	public void setVwh(String vwh) {
		this.vwh = vwh;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Jcsj_police_res_person(Integer id, String glbm, String rybh, String xm, String sfzhm, String xb, String ywgw,
			String ryfl, String fjlx, String bzlx, String zj, String zw, String zt, String bgdh, String yddh,
			String dth, String zhh, String vwh) {
		super();
		this.id = id;
		this.glbm = glbm;
		this.rybh = rybh;
		this.xm = xm;
		this.sfzhm = sfzhm;
		this.xb = xb;
		this.ywgw = ywgw;
		this.ryfl = ryfl;
		this.fjlx = fjlx;
		this.bzlx = bzlx;
		this.zj = zj;
		this.zw = zw;
		this.zt = zt;
		this.bgdh = bgdh;
		this.yddh = yddh;
		this.dth = dth;
		this.zhh = zhh;
		this.vwh = vwh;
	}
	public Jcsj_police_res_person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}


}
