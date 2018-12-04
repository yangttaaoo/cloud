package com.cist.serviceconfig.unlimitedcar.model;

import java.util.Date;

public class CarManage {
	/**
	 * 车辆不限行管理
	 */
	private String twi_plate_no;// 号牌号码
	private String twi_plate_type;// 号牌种类
	private String twi_type_code;// 车辆类型
	private Date twi_s_date;// 开始时间
	private Date twi_e_date;// 结束时间
	private String clzt;
	private String twi_desc;// 描述
	private Integer twi_pk;// 主键
	private String cllx_name;// 车辆类型名称
	private String hpzl_name;// 号牌种类名称

	public String getClzt() {
		Date day = new Date();
		if (twi_s_date.before(day) && twi_e_date.after(day)) {
			return "有效";
		} else if (twi_e_date.equals(day) || twi_s_date.equals(day)) {
			return "有效";
		}
		return "无效";
	}

	public String getHpzl_name() {
		return hpzl_name;
	}

	public void setHpzl_name(String hpzl_name) {
		this.hpzl_name = hpzl_name;
	}

	public String getCllx_name() {
		return cllx_name;
	}

	public void setCllx_name(String cllx_name) {
		this.cllx_name = cllx_name;
	}

	public Integer getTwi_pk() {
		return twi_pk;
	}

	public void setTwi_pk(Integer twi_pk) {
		this.twi_pk = twi_pk;
	}

	public String getTwi_plate_no() {
		return twi_plate_no;
	}

	public void setTwi_plate_no(String twi_plate_no) {
		this.twi_plate_no = twi_plate_no;
	}

	public String getTwi_plate_type() {
		return twi_plate_type;
	}

	public void setTwi_plate_type(String twi_plate_type) {
		this.twi_plate_type = twi_plate_type;
	}

	public String getTwi_desc() {
		return twi_desc;
	}

	public void setTwi_desc(String twi_desc) {
		this.twi_desc = twi_desc;
	}

	public String getTwi_type_code() {
		return twi_type_code;
	}

	public void setTwi_type_code(String twi_type_code) {
		this.twi_type_code = twi_type_code;
	}

	public Date getTwi_s_date() {
		return twi_s_date;
	}

	public void setTwi_s_date(Date twi_s_date) {
		this.twi_s_date = twi_s_date;
	}

	public Date getTwi_e_date() {
		return twi_e_date;
	}

	public void setTwi_e_date(Date twi_e_date) {
		this.twi_e_date = twi_e_date;
	}
}
