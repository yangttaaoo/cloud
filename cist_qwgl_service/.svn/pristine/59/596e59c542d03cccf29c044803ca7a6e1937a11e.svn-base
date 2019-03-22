package com.cist.qwgl.qwbb.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.qwgl.qwbb.model.Gongen;
import com.cist.qwgl.qwbb.model.Jcsj_police_res_person;
import com.cist.qwgl.qwbb.model.Jcsjpoliceresources;
import com.cist.qwgl.qwbb.model.Overviewdata;
import com.cist.qwgl.qwbb.model.Qw_car_patrol_info;
import com.cist.qwgl.qwbb.model.Qw_car_patrol_relation;
import com.cist.qwgl.qwbb.model.Qw_duty_relation;
import com.cist.qwgl.qwbb.model.Qw_equip_info;
import com.cist.qwgl.qwbb.model.Qw_guns_relation;
import com.cist.qwgl.qwbb.model.Qw_police_team;
import com.cist.qwgl.qwbb.model.Qw_police_team_duty;
import com.cist.qwgl.qwbb.model.Qw_police_team_street;
import com.cist.qwgl.qwbb.model.Qw_report;
import com.cist.qwgl.qwbb.model.Qw_walk_patrol_relation;
import com.cist.qwgl.qwbb.model.Qwgl_bc_info;
import com.cist.qwgl.qwbb.model.Qwpatrolarea;
import com.cist.qwgl.qwbb.model.Sysfrmcode;
import com.cist.qwgl.qwbb.model.Tjzy;
import com.cist.qwgl.qwbb.model.View_preparation;




