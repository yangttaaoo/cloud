package com.cist.eventmanagement.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 事件作废归档记录
 * @author Hy
 *
 */
public class Zhdd_event_record implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5276855138266469117L;
	private Integer pk_id;//id
    private Integer fk_event_id;//事件ID
    private String fk_acceptance_dept_id;//操作人单位ID
    private Integer fk_acceptance_person_id;//操作人ID
    private Date acceptance_time;//操作时间
    private String acceptance_state;//操作状态（1作废、0归档）
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
	public String getFk_acceptance_dept_id() {
		return fk_acceptance_dept_id;
	}
	public void setFk_acceptance_dept_id(String fk_acceptance_dept_id) {
		this.fk_acceptance_dept_id = fk_acceptance_dept_id;
	}
	public Integer getFk_acceptance_person_id() {
		return fk_acceptance_person_id;
	}
	public void setFk_acceptance_person_id(Integer fk_acceptance_person_id) {
		this.fk_acceptance_person_id = fk_acceptance_person_id;
	}
	public Date getAcceptance_time() {
		return acceptance_time;
	}
	public void setAcceptance_time(Date acceptance_time) {
		this.acceptance_time = acceptance_time;
	}
	public String getAcceptance_state() {
		return acceptance_state;
	}
	public void setAcceptance_state(String acceptance_state) {
		this.acceptance_state = acceptance_state;
	}
    
}
