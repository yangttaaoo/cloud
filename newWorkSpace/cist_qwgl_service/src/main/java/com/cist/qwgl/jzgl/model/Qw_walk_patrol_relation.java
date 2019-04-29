/**
 * 
 */
package com.cist.qwgl.jzgl.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 步巡关联人员信息
 *
 */
public class Qw_walk_patrol_relation implements Serializable{
	private static final long serialVersionUID = 7358217240965000889L;
    private Integer pk_id;//id
    private String fk_police_team_id;//警组id
    private String fk_user_id;//关联人员ID
    private String user_type;//关联人员类型（1：负责人；2：民警；3：协警）
    private Syspoliceinfo syspoliceinfo;//警员
    
	public Syspoliceinfo getSyspoliceinfo() {
		return syspoliceinfo;
	}
	public void setSyspoliceinfo(Syspoliceinfo syspoliceinfo) {
		this.syspoliceinfo = syspoliceinfo;
	}
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public String getFk_police_team_id() {
		return fk_police_team_id;
	}
	public void setFk_police_team_id(String fk_police_team_id) {
		this.fk_police_team_id = fk_police_team_id;
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
	public Qw_walk_patrol_relation(Integer pk_id, String fk_police_team_id, String fk_user_id, String user_type) {
		super();
		this.pk_id = pk_id;
		this.fk_police_team_id = fk_police_team_id;
		this.fk_user_id = fk_user_id;
		this.user_type = user_type;
	}
	public Qw_walk_patrol_relation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
