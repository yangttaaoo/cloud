package com.cist.intervalVelocity.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DevBaseInfo {

	// ID
	private int pk_id;
	// 部门ID
	private long fk_dept_id;
	// 创建人ID
	private int create_person;
	// 创建时间
	@JsonFormat(pattern="yyyy-MM-dd  hh:mm:ss")
	private Date create_time;
	
	
	// 启用日期
	@JsonFormat(pattern="yyyy-MM-dd  hh:mm:ss")
	private Date enable_date;
	// 有效期止
	@JsonFormat(pattern="yyyy-MM-dd  hh:mm:ss")
	private Date validity_date;
	// 责任人
	private String contacts_person;
	// 责任人联系电话
	private String contacts_num;
	// 备注
	private String remarks;
	// 设备类型
	private String fk_device_type;
	// 设备名称
	private String device_name;
	// 设备编号
	private String device_num;
	// 所属道路ID
	private int belonged_road_id;
	// 公里数
	private int kilometre_num;
	// 米数
	private int meter_num;
	// 道路名称
	private String road_name;
	// 经度
	private int longitude;
	// 纬度
	private int latitude;
	// 所在网络位置
	private char network_location;
	// 数据上传模式
	private char upload_mode;
	// 设备来源
	private char device_source;
	//方向
	private String direction;
	public int getPk_id() {
		return pk_id;
	}
	public void setPk_id(int pk_id) {
		this.pk_id = pk_id;
	}
	public long getFk_dept_id() {
		return fk_dept_id;
	}
	public void setFk_dept_id(long fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}
	public int getCreate_person() {
		return create_person;
	}
	public void setCreate_person(int create_person) {
		this.create_person = create_person;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getEnable_date() {
		return enable_date;
	}
	public void setEnable_date(Date enable_date) {
		this.enable_date = enable_date;
	}
	public Date getValidity_date() {
		return validity_date;
	}
	public void setValidity_date(Date validity_date) {
		this.validity_date = validity_date;
	}
	public String getContacts_person() {
		return contacts_person;
	}
	public void setContacts_person(String contacts_person) {
		this.contacts_person = contacts_person;
	}
	public String getContacts_num() {
		return contacts_num;
	}
	public void setContacts_num(String contacts_num) {
		this.contacts_num = contacts_num;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getFk_device_type() {
		return fk_device_type;
	}
	public void setFk_device_type(String fk_device_type) {
		this.fk_device_type = fk_device_type;
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
	public int getBelonged_road_id() {
		return belonged_road_id;
	}
	public void setBelonged_road_id(int belonged_road_id) {
		this.belonged_road_id = belonged_road_id;
	}
	public int getKilometre_num() {
		return kilometre_num;
	}
	public void setKilometre_num(int kilometre_num) {
		this.kilometre_num = kilometre_num;
	}
	public int getMeter_num() {
		return meter_num;
	}
	public void setMeter_num(int meter_num) {
		this.meter_num = meter_num;
	}
	public String getRoad_name() {
		return road_name;
	}
	public void setRoad_name(String road_name) {
		this.road_name = road_name;
	}
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	public char getNetwork_location() {
		return network_location;
	}
	public void setNetwork_location(char network_location) {
		this.network_location = network_location;
	}
	public char getUpload_mode() {
		return upload_mode;
	}
	public void setUpload_mode(char upload_mode) {
		this.upload_mode = upload_mode;
	}
	public char getDevice_source() {
		return device_source;
	}
	public void setDevice_source(char device_source) {
		this.device_source = device_source;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
}
