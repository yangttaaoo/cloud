package com.cist.qwgl.qwbb.model;

import java.io.Serializable;

/***
 * 9.22.	步巡关联人员报备
 * @author wangtao
 *
 */
public class Qw_report_walk_relation implements Serializable {
	private static final long serialVersionUID = 1L;
    private Integer pk_id;//
    private Integer fk_report_id;//勤务报备ID
    private Integer fk_user_id;//关联人员ID
    private Integer user_type;//关联人员类型（1：负责人；2：民警；3：协警）
    private Jcsj_police_res_person syspoliceinfo;//警员
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Integer getFk_report_id() {
		return fk_report_id;
	}
	public void setFk_report_id(Integer fk_report_id) {
		this.fk_report_id = fk_report_id;
	}
	public Integer getFk_user_id() {
		return fk_user_id;
	}
	public void setFk_user_id(Integer fk_user_id) {
		this.fk_user_id = fk_user_id;
	}
	public Integer getUser_type() {
		return user_type;
	}
	public void setUser_type(Integer user_type) {
		this.user_type = user_type;
	}
	public Jcsj_police_res_person getSyspoliceinfo() {
		return syspoliceinfo;
	}
	public void setSyspoliceinfo(Jcsj_police_res_person syspoliceinfo) {
		this.syspoliceinfo = syspoliceinfo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Qw_report_walk_relation(Integer pk_id, Integer fk_report_id, Integer fk_user_id, Integer user_type,
			Jcsj_police_res_person syspoliceinfo) {
		super();
		this.pk_id = pk_id;
		this.fk_report_id = fk_report_id;
		this.fk_user_id = fk_user_id;
		this.user_type = user_type;
		this.syspoliceinfo = syspoliceinfo;
	}
	public Qw_report_walk_relation() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
