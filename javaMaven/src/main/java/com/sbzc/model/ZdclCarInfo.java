package com.sbzc.model;

import java.math.BigDecimal;
import java.util.Date;

public class ZdclCarInfo {
    private BigDecimal pk;

    private String hphm;

    private String clfl;

    private String clpp;

    private String csys;

    private String cllx;

    private String fdjbh;

    private String clsbdm;

    private String hdzkrs;

    private String hdzzl;

    private Date njyxq;

    private BigDecimal ssgs;

    private BigDecimal jsr;

    private String glbm;

    private String xzqh;

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
}