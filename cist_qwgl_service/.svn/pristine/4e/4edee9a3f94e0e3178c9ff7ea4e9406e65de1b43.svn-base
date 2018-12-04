package com.cist.qwgl.jzgl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.leavemanagment.model.DeptInfo;
import com.cist.qwgl.jzgl.mapper.JzglMapper;
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
import com.cist.qwgl.jzgl.service.JzglService;
import com.cist.qwgl.qwgzt.mapper.QwgztMapper;
import com.cist.qwgl.qwgzt.model.CarInfo;
import com.cist.qwgl.qwgzt.model.Need;
import com.cist.qwgl.qwgzt.model.PbglPolice;
import com.cist.qwgl.qwgzt.model.Police;
import com.cist.qwgl.qwgzt.model.PoliceCar;
import com.cist.qwgl.qwgzt.service.QwgztService;
@Service
public class JzglSeviceImpl implements JzglService{
	@Autowired
	private JzglMapper mapper;

	@Override
	public List<Jcsjpoliceresources> querylistpageList(HashMap<String, Object> map) {
		return mapper.querylistpageList(map);
	}

	@Override
	public List<Sysfrmcode> selectSysfrmcode(HashMap<String, Object> map) {
		return mapper.selectSysfrmcode(map);
	}

	@Override
	public List<Syspoliceinfo> selectpolice(HashMap<String, Object> map) {
		return mapper.selectpolice(map);
	}

	@Override
	public List<Sysfrmcode> selfct(HashMap<String, Object> map) {
		return mapper.selfct(map);
	}

	@Override
	public List<Sysfrmcode> selfctquan(HashMap<String, Object> map) {
		return mapper.selfctquan(map);
	}

	@Override
	public List<Sysfrmcode> bancigt(HashMap<String, Object> map) {
		return mapper.bancigt(map);
	}

	@Override
	public List<Qwpatrolarea> patrolarea(HashMap<String, Object> map) {
		return mapper.patrolarea(map);
	}

	@Override
	public List<Qwgl_bc_info> qwglbcinfo(HashMap<String, Object> map) {
		return mapper.qwglbcinfo(map);
	}

	@Override
	public Integer saveQw_police_team(HashMap<String, Object> map) {
		return mapper.saveQw_police_team(map);
	}

	@Override
	public Integer saveQw_police_team_street(HashMap<String, Object> map) {
		return mapper.saveQw_police_team_street(map);
	}

	@Override
	public Integer saveQw_equip_info(HashMap<String, Object> map) {
		return mapper.saveQw_equip_info(map);
	}

	@Override
	public Integer saveQw_walk_patrol_relation(List<Syspoliceinfo> policList) {
		return mapper.saveQw_walk_patrol_relation(policList);
	}

	@Override
	public Integer saveqw_car_patrol_info(HashMap<String, Object> map) {
		return mapper.saveqw_car_patrol_info(map);
	}

	@Override
	public Integer saveqw_car_patrol_relation(HashMap<String, Object> map) {
		return mapper.saveqw_car_patrol_relation(map);
	}

	@Override
	public List<Qw_police_team> qwpoliceteampagelist(HashMap<String, Object> map) {
		return mapper.qwpoliceteampagelist(map);
	}

	@Override
	public Sysfrmcode selectSysfrmcodeinfo(HashMap<String, Object> map) {
		return mapper.selectSysfrmcodeinfo(map);
	}

	@Override
	public Qw_police_team_street selQw_police_team_street(HashMap<String, Object> map) {
		return mapper.selQw_police_team_street(map);
	}

	@Override
	public Qwgl_bc_info chauxnQwgl_bc_info(HashMap<String, Object> map) {
		return mapper.chauxnQwgl_bc_info(map);
	}

	@Override
	public Qwpatrolarea chauxnxunqu(HashMap<String, Object> map) {
		return mapper.chauxnxunqu(map);
	}

	@Override
	public Integer addteam_duty(HashMap<String, Object> map) {
		return mapper.addteam_duty(map);
	}

	@Override
	public Integer addrelation(HashMap<String, Object> map) {
		return mapper.addrelation(map);
	}

