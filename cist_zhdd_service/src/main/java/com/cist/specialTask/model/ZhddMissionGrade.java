package com.cist.specialTask.model;

import java.math.BigDecimal;

/**
 * 特勤任务等级
 * @author yt
 *
 */
public class ZhddMissionGrade {
    private BigDecimal pk_id;//ID

    private String grade_name;//等级名称

    private String mission_describe;//等级描述

	public BigDecimal getPk_id() {
		return pk_id;
	}

	public void setPk_id(BigDecimal pk_id) {
		this.pk_id = pk_id;
	}

	public String getGrade_name() {
		return grade_name;
	}

	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}

	public String getMission_describe() {
		return mission_describe;
	}

	public void setMission_describe(String mission_describe) {
		this.mission_describe = mission_describe;
	}

}