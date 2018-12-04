package com.cist.serviceconfig.imgnameconfig.model;

public class Progress  {
	 private Integer toal;//下载总数
	 private Integer size;//下载的大小
	 private Integer percent;//下载进度
	public Integer getToal() {
		return toal;
	}
	public void setToal(Integer toal) {
		this.toal = toal;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getPercent() {
		return percent;
	}
	public void setPercent(Integer percent) {
		this.percent = percent;
	}
	 
}
