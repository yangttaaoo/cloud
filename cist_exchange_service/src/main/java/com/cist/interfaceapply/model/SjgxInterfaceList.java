package com.cist.interfaceapply.model;

import java.math.BigDecimal;

public class SjgxInterfaceList {
    private Integer pk_id;//ID

    private Integer interface_id;//接口ID
    
    private String fk_use_apply_id;//接口ID

    private String interface_name;//接口名称

    private Integer connect_limit;//访问限制

    private Integer dev_company_id;//软件开发单位

    private String dev_company_name;//单位名称

	public Integer getPk_id() {
		return pk_id;
	}

	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}

	public Integer getInterface_id() {
		return interface_id;
	}

	public void setInterface_id(Integer interface_id) {
		this.interface_id = interface_id;
	}

	public String getInterface_name() {
		return interface_name;
	}

	public void setInterface_name(String interface_name) {
		this.interface_name = interface_name;
	}

	public Integer getConnect_limit() {
		return connect_limit;
	}

	public void setConnect_limit(Integer connect_limit) {
		this.connect_limit = connect_limit;
	}

	public Integer getDev_company_id() {
		return dev_company_id;
	}

	public void setDev_company_id(Integer dev_company_id) {
		this.dev_company_id = dev_company_id;
	}

	public String getDev_company_name() {
		return dev_company_name;
	}

	public void setDev_company_name(String dev_company_name) {
		this.dev_company_name = dev_company_name;
	}

	public String getFk_use_apply_id() {
		return fk_use_apply_id;
	}

	public void setFk_use_apply_id(String fk_use_apply_id) {
		this.fk_use_apply_id = fk_use_apply_id;
	}

}