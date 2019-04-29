package com.cist.earlyewarningpost.model;

import java.math.BigDecimal;

//处理结果
public class JcbkWarningResult {
    private BigDecimal pk_id;//ID

    private BigDecimal fk_warning_id;//预警ID

    private String result_code;//处理结果（参考SYS_FRM_CODE中FCT_CODE=BK01）

	public BigDecimal getPk_id() {
		return pk_id;
	}

	public void setPk_id(BigDecimal pk_id) {
		this.pk_id = pk_id;
	}

	public BigDecimal getFk_warning_id() {
		return fk_warning_id;
	}

	public void setFk_warning_id(BigDecimal fk_warning_id) {
		this.fk_warning_id = fk_warning_id;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
}