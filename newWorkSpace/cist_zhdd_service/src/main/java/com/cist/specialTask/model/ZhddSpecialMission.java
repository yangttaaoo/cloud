package com.cist.specialTask.model;

import java.math.BigDecimal;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 特勤任务
 * 
 * @author yt
 *
 */
public class ZhddSpecialMission {
	private BigDecimal pk_id;// ID

	private BigDecimal fk_dept_id;// 部门ID

	private BigDecimal fk_create_founder_id;// 创建人ID

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
	private Date create_time;// 创建时间

	private String mission_name;// 任务名称

	private BigDecimal fk_mission_grade_id;// 任务等级

	private Date mission_start_time;// 任务开始时间

	private Date mission_end_time;// 任务结束时间

	private String mission_describe;// 任务描述

	private String fk_create_founder_name;// 创建人名称

	private String grade_name;//特勤等级名称
	private String mission_status;//任务状态
	
	public BigDecimal getPk_id() {
		return pk_id;
	}

	public void setPk_id(BigDecimal pk_id) {
		this.pk_id = pk_id;
	}

	public BigDecimal getFk_dept_id() {
		return fk_dept_id;
	}

	public void setFk_dept_id(BigDecimal fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}

	public BigDecimal getFk_create_founder_id() {
		return fk_create_founder_id;
	}

	public void setFk_create_founder_id(BigDecimal fk_create_founder_id) {
		this.fk_create_founder_id = fk_create_founder_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getMission_name() {
		return mission_name;
	}

	public void setMission_name(String mission_name) {
		this.mission_name = mission_name;
	}

	public BigDecimal getFk_mission_grade_id() {
		return fk_mission_grade_id;
	}

	public void setFk_mission_grade_id(BigDecimal fk_mission_grade_id) {
		this.fk_mission_grade_id = fk_mission_grade_id;
	}

	public Date getMission_start_time() {
		return mission_start_time;
	}

	public void setMission_start_time(Date mission_start_time) {
		this.mission_start_time = mission_start_time;
	}

	public Date getMission_end_time() {
		return mission_end_time;
	}

	public void setMission_end_time(Date mission_end_time) {
		this.mission_end_time = mission_end_time;
	}

	public String getMission_describe() {
		if(mission_describe==null||"".equals(mission_describe)) {
			return "无";
		}
		return mission_describe;
	}

	public void setMission_describe(String mission_describe) {
		this.mission_describe = mission_describe;
	}

	public String getFk_create_founder_name() {
		if (fk_create_founder_id != null) {
			fk_create_founder_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER,
					fk_create_founder_id.toString());
		}
		return fk_create_founder_name;
	}

	public void setFk_create_founder_name(String fk_create_founder_name) {
		this.fk_create_founder_name = fk_create_founder_name;
	}

	public String getGrade_name() {
		return grade_name;
	}

	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}

	public String getMission_status() {
		return mission_status;
	}

	public void setMission_status(String mission_status) {
		this.mission_status = mission_status;
	}

}