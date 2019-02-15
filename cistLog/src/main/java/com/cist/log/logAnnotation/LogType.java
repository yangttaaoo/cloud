package com.cist.log.logAnnotation;

public enum LogType {

	DEFAULT("4"),  //默认查询
	UPDATE("2"), //修改
	ADD("1") , //修改
	DELETE("3"), // 删除
	QUERYINTER("5"), //查询接口
	WRITEINTER("6"),  // 写入接口
	LOGIN("7");  //登录日志
	
	private final String value;
	private LogType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return this.value.toString();
	}
}
