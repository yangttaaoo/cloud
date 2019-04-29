package com.cist.home.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.home.mapper.HomeMapper;
import com.cist.home.model.DeviceInfo;
import com.cist.home.model.EventFlowInfo;
import com.cist.home.model.EventInfo;
import com.cist.home.model.GpsRecord;
import com.cist.home.model.Jcsj_police_res_person;
import com.cist.home.model.Jcsj_police_resources;
import com.cist.home.model.PoliceInfo;
import com.cist.home.model.Qw_gps_history;
import com.cist.home.model.Sysfrmcode;
import com.cist.home.model.Tbl_car_reco;
import com.cist.home.model.Zhdd_event_acceptance;
import com.cist.home.model.Zhdd_event_attachment;
import com.cist.home.model.Zhdd_event_personnel;
import com.cist.home.model.Zhdd_event_result;
import com.cist.home.model.Zhdd_sms_template;
import com.cist.home.model.Zhdd_work_flow;
import com.cist.home.service.HomeService;

@Service("HomeService")
public class HomeServiceImpl implements HomeService{

	@Autowired
	private HomeMapper mapper;
	
	@Override
	public List<DeviceInfo> DeviceList() {
		return mapper.DeviceList();
	}

	@Override
	public List<EventInfo> EventList(HashMap<String, Object> map) {
		return mapper.EventList(map);
	}

	@Override
	public Jcsj_police_res_person PoliceList(HashMap<String, Object> map) {
		return mapper.PoliceList(map);
	}

	@Override
	public List<EventInfo> EventPoliceList(HashMap<String, Object> map) {
		return  mapper.EventPoliceList(map);
	}

	@Override
	public EventInfo EventFlowList(HashMap<String, Object> map) {
		return mapper.EventFlowList(map);
	}

	@Override
	public List<EventFlowInfo> EventResultList(HashMap<String, Object> map) {
		return mapper.EventResultList(map);
	}

	@Override
	public List<GpsRecord> gpsRecordList(HashMap<String, Object> map) {
		return mapper.gpsRecordList(map);
	}

	@Override
	public Integer addzhddeventacceptance(HashMap<String, Object> map) {
		return mapper.addzhddeventacceptance(map);
		
	}

	@Override
	public Integer updatezhddeventinformation(HashMap<String, Object> map) {
		return mapper.updatezhddeventinformation(map);
	}

	@Override
	public List<Jcsj_police_res_person> jcsj_police_res_personpageliist(HashMap<String, Object> map) {
		return mapper.jcsj_police_res_personpageliist(map);
	}

	@Override
	public List<Zhdd_work_flow> zhdd_work_flow(HashMap<String, Object> map) {
		return mapper.zhdd_work_flow(map);
	}

	@Override
	public List<Zhdd_sms_template> zhdd_sms_template(HashMap<String, Object> map) {
		return mapper.zhdd_sms_template(map);
	}

	@Override
	public Integer addzhddeventdispatch(HashMap<String, Object> map) {
		return mapper.addzhddeventdispatch(map);
	}

	@Override
	public Integer addzhdd_event_personnel(List<Zhdd_event_personnel> policList) {
		return mapper.addzhdd_event_personnel(policList);
	}

	@Override
	public Integer updatezhddeventinf(HashMap<String, Object> map) {
		return mapper.updatezhddeventinf(map);
	}

	@Override
	public Zhdd_event_acceptance shhoulixishij(HashMap<String, Object> map) {
		return mapper.shhoulixishij(map);
	}

	@Override
	public List<Zhdd_event_acceptance> shhoulixi(HashMap<String, Object> map) {
		return mapper. shhoulixi(map);
	}

	@Override
	public Zhdd_event_result eventresult(HashMap<String, Object> map) {
		return mapper.eventresult(map);
	}

	@Override
	public Jcsj_police_resources jcsjpolice_resperson(HashMap<String, Object> map) {
		return mapper.jcsjpolice_resperson(map);
	}

	@Override
	public Jcsj_police_res_person Jcsjpoliceresperson(HashMap<String, Object> map) {
		return mapper.Jcsjpoliceresperson(map);
	}

	@Override
	public Tbl_car_reco tbl_car_reco(HashMap<String, Object> map) {
		return mapper.tbl_car_reco(map);
	}

	@Override
	public List<EventFlowInfo> eventflowinfolist(HashMap<String, Object> map) {
		return mapper.eventflowinfolist(map);
	}

	@Override
	public Integer updatejwd(HashMap<String, Object> map) {
		return mapper.updatejwd(map);
	}

	@Override
	public List<EventInfo> EventListchu(HashMap<String, Object> map) {
		return mapper.EventListchu(map);
	}

	@Override
	public List<EventInfo> EventListchuu(HashMap<String, Object> map) {
		return mapper.EventListchuu(map);
	}

	@Override
	public List<EventInfo> EventListquan(HashMap<String, Object> map) {
		return mapper.EventListquan(map);
	}

	@Override
	public List<String> zzclsjjy(HashMap<String, Object> map) {
		return mapper.zzclsjjy(map);
	}

	@Override
	public Integer shijianid(HashMap<String, Object> map) {
		return mapper.shijianid(map);
	}

	@Override
	public EventInfo eventinfojy(HashMap<String, Object> map) {
		return mapper.eventinfojy(map);
	}

	@Override
	public EventFlowInfo eventflowinfov(HashMap<String, Object> map) {
		return mapper.eventflowinfov(map);
	}

	@Override
	public Zhdd_event_result zhdd_event_resultjieguo(HashMap<String, Object> map) {
		return mapper.zhdd_event_resultjieguo(map);
	}

	@Override
	public List<Integer> xiafashijian(HashMap<String, Object> map) {
		return mapper.xiafashijian(map);
	}

	@Override
	public List<Integer> shangjibumenpk(HashMap<String, Object> map) {
		return mapper.shangjibumenpk(map);
	}

	@Override
	public EventInfo acceptance(HashMap<String, Object> map) {
		return mapper.acceptance(map);
	}

	@Override
	public List<Sysfrmcode>  sysfrmcode(HashMap<String, Object> map) {
		return mapper.sysfrmcode(map);
	}

	@Override
	public Integer addEventFlowInfo(EventFlowInfo e) {
		return mapper.addEventFlowInfo(e);
	}

	@Override
	public Integer updateEventFlowInfo(EventFlowInfo e) {
		return mapper.updateEventFlowInfo(e);
	}

	@Override
	public Integer addattachment(Zhdd_event_attachment e) {
		return mapper.addattachment(e);
	}

	@Override
	public List<Zhdd_event_attachment> selectattachment(HashMap<String, Object> map) {
		return mapper.selectattachment(map);
	}

	@Override
	public Zhdd_event_attachment selectyinpin(HashMap<String, Object> map) {
		return mapper.selectyinpin(map);
	}

	@Override
	public int delattachment(HashMap<String, Object> map) {
		return mapper.delattachment(map);
	}

	@Override
	public Integer updatezhddeventresult(Zhdd_event_result e) {
		return mapper.updatezhddeventresult(e);
	}

	@Override
	public Integer addzhddeventresult(Zhdd_event_result e) {
		return mapper.addzhddeventresult(e);
	}

	@Override
	public Integer updateinformation(HashMap<String, Object> map) {
		return mapper.updateinformation(map);
	}

	@Override
	public List<Qw_gps_history> selectGpsHistory(HashMap<String, Object> map) {
		return mapper.selectGpsHistory(map);
	}
	

}
