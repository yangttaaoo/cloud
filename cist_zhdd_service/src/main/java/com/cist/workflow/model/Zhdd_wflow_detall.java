package com.cist.workflow.model;

import java.io.Serializable;

/**
 * 工作流程明细
 * @author Administrator
 *
 */
public class Zhdd_wflow_detall implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pk_id;//id
	private Integer fk_work_flow_id;//流程ID
	private String work_flow_num;//流程序号
	private String work_flow_name;//流程名称
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Integer getFk_work_flow_id() {
		return fk_work_flow_id;
	}
	public void setFk_work_flow_id(Integer fk_work_flow_id) {
		this.fk_work_flow_id = fk_work_flow_id;
	}
	public String getWork_flow_num() {
		return work_flow_num;
	}
	public void setWork_flow_num(String work_flow_num) {
		this.work_flow_num = work_flow_num;
	}
	public String getWork_flow_name() {
		return work_flow_name;
	}
	
	public void setWork_flow_name(String work_flow_name) {
		this.work_flow_name = work_flow_name;
	}
	
	
}
