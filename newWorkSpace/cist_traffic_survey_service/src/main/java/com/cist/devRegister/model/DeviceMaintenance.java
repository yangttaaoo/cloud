package com.cist.devRegister.model;
//5.3.厂商维护信息(JCSJ_DEVICE_MAINTENANCE)
public class DeviceMaintenance {
	//设备ID 
	private int  device_id;
	//设备厂商
	private String  device_manufacturer;
	//设备品牌
	private String  device_brand;
	//设备型号
	private String  device_model;
	//厂商联系人
	private String  contacts_person;
	//联系人电话
	private String  contacts_num;
	//设备IP
	private String  ip_address;
	//设备端口
	private String  port;
	//通道号
	private String  channel;
	//访问地址
	private String  access_address;
	//访问用户名
	private String  access_user_name;
	//访问密码
	private String  access_password;
	
	
	
	
	public DeviceMaintenance() {
	}
	public int getDevice_id() {
		return device_id;
	}
	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}
	public String getDevice_manufacturer() {
		return device_manufacturer;
	}
	public void setDevice_manufacturer(String device_manufacturer) {
		this.device_manufacturer = device_manufacturer;
	}
	public String getDevice_brand() {
		return device_brand;
	}
	public void setDevice_brand(String device_brand) {
		this.device_brand = device_brand;
	}
	public String getDevice_model() {
		return device_model;
	}
	public void setDevice_model(String device_model) {
		this.device_model = device_model;
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
