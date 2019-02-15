package com.cist.earlyewarningpost.model;

import java.math.BigDecimal;

//预警处理文书
public class JcbkWarningDocument {
    private BigDecimal pk_id;//ID

    private BigDecimal fk_warning_id;//预警ID

    private String document_category;//文书类别（1:简易程序处罚决定书3:强制措施凭证6:违法处理通知书。参考SYS_FRM_CODE中FCT_CODE=BK03）

    private String document_num;//文书编号

    private String parity_bit;//校验位

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

	public String getDocument_category() {
		return document_category;
	}

	public void setDocument_category(String document_category) {
		this.document_category = document_category;
	}

	public String getDocument_num() {
		return document_num;
	}

	public void setDocument_num(String document_num) {
		this.document_num = document_num;
	}

	public String getParity_bit() {
		return parity_bit;
	}

	public void setParity_bit(String parity_bit) {
		this.parity_bit = parity_bit;
	}

}