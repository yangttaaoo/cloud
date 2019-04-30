package com.sbzc.model;

import java.math.BigDecimal;
import java.util.Date;

public class ALARMVEHICLE {
    //主键
    private BigDecimal pk;

    //预警序号
    private String yjxh;

    //号牌号码
    private String hphm;

    //号牌种类
    private String hpzl;

    //过车时间
    private Date gcsj;

    //预警时间
    private Date yjsj;

    //预警类型（参考SYS_FRM_CODE表FCT_CODE=YJLX）
    private String yjlx;

    //车辆分类（参考SYS_FRM_CODE表 FCT_CODE=CLFL）
    private String clfl;

    //车道编号
    private String cdbh;

    //车身颜色
    private String csys;

    //车辆类型(参考SYS_FRM_CODE表 FCT_CODE=C002)
    private String cllx;

    //所属道路
    private String ssdl;

    //路口号
    private String lddm;

    //地点米数
    private String ldms;

    //道路类型
    private String dllx;

    //设备方向
    private String sbfx;

    //设备编码
    private String sbbh;

    //图片数量
    private String tpsl;

    //车牌图片路径
    private String cptplj;

    //图片路径1
    private String tplj1;

    //图片路径2
    private String tplj2;

    //图片路径3
    private String tplj3;

    //预警地点
    private String yjdd;

    //行驶速度
    private Long xssd;

    //所属部门
    private String ssbm;

    //行驶区域
    private String xsqy;

    //所属公司ID
    private BigDecimal ssgs;

    //公司名称
    private String gsmc;

    //公司负责人
    private String gsfzr;

    //公司负责人联系电话
    private String gsfzrdh;

    //预警当前状态（0未受理、1已受理、2已调度、3已完成）
    private String eventCurrentStatus;

    /**
     * 主键
     * @return PK 主键
     */
    public BigDecimal getPk() {
        return pk;
    }

    /**
     * 主键
     * @param pk 主键
     */
    public void setPk(BigDecimal pk) {
        this.pk = pk;
    }

    /**
     * 预警序号
     * @return YJXH 预警序号
     */
    public String getYjxh() {
        return yjxh;
    }

    /**
     * 预警序号
     * @param yjxh 预警序号
     */
    public void setYjxh(String yjxh) {
        this.yjxh = yjxh == null ? null : yjxh.trim();
    }

    /**
     * 号牌号码
     * @return HPHM 号牌号码
     */
    public String getHphm() {
        return hphm;
    }

    /**
     * 号牌号码
     * @param hphm 号牌号码
     */
    public void setHphm(String hphm) {
        this.hphm = hphm == null ? null : hphm.trim();
    }

    /**
     * 号牌种类
     * @return HPZL 号牌种类
     */
    public String getHpzl() {
        return hpzl;
    }

    /**
     * 号牌种类
     * @param hpzl 号牌种类
     */
    public void setHpzl(String hpzl) {
        this.hpzl = hpzl == null ? null : hpzl.trim();
    }

    /**
     * 过车时间
     * @return GCSJ 过车时间
     */
    public Date getGcsj() {
        return gcsj;
    }

    /**
     * 过车时间
     * @param gcsj 过车时间
     */
    public void setGcsj(Date gcsj) {
        this.gcsj = gcsj;
    }

    /**
     * 预警时间
     * @return YJSJ 预警时间
     */
    public Date getYjsj() {
        return yjsj;
    }

    /**
     * 预警时间
     * @param yjsj 预警时间
     */
    public void setYjsj(Date yjsj) {
        this.yjsj = yjsj;
    }

    /**
     * 预警类型（参考SYS_FRM_CODE表FCT_CODE=YJLX）
     * @return YJLX 预警类型（参考SYS_FRM_CODE表FCT_CODE=YJLX）
     */
    public String getYjlx() {
        return yjlx;
    }

    /**
     * 预警类型（参考SYS_FRM_CODE表FCT_CODE=YJLX）
     * @param yjlx 预警类型（参考SYS_FRM_CODE表FCT_CODE=YJLX）
     */
    public void setYjlx(String yjlx) {
        this.yjlx = yjlx == null ? null : yjlx.trim();
    }

