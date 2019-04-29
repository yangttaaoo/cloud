package com.cist.roadsection.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cist.configUrl.model.FileUtil;
import com.cist.frame.page.PageInfo;
import com.cist.roadsection.model.CKreisCode;
import com.cist.roadsection.model.CRoadItemInfo;
import com.cist.roadsection.model.DeptInfo;
import com.cist.roadsection.service.RoadSectionService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/roadsection")
public class RoadSectionController {
	@Autowired
	private RoadSectionService service;

	/**
	 * 路段基本信息查询
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="list")
	public PageInfo<CRoadItemInfo> selectByCondition(@RequestBody HashMap<String,Object> map,HttpServletRequest request) {
	
		// 当前用户的部门 用于部门权限设置
				HttpSession session = request.getSession();
				Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
				String deptCode = userMap.get("sypi_dept_code")==null?null:userMap.get("sypi_dept_code").toString();
				map.put("dept", deptCode);//当前用户部门code 用于部门权限 
		PageInfo pinfo = new PageInfo();
		    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<CRoadItemInfo> pageinfo = (PageInfo<CRoadItemInfo>)service.listpageList(map,pinfo);
			return pageinfo;
	}
	/*
	 * //道路代码是否存在
	 * */
	@RequestMapping(value ="getroimcode")
	public Integer getroimcode(@RequestBody HashMap<String,Object> modelMap) {
		return service.getroimcode(modelMap);
	}
	/**
	 * 保存
	 * 
	 * @return String
	 */
	@RequestMapping(value ="save")
	public String save(MultipartFile files,String data) {
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map=new HashMap<String,Object>();
		try {
			if(null!=files) {
				//上传图片到FTP返回路径
				String fileUploadService = FileUtil.FileUploadService(files);
				map.put("roim_pic", fileUploadService);//图片字段参数
			}else {
				map.put("roim_pic", null);//图片字段参数
			}
		
			map = objectMapper.readValue(data, Map.class); //JSON转Map
		
			//data为前台传递的参数JSON参数字符串
			
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
	public String update(MultipartFile files,String data){
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
		ObjectMapper objectMapper = new ObjectMapper();
		Map map=null;
		try {
			//data为前台传递的参数JSON参数字符串
			map = objectMapper.readValue(data, Map.class); //JSON转Map
			//判断前台更新图片的标识，true为做了改变，false为为改变图片
			if((boolean)map.get("flag")==true)
			{
				//上传图片到FTP返回路径
				String fileUploadService = FileUtil.FileUploadService(files);
				map.put("roim_pic", fileUploadService);
			}
			else
			{
				map.put("roim_pic", "");
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
	 * 批量删除
	 * 
	 * @return Integer
	 */
	@RequestMapping(value ="delete")
	public String delete(@RequestParam("roim_pk") String [] roim_pk){
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
		modelMap.put("roim_pk", roim_pk);
		Integer delete = service.delete(modelMap);
		 if(delete>0)//1表示更新成功返回的行数
			{
				return "{\"result\":\"删除成功\"}";
			}
			else{
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
			modelMap.put("dllx", service.selectSysFrmCode("R007"));//道路类型
			modelMap.put("ldlx", service.selectSysFrmCode("3120"));//路段类型
			modelMap.put("dlxx", service.selectSysFrmCode("3123"));//道路线型
			modelMap.put("lmjg", service.selectSysFrmCode("3119"));//路面结构
			modelMap.put("ljlx", service.selectSysFrmCode("R008"));//路肩类型
			modelMap.put("lkdj", service.selectSysFrmCode("F001"));//路况评定等级
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
			/**
			 * 道路选择中行政区划树 
			 * @return
			 * @throws JsonProcessingException
			 */
			@RequestMapping("treeKreis")
			public List<HashMap<String, Object>> treeKreis(HashMap<String,Object> map) throws JsonProcessingException {
				// 道路行政区划 
//				map.put("tbek_parent", "2127");//根据当前用户的顶级部门来确定，现在写死
				List<CKreisCode> kreis = service.kreis(map);
				List<HashMap<String, Object>> kreis2 = getKreis(kreis);
				return kreis2;
			}

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
			 * 根据当前用户的部门把顶级部门树设置为当前部门
			 * @return
			 * @throws JsonProcessingException
			 */	
		private List<DeptInfo> topDept(Map<String,Object> map) {
			List<DeptInfo> departinfo = new ArrayList<DeptInfo>();
			DeptInfo  dept = new DeptInfo();
			dept.setDept_code(map.get("sypi_dept_code")==null?null:map.get("sypi_dept_code").toString());
			dept.setDept_pk(map.get("sypi_dept_pk")==null?null:Integer.valueOf(map.get("sypi_dept_pk").toString()));
			dept.setName(map.get("sypi_dept_name")==null?null:map.get("sypi_dept_name").toString());
			departinfo.add(dept);
			return departinfo;
		}
	/**
	 * 管理部门树
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptinfo")
	public String deptinfo(HttpServletRequest request) throws JsonProcessingException {
		// 获取部门pk用于查询以当前用户部门为顶级部门查询树
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String deptCode = userMap.get("sypi_dept_pk")==null?null:userMap.get("sypi_dept_pk").toString();
		// 顶级部门
		List<DeptInfo> departinfo = topDept(userMap);
//		service.depart_infolist(11100);
		
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
}
