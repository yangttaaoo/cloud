package com.cist.duty.model;

import java.io.Serializable;

public class DutyInfo implements Serializable{
	
	private static final long serialVersionUID = 2862837302776031507L;
	private Integer sypi_dept;//所属部门
	private Integer sypi_pk;//警员编号
	private String sypi_dept_name;//所属部门名称
	private String dept_head;//部门负责人
	private Integer dept_pk;//部门PK
	private String sypi_name;//警员名称
	private Integer pm;//排名
	private Integer eva_num;//指标分数
	private Integer zf;//考核得分
	private String hg;//是否合格
	private Boolean expand=false;
	
	
	public Integer getDept_pk() {
		return dept_pk;
	}
	public void setDept_pk(Integer dept_pk) {
		this.dept_pk = dept_pk;
	}
	public String getDept_head() {
		return dept_head;
	}
	public void setDept_head(String dept_head) {
		this.dept_head = dept_head;
	}
	public Integer getSypi_pk() {
		return sypi_pk;
	}
	public void setSypi_pk(Integer sypi_pk) {
		this.sypi_pk = sypi_pk;
	}
	public Boolean getExpand() {
		return expand;
	}
	public void setExpand(Boolean expand) {
		this.expand = expand;
	}
	public Integer getSypi_dept() {
		return sypi_dept;
	}
	public void setSypi_dept(Integer sypi_dept) {
		this.sypi_dept = sypi_dept;
	}
	public String getSypi_dept_name() {
		return sypi_dept_name;
	}
	public void setSypi_dept_name(String sypi_dept_name) {
		this.sypi_dept_name = sypi_dept_name;
	}
	public String getSypi_name() {
		return sypi_name;
	}
	public void setSypi_name(String sypi_name) {
		this.sypi_name = sypi_name;
	}
	public Integer getPm() {
		return pm;
	}
	public void setPm(Integer pm) {
		this.pm = pm;
	}
	public Integer getEva_num() {
		return eva_num;
	}
	public void setEva_num(Integer eva_num) {
		this.eva_num = eva_num;
	}
	public Integer getZf() {
		return zf;
	}
	public void setZf(Integer zf) {
		this.zf = zf;
	}
	public String getHg() {
		return hg;
	}
	public void setHg(String hg) {
		this.hg = hg;
	}
	

}
