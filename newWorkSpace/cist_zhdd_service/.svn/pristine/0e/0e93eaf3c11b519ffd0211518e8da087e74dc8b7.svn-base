package com.cist.quarters.model;

import java.io.Serializable;
import java.util.List;

import net.sf.json.JSONObject;

/***
 * 功能配置类型
 * @author admin
 *
 */
public class Functiontype implements Serializable{
	private static final long serialVersionUID = 1L;
    private Integer pk_id;//ID
    private String type_name;//类型名称（告警信息、GPS图层、设备图层、业务图层）
    private List<Functionconf> functionconf;//配置基础信息集合
 
	public List<Functionconf> getFunctionconf() {
		return functionconf;
	}
	public void setFunctionconf(List<Functionconf> functionconf) {
		this.functionconf = functionconf;
	}
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Functiontype(Integer pk_id, String type_name) {
		super();
		this.pk_id = pk_id;
		this.type_name = type_name;
	}
	public Functiontype() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
