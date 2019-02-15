package com.sbzc.model;

import java.math.BigDecimal;

public class JcbkControlBayonet {
    private Long pk;

    private String kkbh;

    private String kkmc;

    private String dlmc;

    private String fxlx;

    private String sbfx;

    private String xsfx;

    private BigDecimal jd;

    private BigDecimal wd;

    private String enable;

    private String ms;

    private String glbm;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getKkbh() {
        return kkbh;
    }

    public void setKkbh(String kkbh) {
        this.kkbh = kkbh == null ? null : kkbh.trim();
    }

    public String getKkmc() {
        return kkmc;
    }

    public void setKkmc(String kkmc) {
        this.kkmc = kkmc == null ? null : kkmc.trim();
    }

    public String getDlmc() {
        return dlmc;
    }

    public void setDlmc(String dlmc) {
        this.dlmc = dlmc == null ? null : dlmc.trim();
    }

    public String getFxlx() {
        return fxlx;
    }

    public void setFxlx(String fxlx) {
        this.fxlx = fxlx == null ? null : fxlx.trim();
    }

    public String getSbfx() {
        return sbfx;
    }

    public void setSbfx(String sbfx) {
        this.sbfx = sbfx == null ? null : sbfx.trim();
    }

    public String getXsfx() {
        return xsfx;
    }

    public void setXsfx(String xsfx) {
        this.xsfx = xsfx == null ? null : xsfx.trim();
    }

    public BigDecimal getJd() {
        return jd;
    }

    public void setJd(BigDecimal jd) {
        this.jd = jd;
    }

    public BigDecimal getWd() {
        return wd;
    }

    public void setWd(BigDecimal wd) {
        this.wd = wd;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable == null ? null : enable.trim();
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms == null ? null : ms.trim();
    }

    public String getGlbm() {
        return glbm;
    }

    public void setGlbm(String glbm) {
        this.glbm = glbm == null ? null : glbm.trim();
    }
}