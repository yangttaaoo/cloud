package com.cist.redinfo.model;

import java.io.Serializable;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.cist.frame.utils.SysTempStoreUtils;

@SuppressWarnings("unused")
public class RedInfo implements Serializable {
	/**
	 * 红名单表
	 */
	private Integer pk;// 主键
	private String hphm;// 号牌号码
	private String hpzl;// 号牌种类
	private String cllx;// 车辆类型
	private String csys;// 车身颜色
	private String cllx_name;
	public String getCllx_name() {
		return cllx_name;
	}

	public void setCllx_name(String cllx_name) {
		this.cllx_name = cllx_name;
	}

	public String getClpp_name() {
		return clpp_name;
	}

	public void setClpp_name(String clpp_name) {
		this.clpp_name = clpp_name;
	}

	public String getHpys_name() {
		return hpys_name;
	}

	public void setHpys_name(String hpys_name) {
		this.hpys_name = hpys_name;
	}

	public String getHpzl_name() {
		return hpzl_name;
	}

	public void setHpzl_name(String hpzl_name) {
		this.hpzl_name = hpzl_name;
	}

	public String getSsdw_name() {
		return ssdw_name;
	}

	public void setSsdw_name(String ssdw_name) {
		this.ssdw_name = ssdw_name;
	}

	private String clpp_name;
	private String hpys_name;
	private String hpzl_name;
	private String ssdw;// 所属单位
	private String ssdw_name;// 所属单位
	private String clzt;// 车辆状态
	private String clzt_name;
	private String[] csysArrayCode;
	private String clpp;// 车辆品牌
	private String shry;// 审核人员
	private String cxry;// 撤销人员
	private String csysName;//车身颜色名称
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date shsj;// 审核时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date cxsj;// 撤销时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date yxsj;// 有效时间
	private String hpys;// 号牌颜色
	private String cxyy;// 撤销原因
	private Integer clbj;//特殊车辆 1 显示 2 隐藏
	private String clbjName;//
	private static final long serialVersionUID = 1L;

	public String getClzt_name() {
		Date day=new Date();
		if ("1".equals(clzt)){
			return "未审核";
		}else if ("2".equals(clzt)) {
			if (yxsj.after(day)){
				return "已审核(有效)";
			}else if (yxsj.before(day)){
				return "已审核(无效)";
			}
		}else if ("3".equals(clzt)){
			return "已撤销";
		}else if ("4".equals(clzt)){
			return "已作废";
		}
			return "";

	}

	public void setClzt_name(String clzt_name) {
		this.clzt_name = clzt_name;
	}
	public Integer getPk() {
		return pk;
	}
	public void setPk(Integer pk) {
		this.pk = pk;
	}
	public String getHphm() {
		return hphm;
	}
	public void setHphm(String hphm) {
		this.hphm = hphm;
	}
	public String getHpzl() {
		return hpzl;
	}
	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}
	public String getCllx() {
		return cllx;
	}
	public void setCllx(String cllx) {
		this.cllx = cllx;
	}
	public String getCsys() {

		return csys;
	}
	public void setCsys(String csys) {
		this.csys = csys;
	}
	public String getSsdw() {

		return ssdw ;
	}
	public void setSsdw(String ssdw) {
		this.ssdw = ssdw;
	}
	public String getClzt() {
		return clzt;
	}
	public void setClzt(String clzt) {
		this.clzt = clzt;
	}
	public String getClpp() {
		return clpp;		
	}
	public void setClpp(String clpp) {
		this.clpp = clpp;
	}
	public String getShry() {
		return shry;
	}
	public void setShry(String shry) {
		this.shry = shry;
	}
	public String getCxry() {
		return cxry;
	}
	public void setCxry(String cxry) {
		this.cxry = cxry;
	}
	public Date getShsj() {
		return shsj;
	}
	public void setShsj(Date shsj) {
		this.shsj = shsj;
	}
	public Date getCxsj() {
		return cxsj;
	}
	public void setCxsj(Date cxsj) {
		this.cxsj = cxsj;
	}
	public Date getYxsj() {
		return yxsj;
	}
	public void setYxsj(Date yxsj) {
		this.yxsj = yxsj;
	}
	public String getHpys() {
		return hpys;
	}
	public void setHpys(String hpys) {
		this.hpys = hpys;
	}
	public String getCxyy() {
		return cxyy;
	}
	public void setCxyy(String cxyy) {
		this.cxyy = cxyy;
	}
	public Integer getClbj() {
		
		return clbj;
	}
	public void setClbj(Integer clbj) {
		this.clbj = clbj;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCsysName() {
		if(csys!=null) {
			String csname = "";
			String csysArray[] = csys.split(",");
			for (int j = 0; j < csysArray.length; j++){
				csname = csname + SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CSYS,csysArray[j])+",";
			}
			csysName = csname.substring(0, csname.length()-1);
		}else {
			csysName = "未知";
		}
		return csysName;
	}

	public void setCsysName(String csysName) {
		this.csysName = csysName;
	}

	public String[] getCsysArrayCode() {
		if(csys!=null) {
			csysArrayCode = csys.split(",");
		}else {
			csysArrayCode = new String[0];
		}
		return csysArrayCode;
	}

	public void setCsysArrayCode(String[] csysArrayCode) {
		this.csysArrayCode = csysArrayCode;
	}

	public String getClbjName() {
		if (clbj.equals(1)){
			return "否";
		}else if (clbj.equals(2)){
			return "是";
		}
		return "";
	}

	public void setClbjName(String clbjName) {
		this.clbjName = clbjName;
	}

}
