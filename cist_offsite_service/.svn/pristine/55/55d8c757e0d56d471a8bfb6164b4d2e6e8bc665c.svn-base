package com.cist.redlist.service;

import java.util.HashMap;
import java.util.List;

import com.cist.offsite.invalidtrial.model.SysDepartInfo;
import com.cist.redlist.model.CarColorInfo;
import com.cist.redlist.model.CarTypeInfo;
import com.cist.redlist.model.DeptInfo;
import com.cist.frame.page.PageInfo;
import com.cist.redlist.model.RedListInfo;


public interface RedListService {
	 List<RedListInfo> plateTypeList();
	 List<RedListInfo> plateColorList();
	 List<RedListInfo> carTypeList();
	 List<RedListInfo> plateKerisList();
	 CarTypeInfo selectByCllx(HashMap<String,Object> map);
	 SysDepartInfo selectBySsdw(HashMap<String,Object> map);
	 CarColorInfo selectByCsys(HashMap<String,Object> map);
	 List<RedListInfo> carColorList();
	 List<RedListInfo> carLogoList();
	 Object redInfopageList(HashMap<String,Object> map,PageInfo pinfo); 
	 List<DeptInfo> depart_infolist(Integer dept_superior);
	 int addRedInfo(HashMap<String,Object> map);
	 int delRedInfo(HashMap<String,Object> map);
	 RedListInfo OneRedInfo(HashMap<String,Object> map);
	 int editRedInfo(HashMap<String,Object> map);
}
