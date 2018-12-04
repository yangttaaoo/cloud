package com.cist.devRegister.model;

//5.6.抓拍违法行为(JCSJ_DEVICE_ILLEGAL_ACT)
public class DeviceIllegalAct {

	// 设备ID
	private int device_id;
	// 违法行为ID
	private int fk_illegal_act_id;

	public int getDevice_id() {
		return device_id;
	}

	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}

	public int getFk_illegal_act_id() {
		return fk_illegal_act_id;
	}

	public void setFk_illegal_act_id(int fk_illegal_act_id) {
		this.fk_illegal_act_id = fk_illegal_act_id;
	}

}
