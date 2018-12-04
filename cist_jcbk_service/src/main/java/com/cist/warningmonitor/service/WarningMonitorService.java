package com.cist.warningmonitor.service;

import java.util.HashMap;
import java.util.List;

import com.cist.earlywarning.model.DeptInfo;
import com.cist.frame.page.PageInfo;
import com.cist.warningmonitor.model.BackInfo;
import com.cist.warningmonitor.model.DeviceInfo;
import com.cist.warningmonitor.model.MonitorInfo;

public interface WarningMonitorService{
	List<DeptInfo> plateTypeList();
	Object monitorinfopageList(HashMap<String,Object> map,PageInfo pinfo); 
	DeviceInfo getRoadname(String yjsb);
	BackInfo backlist(HashMap<String,Object> map);
}
