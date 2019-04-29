package com.cist.devRegister.model;

public class DeviceBayonetInfo {

	// 设备ID
	private long device_id;
	// 车道ID
	private long lane_id;
	private String relevance_device_id;
	private char bayonet_type;
	private char bayonet_nature;
	private String lane_name;
	private String lane_alias_name;
	private char lane_type;
	private char in_out_type;
	private long speed_limit_big_car;
	private long speed_limit_small_car;
	private long speed_limit_minimum;
	//方向类型
	private char direction_type;
	public long getDevice_id() {
		return device_id;
	}

	public void setDevice_id(long device_id) {
		this.device_id = device_id;
	}

	public long getLane_id() {
		return lane_id;
	}

	public void setLane_id(long lane_id) {
		this.lane_id = lane_id;
	}

	public String getRelevance_device_id() {
		return relevance_device_id;
	}

	public void setRelevance_device_id(String relevance_device_id) {
		this.relevance_device_id = relevance_device_id;
	}

	public char getBayonet_type() {
		return bayonet_type;
	}

	public void setBayonet_type(char bayonet_type) {
		this.bayonet_type = bayonet_type;
	}

	public char getBayonet_nature() {
		return bayonet_nature;
	}

	public void setBayonet_nature(char bayonet_nature) {
		this.bayonet_nature = bayonet_nature;
	}

	public String getLane_name() {
		return lane_name;
	}

	public void setLane_name(String lane_name) {
		this.lane_name = lane_name;
	}

	public String getLane_alias_name() {
		return lane_alias_name;
	}

	public void setLane_alias_name(String lane_alias_name) {
		this.lane_alias_name = lane_alias_name;
	}

	public char getLane_type() {
		return lane_type;
	}

	public void setLane_type(char lane_type) {
		this.lane_type = lane_type;
	}

	public char getIn_out_type() {
		return in_out_type;
	}

	public void setIn_out_type(char in_out_type) {
		this.in_out_type = in_out_type;
	}

	public long getSpeed_limit_big_car() {
		return speed_limit_big_car;
	}

	public void setSpeed_limit_big_car(long speed_limit_big_car) {
		this.speed_limit_big_car = speed_limit_big_car;
	}

	public long getSpeed_limit_small_car() {
		return speed_limit_small_car;
	}

	public void setSpeed_limit_small_car(long speed_limit_small_car) {
		this.speed_limit_small_car = speed_limit_small_car;
	}

	public long getSpeed_limit_minimum() {
		return speed_limit_minimum;
	}

	public void setSpeed_limit_minimum(long speed_limit_minimum) {
		this.speed_limit_minimum = speed_limit_minimum;
	}

	public char getDirection_type() {
		return direction_type;
	}

	public void setDirection_type(char direction_type) {
		this.direction_type = direction_type;
	}

}
