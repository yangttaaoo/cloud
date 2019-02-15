package com.cist.alarm.logquery.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Alarm_log {

	private Integer log_pk;
	private String type;// 1-温度 2-电压3-断网 4-断电
	private String equipment;// 设备
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
	private Date time;// 报警 时间
	private String push;// 推送类型 1-正常 2-异常

	public Integer getLog_pk() {
		return log_pk;
	}

	public void setLog_pk(Integer log_pk) {
		this.log_pk = log_pk;
	}

	public String getType() {
		switch (type) {
		case "1":
			type = "温度报警";
			break;
		case "2":
			type = "电压报警";
			break;
		case "3":
			type = "断网报警";
			break;
		case "4":
			type = "断电报警";
			break;
		}
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getPush() {
		return "1".equals(push)?"正常":"失败";
	}

	public void setPush(String push) {
		this.push = push;
	}

}
