package com.cist.qwgl.qwbb.model;

import java.io.Serializable;
/**
 * 9.21.	车巡关联人员报备
 * @author wangtao
 *
 */
public class Qw_report_car_relation implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer pk_id;//ID
	private String fk_car_patrol_id;//车巡信息ID
	private String fk_user_id;//关联人员ID
	private String user_type;//关联人员类型（1：负责人；2：民警；3：协警）
	private Jcsj_police_res_person syspoliceinfo;//警员
	 
	public Jcsj_police_res_person getSyspoliceinfo() {
		return syspoliceinfo;
	}
	public void setSyspoliceinfo(Jcsj_police_res_person syspoliceinfo) {
		this.syspoliceinfo = syspoliceinfo;
	}
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public String getFk_car_patrol_id() {
		return fk_car_patrol_id;
	}
	public void setFk_car_patrol_id(String fk_car_patrol_id) {
		this.fk_car_patrol_id = fk_car_patrol_id;
	}
	public String getFk_user_id() {
		return fk_user_id;
	}
	public void setFk_user_id(String fk_user_id) {
		this.fk_user_id = fk_user_id;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Qw_report_car_relation(Integer pk_id, String fk_car_patrol_id, String fk_user_id, String user_type) {
		super();
		this.pk_id = pk_id;
		this.fk_car_patrol_id = fk_car_patrol_id;
		this.fk_user_id = fk_user_id;
		this.user_type = user_type;
	}
	public Qw_report_car_relation() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
