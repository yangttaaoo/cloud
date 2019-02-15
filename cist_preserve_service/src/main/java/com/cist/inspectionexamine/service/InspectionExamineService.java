package com.cist.inspectionexamine.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.inspectionexamine.model.Device;
import com.cist.inspectionexamine.model.Maintenance;
import com.cist.inspectionplan.model.MaintenanceInfo;

public interface InspectionExamineService {
	Object insexapageList(HashMap<String,Object> map,PageInfo pinfo); 
	List<Maintenance> quemaint(HashMap<String,Object> map);
	List<Device> querydev(HashMap<String,Object> map);
	int insexa(HashMap<String,Object> map);
}
