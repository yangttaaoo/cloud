package com.cist.myScheduling.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QwReportOffice {
    private BigDecimal pk_id;//ID

    private BigDecimal fk_report_id;//勤务报备ID

    private Date work_start_time;//开始时间

    private Date work_end_time;//结束时间
    
    private String bctimeyear;// 值班日期 2017-11-15

	public BigDecimal getPk_id() {
		return pk_id;
	}

	public void setPk_id(BigDecimal pk_id) {
		this.pk_id = pk_id;
	}

	public BigDecimal getFk_report_id() {
		return fk_report_id;
	}

	public void setFk_report_id(BigDecimal fk_report_id) {
		this.fk_report_id = fk_report_id;
	}

	public Date getWork_start_time() {
		return work_start_time;
	}

	public void setWork_start_time(Date work_start_time) {
		this.work_start_time = work_start_time;
	}

	public Date getWork_end_time() {
		return work_end_time;
	}

	public void setWork_end_time(Date work_end_time) {
		this.work_end_time = work_end_time;
	}

	public String getBctimeyear() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if (work_start_time != null && work_end_time != null) {
			if (formatter.format(work_start_time).equals(formatter.format(work_end_time))) {
				bctimeyear = formatter.format(work_start_time);
			} else {
				bctimeyear = formatter.format(work_start_time) + "~" + formatter.format(work_end_time);
			}

		} else if (work_start_time != null && work_end_time == null) {
			bctimeyear = formatter.format(work_start_time);
		} else {
			bctimeyear = formatter.format(work_end_time);
		}
		return bctimeyear;
	}

	public void setBctimeyear(String bctimeyear) {
		this.bctimeyear = bctimeyear;
	}

}