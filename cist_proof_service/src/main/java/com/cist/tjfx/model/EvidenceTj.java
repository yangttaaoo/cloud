package com.cist.tjfx.model;

import java.io.Serializable;
/**
 * 统计
 * @author Hy
 *
 */
public class EvidenceTj implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7054012132917433707L;
	private String name;//名称
	private Integer num;//证据数量
	
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
