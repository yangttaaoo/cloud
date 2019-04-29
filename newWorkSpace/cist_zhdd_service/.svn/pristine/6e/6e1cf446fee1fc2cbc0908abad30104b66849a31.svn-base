package com.cist.smsmodule.modle;

import java.io.Serializable;
import java.util.List;


public class DeptInfo implements Serializable{
	private static final long serialVersionUID = 2862837302776031507L;
    private Integer  dept_pk;//ID
    private String dept_code;//部门代码
    private String  name;//简称部门简称
    private String dept_name;
    private Integer dept_superior;//上级ID
    private List<DevInfo> devlist;
    private List<DeptInfo> children;
    private Boolean selectable=true;//设置节点是否可被选中
    private Boolean isLeaf=false;
    
    private String tbei_code;//设备编号
    private String tbei_name;//设备名称
	private String tbec_dept_id;//设备所属部门
	
	public DeptInfo(Integer dept_pk, String dept_code, String name,
			Integer dept_superior, List<DevInfo> devlist,
			List<DeptInfo> children, String tbei_code, String tbec_dept_id){
		
		super();
		this.dept_pk = dept_pk;
		this.dept_code = dept_code;
		this.name = name;
		this.dept_superior = dept_superior;
		this.devlist = devlist;
		this.children = children;
		this.tbei_code = tbei_code;
		this.tbec_dept_id = tbec_dept_id;
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


	public Boolean getSelectable() {
		if(null!=dept_code&&dept_code!="") {
			return true;
		}
		return selectable;
	}


	public void setSelectable(Boolean selectable) {
		this.selectable = selectable;
	}

	public String getTbei_name() {
		return tbei_name;
	}

	public void setTbei_name(String tbei_name) {
		this.tbei_name = tbei_name;
	}


	public String getDept_code() {
		return dept_code;
	}

	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
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

	public Integer getDept_superior() {
		return dept_superior;
	}

	public void setDept_superior(Integer dept_superior) {
		this.dept_superior = dept_superior;
	}

	public List<DevInfo> getDevlist() {
		return devlist;
	}

	public void setDevlist(List<DevInfo> devlist) {
		this.devlist = devlist;
	}



	public List<DeptInfo> getChildren() {
		return children;
	}

	public void setChildren(List<DeptInfo> children) {
		this.children = children;
	}

	public String getTbei_code() {
		return tbei_code;
	}

	public void setTbei_code(String tbei_code) {
		this.tbei_code = tbei_code;
	}

	public String getTbec_dept_id() {
		return tbec_dept_id;
	}

	public void setTbec_dept_id(String tbec_dept_id) {
		this.tbec_dept_id = tbec_dept_id;
	}
	
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public DeptInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
