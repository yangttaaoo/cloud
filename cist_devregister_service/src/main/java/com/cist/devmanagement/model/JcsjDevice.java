package com.cist.devmanagement.model;

import java.math.BigDecimal;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;


/***
 * 
 * @Title:JcsjDevice.java
 * @Package:com.cist.devmanagement.model
 * @Description:设备信息
 * @author:YT
 * @date:2019年3月8日
 * @version V1.0
 */
public class JcsjDevice {
    private BigDecimal pk_id;//ID

    private BigDecimal fk_dept_id;//部门ID

    private BigDecimal create_person;//创建人ID

    private Date create_time;//创建时间

    private Date enable_date;//启用日期

    private String contacts_person;//责任人

    private String contacts_num;//责任人联系电话

    private String remarks;//备注

    private String fk_device_type;//设备类型(参考SYS_FRM_CODE表 FCT_CODE=M001)

    private String device_name;//设备名称

    private String device_num;//设备编号

    private BigDecimal belonged_road_id;//所属道路ID

    private BigDecimal kilometre_num;//公里数/路口号

    private BigDecimal meter_num;//米数

    private String road_name;//道路名称

    private BigDecimal longitude;//经度

    private BigDecimal latitude;//纬度

    private String network_location;//所在网络位置（公安网、专网）

    private String upload_mode;//数据上传模式（直接上传、管理平台上传、第三方系统转发上传）

    private String device_source;//设备来源（交警自建、大公安、交通部门、其他部门）

    private String direction;//方向

    private String xzqh;//行政区划代码

    private Date validity_date;//有效期止
    
    private String fk_device_type_name;//设备类型名称
    
    private String ip_address;//IP地址

	public BigDecimal getPk_id() {
		return pk_id;
	}

	public void setPk_id(BigDecimal pk_id) {
		this.pk_id = pk_id;
	}

	public BigDecimal getFk_dept_id() {
		return fk_dept_id;
	}

	public void setFk_dept_id(BigDecimal fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}

	public BigDecimal getCreate_person() {
		return create_person;
	}

	public void setCreate_person(BigDecimal create_person) {
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

	public BigDecimal getBelonged_road_id() {
		return belonged_road_id;
	}

	public void setBelonged_road_id(BigDecimal belonged_road_id) {
		this.belonged_road_id = belonged_road_id;
	}

	public BigDecimal getKilometre_num() {
		return kilometre_num;
	}

	public void setKilometre_num(BigDecimal kilometre_num) {
		this.kilometre_num = kilometre_num;
	}

	public BigDecimal getMeter_num() {
		return meter_num;
	}

	public void setMeter_num(BigDecimal meter_num) {
		this.meter_num = meter_num;
	}

	public String getRoad_name() {
		return road_name;
	}

	public void setRoad_name(String road_name) {
		this.road_name = road_name;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public String getNetwork_location() {
		return network_location;
	}

	public void setNetwork_location(String network_location) {
		this.network_location = network_location;
	}

	public String getUpload_mode() {
		return upload_mode;
	}

	public void setUpload_mode(String upload_mode) {
		this.upload_mode = upload_mode;
	}

	public String getDevice_source() {
		return device_source;
	}

	public void setDevice_source(String device_source) {
		this.device_source = device_source;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public Date getValidity_date() {
		return validity_date;
	}

	public void setValidity_date(Date validity_date) {
		this.validity_date = validity_date;
	}

	public String getFk_device_type_name() {
		if(fk_device_type!=null) {
			fk_device_type_name = SysTempStoreUtils.getFcName(SysBaseDataCode.DEVICE_TYPE_CODE, fk_device_type);
		}
		return fk_device_type_name;
	}

	public void setFk_device_type_name(String fk_device_type_name) {
		this.fk_device_type_name = fk_device_type_name;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

}