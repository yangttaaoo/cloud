package com.cist.serviceconfig.warningconfig.model;

import java.io.Serializable;
import java.util.List;

import com.cist.picture.model.Monitorpoint;


public class DeptInfo implements Serializable{
	private static final long serialVersionUID = 2862837302776031507L;
    private Integer  dept_pk;//ID
    private String dept_code;//部门代码
    private String  name;//简称部门简称
    private Integer dept_superior;//上级ID
    private List<DevInfo> devlist=null;
    private List<Monitorpoint> monitorpointlist=null;//安装地址 集合
    private List<DeptInfo> children;
    private Boolean selectable=false;//设置节点是否可被选中
    private String tbmp_id;//pk
    private String tbmp_dept_code;//部门
    private String tbmp_azdz;//安装地址（上传违法到六合一时使用该字段）
    private Boolean isLeaf=false;
    private String tbei_code;//设备编号
    private String tbei_name;//设备名称
	private String tbec_dept_id;//设备所属部门
	private String sypi_code;//设备编号
    private String sypi_name;//设备名称
	private String sypi_dept;//设备所属部门
	private Boolean isDept=false;//是否为设备
	
	

	public DeptInfo(Integer dept_pk, String dept_code, String name,
			Integer dept_superior, List<DevInfo> devlist,
			List<Monitorpoint> monitorpointlist, List<DeptInfo> children,
			Boolean selectable, String tbmp_id, String tbmp_dept_code,
			String tbmp_azdz, Boolean isLeaf, String tbei_code,
			String tbei_name, String tbec_dept_id) {
		super();
		this.dept_pk = dept_pk;
		this.dept_code = dept_code;
		this.name = name;
		this.dept_superior = dept_superior;
		this.devlist = devlist;
		this.monitorpointlist = monitorpointlist;
		this.children = children;
		this.selectable = selectable;
		this.tbmp_id = tbmp_id;
		this.tbmp_dept_code = tbmp_dept_code;
		this.tbmp_azdz = tbmp_azdz;
		this.isLeaf = isLeaf;
		this.tbei_code = tbei_code;
		this.tbei_name = tbei_name;
		this.tbec_dept_id = tbec_dept_id;
	}


	public Boolean getIsLeaf() {
		if(null!=tbei_code&&tbei_code!="") {
			return true;
		}
		return isLeaf;
	}


	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public List<Monitorpoint> getMonitorpointlist() {
		return monitorpointlist;
	}

	public void setMonitorpointlist(List<Monitorpoint> monitorpointlist) {
		this.monitorpointlist = monitorpointlist;
	}

	public String getTbmp_id() {
		return tbmp_id;
	}

	public void setTbmp_id(String tbmp_id) {
		this.tbmp_id = tbmp_id;
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

	public Boolean getSelectable() {
		if(null!=tbei_code&&tbei_code!="") {
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
	
	public DeptInfo() {
		super();
	}


	public Boolean getIsDept() {
		return isDept;
	}


	public void setIsDept(Boolean isDept) {
		this.isDept = isDept;
	}
	
}
