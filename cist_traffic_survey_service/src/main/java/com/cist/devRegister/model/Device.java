package com.cist.devRegister.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import com.cist.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
//5.2.设备审核过程(JCSJ_DEVICE_AUDIT_PROCESS)
public class Device implements  Serializable{
	private static final long serialVersionUID = 4637402333171498778L;
	// ID
	private int pk_id;
	// 部门ID
	private long fk_dept_id;
	// 创建人ID
	private int create_person;
	// 创建时间
	@JsonFormat(pattern="yyyy-MM-dd  HH:mm:ss")
	private Date create_time;
	// 启用日期
	@JsonFormat(pattern="yyyy-MM-dd  HH:mm:ss")
	private Date enable_date;
	// 有效期止
	@JsonFormat(pattern="yyyy-MM-dd  HH:mm:ss")
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
	private String longitude;
	// 纬度
	private String latitude;
	// 所在网络位置
	private char network_location;
	// 数据上传模式
	private char upload_mode;
	// 设备来源
	private char device_source;
	//方向
	private String direction;
	//行政区划代码
		private String xzqh;
	private int  td;
	private int  th;
	//设备厂商
	private String  device_manufacturer;
	//设备品牌
	private String  device_brand;
	//设备型号
	private String  device_model;
	//厂商联系人
	private String  maintenance_contacts_person;
	//联系人电话
	private String  maintenance_contacts_num;
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
	
	
	//
	private Integer device_id;
	// 审核人
	private String check_person_id;
	// 审核人部门
	private long check_person_dept_id;
	// 审核时间
	private Date check_time;
	// 审核状态（0：不同过，1：通过）
	private Character  check_status;
	// 不通过原因
	private String uncheck_reason;
	
	
	
	//是否审核
		private boolean  IsDevAudit;
	//审核人姓名
	private String check_person_dept_name;
	// 设备类型Name
	private String fk_device_type_name;
	
	
	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCheck_person_dept_name() {
		return SysTempStoreUtils.getDeptName1(check_person_dept_id);
	}

	public void setCheck_person_dept_name(String check_person_dept_name) {
		this.check_person_dept_name = check_person_dept_name;
	}

	
	/*private HashMap<String, Object> device_audit_state;*/
	
	
/*	public HashMap<String, Object> getDevice_audit_state() {
		
		return SysTempStoreUtils.IsDevAudit(pk_id);
	}
	public void setDevice_audit_state(HashMap<String, Object> device_audit_state) {
		this.device_audit_state = device_audit_state;
	}*/
	
	
	public boolean getIsDevAudit() {
		if(device_id==null) return false;
		 return true;
	}



	public void setIsDevAudit(boolean isDevAudit) {
		IsDevAudit = isDevAudit;
	}



	public String getFk_device_type_name() {
		return SysTempStoreUtils.getDeviceName(fk_device_type);
	}



	public void setFk_device_type_name(String fk_device_type_name) {
		this.fk_device_type_name = fk_device_type_name;
	}

	public Device() {
		
	}


	/*----设备基础信息GET与SET开始----*/
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







	



	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
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



	/*----设备基础信息GET与SET结束----*/
	/*----设备厂商信息GET与SET开始----*/



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



	public String getMaintenance_contacts_person() {
		return maintenance_contacts_person;
	}



	public void setMaintenance_contacts_person(String maintenance_contacts_person) {
		this.maintenance_contacts_person = maintenance_contacts_person;
	}



	public String getMaintenance_contacts_num() {
		return maintenance_contacts_num;
	}



	public void setMaintenance_contacts_num(String maintenance_contacts_num) {
		this.maintenance_contacts_num = maintenance_contacts_num;
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
	/*----设备厂商信息GET与SET结束----*/
	/*----设备审核信息GET与SET开始----*/



	public Integer getDevice_id() {
		return device_id;
	}



	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}


	public String getCheck_person_id() {
		return check_person_id;
	}



	public void setCheck_person_id(String check_person_id) {
		this.check_person_id = check_person_id;
	}



	public long getCheck_person_dept_id() {
		return check_person_dept_id;
	}



	public void setCheck_person_dept_id(long check_person_dept_id) {
		this.check_person_dept_id = check_person_dept_id;
	}



	public Date getCheck_time() {
		return check_time;
	}



	public void setCheck_time(Date check_time) {
		this.check_time = check_time;
	}






	public Character getCheck_status() {
		return check_status;
	}



	public void setCheck_status(Character check_status) {
		this.check_status = check_status;
	}



	public String getUncheck_reason() {
		return uncheck_reason;
	}



	public void setUncheck_reason(String uncheck_reason) {
		this.uncheck_reason = uncheck_reason;
	}

	public int getTd() {
		return td;
	}

	public void setTd(int td) {
		this.td = td;
	}

	public int getTh() {
		return th;
	}

	public void setTh(int th) {
		this.th = th;
	}

	/*----设备审核信息GET与SET结束----*/


}




































