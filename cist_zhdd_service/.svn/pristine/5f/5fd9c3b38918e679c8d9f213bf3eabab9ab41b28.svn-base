package com.cist.trafficControl.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TrafficControl {
	// ID
	private long pk_id;
	// 部门ID
	private long fk_dept_id;
	// 创建人ID
	private long fk_create_founder_id;
	// 创建时间
	@JsonFormat(pattern="yyyy-MM-dd  HH:mm:ss",timezone="GMT+8")
	private Date create_time;
	// 管制名称
	private String control_name;
	// 管制区域
	private String control_route;
	// 任务开始时间
	@JsonFormat(pattern="yyyy-MM-dd  HH:mm:ss",timezone="GMT+8")
	private Date control_start_time;
	// 任务结束时间
	@JsonFormat(pattern="yyyy-MM-dd  HH:mm:ss",timezone="GMT+8")
	private Date control_end_time;
	// 管制规则，用‘，’分割
	private String control_rule;
	// 管制描述
	private String control_describe;
	// 审核状态（2未通过、0审核中、1通过）
	private Character verify_status;
	// 审核人ID
	private long fk_verify_person_id;
	// 审核时间
	@JsonFormat(pattern="yyyy-MM-dd  hh:mm:ss",timezone="GMT+8")
	private Date verify_time;

	private String status;
	private String verify_status_name;
	private String fk_create_founder_name;
	private String fk_verify_person_name;
	private boolean checked = false;
	private boolean expand = false;
	private int nzCurrent;
	
	
	public String getFk_verify_person_name() {
		return fk_verify_person_name;
	}

	public void setFk_verify_person_name(String fk_verify_person_name) {
		this.fk_verify_person_name = fk_verify_person_name;
	}

	public int getNzCurrent() {
		return nzCurrent;
	}

	public void setNzCurrent(int nzCurrent) {
		this.nzCurrent = nzCurrent;
	}

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isExpand() {
		return expand;
	}

	public void setExpand(boolean expand) {
		this.expand = expand;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVerify_status_name() {
		return verify_status_name;
	}

	public void setVerify_status_name(String verify_status_name) {
		this.verify_status_name = verify_status_name;
	}

	public String getFk_create_founder_name() {
		return fk_create_founder_name;
	}

	public void setFk_create_founder_name(String fk_create_founder_name) {
		this.fk_create_founder_name = fk_create_founder_name;
	}

	public long getPk_id() {
		return pk_id;
	}

	public void setPk_id(long pk_id) {
		this.pk_id = pk_id;
	}

	public long getFk_dept_id() {
		return fk_dept_id;
	}

	public void setFk_dept_id(long fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}

	public long getFk_create_founder_id() {
		return fk_create_founder_id;
	}

	public void setFk_create_founder_id(long fk_create_founder_id) {
		this.fk_create_founder_id = fk_create_founder_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getControl_name() {
		return control_name;
	}

	public void setControl_name(String control_name) {
		this.control_name = control_name;
	}

	public String getControl_route() {
		return control_route;
	}

	public void setControl_route(String control_route) {
		this.control_route = control_route;
	}

	public Date getControl_start_time() {
		return control_start_time;
	}

	public void setControl_start_time(Date control_start_time) {
		this.control_start_time = control_start_time;
	}

	public Date getControl_end_time() {
		return control_end_time;
	}

	public void setControl_end_time(Date control_end_time) {
		this.control_end_time = control_end_time;
	}

	public String getControl_rule() {
		return control_rule;
	}

	public void setControl_rule(String control_rule) {
		this.control_rule = control_rule;
	}

	public String getControl_describe() {
		return control_describe;
	}

	public void setControl_describe(String control_describe) {
		this.control_describe = control_describe;
	}

	public Character getVerify_status() {
		return verify_status;
	}

	public void setVerify_status(Character verify_status) {
		this.verify_status = verify_status;
	}

	public long getFk_verify_person_id() {
		return fk_verify_person_id;
	}

	public void setFk_verify_person_id(long fk_verify_person_id) {
		this.fk_verify_person_id = fk_verify_person_id;
	}

	public Date getVerify_time() {
		return verify_time;
	}

	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}

}
