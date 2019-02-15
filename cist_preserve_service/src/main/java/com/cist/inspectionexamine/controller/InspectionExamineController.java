package com.cist.inspectionexamine.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.inspectionexamine.model.Device;
import com.cist.inspectionexamine.model.Maintenance;
import com.cist.inspectionexamine.service.InspectionExamineService;
import com.cist.inspectionplan.model.DeviceInfo;
import com.cist.inspectionplan.model.InspectionInfo;
import com.cist.inspectionplan.model.MaintenanceInfo;
import com.cist.inspectionplan.model.UserInfo;
import com.cist.inspectionplan.service.InspectionPlanService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/inspectionexamine")
public class InspectionExamineController {
	@Autowired
	private InspectionPlanService iservice;
	@Autowired
	private InspectionExamineService service;
	
	/**
	 * 巡检计划审核首页，巡检计划信息查询
	 * @param map
	 */
	@RequestMapping("insexalist")
    public PageInfo<InspectionInfo> insexalist(@RequestBody HashMap<String,Object> modelMap ){
    	PageInfo pinfo = new PageInfo();
	    pinfo.setPageNum(Integer.parseInt(modelMap.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(modelMap.get("pageSize").toString()));
    	PageInfo<InspectionInfo> list= (PageInfo<InspectionInfo>)service.insexapageList(modelMap,pinfo);
    	for(int i=0;i<list.getList().size();i++){
    		list.getList().get(i).setStart_time_end(list.getList().get(i).getStart_time().substring(0, 10)+"~"+list.getList().get(i).getEnd_time().substring(0, 10));
    	}
    	return list;
	}
	/**
	 * 巡检计划审核，审核页面维护公司列表查询
	 */
	@RequestMapping("querygs")
	public  List<Maintenance>  quemaint(@RequestBody HashMap<String,Object> modelMap){
		List<Maintenance> list = service.quemaint(modelMap);
		return list;
	}
	/**
	 * 巡检计划审核，审核页面维护公司列表查询
	 */
	@RequestMapping("querydev")
	public  List<Device>  querydev(@RequestBody HashMap<String,Object> modelMap){
		List<Device> list = service.querydev(modelMap);
		return list;
	}
	/**
	 * 巡检计划审核
	 */
	@RequestMapping("insexa")
	public int  insexa(@RequestBody HashMap<String,Object> map){	
		map.put("shr",3861);
		int c = service.insexa(map);
		return c;
	}
}
