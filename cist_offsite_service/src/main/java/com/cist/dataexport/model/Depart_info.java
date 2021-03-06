/**
 * 
 */
package com.cist.dataexport.model;

import java.io.Serializable;
import java.util.List;


/**
 * 单位树结构
 *
 */
public class Depart_info implements Serializable{
	private static final long serialVersionUID = 2862837302776031507L;
    private Integer  dept_pk;//ID
    private String dept_code;//部门代码
    private String  name;//简称部门简称
    private Integer dept_superior;//上级ID
    private List<Monitorpoint> monitorpointlist=null;//安装地址 集合
    private List<Depart_info> children=null;
	private Boolean selectable=false;//设置节点是否可被选中
    private String tbmp_id;//pk
    private String tbmp_dept_code;//部门
    private String tbmp_azdz;//安装地址（上传违法到六合一时使用该字段）
    private Boolean isLeaf=false;
    
	public Boolean getIsLeaf() {
		if(null!=tbmp_azdz&&tbmp_azdz!="") {
			return true;
		}
		return isLeaf;
	}


	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}


	public Boolean getSelectable() {
		if(null!=tbmp_azdz&&tbmp_azdz!="") {
			return true;
		}
		return selectable;
	}


	public void setSelectable(Boolean selectable) {
		this.selectable = selectable;
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


	public List<Monitorpoint> getMonitorpointlist() {
		return monitorpointlist;
	}


	public void setMonitorpointlist(List<Monitorpoint> monitorpointlist) {
		this.monitorpointlist = monitorpointlist;
	}


	public List<Depart_info> getChildren() {
		return children;
	}


	public void setChildren(List<Depart_info> children) {
		this.children = children;
	}


	


	public String getTbmp_dept_code() {
		return tbmp_dept_code;
	}


	public void setTbmp_dept_code(String tbmp_dept_code) {
		this.tbmp_dept_code = tbmp_dept_code;
	}


	public String getTbmp_azdz() {
		return tbmp_azdz;
	}


	public void setTbmp_azdz(String tbmp_azdz) {
		this.tbmp_azdz = tbmp_azdz;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Depart_info() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getTbmp_id() {
		return tbmp_id;
	}


	public void setTbmp_id(String tbmp_id) {
		this.tbmp_id = tbmp_id;
	}


	public Depart_info(Integer dept_pk, String dept_code, String name, Integer dept_superior,
			List<Monitorpoint> monitorpointlist, List<Depart_info> children, String tbmp_id, String tbmp_dept_code,
			String tbmp_azdz) {
		super();
		this.dept_pk = dept_pk;
		this.dept_code = dept_code;
		this.name = name;
		this.dept_superior = dept_superior;
		this.monitorpointlist = monitorpointlist;
		this.children = children;
		this.tbmp_id = tbmp_id;
		this.tbmp_dept_code = tbmp_dept_code;
		this.tbmp_azdz = tbmp_azdz;
	}
    
    
    
}
