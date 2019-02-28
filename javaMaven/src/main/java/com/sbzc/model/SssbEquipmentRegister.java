package com.sbzc.model;

import java.math.BigDecimal;

public class SssbEquipmentRegister {
    private BigDecimal pkId;

    private String equipmentType;

    private String equipmentName;

    private String dacIp;

    private String equipmentAadr;

    private String status;

    private String reasons;

    public BigDecimal getPkId() {
        return pkId;
    }

    public void setPkId(BigDecimal pkId) {
        this.pkId = pkId;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType == null ? null : equipmentType.trim();
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName == null ? null : equipmentName.trim();
    }

    public String getDacIp() {
        return dacIp;
    }

    public void setDacIp(String dacIp) {
        this.dacIp = dacIp == null ? null : dacIp.trim();
    }

    public String getEquipmentAadr() {
        return equipmentAadr;
    }

    public void setEquipmentAadr(String equipmentAadr) {
        this.equipmentAadr = equipmentAadr == null ? null : equipmentAadr.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons == null ? null : reasons.trim();
    }
}