    /**
     * 车辆分类（参考SYS_FRM_CODE表 FCT_CODE=CLFL）
     * @return CLFL 车辆分类（参考SYS_FRM_CODE表 FCT_CODE=CLFL）
     */
    public String getClfl() {
        return clfl;
    }

    /**
     * 车辆分类（参考SYS_FRM_CODE表 FCT_CODE=CLFL）
     * @param clfl 车辆分类（参考SYS_FRM_CODE表 FCT_CODE=CLFL）
     */
    public void setClfl(String clfl) {
        this.clfl = clfl == null ? null : clfl.trim();
    }

    /**
     * 车道编号
     * @return CDBH 车道编号
     */
    public String getCdbh() {
        return cdbh;
    }

    /**
     * 车道编号
     * @param cdbh 车道编号
     */
    public void setCdbh(String cdbh) {
        this.cdbh = cdbh == null ? null : cdbh.trim();
    }

    /**
     * 车身颜色
     * @return CSYS 车身颜色
     */
    public String getCsys() {
        return csys;
    }

    /**
     * 车身颜色
     * @param csys 车身颜色
     */
    public void setCsys(String csys) {
        this.csys = csys == null ? null : csys.trim();
    }

    /**
     * 车辆类型(参考SYS_FRM_CODE表 FCT_CODE=C002)
     * @return CLLX 车辆类型(参考SYS_FRM_CODE表 FCT_CODE=C002)
     */
    public String getCllx() {
        return cllx;
    }

    /**
     * 车辆类型(参考SYS_FRM_CODE表 FCT_CODE=C002)
     * @param cllx 车辆类型(参考SYS_FRM_CODE表 FCT_CODE=C002)
     */
    public void setCllx(String cllx) {
        this.cllx = cllx == null ? null : cllx.trim();
    }

    /**
     * 所属道路
     * @return SSDL 所属道路
     */
    public String getSsdl() {
        return ssdl;
    }

    /**
     * 所属道路
     * @param ssdl 所属道路
     */
    public void setSsdl(String ssdl) {
        this.ssdl = ssdl == null ? null : ssdl.trim();
    }

    /**
     * 路口号
     * @return LDDM 路口号
     */
    public String getLddm() {
        return lddm;
    }

    /**
     * 路口号
     * @param lddm 路口号
     */
    public void setLddm(String lddm) {
        this.lddm = lddm == null ? null : lddm.trim();
    }

    /**
     * 地点米数
     * @return LDMS 地点米数
     */
    public String getLdms() {
        return ldms;
    }

    /**
     * 地点米数
     * @param ldms 地点米数
     */
    public void setLdms(String ldms) {
        this.ldms = ldms == null ? null : ldms.trim();
    }

    /**
     * 道路类型
     * @return DLLX 道路类型
     */
    public String getDllx() {
        return dllx;
    }

    /**
     * 道路类型
     * @param dllx 道路类型
     */
    public void setDllx(String dllx) {
        this.dllx = dllx == null ? null : dllx.trim();
    }

    /**
     * 设备方向
     * @return SBFX 设备方向
     */
    public String getSbfx() {
        return sbfx;
    }

    /**
     * 设备方向
     * @param sbfx 设备方向
     */
    public void setSbfx(String sbfx) {
        this.sbfx = sbfx == null ? null : sbfx.trim();
    }

    /**
     * 设备编码
     * @return SBBH 设备编码
     */
    public String getSbbh() {
        return sbbh;
    }

    /**
     * 设备编码
     * @param sbbh 设备编码
     */
    public void setSbbh(String sbbh) {
        this.sbbh = sbbh == null ? null : sbbh.trim();
    }

    /**
     * 图片数量
     * @return TPSL 图片数量
     */
    public String getTpsl() {
        return tpsl;
    }

    /**
     * 图片数量
     * @param tpsl 图片数量
     */
    public void setTpsl(String tpsl) {
        this.tpsl = tpsl == null ? null : tpsl.trim();
    }

    /**
     * 车牌图片路径
     * @return CPTPLJ 车牌图片路径
     */
    public String getCptplj() {
        return cptplj;
    }

    /**
     * 车牌图片路径
     * @param cptplj 车牌图片路径
     */
    public void setCptplj(String cptplj) {
        this.cptplj = cptplj == null ? null : cptplj.trim();
    }

    /**
     * 图片路径1
     * @return TPLJ1 图片路径1
     */
    public String getTplj1() {
        return tplj1;
    }

