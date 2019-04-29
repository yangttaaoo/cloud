package com.cist.qwgl.qwbb.model;

import java.io.Serializable;
import java.util.List;

import com.cist.qwgl.qwjg.model.Qw_patrol_alarm_log;
/**
 * 9.18.	勤务报备
 * @author wangtao
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
    private Qw_equip_info qw_equip_info;//装备信息
    private Qw_report_street qw_report_street;//9.19.	街面勤务报备
    private  Qw_police_team qw_police_team;//警组
    private Qw_report_duty qw_report_duty;//9.23.	值班值守报备
    private Qw_report_alarm qw_report_alarm;//接处警报备
    private Qw_report_office qw_report_office;//9.29.	机关工作报备
    private Qw_report_office qw_report_rest;//9.27.	轮休报备
    private List<Qw_report_car_patrol> qw_report_car_patrol;//9.20.	车巡报备
    private List<Qw_report_walk_relation> qw_report_walk_relation;//9.22.	步巡关联人员报备
    private Qw_patrol_alarm_log  qw_patrol_alarm_log;//勤务异常信息
    private boolean checked=false;
	private String dept_name;//管理部门
    private Integer dept_pk;//部门id
    private String area_name;//区域名称
    private Integer fk_patrol_area_id;//区域id
    private Integer jingcheshu;//警车数量
    private Integer ren1;//车巡警员
    private Integer ren2;//步巡警员
	private Integer jczxl;//
    private Integer jyzxl;//
    public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Qw_patrol_alarm_log getQw_patrol_alarm_log() {
		return qw_patrol_alarm_log;
	}

	public void setQw_patrol_alarm_log(Qw_patrol_alarm_log qw_patrol_alarm_log) {
		this.qw_patrol_alarm_log = qw_patrol_alarm_log;
	}



    
    public Integer getJczxl() {
		return jczxl;
	}

	public void setJczxl(Integer jczxl) {
		this.jczxl = jczxl;
	}

	public Integer getJyzxl() {
		return jyzxl;
	}

	public void setJyzxl(Integer jyzxl) {
		this.jyzxl = jyzxl;
	}


	private String police_team_name;//警组名称
	
	public String getPolice_team_name() {
		return police_team_name;
	}

	public void setPolice_team_name(String police_team_name) {
		this.police_team_name = police_team_name;
	}

	public List<Qw_report_walk_relation> getQw_report_walk_relation() {
		return qw_report_walk_relation;
	}

	public void setQw_report_walk_relation(List<Qw_report_walk_relation> qw_report_walk_relation) {
		this.qw_report_walk_relation = qw_report_walk_relation;
	}

	public List<Qw_report_car_patrol> getQw_report_car_patrol() {
		return qw_report_car_patrol;
	}

	public void setQw_report_car_patrol(List<Qw_report_car_patrol> qw_report_car_patrol) {
		this.qw_report_car_patrol = qw_report_car_patrol;
	}

	

    
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
	public Qw_report_office getQw_report_rest() {
		return qw_report_rest;
	}
	public void setQw_report_rest(Qw_report_office qw_report_rest) {
		this.qw_report_rest = qw_report_rest;
	}
	public Qw_report_office getQw_report_office() {
		return qw_report_office;
	}
	public void setQw_report_office(Qw_report_office qw_report_office) {
		this.qw_report_office = qw_report_office;
	}
	public Qw_report_alarm getQw_report_alarm() {
		return qw_report_alarm;
	}
	public void setQw_report_alarm(Qw_report_alarm qw_report_alarm) {
		this.qw_report_alarm = qw_report_alarm;
	}
	public Qw_report_duty getQw_report_duty() {
		return qw_report_duty;
	}
	public void setQw_report_duty(Qw_report_duty qw_report_duty) {
		this.qw_report_duty = qw_report_duty;
	}
	public Qw_police_team getQw_police_team() {
		return qw_police_team;
	}
	public void setQw_police_team(Qw_police_team qw_police_team) {
		this.qw_police_team = qw_police_team;
	}
	public Qw_report_street getQw_report_street() {
		return qw_report_street;
	}
	public void setQw_report_street(Qw_report_street qw_report_street) {
		this.qw_report_street = qw_report_street;
	}
	public Qw_equip_info getQw_equip_info() {
		return qw_equip_info;
	}
	public void setQw_equip_info(Qw_equip_info qw_equip_info) {
		this.qw_equip_info = qw_equip_info;
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
