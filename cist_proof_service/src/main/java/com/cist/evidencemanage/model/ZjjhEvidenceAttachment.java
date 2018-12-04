package com.cist.evidencemanage.model;

import java.math.BigDecimal;
import java.util.Date;

public class ZjjhEvidenceAttachment {
    private BigDecimal pk_id;//ID

    private BigDecimal fk_evidence_id;//证据信息ID

    private String evidence_type;//证据类型（0：图片、1：视频）

    private String data_source_type;//数据来源（0：手动上传、1：接口提取）

    private BigDecimal fk_extract_device_id;//提取设备ID

    private Date extract_time;//提取时间

    private String attachment_name;//附件名称

    private String attachment_location;//资源路径

	public BigDecimal getPk_id() {
		return pk_id;
	}

	public void setPk_id(BigDecimal pk_id) {
		this.pk_id = pk_id;
	}

	public BigDecimal getFk_evidence_id() {
		return fk_evidence_id;
	}

	public void setFk_evidence_id(BigDecimal fk_evidence_id) {
		this.fk_evidence_id = fk_evidence_id;
	}

	public String getEvidence_type() {
		return evidence_type;
	}

	public void setEvidence_type(String evidence_type) {
		this.evidence_type = evidence_type;
	}

	public String getData_source_type() {
		return data_source_type;
	}

	public void setData_source_type(String data_source_type) {
		this.data_source_type = data_source_type;
	}

	public BigDecimal getFk_extract_device_id() {
		return fk_extract_device_id;
	}

	public void setFk_extract_device_id(BigDecimal fk_extract_device_id) {
		this.fk_extract_device_id = fk_extract_device_id;
	}

	public Date getExtract_time() {
		return extract_time;
	}

	public void setExtract_time(Date extract_time) {
		this.extract_time = extract_time;
	}

	public String getAttachment_name() {
		return attachment_name;
	}

	public void setAttachment_name(String attachment_name) {
		this.attachment_name = attachment_name;
	}

	public String getAttachment_location() {
		return attachment_location;
	}

	public void setAttachment_location(String attachment_location) {
		this.attachment_location = attachment_location;
	}

}