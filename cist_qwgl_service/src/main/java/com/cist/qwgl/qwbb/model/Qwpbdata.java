package com.cist.qwgl.qwbb.model;

import java.io.Serializable;
import java.util.List;

/**
 * 勤务排班信息
 * @author wangtao
 *
 */
public class Qwpbdata  implements Serializable{
	private static final long serialVersionUID = 1L;
    private String shangjiname;//上级部门名称
    private Integer dept_superior;//上级部门pk
    private String deptname;//部门名称
    private Integer fk_dept_id;//部门pk
    private Integer  baobbeicount;//部门跨行
    private Integer  fk_patrol_area_id;//巡区id
    private String  area_name;//巡区名称
    private Integer  quyucount;//巡区跨行
    private List<Qw_report> qw_report;//9.18.	勤务报备
    private List<Qwpbdata> qwpbdatainfo;//巡区跨行
    private Integer mingjingcount;//民警
    private Integer fujingcount;//辅警
    
	public Integer getMingjingcount() {
		return mingjingcount;
	}
	public void setMingjingcount(Integer mingjingcount) {
		this.mingjingcount = mingjingcount;
	}
	public Integer getFujingcount() {
		return fujingcount;
	}
	public void setFujingcount(Integer fujingcount) {
		this.fujingcount = fujingcount;
	}
	public List<Qwpbdata> getQwpbdatainfo() {
		return qwpbdatainfo;
	}
	public void setQwpbdatainfo(List<Qwpbdata> qwpbdatainfo) {
		this.qwpbdatainfo = qwpbdatainfo;
	}
	public String getShangjiname() {
		return shangjiname;
	}
	public void setShangjiname(String shangjiname) {
		this.shangjiname = shangjiname;
	}
	public Integer getDept_superior() {
		return dept_superior;
	}
	public void setDept_superior(Integer dept_superior) {
		this.dept_superior = dept_superior;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public Integer getFk_dept_id() {
		return fk_dept_id;
	}
	public void setFk_dept_id(Integer fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}
	public Integer getBaobbeicount() {
		return baobbeicount;
	}
	public void setBaobbeicount(Integer baobbeicount) {
		this.baobbeicount = baobbeicount;
	}
	public Integer getFk_patrol_area_id() {
		return fk_patrol_area_id;
	}
	public void setFk_patrol_area_id(Integer fk_patrol_area_id) {
		this.fk_patrol_area_id = fk_patrol_area_id;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public Integer getQuyucount() {
		return quyucount;
	}
	public void setQuyucount(Integer quyucount) {
		this.quyucount = quyucount;
	}
	public List<Qw_report> getQw_report() {
		return qw_report;
	}
	public void setQw_report(List<Qw_report> qw_report) {
		this.qw_report = qw_report;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Qwpbdata(String shangjiname, Integer dept_superior, String deptname, Integer fk_dept_id,
			Integer baobbeicount, Integer fk_patrol_area_id, String area_name, Integer quyucount,
			List<Qw_report> qw_report) {
		super();
		this.shangjiname = shangjiname;
		this.dept_superior = dept_superior;
		this.deptname = deptname;
		this.fk_dept_id = fk_dept_id;
		this.baobbeicount = baobbeicount;
		this.fk_patrol_area_id = fk_patrol_area_id;
		this.area_name = area_name;
		this.quyucount = quyucount;
		this.qw_report = qw_report;
	}
	public Qwpbdata() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
