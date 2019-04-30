package com.sbzc.model;

import java.math.BigDecimal;
import java.util.Date;

public class ZdclDriversInfo {
    private BigDecimal pk;

    private String xm;

    private String jszbh;

    private Date jszyxqz;

    private String lxdh;

    private String jzdz;

    private BigDecimal ssgs;

    private String glbm;

    public BigDecimal getPk() {
        return pk;
    }

    public void setPk(BigDecimal pk) {
        this.pk = pk;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getJszbh() {
        return jszbh;
    }

    public void setJszbh(String jszbh) {
        this.jszbh = jszbh == null ? null : jszbh.trim();
    }

    public Date getJszyxqz() {
        return jszyxqz;
    }

    public void setJszyxqz(Date jszyxqz) {
        this.jszyxqz = jszyxqz;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh == null ? null : lxdh.trim();
    }

    public String getJzdz() {
        return jzdz;
    }

    public void setJzdz(String jzdz) {
        this.jzdz = jzdz == null ? null : jzdz.trim();
    }

    public BigDecimal getSsgs() {
        return ssgs;
    }

    public void setSsgs(BigDecimal ssgs) {
        this.ssgs = ssgs;
    }

    public String getGlbm() {
        return glbm;
    }

    public void setGlbm(String glbm) {
        this.glbm = glbm == null ? null : glbm.trim();
    }
}