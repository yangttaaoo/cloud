package com.cist.endNumberLimit.model;

import java.util.List;

public class MountTree {
	//监控点方位IDs
		private String tbmp_dire_id;
		//监控点方位名称s
		private String tbmp_dire_no;
	
	private  String title;
	private  String key;
	private  boolean isLeaf=false;
	private  boolean selectable=false;
	private   String level;
	private  List<MountTree> children=null;
	
	
	public boolean isSelectable() {
		if(null==this.getChildren())selectable=true;
		return selectable;
	}


	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}


	public MountTree() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
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
	
	public boolean getisLeaf() {
		if(null==this.getChildren())isLeaf=true;
		return isLeaf;
	}
	public void setisLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	
	


	public List<MountTree> getChildren() {
		return children;
	}


	public void setChildren(List<MountTree> children) {
		this.children = children;
	}


	public String getTbmp_dire_id() {
		return tbmp_dire_id;
	}
	public void setTbmp_dire_id(String tbmp_dire_id) {
		this.tbmp_dire_id = tbmp_dire_id;
	}
	public String getTbmp_dire_no() {
		return tbmp_dire_no;
	}
	public void setTbmp_dire_no(String tbmp_dire_no) {
		this.tbmp_dire_no = tbmp_dire_no;
	}


	@Override
	public String toString() {
		return "MountTree [tbmp_dire_id=" + tbmp_dire_id + ", tbmp_dire_no=" + tbmp_dire_no + ", title=" + title
				+ ", key=" + key + ", isLeaf=" + isLeaf + ", level=" + level + ", children=" + children + "]";
	}
	
	

	
}
