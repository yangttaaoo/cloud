package com.cist.serviceconfig.imgnameconfig.model;

import java.math.BigDecimal;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

public class TblImgNameInfo {
    private BigDecimal mbpk;

    private String mbmc;

    @SuppressWarnings("unused")
	private String sblx;

    private String fgf;

    private String sjgs;

    private String xzx;

    private String kxx;

    private String bz;
    
    private String sblxcode;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date gxsj;

    private String cjr;

    private String cjbm;

    private String cjrCode;
    
    public BigDecimal getMbpk() {
        return mbpk;
    }

    public void setMbpk(BigDecimal mbpk) {
        this.mbpk = mbpk;
    }

    public String getMbmc() {
        return mbmc;
    }

    public void setMbmc(String mbmc) {
        this.mbmc = mbmc == null ? null : mbmc.trim();
    }

/*    public String getSblx() {
    	if(null!=sblx)
    	{
    		sblxcode=sblx;
    		return SysTempStoreUtils.getsblx(sblx);
    	}
        return sblx;
    }*/

    public void setSblx(String sblx) {
        this.sblx = sblx == null ? null : sblx.trim();
    }

    public String getFgf() {
        return fgf;
    }

    public void setFgf(String fgf) {
        this.fgf = fgf == null ? null : fgf.trim();
    }

    public String getSjgs() {
        return sjgs;
    }

    public void setSjgs(String sjgs) {
        this.sjgs = sjgs == null ? null : sjgs.trim();
    }

    public String getXzx() {
        return xzx;
    }

    public void setXzx(String xzx) {
        this.xzx = xzx == null ? null : xzx.trim();
    }

    public String getKxx() {
        return kxx;
    }

    public void setKxx(String kxx) {
        this.kxx = kxx == null ? null : kxx.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public Date getGxsj() {
        return gxsj;
    }

    public void setGxsj(Date gxsj) {
        this.gxsj = gxsj;
    }

    public String getCjr() {
        return cjr;
    }

    public void setCjr(String cjr) {
        this.cjr = cjr == null ? null : cjr.trim();
    }

    public String getCjbm() {
    	
    	if(cjbm!=null&&cjbm!="")
    	{
    		return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT,cjbm);
    	}
        return "";
    }

    public void setCjbm(String cjbm) {
        this.cjbm = cjbm == null ? null : cjbm.trim();
    }

    public String getCjrCode() {
        return cjrCode;
    }

    public void setCjrCode(String cjrCode) {
        this.cjrCode = cjrCode == null ? null : cjrCode.trim();
    }

	public String getSblxcode() {
		return sblxcode;
	}

	public void setSblxcode(String sblxcode) {
		this.sblxcode = sblxcode;
	}

}