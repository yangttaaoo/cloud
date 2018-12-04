package com.cist.device.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.picture.model.Depart_info;
import com.cist.frame.utils.SysTempStoreUtils;
import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.device.model.DeptInfo;
import com.cist.device.model.PoliceInfo;
import com.cist.device.model.Sys_device_grouping;
import com.cist.device.service.DeviceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/device")
public class DeviceController {

	
	@Autowired
	private DeviceService service;
	/**
	 * 审核权限分配首页，分组信息查询
	 * @param map
	 */
	@RequestMapping("querylist")
    public List<Sys_device_grouping> querylist(){
    	List<Sys_device_grouping> list= service.querylist();
    	for (int i = 0; i < list.size(); i++) {
    		String a[]=list.get(i).getGroud_dev().split(",");
    		String groud_dev_name="";
    		for(int j=0;j<a.length;j++){
    		Sys_device_grouping ssdw = service.querydept(a[j]);
    		groud_dev_name = groud_dev_name+ssdw.getTbei_name()+",";
    		}
    		list.get(i).setDept_name(groud_dev_name.substring(0, groud_dev_name.length()-1));
		}
		return list;
	}
    @RequestMapping("querylistxg")
    public List<Sys_device_grouping> querylistxg(@RequestBody HashMap<String,Object> modelMap){
    	String b = modelMap.get("sypi_pk").toString();
    	List<Sys_device_grouping> list= service.querylist();
    	List<Sys_device_grouping> usrgrolist = service.queryusergroud(b);
    	for (int i = 0; i < list.size(); i++) {
    		String a[]=list.get(i).getGroud_dev().split(",");
    		String groud_dev_name="";
    		for(int j=0;j<a.length;j++){
    		Sys_device_grouping ssdw = service.querydept(a[j]);
    		groud_dev_name = groud_dev_name+ssdw.getTbei_name()+",";
    		}
    		list.get(i).setDept_name(groud_dev_name.substring(0, groud_dev_name.length()-1));
    		if(usrgrolist.size()!=0){
	    		for(int c = 0; c < usrgrolist.size(); c++){
	    			if(list.get(i).getPk().toString().equals(usrgrolist.get(c).getGroud_code())){
	    				list.get(i).setChaek(true);
	    			}
	    		}
    		}
		}
		return list;
	}
    /**
	 * 警员分配首页，分组信息查询
	 * @param map
	 */
	@RequestMapping("querylistpol")
    public PageInfo<Sys_device_grouping> querylistpol(@RequestBody HashMap<String,Object> modelMap ){
    	PageInfo pinfo = new PageInfo();
	    pinfo.setPageNum(Integer.parseInt(modelMap.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(modelMap.get("pageSize").toString()));
    	PageInfo<Sys_device_grouping> list= (PageInfo<Sys_device_grouping>)service.querypolpageList(modelMap,pinfo);
    	for (int i = 0; i < list.getList().size(); i++) {
			String ssdw = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT,list.getList().get(i).getSypi_dept());
			list.getList().get(i).setDept_name(ssdw);
			List<Sys_device_grouping> polgrolist = service.querypolgroud(list.getList().get(i).getSypi_code());
			List<Sys_device_grouping> usrgrolist = service.queryusergroud(list.getList().get(i).getSypi_pk());
			String tbei_code = "";
			String tbei_name = "";
			String groud_code = "";
			for(int j = 0; j < polgrolist.size(); j++){
				tbei_code=tbei_code+polgrolist.get(j).getTbei_code()+",";
				tbei_name=tbei_name+polgrolist.get(j).getTbei_name()+",";
			}
			if(usrgrolist.size()!=0){
			for(int c = 0; c < usrgrolist.size(); c++){
				groud_code=groud_code+usrgrolist.get(c).getGroud_code()+",";
			}
			}
			list.getList().get(i).setTbei_code(tbei_code.substring(0, tbei_code.length()-1));
			list.getList().get(i).setTbei_name(tbei_name.substring(0, tbei_name.length()-1));
			if(groud_code.length()!=0){
			list.getList().get(i).setGroud_code(groud_code.substring(0, groud_code.length()-1));
			}
		}
		return list;
	}
	/**
	  * 审核权限分配新增，新增分组信息
	  * @param map
	  */
	@RequestMapping("adddevice")
	public int  addDevInfo(@RequestBody HashMap<String,Object> modelMap){
		modelMap.put("groud_dev", modelMap.get("sblb").toString().substring(0, modelMap.get("sblb").toString().length()-1));
		int status = service.addDevInfo(modelMap);
		return status;
	}

