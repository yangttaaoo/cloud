package com.cist.inspectionplan.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.inspectionplan.model.DeviceInfo;
import com.cist.inspectionplan.model.InspectionInfo;
import com.cist.inspectionplan.model.MaintenanceInfo;
import com.cist.inspectionplan.model.RoadInfo;
import com.cist.inspectionplan.model.UserInfo;

public interface InspectionPlanMapper {
	List<InspectionInfo> inslistpageList(HashMap<String,Object> map); 
	List<MaintenanceInfo> maintservice();
	List<RoadInfo> roadservice();
	List<DeviceInfo> devicelistpageList(HashMap<String,Object> map); 
	int insadd(HashMap<String,Object> map);
	int gsadd(HashMap<String,Object> map);
	int sbadd(HashMap<String,Object> map);
	List<MaintenanceInfo> quemaint(int pk_id);
	List<DeviceInfo> quedev(int pk_id);
	UserInfo queuser(int pk);
	int insedit(HashMap<String,Object> map);
	int delgs(HashMap<String,Object> map);
	int delsb(HashMap<String,Object> map);
	int delIns(HashMap<String,Object> map);
	int delInsmax(HashMap<String,Object> modelMap);
	int delgsmax(HashMap<String,Object> modelMap);
	int delsbmax(HashMap<String,Object> modelMap);
}
