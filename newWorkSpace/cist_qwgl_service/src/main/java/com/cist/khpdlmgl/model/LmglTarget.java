package com.cist.khpdlmgl.model;

import java.io.Serializable;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
/**
 * 考核栏目
 */
public class LmglTarget implements Serializable {
	
	private static final long serialVersionUID = 3454L;
	private Integer pk_id;//ID
	private Long fk_dept_id;//管理部门ID
	private String  topic_name;//评定栏目
	private Integer default_value;//默认分值
	private String topic_explain;//栏目说明
	private String enabled_state;//启用状态（0：禁用；1：启用）
	private Integer create_person_id;//创建人
	private String  create_name;//创建人名字
	private Date create_time;//创建时间
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Long getFk_dept_id() {
		return fk_dept_id;
	}
	public void setFk_dept_id(Long fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}
	public String getTopic_name() {
		return topic_name;
	}
	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}
	public Integer getDefault_value() {
		return default_value;
	}
	public void setDefault_value(Integer default_value) {
		this.default_value = default_value;
	}
	public String getTopic_explain() {
		return topic_explain;
	}
	public void setTopic_explain(String topic_explain) {
		this.topic_explain = topic_explain;
	}
	public String getEnabled_state() {
		if(enabled_state!=null){
			return "1".equals(enabled_state)?"启用":"禁用";
		}
		return enabled_state;
	}
	public void setEnabled_state(String enabled_state) {
		this.enabled_state = enabled_state;
	}
	public Integer getCreate_person_id() {
		return create_person_id;
	}
	public void setCreate_person_id(Integer create_person_id) {
		this.create_person_id = create_person_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getCreate_name() {
		if(create_person_id!=null){
			create_name=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, create_person_id.toString()); ;
			return create_name;
		}
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
}
