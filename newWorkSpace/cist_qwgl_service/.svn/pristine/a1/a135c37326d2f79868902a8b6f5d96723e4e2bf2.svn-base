package com.cist.myScheduling.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

public class QwReport {
	private BigDecimal pk_id;// ID

	private BigDecimal fk_dept_id;// 管理部门ID

	private String fk_police_team_id;// 警组ID

	private String report_type;// 报备类型（1：街面勤务；2：值班值守；3：接处警；4：轮休;5：机关）

	private String car_list_str;// 警车、警车关联人员集合，存放json对象（冗余数据）

	private String personnel_list_str;// 关联人员集合，存放人员类型、姓名、警号、呼号、电话号码json对象（冗余数据）

	private BigDecimal report_person_id;// 报备人

	private Date report_time;// 报备时间

	private Date report_period_type;// 报备日期

	private QwReportStreet qwReportStreet ;// 街面勤务

	private QwReportDuty qwReportDuty;// 值班值守

	private QwReportRest qwReportRest ;// 轮休

	private QwReportOffice qwReportOffice;// 机关

	private String report_type_name;// 报备类型（1：街面勤务；2：值班值守；3：接处警；4：轮休;5：机关）

	private String xq_name;// 巡区名称

	private String bctime;// 班次时间
	
	private Date bckssj;// 班次时间
	
	private Date bcjssj;// 班次时间

	private String report_person_name;// 报备人名字
	
	private List<QwSignIn> qwSignIn =new ArrayList<QwSignIn>();// 签到信息
	
	
	private String fk_dept_name;// 管理部门名称
	
	
	

	public BigDecimal getPk_id() {

		return pk_id;
	}

	public void setPk_id(BigDecimal pk_id) {
		this.pk_id = pk_id;
	}

	public BigDecimal getFk_dept_id() {
		return fk_dept_id;
	}

	public void setFk_dept_id(BigDecimal fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}

	public String getFk_police_team_id() {
		return fk_police_team_id;
	}

	public void setFk_police_team_id(String fk_police_team_id) {
		this.fk_police_team_id = fk_police_team_id;
	}

