package com.cist.personalentry.model;

import java.io.Serializable;
import java.util.List;

import com.cist.qwgl.qwbb.model.Jcsj_police_res_person;

public class PoliceInfo implements Serializable{
	private static final long serialVersionUID = 2862837302776031507L;
    private Integer  dept_pk;//ID
    private String dept_code;//部门代码
    private String  name;//简称部门简称
    private Integer dept_superior;//上级ID
    private List<PoliceInfo> children;
    private Boolean selectable=false;//设置节点是否可被选中
    private Boolean isLeaf=false;
    private String sypi_code;//警员编号
    private String sypi_name;//警员名称
	private Integer sypi_dept;//警员所属部门
	
	
	public PoliceInfo(Integer dept_pk, String dept_code, String name,
			Integer dept_superior, List<PoliceInfo> children,
			Boolean selectable, Boolean isLeaf, String sypi_code,
			String sypi_name, Integer sypi_dept) {
		super();
		this.dept_pk = dept_pk;
		this.dept_code = dept_code;
		this.name = name;
		this.dept_superior = dept_superior;
		this.children = children;
		this.selectable = selectable;
		this.isLeaf = isLeaf;
		this.sypi_code = sypi_code;
		this.sypi_name = sypi_name;
		this.sypi_dept = sypi_dept;
	}
	public PoliceInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getDept_pk() {
		return dept_pk;
	}
	public void setDept_pk(Integer dept_pk) {
		this.dept_pk = dept_pk;
	}
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDept_superior() {
		return dept_superior;
	}
	public void setDept_superior(Integer dept_superior) {
		this.dept_superior = dept_superior;
	}
	public List<PoliceInfo> getChildren() {
		return children;
	}
	public void setChildren(List<PoliceInfo> children) {
		this.children = children;
	}
	public Boolean getSelectable() {
		if(null!=sypi_code&&sypi_code!="") {
			return true;
		}
		return selectable;
	}
	public void setSelectable(Boolean selectable) {
		this.selectable = selectable;
	}
	public Boolean getIsLeaf() {
		if(null!=sypi_code&&sypi_code!="") {
			return true;
		}
		return isLeaf;
	}
	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public String getSypi_code() {
		return sypi_code;
	}
	public void setSypi_code(String sypi_code) {
		this.sypi_code = sypi_code;
	}
	public String getSypi_name() {
		return sypi_name;
	}
	public void setSypi_name(String sypi_name) {
		this.sypi_name = sypi_name;
	}
	public Integer getSypi_dept() {
		return sypi_dept;
	}
	public void setSypi_dept(Integer sypi_dept) {
		this.sypi_dept = sypi_dept;
	}
	
}
