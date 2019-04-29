package com.cist.personalentry.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.personalentry.mapper.PersonalEntryMapper;
import com.cist.personalentry.model.AppraiseInfo;
import com.cist.personalentry.model.DeptInfo;
import com.cist.personalentry.model.IndividualInfo;
import com.cist.personalentry.model.PoliceInfo;
import com.cist.personalentry.model.RegulationsInfo;
import com.cist.personalentry.model.ReportInfo;
import com.cist.personalentry.service.PersonalEntryService;
import com.cist.qwgl.qwbb.model.Jcsj_police_res_person;


@Service("PersonalEntryService")
public class PersonalEntryServiceImpl implements PersonalEntryService{
	@Autowired
	private PersonalEntryMapper mapper;
	
	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}
	@Override
	public List<PoliceInfo> police_infolist(Integer dept_superior) {
		
		return mapper.police_infolist(dept_superior);
	}
	@Override
	public List<PoliceInfo> Police(String dept_pk) {
		return mapper.Police(dept_pk);
	}
	@Override
	public Object findDatapageList(Map map,PageInfo page) {
		return mapper.findDatapageList(map);
	}
	@Override
	public List<AppraiseInfo> AppraiseList() {
		// TODO Auto-generated method stub
		return mapper.AppraiseList();
	}
	@Override
	public List<RegulationsInfo> RegulationsList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.RegulationsList(map);
	}
	@Override
	public Object IndivInfopageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.IndivInfopageList(map);
	}
	@Override
	public List<IndividualInfo> getAttachment(int pk) {
		// TODO Auto-generated method stub
		return mapper.getAttachment(pk);
	}
	@Override
	public int shtsList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.shtsList(map);
	}
	@Override
	public Object khtsList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.khtsList(map);
	}
	@Override
	public String UserList(String user) {
		// TODO Auto-generated method stub
		return mapper.UserList(user);
	}
	@Override
	public int addpersonaloffice(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.addpersonaloffice(map);
	}
	@Override
	public int addattachment(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.addattachment(map);
	}
	@Override
	public int editpersonaloffice(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.editpersonaloffice(map);
	}
	@Override
	public int deleteAttachment(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.deleteAttachment(map);
	}
	@Override
	public int addLog(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.addLog(map);
	}
	@Override
	public int deletepersonalentry(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.deletepersonalentry(map);
	}
	@Override
	public Object reportpageList(HashMap<String, Object> map, PageInfo pinfo) {
		// TODO Auto-generated method stub
		return mapper.reportpageList(map);
	}
	@Override
	public ReportInfo getAreaname(int pk) {
		// TODO Auto-generated method stub
		return mapper.getAreaname(pk);
	}
	@Override
	public int addpersonalreport(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.addpersonalreport(map);
	}
	@Override
	public int editpersonalreport(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.editpersonalreport(map);
	}
}
