package com.cist.inspectiontalk.model;

import java.io.Serializable;
import java.util.Date;

public class TalkInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer pk_id;
	private Integer fk_dept_id;//管理部门
	private Integer fk_planners_id;//制定人
	private String planners_name;//制定人名称
	private Date create_time;//制定时间
	private Integer inspection_num;//巡检编号
	private String inspection_name;//巡检名称
	private Date inspection_start_time;//开始时间
	private Date inspection_end_time;//结束时间
	private String start_time;
	private String end_time;
	private String start_time_end;//巡检时间
	private String inspection_contents;//巡检内容
	private String remarks;//备注
	private char check_status;//审核状态（2：不通过，0：审核中，1通过）
	private String gspk;//关联公司pk
	private char company_confirm;//公司确认状态：0未确认1已确认
	private String company_confirm_name;
	private String inspection_report;//巡检报告
	private String report_time;//巡检时间
	private Integer fk_rapporteur_id;//报告人
	private String fk_rapporteir_name;//报告人名称
	
	
	public String getFk_rapporteir_name() {
		return fk_rapporteir_name;
	}
	public void setFk_rapporteir_name(String fk_rapporteir_name) {
		this.fk_rapporteir_name = fk_rapporteir_name;
	}
	public String getInspection_report() {
		return inspection_report;
	}
	public void setInspection_report(String inspection_report) {
		this.inspection_report = inspection_report;
	}
	public String getReport_time() {
		return report_time;
	}
	public void setReport_time(String report_time) {
		this.report_time = report_time;
	}
	public Integer getFk_rapporteur_id() {
		return fk_rapporteur_id;
	}
	public void setFk_rapporteur_id(Integer fk_rapporteur_id) {
		this.fk_rapporteur_id = fk_rapporteur_id;
	}
	public char getCompany_confirm() {
		return company_confirm;
	}
	public void setCompany_confirm(char company_confirm) {
		this.company_confirm = company_confirm;
		if(company_confirm == '0'){
			this.setCompany_confirm_name("未确认");
		}else{
			this.setCompany_confirm_name("已确认");
		}
	}
	public String getCompany_confirm_name() {
		return company_confirm_name;
	}
	public void setCompany_confirm_name(String company_confirm_name) {
		this.company_confirm_name = company_confirm_name;
	}
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Integer getFk_dept_id() {
		return fk_dept_id;
	}
	public void setFk_dept_id(Integer fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}
	public Integer getFk_planners_id() {
		return fk_planners_id;
	}
	public void setFk_planners_id(Integer fk_planners_id) {
		this.fk_planners_id = fk_planners_id;
	}
	public String getPlanners_name() {
		return planners_name;
	}
	public void setPlanners_name(String planners_name) {
		this.planners_name = planners_name;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Integer getInspection_num() {
		return inspection_num;
	}
	public void setInspection_num(Integer inspection_num) {
		this.inspection_num = inspection_num;
	}
	public String getInspection_name() {
		return inspection_name;
	}
	public void setInspection_name(String inspection_name) {
		this.inspection_name = inspection_name;
	}
	public Date getInspection_start_time() {
		return inspection_start_time;
	}
	public void setInspection_start_time(Date inspection_start_time) {
		this.inspection_start_time = inspection_start_time;
	}
	public Date getInspection_end_time() {
		return inspection_end_time;
	}
	public void setInspection_end_time(Date inspection_end_time) {
		this.inspection_end_time = inspection_end_time;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getStart_time_end() {
		return start_time_end;
	}
	public void setStart_time_end(String start_time_end) {
		this.start_time_end = start_time_end;
	}
	public String getInspection_contents() {
		return inspection_contents;
	}
	public void setInspection_contents(String inspection_contents) {
		this.inspection_contents = inspection_contents;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public char getCheck_status() {
		return check_status;
	}
	public void setCheck_status(char check_status) {
		this.check_status = check_status;
	}
	public String getGspk() {
		return gspk;
	}
	public void setGspk(String gspk) {
		this.gspk = gspk;
	}
	
	

}
