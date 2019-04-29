package com.cist.eventmanagement.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 事件处置流程
 * 
 * @author Hy
 *
 */
public class Zhdd_event_flow implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -404578567014265695L;
	private String pk_id;//id
	private String fk_event_id;//事件id
	private String work_flow_num;//流程序号
	private String work_flow_name;//流程名称
	private String feedback_contents;//反馈信息
	private Date complete_time;//完成时间
	private Integer fk_complete_person_id;//完成人
	private String sj_fkwz;//反馈位置
	private String sj_fkimg;//反馈图标url
	private String sj_fkyy;//语音上报
	
	private String fk_complete_person_name;//完成人名称
	
//	private Zhdd_work_flow zhdd_work_flow;//流程
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
	public String getWork_flow_num() {
		return work_flow_num;
	}
	public void setWork_flow_num(String work_flow_num) {
		this.work_flow_num = work_flow_num;
	}
	public String getWork_flow_name() {
		return work_flow_name;
	}
	public void setWork_flow_name(String work_flow_name) {
		this.work_flow_name = work_flow_name;
	}
	public String getFeedback_contents() {
		return feedback_contents;
	}
	public void setFeedback_contents(String feedback_contents) {
		this.feedback_contents = feedback_contents;
	}
	public Date getComplete_time() {
		return complete_time;
	}
	public void setComplete_time(Date complete_time) {
		this.complete_time = complete_time;
	}
	public Integer getFk_complete_person_id() {
		return fk_complete_person_id;
	}
	public void setFk_complete_person_id(Integer fk_complete_person_id) {
		this.fk_complete_person_id = fk_complete_person_id;
	}
	public String getSj_fkwz() {
		return sj_fkwz;
	}
	public void setSj_fkwz(String sj_fkwz) {
		this.sj_fkwz = sj_fkwz;
	}
	public String getSj_fkimg() {
		return sj_fkimg;
	}
	public void setSj_fkimg(String sj_fkimg) {
		this.sj_fkimg = sj_fkimg;
	}
	public String getSj_fkyy() {
		return sj_fkyy;
	}
	public void setSj_fkyy(String sj_fkyy) {
		this.sj_fkyy = sj_fkyy;
	}
	public String getFk_complete_person_name() {
		return fk_complete_person_name;
	}
	public void setFk_complete_person_name(String fk_complete_person_name) {
		this.fk_complete_person_name = fk_complete_person_name;
	}
//	public Zhdd_work_flow getZhdd_work_flow() {
//		return zhdd_work_flow;
//	}
//	public void setZhdd_work_flow(Zhdd_work_flow zhdd_work_flow) {
//		this.zhdd_work_flow = zhdd_work_flow;
//	}
	
}
