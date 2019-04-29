package com.cist.eventmanagement.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 事件受理信息
 * @author Hy
 *
 */
public class Zhdd_event_acceptance implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3994487825706468479L;
	private Integer pk_id;//ID
    private Integer fk_event_id;//事件ID
    private String fk_acceptance_dept_id;//操作人单位ID
    private Integer fk_acceptance_person_id;//操作人ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date acceptance_time;//操作时间
    private String acceptance_state;//操作状态（2未受理、0已受理、1已下发）
    private String fk_forward_dept_id;//转发单位ID
    private Date forward_time;//转发时间
    
    private String fk_acceptance_dept_name;//操作人单位名称
    private String fk_acceptance_person_name;//操作人姓名
    private String fk_forward_dept_name;//转发单位名称
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
	public String getFk_forward_dept_id() {
		return fk_forward_dept_id;
	}
	public void setFk_forward_dept_id(String fk_forward_dept_id) {
		this.fk_forward_dept_id = fk_forward_dept_id;
	}
	public Date getForward_time() {
		return forward_time;
	}
	public void setForward_time(Date forward_time) {
		this.forward_time = forward_time;
	}
	public String getFk_acceptance_dept_name() {
		return fk_acceptance_dept_name;
	}
	public void setFk_acceptance_dept_name(String fk_acceptance_dept_name) {
		this.fk_acceptance_dept_name = fk_acceptance_dept_name;
	}
	public String getFk_acceptance_person_name() {
		return fk_acceptance_person_name;
	}
	public void setFk_acceptance_person_name(String fk_acceptance_person_name) {
		this.fk_acceptance_person_name = fk_acceptance_person_name;
	}
	public String getFk_forward_dept_name() {
		return fk_forward_dept_name;
	}
	public void setFk_forward_dept_name(String fk_forward_dept_name) {
		this.fk_forward_dept_name = fk_forward_dept_name;
	}
    
}
