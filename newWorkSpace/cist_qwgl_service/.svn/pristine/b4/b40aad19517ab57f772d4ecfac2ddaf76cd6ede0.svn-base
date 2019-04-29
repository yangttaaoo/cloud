package com.cist.qwgl.jzgl.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.qwgl.jzgl.model.Jcsj_police_res_person;
import com.cist.qwgl.jzgl.model.Jcsjpoliceresources;
import com.cist.qwgl.jzgl.model.Qw_alarm_relation;
import com.cist.qwgl.jzgl.model.Qw_car_patrol_info;
import com.cist.qwgl.jzgl.model.Qw_car_patrol_relation;
import com.cist.qwgl.jzgl.model.Qw_duty_relation;
import com.cist.qwgl.jzgl.model.Qw_equip_info;
import com.cist.qwgl.jzgl.model.Qw_guns_relation;
import com.cist.qwgl.jzgl.model.Qw_police_team;
import com.cist.qwgl.jzgl.model.Qw_police_team_alarm;
import com.cist.qwgl.jzgl.model.Qw_police_team_duty;
import com.cist.qwgl.jzgl.model.Qw_police_team_street;
import com.cist.qwgl.jzgl.model.Qw_walk_patrol_relation;
import com.cist.qwgl.jzgl.model.Qwgl_bc_info;
import com.cist.qwgl.jzgl.model.Qwpatrolarea;
import com.cist.qwgl.jzgl.model.Sysfrmcode;
import com.cist.qwgl.jzgl.model.Syspoliceinfo;


public interface JzglMapper {
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
	/**
	 * 根据警组id查询值班值守关联的班次名称
	 * @param map
	 * @return
	 */
	public String querybcnamebyzbzs(HashMap<String,Object> map);
	/**
	 * 根据警组ID查询车巡信息
	 * @param map
	 * @return
	 */
	public List<Qw_car_patrol_info> querypolicecarbyjzid(HashMap<String,Object> map);
	
	/**
	 * 根据巡车id查询巡车详细信息
	 * @param map
	 * @return
	 */
	public List<Qw_car_patrol_relation> querypolicecarinfo(HashMap<String,Object> map);
	/**
	 * 根据警组id查询步巡信息
	 * @param map
	 * @return
	 */
	public List<Qw_walk_patrol_relation> querybxrybyjzid(HashMap<String,Object> map);
	/**
	 * 根据警组id查询装备信息
	 * @param map
	 * @return
	 */
	public List<Qw_equip_info> queryequip(HashMap<String,Object> map);
	/**
	 * 添加枪支关联警员信息
	 * @param map
	 * @return
	 */ 
	public Integer addqw_guns_relation(HashMap<String,Object> map);
	/**
	 * 根据装备信息id查询枪支关联警员信息
	 * @param map
	 * @return
	 */ 
	public List<Qw_guns_relation> queryqw_guns_relation(HashMap<String,Object> map);
	/**
	 * 添加值班值守关联人员信息
	 * @param map
	 * @return
	 */
	public Integer addQw_duty_relation(HashMap<String,Object> map);
	/**
	 * 查询值班值守关联人员信息
	 * @param map
	 * @return
	 */
	public List<Qw_duty_relation> queryQw_duty_relation(HashMap<String,Object> map);
	/**
	 * 根据警组id查询警组-值班值守表
	 * @param map
	 * @return
	 */
	public List<Qw_police_team_duty> queryQw_police_team_duty(HashMap<String,Object> map);
	/**
	 * 根据警组id删除装备报备
	 * @param map
	 * @return
	 */
	public Integer delzbbb(HashMap<String,Object> map);
	/**
	 * 根据装备信息表id删除枪支关联警员信息
	 * @param map
	 * @return
	 */
	public Integer delQw_guns_relation(HashMap<String,Object> map);
	/**
	 * 根据条件查询警组信息
	 * @param map
	 * @return
	 */
	public List<Qw_police_team> queryjzinfo(HashMap<String,Object> map);
	/**
	 * 根据车巡id删除车巡关联人员信息
	 * @param map
	 * @return
	 */
	public Integer delcarpatrol(HashMap<String,Object> map);
	/**
	 * 根据警组id删除车巡信息
	 * @param map
	 * @return
	 */
	public Integer delQw_car_patrol_info(HashMap<String,Object> map);
	/**
	 * 根据警组id删除步巡关联人员信息
	 * @param map
	 * @return
	 */
	public Integer delQw_walk_patrol_relation(HashMap<String,Object> map);
	/**
	 * 根据警组id删除警组信息
	 * @param map
	 * @return
	 */
	public Integer delQw_police_team(HashMap<String,Object> map);
	/**
	 * 根据警组id删除值班值守关联人员信息
	 * @param map
	 * @return
	 */
	public Integer delQw_duty_relation(HashMap<String,Object> map);
	/**
	 * 根据警组id删除警组-值班值守信息
	 * @param map
	 * @return
	 */
	public Integer delQw_police_team_duty(HashMap<String,Object> map);
	/**
	 * 根据警组id查询警组信息
	 * @param map
	 * @return
	 */
	public Qw_police_team queryjzbyjzid(HashMap<String,Object> map);
	/**
	 * 更新警组信息
	 * @param map
	 * @return
	 */
	public Integer updatejz(HashMap<String,Object> map);
	/**
	 * 根据警组id删除警组-街面勤务
	 * @param map
	 * @return
	 */
	public Integer deljmqw(HashMap<String,Object> map);
	/**
	 * 根据警组id删除警组-值班值守
	 * @param map
	 * @return
	 */
	public Integer delzbzs(HashMap<String,Object> map);
	/**
	 * 添加接警处信息
	 * @param map
	 * @return
	 */
	public Integer addjjc(HashMap<String,Object> map);
	/**
	 * 添加接处警关联人员信息
	 * @param map
	 * @return
	 */
	public Integer addjjcglry(HashMap<String,Object> map);
	/**
	 * 删除接警处信息
	 * @param map
	 * @return
	 */
	public Integer deljjc(HashMap<String,Object> map);
	/**
	 * 删除接处警关联人员信息
	 * @param map
	 * @return
	 */
	public Integer deljjcglry(HashMap<String,Object> map);
	/**
	 * 根据警组id查询警组-接处警
	 * @param map
	 * @return
	 */
	public Qw_police_team_alarm queryjcc(HashMap<String,Object> map);
	/**
	 * 根据警组id查询接处警关联人员信息
	 * @param map
	 * @return
	 */
	public List<Qw_alarm_relation> queryjccglry(HashMap<String,Object> map);
	/***
	 * 获取警员信息
	 * @param map
	 * @return
	 */
	public List<Jcsj_police_res_person> selectpoliceinfo(HashMap<String,Object> map);
}
