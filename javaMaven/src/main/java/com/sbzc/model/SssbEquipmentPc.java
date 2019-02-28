package com.sbzc.model;

import java.math.BigDecimal;

public class SssbEquipmentPc {
    private BigDecimal fkEquipmentId;

    private String userName;

    private String contactNumber;

    private BigDecimal fkDeptId;

    private String deptContactNumber;

    private String equipmentModel;

    private String ipAddr;

    private String macAddr;

    private String description;

    private String supplier;

    private String supplierContactNumber;

    public BigDecimal getFkEquipmentId() {
        return fkEquipmentId;
    }

    public void setFkEquipmentId(BigDecimal fkEquipmentId) {
        this.fkEquipmentId = fkEquipmentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber == null ? null : contactNumber.trim();
    }

    public BigDecimal getFkDeptId() {
        return fkDeptId;
    }

    public void setFkDeptId(BigDecimal fkDeptId) {
        this.fkDeptId = fkDeptId;
    }

    public String getDeptContactNumber() {
        return deptContactNumber;
    }

    public void setDeptContactNumber(String deptContactNumber) {
        this.deptContactNumber = deptContactNumber == null ? null : deptContactNumber.trim();
    }

    public String getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel == null ? null : equipmentModel.trim();
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr == null ? null : ipAddr.trim();
    }

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr == null ? null : macAddr.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public String getSupplierContactNumber() {
        return supplierContactNumber;
    }

    public void setSupplierContactNumber(String supplierContactNumber) {
        this.supplierContactNumber = supplierContactNumber == null ? null : supplierContactNumber.trim();
    }
}