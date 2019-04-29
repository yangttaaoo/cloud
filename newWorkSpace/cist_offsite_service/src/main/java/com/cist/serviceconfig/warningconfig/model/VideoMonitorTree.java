package com.cist.serviceconfig.warningconfig.model;

import java.util.List;

public class VideoMonitorTree {

	private String key;
	private String title;
	private boolean isLeaf = false;
	private List<VideoMonitorTree> children = null;

	public VideoMonitorTree() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean getisLeaf() {
		if(this.getChildren()==null)isLeaf=true;
		return isLeaf;
	}

	public void setisLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public List<VideoMonitorTree> getChildren() {
		return children;
	}

	public void setChildren(List<VideoMonitorTree> children) {
		this.children = children;
	}
	
	@Override
	public String toString() {
		return "VideoMonitorTree [key=" + key + ", title=" + title + ", isLeaf=" + isLeaf + ", children=" + children
				+ "]";
	}

}
