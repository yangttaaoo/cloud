package com.cist.policemngment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.cist.policemngment.model.Depart_info;
import com.cist.policemngment.model.DeptInfo;
import com.cist.policemngment.model.Jcsj_P_R_Allot;
import com.cist.policemngment.model.Jcsj_P_R_Have;
import com.cist.policemngment.model.Jcsj_P_R_Relation;
import com.cist.policemngment.model.Jcsj_Police_Res_Person;
import com.cist.policemngment.model.Jcsj_police_resourc;
import com.cist.policemngment.model.SysPoliceInfo;
import com.cist.policemngment.service.PoliceMngmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.jsqlparser.statement.select.First;

@RestController
@RequestMapping("management")
public class PoliceMngmentController {

	@Autowired
	private PoliceMngmentService pmService;

	/**
	 * 分页及条件查询
	 * 
	 * @return
	 */
	@RequestMapping("index")
	public PageInfo<Jcsj_police_resourc> selectByResourc(@RequestBody Map<String, Object> map,HttpServletRequest request) {
		if(map.get("resources_type")!=null){
			if("8".equals(map.get("resources_type").toString())){
				map.put("resources_type", "5");
			}else if("3".equals(map.get("resources_type").toString())){
				map.put("resources_type", "6");
			}else if("6".equals(map.get("resources_type").toString())){
				map.put("resources_type", "4");
			}else if("7".equals(map.get("resources_type").toString())){
				map.put("resources_type", "3");
			}
		}
	
		// 当前用户的部门 用于部门权限设置
		HttpSession session = request.getSession();
		Map<String,Object> map1 = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String deptCode = map1.get("sypi_dept_code")==null?null:map1.get("sypi_dept_code").toString();
		map.put("dept", deptCode);//当前用户部门code 用于部门权限 
		PageInfo pinfo = new PageInfo<>();
		pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Jcsj_police_resourc> pageinfo = (PageInfo<Jcsj_police_resourc>) pmService.selectByRespageList(map,pinfo);
		return pageinfo;

	}

	/**
	 * 过期数据条件查询及分页
	 * @return
	 */
	@RequestMapping("toindex")
	public PageInfo<Jcsj_police_resourc> selectByResourcs(@RequestBody Map<String, Object> map) {
		PageInfo pinfo = new PageInfo<>();
		pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Jcsj_police_resourc> pageinfo = (PageInfo<Jcsj_police_resourc>) pmService.selectsByRespageList(map,pinfo);
		return pageinfo;

	}
	/**
	 * 查询警务通和350M
	 * @return
	 */
	@RequestMapping("selectJW")
	public PageInfo<Jcsj_police_resourc> selectJW(@RequestBody Map<String, Object> map) {
		if(map.get("resources_type")!=null){
		 if("6".equals(map.get("resources_type").toString())){
				map.put("resources_type", "4");
			} else if("9".equals(map.get("resources_type").toString())){
				map.put("resources_type", "7");
			}else if("7".equals(map.get("resources_type").toString())){
				map.put("resources_type", "3");
			}else if("10".equals(map.get("resources_type").toString())){
				map.put("resources_type", "8");
			}
		}
		PageInfo pinfo = new PageInfo<>();
		pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Jcsj_police_resourc> pageinfo = (PageInfo<Jcsj_police_resourc>) pmService.selectByJWpageList(map, pinfo);
			
		return pageinfo;

	}
	
