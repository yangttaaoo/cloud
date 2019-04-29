package com.cist.earlytrail.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.warningmonitor.model.MonitorInfo;

public interface EarlyTrailMapper {
	List<MonitorInfo> trailinfopageList(HashMap<String,Object> map); 
}
