package com.sbzc.model;

import java.math.BigDecimal;

public class JcbkWarningDocument {
    private BigDecimal pkId;

    private BigDecimal fkWarningId;

    private String documentCategory;

    private String documentNum;

    private String parityBit;

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

    public String getDocumentCategory() {
        return documentCategory;
    }

    public void setDocumentCategory(String documentCategory) {
        this.documentCategory = documentCategory == null ? null : documentCategory.trim();
    }

    public String getDocumentNum() {
        return documentNum;
    }

    public void setDocumentNum(String documentNum) {
        this.documentNum = documentNum == null ? null : documentNum.trim();
    }

    public String getParityBit() {
        return parityBit;
    }

    public void setParityBit(String parityBit) {
        this.parityBit = parityBit == null ? null : parityBit.trim();
    }
}