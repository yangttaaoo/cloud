package com.cist.leavemanagment.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Leave implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3214050244966137538L;
	private Integer l_pk;	//主键
	private Date l_qjksrq;	//请假开始日期
	private Date l_qjjsrq;	//请假结束日期
	private Integer tianshu;	//天数差
	private String l_sqr;	//申请人
	private String l_qjyy;  //请假原因
	private Date l_sqsj;	//申请时间
	private Integer l_spzt; //审批状态  1未审批 2已审批 3未通过
	private String l_spr;	//审批人
	private String l_sqsm;	//申请说明
	private Date l_spsj;	//审批时间
	private String l_deptid;//所属单位
	private String times;	//请假日期
	private String l_shsm;  //审核说明
	private String deptname;
	
	private Date sell_off_time;	//销假时间
	private String qjrname;	//申请人姓名
	private String sprrname;  //审批人姓名
	private String qjrnames;  //销假人 申请人
	private Integer shijiqingjia;	//实际请假天数
	
	private Integer xjzt;//销假状态 1未销假 2已销假
	
	
	public String getQjrnames() {
		return qjrnames;
	}

	public void setQjrnames(String qjrnames) {
		this.qjrnames = qjrnames;
	}

	public Integer getXjzt() {
		return xjzt;
	}

	public void setXjzt(Integer xjzt) {
		this.xjzt = xjzt;
	}

	public Integer getShijiqingjia() {
		if(l_spzt==2) {//已审批
			Date date=new Date();
			if(date.getTime()>l_qjksrq.getTime()) {//今天必须大于请假开始时间
				int days = (int) ((date.getTime() - l_qjksrq.getTime()) / (1000*3600*24));
				return days;
			}else {
				return 0;
			}
		}else if(xjzt==4) {
			int days = (int) ((sell_off_time.getTime() - l_qjksrq.getTime()) / (1000*3600*24));
			return days;
		}
		else {
			return 0;
		}
		
	}

	public void setShijiqingjia(Integer shijiqingjia) {
		this.shijiqingjia = shijiqingjia;
	}

	public Date getSell_off_time() {
		return sell_off_time;
	}

	public void setSell_off_time(Date sell_off_time) {
		this.sell_off_time = sell_off_time;
	}

	public Integer getTianshu() {
		 int days = (int) ((l_qjjsrq.getTime() - l_qjksrq.getTime()) / (1000*3600*24));
		return days;
	}

	public void setTianshu(Integer tianshu) {
		this.tianshu = tianshu;
	}

	public String getQjrname() {
		return qjrname;
	}

	public void setQjrname(String qjrname) {
		this.qjrname = qjrname;
	}

	public String getSprrname() {
		return sprrname;
	}

	public void setSprrname(String sprrname) {
		this.sprrname = sprrname;
	}

	public SimpleDateFormat getSim1() {
		return sim1;
	}

	public void setSim1(SimpleDateFormat sim1) {
		this.sim1 = sim1;
	}

	public SimpleDateFormat getSim2() {
		return sim2;
	}

	public void setSim2(SimpleDateFormat sim2) {
		this.sim2 = sim2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	SimpleDateFormat sim1 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sim2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public String getTimes() {
		return sim1.format(l_qjksrq)+"至"+sim1.format(l_qjjsrq);
	}
	
	public void setTimes(String times) {
		this.times = times;
	}

	public Integer getL_pk() {
		return l_pk;
	}

	public void setL_pk(Integer l_pk) {
		this.l_pk = l_pk;
	}

	public Date getL_qjksrq() {
		return l_qjksrq;
	}

	public void setL_qjksrq(Date l_qjksrq) {
		this.l_qjksrq = l_qjksrq;
	}

	public Date getL_qjjsrq() {
		return l_qjjsrq;
	}

	public void setL_qjjsrq(Date l_qjjsrq) {
		this.l_qjjsrq = l_qjjsrq;
	}

	public String getL_sqr() {
		return l_sqr;
	}

	public void setL_sqr(String l_sqr) {
		this.l_sqr = l_sqr;
	}

	public String getL_qjyy() {
		return l_qjyy;
	}
	
	public void setL_qjyy(String l_qjyy) {
		this.l_qjyy = l_qjyy;
	}

	public String getL_sqsj() {
		if (l_sqsj!=null) {
			return sim2.format(l_sqsj);
		}
		return null;
	}

	public void setL_sqsj(Date l_sqsj) {
		this.l_sqsj = l_sqsj;
	}

	public String getL_spzt() {
		//1未审批 2已审批 3未通过 4已销假
		if (l_spzt == 1) {
			return "未审批";
		}else if (l_spzt == 2) {
			return "已审批";
		}else if (l_spzt == 3) {
			return "未通过";
		}else{
			return "已销假";
		}
	}

	public void setL_spzt(Integer l_spzt) {
		this.l_spzt = l_spzt;
	}

	public String getL_spr() {
		return l_spr;
	}

	public void setL_spr(String l_spr) {
		this.l_spr = l_spr;
	}

	public String getL_sqsm() {
		return l_sqsm;
	}

	public void setL_sqsm(String l_sqsm) {
		this.l_sqsm = l_sqsm;
	}

	public String getL_spsj() {
		if (l_spsj!=null) {
			return sim2.format(l_spsj);
		}
		return null;
	}

	public void setL_spsj(Date l_spsj) {
		this.l_spsj = l_spsj;
	}

	public String getL_deptid() {
		return l_deptid;
	}

	public void setL_deptid(String l_deptid) {
		this.l_deptid = l_deptid;
	}
	
	public String getL_shsm() {
		return l_shsm;
	}
	
	public void setL_shsm(String l_shsm) {
		this.l_shsm = l_shsm;
	}
	
	public String getDeptname() {
		return deptname;
	}
	
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

}
