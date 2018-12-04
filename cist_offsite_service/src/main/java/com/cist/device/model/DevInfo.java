package com.cist.device.model;

import java.io.Serializable;
public class DevInfo implements Serializable{
	private static final long serialVersionUID = 6413594393324980833L;
	private String tbei_code;//设备编号
	private String tbei_name;//设备名称
	private String tbec_kkbh;//设备安装地址
	public DevInfo(String tbei_code,String tbei_name,String tbec_kkbh){
		super();
		this.tbei_code = tbei_code;
		this.tbei_name = tbei_name;
		this.tbec_kkbh = tbec_kkbh;
	}
	public String getTbei_code() {
		return tbei_code;
	}
	public void setTbei_code(String tbei_code) {
		this.tbei_code = tbei_code;
	}
	public String getTbei_name() {
		return tbei_name;
	}
	public void setTbei_name(String tbei_name) {
		this.tbei_name = tbei_name;
	}

	public String getTbec_kkbh() {
		return tbec_kkbh;
	}
	public void setTbec_kkbh(String tbec_kkbh) {
		this.tbec_kkbh = tbec_kkbh;
	}
	public DevInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
