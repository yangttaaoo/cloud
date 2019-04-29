package com.cist.redinfo.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.page.PageInfo;
import com.cist.redinfo.model.RedInfo;
import com.cist.redinfo.model.Sys_frm_code;
import com.cist.redinfo.service.RedInfoService;
import com.cist.frame.utils.SysTempStoreUtils;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/red")
public class RedInfoController {
	@Resource
	private RedInfoService service;

	/**
	 * 查询红名单数据
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/selectred")
	public PageInfo<RedInfo> selectRed(@RequestBody HashMap<String, Object> map) {
		try {
			PageInfo page = new PageInfo();
			page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<RedInfo> info = (PageInfo<RedInfo>) service.selectRedInfopageList(map, page);	
			return info;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据主键查询红名单详情
	 */
	@RequestMapping("/bypk")
	public RedInfo selectBypk(@RequestBody Integer pk) {
		RedInfo info = service.selectByfk(pk);
		return info;
	}
	/**
	 * 查询车辆类型
	 */
	@RequestMapping("/car")
	public  List<Sys_frm_code> selectCar(){
		 List<Sys_frm_code> cars=service.selectCllx();
		return cars;
	}
}
