package com.cist.earlyewarningpost.model;

import java.math.BigDecimal;
import java.util.Date;

//受理信息
public class JcbkWarningAcceptance {
    private BigDecimal pk_id;//ID

    private BigDecimal fk_warning_id;//预警ID

    private BigDecimal fk_acceptance_dept_id;//操作人单位ID

    private BigDecimal fk_acceptance_person_id;//操作人ID

    private Date acceptance_time;//操作时间

    private String acceptance_state;//操作状态（0-已受理且无效、1-已受理且有效、2-已下发）

    private String wxyy;//无效原因（参考SYS_FRM_CODE表FCT_CODE=JC01）

    private String fk_forward_dept_id;//转发单位ID

    private Date forward_time;//转发时间

    private String sypi_name;
    
	public BigDecimal getPk_id() {
		return pk_id;
	}

	public void setPk_id(BigDecimal pk_id) {
		this.pk_id = pk_id;
	}

	public BigDecimal getFk_warning_id() {
		return fk_warning_id;
	}

	public void setFk_warning_id(BigDecimal fk_warning_id) {
		this.fk_warning_id = fk_warning_id;
	}

	public BigDecimal getFk_acceptance_dept_id() {
		return fk_acceptance_dept_id;
	}

	public void setFk_acceptance_dept_id(BigDecimal fk_acceptance_dept_id) {
		this.fk_acceptance_dept_id = fk_acceptance_dept_id;
	}

	public BigDecimal getFk_acceptance_person_id() {
		return fk_acceptance_person_id;
	}

	public void setFk_acceptance_person_id(BigDecimal fk_acceptance_person_id) {
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

	public String getWxyy() {
		return wxyy;
	}

	public void setWxyy(String wxyy) {
		this.wxyy = wxyy;
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

	public String getSypi_name() {
		return sypi_name;
	}

	public void setSypi_name(String sypi_name) {
		this.sypi_name = sypi_name;
	}

}