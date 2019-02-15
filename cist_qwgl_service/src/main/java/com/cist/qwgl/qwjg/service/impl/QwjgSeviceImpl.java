package com.cist.qwgl.qwjg.service.impl;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.qwgl.qwbb.model.Jcsj_police_res_person;
import com.cist.qwgl.qwbb.model.Qw_report;
import com.cist.qwgl.qwbb.model.Qw_sign_in;
import com.cist.qwgl.qwbb.model.Qwpbdata;
import com.cist.qwgl.qwbb.model.Sysfrmcode;
import com.cist.qwgl.qwbb.model.Syspoliceinfo;
import com.cist.qwgl.qwjg.mapper.QwjgMapper;
import com.cist.qwgl.qwjg.model.Jcsj_police_resources;
import com.cist.qwgl.qwjg.model.Qw_patrol_alarm_log;
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




}
