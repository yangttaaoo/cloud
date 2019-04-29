package com.cist.carInfo.model;

import java.math.BigDecimal;
import java.util.Date;

public class ZdclDriversInfo {
    private BigDecimal pk;//ID

    private String xm;//姓名

    private String jszbh;//驾驶证号

    private Date jszyxqz;//驾驶证有效期止

    private String lxdh;//联系电话

    private String jzdz;//居住地址

    private BigDecimal ssgs;//所属公司ID

    private String glbm;//部门代码

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