package com.cist.earlywarning.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.earlywarning.model.WarningInfo;
import com.cist.earlywarning.service.EarlyWarningService;
import com.cist.frame.page.PageInfo;
import com.cist.earlywarning.model.DeptInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/earlywarning")
public class EarlyWarningController {
	@Autowired
	private EarlyWarningService service;
	
	/**
	 * 实时预警处理首页，预警信息查询
	 * @param map
	 */
	@RequestMapping("earlyinfolist")
    public PageInfo<WarningInfo> earlyinfopageList(@RequestBody HashMap<String,Object> modelMap ){
    	PageInfo pinfo = new PageInfo();
	    pinfo.setPageNum(Integer.parseInt(modelMap.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(modelMap.get("pageSize").toString()));
    	PageInfo<WarningInfo> list= (PageInfo<WarningInfo>)service.earlyinfopageList(modelMap,pinfo);
		return list;
	}
	/**
	 * 最新一条预警信息查询
	 */
	@RequestMapping("earlyone")
	public WarningInfo earlyone(){
		return service.earlyone();
	}
	/**
	 * 部门树查询
	 */
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
			map.put("key", depart_info.getDept_pk());
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
	 * 警员树查询，部门-警员
	 */
	@RequestMapping("userinfo")
	public String userinfo()throws JsonProcessingException{
    //顶级部门
	List<DeptInfo>	departinfo=service.depart_infolist(null);
	ObjectMapper mapper = new ObjectMapper();
	List<DeptInfo> list=userrtinfodg(departinfo);
	String json=mapper.writeValueAsString(getuser(list));
	return json.substring(1, json.length()-1);
	}
	public List<HashMap<String, Object>> getuser(List<DeptInfo> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (DeptInfo depart_info : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_pk());
			map.put("isLeaf", depart_info.getIsLeaf());
			if(null!=depart_info.getChildren()) {//下级
				
				map.put("children", getuser(depart_info.getChildren()));
				listmap.add(map);
			}else {
				listmap.add(map);
			}
		}
		return listmap;
	}
	public List<DeptInfo> userrtinfodg(List<DeptInfo> departinfo){
	for (DeptInfo depart_info : departinfo) {
	//用户
	List<DeptInfo> tbmp = service.userlist(depart_info.getDept_pk());
	if(tbmp.size()!=0){
		for(int c=0;c<tbmp.size();c++){
			tbmp.get(c).setIsLeaf(true);
		}
	}
	depart_info.setChildren(tbmp);
	//部门
	List<DeptInfo> list= service.depart_infolist(depart_info.getDept_pk());
		if(list.size()!=0){
			depart_info.setChildren(list);
			userrtinfodg(list);
		}
	  }
     return departinfo;
	}
	/**
	 * 预警下达
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("addissued")
	public int  addissued(@RequestBody HashMap<String,Object> modelMap){
			String[] xfbm = modelMap.get("xfbm").toString().split(",");
			String[] xfry = modelMap.get("xfry").toString().split(",");
			int a = 0;
			modelMap.put("xfr", "563");
			int c = service.addiss(modelMap);
			modelMap.put("xdpk", modelMap.get("id"));
			if(xfry != null){
				for(int j=0;c<xfry.length;j++){
					modelMap.put("xfpk", xfry[j]);
					modelMap.put("xflx", 1);
					int status = service.addUserIss(modelMap);
					a = status;
				}
			}else{
				for(int y=0;y<xfbm.length;y++){
					modelMap.put("xfpk", xfbm[y]);
					modelMap.put("xflx", 2);
					int status = service.addUserIss(modelMap);
					a = status;
				}
			}
		return a;
	}
}
