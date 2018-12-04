package com.cist.warningmanagement.controlcar.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

/**
 * 车辆布控管理表
 * 
 * @author wxc
 *
 */
public class Tbl_control_vehicle {

	private Integer pk;// 主键
	private String hphm;// 号牌号牌
	private String hpzl;// 号牌种类
	private String hpzl_name;
	private String cllx;// 车辆类型
	private String cllx_name;
	private String csys;// 车身颜色
	private String csys_name;
	private String clpp;// 车辆品牌
	private String clpp_name;
	private String bklx;// 布控类型
	private String bklx_name;
	private String lrr;// 录入人
	private String bkdw;// 布控单位
	private String bkdw_name;
	private String bkyy;// 布控原因
	private String lxdh;// 联系电话
	private String bkxz;// 布控性质
	private Date bkkssj;// 布控开始时间
	private Date bkjssj;// 布控结束时间
	private String time;
	private Date lrsj;// 录入时间
	private String bkqy;// 布控区域
	private String bkqy_name;
	private String tpzj;// 车辆图片
	private String sfyjts;//是否预警推送 1，推送2，不推送
    private String sfyjts_name;
    private String bkjl;//布控距离
	
    
	public String getBkjl() {
		return bkjl;
	}
	public void setBkjl(String bkjl) {
		this.bkjl = bkjl;
	}
	public String getSfyjts() {
		return sfyjts;
	}
	public void setSfyjts(String sfyjts) {
		this.sfyjts = sfyjts;
	}
	public String getSfyjts_name() {
		if(sfyjts!=null){
			return "1".equals(sfyjts)?"推送":"不推送";
		}
		return sfyjts_name;
	}
	public void setSfyjts_name(String sfyjts_name) {
		this.sfyjts_name = sfyjts_name;
	}
	
	
	public String getBkqy_name() {
		return bkqy_name;
	}
	public void setBkqy_name(String bkqy_name) {
		this.bkqy_name = bkqy_name;
	}
	public String getBkdw_name() {
		if(bkdw!=null){
			bkdw_name=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT_PK, bkdw);
		}
		return bkdw_name;
	}
	public void setBkdw_name(String bkdw_name) {
		this.bkdw_name = bkdw_name;
	}
	public String getBklx_name() {
		if(bklx!=null){
			bklx_name="1".equals(bklx)?"启用":"不启用";
		}
		return bklx_name;
	}
	public void setBklx_name(String bklx_name) {
		this.bklx_name = bklx_name;
	}
	public String getClpp_name() {
		if(clpp!=null){
//			clpp_name=SysTempStoreUtils.getClpp(clpp);
			clpp_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CLPP,clpp);
		}
		return clpp_name;
	}
	public void setClpp_name(String clpp_name) {
		this.clpp_name = clpp_name;
	}
	public String getTime() {
		if(bkkssj!=null && bkjssj!=null){
			SimpleDateFormat  simp=new SimpleDateFormat("yyyy-MM-dd");
			this.time = simp.format(bkkssj)+"~"+simp.format(bkjssj);
			}
			return time;

	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getPk() {
		return pk;
	}
	public void setPk(Integer pk) {
		this.pk = pk;
	}
	public String getHphm() {
		return hphm;
	}
	public void setHphm(String hphm) {
		this.hphm = hphm;
	}
	public String getHpzl() {
		return hpzl;
	}
	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}
	public String getHpzl_name() {
		if(hpzl!=null){
//			hpzl_name=SysTempStoreUtils.getHpzl(hpzl);
			hpzl_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_HPZL, hpzl);
		}
		return hpzl_name;
	}
	public void setHpzl_name(String hpzl_name) {
		this.hpzl_name = hpzl_name;
	}
	public String getCllx() {
		return cllx;
	}
	public void setCllx(String cllx) {
		this.cllx = cllx;
	}
	public String getCllx_name() {
		if(cllx!=null){
//			cllx_name=SysTempStoreUtils.getCllx(cllx);
			cllx_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CLLX,cllx);
		}
		return cllx_name;
	}
	public void setCllx_name(String cllx_name) {
		this.cllx_name = cllx_name;
	}
	public String getCsys() {
		return csys;
	}
	public void setCsys(String csys) {
		this.csys = csys;
	}
	public String getCsys_name() {
		if(csys!=null){
//			csys_name=SysTempStoreUtils.getCsys(csys);
			csys_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CSYS, csys);
		}
		return csys_name;
	}
	public void setCsys_name(String csys_name) {
		this.csys_name = csys_name;
	}
	public String getClpp() {
		return clpp;
	}
	public void setClpp(String clpp) {
		this.clpp = clpp;
	}
	public String getBklx() {
		return bklx;
	}
	public void setBklx(String bklx) {
		this.bklx = bklx;
	}
	public String getLrr() {
		return lrr;
	}
	public void setLrr(String lrr) {
		this.lrr = lrr;
	}
	public String getBkdw() {
	
		return bkdw;
	}
	public void setBkdw(String bkdw) {
		this.bkdw = bkdw;
	}
	public String getBkyy() {
		return bkyy;
	}
	public void setBkyy(String bkyy) {
		this.bkyy = bkyy;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getBkxz() {
		return bkxz;
	}
	public void setBkxz(String bkxz) {
		this.bkxz = bkxz;
	}
	public Date getBkkssj() {
		return bkkssj;
	}
	public void setBkkssj(Date bkkssj) {
		this.bkkssj = bkkssj;
	}
	public Date getBkjssj() {
		return bkjssj;
	}
	public void setBkjssj(Date bkjssj) {
		this.bkjssj = bkjssj;
	}
	public Date getLrsj() {
		return lrsj;
	}
	public void setLrsj(Date lrsj) {
		this.lrsj = lrsj;
	}
	public String getBkqy() {
		return bkqy;
	}
	public void setBkqy(String bkqy) {
		this.bkqy = bkqy;
	}
	public String getTpzj() {
		return tpzj;
	}
	public void setTpzj(String tpzj) {
		this.tpzj = tpzj;
	}
    
	
}
