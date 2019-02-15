package com.cist.home.model;

import java.io.Serializable;
/**
 * 5.20. 摄像头国标参数
 * @author wangtao
 *
 */
public class Jcsj_device_camera_gb28181  implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer device_id;//设备id
	private String device_gb_serial;//设备国标序列号
	private String device_gb_code;//设备国标编码
	private String device_gb_channel;//设备国标通道号
	private Integer device_gb_ptz;//参考sys_frm_code表 fct_code=p015)
	public Integer getDevice_id() {
		return device_id;
	}
	public void setDevice_id(Integer device_id) {
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
	public Integer getDevice_gb_ptz() {
		return device_gb_ptz;
	}
	public void setDevice_gb_ptz(Integer device_gb_ptz) {
		this.device_gb_ptz = device_gb_ptz;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Jcsj_device_camera_gb28181(Integer device_id, String device_gb_serial, String device_gb_code,
			String device_gb_channel, Integer device_gb_ptz) {
		super();
		this.device_id = device_id;
		this.device_gb_serial = device_gb_serial;
		this.device_gb_code = device_gb_code;
		this.device_gb_channel = device_gb_channel;
		this.device_gb_ptz = device_gb_ptz;
	}
	public Jcsj_device_camera_gb28181() {
		super();
		// TODO Auto-generated constructor stub
	}

}
