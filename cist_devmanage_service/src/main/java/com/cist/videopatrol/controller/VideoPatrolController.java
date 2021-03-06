package com.cist.videopatrol.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.patrolplan.model.Tbl_Dev_Info;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CASE;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CONFIG;
import com.cist.videopatrol.service.VideoPatrolService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/videopatrol")
public class VideoPatrolController {
	@Autowired
	private VideoPatrolService service;
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
}
