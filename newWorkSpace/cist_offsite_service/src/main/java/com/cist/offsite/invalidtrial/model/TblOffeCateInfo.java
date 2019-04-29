package com.cist.offsite.invalidtrial.model;

public class TblOffeCateInfo {
    private Long tbocPk;

    private String tbocCode;

    private String tbocName;

    private String tbocShortName;

    private Short tbocPoints;

    private String tbocFines;

    private String tbocLegal;

    private String tbocMemo;

    public Long getTbocPk() {
        return tbocPk;
    }

    public void setTbocPk(Long tbocPk) {
        this.tbocPk = tbocPk;
    }

    public String getTbocCode() {
        return tbocCode;
    }

    public void setTbocCode(String tbocCode) {
        this.tbocCode = tbocCode == null ? null : tbocCode.trim();
    }

    public String getTbocName() {
        return tbocName;
    }

    public void setTbocName(String tbocName) {
        this.tbocName = tbocName == null ? null : tbocName.trim();
    }

    public String getTbocShortName() {
        return tbocShortName;
    }

    public void setTbocShortName(String tbocShortName) {
        this.tbocShortName = tbocShortName == null ? null : tbocShortName.trim();
    }

    public Short getTbocPoints() {
        return tbocPoints;
    }

    public void setTbocPoints(Short tbocPoints) {
        this.tbocPoints = tbocPoints;
    }

    public String getTbocFines() {
        return tbocFines;
    }

    public void setTbocFines(String tbocFines) {
        this.tbocFines = tbocFines == null ? null : tbocFines.trim();
    }

    public String getTbocLegal() {
        return tbocLegal;
    }

    public void setTbocLegal(String tbocLegal) {
        this.tbocLegal = tbocLegal == null ? null : tbocLegal.trim();
    }

    public String getTbocMemo() {
        return tbocMemo;
    }

    public void setTbocMemo(String tbocMemo) {
        this.tbocMemo = tbocMemo == null ? null : tbocMemo.trim();
    }
}