	@Override
	public String querybcnamebyzbzs(HashMap<String, Object> map) {
		return mapper.querybcnamebyzbzs(map);
	}

	@Override
	public List<Qw_car_patrol_info> querypolicecarbyjzid(HashMap<String, Object> map) {
		return mapper.querypolicecarbyjzid(map);
	}

	@Override
	public List<Qw_car_patrol_relation> querypolicecarinfo(HashMap<String, Object> map) {
		return mapper.querypolicecarinfo(map);
	}

	@Override
	public List<Qw_walk_patrol_relation> querybxrybyjzid(HashMap<String, Object> map) {
		return mapper.querybxrybyjzid(map);
	}

	@Override
	public List<Qw_equip_info> queryequip(HashMap<String, Object> map) {
		return mapper.queryequip(map);
	}

	@Override
	public Integer addqw_guns_relation(HashMap<String, Object> map) {
		return mapper.addqw_guns_relation(map);
	}

	@Override
	public List<Qw_guns_relation> queryqw_guns_relation(HashMap<String, Object> map) {
		return mapper.queryqw_guns_relation(map);
	}

	@Override
	public Integer addQw_duty_relation(HashMap<String, Object> map) {
		return mapper.addQw_duty_relation(map);
	}

	@Override
	public List<Qw_duty_relation> queryQw_duty_relation(HashMap<String, Object> map) {
		return mapper.queryQw_duty_relation(map);
	}

	@Override
	public List<Qw_police_team_duty> queryQw_police_team_duty(HashMap<String, Object> map) {
		return mapper.queryQw_police_team_duty(map);
	}

	@Override
	public Integer delzbbb(HashMap<String, Object> map) {
		return mapper.delzbbb(map);
	}

	@Override
	public Integer delQw_guns_relation(HashMap<String, Object> map) {
		return mapper.delQw_guns_relation(map);
	}

	@Override
	public List<Qw_police_team> queryjzinfo(HashMap<String, Object> map) {
		return mapper.queryjzinfo(map);
	}

	@Override
	public Integer delcarpatrol(HashMap<String, Object> map) {
		return mapper.delcarpatrol(map);
	}

	@Override
	public Integer delQw_car_patrol_info(HashMap<String, Object> map) {
		return mapper.delQw_car_patrol_info(map);
	}

	@Override
	public Integer delQw_walk_patrol_relation(HashMap<String, Object> map) {
		return mapper.delQw_walk_patrol_relation(map);
	}

	@Override
	public Integer delQw_police_team(HashMap<String, Object> map) {
		return mapper.delQw_police_team(map);
	}

	@Override
	public Integer delQw_duty_relation(HashMap<String, Object> map) {
		return mapper.delQw_duty_relation(map);
	}

	@Override
	public Integer delQw_police_team_duty(HashMap<String, Object> map) {
		return mapper.delQw_police_team_duty(map);
	}

	@Override
	public Qw_police_team queryjzbyjzid(HashMap<String, Object> map) {
		return mapper.queryjzbyjzid(map);
	}

	@Override
	public Integer updatejz(HashMap<String, Object> map) {
		return mapper.updatejz(map);
	}

	@Override
	public Integer deljmqw(HashMap<String, Object> map) {
		return mapper.deljmqw(map);
	}

	@Override
	public Integer delzbzs(HashMap<String, Object> map) {
		return mapper.delzbzs(map);
	}

	@Override
	public Integer addjjc(HashMap<String, Object> map) {
		return mapper.addjjc(map);
	}

	@Override
	public Integer addjjcglry(HashMap<String, Object> map) {
		return mapper.addjjcglry(map);
	}

	@Override
	public Integer deljjc(HashMap<String, Object> map) {
		return mapper.deljjc(map);
	}

	@Override
	public Integer deljjcglry(HashMap<String, Object> map) {
		return mapper.deljjcglry(map);
	}

	@Override
	public Qw_police_team_alarm queryjcc(HashMap<String, Object> map) {
		return mapper.queryjcc(map);
	}

	@Override
	public List<Qw_alarm_relation> queryjccglry(HashMap<String, Object> map) {
		return mapper.queryjccglry(map);
	}


}
