package com.cist.keyarea.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ZhddHotArea {
    private BigDecimal pk_id;//ID

    private BigDecimal fk_dept_id;//部门ID

    private BigDecimal fk_create_founder_id;//创建人ID

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_time;//创建时间

    private String area_name;//区域名称

    private String hot_area;//重点区域
    
    private String area_desc;//区域描述
    
    private String sypi_name;//用户名称
    
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

	public BigDecimal getFk_create_founder_id() {
		return fk_create_founder_id;
	}

	public void setFk_create_founder_id(BigDecimal fk_create_founder_id) {
		this.fk_create_founder_id = fk_create_founder_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public String getHot_area() {
		return hot_area;
	}

	public void setHot_area(String hot_area) {
		this.hot_area = hot_area;
	}

	public String getArea_desc() {
		return area_desc;
	}

	public void setArea_desc(String area_desc) {
		this.area_desc = area_desc;
	}

	public String getSypi_name() {
		return sypi_name;
	}

	public void setSypi_name(String sypi_name) {
		this.sypi_name = sypi_name;
	}

}