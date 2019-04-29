package com.cist.depttestin.model;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class TargetInfo {
	private int fk_topic_id;//栏目ID
	private String topic_name;//栏目名字
	private int metrics_num;//直标分值
	public int getFk_topic_id() {
		return fk_topic_id;
	}
	public void setFk_topic_id(int fk_topic_id) {
		this.fk_topic_id = fk_topic_id;
	}
	public int getMetrics_num() {
		return metrics_num;
	}
	public void setMetrics_num(int metrics_num) {
		this.metrics_num = metrics_num;
	}
	public String getTopic_name() {
		String fk=String.valueOf(fk_topic_id);
		if(fk_topic_id!=0){
			topic_name=SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_PDLM,fk );
		}
		return topic_name;
	}
	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}
	
}
