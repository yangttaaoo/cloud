package com.sbzc.model;

import java.math.BigDecimal;
import java.util.Date;

public class JcbkWarningFeedBack {
    private BigDecimal pkId;

    private BigDecimal fkWarningId;

    private String disposalLocation;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String hasInterceptVehicles;

    private String notInterceptedReason;

    private String hasSuspectedVehicle;

    private String notSuspectedVehicleReason;

    private String suspectType;

    private String exceptionType;

    private BigDecimal transferDeptId;

    private String contacts;

    private String contactNumber;

    private String disposalDescription;

    private BigDecimal feedbackPersonId;

    private Date feedbackTime;

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

    public String getDisposalLocation() {
        return disposalLocation;
    }

    public void setDisposalLocation(String disposalLocation) {
        this.disposalLocation = disposalLocation == null ? null : disposalLocation.trim();
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getHasInterceptVehicles() {
        return hasInterceptVehicles;
    }

    public void setHasInterceptVehicles(String hasInterceptVehicles) {
        this.hasInterceptVehicles = hasInterceptVehicles == null ? null : hasInterceptVehicles.trim();
    }

    public String getNotInterceptedReason() {
        return notInterceptedReason;
    }

    public void setNotInterceptedReason(String notInterceptedReason) {
        this.notInterceptedReason = notInterceptedReason == null ? null : notInterceptedReason.trim();
    }

    public String getHasSuspectedVehicle() {
        return hasSuspectedVehicle;
    }

    public void setHasSuspectedVehicle(String hasSuspectedVehicle) {
        this.hasSuspectedVehicle = hasSuspectedVehicle == null ? null : hasSuspectedVehicle.trim();
    }

    public String getNotSuspectedVehicleReason() {
        return notSuspectedVehicleReason;
    }

    public void setNotSuspectedVehicleReason(String notSuspectedVehicleReason) {
        this.notSuspectedVehicleReason = notSuspectedVehicleReason == null ? null : notSuspectedVehicleReason.trim();
    }

    public String getSuspectType() {
        return suspectType;
    }

    public void setSuspectType(String suspectType) {
        this.suspectType = suspectType == null ? null : suspectType.trim();
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType == null ? null : exceptionType.trim();
    }

    public BigDecimal getTransferDeptId() {
        return transferDeptId;
    }

    public void setTransferDeptId(BigDecimal transferDeptId) {
        this.transferDeptId = transferDeptId;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber == null ? null : contactNumber.trim();
    }

    public String getDisposalDescription() {
        return disposalDescription;
    }

    public void setDisposalDescription(String disposalDescription) {
        this.disposalDescription = disposalDescription == null ? null : disposalDescription.trim();
    }

    public BigDecimal getFeedbackPersonId() {
        return feedbackPersonId;
    }

    public void setFeedbackPersonId(BigDecimal feedbackPersonId) {
        this.feedbackPersonId = feedbackPersonId;
    }

    public Date getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }
}