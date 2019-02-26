package com.cist.qwgl.qwjg.model;

import java.io.Serializable;

public class DeviceInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer pk_id;//id
	private String fk_dept_id;//部门id
	private String device_name;//设备名称
	private String device_num;//设备编号
	private Integer belonged_road_id;//所属道路id
	private Double longitude;//经度
	private Double latitude;//维度
	private String ip_address;//设备IP
	private String port;//设备端口
	private String channel;//通道号
	private String access_address;//访问地址
	private String access_user_name;//访问用户名
	private String access_password;//访问密码
	private String fk_device_type;
	private Integer img;//DJ KKSB 
	private Jcsj_device_camera_gb28181 jcsj_device_camera_gb28181;
	
	public Jcsj_device_camera_gb28181 getJcsj_device_camera_gb28181() {
		return jcsj_device_camera_gb28181;
	}
	public void setJcsj_device_camera_gb28181(Jcsj_device_camera_gb28181 jcsj_device_camera_gb28181) {
		this.jcsj_device_camera_gb28181 = jcsj_device_camera_gb28181;
	}
	public Integer getImg() {
		if(fk_device_type.equals("DJ")) {
			return 6;
		}else if(fk_device_type.equals("KKSB")) {
			return 5;
		}
		return img;
	}
	public void setImg(Integer img) {
		this.img = img;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getFk_device_type() {
		return fk_device_type;
	}
	public void setFk_device_type(String fk_device_type) {
		this.fk_device_type = fk_device_type;
	}
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public String getFk_dept_id() {
		return fk_dept_id;
	}
	public void setFk_dept_id(String fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	public String getDevice_num() {
		return device_num;
	}
	public void setDevice_num(String device_num) {
		this.device_num = device_num;
	}
	public Integer getBelonged_road_id() {
		return belonged_road_id;
	}
	public void setBelonged_road_id(Integer belonged_road_id) {
		this.belonged_road_id = belonged_road_id;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getAccess_address() {
		return access_address;
	}
	public void setAccess_address(String access_address) {
		this.access_address = access_address;
	}
	public String getAccess_user_name() {
		return access_user_name;
	}
	public void setAccess_user_name(String access_user_name) {
		this.access_user_name = access_user_name;
	}
	public String getAccess_password() {
		return access_password;
	}
	public void setAccess_password(String access_password) {
		this.access_password = access_password;
	}
	
	
}