	/**
	  * 审核权限分配警员分配，删除已有警员分组
	  * @param map
	  */
	@RequestMapping("delpol")
	public int  delPol(@RequestBody HashMap<String,Object> modelMap){
		int status = service.delPol(modelMap);
		return status;
	}
	/**
	  * 审核权限分配警员分配，批量删除已有警员分组
	  * @param map
	  */
	@RequestMapping("delpolall")
	public int  delpolall(@RequestBody HashMap<String,Object> modelMap){
		String 	dept_pk=modelMap.get("sypi_pk").toString();
		 String pk[]=dept_pk.split(",");
		 for (String string : pk) {
				modelMap.put("sypi_pk", string);
				service.delPol(modelMap);
				service.delUserGroud(modelMap);
			}
			return 1;
	}
	/**
	  * 审核权限分配警员分配，新增警员分组
	  * @param map
	  */
	@RequestMapping("addpolgroud")
	public int  addPolGroud(@RequestBody HashMap<String,Object> modelMap){
		String[] sypi_pk = modelMap.get("jylb").toString().split(",");
		String[] groud_code = modelMap.get("sblb").toString().split(",");
		String[] fzlb = modelMap.get("fzlb").toString().split(",");
		int a = 0;
		for(int i=0;i<sypi_pk.length;i++){
			modelMap.put("sypi_pk", sypi_pk[i]);
			int sta = service.delPol(modelMap);
			int sta1 = service.delUserGroud(modelMap);
			for(int j=0;j<groud_code.length;j++){
				modelMap.put("tbei_code", groud_code[j]);
				int status = service.addPolGroud(modelMap);
				a = status;
			}
			for(int c=0;c<fzlb.length;c++){
				modelMap.put("groud_code", fzlb[c]);
				int status = service.addUserGroud(modelMap);
				a = status;
			}
		}
		return a;
	}
	/**
	  * 审核权限分配警员分配，查询已有警员分组
	  * @param map
	  */
	@RequestMapping("querypolgroud")
	public List<Sys_device_grouping>  querypolgroud(String sypi_code){			
		List<Sys_device_grouping> polgrolist = service.querypolgroud(sypi_code);
		return polgrolist;
	}
	/**
	  * 审核权限分配修改，查询已有设备分组
	  * @param map
	  */
	@RequestMapping("querydevgroud")
	public List<Sys_device_grouping>  querydevgroud(@RequestBody String groud_code){			
		List<Sys_device_grouping> polgrolist = service.querydevgroud(groud_code);
		return polgrolist;
	}
	/**
	  * 审核权限分配修改，删除已有设备分组
	  * @param map
	  */
	@RequestMapping("deldev")
	public int  delDev(@RequestBody HashMap<String,Object> modelMap){
			String[] groud_code = modelMap.get("sblb").toString().split(",");
			String[] fzlb = modelMap.get("fzlb").toString().split(",");
			int a = 0;
			int sta = service.delPol(modelMap);
			int sta1 = service.delUserGroud(modelMap);
			for(int c=0;c<fzlb.length;c++){
				modelMap.put("groud_code", fzlb[c]);
				int status = service.addUserGroud(modelMap);
				a = status;
			}
			for(int j=0;j<groud_code.length;j++){
				modelMap.put("tbei_code", groud_code[j]);
				int status = service.addPolGroud(modelMap);
				a = status;
			}
		return a;
	}
	/**
	  * 审核权限分配修改，修改分组信息
	  * @param map
	  */
	@RequestMapping("editdev")
	public int  editDev(@RequestBody HashMap<String,Object> modelMap){
		modelMap.put("groud_dev", modelMap.get("sblb").toString().substring(0, modelMap.get("sblb").toString().length()-1));
		int status = service.editDev(modelMap);
		return status;
	}
	/**
	  * 审核权限分配删除，删除分组信息
	  * @param map
	  */
	@RequestMapping("deldevinfo")
	public int  delDevInfo(@RequestBody HashMap<String,Object> modelMap){
		int status = service.delDevInfo(modelMap);
		return status;
	}
	/**
	  * 审核权限分配新增，验证该groud_code是否重复
	  * @param map
	  */
	@RequestMapping("/querygroudcode")
	public Sys_device_grouping  querygroudcode(@RequestBody String groud_code){
			 Sys_device_grouping groudInfo = service.querygroudcode(groud_code);
			 return groudInfo;
	}
			//部门-安装点位-设备，树结构
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
				//安装地点
				List<DeptInfo> tbmp = service.Monitorpoint(depart_info.getDept_code());
				for(int i=0; i<tbmp.size();i++){
					//设备
					tbmp.get(i).setChildren(service.Device(tbmp.get(i).getDept_code()));
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
			//警员树
			@RequestMapping("policeinfo")
			public String policeinfo() throws JsonProcessingException{
		    //顶级部门 null
			List<PoliceInfo> departinfo=service.police_infolist(null);
			ObjectMapper mapper = new ObjectMapper();	
			List<PoliceInfo> list=departinfodg2(departinfo);
			String json=mapper.writeValueAsString(getdiwfdidian2(list));
			return json.substring(1, json.length()-1);
			}
			
			public List<HashMap<String, Object>> getdiwfdidian2(List<PoliceInfo> list){
				List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
				for (PoliceInfo depart_info : list) {
					HashMap<String, Object> map=new HashMap<String, Object>();
					map.put("title", depart_info.getName());
					map.put("key", depart_info.getDept_code());
					map.put("selectable", depart_info.getSelectable());
					map.put("isLeaf", depart_info.getIsLeaf());
					if(null!=depart_info.getChildren()) {//下级
						map.put("children", getdiwfdidian2(depart_info.getChildren()));
						listmap.add(map);
					}else {
						listmap.add(map);
					}
				}
				return listmap;
			}
			
			
			public List<PoliceInfo> departinfodg2(List<PoliceInfo> departinfo){
				for (PoliceInfo depart_info : departinfo) {
					//警员
					depart_info.setChildren(service.Police(depart_info.getDept_pk()));
					//部门
					List<PoliceInfo> list= service.police_infolist(depart_info.getDept_pk());
					for (PoliceInfo depart_info2 : list) {
						depart_info.getChildren().add(depart_info2);
					}
					depart_info.setChildren(depart_info.getChildren());
					if(null!=list){
						departinfodg2(list);
					}
				}
				return departinfo;
			}
		/**
		  * 分组信息全部
		  */
		@RequestMapping("querydeptlist")
		public List<Sys_device_grouping>  querydeptlist(){			
			List<Sys_device_grouping> devlist = service.querydeptlist();
			return devlist;
		}
}
