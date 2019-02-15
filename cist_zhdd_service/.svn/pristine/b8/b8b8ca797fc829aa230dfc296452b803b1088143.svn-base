package com.cist.smsmodule.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.smsmodule.mapper.SmsMapper;
import com.cist.smsmodule.modle.DeptInfo;
import com.cist.smsmodule.modle.Sys_frm_code;
import com.cist.smsmodule.service.SmsService;
@Service
public class SmsServiceImpl implements SmsService {
@Autowired
private SmsMapper mapper;
	@Override
	public Object selectDatapageList(HashMap<String, Object> map, PageInfo page) {
		return mapper.selectData(map);
	}

	@Override
	public Integer addData(HashMap<String, Object> map) {
		return mapper.addData(map);
	}

	@Override
	public Integer updateData(HashMap<String, Object> map) {
		return mapper.updateData(map);
	}

	@Override
	public Integer deleteDate(HashMap<String, Object> map) {
		return mapper.deleteDate(map);
	}

	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Override
	public List<Sys_frm_code> selectKxx(HashMap<String, Object> map) {
		return mapper.selectKxx(map);
	}

	@Override
	public String queryDeptnameBydeptpk(HashMap<String, Object> map) {
		return mapper.queryDeptnameBydeptpk(map);
	}

	@Override
	public String querypepolenamebycode(HashMap<String, Object> map) {
		return mapper.querypepolenamebycode(map);
	}

	@Override
	public Integer batchdel(HashMap<String, Object> map) {
		return mapper.batchdel(map);
	}

}
