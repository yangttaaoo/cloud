package com.cist.dveallot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.dveallot.model.C_road_item;
import com.cist.dveallot.model.Jtyw_device_allot;
import com.cist.dveallot.model.Vw_dev_info;
import com.cist.dveallot.service.DveAllotService;
import com.cist.frame.page.PageInfo;
import com.cist.opsflow.model.Jtyw_company;
import com.cist.opsvdt.model.Jtyw_group;

@RestController
@RequestMapping("allot")
public class DveAllotController {
	
	@Autowired
	private DveAllotService allotService;
	
	
	/**
	 * 分配详情
	 * @param map
	 * @return
	 */
	/*@RequestMapping("queryinfo")
	public List<Vw_dev_info> selectInfo(Map<String, Object> map){
		return allotService.queryInfo(map);
	}*/
	
	/**
	 * 分配详情
	 * @param map
	 * @return
	 */
	@RequestMapping("queryinfo")
	public PageInfo<Vw_dev_info> selectInfo(@RequestBody Map<String, Object> map){
		PageInfo info = new PageInfo<>();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Vw_dev_info> pageInfo = (PageInfo<Vw_dev_info>)allotService.queryInfopageList(map,info);
		return pageInfo;
	}
	
	
	/**
	 * 所属道路
	 * @param map
	 * @return
	 */
	@RequestMapping("queryroad")
	public List<C_road_item> selectRoad(Map<String, Object> map){
		return allotService.queryRoad(map);
	}
	
	/**
	 * 分配详情
	 * @param map
	 * @return
	 */
	@RequestMapping("querylist")
	public List<Jtyw_device_allot> selectList(Map<String, Object> map){
		return allotService.querylist(map);
	}
	
	/**
	 * 分配详情
	 * @param map
	 * @return
	 */
	@RequestMapping("querycomp")
	public List<Jtyw_company> selectComp(Map<String, Object> map){
		return allotService.queryComp(map);
	}
	
	/**
	 * 分配详情
	 * @param map
	 * @return
	 */
	@RequestMapping("querygroup")
	public List<Jtyw_group> selectGroup(Map<String, Object> map){
		List<Jtyw_group> list = allotService.queryGroup(map);
		return list;
	}
	/**
	 * 提交设备
	 * @param map
	 * @return
	 */
	@RequestMapping("addlist")
	public Integer insertList(@RequestBody Map<String, Object> map){
		return allotService.addList(map);
	}
	
	/**
	 * 设备类型
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="devcode")
	public Map<String,Object> selectOne(@RequestBody HashMap<String,Object> map,HttpServletRequest request) {
		HashMap<String, Object> modelMap=new HashMap<String, Object>();	
		modelMap.put("devlist",allotService.selectDevList("M001"));
		return modelMap;
	}
	
	
}
