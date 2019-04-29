package com.cist.earlywarning.service;

import java.util.HashMap;
import java.util.List;

import com.cist.earlywarning.model.WarningInfo;
import com.cist.frame.page.PageInfo;
import com.cist.earlywarning.model.DeptInfo;

public interface EarlyWarningService {
	Object earlyinfopageList(HashMap<String,Object> map,PageInfo pinfo); 
	WarningInfo earlyone();
	List<DeptInfo> depart_infolist(Integer dept_superior);
	List<DeptInfo> userlist(Integer dept_superior);
	int addiss(HashMap<String,Object> map);
	int addUserIss(HashMap<String,Object> map);
	String getHpzlname(String hpzl);
	String getSsbmname(String ssbm);
}
