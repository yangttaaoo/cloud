package com.cist.offsite.invalidtrial.model;


public class Tbl_dev_vio_config {
	private Integer dvc_pk;
	private Integer dve_pk;
	private String dvc_code;
	private String dvc_name;
	private Integer dvc_comp_pk;
	private Integer dvc_brand_pk;
	private Integer dvc_model_pk;
	private String dvc_dir;
	private String dvc_ip;
	private String dvc_chl;
	private String dvc_admin_url;
	private String dvc_user;
	private String dvc_pwd;
	private String dvc_port;
	private String dvc_rtsp;
	private String dvc_rtmp;
	private String dvc_http;
	private String dvc_ptz;
	private Integer dvc_type_pk;//结构类型
	private Integer dvc_px_pk;
	private Integer dvc_encoder_pk;
	private Integer dvc_bitrate_pk;
	private Integer num;//统计数据
	private String dvc_status;//摄像机状态，0离线 1在线
	private String address_name;//所在地点名称
	private String dvc_status_name;//摄像机状态，0离线 1在线
	private String dvc_brand_name;
	private String dvc_brand;//摄像机品牌（关联SYS_FRM_CODE表中FC_CODE字段）
	private String dvc_type_name;
	private String dvc_type;//结构类型（关联SYS_FRM_CODE表中FC_CODE字段）
	
	private String	 dvc_comp;//摄像机厂家（关联SYS_FRM_CODE表中FC_CODE字段）
	
	private String	dvc_model;//摄像机型号（关联SYS_FRM_CODE表中FC_CODE字段）
	
	private String	dvc_model_name;//摄像机型号
	
	private String dvc_ptz_name;
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getDvc_status() {
		return dvc_status;
	}

	public void setDvc_status(String dvc_status) {
		this.dvc_status = dvc_status;
	}

	public Integer getDvc_pk() {
		return dvc_pk;
	}

	public void setDvc_pk(Integer dvc_pk) {
		this.dvc_pk = dvc_pk;
	}

	public Integer getDve_pk() {
		return dve_pk;
	}

	public void setDve_pk(Integer dve_pk) {
		this.dve_pk = dve_pk;
	}

	public String getDvc_code() {
		return dvc_code;
	}

	public void setDvc_code(String dvc_code) {
		this.dvc_code = dvc_code;
	}

	public String getDvc_name() {
		return dvc_name;
	}

	public void setDvc_name(String dvc_name) {
		this.dvc_name = dvc_name;
	}

	public Integer getDvc_comp_pk() {
		return dvc_comp_pk;
	}

	public void setDvc_comp_pk(Integer dvc_comp_pk) {
		this.dvc_comp_pk = dvc_comp_pk;
	}

	public Integer getDvc_brand_pk() {
		return dvc_brand_pk;
	}

	public void setDvc_brand_pk(Integer dvc_brand_pk) {
		this.dvc_brand_pk = dvc_brand_pk;
	}

	public Integer getDvc_model_pk() {
		return dvc_model_pk;
	}

	public void setDvc_model_pk(Integer dvc_model_pk) {
		this.dvc_model_pk = dvc_model_pk;
	}

	public String getDvc_dir() {
		return dvc_dir;
	}

	public void setDvc_dir(String dvc_dir) {
		this.dvc_dir = dvc_dir;
	}

	public String getDvc_ip() {
		return dvc_ip;
	}

	public void setDvc_ip(String dvc_ip) {
		this.dvc_ip = dvc_ip;
	}

	public String getDvc_chl() {
		return dvc_chl;
	}

	public void setDvc_chl(String dvc_chl) {
		this.dvc_chl = dvc_chl;
	}

	public String getDvc_admin_url() {
		return dvc_admin_url;
	}

	public void setDvc_admin_url(String dvc_admin_url) {
		this.dvc_admin_url = dvc_admin_url;
	}

	public String getDvc_user() {
		return dvc_user;
	}

	public void setDvc_user(String dvc_user) {
		this.dvc_user = dvc_user;
	}

	public String getDvc_pwd() {
		return dvc_pwd;
	}

	public void setDvc_pwd(String dvc_pwd) {
		this.dvc_pwd = dvc_pwd;
	}

