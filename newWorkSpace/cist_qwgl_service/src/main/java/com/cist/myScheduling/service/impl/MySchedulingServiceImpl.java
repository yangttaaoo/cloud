package com.cist.myScheduling.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cist.feedback.model.Sys_frm_code;
import com.cist.frame.page.PageInfo;
import com.cist.myScheduling.mapper.MySchedulingMapper;
import com.cist.myScheduling.model.QwReport;
import com.cist.myScheduling.model.QwSignIn;
import com.cist.myScheduling.model.Qw_patrol_alarm_log;
import com.cist.myScheduling.service.MySchedulingService;
import com.cist.qwgl.jzgl.model.Qw_equip_info;
import com.cist.qwgl.jzgl.model.Qw_guns_relation;

@Service
public class MySchedulingServiceImpl implements MySchedulingService {
	@Autowired
	private MySchedulingMapper mapper;

	@Override
	public Object listpageList(HashMap<String, Object> map, PageInfo page) {
		return mapper.list(map);
	}

	@Override
	public List<Sys_frm_code> selectBaseData(HashMap<String, Object> map) {
		return mapper.selectBaseData(map);
	}

	@Override
	public List<Qw_equip_info> queryequip(HashMap<String, Object> map) {
		return mapper.queryequip(map);
	}

	@Override
	public List<Qw_guns_relation> queryqw_guns_relation(HashMap<String, Object> map) {
		return mapper.queryqw_guns_relation(map);
	}

	@Override
	public List<QwReport> selectlist(HashMap<String, Object> map) {
		return mapper.selectlist(map);
	}

	@Override
	public List<Qw_patrol_alarm_log> selectAlarmLog(HashMap<String, Object> map) {
		return mapper.selectAlarmLog(map);
	}

	@Override
	public List<QwSignIn> selectSign(HashMap<String, Object> map) {
		return mapper.selectSign(map);
	}

	@Override
	public Object queryjmqwlogpageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.queryjmqwlog(map);
	}

}
