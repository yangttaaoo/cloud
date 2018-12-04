package com.cist.myScheduling.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QwReportStreet {
	private BigDecimal pk_id;// ID

	private BigDecimal fk_report_id;// 勤务报备ID

	private String patrol_control_type;// 巡控类型（1：车巡；2：步巡；3：车巡+步巡）

	private String armed_forces_type;// 武装类型（1：武装；2：非武装）

	private String dressing_type;// 着装类型（1：制服；2：便衣）

	private BigDecimal fk_patrol_area_id;// 巡区ID

	private String area_name;// 区域名称（冗余数据）

	private String area_type;// 巡区类别（冗余数据）

	private BigDecimal fk_work_shift_id;// 班次ID

	private String work_shift_name;// 班次名称（冗余数据）

	private String service_type;// 勤务类型（冗余数据）

	private String channel_num;// 频道号

	private String carll_num;// 呼号

	private String telephone;// 值班电话

	private Date work_shift_end_time;// 班次结束时间（冗余数据）

	private BigDecimal span_cycle;// 班次跨越周期（冗余数据）

	private Date work_shift_start_time;// 班次开始时间（冗余数据）

	private String geo_spatial;// 空间信息（冗余数据）

	private String bctimeyear;// 值班日期 2017-11-15

	private String patrol_control_type_name;// 巡控类型（1：车巡；2：步巡；3：车巡+步巡）
	
	private List<Qw_patrol_alarm_log> qw_patrol_alarm_log =new ArrayList<Qw_patrol_alarm_log>();// 街面勤务预警信息

	public BigDecimal getPk_id() {
		return pk_id;
	}

	public void setPk_id(BigDecimal pk_id) {
		this.pk_id = pk_id;
	}

	public BigDecimal getFk_report_id() {
		return fk_report_id;
	}

	public void setFk_report_id(BigDecimal fk_report_id) {
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

	public BigDecimal getFk_patrol_area_id() {
		return fk_patrol_area_id;
	}

	public void setFk_patrol_area_id(BigDecimal fk_patrol_area_id) {
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

	public BigDecimal getFk_work_shift_id() {
		return fk_work_shift_id;
	}

	public void setFk_work_shift_id(BigDecimal fk_work_shift_id) {
		this.fk_work_shift_id = fk_work_shift_id;
	}

	public String getWork_shift_name() {
		return work_shift_name;
	}

	public void setWork_shift_name(String work_shift_name) {
		this.work_shift_name = work_shift_name;
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

	public Date getWork_shift_end_time() {
		return work_shift_end_time;
	}

	public void setWork_shift_end_time(Date work_shift_end_time) {
		this.work_shift_end_time = work_shift_end_time;
	}

	public BigDecimal getSpan_cycle() {
		return span_cycle;
	}

	public void setSpan_cycle(BigDecimal span_cycle) {
		this.span_cycle = span_cycle;
	}

	public Date getWork_shift_start_time() {
		return work_shift_start_time;
	}

	public void setWork_shift_start_time(Date work_shift_start_time) {
		this.work_shift_start_time = work_shift_start_time;
	}

	public String getGeo_spatial() {
		return geo_spatial;
	}

	public void setGeo_spatial(String geo_spatial) {
		this.geo_spatial = geo_spatial;
	}

	public String getBctimeyear() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if (work_shift_start_time != null && work_shift_end_time != null) {
			if (formatter.format(work_shift_start_time).equals(formatter.format(work_shift_end_time))) {
				bctimeyear = formatter.format(work_shift_start_time);
			} else {
				bctimeyear = formatter.format(work_shift_start_time) + "~" + formatter.format(work_shift_end_time);
			}

		} else if (work_shift_start_time != null && work_shift_end_time == null) {
			bctimeyear = formatter.format(work_shift_start_time);
		} else {
			bctimeyear = formatter.format(work_shift_end_time);
		}
		return bctimeyear;
	}

	public void setBctimeyear(String bctimeyear) {
		this.bctimeyear = bctimeyear;
	}

	public String getPatrol_control_type_name() {
		if (patrol_control_type != null) {
			if("1".equals(patrol_control_type)) {
				patrol_control_type_name = "车巡";
			}else if("2".equals(patrol_control_type)) {
				patrol_control_type_name = "步巡";
			}else if("3".equals(patrol_control_type)) {
				patrol_control_type_name = "车巡+步巡";
			}else {
				patrol_control_type_name = "未知";
			}
		}
		return patrol_control_type_name;
	}

	public void setPatrol_control_type_name(String patrol_control_type_name) {
		this.patrol_control_type_name = patrol_control_type_name;
	}

	public List<Qw_patrol_alarm_log> getQw_patrol_alarm_log() {
		return qw_patrol_alarm_log;
	}

	public void setQw_patrol_alarm_log(List<Qw_patrol_alarm_log> qw_patrol_alarm_log) {
		this.qw_patrol_alarm_log = qw_patrol_alarm_log;
	}

}