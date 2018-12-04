package com.cist.personageassess.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 勤务报备
 * 
 * @author Hy
 *
 */
public class Qw_report implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 9073487168912423433L;
	private Integer pk_id;// ID
	private Integer fk_dept_id;// 管理部门ID
	private String fk_police_team_id;// 警组ID
	private String report_type;// 报备类型（1：街面勤务；2：值班值守；3：接处警；4：轮休;5：机关）
	private Integer report_person_id;// 报备人
	private Date report_time;// 报备时间
	private Date report_period_type;// 报备日期
	private String car_list_str;// 警车、警车关联人员集合，存放json对象（冗余数据）
	private String personnel_list_str;// 关联人员集合，存放人员类型、姓名、警号、呼号、电话号码json对象（冗余数据）

	public Integer getPk_id() {
		return pk_id;
	}

	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}

	public Integer getFk_dept_id() {
		return fk_dept_id;
	}

	public void setFk_dept_id(Integer fk_dept_id) {
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

	public Integer getReport_person_id() {
		return report_person_id;
	}

	public void setReport_person_id(Integer report_person_id) {
		this.report_person_id = report_person_id;
	}

	public Date getReport_time() {
		return report_time;
	}

	public void setReport_time(Date report_time) {
		this.report_time = report_time;
	}

	public Date getReport_period_type() {
		return report_period_type;
	}

	public void setReport_period_type(Date report_period_type) {
		this.report_period_type = report_period_type;
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

}
