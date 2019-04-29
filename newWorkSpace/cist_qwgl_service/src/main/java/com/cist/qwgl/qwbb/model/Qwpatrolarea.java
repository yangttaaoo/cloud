package com.cist.qwgl.qwbb.model;

import java.io.Serializable;
/***
 * 巡区信息
 * @author wangtao
 *
 */
public class Qwpatrolarea implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer pk_id;//id
	private String fk_dept_id;//管理部门ID
	private String parent_area;//上级区域
	private String area_name;//区域名称
	private String area_type;//巡区类别
	private String geo_spatial;//空间信息
	private String create_time;//创建时间
	private String create_person;//创建人
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public String getFk_dept_id() {
		return fk_dept_id;
	}
	public void setFk_dept_id(String fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}
	public String getParent_area() {
		return parent_area;
	}
	public void setParent_area(String parent_area) {
		this.parent_area = parent_area;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public String getArea_type() {
		return area_type;
	}
	public void setArea_type(String area_type) {
		this.area_type = area_type;
	}
	public String getGeo_spatial() {
		return geo_spatial;
	}
	public void setGeo_spatial(String geo_spatial) {
		this.geo_spatial = geo_spatial;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getCreate_person() {
		return create_person;
	}
	public void setCreate_person(String create_person) {
		this.create_person = create_person;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Qwpatrolarea(Integer pk_id, String fk_dept_id, String parent_area, String area_name, String area_type,
			String geo_spatial, String create_time, String create_person) {
		super();
		this.pk_id = pk_id;
		this.fk_dept_id = fk_dept_id;
		this.parent_area = parent_area;
		this.area_name = area_name;
		this.area_type = area_type;
		this.geo_spatial = geo_spatial;
		this.create_time = create_time;
		this.create_person = create_person;
	}
	public Qwpatrolarea() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
