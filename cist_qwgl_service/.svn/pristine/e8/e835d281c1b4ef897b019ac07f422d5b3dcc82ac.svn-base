/**
 * 
 */
package com.cist.qwgl.jzgl.model;

import java.io.Serializable;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

/**
 * 	警组信息
 *
 */
public class Qw_police_team implements Serializable{
	private static final long serialVersionUID = 7358217240965000889L;
    private Integer pk_id;//id
    private String fk_dept_id;//管理部门id
    private String police_team_name;//警组名称
    private String report_type;//报备类型（1：街面勤务；2：值班值守；3：接处警；4：机关工作）
    private String create_person_id;//创建人
    private String create_time;//创建时间
    private Sysfrmcode sysfrmcode;//报备类型（1：街面勤务；2：值班值守；3：接处警；4：机关工作）
    private Qw_police_team_street qw_police_team_street;//警组-街面勤务
    
    private String zbzsbcname;//值班值守的班次名称
    private String dept_name;//管理部门名称
    private String xkfs;//展示-巡控方式
    private String glbc;//展示-关联班次
    private String glxq;//展示-关联巡区
    private String bblx;//展示-报备类型
    
    
    
    
    
	public String getBblx() {
		if(null!=sysfrmcode)
			return sysfrmcode.getFc_name();
		return bblx;
	}
	public void setBblx(String bblx) {
		this.bblx = bblx;
	}
	public String getGlxq() {
		if(null!=qw_police_team_street && null !=qw_police_team_street.getQwpatrolarea()) {
			return qw_police_team_street.getQwpatrolarea().getArea_name();
		}
		return glxq;
	}
	public void setGlxq(String glxq) {
		this.glxq = glxq;
	}
	public String getGlbc() {
		if("1".equals(report_type)) {
			if(null!=qw_police_team_street) {
				Qwgl_bc_info qwgl_bc_info = qw_police_team_street.getQwgl_bc_info();
				return qwgl_bc_info!=null?qwgl_bc_info.getBc_name():"未知";
			}
			return "未知";
		}else if("2".equals(report_type)) {
			return zbzsbcname;
		}else if("5".equals(report_type)) {
			return "无";
		}
		return glbc;
	}
	public void setGlbc(String glbc) {
		this.glbc = glbc;
	}
	public String getXkfs() {
		if(null!=qw_police_team_street) {
			switch (qw_police_team_street.getPatrol_control_type()) {
			case "1":
				return "车巡";
			case "2":
				return "步巡";
			case "3":
				return "车巡+步巡";
			default:
				break;
			}
		}else {
			return "无";
		}
		return xkfs;
		
	}
	public void setXkfs(String xkfs) {
		this.xkfs = xkfs;
	}
	public Qw_police_team_street getQw_police_team_street() {
		return qw_police_team_street;
	}
	public void setQw_police_team_street(Qw_police_team_street qw_police_team_street) {
		this.qw_police_team_street = qw_police_team_street;
	}
	public Sysfrmcode getSysfrmcode() {
		return sysfrmcode;
	}
	public void setSysfrmcode(Sysfrmcode sysfrmcode) {
		this.sysfrmcode = sysfrmcode;
	}
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public String getFk_dept_id() {
		return fk_dept_id;
	}
	public void setFk_dept_id(String fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}
	public String getPolice_team_name() {
		if(police_team_name==null) return "未知";
		return police_team_name;
	}
	public void setPolice_team_name(String police_team_name) {
		this.police_team_name = police_team_name;
	}
	public String getReport_type() {
		return report_type;
	}
	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}
	public String getCreate_person_id() {
		return create_person_id;
	}
	public void setCreate_person_id(String create_person_id) {
		this.create_person_id = create_person_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Qw_police_team() {
		super();
	}
	public String getZbzsbcname() {
		return zbzsbcname;
	}
	public void setZbzsbcname(String zbzsbcname) {
		this.zbzsbcname = zbzsbcname;
	}
	public String getDept_name() {
		if(fk_dept_id==null) {
			return "未知";
		}else {
		return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT_PK, fk_dept_id);
		}
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
   
}
