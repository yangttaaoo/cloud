package com.sbzc.model;

import java.math.BigDecimal;

public class ZdclCompanyInfo {
    private BigDecimal pk;

    private String gsmc;

    private String xydm;

    private String zzbh;

    private String lxdh;

    private String fzr;

    private String fzrdh;

    private String gsdz;

    private String glbm;

    private String xzqh;

    public BigDecimal getPk() {
        return pk;
    }

    public void setPk(BigDecimal pk) {
        this.pk = pk;
    }

    public String getGsmc() {
        return gsmc;
    }

    public void setGsmc(String gsmc) {
        this.gsmc = gsmc == null ? null : gsmc.trim();
    }

    public String getXydm() {
        return xydm;
    }

    public void setXydm(String xydm) {
        this.xydm = xydm == null ? null : xydm.trim();
    }

    public String getZzbh() {
        return zzbh;
    }

    public void setZzbh(String zzbh) {
        this.zzbh = zzbh == null ? null : zzbh.trim();
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh == null ? null : lxdh.trim();
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr == null ? null : fzr.trim();
    }

    public String getFzrdh() {
        return fzrdh;
    }

    public void setFzrdh(String fzrdh) {
        this.fzrdh = fzrdh == null ? null : fzrdh.trim();
    }

    public String getGsdz() {
        return gsdz;
    }

    public void setGsdz(String gsdz) {
        this.gsdz = gsdz == null ? null : gsdz.trim();
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