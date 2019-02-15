package com.cist.eventmanagement.model;

import java.io.Serializable;
/**
 * 事件处置人员
 * @author Hy
 *
 */
public class Zhdd_event_personnel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5731477263504263007L;
	private Integer pk_id;//
	private Integer fk_event_id;//事件ID
	private Integer fk_event_dispatch_id;//事件调度ID
	private Integer fk_person_id;//人员ID
	
	private String sypi_name;//人员姓名
	private String sypi_mobial;//移动电话
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
	public Integer getFk_event_dispatch_id() {
		return fk_event_dispatch_id;
	}
	public void setFk_event_dispatch_id(Integer fk_event_dispatch_id) {
		this.fk_event_dispatch_id = fk_event_dispatch_id;
	}
	public Integer getFk_person_id() {
		return fk_person_id;
	}
	public void setFk_person_id(Integer fk_person_id) {
		this.fk_person_id = fk_person_id;
	}
	public String getSypi_name() {
		return sypi_name;
	}
	public void setSypi_name(String sypi_name) {
		this.sypi_name = sypi_name;
	}
	public String getSypi_mobial() {
		return sypi_mobial;
	}
	public void setSypi_mobial(String sypi_mobial) {
		this.sypi_mobial = sypi_mobial;
	}
	
}
