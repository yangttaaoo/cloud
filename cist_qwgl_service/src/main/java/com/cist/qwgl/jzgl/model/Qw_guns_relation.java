/**
 * 
 */
package com.cist.qwgl.jzgl.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 枪支关联警员信息
 *
 */
public class Qw_guns_relation implements Serializable{
	private static final long serialVersionUID = 7358217240965000889L;
    private Integer pk_id;//id
    private Integer fk_equip_id;//装备信息ID
    private Integer fk_user_id;//关联警员ID
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Integer getFk_equip_id() {
		return fk_equip_id;
	}
	public void setFk_equip_id(Integer fk_equip_id) {
		this.fk_equip_id = fk_equip_id;
	}
	public Integer getFk_user_id() {
		return fk_user_id;
	}
	public void setFk_user_id(Integer fk_user_id) {
		this.fk_user_id = fk_user_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Qw_guns_relation(Integer pk_id, Integer fk_equip_id, Integer fk_user_id) {
		super();
		this.pk_id = pk_id;
		this.fk_equip_id = fk_equip_id;
		this.fk_user_id = fk_user_id;
	}
	public Qw_guns_relation() {
		super();
		// TODO Auto-generated constructor stub
	}
   
}
