package com.cist.redlist.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.page.PageInfo;
import com.cist.redlist.model.DeptInfo;
import com.cist.redlist.model.RedListInfo;
import com.cist.redlist.service.RedListService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/redlist")
public class RedListController {
	
	@Autowired
	private RedListService service;
	
	   /**
	    * 号牌种类查询
	    */
		@RequestMapping("plateTypeList")
		public List<RedListInfo>  plateTypeList(){			
			List<RedListInfo> platelist = service.plateTypeList();
			return platelist;
		}
	   /**
		* 号牌种类查询
		*/
		@RequestMapping("plateColorList")
		public List<RedListInfo>  plateColorList(){			
			List<RedListInfo> platelist = service.plateColorList();
			return platelist;
		}
		 /**
		* 号牌区域查询
		*/
		@RequestMapping("plateKerisList")
		public List<RedListInfo>  plateKerisList(){			
			List<RedListInfo> platelist = service.plateKerisList();
			return platelist;
		}
		/**
		 * 车辆类型查询
		 */
		@RequestMapping("carTypeList")
		public List<RedListInfo>  carTypeList(){			
			List<RedListInfo> cartypelist = service.carTypeList();
			return cartypelist;
		}
		/**
		 * 车身颜色查询
		 */
		@RequestMapping("carColorList")
		public List<RedListInfo>  carColorList(){			
			List<RedListInfo> carcolorlist = service.carColorList();
			return carcolorlist;
		}
		/**
		 * 车辆品牌查询
		 */
		@RequestMapping("carLogoList")
		public List<RedListInfo>  carLogoList(){			
			List<RedListInfo> carcolorlist = service.carLogoList();
			return carcolorlist;
		}
		/**
		 * 基础数据合集查询
		 */
		@RequestMapping(value="basicData")
		public HashMap<String,Object> basicData() {
			HashMap<String, Object> modelMap=new HashMap<String, Object>();	
			modelMap.put("carLogoList", service.carLogoList());//车辆品牌
			modelMap.put("carColorList", service.carColorList());//车身颜色
			modelMap.put("plateTypeList", service.plateTypeList());//号牌种类
			modelMap.put("plateColorList", service.plateColorList());//号牌颜色
			modelMap.put("plateKerisList", service.plateKerisList());//号牌区域
			modelMap.put("carTypeList", service.carTypeList());//车辆种类
			return modelMap;
		}
		/**
		 * 红名单申请首页，红名单信息查询
		 * @param map
		 */
		@RequestMapping("redInfoList")
		@SuppressWarnings("rawtypes")
	    public PageInfo<RedListInfo> redInfopageList(@RequestBody HashMap<String,Object> modelMap ){
			PageInfo pinfo = new PageInfo();
		    pinfo.setPageNum(Integer.parseInt(modelMap.get("currentPage").toString()));
			pinfo.setPageSize(Integer.parseInt(modelMap.get("pageSize").toString()));
	    	PageInfo<RedListInfo> list= (PageInfo<RedListInfo>)service.redInfopageList(modelMap,pinfo);
			return list;
		}
		/**
		 * 红名单申请新增
		 * @param map
		 */
		@RequestMapping("addRedInfo")
		public int  addRedInfo(@RequestBody HashMap<String,Object> modelMap){
			if(modelMap.get("clbj").toString().equals("")){
				modelMap.put("clbj","1");
			}else{
				modelMap.put("clbj","2");
			}
			if(modelMap.get("csys").toString().length()!= 1){
			ArrayList<String> wfxw = (ArrayList<String>) modelMap.get("csys");
			String csys = "1";
			for(int y=0;y<wfxw.size();y++){
				 csys = csys+","+wfxw.get(y);
			}
			csys = csys.substring(2, csys.length());
			modelMap.put("csys", csys);
			}
			modelMap.put("hphm",modelMap.get("hpqy").toString()+modelMap.get("hphm").toString());
			int status = service.addRedInfo(modelMap);
			return status;
		}
		/**
		 * 红名单申请删除
		 * @param map
		 */
		@RequestMapping("delRedInfo")
		public int  delRedInfo(@RequestBody HashMap<String,Object> modelMap){
			int status = service.delRedInfo(modelMap);
			return status;
		}
		/**
		 * 查询一条红名单申请信息
		 * @param map
		 */
		@RequestMapping("OneRedInfo")
		public RedListInfo  OneRedInfo(@RequestBody HashMap<String,Object> modelMap){
			RedListInfo red = service.OneRedInfo(modelMap);
			String hphm = red.getHphm();
			red.setHpqy(hphm.substring(0,2));
			red.setHphm(hphm.substring(2,hphm.length()));
			if(red.getClbj()==1){
				red.setClbj(null);
			}
			return red;
		}
		
		/**
		 * 红名单申请修改
		 * @param map
		 */
		@RequestMapping("editRedInfo")
		public int  editRedInfo(@RequestBody HashMap<String,Object> modelMap){
			if(modelMap.get("clbj").toString().equals("1")){
				modelMap.put("clbj","1");
			}else{
				modelMap.put("clbj","2");
			}
			if(modelMap.get("csys_code").toString().length()!= 1){
			ArrayList<String> wfxw = (ArrayList<String>) modelMap.get("csys_code");
			String csys = "1";
			for(int y=0;y<wfxw.size();y++){
				 csys = csys+","+wfxw.get(y);
			}
			csys = csys.substring(2, csys.length());
			modelMap.put("csys", csys);
			}
			modelMap.put("hphm",modelMap.get("hpqy").toString()+modelMap.get("hphm").toString());
			int status = service.editRedInfo(modelMap);
			return status;
		}
		//部门
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
		//部门
		List<DeptInfo> list= service.depart_infolist(depart_info.getDept_pk());
			if(list.size()!=0){
				depart_info.setChildren(list);
				departinfodg(list);
			}
		  }
	     return departinfo;
		}
}
