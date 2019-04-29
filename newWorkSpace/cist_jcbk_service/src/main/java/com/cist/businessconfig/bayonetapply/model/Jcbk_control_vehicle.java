package com.cist.businessconfig.bayonetapply.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Jcbk_control_vehicle implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -263553585778245346L;
	private String pk;//主键
	private String hphm;//号牌号码
	private String hpzl;//号牌种类（参考SYS_FRM_CODE表FCT_CODE=C001）
	private String cllx;//车辆类型（参考SYS_FRM_CODE表FCT_CODE=C002）
	private String csys;//车身颜色（参考SYS_FRM_CODE表FCT_CODE=C003）
	private String clpp;//车辆品牌（参考SYS_FRM_CODE表FCT_CODE=C110）
	private String bklx;//布控类型（参考SYS_FRM_CODE表FCT_CODE=BKLX）
	private String sfqztsxx;//强制推送预警信息 （0-否 1-是）
	private String lrr;//布控人
	private String bkdw;//布控单位
	private String bkyy;//布控原因
	private String lxdh;//联系电话
	private String sjly;//数据来源
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date bkkssj;//布控开始时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date bkjssj;//布控结束时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date lrsj;//录入时间
	private String xyctp1;//嫌疑车图片地址1
	private String xyctp2;//嫌疑车图片地址2
	private String xyctp3;//嫌疑车图片地址2
	private String fjtp1;//附件地址1
	private String fjtp2;//附件地址2
	private String fjtp3;//附件地址3
	private String bkzt;//车辆状态（1-审核通过 2-待审核 0-审核不通过 3-撤控）
	private String shr;//审核人
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private String shsj;//审核时间
	private String shbtgyy;//审核不通过原因
	private String ckr;//撤控人
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date cksj;//撤控时间
	private String ckyy;//撤控原因
	
	private String lrr_name;//录入人名字
	private String bkdw_name;//布控单位名称
	private String sfqztsxx_name;//强制推送预警信息名称
	private String bkzt_name;//车辆状态名称
	private String hpzl_name;//号牌种类名称
	private String cllx_name;//车辆类型名称
	private String csys_name;//车身颜色名称
	private String clpp_name;//车辆品牌名称
	private String bklx_name;//布控类型名称
	private String bksx;//布控时限
	public String getPk() {
		return pk;
	}
	public void setPk(String pk) {
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
	public String getCllx() {
		return cllx;
	}
	public void setCllx(String cllx) {
		this.cllx = cllx;
	}
	public String getCsys() {
		return csys;
	}
	public void setCsys(String csys) {
		this.csys = csys;
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
	public String getSfqztsxx() {
		return sfqztsxx;
	}
	public void setSfqztsxx(String sfqztsxx) {
		this.sfqztsxx = sfqztsxx;
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
	public String getSjly() {
		return sjly;
	}
	public void setSjly(String sjly) {
		this.sjly = sjly;
	}
	public Date getBkksj() {
		return bkkssj;
	}
	public void setBkksj(Date bkkssj) {
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
	public String getXyctp1() {
		return xyctp1;
	}
	public void setXyctp1(String xyctp1) {
		this.xyctp1 = xyctp1;
	}
	public String getXyctp2() {
		return xyctp2;
	}
	public void setXyctp2(String xyctp2) {
		this.xyctp2 = xyctp2;
	}
	public String getXyctp3() {
		return xyctp3;
	}
	public void setXyctp3(String xyctp3) {
		this.xyctp3 = xyctp3;
	}
	public String getFjtp1() {
		return fjtp1;
	}
	public void setFjtp1(String fjtp1) {
		this.fjtp1 = fjtp1;
	}
	public String getFjtp2() {
		return fjtp2;
	}
	public void setFjtp2(String fjtp2) {
		this.fjtp2 = fjtp2;
	}
	public String getFjtp3() {
		return fjtp3;
	}
	public void setFjtp3(String fjtp3) {
		this.fjtp3 = fjtp3;
	}
	public String getBkzt() {
		return bkzt;
	}
	public void setBkzt(String bkzt) {
		this.bkzt = bkzt;
	}
	public String getSfqztsxx_name() {//强制推送预警信息 （0-否 1-是）
		if("0".equals(sfqztsxx)){
			return "否";
		}else{
			return "是";
		}
	}
	public void setSfqztsxx_name(String sfqztsxx_name) {
		this.sfqztsxx_name = sfqztsxx_name;
	}
	public String getBkzt_name() {//车辆状态（1-审核通过 2-待审核 0-审核不通过 3-撤控）
		if("0".equals(bkzt)){
			return "审核不通过";
		}else if("1".equals(bkzt)){
			return "审核通过";
		}else if("2".equals(bkzt)){
			return "待审核";
		}else{
			return "撤控";
		}
		
	}
	public void setBkzt_name(String bkzt_name) {
		this.bkzt_name = bkzt_name;
	}
	public Date getBkkssj() {
		return bkkssj;
	}
	public void setBkkssj(Date bkkssj) {
		this.bkkssj = bkkssj;
	}
	public String getHpzl_name() {
		return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_HPZL, hpzl);
	}
	public void setHpzl_name(String hpzl_name) {
		this.hpzl_name = hpzl_name;
	}
	public String getCllx_name() {
		return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CLLX, cllx);
	}
	public void setCllx_name(String cllx_name) {
		this.cllx_name = cllx_name;
	}
	public String getCsys_name() {
		return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CSYS, csys);
	}
	public void setCsys_name(String csys_name) {
		this.csys_name = csys_name;
	}
	public String getClpp_name() {
		return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CLPP, clpp);
	}
	public void setClpp_name(String clpp_name) {
		this.clpp_name = clpp_name;
	}
	public String getBklx_name() {
		return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_BKLX, bklx);
	}
	public void setBklx_name(String bklx_name) {
		this.bklx_name = bklx_name;
	}
	public String getLrr_name() {
		return lrr_name;
	}
	public void setLrr_name(String lrr_name) {
		this.lrr_name = lrr_name;
	}
	public String getBkdw_name() {
		return bkdw_name;
	}
	public void setBkdw_name(String bkdw_name) {
		this.bkdw_name = bkdw_name;
	}
	public String getBksx() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(bkkssj)+"~"+format.format(bkjssj);
	}
	public void setBksx(String bksx) {
		this.bksx = bksx;
	}
	public String getShr() {
		return shr;
	}
	public void setShr(String shr) {
		this.shr = shr;
	}
	public String getShsj() {
		return shsj;
	}
	public void setShsj(String shsj) {
		this.shsj = shsj;
	}
	public String getShbtgyy() {
		return shbtgyy;
	}
	public void setShbtgyy(String shbtgyy) {
		this.shbtgyy = shbtgyy;
	}
	public String getCkr() {
		return ckr;
	}
	public void setCkr(String ckr) {
		this.ckr = ckr;
	}
	public Date getCksj() {
		return cksj;
	}
	public void setCksj(Date cksj) {
		this.cksj = cksj;
	}
	public String getCkyy() {
		return ckyy;
	}
	public void setCkyy(String ckyy) {
		this.ckyy = ckyy;
	}
	
	
}
