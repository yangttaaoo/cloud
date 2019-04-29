package com.cist.devRegister.model;
//5.9.摄像头参数(JCSJ_DEVICE_CAMERA_PARAM)
public class DeviceCameraParam {
	//设备ID
	private int device_id;
	//图像尺寸ID（标清、准高清、高清、超高清）
	private int image_size_id;
	//成像颜色ID（彩色、黑白、日夜两用）
	private int imaging_color_id;
	//	结构类型ID（枪式、半球、变速球形、针孔、全景）
	private int structure_type_id;
	//码流类型ID（256Kbps、512Kbps、1Mbps、2Mbps、5Mbps、10Mbps、其他）
	private int code_stream_type_id;
	//云台类型ID（无云台、定速普通云台、高速普通云台、球形云台、高速球形云台）
	private int cloud_platform_type_id;
	//	PTZ控制类型ID（可控、不可控）
	private int ptz_control_type_id;
	//事件检测标记（0：不检测；1：检测）
	private char event_detection_sign;
	
	
	
	
	public DeviceCameraParam() {
	}
	public int getDevice_id() {
		return device_id;
	}
	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}
	public int getImage_size_id() {
		return image_size_id;
	}
	public void setImage_size_id(int image_size_id) {
		this.image_size_id = image_size_id;
	}
	public int getImaging_color_id() {
		return imaging_color_id;
	}
	public void setImaging_color_id(int imaging_color_id) {
		this.imaging_color_id = imaging_color_id;
	}
	public int getStructure_type_id() {
		return structure_type_id;
	}
	public void setStructure_type_id(int structure_type_id) {
		this.structure_type_id = structure_type_id;
	}
	public int getCode_stream_type_id() {
		return code_stream_type_id;
	}
	public void setCode_stream_type_id(int code_stream_type_id) {
		this.code_stream_type_id = code_stream_type_id;
	}
	public int getCloud_platform_type_id() {
		return cloud_platform_type_id;
	}
	public void setCloud_platform_type_id(int cloud_platform_type_id) {
		this.cloud_platform_type_id = cloud_platform_type_id;
	}
	public int getPtz_control_type_id() {
		return ptz_control_type_id;
	}
	public void setPtz_control_type_id(int ptz_control_type_id) {
		this.ptz_control_type_id = ptz_control_type_id;
	}
	public char getEvent_detection_sign() {
		return event_detection_sign;
	}
	public void setEvent_detection_sign(char event_detection_sign) {
		this.event_detection_sign = event_detection_sign;
	}
	
	
	
}
