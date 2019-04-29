package com.cist.videopatrol.model;

import java.math.BigDecimal;

public class SPJK_VIO_CRUISE_CONFIG {

	private Integer vcf_pk;//ID
	private Integer vc_pk;//ID
	
	private Integer vcf_num;//视频巡逻方案ID（关联TBL_VIO_CRUISE_CASE表中VCC_PK字段）
	private String device_num;//顺序号
	private Integer vcf_prest_sign;//巡逻预置点
	private Integer vcf_rest_sign;//复位预置点
	private Integer pk_id;//监控设备ID（关联JCSJ_DEVICE表中PK_ID字段）
	private Integer vcf_stop_time;//最小停留时间
	
	private String device_gb_serial;//设备国标序列号
	private String device_gb_code;//设备国标编码
	private String device_gb_channel;//设备国标通道号
	private String device_gb_ptz;//参考SYS_FRM_CODE表 FCT_CODE=P015)
	// 纬度
		private BigDecimal latitude;
		// 经度
		private BigDecimal longitude;
		
		private String road_name;//摄像机所在的道路名称
		
		private boolean play=false;//播放标识 ， 播放过后为true
		
		private Integer status;//设备在线离线标识
		
	public String getDevice_gb_serial() {
			return device_gb_serial;
		}
		public void setDevice_gb_serial(String device_gb_serial) {
			this.device_gb_serial = device_gb_serial;
		}
		public String getDevice_gb_code() {
			return device_gb_code;
		}
		public void setDevice_gb_code(String device_gb_code) {
			this.device_gb_code = device_gb_code;
		}
		public String getDevice_gb_channel() {
			return device_gb_channel;
		}
		public void setDevice_gb_channel(String device_gb_channel) {
			this.device_gb_channel = device_gb_channel;
		}
		public String getDevice_gb_ptz() {
			return device_gb_ptz;
		}
		public void setDevice_gb_ptz(String device_gb_ptz) {
			this.device_gb_ptz = device_gb_ptz;
		}
		public BigDecimal getLatitude() {
			return latitude;
		}
		public void setLatitude(BigDecimal latitude) {
			this.latitude = latitude;
		}
		public BigDecimal getLongitude() {
			return longitude;
		}
		public void setLongitude(BigDecimal longitude) {
			this.longitude = longitude;
		}
		public String getRoad_name() {
			return road_name;
		}
		public void setRoad_name(String road_name) {
			this.road_name = road_name;
		}
	public Integer getVcf_pk() {
		return vcf_pk;
	}
	public void setVcf_pk(Integer vcf_pk) {
		this.vcf_pk = vcf_pk;
	}
	public Integer getVcf_num() {
		return vcf_num;
	}
	public void setVcf_num(Integer vcf_num) {
		this.vcf_num = vcf_num;
	}
	public String getDevice_num() {
		return device_num;
	}
	public void setDevice_num(String device_num) {
		this.device_num = device_num;
	}
	public Integer getVcf_prest_sign() {
		return vcf_prest_sign;
	}
	public void setVcf_prest_sign(Integer vcf_prest_sign) {
		this.vcf_prest_sign = vcf_prest_sign;
	}
	public Integer getVcf_rest_sign() {
		return vcf_rest_sign;
	}
	public void setVcf_rest_sign(Integer vcf_rest_sign) {
		this.vcf_rest_sign = vcf_rest_sign;
	}
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Integer getVcf_stop_time() {
		return vcf_stop_time;
	}
	public void setVcf_stop_time(Integer vcf_stop_time) {
		this.vcf_stop_time = vcf_stop_time;
	}
	public Integer getVc_pk() {
		return vc_pk;
	}
	public void setVc_pk(Integer vc_pk) {
		this.vc_pk = vc_pk;
	}
	public boolean isPlay() {
		return play;
	}
	public void setPlay(boolean play) {
		this.play = play;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}