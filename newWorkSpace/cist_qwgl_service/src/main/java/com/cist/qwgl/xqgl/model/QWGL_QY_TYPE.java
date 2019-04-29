package com.cist.qwgl.xqgl.model;

import java.io.Serializable;
/**
 * 区域类型实体类
 * @author Administrator
 *
 */
public class QWGL_QY_TYPE implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6543830494126217523L;
	private Integer qy_pk;
	private String qy_type_name;//区域类型名称
	public Integer getQy_pk() {
		return qy_pk;
	}
	public void setQy_pk(Integer qy_pk) {
		this.qy_pk = qy_pk;
	}
	public String getQy_type_name() {
		return qy_type_name;
	}
	public void setQy_type_name(String qy_type_name) {
		this.qy_type_name = qy_type_name;
	}
	
}
