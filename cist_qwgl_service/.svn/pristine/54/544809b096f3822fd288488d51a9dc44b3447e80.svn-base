/**
 * 
 */
package com.cist.qwgl.jzgl.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 值班值守关联人员信息
 *
 */
public class Qw_duty_relation implements Serializable{
	private static final long serialVersionUID = 7358217240965000889L;
    private Integer pk_id;//id
    private String fk_police_team_id;//警组id
    private String fk_user_id;//关联人员ID
    private Integer USER_TYPE;//关联人员类型（1：值班领导；2：指挥长；3：值班长；4：值班民警；5：值班协警）
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
	public Integer getUSER_TYPE() {
		return USER_TYPE;
	}
	public void setUSER_TYPE(Integer uSER_TYPE) {
		USER_TYPE = uSER_TYPE;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Qw_duty_relation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Qw_duty_relation(Integer pk_id, String fk_police_team_id, String fk_user_id, Integer uSER_TYPE) {
		super();
		this.pk_id = pk_id;
		this.fk_police_team_id = fk_police_team_id;
		this.fk_user_id = fk_user_id;
		USER_TYPE = uSER_TYPE;
	}
	
}
