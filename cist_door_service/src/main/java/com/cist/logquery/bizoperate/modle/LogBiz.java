package com.cist.logquery.bizoperate.modle;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LogBiz {
	private Integer syol_id;//主键
	private Integer sypi_pk;//用戶名Id
	private String sypi_type;// 日志类型
	private String syol_request_url;// 请求地址
	private String syol_ip;// ip地址
	private String syol_content;// 操作内容
	private String syol_action;// 操作动作
	private String syol_param_values;// 参数名称和值
	private String syol_ex_msg;// 异常信息
	private String syol_err_location;// 异常信息位置
	private String syol_user_cn;// 操作人
	private Date syol_time;// 操作时间
	private String time;//时间
	
	public String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(this.syol_time);
	}
	public Integer getSypi_pk() {
		return sypi_pk;
	}
	public void setSypi_pk(Integer sypi_pk) {
		this.sypi_pk = sypi_pk;
	}
	public Integer getSyol_id() {
		return syol_id;
	}
	public void setSyol_id(Integer syol_id) {
		this.syol_id = syol_id;
	}
	public String getSyol_type() {
	   switch (sypi_type) {
	case "1":
		sypi_type="正常操作日志";
		break;
	case "2":
		sypi_type="错误日志";
		break;
	}
	return sypi_type;
	}
	public void setSyol_type(String sypi_type) {
		this.sypi_type = sypi_type;
	}

	public String getSyol_request_url() {
		return syol_request_url;
	}

	public void setSyol_request_url(String syol_request_url) {
		this.syol_request_url = syol_request_url;
	}

	public String getSyol_ip() {
		return syol_ip;
	}

	public void setSyol_ip(String syol_ip) {
		this.syol_ip = syol_ip;
	}

	public String getSyol_content() {
		return syol_content;
	}

	public void setSyol_content(String syol_content) {
		this.syol_content = syol_content;
	}

	public String getSyol_action() {
		switch (syol_action) {
		 case "1":
			 syol_action="新增";
		 break;
		 case "2":
			 syol_action="修改";
		 break;
		 case "3":
			 syol_action="删除";
		 break;
		 case "4":
			 syol_action="查询";
		break;
		 case "5":
			 syol_action="查询接口";
		break;
		 case "6":
			 syol_action="写入接口";
		break;
	
		}
		return syol_action;
	}

	public void setSyol_action(String syol_action) {
		this.syol_action = syol_action;
	}

	public String getSyol_param_values() {
		return syol_param_values;
	}

	public void setSyol_param_values(String syol_param_values) {
		this.syol_param_values = syol_param_values;
	}

	public String getSyol_ex_msg() {
		return syol_ex_msg;
	}

	public void setSyol_ex_msg(String syol_ex_msg) {
		this.syol_ex_msg = syol_ex_msg;
	}

	public String getSyol_err_location() {
		return syol_err_location;
	}

	public void setSyol_err_location(String syol_err_location) {
		this.syol_err_location = syol_err_location;
	}

	public String getSyol_user_cn() {
		return syol_user_cn;
	}

	public void setSyol_user_cn(String syol_user_cn) {
		this.syol_user_cn = syol_user_cn;
	}

	public Date getSyol_time() {
		return syol_time;
	}

	public void setSyol_time(Date syol_time) {
		this.syol_time = syol_time;
	}

}
