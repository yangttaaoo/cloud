package com.cist.qwgl.qwjg.service.impl;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.qwgl.qwbb.model.Jcsj_police_res_person;
import com.cist.qwgl.qwbb.model.Qw_report;
import com.cist.qwgl.qwbb.model.Qwpbdata;
import com.cist.qwgl.qwbb.model.Sysfrmcode;
import com.cist.qwgl.qwbb.model.Syspoliceinfo;
import com.cist.qwgl.qwjg.mapper.QwjgMapper;
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
import com.cist.qwgl.qwjg.service.QwjgService;
@Service
public class QwjgSeviceImpl implements QwjgService{
	@Autowired
	private QwjgMapper mapper;

	@Override
	public List<Qw_report> selectQw_report(HashMap<String, Object> map){
		return mapper.selectQw_report(map);
	}

	@Override
	public List<Qwpbdata> selectQwpbdata(HashMap<String, Object> map) {
		return mapper.selectQwpbdata(map);
	}

	@Override
	public List<Qwpbdata> qwpbdataxunqu(HashMap<String, Object> map) {
		return mapper.qwpbdataxunqu(map);
	}

	@Override
	public List<Qw_patrol_alarm_log> yujingxinx(HashMap<String, Object> map) {
		return mapper.yujingxinx(map);
	}

	@Override
	public List<Jcsj_police_res_person> pageListSyspoliceinfo(HashMap<String, Object> map) {
		return mapper.pageListSyspoliceinfo(map);
	}

	@Override
	public List<Jcsj_police_resources> pageListJcsj_police_resources(HashMap<String, Object> map) {
		return mapper.pageListJcsj_police_resources(map);
	}

	@Override
	public List<Sysfrmcode> selectjichuxin(HashMap<String, Object> map) {
		return mapper.selectjichuxin(map);
	}

	@Override
	public List<Jcsj_police_resources> jcsjpoliceresources(HashMap<String, Object> map) {
		return mapper.jcsjpoliceresources(map);
	}

	@Override
	public List<Jcsj_police_resources> jingyuan(HashMap<String, Object> map) {
		return mapper.jingyuan(map);
	}

	@Override
	public List<Qw_report> qwreportjg(HashMap<String, Object> map) {
		return mapper.qwreportjg(map);
	}

	@Override
	public List<Qw_sign_in> qw_sign_in(HashMap<String, Object> map) {
		return mapper.qw_sign_in(map);
	}

	@Override
	public Integer qiangzi(HashMap<String, Object> map) {
		return mapper.qiangzi(map);
	}

	@Override
	public Integer qiangziqungwu(HashMap<String, Object> map) {
		return mapper.qiangziqungwu(map);
	}

	@Override
	public Qw_sign_in sign(HashMap<String, Object> map) {
		return mapper.sign(map);
	}

	@Override
	public Qw_patrol_alarm_log qw_patrol_alarm_log(HashMap<String, Object> map) {
		return mapper.qw_patrol_alarm_log(map);
	}

	@Override
	public List<Qw_patrol_alarm_log> alarmlogList(HashMap<String, Object> map) {
		return mapper.alarmlogList(map);
	}

	@Override
	public String eventid(HashMap<String, Object> map) {
		return mapper.eventid(map);
	}

	@Override
	public EventInfo eventlist(HashMap<String, Object> map) {
		return mapper.eventlist(map);
	}

	@Override
	public List<Sysfrmcode> sysfrmcode(HashMap<String, Object> map) {
		return mapper.sysfrmcode(map);
	}

	@Override
	public List<Qw_gps_history> qw_gps_history(HashMap<String, Object> map) {
		return mapper.qw_gps_history(map);
	}

	@Override
	public Qwpbdata eventinfobumen(HashMap<String, Object> map) {
		return mapper.eventinfobumen(map);
	}

	@Override
	public List<Qw_patrol_alarm_log> qwpatrolalarmyujing(HashMap<String, Object> map) {
		return mapper.qwpatrolalarmyujing(map);
	}

	@Override
	public Integer jczzxl(HashMap<String, Object> map) {
		return mapper.jczzxl(map);
	}

	@Override
	public Qw_individual_assessment qwindividualassessment(HashMap<String, Object> map) {
		return mapper.qwindividualassessment(map);
	}

	@Override
	public Integer addattachment(HashMap<String, Object> map) {
		return mapper.addattachment(map);
	}

	@Override
	public List<Qw_assessment_attachment> getAttachment(HashMap<String, Object> map) {
		return mapper.getAttachment(map);
	}

	@Override
	public Integer deleteAttachment(HashMap<String, Object> map) {
		return mapper.deleteAttachment(map);
	}

	@Override
	public Integer updateassessment(HashMap<String, Object> map) {
		return mapper.updateassessment(map);
	}

	@Override
	public List<GpsRecord> gpsrecord(HashMap<String, Object> map) {
		return mapper.gpsrecord(map);
	}

	@Override
	public Integer gpsrecordlixian(HashMap<String, Object> map) {
		return mapper.gpsrecordlixian(map);
	}

	@Override
	public List<DeviceInfo> deviceList(HashMap<String, Object> map) {
		return mapper.deviceList(map);
	}

	@Override
	public Integer delyichang(HashMap<String, Object> map) {
		return mapper.delyichang(map);
	}

	@Override
	public Integer delkaohe(HashMap<String, Object> map) {
		return mapper.delkaohe(map);
	}

	@Override
	public List<Qw_gps_history> qwgpshistoryywbh(HashMap<String, Object> map) {
		return mapper.qwgpshistoryywbh(map);
	}

	@Override
	public List<Jcsj_police_resources> jcsj_police_resources(HashMap<String, Object> map) {
		return mapper.jcsj_police_resources(map);
	}

	@Override
	public List<Jcsj_police_res_person> jcsjpolicerespersoninfo(HashMap<String, Object> map) {
		return mapper.jcsjpolicerespersoninfo(map);
	}

	@Override
	public List<Onduty> onduty(HashMap<String, Object> map) {
		return mapper.onduty(map);
	}

	@Override
	public List<Onduty> ondutyche(HashMap<String, Object> map) {
		return mapper.ondutyche(map);
	}

	@Override
	public List<Onduty> ondutydiaodu(HashMap<String, Object> map) {
		return mapper.ondutydiaodu(map);
	}

	@Override
	public List<Onduty> ondutyjcbk(HashMap<String, Object> map) {
		return mapper.ondutyjcbk(map);
	}

	@Override
	public Qw_report kaoheselectQwreport(HashMap<String, Object> map) {
		return mapper.kaoheselectQwreport(map);
	}




}