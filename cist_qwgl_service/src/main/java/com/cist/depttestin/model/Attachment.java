package com.cist.depttestin.model;

public class Attachment {

	private String attachment_source;// 文件路径
	private Integer pk_id;//主键

	public String getAttachment_source() {
		return attachment_source;
	}

	public void setAttachment_source(String attachment_source) {
		this.attachment_source = attachment_source;
	}

	public Integer getPk_id() {
		return pk_id;
	}

	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
    
}
