package com.cist.inspectionplan.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.inspectionplan.model.DeviceInfo;
import com.cist.inspectionplan.model.InspectionInfo;
import com.cist.inspectionplan.model.MaintenanceInfo;
import com.cist.inspectionplan.model.RoadInfo;
import com.cist.inspectionplan.model.UserInfo;
import com.cist.inspectionplan.service.InspectionPlanService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/inspectionplan")
public class InspectionPlanController {
	
	@Autowired
	private InspectionPlanService service;
	/**
	 * 巡检计划制定首页，巡检计划信息查询
	 * @param map
	 */
	@RequestMapping("inslist")
    public PageInfo<InspectionInfo> inslistpageList(@RequestBody HashMap<String,Object> modelMap ){
    	PageInfo pinfo = new PageInfo();
	    pinfo.setPageNum(Integer.parseInt(modelMap.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(modelMap.get("pageSize").toString()));
    	PageInfo<InspectionInfo> list= (PageInfo<InspectionInfo>)service.inslistpageList(modelMap,pinfo);
    	for(int i=0;i<list.getList().size();i++){
    		list.getList().get(i).setStart_time_end(list.getList().get(i).getStart_time().substring(0, 10)+"~"+list.getList().get(i).getEnd_time().substring(0, 10));
    		UserInfo user = service.queuser(list.getList().get(i).getFk_planners_id());
    		list.getList().get(i).setPlanners_name(user.getName());
    		List<MaintenanceInfo> mlist = service.quemaint(list.getList().get(i).getPk_id());
    		List<DeviceInfo> dlist = service.quedev(list.getList().get(i).getPk_id());
    		int [] a = new int[mlist.size()];
    		String [] b = new String[dlist.size()];
    		for(int j=0;j<mlist.size();j++){
    			a[j] = Integer.parseInt(mlist.get(j).getTitle());
    		}
    		for(int c=0;c<dlist.size();c++){
    			b[c] = dlist.get(c).getDevice_num();
    		}
    		list.getList().get(i).setGs_zu(a);
    		list.getList().get(i).setSb_zu(b);
    	}
    	return list;
	}
	/**
	 * 运维公司查询
	 * @param map
	 */
	@RequestMapping("querygs")
	public  List<MaintenanceInfo>  maintservice(){
		List<MaintenanceInfo> list = service.maintservice();
		return list;
	}
	/**
	 * 运维公司查询(修改)
	 * @param map
	 */
	@RequestMapping("queryeditgs")
	public  List<MaintenanceInfo>  queryeditgs(@RequestBody HashMap<String,Object> map){
		List<MaintenanceInfo> list = service.maintservice();
		List<MaintenanceInfo> mlist = service.quemaint((int)map.get("pk_id"));
		for(int i=0;i<list.size();i++){
			for(int j=0;j<mlist.size();j++){
				if(list.get(i).getKey().toString().equals(mlist.get(j).getTitle())){
					list.get(i).setDirection("right");
				}
			}
		}
		return list;
	}
	/**
	 * 道路查询
	 * @param map
	 */
	@RequestMapping("queryroad")
	public  List<RoadInfo>  roadservice(){
		List<RoadInfo> list = service.roadservice();
		return list;
	}
	/**
	 * 设备查询
	 * @param map
	 */
	@RequestMapping("devicelist")
    public PageInfo<DeviceInfo> devicelistpageList(@RequestBody HashMap<String,Object> modelMap ){
    	PageInfo pinfo = new PageInfo();
    	int a = (int) modelMap.get("pk_id");
    	List<DeviceInfo> dlist = null;
    	if(a!=0){
    		dlist = service.quedev(a);
    	}
	    pinfo.setPageNum(Integer.parseInt(modelMap.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(modelMap.get("pageSize").toString()));
    	PageInfo<DeviceInfo> list= (PageInfo<DeviceInfo>)service.devicelistpageList(modelMap,pinfo);
		if(dlist != null){
    	for(int i=0;i<list.getList().size();i++){
			for(int j=0;j<dlist.size();j++){
				if(list.getList().get(i).getPk_id().toString().equals(dlist.get(j).getDevice_num())){
					list.getList().get(i).setBackground("blue");
				}
			}
		}
		}
    	return list;
	}
	@RequestMapping("insadd")
	public int  insadd(@RequestBody HashMap<String,Object> map){			
		int c = service.insadd(map);
		String[] gs = map.get("gslb").toString().substring(1, map.get("gslb").toString().length()-1).replaceAll(" ", "").split(",");
		String[] sb = map.get("sblb").toString().substring(1, map.get("sblb").toString().length()-1).replaceAll(" ", "").split(",");
		for(int i=0;i<gs.length;i++){
			map.put("gspk", gs[i]);
			int a = service.gsadd(map);
		}
		for(int i=0;i<sb.length;i++){
			map.put("sbpk", sb[i]);
			int a = service.sbadd(map);
		}
		return c;
	}
	@RequestMapping("insedit")
	public int  insedit(@RequestBody HashMap<String,Object> map){			
		int c = service.insedit(map);
		int c1 = service.delgs(map);
		int c2 = service.delsb(map);
		map.put("id", map.get("pk_id"));
		String[] gs = map.get("gslb").toString().substring(1, map.get("gslb").toString().length()-1).replaceAll(" ", "").split(",");
		String[] sb = map.get("sblb").toString().substring(1, map.get("sblb").toString().length()-1).replaceAll(" ", "").split(",");
		for(int i=0;i<gs.length;i++){
			map.put("gspk", gs[i]);
			int a = service.gsadd(map);
		}
		for(int i=0;i<sb.length;i++){
			map.put("sbpk", sb[i]);
			int a = service.sbadd(map);
		}
		return c;
	}
	/**
	 * 巡检计划制定删除
	 * @param map
	 */
	@RequestMapping("delIns")
	public int  delIns(@RequestBody HashMap<String,Object> modelMap){
		int status = service.delIns(modelMap);
		int c1 = service.delgs(modelMap);
		int c2 = service.delsb(modelMap);
		return status;
	}
	/**
	 * 巡检计划制定批量删除
	 * @param map
	 */
	@RequestMapping("delInsmax")
	public int  delInsmax(@RequestBody HashMap<String,Object> modelMap){
		String 	dept_pk=modelMap.get("pk_id").toString();
		modelMap.put("pk_id", dept_pk.split(","));
		int status = service.delInsmax(modelMap);
		int c1 = service.delgsmax(modelMap);
		int c2 = service.delsbmax(modelMap);
		return status;
	}
}
