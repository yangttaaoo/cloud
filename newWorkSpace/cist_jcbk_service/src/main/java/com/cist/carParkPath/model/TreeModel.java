package com.cist.carParkPath.model;

import java.util.List;

public class TreeModel {

	private String title;
	private String key;
	private List<TreeModel> children = null;
	private boolean selectable = true;
	private boolean isLeaf = false;
	private boolean expanded = false;
	private Long pk;
	// 是否为停车场节点
	private boolean isPark = true;
	// 是否为行政区划节点
	private boolean isArea = false;

	public TreeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean getIsArea() {
		return isArea;
	}

	public void setIsArea(boolean isArea) {
		this.isArea = isArea;
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

	public List<TreeModel> getChildren() {
		return children;
	}

	public void setChildren(List<TreeModel> children) {
		this.children = children;
	}

	public boolean isSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public boolean getIsLeaf() {
		if (isPark) {
			return isPark;
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

	public boolean getIsPark() {
		return isPark;
	}

	public void setIsPark(boolean isPark) {
		this.isPark = isPark;
	}

	public boolean getExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

}
