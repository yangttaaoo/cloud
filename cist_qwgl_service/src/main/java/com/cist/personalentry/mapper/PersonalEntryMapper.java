package com.cist.personalentry.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cist.personalentry.model.AppraiseInfo;
import com.cist.personalentry.model.DeptInfo;
import com.cist.personalentry.model.IndividualInfo;
import com.cist.personalentry.model.Oeuser;
import com.cist.personalentry.model.PoliceInfo;
import com.cist.personalentry.model.RegulationsInfo;
import com.cist.personalentry.model.ReportInfo;



public interface PersonalEntryMapper {
	 List<DeptInfo> depart_infolist(Integer dept_superior);
	 List<PoliceInfo> police_infolist(Integer dept_superior);
	 List<PoliceInfo> Police(Integer dept_pk);
	 List<Oeuser> findDatapageList(Map map);
	 List<AppraiseInfo> AppraiseList();
	 List<RegulationsInfo> RegulationsList(HashMap<String, Object> map);
	 List<IndividualInfo> IndivInfopageList(HashMap<String,Object> map); 
	 List<IndividualInfo> getAttachment(int pk);
	 int shtsList(HashMap<String,Object> map);
	 int khtsList(HashMap<String,Object> map);
	 String UserList(String user);
	 int addpersonaloffice(HashMap<String,Object> map);
	 int addattachment(HashMap<String,Object> map);
	 int editpersonaloffice(HashMap<String,Object> map);
	 int editpersonalreport(HashMap<String,Object> map);
	 int deleteAttachment(HashMap<String,Object> map);
	 int addLog(HashMap<String,Object> map);
	 int deletepersonalentry(HashMap<String,Object> map);
	 List<ReportInfo> reportpageList(HashMap<String,Object> map); 
	 ReportInfo getAreaname(int pk);
	 int addpersonalreport(HashMap<String,Object> map);
}
