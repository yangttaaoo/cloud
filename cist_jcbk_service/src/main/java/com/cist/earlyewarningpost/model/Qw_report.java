package com.cist.earlyewarningpost.model;

import java.io.Serializable;
import java.util.List;
/**
 * 	勤务报备
 * @author yangtao
 *
 */
public class Qw_report implements Serializable{
	private static final long serialVersionUID = 1L;
    private Integer pk_id;//
    private String fk_dept_id;//管理部门id
    private String fk_police_team_id;//警组id
    private String report_type;//报备类型（1：街面勤务；2：值班值守；3：接处警；4：轮休;5：机关）
    private String car_list_str;//警车、警车关联人员集合，存放json对象（冗余数据）
    private String personnel_list_str;//关联人员集合，存放人员类型、姓名、警号、呼号、电话号码json对象（冗余数据）
    private String report_period_type;//报备日期
    private String report_person_id;//报备人
    private String report_time;//报备时间 sysdate
	private String dept_name;//管理部门
    private Integer dept_pk;//部门id
    private String area_name;//区域名称
    private Integer fk_patrol_area_id;//区域id
    private Integer jingcheshu;//警车数量
    private Integer ren1;//车巡警员
    private Integer ren2;//步巡警员
    
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public Integer getDept_pk() {
		return dept_pk;
	}
	public void setDept_pk(Integer dept_pk) {
		this.dept_pk = dept_pk;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public Integer getFk_patrol_area_id() {
		return fk_patrol_area_id;
	}
	public void setFk_patrol_area_id(Integer fk_patrol_area_id) {
		this.fk_patrol_area_id = fk_patrol_area_id;
	}
	public Integer getJingcheshu() {
		return jingcheshu;
	}
	public void setJingcheshu(Integer jingcheshu) {
		this.jingcheshu = jingcheshu;
	}
	public Integer getRen1() {
		return ren1;
	}
	public void setRen1(Integer ren1) {
		this.ren1 = ren1;
	}
	public Integer getRen2() {
		return ren2;
	}
	public void setRen2(Integer ren2) {
		this.ren2 = ren2;
	}
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
	public String getFk_police_team_id() {
		return fk_police_team_id;
	}
	public void setFk_police_team_id(String fk_police_team_id) {
		this.fk_police_team_id = fk_police_team_id;
	}
	public String getReport_type() {
		return report_type;
	}
	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}
	public String getCar_list_str() {
		return car_list_str;
	}
	public void setCar_list_str(String car_list_str) {
		this.car_list_str = car_list_str;
	}
	public String getPersonnel_list_str() {
		return personnel_list_str;
	}
	public void setPersonnel_list_str(String personnel_list_str) {
		this.personnel_list_str = personnel_list_str;
	}
	public String getReport_period_type() {
		return report_period_type;
	}
	public void setReport_period_type(String report_period_type) {
		this.report_period_type = report_period_type;
	}
	public String getReport_person_id() {
		return report_person_id;
	}
	public void setReport_person_id(String report_person_id) {
		this.report_person_id = report_person_id;
	}
	public String getReport_time() {
		return report_time;
	}
	public void setReport_time(String report_time) {
		this.report_time = report_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Qw_report(Integer pk_id, String fk_dept_id, String fk_police_team_id, String report_type,
			String car_list_str, String personnel_list_str, String report_period_type, String report_person_id,
			String report_time) {
		super();
		this.pk_id = pk_id;
		this.fk_dept_id = fk_dept_id;
		this.fk_police_team_id = fk_police_team_id;
		this.report_type = report_type;
		this.car_list_str = car_list_str;
		this.personnel_list_str = personnel_list_str;
		this.report_period_type = report_period_type;
		this.report_person_id = report_person_id;
		this.report_time = report_time;
	}
	public Qw_report() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
