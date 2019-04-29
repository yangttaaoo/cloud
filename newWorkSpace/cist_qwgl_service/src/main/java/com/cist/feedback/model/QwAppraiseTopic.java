package com.cist.feedback.model;

import java.math.BigDecimal;
import java.util.Date;

public class QwAppraiseTopic {

	 private BigDecimal pk_id;

	    private BigDecimal fk_dept_id;

	    private String topic_name;

	    private BigDecimal default_value;

	    private String topic_explain;

	    private String enabled_state;

	    private BigDecimal create_person_id;

	    private Date create_time;

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

		public String getTopic_name() {
			return topic_name;
		}

		public void setTopic_name(String topic_name) {
			this.topic_name = topic_name;
		}

		public BigDecimal getDefault_value() {
			return default_value;
		}

		public void setDefault_value(BigDecimal default_value) {
			this.default_value = default_value;
		}

		public String getTopic_explain() {
			return topic_explain;
		}

		public void setTopic_explain(String topic_explain) {
			this.topic_explain = topic_explain;
		}

		public String getEnabled_state() {
			return enabled_state;
		}

		public void setEnabled_state(String enabled_state) {
			this.enabled_state = enabled_state;
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
	    
}