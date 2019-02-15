package com.cist.personageassess.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.personageassess.mapper.PersonageAssessMapper;
import com.cist.personageassess.model.QwReportStreet;
import com.cist.personageassess.model.Qw_Opertion_Log;
import com.cist.personageassess.model.Qw_assessment_attachment;
import com.cist.personageassess.model.Qw_individual_assessment;
import com.cist.personageassess.model.Qw_patrol_alarm_log;
import com.cist.personageassess.model.Qw_report;
import com.cist.personageassess.model.TBL_OFFE_EVDI;
import com.cist.personageassess.service.PersonageAssessService;
import com.cist.qwgl.jzgl.model.Qw_equip_info;
@Service
public class PersonageAssessServiceImpl implements PersonageAssessService {
	@Autowired
	private PersonageAssessMapper mapper;
	
	@Override
	public List<Qw_individual_assessment> querypersonageassessinfo(HashMap<String, Object> map) {
		return mapper.querypersonageassessinfo(map);
	}

	@Override
	public Object querypersonageassessinfopageList(HashMap<String, Object> map,PageInfo info) {
		return mapper.querypersonageassessinfo(map);
	}

	@Override
	public List<Qw_Opertion_Log> querylog(HashMap<String, Object> map) {
		return mapper.querylog(map);
	}

	@Override
	public List<TBL_OFFE_EVDI> queryfxinfo(HashMap<String, Object> map) {
		return mapper.queryfxinfo(map);
	}

	@Override
	public Object queryfxinfopageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.queryfxinfo(map);
	}

	@Override
	public List<Qw_assessment_attachment> queryfjinfo(HashMap<String, Object> map) {
		return mapper.queryfjinfo(map);
	}

	@Override
	public String querykhlm(HashMap<String, Object> map) {
		return mapper.querykhlm(map);
	}

	@Override
	public String querykhtl(HashMap<String, Object> map) {
		return mapper.querykhtl(map);
	}

	@Override
	public Qw_report queryqwbbinfo(HashMap<String, Object> map) {
		return mapper.queryqwbbinfo(map);
	}

	@Override
	public List<Qw_patrol_alarm_log> queryjmqwlog(HashMap<String, Object> map) {
		return mapper.queryjmqwlog(map);
	}

	@Override
	public Object queryjmqwlogpageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.queryjmqwlog(map);
	}

	@Override
	public QwReportStreet queryjmqwinfo(HashMap<String, Object> map) {
		return mapper.queryjmqwinfo(map);
	}

	@Override
	public Qw_equip_info queryequip(HashMap<String, Object> map) {
		return mapper.queryequip(map);
	}

	@Override
	public String queryjmqwbyqwbb(HashMap<String, Object> map) {
		return mapper.queryjmqwbyqwbb(map);
	}

}
