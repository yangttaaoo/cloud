package com.cist.earlywarning.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.earlywarning.model.DeptInfo;
import com.cist.earlywarning.model.WarningInfo;

public interface EarlyWarningMapper {
	
	List<WarningInfo> earlyinfopageList(HashMap<String,Object> map); 
	WarningInfo earlyone();
	List<DeptInfo> depart_infolist(Integer dept_superior);
	List<DeptInfo> userlist(Integer dept_superior);
	int addiss(HashMap<String,Object> map);
	int addUserIss(HashMap<String,Object> map);
	String getHpzlname(String hpzl);
	String getSsbmname(String ssbm);
}
