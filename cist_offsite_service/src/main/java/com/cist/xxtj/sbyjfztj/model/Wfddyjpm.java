package com.cist.xxtj.sbyjfztj.model;

import java.io.Serializable;
/**
 * 违法地点预警排名
 * @author Administrator
 *
 */
public class Wfddyjpm implements Serializable {
	private String sbdd;//设备地点
	private String num;//超出预警数
	public String getSbdd() {
		return sbdd;
	}
	public void setSbdd(String sbdd) {
		this.sbdd = sbdd;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
}