	public String getReport_type() {
		return report_type;
	}

	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}

	public String getCar_list_str() {
		return car_list_str;
	}

	public void setCar_list_str(String car_list_str) {
		this.car_list_str = car_list_str;
	}

	public String getPersonnel_list_str() {
		return personnel_list_str;
	}

	public void setPersonnel_list_str(String personnel_list_str) {
		this.personnel_list_str = personnel_list_str;
	}

	public BigDecimal getReport_person_id() {
		return report_person_id;
	}

	public void setReport_person_id(BigDecimal report_person_id) {
		this.report_person_id = report_person_id;
	}

	public Date getReport_time() {
		return report_time;
	}

	public void setReport_time(Date report_time) {
		this.report_time = report_time;
	}

	public String getReport_period_type() {
		if(report_period_type!=null) {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			return sf.format(report_period_type);
		}
		return "";
	}

	public void setReport_period_type(Date report_period_type) {
		this.report_period_type = report_period_type;
	}

	public QwReportStreet getQwReportStreet() {
		return qwReportStreet;
	}

	public void setQwReportStreet(QwReportStreet qwReportStreet) {
		this.qwReportStreet = qwReportStreet;
	}

	public QwReportDuty getQwReportDuty() {
		return qwReportDuty;
	}

	public void setQwReportDuty(QwReportDuty qwReportDuty) {
		this.qwReportDuty = qwReportDuty;
	}

	public QwReportRest getQwReportRest() {
		return qwReportRest;
	}

	public void setQwReportRest(QwReportRest qwReportRest) {
		this.qwReportRest = qwReportRest;
	}

	public QwReportOffice getQwReportOffice() {
		return qwReportOffice;
	}

	public void setQwReportOffice(QwReportOffice qwReportOffice) {
		this.qwReportOffice = qwReportOffice;
	}

	public String getReport_type_name() {
		if (report_type != null) {
			switch (report_type) {
			case "1":
				report_type_name = "街面勤务";
				break;
			case "2":
				report_type_name = "值班值守";
				break;
			case "3":
				report_type_name = "接处警";
				break;
			case "4":
				report_type_name = "轮休备勤";
				break;
			case "5":
				report_type_name = "机关工作";
				break;
			default:
				report_type_name = "未知";
				break;
			}
		}
		return report_type_name;
	}

	public void setReport_type_name(String report_type_name) {
		this.report_type_name = report_type_name;
	}

	public String getXq_name() {
		if ("1".equals(report_type) && qwReportStreet != null) {
			xq_name = qwReportStreet.getArea_name();// 巡区名称
		} else {
			xq_name = "无勤务区域";
		}
		return xq_name;
	}

	public void setXq_name(String xq_name) {
		this.xq_name = xq_name;
	}

	public String getBctime() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		if ("1".equals(report_type) && qwReportStreet != null) {
			Date start = qwReportStreet.getWork_shift_start_time();
			Date end = qwReportStreet.getWork_shift_end_time();
			if (start != null && end != null) {
				bctime = formatter.format(start) + "~" + formatter.format(end);
			} else if (start != null && end == null) {
				bctime = formatter.format(start);
			} else {
				bctime = formatter.format(end);
			}
		} else if ("2".equals(report_type) && qwReportDuty != null) {
			Date start = qwReportDuty.getWork_shift_start_time();
			Date end = qwReportDuty.getWork_shift_end_time();
			if (start != null && end != null) {
				bctime = formatter.format(start) + "~" + formatter.format(end);
			} else if (start != null && end == null) {
				bctime = formatter.format(start);
			} else {
				bctime = formatter.format(end);
			}
		} else if ("4".equals(report_type) && qwReportRest != null) {
			Date start = qwReportRest.getWork_start_time();
			Date end = qwReportRest.getWork_end_time();
			if (start != null && end != null) {
				bctime = formatter.format(start) + "~" + formatter.format(end);
			} else if (start != null && end == null) {
				bctime = formatter.format(start);
			} else {
				bctime = formatter.format(end);
			}
		} else if ("5".equals(report_type) && qwReportOffice != null) {
			Date start = qwReportOffice.getWork_start_time();
			Date end = qwReportOffice.getWork_end_time();
			if (start != null && end != null) {
				bctime = formatter.format(start) + "~" + formatter.format(end);
			} else if (start != null && end == null) {
				bctime = formatter.format(start);
			} else {
				bctime = formatter.format(end);
			}
		} else {
			bctime = "无";
		}
		return bctime;
	}

	public void setBctime(String bctime) {
		this.bctime = bctime;
	}

	public String getReport_person_name() {
		if (report_person_id != null) {
			report_person_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_USER, report_person_id.toString());
		}
		return report_person_name;
	}

	public void setReport_person_name(String report_person_name) {
		this.report_person_name = report_person_name;
	}

	public List<QwSignIn> getQwSignIn() {
		return qwSignIn;
	}

	public void setQwSignIn(List<QwSignIn> qwSignIn) {
		this.qwSignIn = qwSignIn;
	}

	public Date getBckssj() {
		if ("1".equals(report_type) && qwReportStreet != null) {
			bckssj = qwReportStreet.getWork_shift_start_time();
		} else if ("2".equals(report_type) && qwReportDuty != null) {
			bckssj = qwReportDuty.getWork_shift_start_time();
		} else if ("4".equals(report_type) && qwReportRest != null) {
			bckssj = qwReportRest.getWork_start_time();
		} else if ("5".equals(report_type) && qwReportOffice != null) {
			bckssj = qwReportOffice.getWork_start_time();
		}
		return bckssj;
	}

	public void setBckssj(Date bckssj) {
		this.bckssj = bckssj;
	}

	public Date getBcjssj() {
		if ("1".equals(report_type) && qwReportStreet != null) {
			bcjssj = qwReportStreet.getWork_shift_end_time();
		} else if ("2".equals(report_type) && qwReportDuty != null) {
			bcjssj = qwReportDuty.getWork_shift_end_time();
		} else if ("4".equals(report_type) && qwReportRest != null) {
			bcjssj = qwReportRest.getWork_end_time();
		} else if ("5".equals(report_type) && qwReportOffice != null) {
			bcjssj = qwReportOffice.getWork_end_time();
		}
		return bcjssj;
	}

	public void setBcjssj(Date bcjssj) {
		this.bcjssj = bcjssj;
	}

	public String getFk_dept_name() {
		if(fk_dept_id!=null) {
			fk_dept_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT_PK, fk_dept_id.toString());
		}
		return fk_dept_name;
	}

	public void setFk_dept_name(String fk_dept_name) {
		this.fk_dept_name = fk_dept_name;
	}

}