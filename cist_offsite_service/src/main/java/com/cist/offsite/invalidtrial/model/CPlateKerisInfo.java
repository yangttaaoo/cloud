package com.cist.offsite.invalidtrial.model;

import java.math.BigDecimal;

public class CPlateKerisInfo {
    private BigDecimal pk;

    private String code;

    private String name;

    public BigDecimal getPk() {
        return pk;
    }

    public void setPk(BigDecimal pk) {
        this.pk = pk;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}