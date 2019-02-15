package com.cist.traffic.model;

import java.util.List;

public class Data {

	private Integer value;// 数量
	private String name;// 名字
//	public List<?> data;// 这里要用int 不能用String 不然前台显示不正常（特别是在做数学运算的时候）

	public Data(Integer value, String name) {
		this.name = name;
		this.value = value;
//		this.data = data;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<?> getData() {
//		return data;
//	}
//
//	public void setData(List<?> data) {
//		this.data = data;
//	}

}
