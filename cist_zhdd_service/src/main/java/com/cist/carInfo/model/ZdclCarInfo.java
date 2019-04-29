package com.cist.carInfo.model;

import java.math.BigDecimal;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class ZdclCarInfo {
    private BigDecimal pk;//ID

    private String hphm;//号牌号码

    private String clfl;//车辆分类（参考SYS_FRM_CODE表 FCT_CODE=CLFL）

    private String clpp;//车辆品牌

    private String csys;//车身颜色

    private String cllx;//车辆类型（参考SYS_FRM_CODE表 FCT_CODE=C002）

    private String fdjbh;//发动机编号

    private String clsbdm;//车辆识别代码

    private String hdzkrs;//核定载客（单位：人）

    private String hdzzl;//核定载质量（单位：kg）

    private Date njyxq;//检验有效期止

    private BigDecimal ssgs;//所属公司ID

    private BigDecimal jsr;//驾驶人ID

    private String glbm;//部门代码

    private String xzqh;//行政区划代码
    
    private String glbmName;//部门名称
    
    private String clflName;//车辆分类名称（参考SYS_FRM_CODE表 FCT_CODE=CLFL）
    
    private String ssgsName;//所属公司名称

    public BigDecimal getPk() {
        return pk;
    }

    public void setPk(BigDecimal pk) {
        this.pk = pk;
    }

    public String getHphm() {
        return hphm;
    }

    public void setHphm(String hphm) {
        this.hphm = hphm == null ? null : hphm.trim();
    }

    public String getClfl() {
        return clfl;
    }

    public void setClfl(String clfl) {
        this.clfl = clfl == null ? null : clfl.trim();
    }

    public String getClpp() {
        return clpp;
    }

    public void setClpp(String clpp) {
        this.clpp = clpp == null ? null : clpp.trim();
    }

    public String getCsys() {
        return csys;
    }

    public void setCsys(String csys) {
        this.csys = csys == null ? null : csys.trim();
    }

    public String getCllx() {
        return cllx;
    }

    public void setCllx(String cllx) {
        this.cllx = cllx == null ? null : cllx.trim();
    }

    public String getFdjbh() {
        return fdjbh;
    }

    public void setFdjbh(String fdjbh) {
        this.fdjbh = fdjbh == null ? null : fdjbh.trim();
    }

    public String getClsbdm() {
        return clsbdm;
    }

    public void setClsbdm(String clsbdm) {
        this.clsbdm = clsbdm == null ? null : clsbdm.trim();
    }

    public String getHdzkrs() {
        return hdzkrs;
    }

    public void setHdzkrs(String hdzkrs) {
        this.hdzkrs = hdzkrs == null ? null : hdzkrs.trim();
    }

    public String getHdzzl() {
        return hdzzl;
    }

    public void setHdzzl(String hdzzl) {
        this.hdzzl = hdzzl == null ? null : hdzzl.trim();
    }

    public Date getNjyxq() {
        return njyxq;
    }

    public void setNjyxq(Date njyxq) {
        this.njyxq = njyxq;
    }

    public BigDecimal getSsgs() {
        return ssgs;
    }

    public void setSsgs(BigDecimal ssgs) {
        this.ssgs = ssgs;
    }

    public BigDecimal getJsr() {
        return jsr;
    }

    public void setJsr(BigDecimal jsr) {
        this.jsr = jsr;
    }

    public String getGlbm() {
        return glbm;
    }

    public void setGlbm(String glbm) {
        this.glbm = glbm == null ? null : glbm.trim();
    }

    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh == null ? null : xzqh.trim();
    }

	public String getGlbmName() {
		if(glbm !=null) {
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT, glbm);
		}
		return glbmName;
	}

	public void setGlbmName(String glbmName) {
		this.glbmName = glbmName;
	}

	public String getClflName() {
		if(clfl!=null) {
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CLFL,clfl);
		}
		return clflName;
	}

	public void setClflName(String clflName) {
		this.clflName = clflName;
	}

	public String getSsgsName() {
		return ssgsName;
	}

	public void setSsgsName(String ssgsName) {
		this.ssgsName = ssgsName;
	}
}