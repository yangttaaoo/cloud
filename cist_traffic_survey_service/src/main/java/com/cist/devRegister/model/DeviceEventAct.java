package com.cist.devRegister.model;
//5.9.设备事件检测(JCSJ_DEVICE_EVENT_ACT)
public class DeviceEventAct {
	private int device_id;
	private int fk_event_act_id;
	
	
	
	public DeviceEventAct() {
	
	}
	public int getDevice_id() {
		return device_id;
	}
	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}
	public int getFk_event_act_id() {
		return fk_event_act_id;
	}
	public void setFk_event_act_id(int fk_event_act_id) {
		this.fk_event_act_id = fk_event_act_id;
	}
	
	
	
}
