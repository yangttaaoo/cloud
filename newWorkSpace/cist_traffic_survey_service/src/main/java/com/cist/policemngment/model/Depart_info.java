/**
 * 
 */
package com.cist.policemngment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

/**
 * 单位树结构
 *
 */
public class Depart_info implements Serializable{
	private static final long serialVersionUID = 2862837302776031507L;
    private Integer  dept_pk;//ID
    private String dept_code;//部门代码
    private String dept_codename;//部门名称
    private String  name;//简称部门简称
    private String key;
    private String car_num;
    private String car_type;
    private String title;
    private Integer dept_superior;//上级ID
    private List<Depart_info> children=new ArrayList<Depart_info>();
	private Boolean selectable=true;//设置节点是否可被选中
    private String tbmp_id;//pk
    private String tbmp_dept_code;//部门
    private String tbmp_azdz;//安装地址（上传违法到六合一时使用该字段）
    private Boolean isLeaf=false;
    private String flag="false";
    private String resources_type;
    private String resources_type_name;
    private String tbec_code;
    private String tbec_kkbh;
    private String tbec_dept_id;
    private String tbei_name;
    private String device_type;
	public String getTbec_code() {
		return tbec_code;
	}


	public void setTbec_code(String tbec_code) {
		this.tbec_code = tbec_code;
	}


	public String getTbec_kkbh() {
		return tbec_kkbh;
	}


	public void setTbec_kkbh(String tbec_kkbh) {
		this.tbec_kkbh = tbec_kkbh;
	}


	public String getTbec_dept_id() {
		return tbec_dept_id;
	}


	public void setTbec_dept_id(String tbec_dept_id) {
		this.tbec_dept_id = tbec_dept_id;
	}


	public String getTbei_name() {
		return tbei_name;
	}


	public void setTbei_name(String tbei_name) {
		this.tbei_name = tbei_name;
	}


	public Boolean getIsLeaf() {
		
		if (children == null){
			return true;
		}
		
		return isLeaf;
	}


	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}


	public Boolean getSelectable() {
		
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




	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}


	public String getResources_type() {
		return resources_type;
	}


	public void setResources_type(String resources_type) {
		this.resources_type = resources_type;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCar_num() {
		return car_num;
	}


	public void setCar_num(String car_num) {
		this.car_num = car_num;
	}


	public String getCar_type() {
		return car_type;
	}


	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}


	public String getDept_codename() {
		if (dept_code != null){
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT, dept_code);
		}
		return dept_codename;
	}


	public void setDept_codename(String dept_codename) {
		
		this.dept_codename = dept_codename;
	}


	public String getResources_type_name() {
		if ( resources_type != null){
			if (resources_type.equals("1")){
				return "警车";
			}else if (resources_type.equals("5")) {
				return "摩托车";
			}else {
				return "电瓶车";
			}
			
		}
		return resources_type_name;
	}


	public void setResources_type_name(String resources_type_name) {
		this.resources_type_name = resources_type_name;
	}


	public String getDevice_type() {
		return device_type;
	}


	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}

}
