package com.cist.dataquery.model;

import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Excels {
	private String hphm;//号牌号码
	private String hpzl;//号牌种类
	private String wfxw;//违法行为（对应TBL_OFFE_CATE）
	private String wfdz;//违法地点
	private String cjdw;//采集单位
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GTM+8")
	private Date wfsj;//违法时间
	private String shbz;//审核标志
	
	public String getShbz() {
		switch (shbz) {
		 case "1":
		  shbz="初审通过";	
		   break;
		 case "2":
		   shbz="复审通过";	
		   break;
		 case "3":
		   shbz="初审作废";	
		   break;
		 case "4":
		     shbz="复审作废";	
			 break;
		 case "7":
			  shbz="上传成功";	
			 break;
		 case "8":
			  shbz="上传失败";	
			 break;
		 case "0":
			 shbz="未审核";
		   break;
		 case "11":
			 shbz="上传队列中";
		   break;
		}
		
		return shbz;
	}
	public void setShbz(String shbz) {
		this.shbz = shbz;
	}
	public String getHpzl() {
		if(null!=hpzl){
			 String hpzlname =  SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_HPZL,hpzl);
			 return hpzlname;
		} else{
			return "";
		}
	}
	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}
	public String getHphm() {
		return hphm;
	}
	public void setHphm(String hphm) {
		this.hphm = hphm;
	}
	public String getWfxw() {
		if(null!=wfxw){
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_WFXW,wfxw);
		}
		return wfxw;
	}
	public void setWfxw(String wfxw) {
		this.wfxw = wfxw;
	}
	public String getWfdz() {
		return wfdz;
	}
	public void setWfdz(String wfdz) {
		this.wfdz = wfdz;
	}
	public String getCjdw() {
		if(null!=cjdw){
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT,cjdw);
		}
		return cjdw;
	}
	public void setCjdw(String cjdw) {
		this.cjdw = cjdw;
	}
	public Date getWfsj() {
		return wfsj;
	}
	
	
}
