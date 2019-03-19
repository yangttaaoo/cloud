package com.cist.carParkPath.model;

import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

public class JCBK_CAR_STOP_RECO {
	private String unid;// 过车记录唯一 ID
	private String hphm;// 车牌号码
	private String hpzl;// 号牌种类(参考SYS_FRM_CODE表 FCT_CODE=C001)
	private String hpys;// 车牌颜色 (参考SYS_FRM_CODE表 FCT_CODE=C007)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date jgsj;// 通过时间
	private String tccbh;// 停车场编号
	private String tccmc;// 停车场名称
	private String crkbh;// 出入口编号
	private String crkmc;// 出入口名称
	private String cdbh;// 车道编号
	private String cdmc;// 车道名称
	private String cllx;// 车辆类型 (参考SYS_FRM_CODE表 FCT_CODE=C002)
	private String gcfx;// 过车方向
	private String bwbh;// 泊位编号
	private char TPSL;// 图片数量
	private String cptplj;// 车牌图片路径
	private String tplj1;// 图片路径1
	private String tplj2;// 图片路径2
	private String tplj3;// 图片路径3

	
	private String hpzl_name;//号牌种类名称
	private String hpys_name;//号牌颜色名称
	private String cllx_name;//车辆类型名称
	public String getUnid() {
		return unid;
	}

	public void setUnid(String unid) {
		this.unid = unid;
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

	public String getHpys() {
		return hpys;
	}

	public void setHpys(String hpys) {
		this.hpys = hpys;
	}

	public Date getJgsj() {
		return jgsj;
	}

	public void setJgsj(Date jgsj) {
		this.jgsj = jgsj;
	}

	public String getTccbh() {
		return tccbh;
	}

	public void setTccbh(String tccbh) {
		this.tccbh = tccbh;
	}

	public String getTccmc() {
		return tccmc;
	}

	public void setTccmc(String tccmc) {
		this.tccmc = tccmc;
	}

	public String getCrkbh() {
		return crkbh;
	}

	public void setCrkbh(String crkbh) {
		this.crkbh = crkbh;
	}

	public String getCrkmc() {
		return crkmc;
	}

	public void setCrkmc(String crkmc) {
		this.crkmc = crkmc;
	}

	public String getCdbh() {
		return cdbh;
	}

	public void setCdbh(String cdbh) {
		this.cdbh = cdbh;
	}

	public String getCdmc() {
		return cdmc;
	}

	public void setCdmc(String cdmc) {
		this.cdmc = cdmc;
	}

	public String getCllx() {
		return cllx;
	}

	public void setCllx(String cllx) {
		this.cllx = cllx;
	}

	public String getGcfx() {
		return gcfx;
	}

	public void setGcfx(String gcfx) {
		this.gcfx = gcfx;
	}

	public String getBwbh() {
		return bwbh;
	}

	public void setBwbh(String bwbh) {
		this.bwbh = bwbh;
	}

	public char getTPSL() {
		return TPSL;
	}

	public void setTPSL(char tPSL) {
		TPSL = tPSL;
	}

	public String getCptplj() {
		return cptplj;
	}

	public void setCptplj(String cptplj) {
		this.cptplj = cptplj;
	}

	public String getTplj1() {
		return tplj1;
	}

	public void setTplj1(String tplj1) {
		this.tplj1 = tplj1;
	}

	public String getTplj2() {
		return tplj2;
	}

	public void setTplj2(String tplj2) {
		this.tplj2 = tplj2;
	}

	public String getTplj3() {
		return tplj3;
	}

	public void setTplj3(String tplj3) {
		this.tplj3 = tplj3;
	}

	public String getHpzl_name() {
		return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_HPZL, hpzl);
	}

	public void setHpzl_name(String hpzl_name) {
		this.hpzl_name = hpzl_name;
	}

	public String getHpys_name() {
		return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_HPYS, hpys);
	}

	public void setHpys_name(String hpys_name) {
		this.hpys_name = hpys_name;
	}
	public String getCllx_name() {
		return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CLLX, cllx);
	}
	public void setCllx_name(String cllx_name) {
		this.cllx_name = cllx_name;
	}
}
