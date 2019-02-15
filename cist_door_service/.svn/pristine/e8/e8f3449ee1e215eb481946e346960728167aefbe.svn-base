package com.cist.kreis.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.kreis.model.KreisInfo;
import com.cist.kreis.model.KreisLevelInfo;
import com.cist.kreis.model.TbekInfo;




public interface KreisService {
	Object kerisInfopageList(HashMap<String,Object> map,PageInfo pinfo); 
	KreisInfo getTbekname(Integer tbek_parent);
	int delKreis(HashMap<String,Object> modelMap);
	List<KreisLevelInfo> kreisLevelList();
	int addKreis(HashMap<String,Object> map);
	int editKreis(HashMap<String,Object> map);
	List<TbekInfo> tbek_infolist(Integer dept_superior);
}
