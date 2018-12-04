package com.cist.holidays.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Holidays {
	// ID
	private int syhi_pk;
	// 节假名称
	private String syhi_name;
	// 节日描述
	private String syhi_desc;
	// 节假日期  
	private String syhi_holiday;
	// 调休上班日期
	private String syhi_work_day;
	//节日开始时间（包含,格式：YYYY-MM-dd 00:00:00）
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date syhi_stime;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	//节日结束时间（包含,格式：YYYY-MM-dd 23:59:59）
	private Date syhi_etime;
	// 展示节假日期
	private String show_syhi_holiday;
	// 展示调休上班日期
	private String show_syhi_work_day;

		// 展示节假日期
		private List<String> show_syhi_holiday_list;
		// 展示调休上班日期
		private List<String> show_syhi_work_day_list;
	
	
	public String getShow_syhi_holiday() {
		List<String> list = Arrays.asList(this.syhi_holiday.split(","));
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			String[] split = list.get(i).split("-");
			StringBuffer strBuf = new StringBuffer();
			for (String str : split) {
				strBuf.append(str);
			}
			buff.append(strBuf);
			buff.append(",");
		}
		return buff.toString().substring(0, buff.length() - 1);
	}
	public void setShow_syhi_holiday(String show_syhi_holiday) {
		this.show_syhi_holiday = show_syhi_holiday;
	}

	public String getShow_syhi_work_day() {
		if ("".equals(this.syhi_work_day) || null==this.syhi_work_day) {
			return "";
		} else {
			List<String> list = Arrays.asList(this.syhi_work_day.split(","));
			StringBuffer buff = new StringBuffer();
			for (int i = 0; i < list.size(); i++) {
				String[] split = list.get(i).split("-");
				StringBuffer strBuf = new StringBuffer();
				for (String str : split) {
					strBuf.append(str);
				}
				buff.append(strBuf);
				buff.append(",");
			}
			return buff.toString().substring(0, buff.length() - 1);
		}

	
	}

	public List<String> getShow_syhi_holiday_list() {
		return Arrays.asList(this.syhi_holiday.split(","));
	}
	public void setShow_syhi_holiday_list(List<String> show_syhi_holiday_list) {
		this.show_syhi_holiday_list = show_syhi_holiday_list;
	}
	public void setShow_syhi_work_day(String show_syhi_work_day) {
		this.show_syhi_work_day = show_syhi_work_day;
	}


	public List<String> getShow_syhi_work_day_list() {
		if ("".equals(this.syhi_work_day) || null==this.syhi_work_day) {
			return new ArrayList<String>();
		} else {
			return Arrays.asList(this.syhi_work_day.split(","));
			}
		
	}
	
	public void setShow_syhi_work_day_list(List<String> show_syhi_work_day_list) {
		this.show_syhi_work_day_list = show_syhi_work_day_list;
	}
	public int getSyhi_pk() {
		return syhi_pk;
	}

	public void setSyhi_pk(int syhi_pk) {
		this.syhi_pk = syhi_pk;
	}

	public String getSyhi_name() {
		return syhi_name;
	}

	public void setSyhi_name(String syhi_name) {
		this.syhi_name = syhi_name;
	}

	public String getSyhi_desc() {
		return syhi_desc;
	}

	public void setSyhi_desc(String syhi_desc) {
		this.syhi_desc = syhi_desc;
	}

	public String getSyhi_holiday() {
		return syhi_holiday;
	}

	public void setSyhi_holiday(String syhi_holiday) {
		this.syhi_holiday = syhi_holiday;
	}

	public String getSyhi_work_day() {
		return syhi_work_day;
	}

	public void setSyhi_work_day(String syhi_work_day) {
		this.syhi_work_day = syhi_work_day;
	}

	public Date getSyhi_stime() {
		return syhi_stime;
	}

	public void setSyhi_stime(Date syhi_stime) {
		this.syhi_stime = syhi_stime;
	}

	public Date getSyhi_etime() {
		return syhi_etime;
	}

	public void setSyhi_etime(Date syhi_etime) {
		this.syhi_etime = syhi_etime;
	}


}
