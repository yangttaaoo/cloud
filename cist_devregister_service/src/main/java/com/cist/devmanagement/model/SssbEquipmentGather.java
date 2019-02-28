package com.cist.devmanagement.model;

import java.math.BigDecimal;


/***
 * 
 * @Title:SssbEquipmentGather.java
 * @Package:com.cist.devmanagement.model
 * @Description:采集设备信息
 * @author:YT
 * @date:2019年2月26日
 * @version V1.0
 */
public class SssbEquipmentGather {
    private BigDecimal fk_equipment_id;//设施设备ID

    private String equipment_mmodel;//设备型号

    private String equipment_type;//设备类型，(参考SYS_FRM_CODE表 FCT_CODE=M001)

    private BigDecimal fk_dept_id;//管理单位

    private String charger_person;//负责人

    private String charger_contact_number;//联系电话

    private String ip_addr;//IP地址

    private String mac_addr;//MAC地址

    private String port;//端口

    private String description;//设备描述

    private String supplier;//供应商

    private String supplier_contact_number;//供应商联系电话

	public BigDecimal getFk_equipment_id() {
		return fk_equipment_id;
	}

	public void setFk_equipment_id(BigDecimal fk_equipment_id) {
		this.fk_equipment_id = fk_equipment_id;
	}

	public String getEquipment_mmodel() {
		return equipment_mmodel;
	}

	public void setEquipment_mmodel(String equipment_mmodel) {
		this.equipment_mmodel = equipment_mmodel;
	}

	public String getEquipment_type() {
		return equipment_type;
	}

	public void setEquipment_type(String equipment_type) {
		this.equipment_type = equipment_type;
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
	
}