package com.cist.logquery.loginsystem.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Sys_login_log {
	private Integer user_pk;
	private String userName;//用户名
	private Date login_time;//登陆时间
	private String user_cn;//中文名称
	private String ip;//ip地址
	private String numbers;//显示
	private String dept_name;
	private String time;
	
	public String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(this.login_time);
	}
	
	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String number) {
		this.numbers = number;
	}

	public Integer getUser_pk() {
		return user_pk;
	}

	public void setUser_pk(Integer user_pk) {
		this.user_pk = user_pk;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getLogin_time() {
		return login_time;
	}

	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}

	public String getUser_cn() {
		return user_cn;
	}

	public void setUser_cn(String user_cn) {
		this.user_cn = user_cn;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
