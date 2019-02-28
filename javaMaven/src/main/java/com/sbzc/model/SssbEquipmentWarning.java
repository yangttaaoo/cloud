package com.sbzc.model;

import java.math.BigDecimal;
import java.util.Date;

public class SssbEquipmentWarning {
    private BigDecimal pkId;

    private String warningType;

    private String sourceIp;

    private String sourceMac;

    private String sourceProt;

    private String destIp;

    private String destPort;

    private String dacIp;

    private String ifnameInside;

    private String protocol;

    private String terminalType;

    private String terminalName;

    private String terminalLocationt;

    private Date warningTime;

    public BigDecimal getPkId() {
        return pkId;
    }

    public void setPkId(BigDecimal pkId) {
        this.pkId = pkId;
    }

    public String getWarningType() {
        return warningType;
    }

    public void setWarningType(String warningType) {
        this.warningType = warningType == null ? null : warningType.trim();
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp == null ? null : sourceIp.trim();
    }

    public String getSourceMac() {
        return sourceMac;
    }

    public void setSourceMac(String sourceMac) {
        this.sourceMac = sourceMac == null ? null : sourceMac.trim();
    }

    public String getSourceProt() {
        return sourceProt;
    }

    public void setSourceProt(String sourceProt) {
        this.sourceProt = sourceProt == null ? null : sourceProt.trim();
    }

    public String getDestIp() {
        return destIp;
    }

    public void setDestIp(String destIp) {
        this.destIp = destIp == null ? null : destIp.trim();
    }

    public String getDestPort() {
        return destPort;
    }

    public void setDestPort(String destPort) {
        this.destPort = destPort == null ? null : destPort.trim();
    }

    public String getDacIp() {
        return dacIp;
    }

    public void setDacIp(String dacIp) {
        this.dacIp = dacIp == null ? null : dacIp.trim();
    }

    public String getIfnameInside() {
        return ifnameInside;
    }

    public void setIfnameInside(String ifnameInside) {
        this.ifnameInside = ifnameInside == null ? null : ifnameInside.trim();
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol == null ? null : protocol.trim();
    }

    public String getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType == null ? null : terminalType.trim();
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName == null ? null : terminalName.trim();
    }

    public String getTerminalLocationt() {
        return terminalLocationt;
    }

    public void setTerminalLocationt(String terminalLocationt) {
        this.terminalLocationt = terminalLocationt == null ? null : terminalLocationt.trim();
    }

    public Date getWarningTime() {
        return warningTime;
    }

    public void setWarningTime(Date warningTime) {
        this.warningTime = warningTime;
    }
}