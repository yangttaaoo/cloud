package com.cist.earlyewarningpost.model;

import java.math.BigDecimal;
import java.util.Date;
import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

import net.sf.json.JSONObject;
/***
 * 车辆预警信息
 * @author yt
 *
 */
public class JcbkWarningVehicle {
    private String pk;//主键

    private String hphm;//号牌号码

    private String hpzl;//号牌种类	

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gcsj;//过车时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date yjsj;//预警时间

    private String yjdd;//预警地点

    private BigDecimal xssd;//行驶速度

    private String ssbm;//所属部门

    private String xsqy;//行驶区域

    private String kkbh;//卡口编号

    private String yjxh;//预警序号

    private String yjlx;//预警类型（参考SYS_FRM_CODE表FCT_CODE=BKLX）
    private String yjlxName;//预警类型名称

    private String cdbh;//车道编号

    private String csys;//车身颜色

    private String cllx;//车辆类型

    private String ssdl;//所属道路

    private String lddm;//路口号

    private String ldms;//地点米数

    private String dllx;//道路类型

    private String cdfx;//车道方向名称

    private String sbbh;//设备编码

    private String tpsl;//图片数量

    private String cptplj;//车牌图片路径

    private String tplj1;//图片路径1

    private String tplj2;//图片路径2

    private String tplj3;//图片路径3

    private String event_current_status;//预警当前状态（0未受理、1已受理、2已调度、3已完成）
    
    private String roim_name;//道路名称
    
    private BigDecimal longitude;//经度
    
    private BigDecimal latitude;//纬度
    
    private String hpzlName;
    
    private String ssbmName;//所属部门名称
    
    private String bkyy;//布控原因
    private String ztName;//状态名称
    
    private String ms;//布控卡口描述
    
    private String sjly;//数据来源
    
    

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getHphm() {
        return hphm;
    }

    public void setHphm(String hphm) {
        this.hphm = hphm == null ? null : hphm.trim();
    }

    public String getHpzl() {
        return hpzl;
    }

    public void setHpzl(String hpzl) {
        this.hpzl = hpzl == null ? null : hpzl.trim();
    }

    public Date getGcsj() {
        return gcsj;
    }

    public void setGcsj(Date gcsj) {
        this.gcsj = gcsj;
    }

    public Date getYjsj() {
        return yjsj;
    }

    public void setYjsj(Date yjsj) {
        this.yjsj = yjsj;
    }

    public String getYjdd() {
        return yjdd;
    }

    public void setYjdd(String yjdd) {
        this.yjdd = yjdd == null ? null : yjdd.trim();
    }

    public BigDecimal getXssd() {
        return xssd;
    }

    public void setXssd(BigDecimal xssd) {
        this.xssd = xssd;
    }

    public String getSsbm() {
        return ssbm;
    }

    public void setSsbm(String ssbm) {
        this.ssbm = ssbm == null ? null : ssbm.trim();
    }

    public String getXsqy() {
        return xsqy;
    }

    public void setXsqy(String xsqy) {
        this.xsqy = xsqy == null ? null : xsqy.trim();
    }

    public String getKkbh() {
        return kkbh;
    }

    public void setKkbh(String kkbh) {
        this.kkbh = kkbh == null ? null : kkbh.trim();
    }

    public String getYjxh() {
        return yjxh;
    }

    public void setYjxh(String yjxh) {
        this.yjxh = yjxh == null ? null : yjxh.trim();
    }

    public String getYjlx() {
        return yjlx;
    }

    public void setYjlx(String yjlx) {
        this.yjlx = yjlx == null ? null : yjlx.trim();
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

	public String getEvent_current_status() {
		return event_current_status;
	}

	public void setEvent_current_status(String event_current_status) {
		this.event_current_status = event_current_status;
	}

	public String getRoim_name() {
         if(ssdl!=null) {
        	 roim_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DLMC, ssdl);
         }
		return roim_name;
	}

	public void setRoim_name(String roim_name) {
		this.roim_name = roim_name;
	}

	public BigDecimal getLongitude() {
		if(sbbh!=null) {
			String fcAttr = SysTempStoreUtils.getFcAttr(SysBaseDataCode.SYS_SBBD, sbbh);
			if(!"未知".equals(fcAttr)) {
				JSONObject jsonObject=JSONObject.fromObject(fcAttr);
				Object object = jsonObject.get("longitude");
				if(object!=null) {
					longitude=new BigDecimal(object.toString());
				}	
			}
		}
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		if(sbbh!=null) {
			String fcAttr = SysTempStoreUtils.getFcAttr(SysBaseDataCode.SYS_SBBD, sbbh);
			if(!"未知".equals(fcAttr)) {
				JSONObject jsonObject=JSONObject.fromObject(fcAttr);
				Object object = jsonObject.get("latitude");
				if(object!=null) {
					latitude=new BigDecimal(object.toString());
				}	
			}
		}
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public String getHpzlName() {
		if(hpzl!=null) {
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_HPZL, hpzl);
		}
		return hpzlName;
	}

	public void setHpzlName(String hpzlName) {
		this.hpzlName = hpzlName;
	}

	public String getSsbmName() {
		if(ssbm!=null) {
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT, ssbm);
		}
		return ssbmName;
	}

	public void setSsbmName(String ssbmName) {
		this.ssbmName = ssbmName;
	}

	public String getBkyy() {
		return bkyy;
	}

	public void setBkyy(String bkyy) {
		this.bkyy = bkyy;
	}

	public String getYjlxName() {
		if(yjlx!=null) {
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_BKLX, yjlx);
		}else {
			yjlxName = "未知";
		}
		return yjlxName;
	}

	public void setYjlxName(String yjlxName) {
		this.yjlxName = yjlxName;
	}

	public String getZtName() {
		if("0".equals(event_current_status)) {
			ztName = "未受理";
		}else if("1".equals(event_current_status)) {
			ztName = "已受理";
		}else if("2".equals(event_current_status)) {
			ztName = "已调度";
		}else if("3".equals(event_current_status)) {
			ztName = "已完成";
		}else {
			ztName = "未知";
		}
		return ztName;
	}

	public void setZtName(String ztName) {
		this.ztName = ztName;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public String getSjly() {
		return sjly;
	}

	public void setSjly(String sjly) {
		this.sjly = sjly;
	}
}