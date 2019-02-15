package com.cist.qwgl.qwjg.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.qwgl.qwbb.model.Jcsj_police_res_person;
import com.cist.qwgl.qwbb.model.Qw_report;
import com.cist.qwgl.qwbb.model.Qw_sign_in;
import com.cist.qwgl.qwbb.model.Qwpbdata;
import com.cist.qwgl.qwbb.model.Sysfrmcode;
import com.cist.qwgl.qwbb.model.Syspoliceinfo;
import com.cist.qwgl.qwjg.model.Jcsj_police_resources;
import com.cist.qwgl.qwjg.model.Qw_patrol_alarm_log;

public interface QwjgMapper {

	/**
	 * 查询执勤任务列表
	 * @param today
	 * @return
	 */
	public List<Qw_report> selectQw_report(HashMap<String, Object> map);
	/**
	 * 查询勤务排班信息 部门 跨行
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
	 * 查询警务资源信息 车辆
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
}
