package com.cist.xxtj.wfsjlztj.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TBL_FLOW_CARD_STAT implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 9172143491417205756L;
	private String jrzpzs;//总违法量（JSON格式：{“ZWFL”: “1”, “ZTB”: “10%”, “RHB”: “10%”}, ZWFL：总违法量，ZTB：周同比，RHB：日环比）
    private String jrshs;//总审核量（JSON格式：{“ZSHL”: “1”, “RJSHL”: “10”}, ZSHL：总审核量，RJSHL：日均审核量）
    private String jrscs;//12日未审核量（JSON格式：{“SHL”: “1”, “ZB”: “10%”}, SHL：未审核量，ZB：占比）
    private String sjyxl;//有效率（JSON格式：{“YXL”: “1”, “ZTB”: “10%”, “RHB”: “10%”}, YXL：有效率，ZTB：周同比，RHB：日环比）
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date tjsj;//统计时间（格式：YYYY-MM-dd）
	public String getJrzpzs() {
		return jrzpzs;
	}
	public void setJrzpzs(String jrzpzs) {
		this.jrzpzs = jrzpzs;
	}
	public String getJrshs() {
		return jrshs;
	}
	public void setJrshs(String jrshs) {
		this.jrshs = jrshs;
	}
	public String getJrscs() {
		return jrscs;
	}
	public void setJrscs(String jrscs) {
		this.jrscs = jrscs;
	}
	public String getSjyxl() {
		return sjyxl;
	}
	public void setSjyxl(String sjyxl) {
		this.sjyxl = sjyxl;
	}
	public Date getTjsj() {
		return tjsj;
	}
	public void setTjsj(Date tjsj) {
		this.tjsj = tjsj;
	}
    
}
