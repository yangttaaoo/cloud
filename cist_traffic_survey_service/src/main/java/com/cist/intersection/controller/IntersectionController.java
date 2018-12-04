package com.cist.intersection.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.cist.frame.page.PageInfo;
import com.cist.intersection.model.CRoadSegitemInfo;
import com.cist.intersection.model.C_road_item;
import com.cist.intersection.model.Depart_info;
import com.cist.intersection.model.TblSigcaseSegitem;
import com.cist.intersection.model.TblTimplanSegitem;
import com.cist.intersection.service.IntersectionService;
import com.cist.roadsection.model.CKreisCode;
import com.cist.roadsection.model.CRoadItemInfo;
import com.cist.roadsection.model.DeptInfo;
import com.cist.roadsection.service.RoadSectionService;
import com.cist.roadsection.util.FileUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/intersection")
public class IntersectionController {
	@Autowired
	private IntersectionService service;
	@Autowired
	private RoadSectionService rService;

	/**
	 * 路口基本信息查询
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="list")
	public PageInfo<CRoadSegitemInfo> selectByCondition(@RequestBody HashMap<String,Object> map) {
	
		PageInfo pinfo = new PageInfo();
		    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<CRoadSegitemInfo> pageinfo = (PageInfo<CRoadSegitemInfo>)service.listpageList(map,pinfo);
			return pageinfo;
	}
	/*
	 * //路口代码是否存在
	 * */
	@RequestMapping(value ="getroimcode")
	public Integer getroimcode(@RequestBody HashMap<String,Object> modelMap) {
		return service.getroimcode(modelMap);
	}
	/**
	 * 路口编辑新增信控方案
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="insertXkfa")
	public String insertXkfa(MultipartFile file,String data,String psxx) {
//		,MultipartFile files,String data,ArrayList list
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
		ObjectMapper objectMapper = new ObjectMapper();
		Map map=new HashMap<String,Object>();
		try {
			ArrayList<?> readValue = objectMapper.readValue(psxx, ArrayList.class); //JSON转List
		
			map = objectMapper.readValue(data, Map.class); //JSON转Map
			if(null!=file) {
				String fileUploadService = FileUtil.FileUploadService(file);
				map.put("xwxxt", fileUploadService);//图片字段参数
			}else {
				map.put("xwxxt", null);//图片字段参数
			}
			
			map.put("list", readValue);//路口信息下面的信控方案下的配时信息集合
//			data为前台传递的参数JSON参数字符串
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		     //保存操作
               Integer save = service.insertSignal(map);
               if(save>0)//1表示保存成功返回的行数
   			{
   				return "{\"result\":\"保存成功\"}";
   			}
   			else{
   				return "{\"result\":\"保存失败\"}";
   			}
	}
	/**
	 * 保存
	 * 
	 * @return String
	 */
	@RequestMapping(value ="save")
	public String save(MultipartFile file,List<MultipartFile> files,String data,String xkfa) {
//		,MultipartFile files,String data,ArrayList list
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
		ObjectMapper objectMapper = new ObjectMapper();
		Map map=new HashMap<String,Object>();
		
		try {
			map = objectMapper.readValue(data, Map.class); //JSON转Map
			ArrayList<?> readValue=null;
			if(xkfa!=null)
			{
				readValue = objectMapper.readValue(xkfa, ArrayList.class); //JSON转List
			}
			if(null!=file) {
				String fileUploadService = FileUtil.FileUploadService(file);
				map.put("pic", fileUploadService);//图片字段参数
			}else {
				map.put("pic", null);//图片字段参数
			}
			
			
			
			map.put("list", readValue);//路口信息下面的信控方案集合
			map.put("files", files);//路口信息下面的信控方案集合的文件集合
//			data为前台传递的参数JSON参数字符串
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	 * 更新
	 * 
	 * @return String
	 */
	@RequestMapping(value ="update")
	public String update(MultipartFile file,List<MultipartFile> files,String data,String xkfa){
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
		ObjectMapper objectMapper = new ObjectMapper();
		Map map=null;
		try {
			//路口信息下对应的信控方案
			ArrayList<?> readValue = objectMapper.readValue(xkfa, ArrayList.class); //JSON转List
			//data为前台传递的参数JSON参数字符串
			map = objectMapper.readValue(data, Map.class); //JSON转Map
			//判断前台更新图片的标识，true为做了改变，false为为改变图片
			if((boolean)map.get("flag")==true)
			{
				if(null!=file) {
					//上传图片到FTP返回路径
					String fileUploadService = FileUtil.FileUploadService(file);
					map.put("pic", fileUploadService);
				}else {
					map.put("pic", null);
				}
				
			}
			else
			{
			
				map.put("roim_pic", "");
				if(null!=map.get("pic")) {
					map.put("pic", map.get("pic"));
				}
			}
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
               //执行更新操作
              Integer update = service.update(map);	
               if(update>0)//1表示保存成功返回的行数
   			{
   				return "{\"result\":\"更新成功\"}";
   			}
   			else{
   				return "{\"result\":\"更新失败\"}";
   			}
	}
	/**
	 * 更新
	 * 
	 * @return String
	 */
	@RequestMapping(value ="updateSignal")
	public String updateSignal(MultipartFile file,String data,String psxx){
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
		ObjectMapper objectMapper = new ObjectMapper();
		Map map=null;
		try {
			//路口信息下对应的
			ArrayList<?> readValue = objectMapper.readValue(psxx, ArrayList.class); //JSON转List
			
			//data为前台传递的参数JSON参数字符串
			map = objectMapper.readValue(data, Map.class); //JSON转Map
			map.put("list", readValue);
			//判断前台更新图片的标识，true为做了改变，false为为改变图片
			if((boolean)map.get("flag")==true&&null!=file)
			{
				//上传图片到FTP返回路径
				String fileUploadService = FileUtil.FileUploadService(file);
				map.put("pic", fileUploadService);
			}
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
               //执行更新操作
              Integer update = service.updateSignal(map);
               if(update>0)//1表示保存成功返回的行数
   			{
   				return "{\"result\":\"更新成功\"}";
   			}
   			else{
   				return "{\"result\":\"更新失败\"}";
   			}
	}
	/**
	 * 批量删除
	 * 
	 * @return Integer
	 */
	@RequestMapping(value ="delete")
	public String delete(@RequestParam("pk") String [] pk){
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
		modelMap.put("PK", pk);
		try {
		Integer delete = service.delete(modelMap);
		return "{\"result\":\"删除成功\"}";
		} catch (Exception e) {
			return "{\"result\":\"删除失败\"}";
		}
	}
	/**
	 * 批量删除
	 * 
	 * @return Integer
	 */
	@RequestMapping(value ="deletePsxx")
	public String delete(@RequestBody HashMap<String,Object> modelMap){
		Integer delete = service.deletePsxx(modelMap);
		return "{\"result\":\"删除成功\"}";
	}
	
	/**
	 * 批量删除
	 * 
	 * @return Integer
	 */
	@RequestMapping(value ="deleteXkfa")
	public String deleteXkfa(@RequestBody HashMap<String,Object> map){
		try {
		Integer delete = service.deleteXkfa(map);
		return "{\"result\":\"删除成功\"}";
		} catch (Exception e) {
			return "{\"result\":\"删除失败\"}";
		}
	}
	/**
	 * 新增页面下拉框和树
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value ="addList")
	public Map<String,Object> addList(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
			modelMap.put("lklx", rService.selectSysFrmCode("3120"));//路口类型
			modelMap.put("lmjg", rService.selectSysFrmCode("3119"));//路面结构
//			modelMap.put("xkfa", service.selectSignal(map));//信控方案查询，根据路口id
		return modelMap;
		
	}
	/**
	 * 修改页面数据查询
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value ="editList")
	public Map<String,Object> editList(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
			modelMap.put("lklx", rService.selectSysFrmCode("3120"));//路口类型
			modelMap.put("lmjg", rService.selectSysFrmCode("3119"));//路面结构
//			modelMap.put("xkfa", service.selectSignal(map));//信控方案查询，根据路口id
		return modelMap;
		
	}
	/**
	 * 修改页面数据查询
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value ="selectXkfa")
	public Map<String,Object> selectXkfa(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
			modelMap.put("xkfa", service.selectSignal(map));//信控方案查询，根据路口id
		return modelMap;
		
	}
	/**
	 * 信控方案对应的配时信息查询
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value ="selectPsxx")
	public Map<String,Object> selectPsxx(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
		List<TblTimplanSegitem> selectPsxx = service.selectPsxx(map);
			modelMap.put("psxx", selectPsxx);
		return modelMap;
		
	}
	/**
	 * 信控方案协调路口查询
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value ="selectXtlk")
	public Map<String,Object> selectXtlk(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
		List<TblSigcaseSegitem> selectXtlk = service.selectXtlk(map);
			modelMap.put("xtlk", selectXtlk);
		return modelMap;
		
	}
	/**
	 * 新增页面下拉框和树
	 * 
	 * @return Map<String,Object>
	 */
	@RequestMapping(value ="selectSignal")
	public Map<String,Object> selectSignal(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
			modelMap.put("xkfa", service.selectSignal(map));//信控方案查询，根据路口id
		return modelMap;
		
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
			
	/**
	 * 管理部门树
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptinfo")
	public String deptinfo() throws JsonProcessingException {
		// 顶级部门
		List<Depart_info> departinfo = service.depart_infolist(null);
		ObjectMapper mapper = new ObjectMapper();
		List<Depart_info> list = departinfodg(departinfo);
		String json = mapper.writeValueAsString(getdiwfdidian(list));
		return json.substring(1, json.length() - 1);
	}

	public List<HashMap<String, Object>> getdiwfdidian(List<Depart_info> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_code());
			map.put("selectable", depart_info.getSelectable());
			map.put("dept", true);
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

	public List<Depart_info> departinfodg(List<Depart_info> departinfo) {
		for (Depart_info depart_info : departinfo) {
			// 部门
			List<Depart_info> list = service.depart_infolist(depart_info.getDept_pk());
			if (list.size() != 0) {
				depart_info.setChildren(list);
				departinfodg(list);
			}
		}
		return departinfo;
	}
	
//	/**
//	 * 道路选择中行政区划树 
//	 * @return
//	 * @throws JsonProcessingException
//	 */
//	@RequestMapping("treeKreis")
//	public List<HashMap<String, Object>> treeKreis(HashMap<String,Object> map) throws JsonProcessingException {
//		// 道路行政区划 "2127"
//		map.put("tbek_parent", null);//根据当前用户的顶级部门来确定，现在写死
//		List<CKreisCode> kreis = service.kreis(map);
//		List<HashMap<String, Object>> kreis2 = getKreis(kreis);
//		return kreis2;
//	}

	public List<HashMap<String, Object>> getKreis(List<CKreisCode> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (CKreisCode kreis : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", kreis.getTbek_code()+":"+kreis.getTbek_name());
			map.put("key", kreis.getTbek_code());
			map.put("selectable", true);
			map.put("isLeaf", false);
			map.put("expanded", true);
			
				listmap.add(map);
		}
		return listmap;
	}
	/**
	 * 行政区划代码查询道路树
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("treeRoad")
	public List<HashMap<String, Object>> treeRoad(@RequestBody HashMap<String,Object> map) throws JsonProcessingException {
		// 根据行政区划代码查询道路树
		List<C_road_item> roadList = service.roadList(map);
		List<HashMap<String, Object>> road = getRoad(roadList);
		return road;
	}

	public List<HashMap<String, Object>> getRoad(List<C_road_item> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (C_road_item roadList : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", roadList.getRoim_name());
			map.put("key", roadList.getRoim_code());
			map.put("selectable", true);
			map.put("isLeaf", false);
			map.put("expanded", true);
			
				listmap.add(map);
		}
		return listmap;
	}
	/**
	 * 部门-安装点位-设备，树结构
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("xtlk")
	public String xtlk()throws JsonProcessingException{
    //顶级部门
	List<Depart_info>	departinfo=service.depart_infolist(null);
	ObjectMapper mapper = new ObjectMapper();
	List<Depart_info> list=departinfodg(departinfo);
	String json=mapper.writeValueAsString(getdept(list));
	return json.substring(1, json.length()-1);
	}
	public List<HashMap<String, Object>> getdept(List<Depart_info> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_code());
			map.put("selectable", depart_info.getSelectable());
			map.put("isLeaf", depart_info.getIsLeaf());
			if(null!=depart_info.getChildren()) {//下级
				map.put("children", getdept(depart_info.getChildren()));
				listmap.add(map);
			}else {
				listmap.add(map);
			}
		}
		return listmap;
	}
	public List<Depart_info> departinfo(List<Depart_info> departinfo){
	for (Depart_info depart_info : departinfo) {
		//安装地点
		List<Depart_info> tbmp = service.Monitorpoint(depart_info.getDept_code());
		depart_info.setChildren(tbmp);
		//部门
	List<Depart_info> list= service.depart_infolist(depart_info.getDept_pk());
		if(list.size()!=0){
			depart_info.setChildren(list);
			departinfo(list);
		}
	  }
     return departinfo;
	}
	
	/**
	 * 管理部门树
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptxksb")
	public String deptxksb() throws JsonProcessingException {
		// 顶级部门
		List<Depart_info> departinfo = service.depart_infolist(null);
		ObjectMapper mapper = new ObjectMapper();
		List<Depart_info> list = departxksb(departinfo);
		String json = mapper.writeValueAsString(getxksb(list));
		return json.substring(1, json.length() - 1);
	}

	public List<HashMap<String, Object>> getxksb(List<Depart_info> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_code());
			map.put("selectable", depart_info.getSelectable());
			map.put("dept", true);
			map.put("expanded", true);
			if (null != depart_info.getChildren()) {// 下级
				map.put("isLeaf", false);
				map.put("children", getdiwfdidian(depart_info.getChildren()));
				listmap.add(map);
			} else {
				map.put("isLeaf", true);
				listmap.add(map);
			}
		}
		return listmap;
	}

	public List<Depart_info> departxksb(List<Depart_info> departinfo) {
		for (Depart_info depart_info : departinfo) {
			// 部门
			List<Depart_info> list = service.depart_infolist(depart_info.getDept_pk());
			if (list.size() != 0) {
				depart_info.setChildren(list);
				departinfodg(list);
			}
		}
		return departinfo;
	}
	
	/**
	 * 管理部门树
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("roadxksb")
	public String roadxksb(@RequestBody HashMap<String,Object> map) throws JsonProcessingException {
		// 顶级部门
		List<C_road_item> road = service.road_infolist(map);
		ObjectMapper mapper = new ObjectMapper();
		List<C_road_item> list = departroad(road);
		String json = mapper.writeValueAsString(getroad(list));
		return json;
	}

	public List<HashMap<String, Object>> getroad(List<C_road_item> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (C_road_item depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getRoim_name());
			map.put("key", depart_info.getRoim_code());
			if (null != depart_info.getChildren()) {// 下级
				map.put("children", getroad(depart_info.getChildren()));
				listmap.add(map);
			} else {
				listmap.add(map);
			}
		}
		return listmap;
	}

	public List<C_road_item> departroad(List<C_road_item> departinfo) {
		for (C_road_item depart_info : departinfo) {
			// 点位
			List<C_road_item> list = service.road_point(depart_info.getRoim_code());
			if (list.size() != 0) {
				depart_info.setChildren(list);
				departroad(list);
			}
		}
		return departinfo;
	}
	/***
	 * 
	 * @Title:  IntersectionController.java
	 * @Package com.cist.intersection.controller  
	 * @Description:    点击部门树获取设备列表
	 * @version V1.0   
	 */
	@RequestMapping("clickdepartinfo")
	public String clickdepartinfo(@RequestBody HashMap<String,Object> modelMap) throws JsonProcessingException{

	List<Depart_info>	departinfo=service.clickdepartinfo(modelMap.get("dept_code").toString());
	ObjectMapper mapper = new ObjectMapper();	
	List<Depart_info> list=clickdepartinfodg(departinfo); 
	String json=mapper.writeValueAsString(getdiwfdidianckick(list));
	return json;
	}	
	public List<HashMap<String, Object>> getdiwfdidianckick(List<Depart_info> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title", depart_info.getTbei_name());
			map.put("key", depart_info.getTbec_kkbh());
			if(null!=depart_info.getChildren()) {//下级
				map.put("children", getdiwfdidianckick(depart_info.getChildren()));
				listmap.add(map);
			}else {
				listmap.add(map);
			}
		}
		return listmap;
	}
	public List<Depart_info> clickdepartinfodg(List<Depart_info> departinfo){
		for (Depart_info depart_info : departinfo) {
			List<Depart_info> list= service.kakou(depart_info.getTbec_kkbh());//卡口编码
			depart_info.setChildren(list);
		}
		return departinfo;
	}
	//点击部门的设备树
	@RequestMapping("yijickdepartinfo")
	public String yijickdepartinfo(@RequestBody HashMap<String,Object> modelMap) throws JsonProcessingException{
		List<Depart_info>	departinfo=service.yijicdepartinfo(modelMap);
		ObjectMapper mapper = new ObjectMapper();	
		modelMap.put("departinfo", departinfo);
		List<Depart_info> list=clickdeparckd(modelMap); 
		String json=mapper.writeValueAsString(getdiwfdidianckick(list));
		return json;
	}
	public List<Depart_info> clickdeparckd(HashMap<String,Object> modelMap){
		@SuppressWarnings("unchecked")
		List<Depart_info>	departinfo= (List<Depart_info>) modelMap.get("departinfo");
		for (Depart_info depart_info : departinfo) {
			modelMap.put("tbec_kkbh", depart_info.getTbec_kkbh());
			List<Depart_info> list= service.kakouxiabu(modelMap);//卡口编码
			depart_info.setChildren(list);
		}
		return departinfo;
	}
	
	
	/***
	 * 
	 * @Title:  IntersectionController.java
	 * @Package com.cist.intersection.controller  
	 * @Description:    点击部门查询道路和路口树
	 * @version V1.0   
	 */
	@RequestMapping("selectRoadTree")
	public String selectRoadTree(@RequestBody HashMap<String,Object> modelMap) throws JsonProcessingException{

	List<C_road_item> selectRoadTree = service.selectRoadTree(modelMap.get("dept_code").toString());
	ObjectMapper mapper = new ObjectMapper();	
	List<C_road_item> list=lukou(selectRoadTree); 
	String json=mapper.writeValueAsString(getTree(list));
	return json;
	}	
	public List<HashMap<String, Object>> getTree(List<C_road_item> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (C_road_item depart_info : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title", depart_info.getRoim_name());
			map.put("key", depart_info.getRoim_code());
			if(null!=depart_info.getChildren()) {//下级
				map.put("children", getTree(depart_info.getChildren()));
				listmap.add(map);
			}else {
				listmap.add(map);
			}
		}
		return listmap;
	}
	public List<C_road_item> lukou(List<C_road_item> departinfo){
		for (C_road_item depart_info : departinfo) {
			List<C_road_item> list= service.lukou(depart_info.getRoim_code());//道路代码
			depart_info.setChildren(list);
		}
		return departinfo;
	}
	//点击部门的设备树
	@RequestMapping("checkLukou")
	public String checkLukou(@RequestBody HashMap<String,Object> modelMap) throws JsonProcessingException{
		List<C_road_item>	departinfo=service.checkLukou(modelMap);
		ObjectMapper mapper = new ObjectMapper();	
		modelMap.put("departinfo", departinfo);
		List<C_road_item> list=lukoudm(modelMap); 
		String json=mapper.writeValueAsString(getTree1(list));
		return json;
	}
	public List<HashMap<String, Object>> getTree1(List<C_road_item> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (C_road_item depart_info : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title", depart_info.getRoim_name());
			map.put("key", depart_info.getRoim_code());
			if(null!=depart_info.getChildren()) {//下级
				map.put("children", getTree(depart_info.getChildren()));
				listmap.add(map);
			}else {
				listmap.add(map);
			}
		}
		return listmap;
	}
	public List<C_road_item> lukoudm(HashMap<String,Object> modelMap){
		@SuppressWarnings("unchecked")
		List<C_road_item>	departinfo= (List<C_road_item>) modelMap.get("departinfo");
		for (C_road_item depart_info : departinfo) {
			modelMap.put("roim_code", depart_info.getRoim_code());
			List<C_road_item> list= service.lukoudm(modelMap);//路口代码
			depart_info.setChildren(list);
		}
		return departinfo;
	}
	//协调路口编辑部门查询
	@RequestMapping("selectXtlkDept")
	public List<C_road_item> selectXtlkDept(@RequestBody HashMap<String, Object> map){
		List<C_road_item> selectXtlkDept = service.selectXtlkDept(map);
		return selectXtlkDept;
		
	}
	//协调路口编辑部门查询
	@RequestMapping("selectXksbDept")
	public C_road_item selectXksbDept(@RequestBody HashMap<String, Object> map){
			C_road_item selectXksbDept = service.selectXksbDept(map);
			return selectXksbDept;
			
		}
}
