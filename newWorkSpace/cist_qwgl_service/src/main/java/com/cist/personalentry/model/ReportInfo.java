package com.cist.personalentry.model;

import java.io.Serializable;

public class ReportInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer pk_id;//勤务报备id
	private Integer fk_user_id;//报备警员id
	private String sypi_name;//警员名称
	private String report_date;//报备日期
	private String start_date;//报备班次（开始）
	private String end_date;//报备班次（结束）
	private char report_type;//报备类型（1：街面勤务；2：值班值守；3：接处警；5：机关） 
	private String report_type_name;//报备类型中文名称
	private String area_name;//巡逻区域（只有街面勤务有）
	private Integer fk_patrol_area_id;//巡逻区域id
	private char armed_forces_type;//是否配枪（只有街面勤务有）
	private String dept_name;//管理部门
	
	private String rybh;
	
	public String getRybh() {
		return rybh;
	}
	public void setRybh(String rybh) {
		this.rybh = rybh;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setReport_type_name(String report_type_name) {
		this.report_type_name = report_type_name;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public Integer getFk_patrol_area_id() {
		return fk_patrol_area_id;
	}
	public void setFk_patrol_area_id(Integer fk_patrol_area_id) {
		this.fk_patrol_area_id = fk_patrol_area_id;
	}
	public String getSypi_name() {
		return sypi_name;
	}
	public void setSypi_name(String sypi_name) {
		this.sypi_name = sypi_name;
	}
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Integer getFk_user_id() {
		return fk_user_id;
	}
	public void setFk_user_id(Integer fk_user_id) {
		this.fk_user_id = fk_user_id;
	}
	public String getReport_date() {
		return report_date;
	}
	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public char getReport_type() {
		return report_type;
	}
	public void setReport_type(char report_type) {
		this.report_type = report_type;
		this.setReport_type_name(report_type);
	}
	public String getReport_type_name() {
		return report_type_name;
	}
	public void setReport_type_name(char report_type_name) {
		if(report_type_name == '1'){
			this.report_type_name = "街面勤务";
		}else if(report_type_name == '2'){
			this.report_type_name = "值班值守";
		}else if(report_type_name == '3'){
			this.report_type_name = "接处警";
		}else if(report_type_name == '4'){
			this.report_type_name = "轮休报备";
		}else if(report_type_name == '5'){
			this.report_type_name = "机关工作";
		}
		
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public char getArmed_forces_type() {
		return armed_forces_type;
	}
	public void setArmed_forces_type(char armed_forces_type) {
		this.armed_forces_type = armed_forces_type;
	}
	
	
}
