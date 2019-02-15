package com.cist.inspectionplan.model;
import java.io.Serializable;
import java.util.Date;

public class InspectionInfo implements Serializable{

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
	private String check_status_name;//审核状态中文名称
	private Integer check_reviewer_id;//审核人ID
	private int[] gs_zu;//巡检公司组
	private String[] sb_zu;//巡检设备组
	
	
	public String getPlanners_name() {
		return planners_name;
	}
	public void setPlanners_name(String planners_name) {
		this.planners_name = planners_name;
	}
	public String[] getSb_zu() {
		return sb_zu;
	}
	public void setSb_zu(String[] sb_zu) {
		this.sb_zu = sb_zu;
	}
	public int[] getGs_zu() {
		return gs_zu;
	}
	public void setGs_zu(int[] gs_zu) {
		this.gs_zu = gs_zu;
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
		if(check_status == '1'){
			this.setCheck_status_name("通过");
		}else if(check_status == '0'){
			this.setCheck_status_name("审核中");
		}else{
			this.setCheck_status_name("不通过");
		}
	}
	public String getCheck_status_name() {
		return check_status_name;
	}
	public void setCheck_status_name(String check_status_name) {
		this.check_status_name = check_status_name;
	}
	public Integer getCheck_reviewer_id() {
		return check_reviewer_id;
	}
	public void setCheck_reviewer_id(Integer check_reviewer_id) {
		this.check_reviewer_id = check_reviewer_id;
	}
	
	
	
}