	/**
	 * 查询GPS和安装车辆信息
	 * @return
	 */
	@RequestMapping("selectByGpsCar")
	public PageInfo<Jcsj_police_resourc> selectByGpsCar(@RequestBody Map<String, Object> map) {
		PageInfo pinfo = new PageInfo<>();
		pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Jcsj_police_resourc> pageinfo = (PageInfo<Jcsj_police_resourc>) pmService.selectByGpsCarpageList(map, pinfo);
			
		return pageinfo;

	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping("byindex")
	public PageInfo<Jcsj_Police_Res_Person> selectByPolice(@RequestBody Map<String, Object> map,HttpServletRequest request) {
		// 当前用户的部门 用于部门权限设置
		HttpSession session = request.getSession();
		Map<String,Object> map1 = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String deptCode = map1.get("sypi_dept_code")==null?null:map1.get("sypi_dept_code").toString();
		map.put("dept", deptCode);//当前用户部门code 用于部门权限 
		PageInfo pinfo = new PageInfo<>();
		pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Jcsj_Police_Res_Person> pageinfo = (PageInfo<Jcsj_Police_Res_Person>) pmService
				.selectByPolicepageList(map, pinfo);
		return pageinfo;

	}

	/**
	 * 新增警务资源管理
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("add")
	public String addResourc(@RequestBody Map<String, Object> map) {
		
//		if(!("4".equals(map.get("resources_type").toString()))){
			//判断号牌，设备编号是否存在
			List<Jcsj_police_resourc> selectDeviceCode = pmService.selectDeviceCode(map);
			if(selectDeviceCode.size()==0){
				Integer isAdd = pmService.insetResourc(map);
				if(isAdd>0){
					return	"{\"result\":\"成功\"}";
				}else{
					return	"{\"result\":\"失败\"}";
				}
			}else{
				
				return	"{\"result\":\"存在\"}";
			}
//		}else{
//			Integer isAdd = pmService.insetResourc(map);
//			if(isAdd>0){
//				return	"{\"result\":\"成功\"}";
//			}else{
//				return	"{\"result\":\"失败\"}";
//			}
//		}
		
		
	}

	@RequestMapping("addpolice")
	public String addPolicePerson(@RequestParam Map<String, Object> map,MultipartFile file) {
		
		List<Jcsj_Police_Res_Person> selectPoliceCode = pmService.selectPoliceCode(map);
		List<Jcsj_Police_Res_Person> selectSfzhm = pmService.selectSfzhm(map);
		if(selectPoliceCode.size()==0&&selectSfzhm.size()==0){
			//判断上传的图片是否存在
			if(file!=null) {
				String fileUploadService = FileUtil.FileUploadService(file);//上传图片并且返回图片地址
				if("false".equals(fileUploadService)) {
					return "{\"result\":\"图片上传失败\"}";
				}
				map.put("pic", fileUploadService);
			}
			Integer isAdd = pmService.insertPolicePerson(map);
			if(isAdd>0){
				return	"{\"result\":\"成功\"}";
			}else{
				return	"{\"result\":\"失败\"}";
			}
		}else{
			if(selectPoliceCode.size()>0){
				return	"{\"result\":\"编号存在\"}";
			}else{
				return	"{\"result\":\"身份证存在\"}";
			}
			
		}
		
		
	}

	/**
	 * 修改警务资源管理
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("update")
	public String updateResourc(@RequestBody HashMap<String, Object> map) {
		String newCodeString = map.get("codeString").toString();
		String[] newCodeArray = newCodeString.split(",");
		map.put("arrays", newCodeArray);
		//GPS信息插入或者警车信息插入
		if(map.get("flag")!=null&&("1".equals(map.get("flag").toString())||"2".equals(map.get("flag").toString()))){
			if((map.get("car_id")!=null&&!("".equals(map.get("car_id").toString())))||(map.get("gps_id")!=null&&!("".equals(map.get("gps_id").toString())))){
				List<Jcsj_P_R_Relation> selectCheck = pmService.selectDataCheck(map);
				if(selectCheck.size()>0){
					return "{\"result\":\"存在\"}";
				}
			}
			
		}
		
		if(map.get("array")!=null&&((ArrayList)map.get("array")).size()>0){
			List<Jcsj_P_R_Allot> selectPoliceByCheck = pmService.selectPoliceByCheck(map);
			if(selectPoliceByCheck.size()==0){
				if(map.get("resources_type")!=null){
					if("8".equals(map.get("resources_type").toString())){
						map.put("resources_type", "5");
					}else if("3".equals(map.get("resources_type").toString())){
						map.put("resources_type", "6");
					}else if("6".equals(map.get("resources_type").toString())){
						map.put("resources_type", "4");
					}else if("7".equals(map.get("resources_type").toString())){
						map.put("resources_type", "3");
					}else if("10".equals(map.get("resources_type").toString())){
						map.put("resources_type", "8");
					}else if("9".equals(map.get("resources_type").toString())){
						map.put("resources_type", "7");
					}
				}
				Integer isUpdate = pmService.updateResourc(map);
				if(isUpdate>0){
					return "{\"result\":\"成功\"}";
				}else{
					return "{\"result\":\"失败\"}";
				}
			}else{
				return "{\"result\":\"人员存在\"}";
			}
		}else{
			Integer isUpdate = pmService.updateResourc(map);
			if(isUpdate>0){
				return "{\"result\":\"成功\"}";
			}else{
				return "{\"result\":\"失败\"}";
			}
		}
		
		
		
	
	}

	@RequestMapping("updatepolice")
	public String updatePolicePerson(@RequestParam Map<String, Object> map,MultipartFile file) {

		List<Jcsj_Police_Res_Person> selectPoliceCode = pmService.selectPoliceCode(map);
		List<Jcsj_Police_Res_Person> selectSfzhm = pmService.selectSfzhm(map);
		if(selectPoliceCode.size()==0&&selectSfzhm.size()==0){
			//判断上传的图片是否存在
			if(file!=null) {
				String fileUploadService = FileUtil.FileUploadService(file);//上传图片并且返回图片地址
				map.put("pic", fileUploadService);
				if("false".equals(fileUploadService)) {
					return "{\"result\":\"图片上传失败\"}";
				}
			}else if("true".equals(map.get("flag").toString())&&file==null){
				map.put("pic", "");
			}
			Integer isAdd = pmService.updatePolicePerson(map);
			if(isAdd>0){
				return "{\"result\":\"成功\"}";
			}else{
				return "{\"result\":\"失败\"}";
			}
		}else{
			if(selectPoliceCode.size()>0){
				return "{\"result\":\"编号存在\"}";
			}else{
				return "{\"result\":\"身份证号存在\"}";
			}
			
		}
		
	}

	/**
	 * 删除警务资源管理
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("delete")
	public Integer deleteResourc(@RequestBody Map<String, Object> map) {
		Integer isDelete = pmService.deleteResourc(map);
		return isDelete;
	}
	
	/**
	 * 删除民警和辅警
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("deletePerson")
	public String deletePerson(@RequestBody Map<String, Object> map) {
		Integer isDelete = pmService.deletePerson(map);
		if(isDelete>0){
			return	"{\"result\":\"删除成功\"}";
		}else{
			return	"{\"result\":\"删除失败\"}";
		}

	}
	
	@RequestMapping("deleteAll")
	public String deletePersonAll(@RequestBody Map<String, Object> map){
		if("4".equals(map.get("flag").toString())||"5".equals(map.get("flag").toString())||"11".equals(map.get("flag").toString())){
			Integer deleteMJ = pmService.deleteMJ(map);
			
			if(deleteMJ>0){
				return	"{\"result\":\"删除成功\"}";
			}else{
				return	"{\"result\":\"删除失败\"}";
			}
		}else{
				Integer isDeleteAll = pmService.deletePersonAll(map);
				if(isDeleteAll>0){
					return	"{\"result\":\"删除成功\"}";
				}else{
					return	"{\"result\":\"删除失败\"}";
				}
		}
		
	}

	/**
	 * 警务资源管理人员
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("police")
	public List<HashMap<String, Object>> selectPolice(@RequestBody Map<String,Object> map) throws JsonProcessingException{
		List<Jcsj_Police_Res_Person> isPolice = pmService.selectPolice(map);
         List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
         for (Jcsj_Police_Res_Person police : isPolice) {
        	 HashMap<String, Object> modelMap = new HashMap<String, Object>();
        	 modelMap.put("title", police.getXm());
        	 modelMap.put("key", police.getId());
        	 modelMap.put("selectable", false);
        	 modelMap.put("policeInfo", police);
        	 modelMap.put("isLeaf", true);
        	 listmap.add(modelMap);
 		}
         return listmap;
	}

	/**
	 * 基础数据
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("selectlist")
	public Map<String, Object> selectList(@RequestBody Map<String,Object> map) {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("craTypeList", pmService.selectSysFrmCode("C002"));// 车辆类型
		modelMap.put("craPList", pmService.selectSysFrmCode("C110"));// 车辆品牌
		modelMap.put("commitList", pmService.selectSysFrmCode("JW01"));// 保险公司
		modelMap.put("actionList", pmService.selectSysFrmCode("G999"));// 具备功能
		modelMap.put("carGPS", pmService.selectCarGPS());
		modelMap.put("clytList", pmService.selectSysFrmCode("JW02"));// 车辆用途
		modelMap.put("zjList", pmService.selectSysFrmCode("JW07"));// 职级
		modelMap.put("zwList", pmService.selectSysFrmCode("JW06"));// 职务
		modelMap.put("ywgwList", pmService.selectSysFrmCode("JW04"));// 业务岗位
		modelMap.put("xbList", pmService.selectSysFrmCode("SY01"));// 性别
		modelMap.put("bzlxList", pmService.selectSysFrmCode("JW05"));// 编制类型
		modelMap.put("rylxlxList", pmService.selectSysFrmCode("JW03"));// 人员类型
		return modelMap;
	}

	/**
	 * 具备功能选中
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("selectHave")
	public List<Jcsj_P_R_Have> selectCheckHave(@RequestBody Map<String, Object> map) {
		List<Jcsj_P_R_Have> listHave = pmService.selectHave(map);
		return listHave;
	}

	/**
	 * 警员默认选中
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("selectCheck")
	public List<HashMap<String, Object>> selectCheckPolice(@RequestBody Map<String, Object> map) {
		List<Jcsj_Police_Res_Person> isPolice = pmService.selectPoliceCheck(map);
        List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
        for (Jcsj_Police_Res_Person police : isPolice) {
       	 HashMap<String, Object> modelMap = new HashMap<String, Object>();
       	 if(police!=null){
       		modelMap.put("title", police.getXm());
          	 modelMap.put("key", police.getId());
          	 modelMap.put("selectable", true);
          	 modelMap.put("isLeaf", true);
          	modelMap.put("checked", true);
          	modelMap.put("policeInfo", police);
          	 listmap.add(modelMap);
       	 }
       	 
		}
        return listmap;
	}

	/**
	 * 管理部门树
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptinfo")
	public String deptinfo(HttpServletRequest request) throws JsonProcessingException {
		// 当前用户的部门 用于部门权限设置
		HttpSession session = request.getSession();
		Map<String,Object> map1 = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String deptCode = map1.get("sypi_dept_code")==null?null:map1.get("sypi_dept_code").toString();
//		map.put("dept", deptCode);//当前用户部门code 用于部门权限 
		// 顶级部门
		List<DeptInfo> departinfo = pmService.querydeptByCode(deptCode);
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
			map.put("key", depart_info.getDept_pk());
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
			List<DeptInfo> list = pmService.depart_infolist(depart_info.getDept_pk());
			if (list.size() != 0) {
				depart_info.setChildren(list);
				departinfodg(list);
			}
		}
		return departinfo;
	}

	
	
	/**
	 * 管理部门树
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptinf")
	public String deptinfos() throws JsonProcessingException {
		// 顶级部门
		List<Depart_info> departinfo = pmService.depart_infolists();
		List<Depart_info> list = new ArrayList<>();
		List<Depart_info> list1 = null;
		List<Depart_info> list2 = null;
		for (int i = 0; i < departinfo.size(); i++) {
			list1 = new ArrayList<>();
			list2 = new ArrayList<>();
			Depart_info depart_info = departinfo.get(i);
			String dept_code = depart_info.getDept_code();
			String dept_name = depart_info.getDept_codename();
			int index = -1;
			for (int j = 0; j < list.size(); j++) {
				if (dept_code.equals(list.get(j).getKey())) {
					index = j;
				}
			}if (index == -1) {
				depart_info.setKey(dept_code);
				depart_info.setTitle(dept_name);
				list.add(depart_info);
			}
			String type = depart_info.getResources_type();
			String typename = depart_info.getResources_type_name();
			Depart_info depart_info1 = new Depart_info();
			depart_info1.setKey(type);
			depart_info1.setTitle(typename);
			list1.add(depart_info1);
		
			String cars = depart_info.getCar_num();
			String[] cars1 = cars.split(",");
			for (int k = 0; k < cars1.length; k++) {
				Depart_info depart_info2 = new Depart_info();
				depart_info2.setKey(cars1[k]);
				depart_info2.setTitle(cars1[k]);
				depart_info2.setIsLeaf(true);
				list2.add(depart_info2);
			}
			list1.get(0).setChildren(list2);
			if (index != -1) {
				list2 = list.get(index).getChildren();
				list1.addAll(list2);
				list.get(index).setChildren(list1);
			}else{
				list.get(i).setChildren(list1);
			}
			
		}

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		map.put("children", list);
		map.put("key","1");
		map.put("title", "德阳交警支队");
		String json = mapper.writeValueAsString(map);
		return json;
	}
	
	
	@RequestMapping("deptinfss")
	public String deptinfossss() throws JsonProcessingException {
		// 顶级部门
		List<Depart_info> departinfo = pmService.depart_infolistss();
		List<Depart_info> list = new ArrayList<>();
		List<Depart_info> list1 = null;
		List<Depart_info> list2 = null;
		for (int i = 0; i < departinfo.size(); i++) {
			list1 = new ArrayList<>();
			list2 = new ArrayList<>();
			Depart_info depart_info = departinfo.get(i);
			String dept_code = depart_info.getDept_code();
			String dept_name = depart_info.getDept_codename();
			int index = -1;
			for (int j = 0; j < list.size(); j++) {
				if (dept_code.equals(list.get(j).getKey())) {
					index = j;
				}
			}if (index == -1) {
				depart_info.setKey(dept_code);
				depart_info.setTitle(dept_name);
				list.add(depart_info);
			}
		
		
			String cars = depart_info.getDevice_type();
			if (cars.length() <=0){
				continue;
			}
			String[] cars1 = cars.split(",");
			for (int k = 0; k < cars1.length; k++) {
				Depart_info depart_info2 = new Depart_info();
				depart_info2.setKey(cars1[k]);
				depart_info2.setTitle(cars1[k]);
				depart_info2.setIsLeaf(true);
				list2.add(depart_info2);
			}
			
			if (index != -1) {
				list2 = list.get(index).getChildren();
				
				list.get(index).setChildren(list2);
			}else{
				list.get(i).setChildren(list2);
			}
			
		}

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		map.put("children", list);
		map.put("key","1");
		map.put("title", "德阳交警支队");
		String json = mapper.writeValueAsString(map);
		return json;
	}
	
	

	
	
//	/**
//	 * 管理部门树
//	 * @return
//	 * @throws JsonProcessingException
//	 */
//	@RequestMapping("deptTree")
//	public String deptTree() throws JsonProcessingException {
//		// 顶级部门
//		List<Depart_info> departinfo = pmService.deptTree(null);
//		ObjectMapper mapper = new ObjectMapper();
//		List<Depart_info> list = departinfodgs(departinfo);
//		String json = mapper.writeValueAsString(getdiwfdidians(list));
//		return json.substring(1, json.length() - 1);
//	}

//	@SuppressWarnings("null")
//	public List<HashMap<String, Object>> getdiwfdidians(List<Depart_info> list) {
//		
//		
//		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
//		for (Depart_info depart_info : list) {
//			
//			if((depart_info.getChildren()==null||depart_info.getChildren().size()==0)&&("false").equals(depart_info.getFlag().toString())){
//				continue;
//			}
//				HashMap<String, Object> map = new HashMap<String, Object>();
//				map.put("title", depart_info.getName());
//				map.put("key", depart_info.getDept_pk());
//				if("true".equals(depart_info.getFlag())){
//					map.put("selectable", true);
//				}else{
//					map.put("selectable", false);
//				}
//				
//				map.put("isLeaf", depart_info.getIsLeaf());
//				if (null != depart_info.getChildren()) {// 下级
//
//					map.put("children", getdiwfdidians(depart_info.getChildren()));
//					listmap.add(map);
//				} else {
//					listmap.add(map);
//				}
//			}
//		return listmap;
//	}

//	public List<Depart_info> departinfodgs(List<Depart_info> departinfo) {
//		
//		for (Depart_info depart_info : departinfo) {
//			// 部门
//			List<Depart_info> list = pmService.deptTree(depart_info.getDept_pk());
//			//查询各个部门下的gps
//			List<Depart_info> list1 = pmService.selectGps(depart_info.getDept_pk());
//				if (list1.size() != 0) {
//					depart_info.setChildren(list1);
//					depart_info.getChildren().addAll(list);
//					departinfodgs(list);
//				}else{
//					
//				}
//				
//		}
		
		/*for (int i =0; i < departinfo.size(); i++){
			// 部门
			List<Depart_info> list = pmService.deptTree(departinfo.get(i).getDept_pk());
			//查询各个部门下的gps
			List<Depart_info> list1 = pmService.selectGps(departinfo.get(i).getDept_pk());
				if (list1.size() != 0){
					departinfo.get(i).setChildren(list1);
					departinfo.get(i).getChildren().add(list.get(i));
					
				}else {
					departinfo.get(i).setChildren(null);
				}
		
		}*/
		
//		
//		return departinfo;
//	}
	
	
	
	
	
	
	/**
	 * 警车树
	 * @return
	 * @throws JsonProcessingException
	 */
//	@RequestMapping("carTree")
//	public String carTree() throws JsonProcessingException {
//		// 顶级部门
//		List<Depart_info> departinfo = pmService.deptTree(null);
//		ObjectMapper mapper = new ObjectMapper();
//		List<Depart_info> list = carinfodgs(departinfo);
//		String json = mapper.writeValueAsString(getdiwfdidianss(list));
//		return json.substring(1, json.length() - 1);
//	}

//	public List<HashMap<String, Object>> getdiwfdidianss(List<Depart_info> list) {
//		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
//		for (Depart_info depart_info : list) {
//			HashMap<String, Object> map = new HashMap<String, Object>();
//			map.put("title", depart_info.getName());
//			map.put("key", depart_info.getDept_pk());
//			if("true".equals(depart_info.getFlag())){
//				map.put("selectable", true);
//			}else{
//				map.put("selectable", false);
//			}
//			
//			map.put("isLeaf", depart_info.getIsLeaf());
//			if (null != depart_info.getChildren()) {// 下级
//
//				map.put("children", getdiwfdidianss(depart_info.getChildren()));
//				listmap.add(map);
//			} else {
//				listmap.add(map);
//			}
//		}
//		return listmap;
//	}

//	public List<Depart_info> carinfodgs(List<Depart_info> departinfo) {
//		
//		for (int i =0; i < departinfo.size(); i++){
//			// 部门
//			List<Depart_info> list = pmService.deptTree(departinfo.get(i).getDept_pk());
//			//查询各个部门下的gps
//			List<Depart_info> list1 = pmService.selectPoliceCar(departinfo.get(i).getDept_pk());
//				if (list1.size() != 0){
//					departinfo.get(i).setChildren(list1);
//					departinfo.get(i).getChildren().add(list.get(i));
//				}else {
//					departinfo.get(i).setChildren(null);
//				}
//		
//		}
//		
//		return departinfo;
//	}
	
	/**
	 * 查询关联的gps或者警车
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("selectCheckGps")
	List<Jcsj_P_R_Relation> selectCheck(@RequestBody HashMap<String, Object> map){
		List<Jcsj_P_R_Relation> selectCheck = pmService.selectCheck(map);
		return selectCheck;
		
	}
	
	
	
	/**
	 * 警车树
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("carTreeAll")
	public String carTreeAll() throws JsonProcessingException {
		// 顶级部门
		List<Depart_info> departinfo = pmService.deptTree(null);
		ObjectMapper mapper = new ObjectMapper();
		List<Depart_info> list = carinfodgsAll(departinfo);
		String json = mapper.writeValueAsString(getdiwfdidianssAll(list));
		return json.substring(1, json.length() - 1);
	}

	public List<HashMap<String, Object>> getdiwfdidianssAll(List<Depart_info> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			
			if("true".equals(depart_info.getFlag())){
				map.put("key", depart_info.getDept_pk());
				map.put("selectable", true);
			}else{
				map.put("key", depart_info.getDept_code());
				map.put("selectable", false);
			}
			
			map.put("isLeaf", depart_info.getIsLeaf());
			if (null != depart_info.getChildren()) {// 下级

				map.put("children", getdiwfdidianssAll(depart_info.getChildren()));
				listmap.add(map);
			} else {
				listmap.add(map);
			}
		}
		return listmap;
	}

	public List<Depart_info> carinfodgsAll(List<Depart_info> departinfo) {
		for (Depart_info depart_info : departinfo) {
			// 部门
			List<Depart_info> list = pmService.deptTree(depart_info.getDept_pk());
			//查询各个部门下的gps
			List<Depart_info> list1 = pmService.selectPoliceCarAll(depart_info.getDept_pk());
			if (list1.size() != 0) {
				depart_info.setChildren(list1);
			}
			if (list.size() != 0) {
				depart_info.getChildren().addAll(list);
				carinfodgsAll(list);
			}
		}
		return departinfo;
	}
	
	/**
	 * GPS树
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptTreeAll")
	public String deptTreeAll() throws JsonProcessingException {
		// 顶级部门
		List<Depart_info> departinfo = pmService.deptTree(null);
		ObjectMapper mapper = new ObjectMapper();
		List<Depart_info> list = departinfodgsAll(departinfo);
		String json = mapper.writeValueAsString(getdiwfdidiansAll(list));
		return json.substring(1, json.length() - 1);
	}

	public List<HashMap<String, Object>> getdiwfdidiansAll(List<Depart_info> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			
			if("true".equals(depart_info.getFlag())){
				map.put("selectable", true);
				map.put("key", depart_info.getDept_pk());
			}else{
				map.put("key", depart_info.getDept_code());
				map.put("selectable", false);
			}
			
			map.put("isLeaf", depart_info.getIsLeaf());
			if (null != depart_info.getChildren()) {// 下级

				map.put("children", getdiwfdidiansAll(depart_info.getChildren()));
				listmap.add(map);
			} else {
				listmap.add(map);
			}
		}
		return listmap;
	}

	public List<Depart_info> departinfodgsAll(List<Depart_info> departinfo) {
		for (Depart_info depart_info : departinfo) {
			// 部门
			List<Depart_info> list = pmService.deptTree(depart_info.getDept_pk());
			//查询各个部门下的gps
			List<Depart_info> list1 = pmService.selectGpsAll(depart_info.getDept_pk());
			if (list1.size() != 0) {
				depart_info.setChildren(list1);
			}
			if (list.size() != 0) {
				depart_info.getChildren().addAll(list);
				departinfodgsAll(list);
			}
		}
		return departinfo;
	}
	
	
	/**
	 * 管理部门树code
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptinfoCode")
	public String deptinfoCode(HttpServletRequest request) throws JsonProcessingException {
			// 当前用户的部门 用于部门权限设置
			HttpSession session = request.getSession();
			Map<String,Object> map1 = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
			String deptCode = map1.get("sypi_dept_code")==null?null:map1.get("sypi_dept_code").toString();
//			map.put("dept", deptCode);//当前用户部门code 用于部门权限 
			// 顶级部门
		// 顶级部门
		List<DeptInfo> departinfo = pmService.querydeptByCode(deptCode);
		ObjectMapper mapper = new ObjectMapper();
		List<DeptInfo> list = departinfodgCode(departinfo);
		String json = mapper.writeValueAsString(getdiwfdidianCode(list));
		return json.substring(1, json.length() - 1);
	}
	
	public List<HashMap<String, Object>> getdiwfdidianCode(List<DeptInfo> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (DeptInfo depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_code());
			map.put("selectable", depart_info.getSelectable());
			map.put("isLeaf", depart_info.getIsLeaf());
			if (null != depart_info.getChildren()) {// 下级

				map.put("children", getdiwfdidianCode(depart_info.getChildren()));
				listmap.add(map);
			} else {
				listmap.add(map);
			}
		}
		return listmap;
	}

	public List<DeptInfo> departinfodgCode(List<DeptInfo> departinfo) {
		for (DeptInfo depart_info : departinfo) {
			// 部门
			List<DeptInfo> list = pmService.depart_infolist(depart_info.getDept_pk());
			if (list.size() != 0) {
				depart_info.setChildren(list);
				departinfodgCode(list);
			}
		}
		return departinfo;
	}
	
	/**
	 * 管理部门=>GPS设备树
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptTree")
	public HashMap<String,Object> deptTree1() throws JsonProcessingException {
		// 部门设备Tree
		HashMap<String, Object> initDeptDeviceTree = pmService.initDeptDeviceTree();
		return initDeptDeviceTree;
		
	}
	
	/**
	 * 管理部门=>警车树
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("carTree")
	public HashMap<String,Object> carTree() throws JsonProcessingException {
		// 部门设备Tree
		HashMap<String, Object> initDeptDeviceTree = pmService.initDeptCarTree();
		return initDeptDeviceTree;
		
	}
	
	/**
	 * 基础数据
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("selectBaseData")
	public Map<String, Object> selectBaseData(@RequestBody HashMap<String,Object> map) {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("mzList", pmService.selectSysFrmCode("JW08"));// 民族下拉框
		modelMap.put("zzmmList", pmService.selectSysFrmCode("JW09"));// 政治面貌
		return modelMap;
	}
	/**
	 * 籍贯联动
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("selectJg")
	public Map<String, Object> selectJg(@RequestBody HashMap<String,Object> map) {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		 map.put("fct_code", "JW10");//省市 父id为0的代表省
		modelMap.put("jgList", pmService.selectBaseDate(map));// 籍贯
		return modelMap;
	}
}
