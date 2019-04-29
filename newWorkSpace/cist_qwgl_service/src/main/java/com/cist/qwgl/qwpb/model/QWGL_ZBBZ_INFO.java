package com.cist.qwgl.qwpb.model;

import java.io.Serializable;
/**
 * 装备报备
 * @author Administrator
 *
 */
public class QWGL_ZBBZ_INFO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1486519496379195384L;
	private Integer pk;
	private String qwbb;//关联QWGL_PBGL_PBINFO中zbbb
	private String zb_pk;//关联QWGL_ZB_INFO中的zb_pk
	private Integer zb_num;//装备数量
	public Integer getPk() {
		return pk;
	}
	public void setPk(Integer pk) {
		this.pk = pk;
	}
	public String getQwbb() {
		return qwbb;
	}
	public void setQwbb(String qwbb) {
		this.qwbb = qwbb;
	}
	public String getZb_pk() {
		return zb_pk;
	}
	public void setZb_pk(String zb_pk) {
		this.zb_pk = zb_pk;
	}
	public Integer getZb_num() {
		return zb_num;
	}
	public void setZb_num(Integer zb_num) {
		this.zb_num = zb_num;
	}
	
}