	public String getDvc_port() {
		return dvc_port;
	}

	public void setDvc_port(String dvc_port) {
		this.dvc_port = dvc_port;
	}

	public String getDvc_rtsp() {
		return dvc_rtsp;
	}

	public void setDvc_rtsp(String dvc_rtsp) {
		this.dvc_rtsp = dvc_rtsp;
	}

	public String getDvc_rtmp() {
		return dvc_rtmp;
	}

	public void setDvc_rtmp(String dvc_rtmp) {
		this.dvc_rtmp = dvc_rtmp;
	}

	public String getDvc_http() {
		return dvc_http;
	}

	public void setDvc_http(String dvc_http) {
		this.dvc_http = dvc_http;
	}

	public String getDvc_ptz() {
//		if(dvc_ptz.equals("0"))
//		{
//			dvc_ptz="不可控";
//		}
//		else if(dvc_ptz.equals("1"))
//		{
//			dvc_ptz="可控";
//		}
		return dvc_ptz;
	}

	public void setDvc_ptz(String dvc_ptz) {
		this.dvc_ptz = dvc_ptz;
	}

	public Integer getDvc_type_pk() {
		
		return dvc_type_pk;
	}

	public void setDvc_type_pk(Integer dvc_type_pk) {
		this.dvc_type_pk = dvc_type_pk;
	}

	public Integer getDvc_px_pk() {
		return dvc_px_pk;
	}

	public void setDvc_px_pk(Integer dvc_px_pk) {
		this.dvc_px_pk = dvc_px_pk;
	}

	public Integer getDvc_encoder_pk() {
		return dvc_encoder_pk;
	}

	public void setDvc_encoder_pk(Integer dvc_encoder_pk) {
		this.dvc_encoder_pk = dvc_encoder_pk;
	}

	public Integer getDvc_bitrate_pk() {
		return dvc_bitrate_pk;
	}

	public void setDvc_bitrate_pk(Integer dvc_bitrate_pk) {
		this.dvc_bitrate_pk = dvc_bitrate_pk;
	}

	public String getAddress_name() {
		return address_name;
	}

	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}

	public String getDvc_status_name() {
		if(dvc_status.equals("0"))
		{
			dvc_status_name="离线";
		}
		else if(dvc_status.equals("1"))
		{
			dvc_status_name="在线";
		}
		return dvc_status_name;
	}

	public void setDvc_status_name(String dvc_status_name) {
		this.dvc_status_name = dvc_status_name;
	}

	public String getDvc_brand_name() {
		return dvc_brand_name;
	}

	public void setDvc_brand_name(String dvc_brand_name) {
		this.dvc_brand_name = dvc_brand_name;
	}

	public String getDvc_brand() {
		return dvc_brand;
	}

	public void setDvc_brand(String dvc_brand) {
		this.dvc_brand = dvc_brand;
	}

	public String getDvc_type_name() {
		return dvc_type_name;
	}

	public void setDvc_type_name(String dvc_type_name) {
		
		
		this.dvc_type_name = dvc_type_name;
	}

	public String getDvc_type() {
		return dvc_type;
	}

	public void setDvc_type(String dvc_type) {
		this.dvc_type = dvc_type;
	}

	public String getDvc_comp() {
		return dvc_comp;
	}

	public void setDvc_comp(String dvc_comp) {
		this.dvc_comp = dvc_comp;
	}

	public String getDvc_model() {
		return dvc_model;
	}

	public void setDvc_model(String dvc_model) {
		this.dvc_model = dvc_model;
	}

	public String getDvc_model_name() {
		return dvc_model_name;
	}

	public void setDvc_model_name(String dvc_model_name) {
		this.dvc_model_name = dvc_model_name;
	}

	public String getDvc_ptz_name() {
//		if(dvc_ptz.equals("0"))
//		{
//			dvc_ptz_name="不可控";
//		}
//		else if(dvc_ptz.equals("1"))
//		{
//			dvc_ptz_name="可控";
//		}
		return dvc_ptz_name;
	}

	public void setDvc_ptz_name(String dvc_ptz_name) {
		this.dvc_ptz_name = dvc_ptz_name;
	}

}