public interface QwbbMapper {
	/***
	 * 警车分页
	 * @param map
	 * @return
	 */
	public List<Jcsjpoliceresources> querylistpageList(HashMap<String,Object> map);
	/***
	 * 获取车辆基础类型
	 * @param map
	 * @return
	 */
	public List<Sysfrmcode> selectSysfrmcode(HashMap<String,Object> map);
	/***
	 * 获取警员信息
	 * @param map
	 * @return
	 */
	public List<Jcsj_police_res_person> selectpolice(HashMap<String,Object> map);
	/***
	 * 查询勤务类型
	 * @param map
	 * @return
	 */
	public List<Sysfrmcode> selfct(HashMap<String,Object> map);
	/***
	 * 查询勤务类型 全
	 * @param map
	 * @return
	 */
	public List<Sysfrmcode> selfctquan(HashMap<String,Object> map);
	/***
	 * 班次跨天
	 * @param map
	 * @return
	 */
	public List<Sysfrmcode> bancigt(HashMap<String,Object> map);
	/***
	 * 获取巡区信息
	 * @param map
	 * @return
	 */
	public List<Qwpatrolarea> patrolarea(HashMap<String,Object> map);
	/***
	 * 获取班次信息
	 * @param map
	 * @return
	 */
	public List<Qwgl_bc_info> qwglbcinfo(HashMap<String,Object> map);
	/***
	 * 保存警组信息
	 * @param map
	 * @return
	 */
	public Integer saveQw_police_team(HashMap<String,Object> map);
	/***
	 * 保存警组-街面勤务
	 * @param map
	 * @return
	 */
	public Integer saveQw_police_team_street(HashMap<String,Object> map);
	/***
	 * 保存装备信息
	 * @param map
	 * @return
	 */
	public Integer saveQw_equip_info(HashMap<String,Object> map);
	/***
	 * 保存步巡关联人员信息
	 * @param map
	 * @return
	 */
	public Integer saveQw_walk_patrol_relation(List<Jcsj_police_res_person> policList);
	/***
	 * 保存车巡信息
	 * @param map
	 * @return
	 */
	public Integer saveqw_car_patrol_info(HashMap<String,Object> map);
	/***
	 * 保存车巡关联人员信息
	 * @param map
	 * @return
	 */
	public Integer saveqw_car_patrol_relation(HashMap<String,Object> map);
	/***
	 * 警组分页
	 * @param map
	 * @return
	 */
	public List<Qw_police_team> qwpoliceteampagelist(HashMap<String,Object> map);
	/***
	 * 获取勤务类型 查询
	 * @param map
	 * @return
	 */
	public Sysfrmcode selectSysfrmcodeinfo(HashMap<String,Object> map);
	/***
	 * 查询警组-街面勤务   警组ID获取街面勤务
	 * @param map
	 * @return
	 */
	public Qw_police_team_street selQw_police_team_street(HashMap<String,Object> map);
	/***
	 * 查询班次-id
	 * @param map
	 * @return
	 */
	public Qwgl_bc_info chauxnQwgl_bc_info(HashMap<String,Object> map);
	/***
	 * 查询巡区-id
	 * @param map
	 * @return
	 */
	public Qwpatrolarea chauxnxunqu(HashMap<String,Object> map);
	/***
	 * 保存警组-值班值守
	 * @param map
	 * @return
	 */
	public Integer addteam_duty(HashMap<String,Object> map);
	/***
	 * 保存警组-值班值守关联人员信息
	 * @param map
	 * @return
	 */
	public Integer addrelation(HashMap<String,Object> map);
	/***
	 * 查询 步巡关联人员信息 警组id
	 * @param map
	 * @return
	 */
	public List<Qw_walk_patrol_relation> qwwalkpatrolrelationlist(HashMap<String,Object> map);
	/***
	 * id查询警员
	 * @param map
	 * @return
	 */
	public Jcsj_police_res_person syspoliceinfo(HashMap<String,Object> map);
	/**
	 * 查询装备信息  警组id
	 * @param map
	 * @return
	 */
	public Qw_equip_info qwequipinfos(HashMap<String,Object> map);
	/**
	 * 9.15.	枪支关联警员信息  装备信息ID查询
	 * @param map
	 * @return
	 */
	public List<Qw_guns_relation> qwgunsrelation(HashMap<String,Object> map);
	/**
	 * 9.3.	车巡信息  警组ID
	 * @param map
	 * @return
	 */
	public List<Qw_car_patrol_info> qw_car_patrol_info(HashMap<String,Object> map);
	/**
	 * 9.4.	车巡关联人员信息 车巡信息ID
	 * @param map
	 * @return
	 */
	public List<Qw_car_patrol_relation> qw_car_patrol_relation(HashMap<String,Object> map);
	/**
	 * 查询车俩信息 id
	 * @param map
	 * @return
	 */
	public Jcsjpoliceresources jcsjpoliceresources(HashMap<String,Object> map);
	/**
	 * 保存9.17.	勤务报备
	 * @param map
	 * @return
	 */
	public Integer addqw_report(HashMap<String,Object> map);
	/**
	 * 保存9.18.	街面勤务报备
	 * @param map
	 * @return
	 */
	public Integer addqw_report_street(HashMap<String,Object> map);
	/**
	 * 保存9.15.	枪支关联警员信息
	 * @param map
	 * @return
	 */
	public Integer addqw_guns_relation(HashMap<String,Object> map);
	/**
	 * 查询值班值守   警组id
	 * @param map
	 * @return
	 */
	public Qw_police_team_duty seqw_police_team_duty(HashMap<String,Object> map);
	/**
	 * 查询9.7.	值班值守关联人员信息   警组id
	 * @param map
	 * @return
	 */
	public List<Qw_duty_relation> qw_duty_relationid(HashMap<String,Object> map);
	/**
	 * 添加9.22.	值班值守报备
	 * @param map
	 * @return
	 */
	public Integer addqw_report_duty(HashMap<String,Object> map);
	/**
	 * 添加9.23.	值班值守关联人员报备
	 * @param map
	 * @return
	 */
	public Integer addqw_report_duty_relation(HashMap<String,Object> map);
	/**
	 * 添加9.28.	机关工作报备
	 * @param map
	 * @return
	 */
	public Integer addqw_report_office(HashMap<String,Object> map);
	/**
	 * 添加9.29.	机关工作报备关联人员
	 * @param map
	 * @return
	 */
	public Integer addqw_report_office_relation(HashMap<String,Object> map);
	/**
	 * 添加9.26.	轮休报备
	 * @param map
	 * @return
	 */
	public Integer addqw_report_rest(HashMap<String,Object> map);
	/**
	 * 添加9.27.	轮休报备关联人员
	 * @param map
	 * @return
	 */
	public Integer addqw_report_rest_relation(HashMap<String,Object> map);
	/**
	 * 添加9.24.	接处警报备
	 * @param map
	 * @return
	 */
	public Integer addqw_report_alarm(HashMap<String,Object> map);
	/**
	 * 添加9.25.	接处警报备关联人员
	 * @param map
	 * @return
	 */
	public Integer addqw_report_alarm_relation(HashMap<String,Object> map);
	/**
	 * 查询报备日期的警车警员民警 数据
	 * @param map
	 * @return
	 */
	public List<View_preparation> view_preparation(HashMap<String,Object> map);
	/**
	 * 查询总览数据
	 * @param map
	 * @return
	 */
	public List<Overviewdata> overviewdata(HashMap<String,Object> map);
	/**
	 * 总览数据集合
	 * @param map
	 * @return
	 */
	public List<Gongen> gongen(HashMap<String,Object> map);
	/**
	 * 删除报备
	 * @param map
	 * @return
	 */
	public Integer delbaobei(HashMap<String,Object> map);
	/**
	 * 获取勤务报备
	 * @param map
	 * @return
	 */
	public Qw_report qwreport(HashMap<String,Object> map);
	/**
	 * 更新勤务报备
	 * @param map
	 * @return
	 */
	public Integer updateQw_report(HashMap<String,Object> map);
	/**
	 * 更新街面勤务报备
	 * @param map
	 * @return
	 */
	public Integer updateqw_report_street(HashMap<String,Object> map);
	/**
	 * 更新装备信息
	 * @param map
	 * @return
	 */
	public Integer updateqw_equip_info(HashMap<String,Object> map);

	/**
	 * 删除车行信息  勤务报备ID
	 * @param map
	 * @return
	 */
	public Integer delchexingg(HashMap<String,Object> map);
	/**
	 * 查询节假日
	 * @param map
	 * @return
	 */
	public List<Sysfrmcode> selectjjr(HashMap<String,Object> map);
	/**
	 * 勤务报备主界面统计参数
	 * @param map
	 * @return
	 */
	public List<Tjzy> selectTjzy(HashMap<String,Object> map);
	/**
	 * 勤务报备 步行人员  车俩人员 当天班次是否报备
	 * @param map
	 * @return
	 */
	public List<Integer> bancibaobei(HashMap<String,Object> map);
	/**
	 * 勤务报备   车俩 当天班次是否报备
	 * @param map
	 * @return
	 */
	public List<Integer> bcheliangbaobei(HashMap<String,Object> map);
	/***
	 * 车辆用途
	 * @param map
	 * @return
	 */
	public List<Sysfrmcode> cheliangyjw(HashMap<String,Object> map);
	public List<Qw_report> qwreportpage(HashMap<String,Object> map);
	
}
