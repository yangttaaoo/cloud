package com.cist.qwgl.qwbb.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class View_preparation implements Serializable{

	private static final long serialVersionUID = 1L;
   private String timename;//时间
   private Integer jingche;//警车
   private Integer xiejing;//协警
   private Integer minjing;//民警
public String getTimename() throws ParseException {
	SimpleDateFormat data=new SimpleDateFormat("yyyy-M-d");
	return data.format(data.parse(timename));
}
public void setTimename(String timename) {
	this.timename = timename;
}
public Integer getJingche() {
	return jingche;
}
public void setJingche(Integer jingche) {
	this.jingche = jingche;
}
public Integer getXiejing() {
	return xiejing;
}
public void setXiejing(Integer xiejing) {
	this.xiejing = xiejing;
}
public Integer getMinjing() {
	return minjing;
}
public void setMinjing(Integer minjing) {
	this.minjing = minjing;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public View_preparation(String timename, Integer jingche, Integer xiejing, Integer minjing) {
	super();
	this.timename = timename;
	this.jingche = jingche;
	this.xiejing = xiejing;
	this.minjing = minjing;
}
public View_preparation() {
	super();
	// TODO Auto-generated constructor stub
}
 
/*  create or replace view view_preparation as
select t.timename,t.jingche,
(t.bu_xiejing+t.che_xiejing+t.zhi_xiujing+t.lun_xie_jing+t.jiguan_xiejing+t.jichujing_xiejing) as xiejing,
(t.bu_minjing+t.che_minjing+t.zhi_minjing+t.lun_min_jing+t.jiguan_minjing+t.jichujing_minjing) as minjing
 from (
select k.timename,sum(k.bu_xiejing) as bu_xiejing ,sum(k.bu_minjing) as bu_minjing,sum(k.jingche) as jingche,sum(k.che_minjing) as che_minjing,sum(k.che_xiejing) as che_xiejing ,sum(k.zhi_xiujing) as zhi_xiujing ,
sum(k.zhi_minjing) as zhi_minjing ,sum(k.lun_xie_jing)  as lun_xie_jing,sum(k.lun_min_jing)  as lun_min_jing,sum(k.jiguan_minjing) as jiguan_minjing ,
sum(k.jiguan_xiejing) as jiguan_xiejing,sum(k.jichujing_minjing) as jichujing_minjing,sum(k.jichujing_xiejing) as jichujing_xiejing from (
select to_char(t.report_period_type,'yyyy-mm-dd') as timename,t.pk_id,
步巡信息
步巡协警
(select count(*) from QW_REPORT_WALK_RELATION h where h.fk_report_id=t.pk_id and h.user_type=3) as bu_xiejing,
步巡民警
(select count(*) from QW_REPORT_WALK_RELATION h where h.fk_report_id=t.pk_id and h.user_type!=3) as bu_minjing,
车巡信息
警车
(select count(*) from QW_REPORT_CAR_PATROL k where k.fk_report_id=t.pk_id) as jingche,
警车民警
(select count(*) from QW_REPORT_CAR_RELATION p where p.fk_car_patrol_id in (select k.pk_id from QW_REPORT_CAR_PATROL k where k.fk_report_id=t.pk_id) and p.user_type!=3) as che_minjing,
警车协警
(select count(*) from QW_REPORT_CAR_RELATION p where p.fk_car_patrol_id in (select k.pk_id from QW_REPORT_CAR_PATROL k where k.fk_report_id=t.pk_id) and p.user_type=3) as che_xiejing,
值班值守关联人员报备
(select count(*) from QW_REPORT_DUTY_RELATION y where y.fk_report_id=t.pk_id and y.user_type=5) as zhi_xiujing,
(select count(*) from QW_REPORT_DUTY_RELATION y where y.fk_report_id=t.pk_id and y.user_type!=5) as zhi_minjing,
轮休报备
(select count(*) from QW_REPORT_REST_RELATION e where e.fk_report_rest_id=(select r.pk_id from QW_REPORT_REST r where r.fk_report_id=t.pk_id) and e.user_type=2) as lun_xie_jing,
(select count(*) from QW_REPORT_REST_RELATION e where e.fk_report_rest_id=(select r.pk_id from QW_REPORT_REST r where r.fk_report_id=t.pk_id) and e.user_type=1) as lun_min_jing,
机关工作报备
(select count(*) from QW_REPORT_OFFICE_RELATION q where q.fk_report_office_id=(select w.pk_id from QW_REPORT_OFFICE w where w.fk_report_id=t.pk_id) and q.user_type=1) as jiguan_minjing,
(select count(*) from QW_REPORT_OFFICE_RELATION q where q.fk_report_office_id=(select w.pk_id from QW_REPORT_OFFICE w where w.fk_report_id=t.pk_id) and q.user_type=2) as jiguan_xiejing,
接处警报备
(select count(*) from QW_REPORT_ALARM_RELATION n where n.fk_report_alarm_id=(select w.pk_id from QW_REPORT_ALARM w where w.fk_report_id=t.pk_id) and n.user_type=1) as jichujing_minjing,
(select count(*) from QW_REPORT_ALARM_RELATION n where n.fk_report_alarm_id=(select w.pk_id from QW_REPORT_ALARM w where w.fk_report_id=t.pk_id) and n.user_type=2) as jichujing_xiejing
 from QW_REPORT t
group by t.report_period_type,t.pk_id
) k
group by k.timename
)t;*/
}
