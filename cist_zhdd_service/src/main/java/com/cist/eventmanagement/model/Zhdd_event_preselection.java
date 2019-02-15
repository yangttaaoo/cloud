package com.cist.eventmanagement.model;

import java.io.Serializable;
/**
 * 预选项
 * @author Hy
 *
 */
public class Zhdd_event_preselection implements Serializable {
	private Integer value;//pk_id
	private String label;//event_preselection
	private Boolean disabled=false;
	private Boolean checked=false;
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Boolean getDisabled() {
		return disabled;
	}
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	
}
