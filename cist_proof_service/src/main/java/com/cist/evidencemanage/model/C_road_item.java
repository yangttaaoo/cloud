package com.cist.evidencemanage.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * 道路基础信息
 * @author Administrator
 *
 */
public class C_road_item {
	private Integer roim_pk;
	private String dept_code;
	private String roim_code;
	private String tbek_code;
	private  String  roim_name;
	private  String	roim_type;
	private List<C_road_item> children=null;
	
	private BigDecimal belonged_road_id;//所属道路id

    private BigDecimal kilometre_num;//公里数
    
    private String device_name;//设备名称
    
	public Integer getRoim_pk() {
		return roim_pk;
	}
	public void setRoim_pk(Integer roim_pk) {
		this.roim_pk = roim_pk;
	}
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}
	public String getRoim_code() {
		return roim_code;
	}
	public void setRoim_code(String roim_code) {
		this.roim_code = roim_code;
	}
	public String getTbek_code() {
		return tbek_code;
	}
	public void setTbek_code(String tbek_code) {
		this.tbek_code = tbek_code;
	}
	public String getRoim_name() {
		return roim_name;
	}
	public void setRoim_name(String roim_name) {
		this.roim_name = roim_name;
	}
	public String getRoim_type() {
		return roim_type;
	}
	public void setRoim_type(String roim_type) {
		this.roim_type = roim_type;
	}
	public List<C_road_item> getChildren() {
		return children;
	}
	public void setChildren(List<C_road_item> children) {
		this.children = children;
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
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}


	
	
}
