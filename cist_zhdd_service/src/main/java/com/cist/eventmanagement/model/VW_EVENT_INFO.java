package com.cist.eventmanagement.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 事件信息
 * 
 * @author Hy
 *
 */
public class VW_EVENT_INFO implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 5717469003550989632L;
	private Integer pk_id;// ID
	private String fk_dept_id;// 部门ID
	private Integer fk_event_source_id;// 事件来源
	private Integer fk_event_type_id;// 事件类型
	private String event_address;// 事件地点
	private String event_name;//事件名称
	private BigDecimal longitude;// 经度
	private BigDecimal latitude;// 纬度
	private String event_describe;// 事件描述
	private String alarm_person;// 报警人
	private String alarm_person_telephone;// 联系电话
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date alarm_time;// 报警时间
	private String event_preselection;// 预选项 用‘,’分隔
	private String event_current_status;// 事件当前状态（4未受理-查询事件受理信息、0已受理、1未调度、2已调度-查询事件处理流程、3已完成查询事件结果）
	private String event_status;// 事件状态（3作废、0未办结、1办结-事件处置流程全部完成、2归档）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date completion_time_limit;// 完成时限
	private String event_type_name;//事件类型名称
	private String event_source_name;//事件来源名称
	private String dept_name;//单位名称
	

	
	private String event_status_name;//事件跟踪名称
	private Integer sjzt;//事件状态  0:未受理   1:已受理   2:处置  3:完成
	private Integer zt;//1:未反馈 2:未处理结果 3：未受理  4：未调度 0：其他
	public Integer getPk_id() {
		return pk_id;
	}

	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}

	public String getFk_dept_id() {
		return fk_dept_id;
	}

	public void setFk_dept_id(String fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}

	public Integer getFk_event_source_id() {
		return fk_event_source_id;
	}

	public void setFk_event_source_id(Integer fk_event_source_id) {
		this.fk_event_source_id = fk_event_source_id;
	}

	public Integer getFk_event_type_id() {
		return fk_event_type_id;
	}

	public void setFk_event_type_id(Integer fk_event_type_id) {
		this.fk_event_type_id = fk_event_type_id;
	}

	public String getEvent_address() {
		return event_address;
	}

	public void setEvent_address(String event_address) {
		this.event_address = event_address;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public String getEvent_describe() {
		return event_describe;
	}

	public void setEvent_describe(String event_describe) {
		this.event_describe = event_describe;
	}

	public String getAlarm_person() {
		return alarm_person;
	}

	public void setAlarm_person(String alarm_person) {
		this.alarm_person = alarm_person;
	}

	public String getAlarm_person_telephone() {
		return alarm_person_telephone;
	}

	public void setAlarm_person_telephone(String alarm_person_telephone) {
		this.alarm_person_telephone = alarm_person_telephone;
	}

	public Date getAlarm_time() {
		return alarm_time;
	}

	public void setAlarm_time(Date alarm_time) {
		this.alarm_time = alarm_time;
	}

	public String getEvent_preselection() {
		return event_preselection;
	}

	public void setEvent_preselection(String event_preselection) {
		this.event_preselection = event_preselection;
	}

	public String getEvent_current_status() {
		return event_current_status;
	}

	public void setEvent_current_status(String event_current_status) {
		this.event_current_status = event_current_status;
	}

	public String getEvent_status() {
		return event_status;
	}

	public void setEvent_status(String event_status) {
		this.event_status = event_status;
	}

	public Date getCompletion_time_limit() {
		return completion_time_limit;
	}

	public void setCompletion_time_limit(Date completion_time_limit) {
		this.completion_time_limit = completion_time_limit;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getEvent_type_name() {
		return event_type_name;
	}

	public void setEvent_type_name(String event_type_name) {
		this.event_type_name = event_type_name;
	}

	public String getEvent_source_name() {
		return event_source_name;
	}

	public void setEvent_source_name(String event_source_name) {
		this.event_source_name = event_source_name;
	}

	public String getEvent_status_name() {
		if("0".equals(event_status)) {
			return "未办结";
		}else if("1".equals(event_status)) {
			return "已办结";
		}else if("2".equals(event_status)) {
			return "归档";
		}else if("3".equals(event_status)) {
			return "作废";
		}else{
			return "未知";
		}
	}

	public void setEvent_status_name(String event_status_name) {
		this.event_status_name = event_status_name;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public Integer getSjzt() {
		return sjzt;
	}

	public void setSjzt(Integer sjzt) {
		this.sjzt = sjzt;
	}

	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}


	
}
