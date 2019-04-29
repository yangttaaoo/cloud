package com.cist.qwgl.jzgl.model;

import java.io.Serializable;

/**
 * 警务资源信息-人员
 * @author Hy
 *
 */
public class Jcsj_police_res_person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1164710015347159216L;
	private Integer id;//ID
	private String glbm;//管理部门代码
	private String rybh;//民警/辅警编号
	private String xm;//姓名
	private String sfzhm;//身份证号码
	private String xb;//性别
	private String ywgw;//业务岗位
	private String ryfl;//人员分类（1-民警 2-辅警）
	private String fjlx;//人员类型（当RYLX=2时有效）
	private String bzlx;//编制类型（当RYLX=1时有效）
	private String zj;//职级（当RYLX=1时有效）
	private String zw;//职务（当RYLX=1时有效）
	private String zt;//状态，0-停用 1-启用
	private String bgdh;//办公电话
	private String yddh;//移动电话
	private String dth;//电台号/对讲机号
	private String zhh;//组呼号
	private String vwh;//V网号
	
	private String sypi_comp;//1负责人2 民警 3协警
	private String fk_police_team_id;//警组ID
	private String glbm_name;//管理部门名称
	
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
	public String getSypi_comp() {
		return sypi_comp;
	}
	public void setSypi_comp(String sypi_comp) {
		this.sypi_comp = sypi_comp;
	}
	public String getFk_police_team_id() {
		return fk_police_team_id;
	}
	public void setFk_police_team_id(String fk_police_team_id) {
		this.fk_police_team_id = fk_police_team_id;
	}
	public String getGlbm_name() {
		return glbm_name;
	}
	public void setGlbm_name(String glbm_name) {
		this.glbm_name = glbm_name;
	}
	
}
