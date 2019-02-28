package com.sbzc.model;

import java.math.BigDecimal;

public class SssbEquipmentGather {
    private BigDecimal fkEquipmentId;

    private String equipmentModel;

    private String equipmentType;

    private BigDecimal fkDeptId;

    private String chargerPerson;

    private String chargerContactNumber;

    private String ipAddr;

    private String macAddr;

    private String port;

    private String description;

    private String supplier;

    private String supplierContactNumber;

    public BigDecimal getFkEquipmentId() {
        return fkEquipmentId;
    }

    public void setFkEquipmentId(BigDecimal fkEquipmentId) {
        this.fkEquipmentId = fkEquipmentId;
    }

    public String getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel == null ? null : equipmentModel.trim();
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType == null ? null : equipmentType.trim();
    }

    public BigDecimal getFkDeptId() {
        return fkDeptId;
    }

    public void setFkDeptId(BigDecimal fkDeptId) {
        this.fkDeptId = fkDeptId;
    }

    public String getChargerPerson() {
        return chargerPerson;
    }

    public void setChargerPerson(String chargerPerson) {
        this.chargerPerson = chargerPerson == null ? null : chargerPerson.trim();
    }

    public String getChargerContactNumber() {
        return chargerContactNumber;
    }

    public void setChargerContactNumber(String chargerContactNumber) {
        this.chargerContactNumber = chargerContactNumber == null ? null : chargerContactNumber.trim();
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

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
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