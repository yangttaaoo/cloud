package com.cist.qwgl.jzgl.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 班次实体类
 * @author hy
 *
 */
public class Qwgl_bc_info implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7770353961429866281L;
	private Integer bc_pk;
	private String bc_name;//班次名称 
	private String dept_pk;//单位id
	private String qwlx_pk;//勤务类型id
	private String sfqy;//是否启用 0：是 1：否
	private String sfqyname;//是否启用 0：是 1：否
	 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date bc_kssj;//班次开始时间
	 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date bc_jssj;//班次结束时间
	 private String bctime;//班次结束时间 9:00 ~ 12:00
	private String dept_name;//单位名称
	private String qw_name;//勤务类型名称
	private String sfqy_name;
	private String bcgt;//班次跨天
	private String bcgtcode;//班次跨天
	
	
	


	public String getSfqyname() {
		if(sfqy.equals("0")||sfqy.equals(0)) {
			return "是";
		}
		return "否";
	}
	public void setSfqyname(String sfqyname) {
		this.sfqyname = sfqyname;
	}
	public String getBctime() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		return formatter.format(bc_kssj)+"~"+formatter.format(bc_jssj);
	}
	public void setBctime(String bctime) {
		this.bctime = bctime;
	}
	public String getBcgtcode() {
		return bcgtcode;
	}
	public void setBcgtcode(String bcgtcode) {
		this.bcgtcode = bcgtcode;
	}
	public String getBcgt() {
		return bcgt;
	}
	public void setBcgt(String bcgt) {
		this.bcgt = bcgt;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getBc_pk() {
		return bc_pk;
	}
	public void setBc_pk(Integer bc_pk) {
		this.bc_pk = bc_pk;
	}
	public String getBc_name() {
		return bc_name;
	}
	public void setBc_name(String bc_name) {
		this.bc_name = bc_name;
	}
	public String getDept_pk() {
		return dept_pk;
	}
	public void setDept_pk(String dept_pk) {
		this.dept_pk = dept_pk;
	}
	public String getQwlx_pk() {
		return qwlx_pk;
	}
	public void setQwlx_pk(String qwlx_pk) {
		this.qwlx_pk = qwlx_pk;
	}
	public String getSfqy() {
		return sfqy;
	}
	public void setSfqy(String sfqy) {
		this.sfqy = sfqy;
	}
	public Date getBc_kssj() {
		return bc_kssj;
	}
	public void setBc_kssj(Date bc_kssj) {
		this.bc_kssj = bc_kssj;
	}
	public Date getBc_jssj() {
		return bc_jssj;
	}
	public void setBc_jssj(Date bc_jssj) {
		this.bc_jssj = bc_jssj;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getQw_name() {
		return qw_name;
	}
	public void setQw_name(String qw_name) {
		this.qw_name = qw_name;
	}
	public String getSfqy_name() {
		return sfqy_name;
	}
	public void setSfqy_name(String sfqy_name) {
		this.sfqy_name = sfqy_name;
	}
	
}
