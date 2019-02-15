package com.cist.quarters.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

/***
 * 岗位信息
 * @author admin
 *
 */
public class Postinfo implements Serializable{
	private static final long serialVersionUID = 1L;
    private Integer pk_id;//ID
    private String fk_dept_id;//管理单位ID
    private String post_name;//岗位名称
    private Integer is_default;//是否默认（0：否、1：是）
    private String remarks;//备注
    private Date post_time;//创建时间
    
	public Date getPost_time() {
		return post_time;
	}
	public void setPost_time(Date post_time) {
		this.post_time = post_time;
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
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}
	public Integer getIs_default() {
		return is_default;
	}
	public void setIs_default(Integer is_default) {
		this.is_default = is_default;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Postinfo(Integer pk_id, String fk_dept_id, String post_name, Integer is_default, String remarks) {
		super();
		this.pk_id = pk_id;
		this.fk_dept_id = fk_dept_id;
		this.post_name = post_name;
		this.is_default = is_default;
		this.remarks = remarks;
	}
	public Postinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
