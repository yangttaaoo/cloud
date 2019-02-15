package com.cist.opsflow.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.opsflow.model.DeptInfo;
import com.cist.opsflow.model.Jtyw_company;
import com.cist.opsflow.service.OpsFlowService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("opsflow")
public class OpsFlowController {

	@Autowired
	private OpsFlowService flowService;

	
	/**
	 * 维护单位管理详情
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("index")
	public PageInfo<Jtyw_company> selectAll(@RequestBody HashMap<String, Object> map){
		PageInfo info = new PageInfo<>();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Jtyw_company> pageInfo = (PageInfo<Jtyw_company>)flowService.queryAllpageList(map, info);
		return pageInfo;
	}
	
	/**	
	 * 修改维护单位管理详情
	 * @param map
	 * @return
	 */
	@RequestMapping("update")
	public Integer updateOps(@RequestBody Map<String, Object> map){
		return flowService.updateOps(map);
	}
	
	/**
	 * 删除维护单位管理详情
	 * @param map
	 * @return
	 */
	@RequestMapping("delete")
	public Integer deleteOps(@RequestBody Map<String, Object> map){
		return flowService.deleteOps(map);
	}
	
	/**
	 * 添加维护单位管理详情
	 * @param map
	 * @return
	 */
	@RequestMapping("insert")
	public Integer add(@RequestBody Map<String, Object> map){
		return flowService.insertOps(map);
	}
	
	/**
	 * 批量删除维护单位管理详情
	 * @param map
	 * @return
	 */
	@RequestMapping("deletewfxws")
	   public Integer deleteAll(@RequestParam("pk")  String[] pk){
		  Integer in=flowService.deleteAll(pk);
		return in;
	   }
  
	
	/**
	 * 管理部门树
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptinfo")
	public String deptinfo() throws JsonProcessingException {
		// 顶级部门
		List<DeptInfo> departinfo = flowService.depart_infolist(null);
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
			List<DeptInfo> list = flowService.depart_infolist(depart_info.getDept_pk());
			if (list.size() != 0) {
				depart_info.setChildren(list);
				departinfodg(list);
			}
		}
		return departinfo;
	}
	
}
