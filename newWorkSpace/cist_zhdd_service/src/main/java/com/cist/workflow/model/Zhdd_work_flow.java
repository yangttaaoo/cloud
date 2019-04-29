package com.cist.workflow.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 工作流程
 * @author Administrator
 *
 */
public class Zhdd_work_flow implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer pk_id;//ID
	private Integer fk_dept_id;//部门id
	private String fk_producer_id;//创建人
	private Date create_time;//创建时间
	private String work_flow_name;//流程名称
	private String work_flow_summary;//流程介绍
	public Integer getPk_id() {
		return pk_id;
	}
	
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Integer getPk_dept_id() {
		return fk_dept_id;
	}
	public void setPk_dept_id(Integer pk_dept_id) {
		this.fk_dept_id = pk_dept_id;
	}
	public String getFk_producer_id() {
		return fk_producer_id;
	}
	public void setFk_producer_id(String fk_producer_id) {
		this.fk_producer_id = fk_producer_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
	public String getWork_flow_summary() {
		return work_flow_summary;
	}
	public void setWork_flow_summary(String work_flow_summary) {
		this.work_flow_summary = work_flow_summary;
	}
	public String getWork_flow_name() {
		return work_flow_name;
	}
	public void setWork_flow_name(String work_flow_name) {
		this.work_flow_name = work_flow_name;
	}
	
	
	
	
}