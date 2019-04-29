package com.cist.khpd.rules.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RuleMannage {
	private Integer pk;// 编号/主键
	private String lmmc;// 栏目名称
	private String tlmc;//条例名称
	private Integer lmfz;// 栏目分值
	private String lmsm;// 栏目/条例说明
	private String pdgz;// 评定规则 1 减分，2 加分
	private String tlfz;// 条例分值
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GTM+8")
	private Date cjsj;// 创建时间
	private String sfqy;// 是否启用
	public String getTlmc() {
		return tlmc;
	}

	public void setTlmc(String tlmc) {
		this.tlmc = tlmc;
	}

	public Integer getPk() {
		return pk;
	}

	public void setPk(Integer pk) {
		this.pk = pk;
	}

	public String getLmmc() {
		return lmmc;
	}

	public void setLmmc(String lmmc) {
		this.lmmc = lmmc;
	}

	public Integer getLmfz() {
		return lmfz;
	}

	public void setLmfz(Integer lmfz) {
		this.lmfz = lmfz;
	}

	public String getLmsm() {
		return lmsm;
	}

	public void setLmsm(String lmsm) {
		this.lmsm = lmsm;
	}

	public String getPdgz() {
		return "1".equals(pdgz)?"减分":"加分";
	}

	public void setPdgz(String pdgz) {
		this.pdgz = pdgz;
	}

	public String getTlfz() {
		return tlfz;
	}

	public void setTlfz(String tlfz) {
		this.tlfz = tlfz;
	}

	public Date getCjsj() {
		return cjsj;
	}

	public void setSjsj(Date cjsj) {
		this.cjsj = cjsj;
	}

	public String getSfqy() {
		
	return "1".equals(sfqy)?"是":"否";
	}

	public void setSfqy(String sfqy) {
		this.sfqy = sfqy;
	}

}
