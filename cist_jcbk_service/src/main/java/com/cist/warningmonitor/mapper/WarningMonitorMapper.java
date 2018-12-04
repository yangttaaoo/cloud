package com.cist.warningmonitor.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.earlywarning.model.DeptInfo;
import com.cist.warningmonitor.model.BackInfo;
import com.cist.warningmonitor.model.DeviceInfo;
import com.cist.warningmonitor.model.MonitorInfo;

public interface WarningMonitorMapper {
	List<DeptInfo> plateTypeList();
	List<MonitorInfo> monitorinfopageList(HashMap<String,Object> map); 
	DeviceInfo getRoadname(String yjsb);
	BackInfo backlist(HashMap<String,Object> map);
}
