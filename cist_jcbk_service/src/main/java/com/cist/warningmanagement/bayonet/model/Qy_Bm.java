package com.cist.warningmanagement.bayonet.model;

/**
 * 区域 部门
 * 
 * @author wxc
 *
 */
public class Qy_Bm {
	
	private String kkbh;// 卡口编号
	private String qy_code;// 区域编码
	private String dept_code;// 部门编码
	private String qy_code_name;
	private String dept_code_name;

	public String getKkbh() {
		return kkbh;
	}

	public void setKkbh(String kkbh) {
		this.kkbh = kkbh;
	}

	public String getQy_code() {
		return qy_code;
	}

	public void setQy_code(String qy_code) {
		this.qy_code = qy_code;
	}

	public String getDept_code() {
		return dept_code;
	}

	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}

	public String getQy_code_name() {
		return qy_code_name;
	}

	public void setQy_code_name(String qy_code_name) {
		this.qy_code_name = qy_code_name;
	}

	public String getDept_code_name() {
		return dept_code_name;
	}

	public void setDept_code_name(String dept_code_name) {
		this.dept_code_name = dept_code_name;
	}

}