    /**
     * 图片路径1
     * @param tplj1 图片路径1
     */
    public void setTplj1(String tplj1) {
        this.tplj1 = tplj1 == null ? null : tplj1.trim();
    }

    /**
     * 图片路径2
     * @return TPLJ2 图片路径2
     */
    public String getTplj2() {
        return tplj2;
    }

    /**
     * 图片路径2
     * @param tplj2 图片路径2
     */
    public void setTplj2(String tplj2) {
        this.tplj2 = tplj2 == null ? null : tplj2.trim();
    }

    /**
     * 图片路径3
     * @return TPLJ3 图片路径3
     */
    public String getTplj3() {
        return tplj3;
    }

    /**
     * 图片路径3
     * @param tplj3 图片路径3
     */
    public void setTplj3(String tplj3) {
        this.tplj3 = tplj3 == null ? null : tplj3.trim();
    }

    /**
     * 预警地点
     * @return YJDD 预警地点
     */
    public String getYjdd() {
        return yjdd;
    }

    /**
     * 预警地点
     * @param yjdd 预警地点
     */
    public void setYjdd(String yjdd) {
        this.yjdd = yjdd == null ? null : yjdd.trim();
    }

    /**
     * 行驶速度
     * @return XSSD 行驶速度
     */
    public Long getXssd() {
        return xssd;
    }

    /**
     * 行驶速度
     * @param xssd 行驶速度
     */
    public void setXssd(Long xssd) {
        this.xssd = xssd;
    }

    /**
     * 所属部门
     * @return SSBM 所属部门
     */
    public String getSsbm() {
        return ssbm;
    }

    /**
     * 所属部门
     * @param ssbm 所属部门
     */
    public void setSsbm(String ssbm) {
        this.ssbm = ssbm == null ? null : ssbm.trim();
    }

    /**
     * 行驶区域
     * @return XSQY 行驶区域
     */
    public String getXsqy() {
        return xsqy;
    }

    /**
     * 行驶区域
     * @param xsqy 行驶区域
     */
    public void setXsqy(String xsqy) {
        this.xsqy = xsqy == null ? null : xsqy.trim();
    }

    /**
     * 所属公司ID
     * @return SSGS 所属公司ID
     */
    public BigDecimal getSsgs() {
        return ssgs;
    }

    /**
     * 所属公司ID
     * @param ssgs 所属公司ID
     */
    public void setSsgs(BigDecimal ssgs) {
        this.ssgs = ssgs;
    }

    /**
     * 公司名称
     * @return GSMC 公司名称
     */
    public String getGsmc() {
        return gsmc;
    }

    /**
     * 公司名称
     * @param gsmc 公司名称
     */
    public void setGsmc(String gsmc) {
        this.gsmc = gsmc == null ? null : gsmc.trim();
    }

    /**
     * 公司负责人
     * @return GSFZR 公司负责人
     */
    public String getGsfzr() {
        return gsfzr;
    }

    /**
     * 公司负责人
     * @param gsfzr 公司负责人
     */
    public void setGsfzr(String gsfzr) {
        this.gsfzr = gsfzr == null ? null : gsfzr.trim();
    }

    /**
     * 公司负责人联系电话
     * @return GSFZRDH 公司负责人联系电话
     */
    public String getGsfzrdh() {
        return gsfzrdh;
    }

    /**
     * 公司负责人联系电话
     * @param gsfzrdh 公司负责人联系电话
     */
    public void setGsfzrdh(String gsfzrdh) {
        this.gsfzrdh = gsfzrdh == null ? null : gsfzrdh.trim();
    }

    /**
     * 预警当前状态（0未受理、1已受理、2已调度、3已完成）
     * @return EVENT_CURRENT_STATUS 预警当前状态（0未受理、1已受理、2已调度、3已完成）
     */
    public String getEventCurrentStatus() {
        return eventCurrentStatus;
    }

    /**
     * 预警当前状态（0未受理、1已受理、2已调度、3已完成）
     * @param eventCurrentStatus 预警当前状态（0未受理、1已受理、2已调度、3已完成）
     */
    public void setEventCurrentStatus(String eventCurrentStatus) {
        this.eventCurrentStatus = eventCurrentStatus == null ? null : eventCurrentStatus.trim();
    }
}