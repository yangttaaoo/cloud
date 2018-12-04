package com.cist.redlist.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.offsite.invalidtrial.model.SysDepartInfo;
import com.cist.redlist.model.CarColorInfo;
import com.cist.redlist.model.CarTypeInfo;
import com.cist.redlist.model.DeptInfo;
import com.cist.redlist.model.RedListInfo;

public interface RedListMapper {
	 List<RedListInfo> plateTypeList();
	 List<RedListInfo> carTypeList();
	 List<RedListInfo> carColorList();
	 List<RedListInfo> carLogoList();
	 List<RedListInfo> plateColorList();
	 List<RedListInfo> plateKerisList();
	 List<RedListInfo> redInfopageList(HashMap<String,Object> map); 
	 List<DeptInfo> depart_infolist(Integer dept_superior);
	 int addRedInfo(HashMap<String,Object> map);
	 CarTypeInfo selectByCllx(HashMap<String,Object> map);
	 CarColorInfo selectByCsys(HashMap<String,Object> map);
	 SysDepartInfo selectBySsdw(HashMap<String,Object> map);
	 int delRedInfo(HashMap<String,Object> map);
	 RedListInfo OneRedInfo(HashMap<String,Object> map);
	 int editRedInfo(HashMap<String,Object> map);
}
