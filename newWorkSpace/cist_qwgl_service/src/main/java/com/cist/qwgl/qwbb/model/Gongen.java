package com.cist.qwgl.qwbb.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Gongen implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer pk_id;//报备id
	private String name;//巡区名称
	private String fangshi;//巡控方式
	private String banciname;//班次名称
	private Integer chezong;//车辆总数
	private Integer renzong;//人员总数
	private Date bancikaishitime;//班次开始时间
	private Date banciendtime;//班次结束时间
	private String  bancibiename;//班次别名
	private String  car_list_str;//警车人员集合
	private String  personnel_list_str;//其它人员集合
	private Integer report_type;//报备类型（1：街面勤务；2：值班值守；3：接处警；4：轮休;5：机关）
	private String  zhibanlingdao;//值班领导
	private String  lianxiphone;//联系电话
	private String  zhihuizhang;//指挥长
	private String  renyuan;//人员
	private String  minjing;//民警人员
	private String  xiejing;//协警人员
	private String  gongzuotime;//工作时间
	
	public String getGongzuotime() {
		if(null!=bancikaishitime&&null!=banciendtime) {
			SimpleDateFormat simp=new SimpleDateFormat("HH:mm");
			return simp.format(bancikaishitime)+"~"+simp.format(banciendtime);
		}
		return gongzuotime;
	}
	public void setGongzuotime(String gongzuotime) {
		this.gongzuotime = gongzuotime;
	}
	public String getMinjing() {
		return minjing;
	}
	public void setMinjing(String minjing) {
		this.minjing = minjing;
	}
	public String getXiejing() {
		return xiejing;
	}
	public void setXiejing(String xiejing) {
		this.xiejing = xiejing;
	}
	public String getRenyuan() {
		return renyuan;
	}
	public void setRenyuan(String renyuan) {
		this.renyuan = renyuan;
	}
	public String getZhibanlingdao() {
		return zhibanlingdao;
	}
	public void setZhibanlingdao(String zhibanlingdao) {
		this.zhibanlingdao = zhibanlingdao;
	}
	public String getLianxiphone() {
		return lianxiphone;
	}
	public void setLianxiphone(String lianxiphone) {
		this.lianxiphone = lianxiphone;
	}
	public String getZhihuizhang() {
		return zhihuizhang;
	}
	public void setZhihuizhang(String zhihuizhang) {
		this.zhihuizhang = zhihuizhang;
	}
	public Integer getReport_type() {
		return report_type;
	}
	public void setReport_type(Integer report_type) {
		this.report_type = report_type;
	}
	public String getCar_list_str() {
		return car_list_str;
	}
	public void setCar_list_str(String car_list_str) {
		this.car_list_str = car_list_str;
	}
	public String getPersonnel_list_str() {
		return personnel_list_str;
	}
	public void setPersonnel_list_str(String personnel_list_str) {
		this.personnel_list_str = personnel_list_str;
	}
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public String getBancibiename() {
		if(null!=banciname&&banciname!="") {
			SimpleDateFormat simp=new SimpleDateFormat("HH:mm");
			return banciname+"/"+simp.format(bancikaishitime)+"~"+simp.format(banciendtime);
		}
		return bancibiename;
	}
	public void setBancibiename(String bancibiename) {
		this.bancibiename = bancibiename;
	}
	public Date getBancikaishitime() {
		return bancikaishitime;
	}
	public void setBancikaishitime(Date bancikaishitime) {
		this.bancikaishitime = bancikaishitime;
	}
	public Date getBanciendtime() {
		return banciendtime;
	}
	public void setBanciendtime(Date banciendtime) {
		this.banciendtime = banciendtime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFangshi() {
		return fangshi;
	}
	public void setFangshi(String fangshi) {
		this.fangshi = fangshi;
	}
	public String getBanciname() {
		return banciname;
	}
	public void setBanciname(String banciname) {
		this.banciname = banciname;
	}
	public Integer getChezong() {
		return chezong;
	}
	public void setChezong(Integer chezong) {
		this.chezong = chezong;
	}
	public Integer getRenzong() {
		return renzong;
	}
	public void setRenzong(Integer renzong) {
		this.renzong = renzong;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Gongen(String name, String fangshi, String banciname, Integer chezong, Integer renzong) {
		super();
		this.name = name;
		this.fangshi = fangshi;
		this.banciname = banciname;
		this.chezong = chezong;
		this.renzong = renzong;
	}
	public Gongen() {
		super();
		// TODO Auto-generated constructor stub
	}
}
