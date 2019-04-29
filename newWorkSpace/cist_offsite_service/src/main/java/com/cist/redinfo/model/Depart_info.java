package com.cist.redinfo.model;
/**
 * 单位表
 * @author wxc
 *
 */
public class Depart_info {
	private String  dept_pk;// 主键
	private String dept_name;// 名字
	public String getDept_pk() {
		return dept_pk;
	}
	public void setDept_pk(String dept_pk) {
		this.dept_pk = dept_pk;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
}
