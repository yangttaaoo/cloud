package com.cist.policemngment.model;

import java.math.BigDecimal;
import java.util.List;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class DeptDeviceTree {
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


	public boolean getIsDevice() {
		return isDevice;
	}

	public void setIsDevice(boolean isDevice) {
		this.isDevice = isDevice;
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
