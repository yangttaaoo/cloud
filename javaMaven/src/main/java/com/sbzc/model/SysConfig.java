package com.sbzc.model;

public class SysConfig {
    private Long syciPk;

    private String syciType;

    private String syciKey;

    private String syciName;

    private String syciValue;

    private String syciDes;

    private String syciHtmlType;

    private String syciHtml;

    private String syciFlag;

    public Long getSyciPk() {
        return syciPk;
    }

    public void setSyciPk(Long syciPk) {
        this.syciPk = syciPk;
    }

    public String getSyciType() {
        return syciType;
    }

    public void setSyciType(String syciType) {
        this.syciType = syciType == null ? null : syciType.trim();
    }

    public String getSyciKey() {
        return syciKey;
    }

    public void setSyciKey(String syciKey) {
        this.syciKey = syciKey == null ? null : syciKey.trim();
    }

    public String getSyciName() {
        return syciName;
    }

    public void setSyciName(String syciName) {
        this.syciName = syciName == null ? null : syciName.trim();
    }

    public String getSyciValue() {
        return syciValue;
    }

    public void setSyciValue(String syciValue) {
        this.syciValue = syciValue == null ? null : syciValue.trim();
    }

    public String getSyciDes() {
        return syciDes;
    }

    public void setSyciDes(String syciDes) {
        this.syciDes = syciDes == null ? null : syciDes.trim();
    }

    public String getSyciHtmlType() {
        return syciHtmlType;
    }

    public void setSyciHtmlType(String syciHtmlType) {
        this.syciHtmlType = syciHtmlType == null ? null : syciHtmlType.trim();
    }

    public String getSyciHtml() {
        return syciHtml;
    }

    public void setSyciHtml(String syciHtml) {
        this.syciHtml = syciHtml == null ? null : syciHtml.trim();
    }

    public String getSyciFlag() {
        return syciFlag;
    }

    public void setSyciFlag(String syciFlag) {
        this.syciFlag = syciFlag == null ? null : syciFlag.trim();
    }
}