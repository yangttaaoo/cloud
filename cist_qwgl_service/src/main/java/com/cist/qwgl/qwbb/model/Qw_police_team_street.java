package com.cist.qwgl.qwbb.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 	警组信息
 *
 */
public class Qw_police_team_street implements Serializable{
	private static final long serialVersionUID = 7358217240965000889L;
    private Integer pk_id;//id
    private String fk_police_team_id;//警组ID
    private String patrol_control_type;//巡控类型（1：车巡；2：步巡；3：车巡+步巡）
    private String armed_forces_type;//武装类型（1：武装；2：非武装）
    private String dressing_type;//着装类型（1：制服；2：便衣）
    private String fk_patrol_area_id;//巡区ID
    private String fk_work_shift_id;//班次ID
    private String work_shift_name;//班次名称（冗余数据）
    private String work_shift_start_time;//班次开始时间（冗余数据）
    private String work_shift_end_time;//班次结束时间（冗余数据）
    private String span_cycle;//班次跨越周期（冗余数据）
    private String channel_num;//频道号
    private String carll_num;//呼号
    private String telephone;//值班电话
    private Qwgl_bc_info qwgl_bc_info;//班次
    private Qwpatrolarea qwpatrolarea;//巡区
    
	public Qwpatrolarea getQwpatrolarea() {
		return qwpatrolarea;
	}
	public void setQwpatrolarea(Qwpatrolarea qwpatrolarea) {
		this.qwpatrolarea = qwpatrolarea;
	}
	public Qwgl_bc_info getQwgl_bc_info() {
		return qwgl_bc_info;
	}
	public void setQwgl_bc_info(Qwgl_bc_info qwgl_bc_info) {
		this.qwgl_bc_info = qwgl_bc_info;
	}
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public String getFk_police_team_id() {
		return fk_police_team_id;
	}
	public void setFk_police_team_id(String fk_police_team_id) {
		this.fk_police_team_id = fk_police_team_id;
	}
	public String getPatrol_control_type() {
		return patrol_control_type;
	}
	public void setPatrol_control_type(String patrol_control_type) {
		this.patrol_control_type = patrol_control_type;
	}
	public String getArmed_forces_type() {
		return armed_forces_type;
	}
	public void setArmed_forces_type(String armed_forces_type) {
		this.armed_forces_type = armed_forces_type;
	}
	public String getDressing_type() {
		return dressing_type;
	}
	public void setDressing_type(String dressing_type) {
		this.dressing_type = dressing_type;
	}
	public String getFk_patrol_area_id() {
		return fk_patrol_area_id;
	}
	public void setFk_patrol_area_id(String fk_patrol_area_id) {
		this.fk_patrol_area_id = fk_patrol_area_id;
	}
	public String getFk_work_shift_id() {
		return fk_work_shift_id;
	}
	public void setFk_work_shift_id(String fk_work_shift_id) {
		this.fk_work_shift_id = fk_work_shift_id;
	}
	public String getWork_shift_name() {
		return work_shift_name;
	}
	public void setWork_shift_name(String work_shift_name) {
		this.work_shift_name = work_shift_name;
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
	public String getSpan_cycle() {
		return span_cycle;
	}
	public void setSpan_cycle(String span_cycle) {
		this.span_cycle = span_cycle;
	}
	public String getChannel_num() {
		return channel_num;
	}
	public void setChannel_num(String channel_num) {
		this.channel_num = channel_num;
	}
	public String getCarll_num() {
		return carll_num;
	}
	public void setCarll_num(String carll_num) {
		this.carll_num = carll_num;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Qw_police_team_street() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
   
}
