package com.cist.intersection.model;

import java.util.List;
import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class TblSegitemSignal {
    private Long pk;//ID

    private Long lkid;//路口ID（参考C_ROAD_SEGITEM表中PK字段）

    private String famc;//方案名称

    private String fasd;//方案时段

    private String zzsj;//制作时间

    private Long xksb;//信控设备（参考JCSJ_DEVICE表中PK_ID字段）

    private String falx;//方案类型（0-无步序 1-有步序）

    private String xwxxt;//相位相序图
    
    private String device_name;//信控设备名称
    
    private List<TblSigcaseSegitem> xtlk;//信控方案下的协调路口
    
    private String xtlkname;//协调路口名称
    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public Long getLkid() {
        return lkid;
    }

    public void setLkid(Long lkid) {
        this.lkid = lkid;
    }

    public String getFamc() {
        return famc;
    }

    public void setFamc(String famc) {
        this.famc = famc == null ? null : famc.trim();
    }

    public String getFasd() {
        return fasd;
    }

    public void setFasd(String fasd) {
        this.fasd = fasd == null ? null : fasd.trim();
    }

    public String getZzsj() {
        return zzsj;
    }

    public void setZzsj(String zzsj) {
        this.zzsj = zzsj == null ? null : zzsj.trim();
    }

    public Long getXksb() {
        return xksb;
    }

    public void setXksb(Long xksb) {
        this.xksb = xksb;
    }

    public String getFalx() {
        return falx;
    }

    public void setFalx(String falx) {
        this.falx = falx == null ? null : falx.trim();
    }

    public String getXwxxt() {
        return xwxxt;
    }

    public void setXwxxt(String xwxxt) {
        this.xwxxt = xwxxt == null ? null : xwxxt.trim();
    }

	public String getDevice_name() {
		if(xksb!=null&&!("".equals(xksb))){
			device_name=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_SBBD, xksb.toString());
		}
		 return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

	public List<TblSigcaseSegitem> getXtlk() {
		return xtlk;
	}

	public void setXtlk(List<TblSigcaseSegitem> xtlk) {
		this.xtlk = xtlk;
	}

	public String getXtlkname() {
		xtlkname="";
		if(xtlk.size()>0)
		{
			for (int i=0;i<xtlk.size();i++) {
				xtlkname=xtlkname+xtlk.get(i).getXtlkname()+",";
			}
			xtlkname=xtlkname.substring(0, xtlkname.length()-1);
		}
		else
		{
			xtlkname="无";
		}
		return xtlkname;
	}

	public void setXtlkname(String xtlkname) {
		this.xtlkname = xtlkname;
	}
}