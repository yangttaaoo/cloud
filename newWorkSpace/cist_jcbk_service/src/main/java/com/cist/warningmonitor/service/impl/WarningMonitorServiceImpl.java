package com.cist.warningmonitor.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.earlywarning.model.DeptInfo;
import com.cist.frame.page.PageInfo;
import com.cist.warningmonitor.mapper.WarningMonitorMapper;
import com.cist.warningmonitor.model.BackInfo;
import com.cist.warningmonitor.model.DeviceInfo;
import com.cist.warningmonitor.model.MonitorInfo;
import com.cist.warningmonitor.service.WarningMonitorService;

@Service("WarningMonitorService")
public class WarningMonitorServiceImpl implements WarningMonitorService{
	@Autowired
	private WarningMonitorMapper mapper;
	
	@Override
	public List<DeptInfo> plateTypeList() {
		return mapper.plateTypeList();
	}

	@Override
	public Object monitorinfopageList(HashMap<String, Object> map,
			PageInfo pinfo) {
		return mapper.monitorinfopageList(map);
	}

	@Override
	public DeviceInfo getRoadname(String yjsb) {
		return mapper.getRoadname(yjsb);
	}

	@Override
	public BackInfo backlist(HashMap<String, Object> map) {
		return mapper.backlist(map);
	}

}
