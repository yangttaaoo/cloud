package com.cist.pdgrzb.model;

import java.util.List;

public class DateList {

	private String value;
	private String label;
	private Boolean isLeaf=false;
	private List<DateList>  children = null;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Boolean getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public List<DateList> getChildren() {
		return children;
	}
	public void setChildren(List<DateList> children) {
		this.children = children;
	}
	
	
}
