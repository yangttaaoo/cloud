package com.cist.kreis.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.kreis.model.KreisInfo;
import com.cist.kreis.model.KreisLevelInfo;
import com.cist.kreis.model.TbekInfo;
public interface KreisMapper {
	
	List<KreisInfo> kerisInfopageList(HashMap<String,Object> map);
	KreisInfo getTbekname(Integer tbek_parent);
	int delKreis(HashMap<String,Object> map);
	List<KreisLevelInfo> kreisLevelList();
	int addKreis(HashMap<String,Object> map);
	int editKreis(HashMap<String,Object> map);
	List<TbekInfo> tbek_infolist(Integer dept_superior);
}
