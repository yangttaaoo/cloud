package com.cist.yjgl.ljqygl.model;

import java.io.Serializable;
/**
 * 拦截区域
 * @author Administrator
 *
 */
import java.sql.Clob;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
public class Jcbk_Ljqy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2824781162441257812L;
	private Integer pk_id;
	private String qy_code;//区域编号
	private String qy_name;//区域名称
	private String dept_id;//单位id
	private Integer create_user;//创建人id
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date create_time;//创建时间
	private String status;//状态 0：未启用 1：启用
	private String qy;//区域
	
	private String status_name;//状态名称
	private String dept_name;//单位名称
	private String police_name;//警员姓名
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public String getQy_code() {
		return qy_code;
	}
	public void setQy_code(String qy_code) {
		this.qy_code = qy_code;
	}
	public String getQy_name() {
		return qy_name;
	}
	public void setQy_name(String qy_name) {
		this.qy_name = qy_name;
	}

	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public Integer getCreate_user() {
		return create_user;
	}
	public void setCreate_user(Integer create_user) {
		this.create_user = create_user;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getQy() {
		return qy;
	}
	public void setQy(String qy) {
		this.qy = qy;
	}
	public String getStatus_name() {
		if(status.equals("1")) {
			return "启用";
		}else {
			return "未启用";
		}
	}
	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getPolice_name() {
		return police_name;
	}
	public void setPolice_name(String police_name) {
		this.police_name = police_name;
	}

	
}
