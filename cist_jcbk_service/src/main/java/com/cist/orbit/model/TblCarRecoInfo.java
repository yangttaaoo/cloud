package com.cist.orbit.model;

import java.math.BigDecimal;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.StringUtils;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

public class TblCarRecoInfo {
    private Long gcpk;//ID

    private String gcxh;//过车序号

    private String hpzl;//号牌种类(参考SYS_FRM_CODE表 FCT_CODE=C001)

    private String hphm;//号牌号码

    private String hpys;//号牌颜色

    private BigDecimal clsd;//速度

    private String cdbh;//车道编号

    private String csys;//车身颜色

    private String cllx;//车辆类型

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date jgsj;//经过时间

    private String clwlc;//车辆外廊长

    private String clzpp1;//车辆主品牌

    private String clzpp2;//车辆子品牌

    private String clnk;//车辆年款

    private String zjsaqdzt;//主驾驶安全带状态（0-未知1-未系安全带2-系安全带）

    private String fjsaqdzt;//副驾驶安全带状态（0-未知1-未系安全带2-系安全带）

    private String zjszybzt;//主驾驶遮阳板状态（0-未知1-未打开 2-打开）

    private String fjszybzt;//副驾驶遮阳板状态（0-未知1-未打开 2-打开）

    private String sfddh;//是否打电话（0 -未知1-未打电话2-打电话）

    private String sfhbc;//是否黄标车（0 -未知1-非黄标车2-黄 标车）

    private String sfwxpc;//是否危险品车（0-未知1-危险品车2-非危险品车）

    private String sfygj;//是否有挂（0 -未知1-无挂件2-有挂件）

    private String ssdl;//所属道路

    private String lddm;//路口号

    private String ldms;//地点米数

    private String dllx;//道路类型

    private String cdfx;//车道方向名称

    private String kkbh;//卡口编码(路段代码+路口号+地点米数)

    private String sbbh;//设备编码

    private String tpsl;//图片数量

    private String cptplj;//特征图片

    private String tplj1;//图片路径1

    private String tplj2;//图片路径2

    private String tplj3;//图片路径3

    private String xsdd;//行驶地点
    
    private String device_name;//设备名称
    
    private String hpzlname;//号牌种类名称
    
    private String roim_name;//道路名称
    
    private String csysName;//车身颜色名称
    
    private String hpysName;//号牌颜色名称
    
    private String cllxName;//车辆类型名称
    
    public Long getGcpk() {
        return gcpk;
    }

    public void setGcpk(Long gcpk) {
        this.gcpk = gcpk;
    }

    public String getGcxh() {
        return gcxh;
    }

    public void setGcxh(String gcxh) {
        this.gcxh = gcxh == null ? null : gcxh.trim();
    }

    public String getHpzl() {
        return hpzl;
    }

    public void setHpzl(String hpzl) {
        this.hpzl = hpzl == null ? null : hpzl.trim();
    }

    public String getHphm() {
        return hphm;
    }

    public void setHphm(String hphm) {
        this.hphm = hphm == null ? null : hphm.trim();
    }

    public String getHpys() {
        return hpys;
    }

    public void setHpys(String hpys) {
        this.hpys = hpys == null ? null : hpys.trim();
    }

    public BigDecimal getClsd() {
        return clsd;
    }

    public void setClsd(BigDecimal clsd) {
        this.clsd = clsd;
    }

    public String getCdbh() {
        return cdbh;
    }

    public void setCdbh(String cdbh) {
        this.cdbh = cdbh == null ? null : cdbh.trim();
    }

    public String getCsys() {
        return csys;
    }

    public void setCsys(String csys) {
        this.csys = csys == null ? null : csys.trim();
    }

    public String getCllx() {
        return cllx;
    }

    public void setCllx(String cllx) {
        this.cllx = cllx == null ? null : cllx.trim();
    }

    public Date getJgsj() {
        return jgsj;
    }

    public void setJgsj(Date jgsj) {
        this.jgsj = jgsj;
    }

    public String getClwlc() {
        return clwlc;
    }

    public void setClwlc(String clwlc) {
        this.clwlc = clwlc == null ? null : clwlc.trim();
    }

    public String getClzpp1() {
        return clzpp1;
    }

    public void setClzpp1(String clzpp1) {
        this.clzpp1 = clzpp1 == null ? null : clzpp1.trim();
    }

    public String getClzpp2() {
        return clzpp2;
    }

    public void setClzpp1lznk(String clzpp2) {
        this.clzpp2 = clzpp2 == null ? null : clzpp2.trim();
    }

    public String getLznk() {
        return clnk;
    }

    public void setLznk(String clnk) {
        this.clnk = clnk == null ? null : clnk.trim();
    }

    public String getZjsaqdzt() {
        return zjsaqdzt;
    }

    public void setZjsaqdzt(String zjsaqdzt) {
        this.zjsaqdzt = zjsaqdzt == null ? null : zjsaqdzt.trim();
    }

