package com.cist.qwgl.qwjg.model;

import java.io.Serializable;

public class Onduty  implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer pk_id;
	private Integer fk_event_id;
	private Integer fk_event_dispatch_id;
	private Integer fk_person_id;
	private String fk_report_id;
	private String fk_user_id;
	private String user_type;
	private String report_period_type;
	private String rybh;
	private String xm;
	private String event_describe;
	private String work_shift_start_time;
	private String work_shift_end_time;
	private String  dispatch_time;
	private String  area_name;
	private String  police_team_name;
	private String  armed_forces_type;
	private String  armed_forces_name;
	
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public String getPolice_team_name() {
		return police_team_name;
	}
	public void setPolice_team_name(String police_team_name) {
		this.police_team_name = police_team_name;
	}
	public String getArmed_forces_type() {
		return armed_forces_type;
	}
	public void setArmed_forces_type(String armed_forces_type) {
		this.armed_forces_type = armed_forces_type;
	}
	public String getArmed_forces_name() {
		if(null!=armed_forces_type) {
			if(armed_forces_type.equals("1")) {
				return "武装";
			}
			if(armed_forces_type.equals("2")) {
				return "非武装";
			}
		}
		
		return armed_forces_name;
	}
	public void setArmed_forces_name(String armed_forces_name) {
		this.armed_forces_name = armed_forces_name;
	}
	public String getEvent_describe() {
		return event_describe;
	}
	public void setEvent_describe(String event_describe) {
		this.event_describe = event_describe;
	}
	public Integer getFk_event_id() {
		return fk_event_id;
	}
	public void setFk_event_id(Integer fk_event_id) {
		this.fk_event_id = fk_event_id;
	}
	public Integer getFk_event_dispatch_id() {
		return fk_event_dispatch_id;
	}
	public void setFk_event_dispatch_id(Integer fk_event_dispatch_id) {
		this.fk_event_dispatch_id = fk_event_dispatch_id;
	}
	public Integer getFk_person_id() {
		return fk_person_id;
	}
	public void setFk_person_id(Integer fk_person_id) {
		this.fk_person_id = fk_person_id;
	}
	public String getDispatch_time() {
		return dispatch_time;
	}
	public void setDispatch_time(String dispatch_time) {
		this.dispatch_time = dispatch_time;
	}
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public String getFk_report_id() {
		return fk_report_id;
	}
	public void setFk_report_id(String fk_report_id) {
		this.fk_report_id = fk_report_id;
	}
	public String getFk_user_id() {
		return fk_user_id;
	}
	public void setFk_user_id(String fk_user_id) {
		this.fk_user_id = fk_user_id;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getReport_period_type() {
		return report_period_type;
	}
	public void setReport_period_type(String report_period_type) {
		this.report_period_type = report_period_type;
	}
	public String getRybh() {
		return rybh;
	}
	public void setRybh(String rybh) {
		this.rybh = rybh;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getWork_shift_start_time() {
		return work_shift_start_time;
	}
	public void setWork_shift_start_time(String work_shift_start_time) {
		this.work_shift_start_time = work_shift_start_time;
	}
	public String getWork_shift_end_time() {
		return work_shift_end_time;
	}
	public void setWork_shift_end_time(String work_shift_end_time) {
		this.work_shift_end_time = work_shift_end_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Onduty() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
