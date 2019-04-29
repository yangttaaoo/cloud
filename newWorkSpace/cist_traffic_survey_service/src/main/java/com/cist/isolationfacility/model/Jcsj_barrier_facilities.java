package com.cist.isolationfacility.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 隔离设施信息
 * @author Hy
 *
 */
public class Jcsj_barrier_facilities implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6092860408723817391L;
	private String pk_id;//id
	private String glbm;//管理部门
	private String xzqh;//区(县)代码
	private String dldm;//道路代码
	private String dllx;//道路类型，参考表（SYS_FRM_CODE=R007）
	private String lddm;//路段代码\路口号\公里数
	private String dlms;//道路米数
	private String dllxmc;//道路类型名称
	private String jdzb;//经度坐标
	private String wdzb;//纬度坐标
	private String jyms;//简要描述
	private String glsslx;//隔离设施类型，参考表（SYS_FRM_CODE=GLLX）
	private String glsscd;//隔离设施长度（单位：米）
	private String glssgd;//隔离设施高度（单位：米）
	private String glsscl;//隔离设施材料，参考表（SYS_FRM_CODE=GLCL）
	private String jsdw;//建设单位
	private String sgdw;//施工单位
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date jssj;//建设时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date syqxjzsj;//使用期限截止时间
	private String syqxy;//使用期限（年）
	private String syqxm;//使用期限（月）
	private String glsssjtp;//隔离设施实景图片路径
	
	private String glbm_name;//管理部门名称
	private String dldm_name;//道路名称
	private String glsslx_name;//隔离设施类型名称
	private String xzqh_name;//区（县）名称
	private String glsscl_name;//隔离设施材料名称
	public String getPk_id() {
		return pk_id;
	}
	public void setPk_id(String pk_id) {
		this.pk_id = pk_id;
	}
	public String getGlbm() {
		return glbm;
	}
	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}
	public String getXzqh() {
		return xzqh;
	}
	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}
	public String getDldm() {
		return dldm;
	}
	public void setDldm(String dldm) {
		this.dldm = dldm;
	}
	public String getDllx() {
		return dllx;
	}
	public void setDllx(String dllx) {
		this.dllx = dllx;
	}
	public String getLddm() {
		return lddm;
	}
	public void setLddm(String lddm) {
		this.lddm = lddm;
	}
	public String getDlms() {
		return dlms;
	}
	public void setDlms(String dlms) {
		this.dlms = dlms;
	}
	public String getDllxmc() {
		return dllxmc;
	}
	public void setDllxmc(String dllxmc) {
		this.dllxmc = dllxmc;
	}
	public String getJdzb() {
		return jdzb;
	}
	public void setJdzb(String jdzb) {
		this.jdzb = jdzb;
	}
	public String getWdzb() {
		return wdzb;
	}
	public void setWdzb(String wdzb) {
		this.wdzb = wdzb;
	}
	public String getJyms() {
		return jyms;
	}
	public void setJyms(String jyms) {
		this.jyms = jyms;
	}
	public String getGlsslx() {
		return glsslx;
	}
	public void setGlsslx(String glsslx) {
		this.glsslx = glsslx;
	}
	public String getGlsscd() {
		return glsscd;
	}
	public void setGlsscd(String glsscd) {
		this.glsscd = glsscd;
	}
	public String getGlssgd() {
		return glssgd;
	}
	public void setGlssgd(String glssgd) {
		this.glssgd = glssgd;
	}
	public String getGlsscl() {
		return glsscl;
	}
	public void setGlsscl(String glsscl) {
		this.glsscl = glsscl;
	}
	public String getJsdw() {
		return jsdw;
	}
	public void setJsdw(String jsdw) {
		this.jsdw = jsdw;
	}
	public String getSgdw() {
		return sgdw;
	}
	public void setSgdw(String sgdw) {
		this.sgdw = sgdw;
	}
	public Date getJssj() {
		return jssj;
	}
	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}
	public Date getSyqxjzsj() {
		return syqxjzsj;
	}
	public void setSyqxjzsj(Date syqxjzsj) {
		this.syqxjzsj = syqxjzsj;
	}
	public String getSyqxy() {
		return syqxy;
	}
	public void setSyqxy(String syqxy) {
		this.syqxy = syqxy;
	}
	public String getSyqxm() {
		return syqxm;
	}
	public void setSyqxm(String syqxm) {
		this.syqxm = syqxm;
	}
	public String getGlsssjtp() {
		return glsssjtp;
	}
	public void setGlsssjtp(String glsssjtp) {
		this.glsssjtp = glsssjtp;
	}
	public String getGlbm_name() {
		return glbm_name;
	}
	public void setGlbm_name(String glbm_name) {
		this.glbm_name = glbm_name;
	}
	public String getDldm_name() {
		return dldm_name;
	}
	public void setDldm_name(String dldm_name) {
		this.dldm_name = dldm_name;
	}
	public String getGlsslx_name() {
		return glsslx_name;
	}
	public void setGlsslx_name(String glsslx_name) {
		this.glsslx_name = glsslx_name;
	}
	public String getXzqh_name() {
		return xzqh_name;
	}
	public void setXzqh_name(String xzqh_name) {
		this.xzqh_name = xzqh_name;
	}
	public String getGlsscl_name() {
		return glsscl_name;
	}
	public void setGlsscl_name(String glsscl_name) {
		this.glsscl_name = glsscl_name;
	}
	
	
	
}
