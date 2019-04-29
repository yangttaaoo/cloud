package com.cist.earlyewarningpost.model;

import java.math.BigDecimal;
/***
 * 车辆布控卡口表
 * @author yt
 *
 */
public class JcbkControlBayonet {
    private Long pk;//主键

    private String kkbh;//卡口编号

    private String kkmc;//卡口名称

    private String dlmc;//道路名称

    private String fxlx;//方向类型 1-上行 2-下行

    private String sbfx;//设备方向

    private String xsfx;//行驶方向

    private BigDecimal jd;//经度

    private BigDecimal wd;//纬度

    private String enable;//是否启用（1-启用 0-禁用）

    private String ms;//描述

    private String glbm;//所属部门
    
//	设备国标序列号
	private String device_gb_serial;
//	设备国标编码
	private String device_gb_code;
//	设备国标通道号
	private String device_gb_channel;

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

	public String getDevice_gb_serial() {
		return device_gb_serial;
	}

	public void setDevice_gb_serial(String device_gb_serial) {
		this.device_gb_serial = device_gb_serial;
	}

	public String getDevice_gb_code() {
		return device_gb_code;
	}

	public void setDevice_gb_code(String device_gb_code) {
		this.device_gb_code = device_gb_code;
	}

	public String getDevice_gb_channel() {
		return device_gb_channel;
	}

	public void setDevice_gb_channel(String device_gb_channel) {
		this.device_gb_channel = device_gb_channel;
	}
}