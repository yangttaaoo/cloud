package com.cist.earlywarning.model;

import java.io.Serializable;
import java.util.List;




public class DeptInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer  dept_pk;//ID
	private String  name;//简称部门简称
	private List<DeptInfo> children;
	private Boolean isLeaf=false;
	
	public DeptInfo(Integer dept_pk,String name,List<DeptInfo> children){
		super();
		this.dept_pk = dept_pk;
		this.name = name;
		this.children = children;
	}

	public Integer getDept_pk() {
		return dept_pk;
	}

	public void setDept_pk(Integer dept_pk) {
		this.dept_pk = dept_pk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DeptInfo> getChildren() {
		return children;
	}

	public void setChildren(List<DeptInfo> children) {
		if(this.children!=null){
			if(children.size()!=0){
				this.children.addAll(children);
			}
			}else{
				this.children=children;
			}
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
	public DeptInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
