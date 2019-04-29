package com.cist.earlyewarningpost.model;

//布控卡口拦截单位
public class JcbkBayonetUnits {
    private Long pk;//主键

    private String kkbh;//卡口编号

    private String bmdm;//部门代码

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

    public String getBmdm() {
        return bmdm;
    }

    public void setBmdm(String bmdm) {
        this.bmdm = bmdm == null ? null : bmdm.trim();
    }
}