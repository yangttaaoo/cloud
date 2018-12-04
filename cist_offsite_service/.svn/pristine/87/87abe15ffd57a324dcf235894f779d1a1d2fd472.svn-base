package com.cist.redlist.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class RedListInfo  implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer pk;//红名单pk
	private String hphm;//号牌号码
	private String hpqyhphm;
	private String hpzl;//号牌种类
	private String hpzl_name;//号牌种类名称
	private String cllx;//车辆类型
	private String cllx_name;//车辆类型名称
	private String csys;//车身颜色
	private String csys_name;//车身颜色名称
	private String[] csys_code;
	private String ssdw;//所属单位
	private String ssdw_name;//所属单位名称
	private Integer clzt;//车辆状态（1-未审核，2-已审核，3-已撤销，4-已作废）
	private String clpp;//车辆品牌
	private String clpp_name;//车辆品牌名称
	private String shry;//审核人员
	private String cxry;//撤销人员
	private Timestamp shsj;//审核时间
	private Timestamp cxsj;//撤销时间
	private String yxsj;//有效时间
	private String hpys;//号牌颜色
	private String hpys_name;//号牌颜色名称
	private String cxyy;//撤销原因
	private Integer clbj;//车辆标记（1-显示，2-隐藏）
	private String hpqy;//号牌区域
	
	
	public String getHpqyhphm() {
		hpqyhphm = hphm;
		return hpqyhphm;
	}
	public void setHpqyhphm(String hpqyhphm) {
		this.hpqyhphm = hpqyhphm;
	}
	public String[] getCsys_code() {
		if(csys!=null) {
			csys_code = this.csys.split(",");
		}
		return csys_code;
	}
	public void setCsys_code(String[] csys_code) {
		this.csys_code = csys_code;
	}
	public String getSsdw_name() {
		return ssdw_name;
	}
	public void setSsdw_name(String ssdw_name) {
		this.ssdw_name = ssdw_name;
	}
	public String getHpqy() {
		if(hphm!=null) {
			hpqy = hphm.substring(0,2);
		}
		return hpqy;
	}
	public void setHpqy(String hpqy) {
		this.hpqy = hpqy;
	}
	public String getHpys_name() {
		return hpys_name;
	}
	public void setHpys_name(String hpys_name) {
		this.hpys_name = hpys_name;
	}
	public String getClpp_name() {
		return clpp_name;
	}
	public void setClpp_name(String clpp_name) {
		this.clpp_name = clpp_name;
	}
	public String getCsys_name() {
		String csname = "";
		if(csys!=null) {
			String[] a = csys.split(",");
			for(int j=0;j<a.length;j++){
				csname = csname+SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CSYS,a[j])+",";
			}
			csys_name = csname.substring(0, csname.length()-1);
		}
		return csys_name;
	}
	public void setCsys_name(String csys_name) {
		this.csys_name = csys_name;
	}
	public String getCllx_name() {
		return cllx_name;
	}
	public void setCllx_name(String cllx_name) {
		this.cllx_name = cllx_name;
	}
	public String getHpzl_name() {
		return hpzl_name;
	}
	public void setHpzl_name(String hpzl_name) {
		this.hpzl_name = hpzl_name;
	}
	public Integer getPk() {
		return pk;
	}
	public void setPk(Integer pk) {
		this.pk = pk;
	}
	public String getHphm() {
		String hphm1 = "";
		if(hphm!=null) {
			hphm1 = hphm.substring(2,hphm.length());
		}
		return hphm1;
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
		return ssdw;
	}
	public void setSsdw(String ssdw) {
		this.ssdw = ssdw;
	}
	public Integer getClzt() {
		return clzt;
	}
	public void setClzt(Integer clzt) {
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
	public Timestamp getShsj() {
		return shsj;
	}
	public void setShsj(Timestamp shsj) {
		this.shsj = shsj;
	}
	public Timestamp getCxsj() {
		return cxsj;
	}
	public void setCxsj(Timestamp cxsj) {
		this.cxsj = cxsj;
	}

	public String getYxsj() {
		return yxsj;
	}
	public void setYxsj(String yxsj) {
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
	
	
}
