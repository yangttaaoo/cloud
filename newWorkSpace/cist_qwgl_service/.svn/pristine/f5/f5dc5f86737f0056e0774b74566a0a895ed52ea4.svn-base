package com.cist.myScheduling.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cist.feedback.model.DeptInfo;
import com.cist.feedback.model.QWAppraiseFeedbackResponse;
import com.cist.feedback.model.QwAssessmentAttachment;
import com.cist.feedback.model.Sys_frm_code;
import com.cist.frame.page.PageInfo;
import com.cist.myScheduling.model.QwReport;
import com.cist.myScheduling.model.QwSignIn;
import com.cist.myScheduling.model.Qw_patrol_alarm_log;
import com.cist.qwgl.jzgl.model.Qw_equip_info;
import com.cist.qwgl.jzgl.model.Qw_guns_relation;

public interface MySchedulingService {
	/**
	 * 查询所有
	 * 
	 * @param map
	 * @return
	 */
	Object listpageList(HashMap<String, Object> map, PageInfo page);
	
	// 基础数据查询
	List<Sys_frm_code> selectBaseData(HashMap<String, Object> map);
	
	/**
	 * 根据警组id查询装备信息
	 * @param map
	 * @return
	 */
	List<Qw_equip_info> queryequip(HashMap<String,Object> map);
	
	/**
	 * 根据装备信息id查询枪支关联警员信息
	 * @param map
	 * @return
	 */ 
	List<Qw_guns_relation> queryqw_guns_relation(HashMap<String,Object> map);
	
	/**
	 * 日历排班查询
	 * @param map
	 * @return
	 */ 
	List<QwReport> selectlist(HashMap<String,Object> map);
	
	/**
	 * 街面勤务异常日志查询
	 * @param map
	 * @return
	 */ 
	List<Qw_patrol_alarm_log>selectAlarmLog(HashMap<String,Object> map);
	
	/**
	 * 任务异常信息查询 通过签到和街面勤务异常判断早退迟到 脱岗
	 * @param map
	 * @return
	 */ 
	List<QwSignIn>selectSign(HashMap<String,Object> map);
	
	/**
	 * 根据条件查询街面勤务异常日志(分页)
	 * @param map
	 * @return
	 */
	public Object queryjmqwlogpageList(HashMap<String,Object> map,PageInfo info);
	
	
	
}
