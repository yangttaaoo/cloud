package com.cist.offsite.invalidtrial.model;

import java.math.BigDecimal;

public class CDirectionInfo {
    private BigDecimal pk;

    private String dirCode;

    private String dirName;

    public BigDecimal getPk() {
        return pk;
    }

    public void setPk(BigDecimal pk) {
        this.pk = pk;
    }

    public String getDirCode() {
        return dirCode;
    }

    public void setDirCode(String dirCode) {
        this.dirCode = dirCode == null ? null : dirCode.trim();
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName == null ? null : dirName.trim();
    }
}