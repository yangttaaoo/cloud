package com.cist.specialTask.model;

import java.math.BigDecimal;


/**
 * 特勤任务路线
 * @author yt
 *
 */
public class ZhddMissionRoute {
    private BigDecimal pk_id;//ID

    private BigDecimal fk_mission_id;//任务ID

    private BigDecimal s_longitude;//起点经度

    private BigDecimal s_latitude;//起点纬度

    private BigDecimal e_longitude;//终点经度

    private BigDecimal e_latitude;//终点纬度

    private String route_line;//路线

	public BigDecimal getPk_id() {
		return pk_id;
	}

	public void setPk_id(BigDecimal pk_id) {
		this.pk_id = pk_id;
	}

	public BigDecimal getFk_mission_id() {
		return fk_mission_id;
	}

	public void setFk_mission_id(BigDecimal fk_mission_id) {
		this.fk_mission_id = fk_mission_id;
	}

	public BigDecimal getS_longitude() {
		return s_longitude;
	}

	public void setS_longitude(BigDecimal s_longitude) {
		this.s_longitude = s_longitude;
	}

	public BigDecimal getS_latitude() {
		return s_latitude;
	}

	public void setS_latitude(BigDecimal s_latitude) {
		this.s_latitude = s_latitude;
	}

	public BigDecimal getE_longitude() {
		return e_longitude;
	}

	public void setE_longitude(BigDecimal e_longitude) {
		this.e_longitude = e_longitude;
	}

	public BigDecimal getE_latitude() {
		return e_latitude;
	}

	public void setE_latitude(BigDecimal e_latitude) {
		this.e_latitude = e_latitude;
	}

	public String getRoute_line() {
		return route_line;
	}

	public void setRoute_line(String route_line) {
		this.route_line = route_line;
	}

}