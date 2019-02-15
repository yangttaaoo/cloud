package com.sbzc.model;

import java.math.BigDecimal;

public class JcbkWarningPersonnel {
    private BigDecimal pkId;

    private BigDecimal fkWarningId;

    private BigDecimal fkWarningDispatchId;

    private BigDecimal fkPersonId;

    private String confirmation;

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

    public BigDecimal getFkWarningDispatchId() {
        return fkWarningDispatchId;
    }

    public void setFkWarningDispatchId(BigDecimal fkWarningDispatchId) {
        this.fkWarningDispatchId = fkWarningDispatchId;
    }

    public BigDecimal getFkPersonId() {
        return fkPersonId;
    }

    public void setFkPersonId(BigDecimal fkPersonId) {
        this.fkPersonId = fkPersonId;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation == null ? null : confirmation.trim();
    }
}