package com.cist.eventmanagement.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 事件调度
 * @author Hy
 *
 */
public class Zhdd_event_dispatch implements Serializable {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 5829442309879529378L;
	private Integer pk_id;//id
       private Integer fk_event_id;//事件ID
       private Integer fk_dispatch_person_id;//调度人ID
       @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
       private Date dispatch_time;//调度时间
       private String sms_contents;//短信内容
       private Integer fk_work_flow_id;//事件处置流程ID
       
       private String fk_dispatch_person_name;//调度人姓名

	public Integer getPk_id() {
		return pk_id;
	}

	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}

	public Integer getFk_event_id() {
		return fk_event_id;
	}

	public void setFk_event_id(Integer fk_event_id) {
		this.fk_event_id = fk_event_id;
	}

	public Integer getFk_dispatch_person_id() {
		return fk_dispatch_person_id;
	}

	public void setFk_dispatch_person_id(Integer fk_dispatch_person_id) {
		this.fk_dispatch_person_id = fk_dispatch_person_id;
	}

	public Date getDispatch_time() {
		return dispatch_time;
	}

	public void setDispatch_time(Date dispatch_time) {
		this.dispatch_time = dispatch_time;
	}

	public String getSms_contents() {
		return sms_contents;
	}

	public void setSms_contents(String sms_contents) {
		this.sms_contents = sms_contents;
	}

	public Integer getFk_work_flow_id() {
		return fk_work_flow_id;
	}

	public void setFk_work_flow_id(Integer fk_work_flow_id) {
		this.fk_work_flow_id = fk_work_flow_id;
	}

	public String getFk_dispatch_person_name() {
		return fk_dispatch_person_name;
	}

	public void setFk_dispatch_person_name(String fk_dispatch_person_name) {
		this.fk_dispatch_person_name = fk_dispatch_person_name;
	}
       
}
