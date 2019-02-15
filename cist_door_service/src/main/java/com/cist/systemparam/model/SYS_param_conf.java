package com.cist.systemparam.model;

import java.io.Serializable;
import java.util.List;

/**
 * 系统参数配置
 * @author Administrator
 *
 */
public class SYS_param_conf implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3180808945253263826L;
	private String syci_type;//类型
	private Integer num;//数据条数
	private List<Sys_config> list;//数据
	public String getSyci_type() {
		return syci_type;
	}
	public void setSyci_type(String syci_type) {
		this.syci_type = syci_type;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public List<Sys_config> getList() {
		return list;
	}
	public void setList(List<Sys_config> list) {
		this.list = list;
	}
	
}
