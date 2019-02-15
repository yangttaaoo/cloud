package com.cist.qwgl.qwbb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 车巡信息
 *
 */
public class Qw_car_patrol_info implements Serializable{
	private static final long serialVersionUID = 7358217240965000889L;
    private Integer pk_id;//id
    private String fk_police_team_id;//警组id
    private String fk_police_car_id;//警车id
    private List<Qw_car_patrol_relation> qw_car_patrol_relation;//9.4.	车巡关联人员信息
    private Jcsjpoliceresources jcsjpoliceresources;//车俩信息
    
	public Jcsjpoliceresources getJcsjpoliceresources() {
		return jcsjpoliceresources;
	}
	public void setJcsjpoliceresources(Jcsjpoliceresources jcsjpoliceresources) {
		this.jcsjpoliceresources = jcsjpoliceresources;
	}
	public List<Qw_car_patrol_relation> getQw_car_patrol_relation() {
		return qw_car_patrol_relation;
	}
	public void setQw_car_patrol_relation(List<Qw_car_patrol_relation> qw_car_patrol_relation) {
		this.qw_car_patrol_relation = qw_car_patrol_relation;
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
	public String getFk_police_car_id() {
		return fk_police_car_id;
	}
	public void setFk_police_car_id(String fk_police_car_id) {
		this.fk_police_car_id = fk_police_car_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Qw_car_patrol_info(Integer pk_id, String fk_police_team_id, String fk_police_car_id) {
		super();
		this.pk_id = pk_id;
		this.fk_police_team_id = fk_police_team_id;
		this.fk_police_car_id = fk_police_car_id;
	}
	public Qw_car_patrol_info() {
		super();
		// TODO Auto-generated constructor stub
	}
	
   
}
