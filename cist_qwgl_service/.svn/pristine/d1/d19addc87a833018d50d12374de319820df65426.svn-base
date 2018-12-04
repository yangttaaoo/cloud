package com.cist.qwgl.qwbb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 	警组信息
 *
 */
public class Qw_police_team implements Serializable{
	private static final long serialVersionUID = 7358217240965000889L;
    private Integer pk_id;//id
    private String fk_dept_id;//管理部门id
    private String police_team_name;//警组名称
    private String report_type;//报备类型（1：街面勤务；2：值班值守；3：接处警；4：机关工作）
    private String create_person_id;//创建人
    private String create_time;//创建时间
    private Sysfrmcode sysfrmcode;//报备类型（1：街面勤务；2：值班值守；3：接处警；4：机关工作）
    private Qw_police_team_street qw_police_team_street;//警组-街面勤务
    private List<Qw_walk_patrol_relation> qw_walk_patrol_relation;//步巡关联人员信息
    private Qw_equip_info qw_equip_info;//9.14.	装备信息
    private List<Qw_car_patrol_info> qw_car_patrol_info;//9.3.	车巡信息
    private Qw_police_team_duty qw_police_team_duty;//9.6.	警组-值班值守
    
	public Qw_police_team_duty getQw_police_team_duty() {
		return qw_police_team_duty;
	}
	public void setQw_police_team_duty(Qw_police_team_duty qw_police_team_duty) {
		this.qw_police_team_duty = qw_police_team_duty;
	}
	public List<Qw_car_patrol_info> getQw_car_patrol_info() {
		return qw_car_patrol_info;
	}
	public void setQw_car_patrol_info(List<Qw_car_patrol_info> qw_car_patrol_info) {
		this.qw_car_patrol_info = qw_car_patrol_info;
	}
	public Qw_equip_info getQw_equip_info() {
		return qw_equip_info;
	}
	public void setQw_equip_info(Qw_equip_info qw_equip_info) {
		this.qw_equip_info = qw_equip_info;
	}
	public List<Qw_walk_patrol_relation> getQw_walk_patrol_relation() {
		return qw_walk_patrol_relation;
	}
	public void setQw_walk_patrol_relation(List<Qw_walk_patrol_relation> qw_walk_patrol_relation) {
		this.qw_walk_patrol_relation = qw_walk_patrol_relation;
	}
	public Qw_police_team_street getQw_police_team_street() {
		return qw_police_team_street;
	}
	public void setQw_police_team_street(Qw_police_team_street qw_police_team_street) {
		this.qw_police_team_street = qw_police_team_street;
	}
	public Sysfrmcode getSysfrmcode() {
		return sysfrmcode;
	}
	public void setSysfrmcode(Sysfrmcode sysfrmcode) {
		this.sysfrmcode = sysfrmcode;
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
	public String getPolice_team_name() {
		return police_team_name;
	}
	public void setPolice_team_name(String police_team_name) {
		this.police_team_name = police_team_name;
	}
	public String getReport_type() {
		return report_type;
	}
	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}
	public String getCreate_person_id() {
		return create_person_id;
	}
	public void setCreate_person_id(String create_person_id) {
		this.create_person_id = create_person_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Qw_police_team() {
		super();
	}
   
}
