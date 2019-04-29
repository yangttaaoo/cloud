package com.cist.qwgl.qwjg.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/***
 * 9.16. 签到表
 * @author wangtao
 *
 */
public class Qw_sign_in  implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer pk_id;//id
	private String fk_dept_id;//管理部门ID
	private Integer fk_sign_in_user_id;//签到人ID
	private String sign_in_user_name;//签到人姓名（冗余数据）
	private String sign_in_user_unit;//签到人单位（冗余数据）
	private Date sign_time;//签到时间
	private String longitude;//	经度
	private String latitude;//纬度
	private Integer sign_in_type;//签到类型（1：签到；2：签退）
	private Integer fk_report_id;//勤务报备ID
	private String sign_in_addr;//签到地点
	private String sign_in_img;//签到图片
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}

	public String getFk_dept_id() {
		return fk_dept_id;
	}
	public void setFk_dept_id(String fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}
	public Integer getFk_sign_in_user_id() {
		return fk_sign_in_user_id;
	}
	public void setFk_sign_in_user_id(Integer fk_sign_in_user_id) {
		this.fk_sign_in_user_id = fk_sign_in_user_id;
	}
	public String getSign_in_user_name() {
		return sign_in_user_name;
	}
	public void setSign_in_user_name(String sign_in_user_name) {
		this.sign_in_user_name = sign_in_user_name;
	}
	public String getSign_in_user_unit() {
		return sign_in_user_unit;
	}
	public void setSign_in_user_unit(String sign_in_user_unit) {
		this.sign_in_user_unit = sign_in_user_unit;
	}
	public Date getSign_time() {
		return sign_time;
	}
	public void setSign_time(Date sign_time) {
		this.sign_time = sign_time;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public Integer getSign_in_type() {
		return sign_in_type;
	}
	public void setSign_in_type(Integer sign_in_type) {
		this.sign_in_type = sign_in_type;
	}
	public Integer getFk_report_id() {
		return fk_report_id;
	}
	public void setFk_report_id(Integer fk_report_id) {
		this.fk_report_id = fk_report_id;
	}
	public String getSign_in_addr() {
		return sign_in_addr;
	}
	public void setSign_in_addr(String sign_in_addr) {
		this.sign_in_addr = sign_in_addr;
	}
	public String getSign_in_img() {
		return sign_in_img;
	}
	public void setSign_in_img(String sign_in_img) {
		this.sign_in_img = sign_in_img;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Qw_sign_in() {
		super();
	}
}
