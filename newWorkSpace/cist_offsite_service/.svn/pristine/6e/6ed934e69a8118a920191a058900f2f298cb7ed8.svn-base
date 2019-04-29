package com.cist.audit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.audit.model.DeviceGroup;
import com.cist.audit.model.OffeInfo;
import com.cist.audit.model.PoliceInfo;
import com.cist.audit.service.AuditService;
import com.cist.device.model.DeptInfo;
import com.cist.device.model.Sys_device_grouping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/audit")
public class AuditController {
	@Autowired
	private AuditService service;
	
	/**
	 * 审核权限分配首页
	 * @param map
	 */
	@RequestMapping("querypol")
	public List<PoliceInfo>  querypol(){			
		List<PoliceInfo> list = service.querypol();
		List<PoliceInfo> wsblist = service.querywsb();
		String sypi_pk_zu = "";
		for(int i=0;i<list.size();i++){
			for(int m=0;m<wsblist.size();m++){
				sypi_pk_zu = sypi_pk_zu+wsblist.get(m).getSypi_pk().toString()+",";
				if(list.get(i).getTbvg_pk().toString().equals(wsblist.get(m).getTbvg_pk().toString())){
    				list.get(i).setWsb(true);
    			}
			}
			if(sypi_pk_zu.length()!=0){
				list.get(i).setSypi_pk_zu(sypi_pk_zu.substring(0, sypi_pk_zu.length()-1));
			}
			list.get(i).setSypi_name_code(list.get(i).getSypi_name()+"("+list.get(i).getSypi_code()+")");
			if(list.get(i).getTbvg_wfxw()!= null){
			String[] a = list.get(i).getTbvg_wfxw().split(",");
			list.get(i).setTbcg_wfxw_code(a);
			}
			if(list.get(i).getTbvg_pk()!=null){
			List<PoliceInfo> polgrolist = service.polgroud(list.get(i).getTbvg_pk());
			List<PoliceInfo> usrgrolist = service.usergroud(list.get(i).getTbvg_pk());
			String tbei_code = "";
			String tbei_name = "";
			String groud_code = "";
			if(polgrolist != null){
			for(int j = 0; j < polgrolist.size(); j++){
				tbei_code=tbei_code+polgrolist.get(j).getDvc_pk()+",";
				tbei_name=tbei_name+polgrolist.get(j).getDvc_name()+",";
			}
			}
			if(usrgrolist.isEmpty()){
				for(int c = 0; c < usrgrolist.size(); c++){
					groud_code=groud_code+usrgrolist.get(c).getTbge_pk()+",";
				}
			}
			if(tbei_code.length()!=0){
				list.get(i).setDvc_pk_zu(tbei_code.substring(0, tbei_code.length()-1));
				list.get(i).setDvc_name_zu(tbei_name.substring(0, tbei_name.length()-1));
			}
			if(groud_code.length()!=0){
				list.get(i).setTbge_pk_zu(groud_code.substring(0, groud_code.length()-1));
			}
			}
		}
		return list;
	}
	@RequestMapping("querywfxw")
	public List<OffeInfo>  querywfxw(){			
		List<OffeInfo> list = service.querywfxw();
		for(int i=0;i<list.size();i++){
			list.get(i).setTboc_name_code(list.get(i).getTboc_name()+"("+list.get(i).getTboc_code()+")");
		}
		return list;
	}
	@RequestMapping("addAuditInfo")
	public int  addAuditInfo(@RequestBody HashMap<String,Object> map){			
		List<PoliceInfo> list = service.querypol();
		List<PoliceInfo> list2 = service.querv();
		int k  = service.deldve();
		int c = 0;
		if(map.get("sypi_sb")!=""){
		String[] o = map.get("sypi_sb").toString().split(",");
		for(int y = 0;y<o.length;y++){
			PoliceInfo tbvg_pk = service.querytbvg(o[y]);
			if(tbvg_pk != null){
				map.put("dvc_pk", 0);
				map.put("tbvg_pk", tbvg_pk.getTbvg_pk());
				int p = service.addPolGroud(map);
			}else{
				map.put("sypi_pk", o[y]);
				int id = service.addauthority(map);
				int a = (int) map.get("id");
				map.put("dvc_pk", 0);
				map.put("tbvg_pk", a);
				int p = service.addPolGroud(map);
			}
		}
		}
		for(int i=0;i<list.size();i++){
			boolean b = true;
			ArrayList<String> wfxw = (ArrayList<String>) map.get(list.get(i).getSypi_code()+"wf");
			String wflx = "1";
			if(wfxw!=null&&wfxw.size()>0){
			for(int y=0;y<wfxw.size();y++){
				 wflx = wflx+","+wfxw.get(y);
			}
				wflx = wflx.substring(2, wflx.length());
			}
			if(wflx.equals("1")){
				wflx = null;
			}
			map.put("shsl", map.get(list.get(i).getSypi_code()+"sl"));
			map.put("wflx", wflx);
			map.put("sypi_pk", list.get(i).getSypi_pk());
			for(int j=0;j<list2.size();j++){
				if(list.get(i).getSypi_pk().equals(list2.get(j).getSypi_pk())){
					b=false;
					int a = service.editaudit(map);
					c=1;
				}
			}
			if(map.get("shsl") != null || map.get("wflx")!=null){
				if(b){
					int a = service.addaudie(map);
					c = 1;
				}
			}
		}
		return c;
	}
	@RequestMapping("querypolgroud")
	public List<DeviceGroup>  querypolgroud(@RequestBody HashMap<String,Object> modelMap){			
		String b = modelMap.get("tbvg_pk").toString();
    	List<DeviceGroup> list= service.querygoulist();
    	List<DeviceGroup> usrgrolist = service.queryusergroud(b);
    	for (int i = 0; i < list.size(); i++) {
    		String a[]=list.get(i).getDvc_pk().split(",");
    		String groud_dev_name="";
    		for(int j=0;j<a.length;j++){
    		DeviceGroup ssdw = service.querydept(a[j]);
    		groud_dev_name = groud_dev_name+ssdw.getDevice_name()+",";
    		}
    		list.get(i).setDept_name(groud_dev_name.substring(0, groud_dev_name.length()-1));
    		if(usrgrolist.isEmpty()){
	    		for(int c = 0; c < usrgrolist.size(); c++){
	    			if(list.get(i).getTbge_pk().toString().equals(usrgrolist.get(c).getTbge_pk().toString())){
	    				list.get(i).setChaek(true);
	    			}
	    		}
    		}
		}
		return list;
	}
	@RequestMapping("goulist")
	public int  goulist(@RequestBody HashMap<String,Object> map){			
			int a = service.addgroup(map);
		return a;
	}
	/**
	  * 审核权限分配修改，删除已有设备分组再新增
	  * @param map
	  */
	@RequestMapping("deldev")
	public int  delDev(@RequestBody HashMap<String,Object> modelMap){
			String[] groud_code = modelMap.get("sblb").toString().split(",");
			String[] fzlb = modelMap.get("fzlb").toString().split(",");
			int a = 0;
			if(modelMap.get("tbvg_pk")!=null){
			int sta = service.delPol(modelMap);
			int sta1 = service.delUserGroud(modelMap);
			for(int c=0;c<fzlb.length;c++){
				modelMap.put("tbge_pk", fzlb[c]);
				int status = service.addUserGroud(modelMap);
				a = status;
			}
			for(int j=0;j<groud_code.length;j++){
				modelMap.put("dvc_pk", groud_code[j]);
				int status = service.addPolGroud(modelMap);
				a = status;
			}
			}else{
				int c = service.addauthority(modelMap);
				modelMap.put("tbvg_pk", modelMap.get("id"));
				for(int j=0;c<fzlb.length;j++){
					modelMap.put("tbge_pk", fzlb[j]);
					int status = service.addUserGroud(modelMap);
					a = status;
				}
				for(int y=0;y<groud_code.length;y++){
					modelMap.put("dvc_pk", groud_code[y]);
					int status = service.addPolGroud(modelMap);
					a = status;
				}
			}
		return a;
	}
	/**
	 * 删除设备分组
	 * @param map
	 * @return
	 */
	@RequestMapping("delgoulist")
	public int  delgoulist(@RequestBody HashMap<String,Object> map){			
			int a = service.delgoulist(map);
		return a;
	}
	/**
	 * 查询用户设备数量
	 */
	@RequestMapping("querysbsl")
	public List<DeviceGroup>  querysbsl(){			
		List<DeviceGroup> list = service.querysbsl();
		return list;
	}
	
	
	//部门-道路-安装点位-设备，树结构
	@RequestMapping("deptinfo")
	public String deptinfo()throws JsonProcessingException{
    //顶级部门
	List<DeptInfo>	departinfo=service.depart_infolist(null);
	ObjectMapper mapper = new ObjectMapper();
	List<DeptInfo> list=departinfodg(departinfo);
	String json=mapper.writeValueAsString(getdiwfdidian(list));
	return json.substring(1, json.length()-1);
	}
	public List<HashMap<String, Object>> getdiwfdidian(List<DeptInfo> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (DeptInfo depart_info : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_code());
			map.put("selectable", depart_info.getSelectable());
			map.put("isLeaf", depart_info.getIsLeaf());
			if(null!=depart_info.getChildren()) {//下级
				map.put("children", getdiwfdidian(depart_info.getChildren()));
				listmap.add(map);
			}else {
				listmap.add(map);
			}
		}
		return listmap;
	}
	public List<DeptInfo> departinfodg(List<DeptInfo> departinfo){
	for (DeptInfo depart_info : departinfo) {
		//道路
		List<DeptInfo> tbmp = service.Monitorpoint(depart_info.getDept_code());
		for(int i=0; i<tbmp.size();i++){
			//安装点位
			List<DeptInfo> tbeg = service.azdw(tbmp.get(i).getDept_code());
			for(int j=0;j<tbeg.size();j++){
				//设备
				List<DeptInfo> sb = service.Device(tbeg.get(j).getName());
				if(sb.size()!=0){
					for(int c=0;c<sb.size();c++){
						sb.get(c).setIsLeaf(true);
					}
				}
				tbeg.get(j).setChildren(sb);
			}
			tbmp.get(i).setChildren(tbeg);
		}
		depart_info.setChildren(tbmp);
		//部门
	List<DeptInfo> list= service.depart_infolist(depart_info.getDept_pk());
		if(list.size()!=0){
			depart_info.setChildren(list);
			departinfodg(list);
		}
	  }
     return departinfo;
	}
	
