package com.cist.earlymanagement.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.earlywarning.model.WarningInfo;

public interface EarlyManagementMapper {
	List<WarningInfo> earlyminfopageList(HashMap<String,Object> map); 
}
