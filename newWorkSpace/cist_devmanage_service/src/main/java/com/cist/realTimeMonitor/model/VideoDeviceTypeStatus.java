package com.cist.realTimeMonitor.model;
/**
 * 视频设备分类型统计
 * @author 57150
 *
 */
public class VideoDeviceTypeStatus {
	//视频设备类型名称
	private String device_type_name;
	//该类型视频设备在线数
	private Long device_type_online_total;
	//该类型视频设备离线数
	private Long device_type_offline_total;

	public String getDevice_type_name() {
		return device_type_name;
	}

	public void setDevice_type_name(String device_type_name) {
		this.device_type_name = device_type_name;
	}

	public Long getDevice_type_online_total() {
		return device_type_online_total;
	}

	public void setDevice_type_online_total(Long device_type_online_total) {
		this.device_type_online_total = device_type_online_total;
	}

	public Long getDevice_type_offline_total() {
		return device_type_offline_total;
	}

	public void setDevice_type_offline_total(Long device_type_offline_total) {
		this.device_type_offline_total = device_type_offline_total;
	}

}