/**
 * =====================复审权限配置====================	
 */
/**
 * 复审权限首页查询
 */
	/**
	 * 审核权限分配首页
	 * @param map
	 */
	@RequestMapping("querypol2")
	public List<PoliceInfo>  querypol2(){			
		List<PoliceInfo> list = service.querypol2();
		List<PoliceInfo> wsblist = service.querywsb2();
		String sypi_pk_zu = "";
		for(int i=0;i<list.size();i++){
			for(int m=0;m<wsblist.size();m++){
				sypi_pk_zu = sypi_pk_zu+wsblist.get(m).getSypi_pk().toString()+",";
				Integer tbvgpk = list.get(i).getTbvg_pk();
				if(tbvgpk!=null){
					if(tbvgpk==wsblist.get(m).getTbvg_pk()){
	    				list.get(i).setWsb(true);
	    			}
				}
			}
			if(sypi_pk_zu.length()!=0){
				list.get(i).setSypi_pk_zu(sypi_pk_zu.substring(0, sypi_pk_zu.length()-1));
			}
			list.get(i).setSypi_name_code(list.get(i).getSypi_name()+"("+list.get(i).getSypi_code()+")");
			if(list.get(i).getTbvg_wfxw()!= null){
			String[] a = list.get(i).getTbvg_wfxw().split(",");
			list.get(i).setTbcg_wfxw_code(a);
			}
			if(list.get(i).getTbvg_pk()!=null){
			List<PoliceInfo> polgrolist = service.polgroud(list.get(i).getTbvg_pk());
			List<PoliceInfo> usrgrolist = service.usergroud(list.get(i).getTbvg_pk());
			String tbei_code = "";
			String tbei_name = "";
			String groud_code = "";
			if(polgrolist != null){
			for(int j = 0; j < polgrolist.size(); j++){
				tbei_code=tbei_code+polgrolist.get(j).getDvc_pk()+",";
				tbei_name=tbei_name+polgrolist.get(j).getDvc_name()+",";
			}
			}
			if(usrgrolist.isEmpty()){
				for(int c = 0; c < usrgrolist.size(); c++){
					groud_code=groud_code+usrgrolist.get(c).getTbge_pk()+",";
				}
			}
			if(tbei_code.length()!=0){
				list.get(i).setDvc_pk_zu(tbei_code.substring(0, tbei_code.length()-1));
				list.get(i).setDvc_name_zu(tbei_name.substring(0, tbei_name.length()-1));
			}
			if(groud_code.length()!=0){
				list.get(i).setTbge_pk_zu(groud_code.substring(0, groud_code.length()-1));
			}
			}
		}
		return list;
	}
	/**
	 * 查询用户设备数量
	 */
	@RequestMapping("querysbsl2")
	public List<DeviceGroup>  querysbsl2(){			
		List<DeviceGroup> list = service.querysbsl2();
		return list;
	}
	@RequestMapping("addAuditInfo2")
	public int  addAuditInfo2(@RequestBody HashMap<String,Object> map){			
		List<PoliceInfo> list = service.querypol2();
		List<PoliceInfo> list2 = service.querv2();
		int c = 0;
		if(map.get("sypi_sb")!=""){
		String[] o = map.get("sypi_sb").toString().split(",");
		for(int y = 0;y<o.length;y++){
			PoliceInfo tbvg_pk = service.querytbvg2(o[y]);
			if(tbvg_pk != null){
				map.put("dvc_pk", 0);
				map.put("tbvg_pk", tbvg_pk.getTbvg_pk());
				int p = service.addPolGroud(map);
			}else{
				map.put("sypi_pk", o[y]);
				int id = service.addauthority2(map);
				int a = (int) map.get("id");
				map.put("dvc_pk", 0);
				map.put("tbvg_pk", a);
				int p = service.addPolGroud(map);
			}
		}
		}
		for(int i=0;i<list.size();i++){
			boolean b = true;
			ArrayList<String> wfxw = (ArrayList<String>) map.get(list.get(i).getSypi_code()+"wf2");
			String wflx = "1";
			if(wfxw!=null&&wfxw.size()>0){
			for(int y=0;y<wfxw.size();y++){
				 wflx = wflx+","+wfxw.get(y);
			}
			wflx = wflx.substring(2, wflx.length());
			}
			if(wflx.equals("1")){
				wflx = null;
			}
			map.put("shsl", map.get(list.get(i).getSypi_code()+"sl2"));
			map.put("wflx", wflx);
			map.put("sypi_pk", list.get(i).getSypi_pk());
			for(int j=0;j<list2.size();j++){
				if(list.get(i).getSypi_pk().equals(list2.get(j).getSypi_pk())){
					b=false;
					int a = service.editaudit2(map);
					c=1;
				}
			}
			if(map.get("shsl") != null || map.get("wflx")!=null){
				if(b){
					int a = service.addaudie2(map);
					c = 1;
				}
			}
		}
		return c;
	}
	@RequestMapping("querypolgroud2")
	public List<DeviceGroup>  querypolgroud2(@RequestBody HashMap<String,Object> modelMap){			
		String b = modelMap.get("tbvg_pk").toString();
    	List<DeviceGroup> list= service.querygoulist2();
    	List<DeviceGroup> usrgrolist = service.queryusergroud(b);
    	for (int i = 0; i < list.size(); i++) {
    		String a[]=list.get(i).getDvc_pk().split(",");
    		String groud_dev_name="";
    		for(int j=0;j<a.length;j++){
    		DeviceGroup ssdw = service.querydept(a[j]);
    		groud_dev_name = groud_dev_name+ssdw.getDevice_name()+",";
    		}
    		list.get(i).setDept_name(groud_dev_name.substring(0, groud_dev_name.length()-1));
    		if(usrgrolist.isEmpty()){
	    		for(int c = 0; c < usrgrolist.size(); c++){
	    			if(list.get(i).getTbge_pk().toString().equals(usrgrolist.get(c).getTbge_pk().toString())){
	    				list.get(i).setChaek(true);
	    			}
	    		}
    		}
		}
		return list;
	}
	
	@RequestMapping("goulist2")
	public int  goulist2(@RequestBody HashMap<String,Object> map){			
			int a = service.addgroup2(map);
		return a;
	}
	
	@RequestMapping("deldev2")
	public int  delDev2(@RequestBody HashMap<String,Object> modelMap){
			String[] groud_code = modelMap.get("sblb").toString().split(",");
			String[] fzlb = modelMap.get("fzlb").toString().split(",");
			int a = 0;
			if(modelMap.get("tbvg_pk")!=null){
			int sta = service.delPol(modelMap);
			int sta1 = service.delUserGroud(modelMap);
			for(int c=0;c<fzlb.length;c++){
				modelMap.put("tbge_pk", fzlb[c]);
				int status = service.addUserGroud(modelMap);
				a = status;
			}
			for(int j=0;j<groud_code.length;j++){
				modelMap.put("dvc_pk", groud_code[j]);
				int status = service.addPolGroud(modelMap);
				a = status;
			}
			}else{
				int c = service.addauthority2(modelMap);
				modelMap.put("tbvg_pk", modelMap.get("id"));
				for(int j=0;c<fzlb.length;j++){
					modelMap.put("tbge_pk", fzlb[j]);
					int status = service.addUserGroud(modelMap);
					a = status;
				}
				for(int y=0;y<groud_code.length;y++){
					modelMap.put("dvc_pk", groud_code[y]);
					int status = service.addPolGroud(modelMap);
					a = status;
				}
			}
		return a;
	}
}
