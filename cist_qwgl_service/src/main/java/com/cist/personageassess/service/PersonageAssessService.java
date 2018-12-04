package com.cist.personageassess.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.personageassess.model.QwReportStreet;
import com.cist.personageassess.model.Qw_Opertion_Log;
import com.cist.personageassess.model.Qw_assessment_attachment;
import com.cist.personageassess.model.Qw_individual_assessment;
import com.cist.personageassess.model.Qw_patrol_alarm_log;
import com.cist.personageassess.model.Qw_report;
import com.cist.personageassess.model.TBL_OFFE_EVDI;
import com.cist.qwgl.jzgl.model.Qw_equip_info;

public interface PersonageAssessService {
	/**
	 * 根据条件查询个人勤务考核信息
	 * @param map
	 * @return
	 */
	public List<Qw_individual_assessment> querypersonageassessinfo(HashMap<String,Object> map);
	/**
	 * 根据条件查询个人勤务考核信息(分页)
	 * @param map
	 * @return
	 */
	public Object querypersonageassessinfopageList(HashMap<String,Object> map,PageInfo info);
	/**
	 * 根据个人勤务id查询日志信息
	 * @param map
	 * @return
	 */
	public List<Qw_Opertion_Log> querylog(HashMap<String,Object> map);
	/**
	 * 根据条件查询非现场数据
	 * @param map
	 * @return
	 */
	public List<TBL_OFFE_EVDI> queryfxinfo(HashMap<String,Object> map);
	/**
	 * 根据条件查询非现场数据（分页）
	 * @param map
	 * @return
	 */
	public Object queryfxinfopageList(HashMap<String,Object> map,PageInfo info);
	/**
	 * 根据条件查询附件信息
	 * @param map
	 * @return
	 */
	public List<Qw_assessment_attachment> queryfjinfo(HashMap<String,Object> map);
	
	/**
	 * 根据条件查询考核栏目名称
	 * @param map
	 * @return
	 */
	public String querykhlm(HashMap<String,Object> map);
	/**
	 * 根据条件查询考核条例名称
	 * @param map
	 * @return
	 */
	public String querykhtl(HashMap<String,Object> map);
	/**
	 * 根据勤务报备id查询勤务报备信息
	 * @param map
	 * @return
	 */
	public Qw_report queryqwbbinfo(HashMap<String,Object> map);
	
	/**
	 * 根据条件查询街面勤务异常日志
	 * @param map
	 * @return
	 */
	public List<Qw_patrol_alarm_log> queryjmqwlog(HashMap<String,Object> map);
	
	/**
	 * 根据条件查询街面勤务异常日志(分页)
	 * @param map
	 * @return
	 */
	public Object queryjmqwlogpageList(HashMap<String,Object> map,PageInfo info);
	
	/**
	 * 根据勤务报备id查询界面勤务信息
	 * @param map
	 * @return
	 */
	public QwReportStreet queryjmqwinfo(HashMap<String,Object> map);
	
	/**
	 * 根据报备id查询装备信息
	 * @param map
	 * @return
	 */
	public Qw_equip_info queryequip(HashMap<String,Object> map);
}
