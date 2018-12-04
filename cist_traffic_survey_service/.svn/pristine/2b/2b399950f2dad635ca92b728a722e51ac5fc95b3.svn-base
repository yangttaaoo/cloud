package com.cist.devRegister.model;

import java.util.List;

public class KreisTree {

	private int tbek_pk;
	private String tbek_parent;
	private String title;
	private String key;
	private boolean isLeaf = false;
	private boolean selectable = false;
	private String level;
	private List<KreisTree> children = null;

	public boolean isSelectable() {
		if (null == this.getChildren())
			selectable = true;
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public KreisTree() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTbek_pk() {
		return tbek_pk;
	}

	public void setTbek_pk(int tbek_pk) {
		this.tbek_pk = tbek_pk;
	}

	public String getTbek_parent() {
		return tbek_parent;
	}

	public void setTbek_parent(String tbek_parent) {
		this.tbek_parent = tbek_parent;
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

	public List<KreisTree> getChildren() {
		return children;
	}

	public void setChildren(List<KreisTree> children) {
		this.children = children;
	}

}
