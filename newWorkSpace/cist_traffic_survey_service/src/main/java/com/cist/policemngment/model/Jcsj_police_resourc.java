package com.cist.policemngment.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

/**
 * 警务资源信息-车辆、设备
 * @author Administrator
 *
 */
public class Jcsj_police_resourc implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pk_id;//ID
	private Long fk_dept_id;//管理部门ID
	private String fk_dept_name;
	private Integer create_person;//创建人ID
	private Date create_time;//创建时间
	private Date enable_date;//启用日期
	private Date validity_date;//有效期止
	private String validity_date_name;
	private String resources_type;//资源类型（1：警车；2：GPS；3：350M）
	private String car_type;//车辆类型
	private String car_type_name;//车辆类型
	private String car_brand;//车辆品牌
	private String car_brand_name;//车辆品牌名称
	private String car_num;//号牌号码
	private String car_purpose;//车辆用途
	private Date annual_inspection_valid;//年检有效期
	private String insurance_company;//保险公司
	private String insurance_num;//保单号
	private String device_type;//设备名称
	private String device_model;//设备型号
	private String device_code;//设备型号
	private String manufacturer;//生成厂商
	private String  staff_name;//维护人
	private String staff_contacts_num ;//维护人电话
	private String  sim_num;//SIM卡号
	private String call_num;//呼号
	private String hb_car_type;//电瓶车类型（当RESOURCES_TYPE=6时有效）
	
	private String car_purpose_name;//车辆用途名称
	private String hphm;//号牌号码
	
	private String clpp;//车辆品牌
	
	private String xm;//350和警务通关联人员姓名
	
	private String rybh;//350和警务通关联人员编号
	
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Long getFk_dept_id() {
		return fk_dept_id;
	}
	public void setFk_dept_id(Long fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}
	public Integer getCreate_person() {
		return create_person;
	}
	public void setCreate_person(Integer create_person) {
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

	public String getResources_type() {
		return resources_type;
	}
	public void setResources_type(String resources_type) {
		this.resources_type = resources_type;
	}
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	public String getCar_brand() {
		return car_brand;
	}
	public void setCar_brand(String car_brand) {
		this.car_brand = car_brand;
	}
	public String getCar_num() {
		return car_num;
	}
	public void setCar_num(String car_num) {
		this.car_num = car_num;
	}
	public String getCar_purpose() {
		return car_purpose;
	}
	public void setCar_purpose(String car_purpose) {
		this.car_purpose = car_purpose;
	}
	public Date getAnnual_inspection_valid() {
		return annual_inspection_valid;
	}
	public void setAnnual_inspection_valid(Date annual_inspection_valid) {
		this.annual_inspection_valid = annual_inspection_valid;
	}
	public String getInsurance_company() {
		return insurance_company;
	}
	public void setInsurance_company(String insurance_company) {
		this.insurance_company = insurance_company;
	}
	public String getInsurance_num() {
		return insurance_num;
	}
	public void setInsurance_num(String insurance_num) {
		this.insurance_num = insurance_num;
	}
	public String getDevice_type() {
		return device_type;
	}
	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	public String getDevice_model() {
		return device_model;
	}
	public void setDevice_model(String device_model) {
		this.device_model = device_model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getStaff_contacts_num() {
		return staff_contacts_num;
	}
	public void setStaff_contacts_num(String staff_contacts_num) {
		this.staff_contacts_num = staff_contacts_num;
	}
	public String getCall_num() {
		return call_num;
	}
	public void setCall_num(String call_num) {
		this.call_num = call_num;
	}
	public Date getValidity_date() {
		return validity_date;
	}
	public void setValidity_date(Date validity_date) {
		this.validity_date = validity_date;
	}
	public String getSim_num() {
		return sim_num;
	}
	public void setSim_num(String sim_num) {
		this.sim_num = sim_num;
	}
	public String getCar_brand_name() {
		
		if(car_brand != null){
			String car_brand_replace = car_brand.replace(" ", "");
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CLPP, car_brand_replace);
		}
		return car_brand_name;
	}
	public void setCar_brand_name(String car_brand_name) {
		this.car_brand_name = car_brand_name;
	}
	public String getCar_type_name() {
		if(car_type != null){
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CLLX, car_type);
		}
		return car_type_name;
	}
	public void setCar_type_name(String car_type_name) {
		this.car_type_name = car_type_name;
	}
	public String getHb_car_type() {
		return hb_car_type;
	}
	public void setHb_car_type(String hb_car_type) {
		this.hb_car_type = hb_car_type;
	}
	public String getValidity_date_name() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		validity_date_name = sdf.format(this.validity_date);
		return validity_date_name;
	}
	public void setValidity_date_name(String validity_date_name) {
		this.validity_date_name = validity_date_name;
	}
	
	public String getFk_dept_name() {
		if(fk_dept_id!=null){
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT_PK, fk_dept_id.toString());
		}
		return fk_dept_name;
	}
	public void setFk_dept_name(String fk_dept_name) {
		this.fk_dept_name = fk_dept_name;
	}
	public String getCar_purpose_name() {
		if(car_purpose!=null){
			car_purpose_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_CLYT1, car_purpose);
		}else{
			return "未知";
		}
		return car_purpose_name;
	}
	public void setCar_purpose_name(String car_purpose_name) {
		this.car_purpose_name = car_purpose_name;
	}
	public String getHphm() {
		return hphm;
	}
	public void setHphm(String hphm) {
		this.hphm = hphm;
	}
	public String getClpp() {
		return clpp;
	}
	public void setClpp(String clpp) {
		this.clpp = clpp;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getRybh() {
		return rybh;
	}
	public void setRybh(String rybh) {
		this.rybh = rybh;
	}
	public String getDevice_code() {
		return device_code;
	}
	public void setDevice_code(String device_code) {
		this.device_code = device_code;
	}
	
	
	
	
	
}
