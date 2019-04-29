package com.cist.xxtj.sjwxyytj.model;

import java.io.Serializable;
/**
 * 排名统计
 * @author Hy
 *
 */
public class Ranking implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3445384104059749672L;
	private String name;
	private Integer num;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
}
