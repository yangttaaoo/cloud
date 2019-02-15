package com.cist.specialTask.model;

public class JcsjPoliceResPerson {
    private Long id;//ID

    private String glbm;//管理部门代码

    private String rybh;//民警/辅警编号

    private String xm;//姓名

    private String sfzhm;//身份证号码

    private String xb;//性别

    private String ywgw;//业务岗位

    private String ryfl;//人员分类（1-民警 2-辅警）

    private String fjlx;//人员类型（当RYLX=2时有效）

    private String bzlx;//编制类型（当RYLX=1时有效）

    private String zj;//职级（当RYLX=1时有效）

    private String zw;//职务（当RYLX=1时有效）

    private String zt;//状态，0-停用 1-启用

    private String bgdh;//办公电话

    private String yddh;//移动电话

    private String dth;//电台号/对讲机号

    private String zhh;//组呼号

    private String vwh;//V网号

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGlbm() {
        return glbm;
    }

    public void setGlbm(String glbm) {
        this.glbm = glbm == null ? null : glbm.trim();
    }

    public String getRybh() {
        return rybh;
    }

    public void setRybh(String rybh) {
        this.rybh = rybh == null ? null : rybh.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getSfzhm() {
        return sfzhm;
    }

    public void setSfzhm(String sfzhm) {
        this.sfzhm = sfzhm == null ? null : sfzhm.trim();
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb == null ? null : xb.trim();
    }

    public String getYwgw() {
        return ywgw;
    }

    public void setYwgw(String ywgw) {
        this.ywgw = ywgw == null ? null : ywgw.trim();
    }

    public String getRyfl() {
        return ryfl;
    }

    public void setRyfl(String ryfl) {
        this.ryfl = ryfl == null ? null : ryfl.trim();
    }

    public String getFjlx() {
        return fjlx;
    }

    public void setFjlx(String fjlx) {
        this.fjlx = fjlx == null ? null : fjlx.trim();
    }

    public String getBzlx() {
        return bzlx;
    }

    public void setBzlx(String bzlx) {
        this.bzlx = bzlx == null ? null : bzlx.trim();
    }

    public String getZj() {
        return zj;
    }

    public void setZj(String zj) {
        this.zj = zj == null ? null : zj.trim();
    }

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw == null ? null : zw.trim();
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt == null ? null : zt.trim();
    }

    public String getBgdh() {
        return bgdh;
    }

    public void setBgdh(String bgdh) {
        this.bgdh = bgdh == null ? null : bgdh.trim();
    }

    public String getYddh() {
        return yddh;
    }

    public void setYddh(String yddh) {
        this.yddh = yddh == null ? null : yddh.trim();
    }

    public String getDth() {
        return dth;
    }

    public void setDth(String dth) {
        this.dth = dth == null ? null : dth.trim();
    }

    public String getZhh() {
        return zhh;
    }

    public void setZhh(String zhh) {
        this.zhh = zhh == null ? null : zhh.trim();
    }

    public String getVwh() {
        return vwh;
    }

    public void setVwh(String vwh) {
        this.vwh = vwh == null ? null : vwh.trim();
    }
}