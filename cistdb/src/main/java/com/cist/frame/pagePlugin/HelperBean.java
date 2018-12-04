package com.cist.frame.pagePlugin;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="pagehelper")
public class HelperBean {

	private String helperDialect;
	private String params;
	private String reasonable;
	private String supportMethodsArguments;
	private String offsetAsPageNum;
	public String getOffsetAsPageNum() {
		return offsetAsPageNum;
	}
	public void setOffsetAsPageNum(String offsetAsPageNum) {
		this.offsetAsPageNum = offsetAsPageNum;
	}
	public String getRowBoundsWithCount() {
		return rowBoundsWithCount;
	}
	public void setRowBoundsWithCount(String rowBoundsWithCount) {
		this.rowBoundsWithCount = rowBoundsWithCount;
	}
	private String rowBoundsWithCount;
	public String getHelperDialect() {
		return helperDialect;
	}
	public String getParams() {
		return params;
	}
	public String getReasonable() {
		return reasonable;
	}
	public String getSupportMethodsArguments() {
		return supportMethodsArguments;
	}
	public void setHelperDialect(String helperDialect) {
		this.helperDialect = helperDialect;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public void setReasonable(String reasonable) {
		this.reasonable = reasonable;
	}
	public void setSupportMethodsArguments(String supportMethodsArguments) {
		this.supportMethodsArguments = supportMethodsArguments;
	}
}
