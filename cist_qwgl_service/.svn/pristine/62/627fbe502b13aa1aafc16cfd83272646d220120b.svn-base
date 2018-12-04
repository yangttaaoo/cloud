package com.cist.khpd.target.model;

import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Target {
	
	private Integer pk;// 主键
	private String sypi_pk;// 警员编号号码
	private String sypi_code;//警员编号
	private String sypi_name;//警员姓名
	private Integer col_pk;//栏目1，栏目。0总分值
	private Integer col_zf;//總分值
	private Integer eva_num;// 栏目分值
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GTM+8")
	private Date eva_date;//日期
	private String dept_name;//單位名字
	private String dept_code;
	private String dept_head;
	private String eva_exl;// 备注说明
	private String eva_type;// 类型 1，部门。2，个人 
	private String eva_date_year;
	private String eva_type_name;//部门名字
	private String quarter;//季度
	
	
	public String getDept_code() {
		return dept_code;
	}

	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}

	public String getDept_head() {
		return dept_head;
	}

	public void setDept_head(String dept_head) {
		this.dept_head = dept_head;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public Integer getCol_pk() {
		return col_pk;
	}

	public void setCol_pk(Integer col_pk) {
		this.col_pk = col_pk;
	}

	public Date getEva_date() {
		return eva_date;
	}

	public void setEva_date(Date eva_date) {
		this.eva_date = eva_date;
	}

	public String getSypi_code() {
		return sypi_code;
	}

	public void setSypi_code(String sypi_code) {
		this.sypi_code = sypi_code;
	}

	public String getSypi_name() {
		return sypi_name;
	}

	public void setSypi_name(String sypi_name) {
		this.sypi_name = sypi_name;
	}

	public Integer getPk() {
		return pk;
	}

	public void setPk(Integer pk) {
		this.pk = pk;
	}

	public String getSypi_pk() {
		return sypi_pk;
	}

	public void setSypi_pk(String sypi_pk) {
		this.sypi_pk = sypi_pk;
	}

	public Integer getEva_num() {
		return eva_num;
	}

	public void setEva_num(Integer eva_num) {
		this.eva_num = eva_num;
	}

	public String getEva_exl() {
		return eva_exl;
	}

	public void setEva_exl(String eva_exl) {
		this.eva_exl = eva_exl;
	}

	public String getEva_type() {
	   return eva_type;	
	}
	public void setEva_type(String eva_type) {
		this.eva_type = eva_type;
	}
    
	public String getEva_type_name() {
		if(eva_type!=null){
		eva_type_name=eva_type;
		return "1".equals(eva_type)?"部门指标":"个人指标";
		}
		return eva_type_name;
	    
	
	}

	public String getEva_date_year() {
		if(eva_date!=null){
			Calendar canlandar = Calendar.getInstance();
			canlandar.setTime(eva_date);
			return canlandar.get(Calendar.YEAR)+"年";
		}else{
			return "";
		}
		
	}

	public void setEva_date_year(String eva_date_year) {
		this.eva_date_year = eva_date_year;
	}

	public Integer getCol_zf() {
		if(col_pk==0){
			col_zf=eva_num;
		}
		return col_zf;
	}

	public String getQuarter() {
		if(eva_date!=null){
			Calendar canlandar = Calendar.getInstance();
			canlandar.setTime(eva_date);
			int i=(canlandar.get(Calendar.MONTH)+1)/3;
			 Math.ceil(i);
			 return i+"季度";
		}else{
			return "";
		}
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
    
}
