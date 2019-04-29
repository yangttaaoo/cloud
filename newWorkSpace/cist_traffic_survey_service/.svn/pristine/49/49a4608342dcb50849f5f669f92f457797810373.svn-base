package com.cist.devRegister.model;

import java.util.Date;

import com.cist.utils.SysTempStoreUtils;

//5.2.设备审核过程(JCSJ_DEVICE_AUDIT_PROCESS)
public class DeviceAuditProcess {
	// 设备ID 
	private int device_id;
	// 审核人
	private String check_person_id;
	// 审核人部门
	private long check_person_dept_id;
	// 审核时间
	private Date check_time;
	// 审核状态（0：不同过，1：通过）
	private char check_status;
	// 不通过原因
	private String uncheck_reason;
	
	
	private String check_person_dept_name;
	
	
	

	public DeviceAuditProcess() {
	}

	public int getDevice_id() {
		return device_id;
	}

	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}

	public String getCheck_person_id() {
		return check_person_id;
	}

	public void setCheck_person_id(String check_person_id) {
		this.check_person_id = check_person_id;
	}

	

	public String getCheck_person_dept_name() {
		return SysTempStoreUtils.getDeptName1(check_person_dept_id);
	}

	public void setCheck_person_dept_name(String check_person_dept_name) {
		this.check_person_dept_name = check_person_dept_name;
	}

	public long getCheck_person_dept_id() {
		
		
		return check_person_dept_id;
	}

	public void setCheck_person_dept_id(long check_person_dept_id) {
		this.check_person_dept_id = check_person_dept_id;
	}

	public Date getCheck_time() {
		return check_time;
	}

	public void setCheck_time(Date check_time) {
		this.check_time = check_time;
	}

	public char getCheck_status() {
		return check_status;
	}

	public void setCheck_status(char check_status) {
		this.check_status = check_status;
	}

	public String getUncheck_reason() {
		return uncheck_reason;
	}

	public void setUncheck_reason(String uncheck_reason) {
		this.uncheck_reason = uncheck_reason;
	}


}
