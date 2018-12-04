package com.cist.qwgl.qwbb.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 9.23.	值班值守报备
 * @author wangtao
 *
 */
public class Qw_report_duty  implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer pk_id;
	private Integer fk_report_id;//勤务报备id
	private Integer fk_work_shift_id;//班次id
	private String work_shift_name;//	班次名称（冗余数据）
	private Date work_shift_start_time;//班次开始时间（冗余数据）
	private Date work_shift_end_time;//	班次结束时间（冗余数据）
	private String span_cycle;//班次跨越周期（冗余数据）
	private String channel_num;//频道号
	private String carll_num;//呼号
	private String telephone;//值班电话
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Integer getFk_report_id() {
		return fk_report_id;
	}
	public void setFk_report_id(Integer fk_report_id) {
		this.fk_report_id = fk_report_id;
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
	public Qw_report_duty(Integer pk_id, Integer fk_report_id, Integer fk_work_shift_id, String work_shift_name,
			Date work_shift_start_time, Date work_shift_end_time, String span_cycle, String channel_num,
			String carll_num, String telephone) {
		super();
		this.pk_id = pk_id;
		this.fk_report_id = fk_report_id;
		this.fk_work_shift_id = fk_work_shift_id;
		this.work_shift_name = work_shift_name;
		this.work_shift_start_time = work_shift_start_time;
		this.work_shift_end_time = work_shift_end_time;
		this.span_cycle = span_cycle;
		this.channel_num = channel_num;
		this.carll_num = carll_num;
		this.telephone = telephone;
	}
	public Qw_report_duty() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
