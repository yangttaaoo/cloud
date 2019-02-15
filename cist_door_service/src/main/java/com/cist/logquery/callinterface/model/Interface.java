package com.cist.logquery.callinterface.model;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Interface {
	private Integer syil_pk;// 主键
	private String syil_code;// 接口编号
	private String syil_name;// 接口名称
	private String syil_rip;// ip地址
	private Date syil_rtime;// 访问时间
	private String syil_rcode;// 返回代码
	private String syil_rmsg;// 返回信息
	private String time;//时间
	
	public String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(this.syil_rtime);
	}
	public Integer getSyil_pk() {
		return syil_pk;
	}

	public void setSyil_pk(Integer syil_pk) {
		this.syil_pk = syil_pk;
	}

	public String getSyil_code() {
		return syil_code;
	}

	public void setSyil_code(String syil_code) {
		this.syil_code = syil_code;
	}

	public String getSyil_name() {
		return syil_name;
	}

	public void setSyil_name(String syil_name) {
		this.syil_name = syil_name;
	}

	public String getSyil_rip() {
		return syil_rip;
	}

	public void setSyil_rip(String syil_rip) {
		this.syil_rip = syil_rip;
	}

	public Date getSyil_rtime() {
		return syil_rtime;
	}

	public void setSyil_rtime(Date syil_rtime) {
		this.syil_rtime = syil_rtime;
	}

	public String getSyil_rcode() {
		return syil_rcode;
	}

	public void setSyil_rcode(String syil_rcode) {
		this.syil_rcode = syil_rcode;
	}

	public String getSyil_rmsg() {
		return syil_rmsg;
	}

	public void setSyil_rmsg(String syil_rmsg) {
		this.syil_rmsg = syil_rmsg;
	}

}
