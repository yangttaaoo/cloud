package com.cist.interfaceapply.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cist.frame.page.PageInfo;
import com.cist.interfaceapply.model.DeptInfo;
import com.cist.interfaceapply.model.SjgxDevCompany;
import com.cist.interfaceapply.model.SjgxInterface;
import com.cist.interfaceapply.model.SjgxInterfaceList;
import com.cist.interfaceapply.model.SjgxInterfaceUseApply;
import com.cist.interfaceapply.model.VwDeptList;
import com.cist.interfaceapply.service.InterApplyService;

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
@RequestMapping("interfaceapply")
public class InterApplyController{
	
	@Autowired
	private InterApplyService service;
	
	/**
	 * 使用接口列表树
	 * 
	 * @return List<HashMap<String, Object>>
	 */
	@RequestMapping("InterfaceTree")
	public List<SjgxInterface> InterfaceTree(HttpServletRequest request) throws Exception{
		HashMap<String,Object> map=new HashMap<String, Object>();
		//接口列表树信息查询
	List<SjgxInterface> selectTInterface = service.selectTInterface(null);
//		List<HashMap<String, Object>> getmenu = getmenu(selectTInterface);
		return selectTInterface;
	}
	
	/**
	 * 查询结果转换为树所需数据结构
	 * 
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getmenu(List<SjgxInterface> selectTInterface){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (SjgxInterface sys : selectTInterface) {
			//列表树信息构造
			HashMap<String, Object> map=new HashMap();
			map.put("title", sys.getInterface_name());
			map.put("key", sys.getPk_id());
			map.put("info", sys);
			map.put("disableCheckbox",false);
			map.put("isLeaf", true);
			listmap.add(map);
		}
		return listmap;
	}
	
	/**
	 * 接口开发单位列表树
	 * 
	 * @return List<HashMap<String, Object>>
	 */
	@RequestMapping("devcompanyTree")
	public List<SjgxDevCompany> getToUsers(HttpServletRequest request) throws Exception{
		HashMap<String,Object> map=new HashMap<String, Object>();
		//接口列表树信息查询
	List<SjgxDevCompany> selectDevCompany = service.selectDevCompany(map);
//		List<HashMap<String, Object>> getmenu = getDevCompany(selectDevCompany);
		return selectDevCompany;
	}
	
	/**
	 * 查询结果转换为树所需数据结构
	 * 
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getDevCompany(List<SjgxDevCompany> selectDevCompany){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (SjgxDevCompany sys : selectDevCompany) {
			//接口开发列表树信息构造
			HashMap<String, Object> map=new HashMap();
			map.put("title", sys.getDev_comp_name());
			map.put("key", sys.getPk_id());
			map.put("disableCheckbox",false);
			map.put("isLeaf", true);
			listmap.add(map);
		}
		return listmap;
	}
	
	/**
	 * 新增接口使用申请
	 * 
	 * @return String
	 */
	@RequestMapping("save")
	public String save(@RequestBody HashMap<String,Object> map){
		Integer save = service.save(map);
		if(save>0)
		{
			
				return "{\"result\":\"保存成功\"}";
		}
		else{
				return "{\"result\":\"保存失败\"}";
			}
	
	}
	
	/**
	 * 首页分页条件查询接口使用申请列表
	 * 
	 * @return PageInfo<SjgxInterfaceUseApply>
	 */
	@RequestMapping("list")
	public PageInfo<SjgxInterfaceUseApply> select(@RequestBody HashMap<String,Object> map){
		try{	
		PageInfo pinfo = new PageInfo();
	    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<SjgxInterfaceUseApply> pageinfo=(PageInfo<SjgxInterfaceUseApply>)service.listpageList(map, pinfo);
		 return pageinfo;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 批量删除
	 * 
	 * @return Integer
	 */
	@RequestMapping(value ="delete")
	public String delete(@RequestParam("pk_id") String [] pk_id){
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
		modelMap.put("pk_id", pk_id);
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
	 * 更新
	 * 
	 * @return Integer
	 */
	@RequestMapping("update")
	public String update(@RequestBody HashMap<String,Object> map){
		Integer update = service.update(map);
		 if(update>0)//1表示删除成功返回的行数
			{
				return "{\"result\":\"更新成功\"}";
			}
			else{
				return "{\"result\":\"更新失败\"}";
			}
	
	}
	
	/**
	 * 首页查询条件下拉列表查询
	 * 
	 * @return HashMap<String,Object>
	 */
	@RequestMapping(value ="index")
	public HashMap<String,Object> selectDept(@RequestParam  HashMap<String,Object> map){
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
	     List<VwDeptList> selectDept = service.selectDept(map);
	     List<SjgxDevCompany> selectDevCompany = service.selectDevCompany(map);
	     modelMap.put("devCompanyList", selectDevCompany);
	     modelMap.put("deptList", selectDept);
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
}
