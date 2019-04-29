package com.cist.qwgl.jzgl.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 警组-接处警
 * @author Hy
 *
 */
public class Qw_police_team_alarm implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 2869582385701720360L;
	private Integer pk_id;// ID
	private Integer fk_police_team_id;// 警组id
	private String telephone;// 值班电话
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date work_start_time;// 开始时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date work_end_time;// 结束时间

	public Integer getPk_id() {
		return pk_id;
	}

	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}

	public Integer getFk_police_team_id() {
		return fk_police_team_id;
	}

	public void setFk_police_team_id(Integer fk_police_team_id) {
		this.fk_police_team_id = fk_police_team_id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getWork_start_time() {
		return work_start_time;
	}

	public void setWork_start_time(Date work_start_time) {
		this.work_start_time = work_start_time;
	}

	public Date getWork_end_time() {
		return work_end_time;
	}

	public void setWork_end_time(Date work_end_time) {
		this.work_end_time = work_end_time;
	}

}
