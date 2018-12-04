package com.cist.evidencemanage.model;

import java.math.BigDecimal;

public class ZjjhAttachmentDownloadList {
    private BigDecimal pk_id;//ID

    private BigDecimal fk_evidence_download_id;//证据下载信息ID

    private BigDecimal fk_evidence_attachment_id;//证据附件信息ID

    private String download_stauts;//下载状态（0：成功、1：失败）

	public BigDecimal getPk_id() {
		return pk_id;
	}

	public void setPk_id(BigDecimal pk_id) {
		this.pk_id = pk_id;
	}

	public BigDecimal getFk_evidence_download_id() {
		return fk_evidence_download_id;
	}

	public void setFk_evidence_download_id(BigDecimal fk_evidence_download_id) {
		this.fk_evidence_download_id = fk_evidence_download_id;
	}

	public BigDecimal getFk_evidence_attachment_id() {
		return fk_evidence_attachment_id;
	}

	public void setFk_evidence_attachment_id(BigDecimal fk_evidence_attachment_id) {
		this.fk_evidence_attachment_id = fk_evidence_attachment_id;
	}

	public String getDownload_stauts() {
		return download_stauts;
	}

	public void setDownload_stauts(String download_stauts) {
		this.download_stauts = download_stauts;
	}

	
}