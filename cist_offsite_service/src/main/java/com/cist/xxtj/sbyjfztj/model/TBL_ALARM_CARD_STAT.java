package com.cist.xxtj.sbyjfztj.model;

import java.io.Serializable;
import java.util.Date;

public class TBL_ALARM_CARD_STAT implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5568027161774696070L;
	private String sbyjs;
    private String jrsbgzl;
    private String jrsbzxs;
    private String jrsbzxl;
    private Date tjsj;
	public String getSbyjs() {
		return sbyjs;
	}
	public void setSbyjs(String sbyjs) {
		this.sbyjs = sbyjs;
	}
	public String getJrsbgzl() {
		return jrsbgzl;
	}
	public void setJrsbgzl(String jrsbgzl) {
		this.jrsbgzl = jrsbgzl;
	}
	public String getJrsbzxs() {
		return jrsbzxs;
	}
	public void setJrsbzxs(String jrsbzxs) {
		this.jrsbzxs = jrsbzxs;
	}
	public String getJrsbzxl() {
		return jrsbzxl;
	}
	public void setJrsbzxl(String jrsbzxl) {
		this.jrsbzxl = jrsbzxl;
	}
	public Date getTjsj() {
		return tjsj;
	}
	public void setTjsj(Date tjsj) {
		this.tjsj = tjsj;
	}
    
}
