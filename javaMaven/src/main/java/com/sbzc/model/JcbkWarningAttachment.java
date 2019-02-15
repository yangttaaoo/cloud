package com.sbzc.model;

import java.math.BigDecimal;
import java.util.Date;

public class JcbkWarningAttachment {
    private BigDecimal pkId;

    private BigDecimal fkWarningId;

    private String attachmentName;

    private String attachmentSuffix;

    private String attachmentSize;

    private String attachmentSource;

    private Date commitTime;

    private String remarks;

    public BigDecimal getPkId() {
        return pkId;
    }

    public void setPkId(BigDecimal pkId) {
        this.pkId = pkId;
    }

    public BigDecimal getFkWarningId() {
        return fkWarningId;
    }

    public void setFkWarningId(BigDecimal fkWarningId) {
        this.fkWarningId = fkWarningId;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName == null ? null : attachmentName.trim();
    }

    public String getAttachmentSuffix() {
        return attachmentSuffix;
    }

    public void setAttachmentSuffix(String attachmentSuffix) {
        this.attachmentSuffix = attachmentSuffix == null ? null : attachmentSuffix.trim();
    }

    public String getAttachmentSize() {
        return attachmentSize;
    }

    public void setAttachmentSize(String attachmentSize) {
        this.attachmentSize = attachmentSize == null ? null : attachmentSize.trim();
    }

    public String getAttachmentSource() {
        return attachmentSource;
    }

    public void setAttachmentSource(String attachmentSource) {
        this.attachmentSource = attachmentSource == null ? null : attachmentSource.trim();
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}