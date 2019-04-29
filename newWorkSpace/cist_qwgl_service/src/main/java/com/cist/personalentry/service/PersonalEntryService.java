package com.cist.personalentry.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cist.frame.page.PageInfo;
import com.cist.personalentry.model.AppraiseInfo;
import com.cist.personalentry.model.DeptInfo;
import com.cist.personalentry.model.IndividualInfo;
import com.cist.personalentry.model.PoliceInfo;
import com.cist.personalentry.model.RegulationsInfo;
import com.cist.personalentry.model.ReportInfo;
import com.cist.qwgl.qwbb.model.Jcsj_police_res_person;


public interface PersonalEntryService {
	 List<DeptInfo> depart_infolist(Integer dept_superior);
	 List<PoliceInfo> police_infolist(Integer dept_superior);
	 List<PoliceInfo> Police(String dept_pk);
	 Object findDatapageList(Map map,PageInfo page);
	 List<AppraiseInfo> AppraiseList();
	 List<RegulationsInfo> RegulationsList(HashMap<String, Object> map);
	 Object IndivInfopageList(HashMap<String,Object> map,PageInfo pinfo); 
	 List<IndividualInfo> getAttachment(int pk);
	 int shtsList(HashMap<String,Object> map);
	 Object khtsList(HashMap<String,Object> map);
	 String UserList(String user);
	 int addpersonaloffice(HashMap<String,Object> map);
	 int addpersonalreport(HashMap<String,Object> map);
	 int addattachment(HashMap<String,Object> map);
	 int editpersonaloffice(HashMap<String,Object> map);
	 int editpersonalreport(HashMap<String,Object> map);
	 int deleteAttachment(HashMap<String,Object> map);
	 int addLog(HashMap<String,Object> map);
	 int deletepersonalentry(HashMap<String,Object> map);
	 Object reportpageList(HashMap<String,Object> map,PageInfo pinfo); 
	 ReportInfo getAreaname(int pk);
}