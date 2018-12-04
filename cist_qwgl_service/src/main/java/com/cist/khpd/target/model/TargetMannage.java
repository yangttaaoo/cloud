package com.cist.khpd.target.model;

import java.util.Calendar;
public class TargetMannage {
	private String sypi_code;//警员编号
	private String sypi_name;//警员姓名
	private String eva_type;// 类型 1，部门。2，个人 
	private String dept_name;//單位名字
	private Integer eva_num;// 栏目分值
	private String eva_date;//日期
	private String sypi_pk;//季度
	private String eva_exl;// 备注说明
	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
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
		if(eva_type!=null){
			return "1".equals(eva_type)?"部门指标":"个人指标";
			}
	   return eva_type;	
	}
	public void setEva_type(String eva_type) {
		this.eva_type = eva_type;
	}
	public String getEva_date() {
		Target t=new Target();
		if(t.getEva_date()!=null){
			Calendar canlandar = Calendar.getInstance();
			canlandar.setTime(t.getEva_date());
			return canlandar.get(Calendar.YEAR)+"年";
		}else{
			return "";
		}
		
	}
	public String getSypi_pk() {
		Target t=new Target();
		if(t.getEva_date()!=null){
			Calendar canlandar = Calendar.getInstance();
			canlandar.setTime(t.getEva_date());
			 int i=(canlandar.get(Calendar.MONDAY))/4;
			 return i+"季度";
		}else{
			return "";
		}
	}

	public void setEva_date(String eva_date) {
		this.eva_date = eva_date;
	}

}
