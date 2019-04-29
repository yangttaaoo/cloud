package com.cist.policemngment.model;

import java.io.Serializable;

/**
 * 车辆（警车、摩托车、电瓶车）与GPS关联信息
 * @author Administrator
 *
 */
public class Jcsj_P_R_Relation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer fk_p_r_id;//警车ID
	private Integer fk_gps_id;//
	public Integer getFk_p_r_id() {
		return fk_p_r_id;
	}
	public void setFk_p_r_id(Integer fk_p_r_id) {
		this.fk_p_r_id = fk_p_r_id;
	}
	public Integer getFk_gps_id() {
		return fk_gps_id;
	}
	public void setFk_gps_id(Integer fk_gps_id) {
		this.fk_gps_id = fk_gps_id;
	}
	
	
	
}
