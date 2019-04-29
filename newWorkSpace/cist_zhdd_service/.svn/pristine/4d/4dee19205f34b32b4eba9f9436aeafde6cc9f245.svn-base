package com.cist.traffic.model;

import java.util.Date;

/**
 * 交通状况表
 * @author wxc
 *
 */
public class Traffic {
	
    private Integer jyzx;//警员在线
    private Integer jyqj;//警员请假
    private Integer ryzs;//警员总数
    private Integer jyzxn;//警员在线率
//    private Date yjsj;//预警时间
    private Integer sjzs;//今日交通事件总数
    private Integer sjzss;//交通事件总数
    private Integer rjzs;//日均总数
    private Long sfzd;//施工占道总数  
	public Integer getJyzx() {
		return jyzx;
	}
	public void setJyzx(Integer jyzx) {
		this.jyzx = jyzx;
	}
	public Integer getJyqj() {
		return jyqj;
	}
	public void setJyqj(Integer jyqj) {
		this.jyqj = jyqj;
	}
	public Integer getRyzs() {
		return ryzs;
	}
	public void setRyzs(Integer ryzs) {
		this.ryzs = ryzs;
	}
	public Integer getJyzxn() {
		return jyzx/ryzs*100;
	}
	public void setJyzxn(Integer jyzxn) {
		this.jyzxn = jyzxn;
	}
	public Integer getSjzs() {
		if(sjzs==null){
			return 0;
		}
		else{
		return sjzs;
		}
	}
	public void setSjzs(Integer sjzs) {
		this.sjzs = sjzs;
	}
	public Integer getSjzss() {
		return sjzss;
	}
	public void setSjzss(Integer sjzss) {
		this.sjzss = sjzss;
	}
	public Integer getRjzs() {
		return rjzs;
	}
	public void setRjzs(Integer rjzs) {
		this.rjzs = rjzs;
	}
	public Long getSfzd() {
		return sfzd;
	}
	public void setSfzd(Long sfzd) {
		this.sfzd = sfzd;
	}
    
}
