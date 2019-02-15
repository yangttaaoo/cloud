package com.sbzc.model;

import java.math.BigDecimal;

public class JcbkWarningResult {
    private BigDecimal pkId;

    private BigDecimal fkWarningId;

    private String resultCode;

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

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode == null ? null : resultCode.trim();
    }
}