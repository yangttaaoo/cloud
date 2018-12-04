package com.cist.deptduty.service;

import java.util.HashMap;
import java.util.List;

import com.cist.duty.model.DutyInfo;
import com.cist.duty.model.EchartsInfo;
import com.cist.duty.model.Rule_info;
import com.cist.duty.model.TlInfo;
import com.cist.frame.page.PageInfo;

public interface DeptDutyService {
	Object deptdutyInfopageList(HashMap<String,Object> map,PageInfo pinfo); 
	List<Rule_info> infolist();
	List<Rule_info> rulelist(HashMap<String,Object> modelMap);
	List<TlInfo> tllist(HashMap<String,Object> modelMap);
	List<DutyInfo> deptdutyInfo(HashMap<String,Object> map);
	EchartsInfo hgecharts(HashMap<String,Object> modelMap);
	List<EchartsInfo> tlecharts(HashMap<String,Object> modelMap);
}
