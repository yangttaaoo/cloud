package com.cist.earlyewarningpost.model;

import java.math.BigDecimal;
import java.util.Date;

//附件信息
public class JcbkWarningAttachment {
    private BigDecimal pk_id;//ID

    private BigDecimal fk_warning_id;//预警ID

    private String attachment_name;//附件名称

    private String attachment_suffix;//附件后缀名

    private String attachment_size;//附件大小

    private String attachment_source;//附件路径

    private Date commit_time;//提交时间

    private String remarks;//备注

	public BigDecimal getPk_id() {
		return pk_id;
	}

	public void setPk_id(BigDecimal pk_id) {
		this.pk_id = pk_id;
	}

	public BigDecimal getFk_warning_id() {
		return fk_warning_id;
	}

	public void setFk_warning_id(BigDecimal fk_warning_id) {
		this.fk_warning_id = fk_warning_id;
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

}