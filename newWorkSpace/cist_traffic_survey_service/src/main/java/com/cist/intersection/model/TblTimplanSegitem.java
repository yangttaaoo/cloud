package com.cist.intersection.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TblTimplanSegitem {
    private Long pk;//PK

    private Integer xkid;//路口信控方案ID（参考TBL_SEGITEM_SIGNAL表中PK字段）

    private String xh;//序号
    
    @JsonFormat(pattern="HH:mm",timezone = "GMT+8")
    private Date kssj;//开始时间
    
    @JsonFormat(pattern="HH:mm",timezone = "GMT+8")
    private Date jssj;//结束时间

    private String fah;//方案号

    private String fabz;//方案备注

    private String xx;//相序

    private String zq;//周期

    private String xwc;//相位差

    private String xwmc;//相位名称,唯一主键
    
    private List<TblTimplanPhase> xwxx;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }


    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh == null ? null : xh.trim();
    }


    public String getFah() {
        return fah;
    }

    public void setFah(String fah) {
        this.fah = fah == null ? null : fah.trim();
    }

    public String getFabz() {
        return fabz;
    }

    public void setFabz(String fabz) {
        this.fabz = fabz == null ? null : fabz.trim();
    }

    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx == null ? null : xx.trim();
    }

    public String getZq() {
        return zq;
    }

    public void setZq(String zq) {
        this.zq = zq == null ? null : zq.trim();
    }

    public String getXwc() {
        return xwc;
    }

    public void setXwc(String xwc) {
        this.xwc = xwc == null ? null : xwc.trim();
    }

    public String getXwmc() {
        return xwmc;
    }

    public void setXwmc(String xwmc) {
        this.xwmc = xwmc == null ? null : xwmc.trim();
    }

	public List<TblTimplanPhase> getXwxx() {
		return xwxx;
	}

	public void setXwxx(List<TblTimplanPhase> xwxx) {
		this.xwxx = xwxx;
	}

	public Integer getXkid() {
		return xkid;
	}

	public void setXkid(Integer xkid) {
		this.xkid = xkid;
	}

	public Date getKssj() {
		return kssj;
	}

	public void setKssj(Date kssj) {
		this.kssj = kssj;
	}

	public Date getJssj() {
		return jssj;
	}

	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}
}