package com.cist.qwgl.qwpb.model;

import java.io.Serializable;
import java.util.List;
/**
 * 勤务排版查看
 * @author Administrator
 *
 */
public class QWGL_QWPB_TJ implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7355561421204904411L;
	private String sj;
	private List<DEPT> dept;
	private Integer rownum;
	public String getSj() {
		return sj;
	}
	public void setSj(String sj) {
		this.sj = sj;
	}
	public List<DEPT> getDept() {
		return dept;
	}
	public void setDept(List<DEPT> dept) {
		this.dept = dept;
	}
	public Integer getRownum() {
		return rownum;
	}
	public void setRownum(Integer rownum) {
		this.rownum = rownum;
	}
	
}
