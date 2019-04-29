package com.cist.carInfo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cist.carInfo.service.CarInfoService;
import com.cist.frame.page.PageInfo;
import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.carInfo.model.CKreisCode;
import com.cist.carInfo.model.DeptInfo;
import com.cist.carInfo.model.ZdclCarInfo;
import com.cist.carInfo.model.ZdclCompanyInfo;

/***
 * 
 * @Title:  InterApplyController.java   
 * @Package com.cist.interfaceapply.controller
 * @Description:    数据共享接口申请
 * @author: yt
 * @date:   2018年7月6日 下午4:27:35 
 * @version V1.0
 */

@RestController
@RequestMapping("carInfo")
public class CarInfoController{
	
	@Autowired
	private CarInfoService service;
	
	
	/**
	 * 保存
	 * 
	 * @return String
	 */
	@RequestMapping(value ="save")
	public String save(@RequestBody HashMap<String,Object> map) {
		     //保存操作
               Integer save = service.save(map);	
               if(save>0)//1表示保存成功返回的行数
   			{
   				return "{\"result\":\"保存成功\"}";
   			}
   			else{
   				return "{\"result\":\"保存失败\"}";
   			}
	}
	
	/**
	 * 首页列表信息查询
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="list")
	public PageInfo<ZdclCarInfo> selectByCondition(@RequestBody HashMap<String,Object> map,HttpServletRequest request) {
	
		PageInfo pinfo = new PageInfo();
		    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<ZdclCarInfo> pageinfo = (PageInfo<ZdclCarInfo>)service.listpageList(map,pinfo);
			return pageinfo;
	}
	
	/**
	 * 首页列表信息查询
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="selectCompany")
	public PageInfo<ZdclCompanyInfo> selectCompany(@RequestBody HashMap<String,Object> map) {
	
		PageInfo pinfo = new PageInfo();
		    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<ZdclCompanyInfo> pageinfo = (PageInfo<ZdclCompanyInfo>)service.listpageList(map,pinfo);
			return pageinfo;
	}
	/**
	 * 新增页面下拉框
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value ="addList")
	public Map<String,Object> addList(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
			modelMap.put("clfl", service.selectSysFrmCode(SysBaseDataCode.SYS_CLFL));//车辆分类
			modelMap.put("cllx", service.selectSysFrmCode(SysBaseDataCode.SYS_CLLX));//车辆类型
			modelMap.put("syxz", service.selectSysFrmCode(SysBaseDataCode.SYS_SYXZ));//使用性质
		return modelMap;
		
	}
	/**
	 * 管理部门树
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptinfo")
	public String deptinfo() throws JsonProcessingException {
		// 顶级部门
		List<DeptInfo> departinfo = service.depart_infolist(null);
		ObjectMapper mapper = new ObjectMapper();
		List<DeptInfo> list = departinfodg(departinfo);
		String json = mapper.writeValueAsString(getdiwfdidian(list));
		return json.substring(1, json.length() - 1);
	}

	public List<HashMap<String, Object>> getdiwfdidian(List<DeptInfo> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (DeptInfo depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_code());
			map.put("selectable", depart_info.getSelectable());
			map.put("isLeaf", depart_info.getIsLeaf());
			if (null != depart_info.getChildren()) {// 下级

				map.put("children", getdiwfdidian(depart_info.getChildren()));
				listmap.add(map);
			} else {
				listmap.add(map);
			}
		}
		return listmap;
	}

	public List<DeptInfo> departinfodg(List<DeptInfo> departinfo) {
		for (DeptInfo depart_info : departinfo) {
			// 部门
			List<DeptInfo> list = service.depart_infolist(depart_info.getDept_pk());
			if (list.size() != 0) {
				depart_info.setChildren(list);
				departinfodg(list);
			}
		}
		return departinfo;
	}
	
	//行政区划
	@RequestMapping("kreis")
	public String kreis()throws JsonProcessingException{
		//顶级行政区划
		List<CKreisCode> kreis = service.kreis(null);
		ObjectMapper mapper = new ObjectMapper();
		List<CKreisCode> list=kreisinfodg(kreis);
		String json=mapper.writeValueAsString(getxzxh(list));
		return json.substring(1, json.length()-1);
	}
	public List<CKreisCode> kreisinfodg(List<CKreisCode> kreis){
		for (CKreisCode kre : kreis) {
			//部门
			List<CKreisCode> list= service.kreisList(kre.getTbek_pk());
			if(list.size()!=0){
				kre.setChildren(list);
				kreisinfodg(list);
			}
		}
		return kreis;
	}
	
	public List<HashMap<String, Object>> getxzxh(List<CKreisCode> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (CKreisCode ckr : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title",ckr.getTbek_name());
			map.put("key", ckr.getTbek_code());
			map.put("disableCheckbox", false);
			if (null != ckr.getChildren()) {// 下级
				map.put("isLeaf", false);
				map.put("children", getxzxh(ckr.getChildren()));
				listmap.add(map);
			} else {
				map.put("isLeaf", true);
				listmap.add(map);
			}
		}
		return listmap;
	}
	//行政区划
	@RequestMapping("treeKreis")
	public String kreis1()throws JsonProcessingException{
		//顶级行政区划
		List<CKreisCode> kreis = service.kreis(null);
		ObjectMapper mapper = new ObjectMapper();
		List<CKreisCode> list=kreisinfodg1(kreis);
		String json=mapper.writeValueAsString(getxzxh(list));
		return json.substring(1, json.length()-1);
	}
	public List<CKreisCode> kreisinfodg1(List<CKreisCode> kreis){
		for (CKreisCode kre : kreis) {
			//部门
			List<CKreisCode> list= service.kreisList(kre.getTbek_pk());
			if(list.size()!=0){
				kre.setChildren(list);
				kreisinfodg(list);
			}
		}
		return kreis;
	}
	
	public List<HashMap<String, Object>> getxzxh1(List<CKreisCode> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (CKreisCode ckr : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title",ckr.getTbek_code()+":"+ckr.getTbek_name());
			map.put("key", ckr.getTbek_code());
			map.put("disableCheckbox", false);
			if (null != ckr.getChildren()) {// 下级
				map.put("isLeaf", false);
				map.put("children", getxzxh1(ckr.getChildren()));
				listmap.add(map);
			} else {
				map.put("isLeaf", true);
				listmap.add(map);
			}
		}
		return listmap;
	}
	
}
