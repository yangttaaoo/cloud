package com.sbzc.model;

import java.math.BigDecimal;
import java.util.Date;

public class JcsjDevice {
    private BigDecimal pkId;

    private BigDecimal fkDeptId;

    private BigDecimal createPerson;

    private Date createTime;

    private Date enableDate;

    private String contactsPerson;

    private String contactsNum;

    private String remarks;

    private String fkDeviceType;

    private String deviceName;

    private String deviceNum;

    private BigDecimal belongedRoadId;

    private BigDecimal kilometreNum;

    private BigDecimal meterNum;

    private String roadName;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String networkLocation;

    private String uploadMode;

    private String deviceSource;

    private String direction;

    private String xzqh;

    private Date validityDate;

    public BigDecimal getPkId() {
        return pkId;
    }

    public void setPkId(BigDecimal pkId) {
        this.pkId = pkId;
    }

    public BigDecimal getFkDeptId() {
        return fkDeptId;
    }

    public void setFkDeptId(BigDecimal fkDeptId) {
        this.fkDeptId = fkDeptId;
    }

    public BigDecimal getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(BigDecimal createPerson) {
        this.createPerson = createPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEnableDate() {
        return enableDate;
    }

    public void setEnableDate(Date enableDate) {
        this.enableDate = enableDate;
    }

    public String getContactsPerson() {
        return contactsPerson;
    }

    public void setContactsPerson(String contactsPerson) {
        this.contactsPerson = contactsPerson == null ? null : contactsPerson.trim();
    }

    public String getContactsNum() {
        return contactsNum;
    }

    public void setContactsNum(String contactsNum) {
        this.contactsNum = contactsNum == null ? null : contactsNum.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getFkDeviceType() {
        return fkDeviceType;
    }

    public void setFkDeviceType(String fkDeviceType) {
        this.fkDeviceType = fkDeviceType == null ? null : fkDeviceType.trim();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public String getDeviceNum() {
        return deviceNum;
    }

    public void setDeviceNum(String deviceNum) {
        this.deviceNum = deviceNum == null ? null : deviceNum.trim();
    }

    public BigDecimal getBelongedRoadId() {
        return belongedRoadId;
    }

    public void setBelongedRoadId(BigDecimal belongedRoadId) {
        this.belongedRoadId = belongedRoadId;
    }

    public BigDecimal getKilometreNum() {
        return kilometreNum;
    }

    public void setKilometreNum(BigDecimal kilometreNum) {
        this.kilometreNum = kilometreNum;
    }

    public BigDecimal getMeterNum() {
        return meterNum;
    }

    public void setMeterNum(BigDecimal meterNum) {
        this.meterNum = meterNum;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName == null ? null : roadName.trim();
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

    public String getNetworkLocation() {
        return networkLocation;
    }

    public void setNetworkLocation(String networkLocation) {
        this.networkLocation = networkLocation == null ? null : networkLocation.trim();
    }

    public String getUploadMode() {
        return uploadMode;
    }

    public void setUploadMode(String uploadMode) {
        this.uploadMode = uploadMode == null ? null : uploadMode.trim();
    }

    public String getDeviceSource() {
        return deviceSource;
    }

    public void setDeviceSource(String deviceSource) {
        this.deviceSource = deviceSource == null ? null : deviceSource.trim();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh == null ? null : xzqh.trim();
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }
}