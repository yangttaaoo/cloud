package com.cist.qwgl.qwbb.model;

import java.io.Serializable;
import java.util.List;

import com.cist.personalentry.model.PoliceInfo;
import com.cist.qwgl.qwjg.model.GpsRecord;
import com.cist.qwgl.qwjg.model.Qw_gps_history;
import com.cist.qwgl.qwjg.model.Qw_patrol_alarm_log;
import com.cist.qwgl.qwjg.model.Qw_sign_in;

/***
 * 5.27. 警务资源信息-人员
 * @author wangtao
 *
 */
public class Jcsj_police_res_person implements Serializable{
	private static final long serialVersionUID = 1L;
	private  Integer id;//	id
	private  String glbm;//	管理部门代码
	private  String rybh;//	民警/辅警编号
	private  String xm;//	姓名
	private  String sfzhm	;//	身份证号码
	private  String xb;//	性别
	private  String ywgw;//	业务岗位
	private  String ryfl;//	 //1负责人2 民警 3协警   	人员分类（1-民警 2-辅警）
	private  String fjlx;//		人员类型（当rylx=2时有效）
	private  String bzlx;//	编制类型（当rylx=1时有效）
	private  String zj;//	职级（当rylx=1时有效）
	private  String zw;//职务（当rylx=1时有效）
	private  String zt;//状态，0-停用 1-启用
	private  String bgdh;//办公电话
	private  String yddh;//移动电话
	private  String dth;//电台号/对讲机号
	private  String zhh;//组呼号
	private  String vwh;//V网号
	
	 private String fk_police_team_id;//警组ID
	private String dept_name;
	private  String fk_dept_name;//部门名
	private  String car_brandname;//职务名
	private  String ywgwname;//业务岗位名
	private  String xbname;//性别名
	private Qw_gps_history qw_gps_history;//警员gps  历史
	private GpsRecord gpsrecord;//警员gps  实时
	private Qw_patrol_alarm_log qw_patrol_alarm_log;//9.43. 街面勤务异常日志
	private Qw_sign_in qw_sign_in;//签到表
	private Qw_sign_in qw_sign_intui;//签退

	private Integer renwu;//当前警员是否有任务0没有
	private Integer beiqiang=0;//当前警员是否配枪
	
	private Integer baobei=0;//当前警员是否报备
	 private List<Jcsj_police_res_person> children;
	 
	public List<Jcsj_police_res_person> getChildren() {
		return children;
	}
	public void setChildren(List<Jcsj_police_res_person> children) {
		this.children = children;
	}
	public Qw_sign_in getQw_sign_intui() {
		return qw_sign_intui;
	}
	public void setQw_sign_intui(Qw_sign_in qw_sign_intui) {
		this.qw_sign_intui = qw_sign_intui;
	}
	public Qw_patrol_alarm_log getQw_patrol_alarm_log() {
		return qw_patrol_alarm_log;
	}
	public void setQw_patrol_alarm_log(Qw_patrol_alarm_log qw_patrol_alarm_log) {
		this.qw_patrol_alarm_log = qw_patrol_alarm_log;
	}
	public Qw_sign_in getQw_sign_in() {
		return qw_sign_in;
	}
	public void setQw_sign_in(Qw_sign_in qw_sign_in) {
		this.qw_sign_in = qw_sign_in;
	}
	public Integer getBaobei() {
		return baobei;
	}
	public void setBaobei(Integer baobei) {
		this.baobei = baobei;
	}
	public Integer getBeiqiang() {
		return beiqiang;
	}
	public void setBeiqiang(Integer beiqiang) {
		this.beiqiang = beiqiang;
	}
	public Integer getRenwu() {
		return renwu;
	}
	public void setRenwu(Integer renwu) {
		this.renwu = renwu;
	}
	public GpsRecord getGpsrecord() {
		return gpsrecord;
	}
	public void setGpsrecord(GpsRecord gpsrecord) {
		this.gpsrecord = gpsrecord;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public Qw_gps_history getQw_gps_history() {
		return qw_gps_history;
	}
	public void setQw_gps_history(Qw_gps_history qw_gps_history) {
		this.qw_gps_history = qw_gps_history;
	}
	public String getFk_police_team_id() {
		return fk_police_team_id;
	}
	public void setFk_police_team_id(String fk_police_team_id) {
		this.fk_police_team_id = fk_police_team_id;
	}
	public String getFk_dept_name() {
		return fk_dept_name;
	}
	public void setFk_dept_name(String fk_dept_name) {
		this.fk_dept_name = fk_dept_name;
	}
	public String getCar_brandname() {
		return car_brandname;
	}
	public void setCar_brandname(String car_brandname) {
		this.car_brandname = car_brandname;
	}
	public String getYwgwname() {
		return ywgwname;
	}
	public void setYwgwname(String ywgwname) {
		this.ywgwname = ywgwname;
	}
	public String getXbname() {
		return xbname;
	}
	public void setXbname(String xbname) {
		this.xbname = xbname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGlbm() {
		return glbm;
	}
	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}
	public String getRybh() {
		return rybh;
	}
	public void setRybh(String rybh) {
		this.rybh = rybh;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getSfzhm() {
		return sfzhm;
	}
	public void setSfzhm(String sfzhm) {
		this.sfzhm = sfzhm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getYwgw() {
		return ywgw;
	}
	public void setYwgw(String ywgw) {
		this.ywgw = ywgw;
	}
	public String getRyfl() {
		return ryfl;
	}
	public void setRyfl(String ryfl) {
		this.ryfl = ryfl;
	}
	public String getFjlx() {
		return fjlx;
	}
	public void setFjlx(String fjlx) {
		this.fjlx = fjlx;
	}
	public String getBzlx() {
		return bzlx;
	}
	public void setBzlx(String bzlx) {
		this.bzlx = bzlx;
	}
	public String getZj() {
		return zj;
	}
	public void setZj(String zj) {
		this.zj = zj;
	}
	public String getZw() {
		return zw;
	}
	public void setZw(String zw) {
		this.zw = zw;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public String getBgdh() {
		return bgdh;
	}
	public void setBgdh(String bgdh) {
		this.bgdh = bgdh;
	}
	public String getYddh() {
		return yddh;
	}
	public void setYddh(String yddh) {
		this.yddh = yddh;
	}
	public String getDth() {
		return dth;
	}
	public void setDth(String dth) {
		this.dth = dth;
	}
	public String getZhh() {
		return zhh;
	}
	public void setZhh(String zhh) {
		this.zhh = zhh;
	}
	public String getVwh() {
		return vwh;
	}
	public void setVwh(String vwh) {
		this.vwh = vwh;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Jcsj_police_res_person(Integer id, String glbm, String rybh, String xm, String sfzhm, String xb, String ywgw,
			String ryfl, String fjlx, String bzlx, String zj, String zw, String zt, String bgdh, String yddh,
			String dth, String zhh, String vwh) {
		super();
		this.id = id;
		this.glbm = glbm;
		this.rybh = rybh;
		this.xm = xm;
		this.sfzhm = sfzhm;
		this.xb = xb;
		this.ywgw = ywgw;
		this.ryfl = ryfl;
		this.fjlx = fjlx;
		this.bzlx = bzlx;
		this.zj = zj;
		this.zw = zw;
		this.zt = zt;
		this.bgdh = bgdh;
		this.yddh = yddh;
		this.dth = dth;
		this.zhh = zhh;
		this.vwh = vwh;
	}
	public Jcsj_police_res_person() {
		super();
		// TODO Auto-generated constructor stub
	}


}