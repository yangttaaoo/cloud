package com.cist.policemngment.model;

import java.io.Serializable;

/**
 * 警务资源分配信息
 * @author Administrator
 *
 */
public class Jcsj_P_R_Allot implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2233L;
	private Integer fk_p_r_id;//设备ID
	private Integer fk_user_id;//分配警员ID
	public Integer getFk_p_r_id() {
		return fk_p_r_id;
	}
	public void setFk_p_r_id(Integer fk_p_r_id) {
		this.fk_p_r_id = fk_p_r_id;
	}
	public Integer getFk_user_id() {
		return fk_user_id;
	}
	public void setFk_user_id(Integer fk_user_id) {
		this.fk_user_id = fk_user_id;
	}
	
}
