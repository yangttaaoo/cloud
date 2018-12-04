/**
 * 
 */
package com.cist.picture.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class Monitorpoint implements Serializable{
	private static final long serialVersionUID = 6413594393324980833L;
    private Integer tbmp_pk;//pk
    private String tbmp_dept_code;//部门
    private String tbmp_name;//监控点名称（本平台自己显示使用）
    private String tbmp_azdz;//安装地址（上传违法到六合一时使用该字段）
	
	public Monitorpoint(Integer tbmp_pk, String tbmp_dept_code,
			String tbmp_name, String tbmp_azdz) {
		super();
		this.tbmp_pk = tbmp_pk;
		this.tbmp_dept_code = tbmp_dept_code;
		this.tbmp_name = tbmp_name;
		this.tbmp_azdz = tbmp_azdz;
	}

	public Integer getTbmp_pk() {
		return tbmp_pk;
	}

	public void setTbmp_pk(Integer tbmp_pk) {
		this.tbmp_pk = tbmp_pk;
	}

	public String getTbmp_dept_code() {
		return tbmp_dept_code;
	}

	public void setTbmp_dept_code(String tbmp_dept_code) {
		this.tbmp_dept_code = tbmp_dept_code;
	}

	public String getTbmp_name() {
		return tbmp_name;
	}

	public void setTbmp_name(String tbmp_name) {
		this.tbmp_name = tbmp_name;
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

	public Monitorpoint() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
