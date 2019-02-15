package com.cist.inspectionexamine.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.inspectionexamine.model.Device;
import com.cist.inspectionexamine.model.Maintenance;
import com.cist.inspectionplan.model.InspectionInfo;
import com.cist.inspectionplan.model.MaintenanceInfo;

public interface InspectionExamineMapper {
	
	List<InspectionInfo> insexapageList(HashMap<String,Object> map); 
	List<Maintenance> quemaint(HashMap<String,Object> map);
	List<Device> querydev(HashMap<String,Object> map);
	int insexa(HashMap<String,Object> map);
}
