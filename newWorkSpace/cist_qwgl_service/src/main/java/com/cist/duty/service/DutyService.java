package com.cist.duty.service;

import java.util.HashMap;
import java.util.List;

import com.cist.duty.model.DutyInfo;
import com.cist.duty.model.EchartsInfo;
import com.cist.duty.model.Rule_info;
import com.cist.duty.model.TlInfo;
import com.cist.frame.page.PageInfo;
import com.cist.duty.model.DeptInfo;


public interface DutyService {
	
	List<Rule_info> rulelist(HashMap<String,Object> modelMap);
	Object dutyInfopageList(HashMap<String,Object> map,PageInfo pinfo); 
	List<DutyInfo> dutyInfo(HashMap<String,Object> map); 
	List<Rule_info> infolist();
	List<TlInfo> tllist(HashMap<String,Object> modelMap);
	List<DeptInfo> depart_infolist(Integer dept_superior);
	DutyInfo getSypideptname(Integer sypi_pk);
	EchartsInfo hgecharts(HashMap<String,Object> modelMap);
	List<EchartsInfo> tlecharts(HashMap<String,Object> modelMap);
	List<EchartsInfo> lmecharts(HashMap<String,Object> modelMap);
}
