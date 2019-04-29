package com.cist.videopatrol.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
//		List<TBL_VIO_CRUISE_CONFIG> list = service.querycruiseconf(map);
//		HashMap<String,Object> map1 = new HashMap<>();
//		for (int i = 0; i < list.size(); i++) {
//			map1.put("dvc_pk", list.get(i).getDvc_pk());
//			 List<Tbl_Dev_Info> list1 = service.querydev(map1);
//			list.get(i).setDvc_name(list1.get(0).getDvc_name());
//			if("0".equals(list1.get(0).getDvc_status())) {
//				list.get(i).setZt("离线");
//			}else {
//				list.get(i).setZt("在线");
//			}
//			list.get(i).setDvc_admin_url(list1.get(0).getDvc_admin_url());
//			list.get(i).setDvc_dir(list1.get(0).getDvc_dir());
//			list.get(i).setDvc_ip(list1.get(0).getDvc_ip());
//			list.get(i).setDvc_chl(list1.get(0).getDvc_chl());
//			list.get(i).setDvc_user(list1.get(0).getDvc_user());
//			list.get(i).setDvc_pwd(list1.get(0).getDvc_pwd());
//			list.get(i).setDvc_port(list1.get(0).getDvc_port());
//			list.get(i).setDvc_rtsp(list1.get(0).getDvc_rtsp());
//			list.get(i).setDvc_rtmp(list1.get(0).getDvc_rtmp());
//			list.get(i).setDvc_http(list1.get(0).getDvc_http());
//		}
		List<TBL_VIO_CRUISE_CONFIG> list = service.queryinfo(map);
		for (int i = 0; i < list.size(); i++) {
			if("0".equals(list.get(i).getDvc_status())) {
				list.get(i).setZt("离线");
			}else if("1".equals(list.get(i).getDvc_status())) {
				list.get(i).setZt("在线");
			}
		}
		return list;
	}
}
