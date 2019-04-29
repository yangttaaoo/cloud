package com.cist.endNumberLimit.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.endNumberLimit.controller.DateUtil;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("unused")
public class CarLimtRules implements  Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4637402333171498778L;
	// ID
	private int tlr_pk;
	// 规则名称
	private String tlr_name;
	// 拼音简码
	private String tlr_name_spell;
	// 限行点位设备IDS
	private String tlr_point_ids;
	
	//星期一限行尾号
	private String tlr_mon;
	//星期二限行尾号
	private String tlr_tue;
	//星期三限行尾号
	private String tlr_wed;
	//星期四限行尾号
	private String tlr_thu;
	//星期五限行尾号
	private String tlr_fri;
	////星期六限行尾号
	private String tlr_sat;
	////星期天限行尾号
	private String tlr_sun;
	//限行时间段 开始时间 格式 时分秒
	private String tlr_start_time;
	//限行时间段 结束时间 格式 时分秒
	private String tlr_end_time;
	//0：禁用  1：启用
	private String tlr_flag;
	//规则有效时间 开始时间 格式 年月日
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date tlr_start_date;
	//规则有效时间 结束时间 格式 年月日
	@JsonFormat(pattern="yyyy-MM-dd  hh:mm:ss")
	private Date tlr_end_date;
	//管理部门
	private   String    tlr_dept;
	//限行类型 1：单双号限行 2：星期限行
	private String      tlr_type;
	//单号规则
	private String tlr_odd;
	//双号规则
	private String tlr_even;
	
	private   String tlr_flag_info;
	
	private String tlr_point_nos;
	
	private List<Object> start_end_date=null;
	private String show_date;
	private String start_h_time;
	private String start_m_time;
	private String start_s_time;
	private String end_h_time;
	private String end_m_time;
	private String end_s_time;
	
	
	
	
	public CarLimtRules() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Object> getStart_end_date() {
		start_end_date=new  ArrayList<Object>();
		start_end_date.add(DateUtil.formatDate(this.tlr_start_date, ""));
		start_end_date.add(DateUtil.formatDate(this.tlr_end_date, ""));
		return start_end_date;
	}
	public void setStart_end_date(List<Object> start_end_date) {
		
		this.start_end_date = start_end_date;
	}
	public String getTlr_point_nos() {
		List<String> list = Arrays.asList(tlr_point_ids.split(","));
		
		String point_nos="";
		for (String string : list) {
			
			String equipment = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_SBBD,string);
		
			
			point_nos+=equipment+",";
		}
		return point_nos;
	}
	public void setTlr_point_nos(String tlr_point_nos) {
		
		this.tlr_point_nos = tlr_point_nos;
	}
	public String getTlr_flag_info() {
		String flag_info="不限";
		if(this.tlr_flag.equals("1")) flag_info="启用";
		if(this.tlr_flag.equals("0")) flag_info="禁用";
		return flag_info;
	}
	public void setTlr_flag_info(String tlr_flag_info) {
		this.tlr_flag_info = tlr_flag_info;
	}
	public String getStart_h_time() {
		String[] split = this.tlr_start_time.split(":");
		return split[0];
	}
	public void setStart_h_time(String start_h_time) {
		this.start_h_time = start_h_time;
	}
	public String getStart_m_time() {
		String[] split = this.tlr_start_time.split(":");
		return split[1];
	}
	public void setStart_m_time(String start_m_time) {
		
		this.start_m_time = start_m_time;
	}
	public String getStart_s_time() {
		String[] split = this.tlr_start_time.split(":");
		return split[2];
	}
	public void setStart_s_time(String start_s_time) {
		this.start_s_time = start_s_time;
	}
	public String getEnd_h_time() {
		String[] split = this.tlr_end_time.split(":");
		return split[0];
	}
	public void setEnd_h_time(String end_h_time) {
		
		this.end_h_time = end_h_time;
	}
	public String getEnd_m_time() {
		String[] split = this.tlr_end_time.split(":");
		return split[1];
	}
	public void setEnd_m_time(String end_m_time) {
		this.end_m_time = end_m_time;
	}
	public String getEnd_s_time() {
		String[] split = this.tlr_end_time.split(":");
		return split[2];
	}
	public void setEnd_s_time(String end_s_time) {
		this.end_s_time = end_s_time;
	}
	public String getShow_date() {
		
		String show_date = DateUtil.formatDate(this.tlr_start_date, "")+"~"+DateUtil.formatDate(this.tlr_end_date, "");
		return show_date;
	}
	public void setShow_date(String show_date) {
	
		this.show_date = show_date;
	}
	public int getTlr_pk() {
		return tlr_pk;
	}
	public void setTlr_pk(int tlr_pk) {
		this.tlr_pk = tlr_pk;
	}
	public String getTlr_name() {
		return tlr_name;
	}
	public void setTlr_name(String tlr_name) {
		this.tlr_name = tlr_name;
	}
	public String getTlr_name_spell() {
		return tlr_name_spell;
	}
	public void setTlr_name_spell(String tlr_name_spell) {
		this.tlr_name_spell = tlr_name_spell;
	}
	public String getTlr_point_ids() {
		return tlr_point_ids;
	}
	public void setTlr_point_ids(String tlr_point_ids) {
		this.tlr_point_ids = tlr_point_ids;
	}
	public String getTlr_mon() {
		return tlr_mon;
	}
	public void setTlr_mon(String tlr_mon) {
		this.tlr_mon = tlr_mon;
	}
	public String getTlr_tue() {
		return tlr_tue;
	}
	public void setTlr_tue(String tlr_tue) {
		this.tlr_tue = tlr_tue;
	}
	public String getTlr_wed() {
		return tlr_wed;
	}
	public void setTlr_wed(String tlr_wed) {
		this.tlr_wed = tlr_wed;
	}
	public String getTlr_thu() {
		return tlr_thu;
	}
	public void setTlr_thu(String tlr_thu) {
		this.tlr_thu = tlr_thu;
	}
	public String getTlr_fri() {
		return tlr_fri;
	}
	public void setTlr_fri(String tlr_fri) {
		this.tlr_fri = tlr_fri;
	}
	public String getTlr_sat() {
		return tlr_sat;
	}
	public void setTlr_sat(String tlr_sat) {
		this.tlr_sat = tlr_sat;
	}
	public String getTlr_sun() {
		return tlr_sun;
	}
	public void setTlr_sun(String tlr_sun) {
		this.tlr_sun = tlr_sun;
	}
	public String getTlr_start_time() {
		return tlr_start_time;
	}
	public void setTlr_start_time(String tlr_start_time) {
		this.tlr_start_time = tlr_start_time;
	}
	public String getTlr_end_time() {
		return tlr_end_time;
	}
	public void setTlr_end_time(String tlr_end_time) {
		this.tlr_end_time = tlr_end_time;
	}
	public String getTlr_flag() {
		return tlr_flag;
	}
	public void setTlr_flag(String tlr_flag) {
		this.tlr_flag = tlr_flag;
	}

	
	public Date getTlr_start_date() {
		return tlr_start_date;
	}
	public void setTlr_start_date(Date tlr_start_date) {
		this.tlr_start_date = tlr_start_date;
	}
	public Date getTlr_end_date() {
		return tlr_end_date;
	}
	public void setTlr_end_date(Date tlr_end_date) {
		this.tlr_end_date = tlr_end_date;
	}
	public String getTlr_dept() {
		return tlr_dept;
	}
	public void setTlr_dept(String tlr_dept) {
		this.tlr_dept = tlr_dept;
	}
	public String getTlr_type() {
		return tlr_type;
	}
	public void setTlr_type(String tlr_type) {
		this.tlr_type = tlr_type;
	}
	public String getTlr_odd() {
		return tlr_odd;
	}
	public void setTlr_odd(String tlr_odd) {
		this.tlr_odd = tlr_odd;
	}
	public String getTlr_even() {
		return tlr_even;
	}
	public void setTlr_even(String tlr_even) {
		this.tlr_even = tlr_even;
	}
	
	
	
	
	}
