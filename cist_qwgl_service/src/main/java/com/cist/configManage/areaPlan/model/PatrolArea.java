package com.cist.configManage.areaPlan.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PatrolArea {
	// ID
	private long pk_id;
	// 管理部门ID
	private long fk_dept_id;
	// 管理部门ID
	private Long parent_area;
	// 区域名称
	private String area_name;
	// 巡区类别
	private char area_type;
	// 巡区类别
	private String geo_spatial;
	// 创建时间
	@JsonFormat(pattern = "yyyy-hh-dd HH:mm:ss")
	private Date privacreate_time;
	// 创建人
	private long create_person;

	private String area_type_name;
	private String fk_dept_name;
	
	
	
	private String title;
	private long key;
	private List<PatrolArea> children = null;
	private boolean selectable = true;
	private boolean isLeaf = false;
	private Long pk;
	
	private boolean isDept=false;

	
	public boolean getIsDept() {
		return isDept;
	}

	public void setIsDept(boolean isDept) {
		this.isDept = isDept;
	}

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public boolean getisLeaf() {
		if (null == children) {
			isLeaf = true;
		}else { if (children.size() == 0) {
			isLeaf = true;}}
		return isLeaf;
	}

	public void setisLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean getSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public long getKey() {
		return key;
	}

	public void setKey(long key) {
		this.key = key;
	}

	public List<PatrolArea> getChildren() {
		return children;
	}

	public void setChildren(List<PatrolArea> children) {
		this.children = children;
	}

	public PatrolArea() {
	}

	public long getPk_id() {
		return pk_id;
	}

	public void setPk_id(long pk_id) {
		this.pk_id = pk_id;
	}

	public long getFk_dept_id() {
		return fk_dept_id;
	}

	public void setFk_dept_id(long fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}

	public Long getParent_area() {
		return parent_area;
	}

	public void setParent_area(Long parent_area) {
		this.parent_area = parent_area;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public char getArea_type() {
		return area_type;
	}

	public void setArea_type(char area_type) {
		this.area_type = area_type;
	}

	public String getGeo_spatial() {
		return geo_spatial;
	}

	public void setGeo_spatial(String geo_spatial) {
		this.geo_spatial = geo_spatial;
	}

	public Date getPrivacreate_time() {
		return privacreate_time;
	}

	public void setPrivacreate_time(Date privacreate_time) {
		this.privacreate_time = privacreate_time;
	}

	public long getCreate_person() {
		return create_person;
	}

	public void setCreate_person(long create_person) {
		this.create_person = create_person;
	}

	public String getArea_type_name() {
		return area_type_name;
	}

	public void setArea_type_name(String area_type_name) {
		this.area_type_name = area_type_name;
	}

	public String getFk_dept_name() {
		return fk_dept_name;
	}

	public void setFk_dept_name(String fk_dept_name) {
		this.fk_dept_name = fk_dept_name;
	}

}
