package com.cist.myScheduling.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QwReportDuty {
    private BigDecimal pk_id;//ID

    private BigDecimal fk_report_id;//班次ID

    private BigDecimal fk_work_shift_id;//班次ID

    private BigDecimal channel_num;//频道号

    private String carll_num;//呼号

    private String telephone;//值班电话

    private String work_shift_name;//班次名称（冗余数据）

    private Date work_shift_start_time;//班次开始时间（冗余数据）

    private Date work_shift_end_time;//班次结束时间（冗余数据）

    private BigDecimal span_cycle;//班次跨越周期（冗余数据）
    
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

	public BigDecimal getFk_work_shift_id() {
		return fk_work_shift_id;
	}

	public void setFk_work_shift_id(BigDecimal fk_work_shift_id) {
		this.fk_work_shift_id = fk_work_shift_id;
	}

	public BigDecimal getChannel_num() {
		return channel_num;
	}

	public void setChannel_num(BigDecimal channel_num) {
		this.channel_num = channel_num;
	}

	public String getCarll_num() {
		return carll_num;
	}

	public void setCarll_num(String carll_num) {
		this.carll_num = carll_num;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getWork_shift_name() {
		return work_shift_name;
	}

	public void setWork_shift_name(String work_shift_name) {
		this.work_shift_name = work_shift_name;
	}

	public Date getWork_shift_start_time() {
		return work_shift_start_time;
	}

	public void setWork_shift_start_time(Date work_shift_start_time) {
		this.work_shift_start_time = work_shift_start_time;
	}

	public Date getWork_shift_end_time() {
		return work_shift_end_time;
	}

	public void setWork_shift_end_time(Date work_shift_end_time) {
		this.work_shift_end_time = work_shift_end_time;
	}

	public BigDecimal getSpan_cycle() {
		return span_cycle;
	}

	public void setSpan_cycle(BigDecimal span_cycle) {
		this.span_cycle = span_cycle;
	}

	public String getBctimeyear() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if (work_shift_start_time != null && work_shift_end_time != null) {
			if (formatter.format(work_shift_start_time).equals(formatter.format(work_shift_end_time))) {
				bctimeyear = formatter.format(work_shift_start_time);
			} else {
				bctimeyear = formatter.format(work_shift_start_time) + "~" + formatter.format(work_shift_end_time);
			}

		} else if (work_shift_start_time != null && work_shift_end_time == null) {
			bctimeyear = formatter.format(work_shift_start_time);
		} else {
			bctimeyear = formatter.format(work_shift_end_time);
		}
		return bctimeyear;
	}

	public void setBctimeyear(String bctimeyear) {
		this.bctimeyear = bctimeyear;
	}

}