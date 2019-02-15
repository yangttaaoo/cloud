package com.cist.videopatrol.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.page.PageInfo;
import com.cist.patrolplan.model.SYS_CONFIG;
import com.cist.patrolplan.model.Sys_frm_code;
import com.cist.patrolplan.model.Tbl_Dev_Info;
import com.cist.patrolplan.service.PatrolplanService;
import com.cist.videopatrol.model.SYS_FRM_CODE;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CASE;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CONFIG;
import com.cist.videopatrol.service.VideoPatrolService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/videopatrol")
public class VideoPatrolController {
	@Autowired
	private VideoPatrolService service;
	@Autowired
	private PatrolplanService Pservice;
	
	/**
	 * 查询视频巡逻方案
	 * @param map
	 * @return
	 */
	@RequestMapping("/scheme")
	public List<TBL_VIO_CRUISE_CASE> querycruise(){
		HashMap<String, Object> map=new HashMap<>();
		 List<TBL_VIO_CRUISE_CASE> list = service.querycruise(map);
		return list;
	}
	/**
	 * 查询视频画面数量
	 * @return
	 */
	@RequestMapping("/videonum")
	public List<SYS_FRM_CODE> queryvideonum(){
		return service.queryvideonum(null);
	}
	/**
	 * 根据条件查询相关摄像机信息
	 * @param map
	 * @return
	 */
	@RequestMapping("/list")
	public List<TBL_VIO_CRUISE_CONFIG> querylist(@RequestBody HashMap<String,Object> map){
		List<TBL_VIO_CRUISE_CONFIG> list = service.queryinfo(map);
	
		return list;
	}
	/**
	 * 根据条件查询相关摄像机信息(分页)
	 * @param map
	 * @return
	 */
	@RequestMapping("/pagelist")
	public PageInfo<TBL_VIO_CRUISE_CONFIG> querypagelist(@RequestBody HashMap<String,Object> map){
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<TBL_VIO_CRUISE_CONFIG> list =(PageInfo<TBL_VIO_CRUISE_CONFIG>) service.queryinfopageList(map,info);
		return list;
	}
	
	/**
	 * 根据巡逻分类查询摄像机信息
	 * @param map
	 * @return
	 */
	@RequestMapping("/selectPatrol")
	public Map<String,Object> selectPatrol(@RequestBody HashMap<String,Object> map){
		Map<String,Object> modelMap=new HashMap<String,Object>();
/*		List<TBL_VIO_CRUISE_CASE> selectPatrol = service.selectPatrol(map);
		modelMap.put("xlList", selectPatrol);*/
		map.put("fct_code", SysBaseDataCode.SYS_XLFL);
		List<Sys_frm_code> selectBaseDate = Pservice.selectBaseDate(map);//查询巡逻方案分类
		modelMap.put("xlfl", selectBaseDate);
		if(selectBaseDate.size()>0) {
			map.put("vvc_patrol_type", selectBaseDate.get(0).getFc_code());
		}
		modelMap.put("xlfaList", service.selectPatrolList(map));
		map.put("configKey", "VIDEOINFO");
		map.put("syci_key", "GBVIDEOURL");
		SYS_CONFIG selectConfig = Pservice.selectConfig(map);//查询国标视频地址
		modelMap.put("config", selectConfig);
		modelMap.put("MapConfig", service.queryMineMapBaseConfig(map));//地图配置信息
		return modelMap;
	}
	/**
	 * 根据巡逻分类查询摄像机信息
	 * @param map
	 * @return
	 */
	@RequestMapping("/selectList")
	public Map<String,Object> selectList(@RequestBody HashMap<String,Object> map){
		Map<String,Object> modelMap=new HashMap<String,Object>();
		modelMap.put("xlfaList", service.selectPatrolList(map));
		return modelMap;
	}
	
	/**
	 * 根据巡逻分类查询摄像机信息
	 * @param map
	 * @return
	 */
	@RequestMapping("/selectGbip")
	public Map<String,Object> selectGbip(@RequestBody HashMap<String,Object> map){
		Map<String,Object> modelMap=new HashMap<String,Object>();
		map.put("configKey", "VIDEOINFO");
		map.put("syci_key", "GBVIDEOURL");
		SYS_CONFIG selectConfig = Pservice.selectConfig(map);//查询国标视频地址
		modelMap.put("config", selectConfig);
		return modelMap;
	}
}
