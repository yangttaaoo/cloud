package com.cist.devasset.model;

import java.util.Date;


public class Jtyw_jksbzc_plan {

	private Integer pk_id;
	private String asset_name;//资产名称
	private String asset_type;//资产类型
	private String	asset_id;
	private String device_type;//设备类型
	private String device_model;//设备型号
	private String 	asset_num;//资产编号
	private String 	vendor;//生产厂商
	private Date deploy_time;//	部署日期
	private String 	install_site;//安装地点
	private String 	remarks;//备注
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public String getAsset_name() {
		return asset_name;
	}
	public void setAsset_name(String asset_name) {
		this.asset_name = asset_name;
	}
	public String getAsset_type() {
		return asset_type;
	}
	public void setAsset_type(String asset_type) {
		this.asset_type = asset_type;
	}
	public String getDevice_type() {
		return device_type;
	}
	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	public String getDevice_model() {
		return device_model;
	}
	public void setDevice_model(String device_model) {
		this.device_model = device_model;
	}
	public String getAsset_num() {
		return asset_num;
	}
	public void setAsset_num(String asset_num) {
		this.asset_num = asset_num;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Date getDeploy_time() {
		return deploy_time;
	}
	public void setDeploy_time(Date deploy_time) {
		this.deploy_time = deploy_time;
	}
	public String getInstall_site() {
		return install_site;
	}
	public void setInstall_site(String install_site) {
		this.install_site = install_site;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(String asset_id) {
		this.asset_id = asset_id;
	}






}
