package com.cist.devRegister.model;

public class DeviceCameraGb28181 {
	//设备ID
	private long device_id;
//	设备国标序列号
	private String device_gb_serial;
//	设备国标编码
	private String device_gb_code;
//	设备国标通道号
	private String device_gb_channel;
//	参考SYS_FRM_CODE表 FCT_CODE=P015)
	private char   device_gb_ptz;
	public long getDevice_id() {
		return device_id;
	}
	public void setDevice_id(long device_id) {
		this.device_id = device_id;
	}
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
	public char getDevice_gb_ptz() {
		return device_gb_ptz;
	}
	public void setDevice_gb_ptz(char device_gb_ptz) {
		this.device_gb_ptz = device_gb_ptz;
	}
	
	
	
}
