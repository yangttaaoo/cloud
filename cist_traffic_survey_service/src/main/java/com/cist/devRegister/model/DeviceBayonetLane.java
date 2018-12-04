package com.cist.devRegister.model;

import java.util.List;

import com.cist.utils.SysTempStoreUtils;

//5.3.卡口车道信息(JCSJ_DEVICE_BAYONET_LANE)
public class DeviceBayonetLane {
	//车道ID
	private long pk_id;
	//设备ID
	private long device_id;
	//车道名称（固定为第1车道、第2车道、……）
	private String lane_name;
	//车道别名
	private String lane_alias_name;
	//车道类型（直行机动车车道、直左混行机动车车道、直右混行机动车车道、左右混行机动车车道、直左右混行机动车车道、
	//左转机动车车道、右转机动车车道、非机动车车道、机动车掉头机动车车道、小客车道、客车道、客货车道、应急车道）
	private char lane_type;
	//进出类型（0：不进出、1：进辖区（城）、2：出辖区（城））
	private char in_out_type;
	//大车限速
	private long speed_limit_big_car;
	//小车限速
	private long speed_limit_small_car;
	//最低限速
	private long speed_limit_minimum;
	//方向类型
	private char direction_type;
	
	private List<Long> devList;
	
	public List<Long> getDevList() {
		List<Long> connectDevIds = SysTempStoreUtils.getConnectDevIds(this.pk_id,this.device_id);
		return connectDevIds;
	}
	public long getPk_id() {
		return pk_id;
	}

	public void setPk_id(long pk_id) {
		this.pk_id = pk_id;
	}

	public long getDevice_id() {
		return device_id;
	}

	public void setDevice_id(long device_id) {
		this.device_id = device_id;
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
