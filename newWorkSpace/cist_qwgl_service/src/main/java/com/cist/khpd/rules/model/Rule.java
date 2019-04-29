package com.cist.khpd.rules.model;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Rule {
	private Integer pk;// 编号/主键
	private String lmmc;// 栏目名称
	private String tlmc;//条例名称
	private Integer lmfz;// 栏目分值
	private String lmsm;// 栏目/条例说明
	private String sjlm;// 上级栏目
	private String pdgz;// 评定规则 1 减分，2 加分
	private String pdgz_name;
	private String tlfz;// 条例分值
	private Date cjsj;// 创建时间
	private String cjsj_name;
	private String sfqy;// 是否启用
	private String sfqy_name;
	private Integer lmlx;
	
	
	public String getCjsj_name() {
		if(cjsj!=null){
		SimpleDateFormat  simp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.cjsj_name = simp.format(cjsj);
		}
		return cjsj_name;
	}

	public void setCjsj_name(String cjsj_name) {
		this.cjsj_name = cjsj_name;
	}

	public Integer getLmlx() {
		return lmlx;
	}

	public void setLmlx(Integer lmlx) {
		this.lmlx = lmlx;
	}

	public String getPdgz_name() {
		 if(pdgz!=null){
			 return pdgz;
		 }
		return pdgz_name;
	}

	public void setPdgz_name(String pdgz_name) {
		this.pdgz_name = pdgz_name;
	}

	public String getSfqy_name() {
		if(sfqy!=null){
			return sfqy;
		}
		return sfqy_name;
	}

	public void setSfqy_name(String sfqy_name) {
		this.sfqy_name = sfqy_name;
	}

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

	public String getSjlm() {
		return sjlm;
	}

	public void setSjlm(String sjlm) {
		this.sjlm = sjlm;
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
