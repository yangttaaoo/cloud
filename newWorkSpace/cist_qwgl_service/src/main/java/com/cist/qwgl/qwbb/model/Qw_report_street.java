package com.cist.qwgl.qwbb.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 9.19.	街面勤务报备
 * @author wangtao
 *
 */
public class Qw_report_street  implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer PK_ID;//
	private String fk_report_id;//勤务报备id
	private String patrol_control_type;//	巡控类型（1：车巡；2：步巡；3：车巡+步巡）
	private String armed_forces_type;//武装类型（1：武装；2：非武装）
	private String dressing_type;//	着装类型（1：制服；2：便衣）
	private String fk_patrol_area_id;//	巡区id
	private String area_name;//	区域名称（冗余数据）
	private String area_type;//巡区类别（冗余数据）
	private String geo_spatial;//	空间信息（冗余数据）
	private Integer fk_work_shift_id;//	班次id
	private String work_shift_name;//	班次名称（冗余数据）
	private Date work_shift_start_time;//	班次开始时间（冗余数据）
	private Date work_shift_end_time;//	班次结束时间（冗余数据）
	private String span_cycle;//	班次跨越周期（冗余数据）
	private String service_type;//	勤务类型（冗余数据）
	private String channel_num;//	频道号
	private String carll_num;//	呼号
	private String telephone;//值班电话
	
	private String timename;//执勤时间
	
	public String getTimename() {
		if(work_shift_start_time!=null) {
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
			return formatter.format(work_shift_start_time)+"~"+formatter.format(work_shift_end_time);
		}
		return timename;
	}
	public void setTimename(String timename) {
		this.timename = timename;
	}
	public Integer getPK_ID() {
		return PK_ID;
	}
	public void setPK_ID(Integer pK_ID) {
		PK_ID = pK_ID;
	}
	public String getFk_report_id() {
		return fk_report_id;
	}
	public void setFk_report_id(String fk_report_id) {
		this.fk_report_id = fk_report_id;
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
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public String getArea_type() {
		return area_type;
	}
	public void setArea_type(String area_type) {
		this.area_type = area_type;
	}
	public String getGeo_spatial() {
		return geo_spatial;
	}
	public void setGeo_spatial(String geo_spatial) {
		this.geo_spatial = geo_spatial;
	}
	public Integer getFk_work_shift_id() {
		return fk_work_shift_id;
	}
	public void setFk_work_shift_id(Integer fk_work_shift_id) {
		this.fk_work_shift_id = fk_work_shift_id;
	}
	public String getWork_shift_name() {
		return work_shift_name;
	}
	public void setWork_shift_name(String work_shift_name) {
		this.work_shift_name = work_shift_name;
	}
	public Date getWork_shift_start_time() {
		return work_shift_start_time;
	}
	public void setWork_shift_start_time(Date work_shift_start_time) {
		this.work_shift_start_time = work_shift_start_time;
	}
	public Date getWork_shift_end_time() {
		return work_shift_end_time;
	}
	public void setWork_shift_end_time(Date work_shift_end_time) {
		this.work_shift_end_time = work_shift_end_time;
	}
	public String getSpan_cycle() {
		return span_cycle;
	}
	public void setSpan_cycle(String span_cycle) {
		this.span_cycle = span_cycle;
	}
	public String getService_type() {
		return service_type;
	}
	public void setService_type(String service_type) {
		this.service_type = service_type;
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
	public Qw_report_street(Integer pK_ID, String fk_report_id, String patrol_control_type, String armed_forces_type,
			String dressing_type, String fk_patrol_area_id, String area_name, String area_type, String geo_spatial,
			Integer fk_work_shift_id, String work_shift_name, Date work_shift_start_time, Date work_shift_end_time,
			String span_cycle, String service_type, String channel_num, String carll_num, String telephone) {
		super();
		PK_ID = pK_ID;
		this.fk_report_id = fk_report_id;
		this.patrol_control_type = patrol_control_type;
		this.armed_forces_type = armed_forces_type;
		this.dressing_type = dressing_type;
		this.fk_patrol_area_id = fk_patrol_area_id;
		this.area_name = area_name;
		this.area_type = area_type;
		this.geo_spatial = geo_spatial;
		this.fk_work_shift_id = fk_work_shift_id;
		this.work_shift_name = work_shift_name;
		this.work_shift_start_time = work_shift_start_time;
		this.work_shift_end_time = work_shift_end_time;
		this.span_cycle = span_cycle;
		this.service_type = service_type;
		this.channel_num = channel_num;
		this.carll_num = carll_num;
		this.telephone = telephone;
	}
	public Qw_report_street() {
		super();
	}
	
}