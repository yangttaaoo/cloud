package com.cist.realTimeMonitor.model;

import java.math.BigDecimal;
import java.util.List;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class DeptDeviceTree {
	//设备信息
	//纬度
	private BigDecimal latitude;
	//经度
	private BigDecimal longitude;
//	设备国标序列号
	private String device_gb_serial;
//	设备国标编码
	private String device_gb_code;
//	设备国标通道号
	private String device_gb_channel;
	// 参考SYS_FRM_CODE表 FCT_CODE=P015)
	private char device_gb_ptz;
	//设备状态
	private Integer status;
	
	private Long fk_dept_id;
	private String fk_dept_name;
	private String fk_device_type;
	private String fk_device_name;
	private String direction;
	
	
	
	
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getFk_device_name() {
			return SysTempStoreUtils.getFcName(SysBaseDataCode.DEVICE_TYPE_CODE, fk_device_type);
	}

	public void setFk_device_name(String fk_device_name) {
		this.fk_device_name = fk_device_name;
	}

	public String getFk_device_type() {
		return fk_device_type;
	}

	public void setFk_device_type(String fk_device_type) {
		this.fk_device_type = fk_device_type;
	}

	public String getFk_dept_name() {
		if(null!=fk_dept_id)
		return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT, Long.toString(fk_dept_id));
		return null;
	}

	public void setFk_dept_name(String fk_dept_name) {
		this.fk_dept_name	 = fk_dept_name;
	}

	public Long getFk_dept_id() {
		return fk_dept_id;
	}

	public void setFk_dept_id(Long fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}

	private Integer childrenDevNum;
	public Integer getChildrenDevNum() {
		return childrenDevNum;
	}

	public void setChildrenDevNum(Integer childrenDevNum) {
		this.childrenDevNum = childrenDevNum;
	}

	private String title;
	private String key;
	private List<DeptDeviceTree> children = null;
	private boolean selectable = true;
	private boolean isLeaf = false;
	private boolean expanded=false;
	private Long pk;

	private boolean isDept = false;
	private boolean isDevice = true;

	public DeptDeviceTree() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<DeptDeviceTree> getChildren() {
		return children;
	}

	public void setChildren(List<DeptDeviceTree> children) {
		this.children = children;
	}

	public boolean isSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public boolean getIsLeaf() {
		if(isDevice) {
			return isDevice;
		}
		return isLeaf;
	}

	public void setIsLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public boolean getIsDept() {
		return isDept;
	}

	public void setIsDept(boolean isDept) {
		this.isDept = isDept;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public boolean getIsDevice() {
		return isDevice;
	}

	public void setIsDevice(boolean isDevice) {
		this.isDevice = isDevice;
	}

	public String getDevice_gb_serial() {
		return device_gb_serial;
	}

	public void setDevice_gb_serial(String device_gb_serial) {
		this.device_gb_serial = device_gb_serial;
	}

	public String getDevice_gb_code() {
		return device_gb_code;
	}

	public void setDevice_gb_code(String device_gb_code) {
		this.device_gb_code = device_gb_code;
	}

	public String getDevice_gb_channel() {
		return device_gb_channel;
	}

	public void setDevice_gb_channel(String device_gb_channel) {
		this.device_gb_channel = device_gb_channel;
	}

	public char getDevice_gb_ptz() {
		return device_gb_ptz;
	}

	public void setDevice_gb_ptz(char device_gb_ptz) {
		this.device_gb_ptz = device_gb_ptz;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public boolean getExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}


	
	
	
	
	
	
	
}
