package com.cist.devRegister.model;

import java.util.List;

public class RoadTree {
	private String title;
	private String key;
	private List<RoadTree> children = null;
	private boolean selectable = true;
	private boolean isLeaf = true;
	private Long pk;
	
	private int road_type;
	private boolean isRoad=false;
	
	
	

	public boolean getIsRoad() {
		return isRoad;
	}

	public void setIsRoad(boolean isRoad) {
		this.isRoad = isRoad;
	}

	public int getRoad_type() {
		return road_type;
	}

	public void setRoad_type(int road_type) {
		this.road_type = road_type;
	}

	public RoadTree() {
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

	public List<RoadTree> getChildren() {
		return children;
	}

	public void setChildren(List<RoadTree> children) {
		this.children = children;
	}

	public boolean getIsSelectable() {
		return selectable;
	}

	public void setIsSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public boolean getIsLeaf() {
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

}
