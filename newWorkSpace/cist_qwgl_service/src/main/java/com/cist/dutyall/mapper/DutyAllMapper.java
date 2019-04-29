package com.cist.dutyall.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.duty.model.EchartsInfo;
import com.cist.dutyall.model.DutyAllInfo;
import com.cist.dutyall.model.TlInfo;

public interface DutyAllMapper {
	List<DutyAllInfo> dutyAllInfopageList(HashMap<String,Object> map);
	List<DutyAllInfo> dutyAllInfo(HashMap<String,Object> map);
	EchartsInfo hgecharts(HashMap<String,Object> modelMap);
	List<TlInfo> tllist(Integer sypi_pk);
	List<TlInfo> tlcx();
}
