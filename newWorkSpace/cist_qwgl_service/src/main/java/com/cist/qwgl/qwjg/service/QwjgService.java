package com.cist.qwgl.qwjg.service;

import java.util.HashMap;
import java.util.List;

import com.cist.qwgl.qwbb.model.Jcsj_police_res_person;
import com.cist.qwgl.qwbb.model.Qw_report;
import com.cist.qwgl.qwbb.model.Qwpbdata;
import com.cist.qwgl.qwbb.model.Sysfrmcode;
import com.cist.qwgl.qwjg.model.DeviceInfo;
import com.cist.qwgl.qwjg.model.EventInfo;
import com.cist.qwgl.qwjg.model.GpsRecord;
import com.cist.qwgl.qwjg.model.Jcsj_police_resources;
import com.cist.qwgl.qwjg.model.Onduty;
import com.cist.qwgl.qwjg.model.Qw_assessment_attachment;
import com.cist.qwgl.qwjg.model.Qw_gps_history;
import com.cist.qwgl.qwjg.model.Qw_individual_assessment;
import com.cist.qwgl.qwjg.model.Qw_patrol_alarm_log;
import com.cist.qwgl.qwjg.model.Qw_sign_in;

public interface QwjgService {
	/**
	 * 查询执勤任务列表
	 * @param today
	 * @return
	 */
	public List<Qw_report> selectQw_report(HashMap<String, Object> map);
	/**
	 * 查询执勤任务列表
	 * @param today
	 * @return
	 */
	public Qw_report kaoheselectQwreport(HashMap<String, Object> map);
	/**
	 * 查询勤务排班信息
	 * @param today
	 * @return
	 */
	public List<Qwpbdata> selectQwpbdata(HashMap<String, Object> map);
	/**
	 * 查询勤务排班信息巡区 跨行
	 * @param today
	 * @return
	 */
	public List<Qwpbdata> qwpbdataxunqu(HashMap<String, Object> map);
	/**
	 * 查询勤务排班信息预警信息
	 * @param today
	 * @return
	 */
	public List<Qw_patrol_alarm_log> yujingxinx(HashMap<String, Object> map);
	/**
	 * 警员分页查询
	 * @param today
	 * @return
	 */
	public List<Jcsj_police_res_person> pageListSyspoliceinfo(HashMap<String, Object> map);
	/**
	 * 警车分页查询
	 * @param today
	 * @return
	 */
	public List<Jcsj_police_resources> pageListJcsj_police_resources(HashMap<String, Object> map);
	/**
	 * 查询基础信息
	 * @param today
	 * @return
	 */
	public List<Sysfrmcode> selectjichuxin(HashMap<String, Object> map);
	/**
	 * 查询警务资源信息
	 * @param today
	 * @return
	 */
	public List<Jcsj_police_resources> jcsjpoliceresources(HashMap<String, Object> map);
	/**
	 * 查询警务资源信息 警员
	 * @param today
	 * @return
	 */
	public List<Jcsj_police_resources> jingyuan(HashMap<String, Object> map);
	/***
	 * 勤务监管警务资源信息
	 * @param map
	 * @return
	 */
	public List<Qw_report> qwreportjg(HashMap<String, Object> map);
	/***
	 * 签到信息
	 * @param map
	 * @return
	 */
	public List<Qw_sign_in> qw_sign_in(HashMap<String, Object> map);
	/**
	 * 是否配枪
	 * @param map
	 * @return
	 */
	public Integer qiangzi(HashMap<String,Object> map);
	/**
	 * 是否配枪  勤务监督
	 * @param map
	 * @return
	 */
	public Integer qiangziqungwu(HashMap<String,Object> map);
	/**
	 * 当前勤务人员签到信息
	 * @param map
	 * @return
	 */
	public Qw_sign_in sign(HashMap<String,Object> map);
	/**
	 * 当前勤务人员街面勤务异常日志
	 * @param map
	 * @return
	 */
	public Qw_patrol_alarm_log qw_patrol_alarm_log(HashMap<String,Object> map);
	/**
	 * 当前勤务人员街面勤务异常日志 分页数据
	 * @param map
	 * @return
	 */
	public List<Qw_patrol_alarm_log> alarmlogList(HashMap<String,Object> map);
	/**
	 * 当前勤务人员街面勤务异常日志 是否有接处警
	 * @param map
	 * @return
	 */
	public String eventid(HashMap<String,Object> map);
	/***
	 * 事件信息
	 * @param map
	 * @return
	 */
	public EventInfo eventlist(HashMap<String,Object> map);
	/**
	 * 获取基础信息
	 * @param map
	 * @return
	 */
	List<Sysfrmcode> sysfrmcode(HashMap<String, Object> map);
	/**
	 * 历史gps
	 * @param map
	 * @return
	 */
	List<Qw_gps_history> qw_gps_history(HashMap<String, Object> map);
	/**
	 * 不部门人员信息
	 * @param map
	 * @return
	 */
	Qwpbdata eventinfobumen(HashMap<String, Object> map);
	/**
	 * 查询预警信息
	 * @param map
	 * @return
	 */
	List<Qw_patrol_alarm_log> qwpatrolalarmyujing(HashMap<String, Object> map);
	/**
	 * 警员警车在线率
	 * @param map
	 * @return
	 */
	Integer jczzxl(HashMap<String, Object> map);
	/***
	 * 个人考核
	 * @param map
	 * @return
	 */
	Qw_individual_assessment qwindividualassessment(HashMap<String, Object> map);
	/***
	 * 添加附件
	 * @param map
	 * @return
	 */
	Integer addattachment(HashMap<String, Object> map);
	/***
	 * 考核附件信息
	 * @param map
	 * @return
	 */
	List<Qw_assessment_attachment> getAttachment(HashMap<String, Object> map);
	/**
	 * 删除附件信息
	 * @param map
	 * @return
	 */
	Integer deleteAttachment(HashMap<String, Object> map);
	/**
	 * 更新个人考核
	 * @param map
	 * @return
	 */
	Integer updateassessment(HashMap<String, Object> map);
	/**
	 * 350M数据
	 * @param map
	 * @return
	 */
	List<GpsRecord> gpsrecord(HashMap<String, Object> map);
	/**
	 * 350M在离线据数据
	 * @param map
	 * @return
	 */
	Integer gpsrecordlixian(HashMap<String, Object> map);
	/***
	 * 监控设备
	 * @param map
	 * @return
	 */
	List<DeviceInfo> deviceList(HashMap<String, Object> map);
	/***
	 * 一键解除报警 删除所有异常数据
	 * @param map
	 * @return
	 */
	Integer delyichang(HashMap<String, Object> map);
	/***
	 * 一键解除报警 删除这段时间内 考核数据
	 * @param map
	 * @return
	 */
	Integer delkaohe(HashMap<String, Object> map);
	/***
	 * 警车警员历史数据
	 * @param map
	 * @return
	 */
	List<Qw_gps_history> qwgpshistoryywbh(HashMap<String, Object> map);
	/***
	 * 车俩信息
	 * @param map
	 * @return
	 */
	List<Jcsj_police_resources> jcsj_police_resources(HashMap<String, Object> map);
	/***
	 * 人员信息
	 * @param map
	 * @return
	 */
	List<Jcsj_police_res_person> jcsjpolicerespersoninfo(HashMap<String, Object> map);
	List<Onduty> onduty(HashMap<String, Object> map);
	List<Onduty> ondutyche(HashMap<String, Object> map);
	List<Onduty> ondutydiaodu(HashMap<String, Object> map);
	List<Onduty> ondutyjcbk(HashMap<String, Object> map);
}