package com.cist.wobacklog.model;

import java.util.Date;

public class JtywJobProcess {
    private Integer pk_id;

    private Integer fk_job_num;

    private Integer fk_d_operator_id;

    private Date distribution_time;

    private Integer fk_r_operator_id;

    private Date receive_time;

    private Integer fk_c_operator_id;

    private Date complete_time;

    private String fk_job_status;

	public Integer getPk_id() {
		return pk_id;
	}

	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}

	public Integer getFk_job_num() {
		return fk_job_num;
	}

	public void setFk_job_num(Integer fk_job_num) {
		this.fk_job_num = fk_job_num;
	}

	public Integer getFk_d_operator_id() {
		return fk_d_operator_id;
	}

	public void setFk_d_operator_id(Integer fk_d_operator_id) {
		this.fk_d_operator_id = fk_d_operator_id;
	}

	public Date getDistribution_time() {
		return distribution_time;
	}

	public void setDistribution_time(Date distribution_time) {
		this.distribution_time = distribution_time;
	}

	public Integer getFk_r_operator_id() {
		return fk_r_operator_id;
	}

	public void setFk_r_operator_id(Integer fk_r_operator_id) {
		this.fk_r_operator_id = fk_r_operator_id;
	}

	public Date getReceive_time() {
		return receive_time;
	}

	public void setReceive_time(Date receive_time) {
		this.receive_time = receive_time;
	}

	public Integer getFk_c_operator_id() {
		return fk_c_operator_id;
	}

	public void setFk_c_operator_id(Integer fk_c_operator_id) {
		this.fk_c_operator_id = fk_c_operator_id;
	}

	public Date getComplete_time() {
		return complete_time;
	}

	public void setComplete_time(Date complete_time) {
		this.complete_time = complete_time;
	}

	public String getFk_job_status() {
		return fk_job_status;
	}

	public void setFk_job_status(String fk_job_status) {
		this.fk_job_status = fk_job_status;
	}

}