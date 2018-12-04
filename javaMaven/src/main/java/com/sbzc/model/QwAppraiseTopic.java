package com.sbzc.model;

import java.math.BigDecimal;
import java.util.Date;

public class QwAppraiseTopic {
    private BigDecimal pkId;

    private BigDecimal fkDeptId;

    private String topicName;

    private BigDecimal defaultValue;

    private String topicExplain;

    private String enabledState;

    private BigDecimal createPersonId;

    private Date createTime;

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

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName == null ? null : topicName.trim();
    }

    public BigDecimal getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(BigDecimal defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getTopicExplain() {
        return topicExplain;
    }

    public void setTopicExplain(String topicExplain) {
        this.topicExplain = topicExplain == null ? null : topicExplain.trim();
    }

    public String getEnabledState() {
        return enabledState;
    }

    public void setEnabledState(String enabledState) {
        this.enabledState = enabledState == null ? null : enabledState.trim();
    }

    public BigDecimal getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(BigDecimal createPersonId) {
        this.createPersonId = createPersonId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}