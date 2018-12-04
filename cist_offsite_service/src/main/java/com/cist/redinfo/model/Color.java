package com.cist.redinfo.model;
/**
 * 车身颜色表
 * @author wxc
 *
 */
public class Color {
	private Integer id;// 主键
	private String code;// 外键颜色
	private String name;// 颜色

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
