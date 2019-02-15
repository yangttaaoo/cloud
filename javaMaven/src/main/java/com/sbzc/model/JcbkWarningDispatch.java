package com.sbzc.model;

import java.math.BigDecimal;
import java.util.Date;

public class JcbkWarningDispatch {
    private BigDecimal pkId;

    private BigDecimal fkWarningId;

    private BigDecimal fkDispatchPersonId;

    private Date dispatchTime;

    private String notificationContent;

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

    public BigDecimal getFkDispatchPersonId() {
        return fkDispatchPersonId;
    }

    public void setFkDispatchPersonId(BigDecimal fkDispatchPersonId) {
        this.fkDispatchPersonId = fkDispatchPersonId;
    }

    public Date getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(Date dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public String getNotificationContent() {
        return notificationContent;
    }

    public void setNotificationContent(String notificationContent) {
        this.notificationContent = notificationContent == null ? null : notificationContent.trim();
    }
}