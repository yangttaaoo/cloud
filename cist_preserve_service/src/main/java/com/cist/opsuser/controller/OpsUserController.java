package com.cist.opsuser.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.opsflow.model.Jtyw_company;
import com.cist.opsuser.model.Jtyw_staff;
import com.cist.opsuser.service.OpsUserService;
import com.cist.opsvdt.model.Jtyw_group;

@RestController
@RequestMapping("opsuser")
public class OpsUserController {
	
	@Autowired
	private OpsUserService opsUserService;
	
	/**
	 * 维护单位管理详情
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("index")
	public PageInfo<Jtyw_staff> selectAll(@RequestBody HashMap<String, Object> map){
		PageInfo info = new PageInfo<>();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Jtyw_staff> pageInfo = (PageInfo<Jtyw_staff>)opsUserService.queryAllpageList(map, info);
		return pageInfo;
	}
	
	/**
	 * 用户基本详情
	 * @param map
	 * @return
	 */
	@RequestMapping("userlist")
	public List<Jtyw_company> selectCorp( Map<String, Object> map){
		return opsUserService.queryUser(map);
	}
	
	/**
	 * 用户基本详情
	 * @param map
	 * @return
	 */
	@RequestMapping("grouplist")
	public List<Jtyw_group> selectGroup( Map<String, Object> map){
		return opsUserService.queryGroup(map);
	}
	
	/**	
	 * 修改维护单位管理详情
	 * @param map
	 * @return
	 */
	@RequestMapping("update")
	public Integer updateOps(@RequestBody Map<String, Object> map){
		return opsUserService.updateOps(map);
	}
	
	/**
	 * 删除维护单位管理详情
	 * @param map
	 * @return
	 */
	@RequestMapping("delete")
	public Integer deleteOps(@RequestBody Map<String, Object> map){
		return opsUserService.deleteOps(map);
	}
	
	/**
	 * 添加维护单位管理详情
	 * @param map
	 * @return
	 */
	@RequestMapping("insert")
	public Integer add(@RequestBody Map<String, Object> map){
		return opsUserService.insertOps(map);
	}
	
	/**
	 * 批量删除维护单位管理详情
	 * @param map
	 * @return
	 */
	@RequestMapping("deletewfxws")
	   public Integer deleteAll(@RequestParam("pk")  String[] pk){
		  Integer in=opsUserService.deleteAll(pk);
		  return in;
	   }
  
}
