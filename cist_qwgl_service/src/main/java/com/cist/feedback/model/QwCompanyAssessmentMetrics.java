package com.cist.feedback.model;

import java.math.BigDecimal;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class QwCompanyAssessmentMetrics {
	private BigDecimal pk_id;// ID

	private BigDecimal fk_comp_assessment_id;// 单位勤务考核ID

	private Integer fk_topic_id;// 栏目ID

	private int metrics_num;// 指标分值

	private String fk_topic_name;// 栏目名称

	public BigDecimal getPk_id() {
		return pk_id;
	}

	public void setPk_id(BigDecimal pk_id) {
		this.pk_id = pk_id;
	}

	public BigDecimal getFk_comp_assessment_id() {
		return fk_comp_assessment_id;
	}

	public void setFk_comp_assessment_id(BigDecimal fk_comp_assessment_id) {
		this.fk_comp_assessment_id = fk_comp_assessment_id;
	}

	public Integer getFk_topic_id() {
		return fk_topic_id;
	}

	public void setFk_topic_id(Integer fk_topic_id) {
		this.fk_topic_id = fk_topic_id;
	}

	public int getMetrics_num() {
		return metrics_num;
	}

	public void setMetrics_num(int metrics_num) {
		this.metrics_num = metrics_num;
	}

	public String getFk_topic_name() {
		if (fk_topic_id != null) {
			fk_topic_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_PDLM,fk_topic_id.toString());
		}

		return fk_topic_name;
	}

	public void setFk_topic_name(String fk_topic_name) {
		this.fk_topic_name = fk_topic_name;
	}

}