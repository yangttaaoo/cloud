package com.cist.devmanagement.model;

import java.math.BigDecimal;

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
    private BigDecimal pk_id;//ID

    private String equipment_type;//终端类型，(参考SYS_FRM_CODE表 FCT_CODE=ZDLX)

    private String equipment_name;//设备名称

    private String dac_ip;//DAC设备IP

    private String equipment_aadr;//安装地址

    private String status;//审核状态（0：不通过1：通过 2:未审核）

    private String reasons;//不通过原因

	public BigDecimal getPk_id() {
		return pk_id;
	}

	public void setPk_id(BigDecimal pk_id) {
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

}