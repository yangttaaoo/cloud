package com.cist.evidencemanage.model;

import java.math.BigDecimal;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ZjjhEvidenceInfo {
    private BigDecimal pk_id;//ID

    private BigDecimal fk_dept_id;//管理部门ID

    private String evidence_name;//证据名称

    private String evidence_num;//证据编号

    private String data_source;//数据来源

    private String fk_evidence_type_id;//证据类型（参考SYS_FRM_CODE表 FCT_CODE=E001）

    private String fk_involved_type_id;//涉案类型（参考SYS_FRM_CODE表 FCT_CODE=E002）

    private String relation_case_name;//关联案件名称

    private String relation_case_id;//关联案件编号

    private String remarks;//备注

    private String evidence_status;//证据状态（0：正常、1：归档）

    private BigDecimal create_person_id;//创建人
    
    private String extract_pwd;//提取密码
    
    private String fk_evidence_type_name;//证据类型名称（参考SYS_FRM_CODE表 FCT_CODE=E001）

    private String fk_involved_type_name;//涉案类型名称（参考SYS_FRM_CODE表 FCT_CODE=E002）

    private String data_source_type;//证据来源
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date create_time;//创建时间

	public BigDecimal getPk_id() {
		return pk_id;
	}

	public void setPk_id(BigDecimal pk_id) {
		this.pk_id = pk_id;
	}

	public BigDecimal getFk_dept_id() {
		return fk_dept_id;
	}

	public void setFk_dept_id(BigDecimal fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}

	public String getEvidence_name() {
		return evidence_name;
	}

	public void setEvidence_name(String evidence_name) {
		this.evidence_name = evidence_name;
	}

	public String getEvidence_num() {
		return evidence_num;
	}

	public void setEvidence_num(String evidence_num) {
		this.evidence_num = evidence_num;
	}

	public String getData_source() {
		return data_source;
	}

	public void setData_source(String data_source) {
		this.data_source = data_source;
	}

	public String getFk_evidence_type_id() {
		return fk_evidence_type_id;
	}

	public void setFk_evidence_type_id(String fk_evidence_type_id) {
		this.fk_evidence_type_id = fk_evidence_type_id;
	}

	public String getFk_involved_type_id() {
		return fk_involved_type_id;
	}

	public void setFk_involved_type_id(String fk_involved_type_id) {
		this.fk_involved_type_id = fk_involved_type_id;
	}

	public String getRelation_case_name() {
		return relation_case_name;
	}

	public void setRelation_case_name(String relation_case_name) {
		this.relation_case_name = relation_case_name;
	}

	public String getRelation_case_id() {
		return relation_case_id;
	}

	public void setRelation_case_id(String relation_case_id) {
		this.relation_case_id = relation_case_id;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getEvidence_status() {
		return evidence_status;
	}

	public void setEvidence_status(String evidence_status) {
		this.evidence_status = evidence_status;
	}

	public BigDecimal getCreate_person_id() {
		return create_person_id;
	}

	public void setCreate_person_id(BigDecimal create_person_id) {
		this.create_person_id = create_person_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getExtract_pwd() {
		return extract_pwd;
	}

	public void setExtract_pwd(String extract_pwd) {
		this.extract_pwd = extract_pwd;
	}

	public String getFk_evidence_type_name() {
		if(fk_evidence_type_id!=null) {
			fk_evidence_type_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_ZJLX, fk_evidence_type_id.toString());
		}else {
			fk_evidence_type_name = "未知";
		}
		return fk_evidence_type_name;
	}

	public void setFk_evidence_type_name(String fk_evidence_type_name) {
		this.fk_evidence_type_name = fk_evidence_type_name;
	}

	public String getFk_involved_type_name() {
		if(fk_involved_type_id!=null) {
			fk_involved_type_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_SALX, fk_involved_type_id.toString());
		}else {
			fk_involved_type_name = "未知";
		}
		return fk_involved_type_name;
	}

	public void setFk_involved_type_name(String fk_involved_type_name) {
		this.fk_involved_type_name = fk_involved_type_name;
	}

	public String getData_source_type() {
		return data_source_type;
	}

	public void setData_source_type(String data_source_type) {
		this.data_source_type = data_source_type;
	}

   
}