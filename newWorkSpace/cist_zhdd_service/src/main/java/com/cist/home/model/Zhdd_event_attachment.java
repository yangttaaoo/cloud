package com.cist.home.model;

import java.io.Serializable;
import java.util.Date;
/***
 * 4.12. 事件附件
 * @author wangtao
 *
 */
public class Zhdd_event_attachment implements Serializable{
	private static final long serialVersionUID = 1L;
	private String pk_id;
	private String fk_event_id;//事件ID
	private String attachment_name;//附件名称
	private String attachment_suffix;//附件后缀名
	private String attachment_size;//附件大小
	private String attachment_source;//	附件路径
	private Date commit_time;//提交时间
	private String remarks;//备注
	public String getPk_id() {
		return pk_id;
	}
	public void setPk_id(String pk_id) {
		this.pk_id = pk_id;
	}
	public String getFk_event_id() {
		return fk_event_id;
	}
	public void setFk_event_id(String fk_event_id) {
		this.fk_event_id = fk_event_id;
	}
	public String getAttachment_name() {
		return attachment_name;
	}
	public void setAttachment_name(String attachment_name) {
		this.attachment_name = attachment_name;
	}
	public String getAttachment_suffix() {
		return attachment_suffix;
	}
	public void setAttachment_suffix(String attachment_suffix) {
		this.attachment_suffix = attachment_suffix;
	}
	public String getAttachment_size() {
		return attachment_size;
	}
	public void setAttachment_size(String attachment_size) {
		this.attachment_size = attachment_size;
	}
	public String getAttachment_source() {
		return attachment_source;
	}
	public void setAttachment_source(String attachment_source) {
		this.attachment_source = attachment_source;
	}
	public Date getCommit_time() {
		return commit_time;
	}
	public void setCommit_time(Date commit_time) {
		this.commit_time = commit_time;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Zhdd_event_attachment(String pk_id, String fk_event_id, String attachment_name, String attachment_suffix,
			String attachment_size, String attachment_source, Date commit_time, String remarks) {
		super();
		this.pk_id = pk_id;
		this.fk_event_id = fk_event_id;
		this.attachment_name = attachment_name;
		this.attachment_suffix = attachment_suffix;
		this.attachment_size = attachment_size;
		this.attachment_source = attachment_source;
		this.commit_time = commit_time;
		this.remarks = remarks;
	}
	public Zhdd_event_attachment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}