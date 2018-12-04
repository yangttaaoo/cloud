package com.cist.khpd.resultback.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ResultBack {
	
    private Integer result_pk;//主键
    private String user_number;//用户编号
    private String  user_name;//姓名
    private String back_title;//反馈标题
    private String back_type;//反馈类型 1，部门反馈，2，个人反馈
    private String depart;//部门名称
    private Date submit_time;//提交时间
    private String submit;
    private String reply_type;//回复状态 1，回复。2，未回复
    private Date reply_time;//回复时间
    private String reply;
    private String content;//备注说明
    private String reply_content;//回复内容
    
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getResult_pk() {
		return result_pk;
	}
	public void setResult_pk(Integer result_pk) {
		this.result_pk = result_pk;
	}
	public String getUser_number() {
		return user_number;
	}
	public void setUser_number(String user_number) {
		this.user_number = user_number;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getBack_title() {
		return back_title;
	}
	public void setBack_title(String back_title) {
		this.back_title = back_title;
	}
	public String getBack_type() {
		return back_type.equals("1")?"部门反馈":"个人反馈";
	}
	public void setBack_type(String back_type) {
		this.back_type = back_type;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public Date getSubmit_time() {
		return submit_time;
	}
	public void setSubmit_time(Date submit_time) {
		this.submit_time = submit_time;
	}
	public String getReply_type() {
		
		return reply_type.equals("1")?"已回复":"未回复";
	}
	public void setReply_type(String reply_type) {
		this.reply_type = reply_type;
	}
	public Date getReply_time() {
//		SimpleDateFormat  format=new SimpleDateFormat("yyyy-MM-dd ");
//		format.parse(reply_time);
		return reply_time;
	}
	public void setReply_time(Date reply_time) {
		this.reply_time = reply_time;
	}
	public String getSubmit() {
		if(submit_time!=null){
			SimpleDateFormat  simp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			this.submit = simp.format(submit_time);
			}
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getReply() {
		if(reply_time!=null){
			SimpleDateFormat  simp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			this.reply=simp.format(reply_time);
		}
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	
}
