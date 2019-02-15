package com.cist.kreis.model;

import java.io.Serializable;
import java.util.List;


public class TbekInfo implements Serializable{
	private static final long serialVersionUID = 2862837302776031507L;
	private Integer tbek_pk;//主键
	private String tbek_code;//行政区代码
	private String tbek_name;//行政区名称
	private Integer tbek_parent;//父行政区划
	private Boolean selectable=true;//设置节点是否可被选中
    private Boolean isLeaf=false;
    private List<TbekInfo> children;
    
    
    
	public TbekInfo() {
		super();
	}
	public TbekInfo(Integer tbek_pk, String tbek_code, String tbek_name,
			Integer tbek_parent, List<TbekInfo> children) {
		super();
		this.tbek_pk = tbek_pk;
		this.tbek_code = tbek_code;
		this.tbek_name = tbek_name;
		this.tbek_parent = tbek_parent;
		this.children = children;
	}
	public Integer getTbek_pk() {
		return tbek_pk;
	}
	public void setTbek_pk(Integer tbek_pk) {
		this.tbek_pk = tbek_pk;
	}
	public String getTbek_code() {
		return tbek_code;
	}
	public void setTbek_code(String tbek_code) {
		this.tbek_code = tbek_code;
	}
	public String getTbek_name() {
		return tbek_name;
	}
	public void setTbek_name(String tbek_name) {
		this.tbek_name = tbek_name;
	}
	public Integer getTbek_parent() {
		return tbek_parent;
	}
	public void setTbek_parent(Integer tbek_parent) {
		this.tbek_parent = tbek_parent;
	}
	public Boolean getSelectable() {
		if(null!=tbek_code&&tbek_code!="") {
			return true;
		}
		return selectable;
	}
	public void setSelectable(Boolean selectable) {
		this.selectable = selectable;
	}
	public Boolean getIsLeaf() {
		if(children==null) {
			return true;
		}
		return isLeaf;
	}
	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public List<TbekInfo> getChildren() {
		return children;
	}
	public void setChildren(List<TbekInfo> children) {
		this.children = children;
	}
    
    
}
