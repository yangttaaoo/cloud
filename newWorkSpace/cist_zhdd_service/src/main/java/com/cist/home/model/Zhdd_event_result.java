package com.cist.home.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/***
 * 4.10. 事处置结果
 * @author wangtao
 *
 */
public class Zhdd_event_result implements Serializable{
	private static final long serialVersionUID = 1L;
	private String pk_id;//id
	private String fk_event_id;//事件id
	private Integer fk_submitter_id;//提交人
	private Date submit_time;//提交时间
	private String processing_results;//处理结果
	private Integer return_visit;//是否回访0是1否
	private String visit_results;//回访结果
	private Integer satisfaction_star;//满意度星级（0-5）
	/*private String sj_fkwz;//反馈位置
	private String sj_fkimg;//反馈图标URL
	private String sj_fkyy;//语音上报
*/
	public String getPk_id() {
		return pk_id;
	}
	public void setPk_id(String pk_id) {
		this.pk_id = pk_id;
	}
	public String getFk_event_id() {
		return fk_event_id;
	}
	public void setFk_event_id(String fk_event_id) {
		this.fk_event_id = fk_event_id;
	}
	public Integer getFk_submitter_id() {
		return fk_submitter_id;
	}
	public void setFk_submitter_id(Integer fk_submitter_id) {
		this.fk_submitter_id = fk_submitter_id;
	}
	public Date getSubmit_time() {
		return submit_time;
	}
	public void setSubmit_time(Date submit_time) {
		this.submit_time = submit_time;
	}
	public String getProcessing_results() {
		return processing_results;
	}
	public void setProcessing_results(String processing_results) {
		this.processing_results = processing_results;
	}
	public Integer getReturn_visit() {
		return return_visit;
	}
	public void setReturn_visit(Integer return_visit) {
		this.return_visit = return_visit;
	}
	public String getVisit_results() {
		return visit_results;
	}
	public void setVisit_results(String visit_results) {
		this.visit_results = visit_results;
	}
	public Integer getSatisfaction_star() {
		return satisfaction_star;
	}
	public void setSatisfaction_star(Integer satisfaction_star) {
		this.satisfaction_star = satisfaction_star;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Zhdd_event_result() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
}