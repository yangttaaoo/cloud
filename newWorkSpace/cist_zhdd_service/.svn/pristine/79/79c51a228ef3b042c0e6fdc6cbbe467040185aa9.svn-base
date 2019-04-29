package com.cist.home.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EventInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer pk_id;//ID
	private Integer fk_dept_id;//部门ID
	private Integer fk_event_source_id;//事件来源
	private String event_source_name;//事件来源名称
	private Integer fk_event_type_id;//事件类型
	private String event_type_name;//事件类型名称
	private String event_address;//事件地点
	private BigDecimal longitude;//纬度
	private BigDecimal latitude;//经度
	private String event_name;//名称
	private String event_describe;//事件描述
	private String alarm_person;//报警人
	private String alarm_person_telephone;//联系电话
	private String alarm_time;//报警时间
	private String event_preselection;//预选项 用‘,’分隔
	private Integer event_current_status;//事件当前状态（4未受理-查询事件受理信息、0已受理、1未调度、2已调度-查询事件处理流程、3已完成查询事件结果）
	private String event_current_status_name;//当前处理状态 2进行中，3已完成
	private Integer event_status;//事件状态（3作废、0未办结、1办结-事件处置流程全部完成、2归档）
	private Date completion_time_limit;//完成时限[新增]
	private Integer fk_person_id;//事件处置人员ID
	private String dispatch_time;//事件开始时间（调度时间）
	private String event_jjd;//报警人
	private String jjy_name;//接警人名称
	private Integer  startid=0;//事件处置流程如果大于0说明当前事件已经返回信息了 处警，当等于0 出警中
	private Integer  startidinfo;//1接警2出警3处警
	private Integer xiafa=1;//指挥长下发   1没有下发 2下发
	
	public Integer getXiafa() {
		return xiafa;
	}
	public void setXiafa(Integer xiafa) {
		this.xiafa = xiafa;
	}
	public String getJjy_name() {
		return jjy_name;
	}
	public void setJjy_name(String jjy_name) {
		this.jjy_name = jjy_name;
	}
	public Integer getStartidinfo() {
		if(event_current_status==4) {
			return 1;
		}else {
			if(startid==0) {
				return 2;
			}
		}
		return 3;
	}
	public void setStartidinfo(Integer startidinfo) {
		this.startidinfo = startidinfo;
	}
	public Integer getStartid() {
		return startid;
	}
	public void setStartid(Integer startid) {
		this.startid = startid;
	}
	public String getEvent_jjd() {
		return event_jjd;
	}
	public void setEvent_jjd(String event_jjd) {
		this.event_jjd = event_jjd;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setEvent_current_status_name(String event_current_status_name) {
		this.event_current_status_name = event_current_status_name;
	}
	public String getEvent_source_name() {
		return event_source_name;
	}
	public void setEvent_source_name(String event_source_name) {
		this.event_source_name = event_source_name;
	}
	public String getEvent_type_name() {
		return event_type_name;
	}
	public void setEvent_type_name(String event_type_name) {
		this.event_type_name = event_type_name;
	}
	public String getDispatch_time() {
		return dispatch_time;
	}
	public void setDispatch_time(String dispatch_time) {
		this.dispatch_time = dispatch_time;
	}
	public String getEvent_current_status_name() {
		return event_current_status_name;
	}
	public void setEvent_current_status_name(char event_current_status_name) {
		if(event_current_status_name == '2'){
			this.event_current_status_name = "进行中";
		}else if(event_current_status_name == '3'){
			this.event_current_status_name = "已完成";
		}else{
			this.event_current_status_name = "未开始";
		}
		
	}
	public Integer getFk_person_id() {
		return fk_person_id;
	}
	public void setFk_person_id(Integer fk_person_id) {
		this.fk_person_id = fk_person_id;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Integer getFk_dept_id() {
		return fk_dept_id;
	}
	public void setFk_dept_id(Integer fk_dept_id) {
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
	public String getAlarm_time() {
		return alarm_time;
	}
	public void setAlarm_time(String alarm_time) {
		this.alarm_time = alarm_time;
	}
	public String getEvent_preselection() {
		return event_preselection;
	}
	public void setEvent_preselection(String event_preselection) {
		this.event_preselection = event_preselection;
	}
	public Integer getEvent_current_status() {
		return event_current_status;
	}
	public void setEvent_current_status(Integer event_current_status) {
		this.setEvent_current_status_name(event_current_status.toString());
		this.event_current_status = event_current_status;
	}
	public Integer getEvent_status() {
		return event_status;
	}
	public void setEvent_status(Integer event_status) {
		this.event_status = event_status;
	}
	public Date getCompletion_time_limit() {
		return completion_time_limit;
	}
	public void setCompletion_time_limit(Date completion_time_limit) {
		this.completion_time_limit = completion_time_limit;
	}
	
	
}
