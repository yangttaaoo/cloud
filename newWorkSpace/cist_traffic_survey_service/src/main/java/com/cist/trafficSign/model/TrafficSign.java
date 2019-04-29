package com.cist.trafficSign.model;

import java.math.BigDecimal;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 5.34.交通标志信息(JCSJ_TRAFFIC_SIGNS)
 * 
 * @author 57150
 *
 */
public class TrafficSign {
	private long pk_id;// 标志ID
	private String bzmc;// 标志名称
	private String bzlx;// 标志类型，参考表（SYS_FRM_CODE=BZLX）
	private Integer bzsl;// 数量
	private String jyms;// 简要描述
	private char zxbj;// 注销标记（0：有效 、1：注销）
	private String xzqh;// 区(县)代码
	private String szwz;//设置位置 (add)
	private String jsdw;// 建设单位
	private String sgdw;// 施工单位
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date jssj;// 建设时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date syqxjzsj;// 使用期限截止时间
	private Integer syqxy;// 使用期限（年）
	private Integer syqxm;// 使用期限（月）
	private String zcfs;// 支撑方式，参考表（SYS_FRM_CODE=ZCFS）
	private String xz;// 形状，参考表（SYS_FRM_CODE=BZXZ）
	private Integer cd;// 长度
	private Integer kd;// 宽度
	private Integer bc;// 边长
	private Integer zj;// 直径
	private Integer mj;// 面积
	private String fx;// 方向名称，参考表（SYS_FRM_CODE=BZFX）
	private String bzlxtp;// 标志类型图id  附件路径(update)
	private String bzsjtp;// 标志实景图id   附件路径  (update)
	private BigDecimal jdzb;// 经度坐标
	private BigDecimal wdzb;// 纬度坐标
	private String gxtx;// 光学特性，参考表（SYS_FRM_CODE=GXTX）
	private String xswz;// 显示位置，参考表（SYS_FRM_CODE=XSWZ）
	private String bmxxfs;// 版面显示方式，参考表（SYS_FRM_CODE=BMXS）
	private String nylx;// 能源类型，参考表（SYS_FRM_CODE=LYLX）
	private String dldm;// 道路代码
	private String dllx;//道路类型，参考表（SYS_FRM_CODE=R007）
	private String lddm;// 路段代码\路口号\公里数
	private Character dlms;// 道路米数
	private String dllxmc;// 道路类型名称
	private long glbm;// 管理部门
	private long cjr;// 创建人id
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date cjsj;// 创建时间

	
	private String bzlx_name;
	private String glbm_name;
	
	
	
	public String getBzlx_name() {
		return SysTempStoreUtils.queryBaseDateName("BZLX", bzlx);
	}
	

	public void setBzlx_name(String bzlx_name) {
		this.bzlx_name = bzlx_name;
	}

	
	public String getGlbm_name() {
		return com.cist.frame.utils.SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT, Long.toString(glbm));
	}


	public void setGlbm_name(String glbm_name) {
		this.glbm_name = glbm_name;
	}


	public TrafficSign() {
	}

	public long getPk_id() {
		return pk_id;
	}

	public void setPk_id(long pk_id) {
		this.pk_id = pk_id;
	}

	public String getBzmc() {
		return bzmc;
	}

	public void setBzmc(String bzmc) {
		this.bzmc = bzmc;
	}

	public String getBzlx() {
		return bzlx;
	}

	public void setBzlx(String bzlx) {
		this.bzlx = bzlx;
	}

	public Integer get() {
		return bzsl;
	}

	public void setBzsl(Integer bzsl) {
		this.bzsl = bzsl;
	}

	public String getJyms() {
		return jyms;
	}

	public void setJyms(String jyms) {
		this.jyms = jyms;
	}

	public char getZxbj() {
		return zxbj;
	}

	public void setZxbj(char zxbj) {
		this.zxbj = zxbj;
	}



	public String getSzwz() {
		return szwz;
	}

	public void setSzwz(String szwz) {
		this.szwz = szwz;
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

	public Integer getSyqxy() {
		return syqxy;
	}

	public void setSyqxy(Integer syqxy) {
		this.syqxy = syqxy;
	}

	public Integer getSyqxm() {
		return syqxm;
	}

	public void setSyqxm(Integer syqxm) {
		this.syqxm = syqxm;
	}

	public String getZcfs() {
		return zcfs;
	}

	public void setZcfs(String zcfs) {
		this.zcfs = zcfs;
	}

	public String getXz() {
		return xz;
	}

	public void setXz(String xz) {
		this.xz = xz;
	}

	public Integer getCd() {
		return cd;
	}

	public void setCd(Integer cd) {
		this.cd = cd;
	}

	public Integer getKd() {
		return kd;
	}

	public void setKd(Integer kd) {
		this.kd = kd;
	}

	public Integer getBc() {
		return bc;
	}

	public void setBc(Integer bc) {
		this.bc = bc;
	}

	public Integer getZj() {
		return zj;
	}

	public void setZj(Integer zj) {
		this.zj = zj;
	}

	public String getFx() {
		return fx;
	}

	public void setFx(String fx) {
		this.fx = fx;
	}

	
	public String getBzlxtp() {
		return bzlxtp;
	}

	public void setBzlxtp(String bzlxtp) {
		this.bzlxtp = bzlxtp;
	}

	public String getBzsjtp() {
		return bzsjtp;
	}

	public void setBzsjtp(String bzsjtp) {
		this.bzsjtp = bzsjtp;
	}

	public BigDecimal getJdzb() {
		return jdzb;
	}

	public void setJdzb(BigDecimal jdzb) {
		this.jdzb = jdzb;
	}

	public BigDecimal getWdzb() {
		return wdzb;
	}

	public void setWdzb(BigDecimal wdzb) {
		this.wdzb = wdzb;
	}

	public String getGxtx() {
		return gxtx;
	}

	public void setGxtx(String gxtx) {
		this.gxtx = gxtx;
	}

	public String getXswz() {
		return xswz;
	}

	public void setXswz(String xswz) {
		this.xswz = xswz;
	}

	public String getBmxxfs() {
		return bmxxfs;
	}

	public void setBmxxfs(String bmxxfs) {
		this.bmxxfs = bmxxfs;
	}

	public String getNylx() {
		return nylx;
	}

	public void setNylx(String nylx) {
		this.nylx = nylx;
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

	public Character getDlms() {
		return dlms;
	}

	public void setDlms(Character dlms) {
		this.dlms = dlms;
	}

	public String getDllxmc() {
		return dllxmc;
	}

	public void setDllxmc(String dllxmc) {
		this.dllxmc = dllxmc;
	}

	public long getGlbm() {
		return glbm;
	}

	public void setGlbm(long glbm) {
		this.glbm = glbm;
	}

	public long getCjr() {
		return cjr;
	}

	public void setCjr(long cjr) {
		this.cjr = cjr;
	}

	public Date getCjsj() {
		return cjsj;
	}

	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
	}

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public Integer getMj() {
		return mj;
	}

	public void setMj(Integer mj) {
		this.mj = mj;
	}

	
}