    public String getFjsaqdzt() {
        return fjsaqdzt;
    }

    public void setFjsaqdzt(String fjsaqdzt) {
        this.fjsaqdzt = fjsaqdzt == null ? null : fjsaqdzt.trim();
    }

    public String getZjszybzt() {
        return zjszybzt;
    }

    public void setZjszybzt(String zjszybzt) {
        this.zjszybzt = zjszybzt == null ? null : zjszybzt.trim();
    }

    public String getFjszybzt() {
        return fjszybzt;
    }

    public void setFjszybzt(String fjszybzt) {
        this.fjszybzt = fjszybzt == null ? null : fjszybzt.trim();
    }

    public String getSfddh() {
        return sfddh;
    }

    public void setSfddh(String sfddh) {
        this.sfddh = sfddh == null ? null : sfddh.trim();
    }

    public String getSfhbc() {
        return sfhbc;
    }

    public void setSfhbc(String sfhbc) {
        this.sfhbc = sfhbc == null ? null : sfhbc.trim();
    }

    public String getSfwxpc() {
        return sfwxpc;
    }

    public void setSfwxpc(String sfwxpc) {
        this.sfwxpc = sfwxpc == null ? null : sfwxpc.trim();
    }

    public String getSfygj() {
        return sfygj;
    }

    public void setSfygj(String sfygj) {
        this.sfygj = sfygj == null ? null : sfygj.trim();
    }

    public String getSsdl() {
        return ssdl;
    }

    public void setSsdl(String ssdl) {
        this.ssdl = ssdl == null ? null : ssdl.trim();
    }

    public String getLddm() {
        return lddm;
    }

    public void setLddm(String lddm) {
        this.lddm = lddm == null ? null : lddm.trim();
    }

    public String getLdms() {
        return ldms;
    }

    public void setLdms(String ldms) {
        this.ldms = ldms == null ? null : ldms.trim();
    }

    public String getDllx() {
        return dllx;
    }

    public void setDllx(String dllx) {
        this.dllx = dllx == null ? null : dllx.trim();
    }

    public String getCdfx() {
        return cdfx;
    }

    public void setCdfx(String cdfx) {
        this.cdfx = cdfx == null ? null : cdfx.trim();
    }

    public String getKkbh() {
        return kkbh;
    }

    public void setKkbh(String kkbh) {
        this.kkbh = kkbh == null ? null : kkbh.trim();
    }

    public String getSbbh() {
        return sbbh;
    }

    public void setSbbh(String sbbh) {
        this.sbbh = sbbh == null ? null : sbbh.trim();
    }

    public String getTpsl() {
        return tpsl;
    }

    public void setTpsl(String tpsl) {
        this.tpsl = tpsl == null ? null : tpsl.trim();
    }

    public String getCptplj() {
        return cptplj;
    }

    public void setCptplj(String cptplj) {
        this.cptplj = cptplj == null ? null : cptplj.trim();
    }

    public String getTplj1() {
        return tplj1;
    }

    public void setTplj1(String tplj1) {
        this.tplj1 = tplj1 == null ? null : tplj1.trim();
    }

    public String getTplj2() {
        return tplj2;
    }

    public void setTplj2(String tplj2) {
        this.tplj2 = tplj2 == null ? null : tplj2.trim();
    }

    public String getTplj3() {
        return tplj3;
    }

    public void setTplj3(String tplj3) {
        this.tplj3 = tplj3 == null ? null : tplj3.trim();
    }

	public String getXsdd() {
		String wfddm = StringUtils.addZeroForFiled(this.ssdl,5)+StringUtils.addZeroForFiled(this.lddm,4)
		+StringUtils.addZeroForFiled(this.ldms,3);
		xsdd = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_WFDD, wfddm);
		return xsdd;
	}

	public void setXsdd(String xsdd) {
		this.xsdd = xsdd;
	}

	public String getDevice_name() {
		if(sbbh!=null){
			device_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_SBBD, sbbh);
		}
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

	public String getHpzlname() {
		if(hpzl!=null){
			hpzlname = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_HPZL, hpzl);
		}
		return hpzlname;
	}

	public void setHpzlname(String hpzlname) {
		this.hpzlname = hpzlname;
	}

	public String getRoim_name() {
		return roim_name;
	}

	public void setRoim_name(String roim_name) {
		this.roim_name = roim_name;
	}

	public String getCsysName() {
		if(csys!=null){
			csysName = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CSYS, csys);
		}
		return csysName;
	}

	public void setCsysName(String csysName) {
		this.csysName = csysName;
	}

	public String getHpysName() {
		if(hpys!=null){
			hpysName = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_HPYS, hpys);
		}
		return hpysName;
	}

	public void setHpysName(String hpysName) {
		this.hpysName = hpysName;
	}

	public String getCllxName() {
		if(cllx!=null){
			cllxName = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CLLX, cllx);
		}
		return cllxName;
	}

	public void setCllxName(String cllxName) {
		this.cllxName = cllxName;
	}
}