package com.cist.duty.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.duty.model.DutyInfo;
import com.cist.duty.model.EchartsInfo;
import com.cist.duty.model.Rule_info;
import com.cist.duty.model.DeptInfo;
import com.cist.duty.model.TlInfo;


public interface DutyMapper {
	
	List<Rule_info> rulelist(HashMap<String,Object> modelMap);
	List<DutyInfo> dutyInfopageList(HashMap<String,Object> map);
	List<DutyInfo> dutyInfo(HashMap<String,Object> map);
	List<Rule_info> infolist();
	List<DeptInfo> depart_infolist(Integer dept_superior);
	DutyInfo getSypideptname(Integer sypi_pk);
	List<TlInfo> tllist(HashMap<String,Object> modelMap);
	EchartsInfo hgecharts(HashMap<String,Object> modelMap);
	List<EchartsInfo> tlecharts(HashMap<String,Object> modelMap);
	List<EchartsInfo> lmecharts(HashMap<String,Object> modelMap);
}
