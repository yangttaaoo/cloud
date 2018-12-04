package com.cist.devRegister.model;
//5.5.具备功能(JCSJ_DEVICE_HAVE_FUNCTION)
public class DeviceHaveFunction {
	// 设备ID
	private int device_id;
	// 具备功能ID
	private int fk_have_function;

	public DeviceHaveFunction() {

	}

	public int getDevice_id() {
		return device_id;
	}

	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}

	public int getFk_have_function() {
		return fk_have_function;
	}

	public void setFk_have_function(int fk_have_function) {
		this.fk_have_function = fk_have_function;
	}

}
