package com.cist.devmanagement.model;

import java.math.BigDecimal;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

/***
 * 
 * @Title:SssbEquipmentRegister.java
 * @Package:com.cist.devmanagement.model
 * @Description:设施设备注册
 * @author:YT
 * @date:2019年2月26日
 * @version V1.0
 */
public class SssbEquipmentRegister {
    private Integer pk_id;//ID

    private String equipment_type;//终端类型，(参考SYS_FRM_CODE表 FCT_CODE=ZDLX)

    private String equipment_name;//设备名称

    private String dac_ip;//DAC设备IP

    private String equipment_aadr;//安装地址

    private String status;//审核状态（0：不通过1：通过 2:未审核）

    private String reasons;//不通过原因
    
    private String statusName;//审核状态名称（0：不通过1：通过 2:未审核）
    
    private String equipment_model;//设备型号

    private String sblx;//设备类型，(参考SYS_FRM_CODE表 FCT_CODE=M001)
    
    private BigDecimal fk_dept_id;//管理单位

    private String charger_person;//负责人

    private String charger_contact_number;//联系电话

    private String ip_addr;//IP地址

    private String mac_addr;//MAC地址

    private String port;//端口

    private String description;//设备描述

    private String supplier;//供应商

    private String supplier_contact_number;//供应商联系电话
    
    private String sblxName;//设备类型名称
    
    private String fk_dept_name;//部门名称
    
    private String equipment_type_name;//终端类型名称，(参考SYS_FRM_CODE表 FCT_CODE=ZDLX)
    
    //PC终端多出的几个信息
    private String user_name;//使用人

    private String contact_number;//使用人电话

    private String dept_contact_number;//单位电话
    
    private String use_name;//使用人  使用人（电话）
    
    
    //设备信息
    
    private String device_name;//设备名称
    
    private String road_name;//道路名称
    

	public Integer getPk_id() {
		return pk_id;
	}

	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}

	public String getEquipment_type() {
		return equipment_type;
	}

	public void setEquipment_type(String equipment_type) {
		this.equipment_type = equipment_type;
	}

	public String getEquipment_name() {
		return equipment_name;
	}

	public void setEquipment_name(String equipment_name) {
		this.equipment_name = equipment_name;
	}

	public String getDac_ip() {
		return dac_ip;
	}

	public void setDac_ip(String dac_ip) {
		this.dac_ip = dac_ip;
	}

	public String getEquipment_aadr() {
		return equipment_aadr;
	}

	public void setEquipment_aadr(String equipment_aadr) {
		this.equipment_aadr = equipment_aadr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReasons() {
		return reasons;
	}

	public void setReasons(String reasons) {
		this.reasons = reasons;
	}

	public String getEquipment_model() {
		return equipment_model;
	}

	public void setEquipment_model(String equipment_model) {
		this.equipment_model = equipment_model;
	}

	public String getSblx() {
		return sblx;
	}

	public void setSblx(String sblx) {
		this.sblx = sblx;
	}

	public BigDecimal getFk_dept_id() {
		return fk_dept_id;
	}

	public void setFk_dept_id(BigDecimal fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}

	public String getCharger_person() {
		return charger_person;
	}

	public void setCharger_person(String charger_person) {
		this.charger_person = charger_person;
	}

	public String getCharger_contact_number() {
		return charger_contact_number;
	}

	public void setCharger_contact_number(String charger_contact_number) {
		this.charger_contact_number = charger_contact_number;
	}

	public String getIp_addr() {
		return ip_addr;
	}

	public void setIp_addr(String ip_addr) {
		this.ip_addr = ip_addr;
	}

	public String getMac_addr() {
		return mac_addr;
	}

	public void setMac_addr(String mac_addr) {
		this.mac_addr = mac_addr;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getSupplier_contact_number() {
		return supplier_contact_number;
	}

	public void setSupplier_contact_number(String supplier_contact_number) {
		this.supplier_contact_number = supplier_contact_number;
	}

	public String getSblxName() {
		if(sblx!=null) {
			sblxName = SysTempStoreUtils.getFcName(SysBaseDataCode.DEVICE_TYPE_CODE, sblx);
		}
		return sblxName;
	}

	public void setSblxName(String sblxName) {
		this.sblxName = sblxName;
	}

	public String getStatusName() {
		if("0".equals(status)) {
			statusName = "不通过";
		}else if("1".equals(status)) {
			statusName = "通过";
		}else {
			statusName = "未审核";
		}
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getFk_dept_name() {
		if(fk_dept_id!=null) {
			fk_dept_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT_PK, fk_dept_id.toString());
		}
		return fk_dept_name;
	}

	public void setFk_dept_name(String fk_dept_name) {
		this.fk_dept_name = fk_dept_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public String getDept_contact_number() {
		return dept_contact_number;
	}

	public void setDept_contact_number(String dept_contact_number) {
		this.dept_contact_number = dept_contact_number;
	}

	public String getUse_name() {
		use_name = user_name+"("+(contact_number==null?"未知":contact_number)+")";
		return use_name;
	}

	public void setUse_name(String use_name) {
		this.use_name = use_name;
	}

	public String getEquipment_type_name() {
		if(equipment_type !=null) {
			equipment_type_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_ZDLX, equipment_type);
		}
		return equipment_type_name;
	}

	public void setEquipment_type_name(String equipment_type_name) {
		this.equipment_type_name = equipment_type_name;
	}

	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

	public String getRoad_name() {
		return road_name;
	}

	public void setRoad_name(String road_name) {
		this.road_name = road_name;
	}

}