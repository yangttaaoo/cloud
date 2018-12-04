package com.cist.warningmanagement.controlcar.model;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class Kklx {
	private String fk_dept_id;// 部门Id
	private String dept_name;
	private String device_name;// 卡口名字
	private String device_num;// 卡口编号
	private String road_name;// 道路名称
	private String direction;// 方向名称
	private Integer longitude;//经度
	private Integer latitude;//纬度
    
	
	public Integer getLongitude() {
		return longitude;
	}

	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}

	public Integer getLatitude() {
		return latitude;
	}

	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}
   
	public String getDept_name() {
		if(fk_dept_id!=null){
//			dept_name=SysTempStoreUtils.getDeptName(fk_dept_id);
			dept_name=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT, fk_dept_id);
		}
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getFk_dept_id() {
		return fk_dept_id;
	}

	public void setFk_dept_id(String fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}

	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

	public String getDevice_num() {
		return device_num;
	}

	public void setDevice_num(String device_num) {
		this.device_num = device_num;
	}

	public String getRoad_name() {
		return road_name;
	}

	public void setRoad_name(String road_name) {
		this.road_name = road_name;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

}
