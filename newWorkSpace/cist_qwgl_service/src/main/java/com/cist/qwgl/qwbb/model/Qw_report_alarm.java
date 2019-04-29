package com.cist.qwgl.qwbb.model;

import java.io.Serializable;
import java.util.Date;
/***
 * 接处警
 * @author wangtao
 *
 */
public class Qw_report_alarm implements Serializable{
	private static final long serialVersionUID = 1L;
    private Integer pk_id;//
    private Integer fk_police_team_id;//警组ID
    private String telephone;//值班电话
    private Integer fk_report_id;//勤务报备ID
    private Date work_start_time;//开始时间
    private Date work_end_time;//结束时间
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Integer getFk_police_team_id() {
		return fk_police_team_id;
	}
	public void setFk_police_team_id(Integer fk_police_team_id) {
		this.fk_police_team_id = fk_police_team_id;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getFk_report_id() {
		return fk_report_id;
	}
	public void setFk_report_id(Integer fk_report_id) {
		this.fk_report_id = fk_report_id;
	}
	public Date getWork_start_time() {
		return work_start_time;
	}
	public void setWork_start_time(Date work_start_time) {
		this.work_start_time = work_start_time;
	}
	public Date getWork_end_time() {
		return work_end_time;
	}
	public void setWork_end_time(Date work_end_time) {
		this.work_end_time = work_end_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Qw_report_alarm(Integer pk_id, Integer fk_police_team_id, String telephone, Integer fk_report_id,
			Date work_start_time, Date work_end_time) {
		super();
		this.pk_id = pk_id;
		this.fk_police_team_id = fk_police_team_id;
		this.telephone = telephone;
		this.fk_report_id = fk_report_id;
		this.work_start_time = work_start_time;
		this.work_end_time = work_end_time;
	}
	public Qw_report_alarm() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
