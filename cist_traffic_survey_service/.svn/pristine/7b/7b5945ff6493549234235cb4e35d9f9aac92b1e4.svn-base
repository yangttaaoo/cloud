package com.cist.devRegister.model;

import java.util.List;

public class DeptTree {
 	
	private int dept_pk;
	private int dept_superior;
	private String title;
	private String key;
	private boolean isLeaf = false;
	private boolean selectable = true;
	private String level;
	private List<DeptTree> children = null;

	public boolean isSelectable() {
		if (null == this.getChildren())
			selectable = true;
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public DeptTree() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public int getDept_pk() {
		return dept_pk;
	}

	public void setDept_pk(int dept_pk) {
		this.dept_pk = dept_pk;
	}



	public int getDept_superior() {
		return dept_superior;
	}

	public void setDept_superior(int dept_superior) {
		this.dept_superior = dept_superior;
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
		if (null == this.getChildren())
			isLeaf = true;
		return isLeaf;
	}

	public void setisLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public List<DeptTree> getChildren() {
		return children;
	}

	public void setChildren(List<DeptTree> children) {
		this.children = children;
	}

}
