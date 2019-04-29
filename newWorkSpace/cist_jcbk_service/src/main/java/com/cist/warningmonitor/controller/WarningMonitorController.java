package com.cist.warningmonitor.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.earlywarning.model.WarningInfo;
import com.cist.earlywarning.service.EarlyWarningService;
import com.cist.frame.page.PageInfo;
import com.cist.warningmonitor.model.BackInfo;
import com.cist.warningmonitor.model.DeviceInfo;
import com.cist.warningmonitor.model.MonitorInfo;
import com.cist.warningmonitor.service.WarningMonitorService;


@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/warningmonitor")
public class WarningMonitorController {
	@Autowired
	private WarningMonitorService service;
	@Autowired
	private EarlyWarningService iservice;
	
	/**
	 * 基础数据合集查询
	 */
	@RequestMapping(value="basicData")
	public HashMap<String,Object> basicData() {
		HashMap<String, Object> modelMap=new HashMap<String, Object>();	
		modelMap.put("plateTypeList", service.plateTypeList());//号牌种类
		return modelMap;
	}
	/**
	 * 实时预警监控首页，预警信息查询
	 * @param map
	 */
	@RequestMapping("monitorinfoList")
    public PageInfo<MonitorInfo> monitorinfopageList(@RequestBody HashMap<String,Object> modelMap ){
    	PageInfo pinfo = new PageInfo();
	    pinfo.setPageNum(Integer.parseInt(modelMap.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(modelMap.get("pageSize").toString()));
    	PageInfo<MonitorInfo> list= (PageInfo<MonitorInfo>)service.monitorinfopageList(modelMap,pinfo);
    	for (int i = 0; i < list.getList().size(); i++) {
    		DeviceInfo jgdd = service.getRoadname(list.getList().get(i).getYjsb());
    		list.getList().get(i).setJgdd(jgdd.getRoad_name());
    		list.getList().get(i).setSbmc(jgdd.getDevice_name());
    		list.getList().get(i).setZt("1");
    		String hpzl_name = iservice.getHpzlname(list.getList().get(i).getHpzl());
    		list.getList().get(i).setHpzl_name(hpzl_name);
    		String ssbm_name = iservice.getSsbmname(list.getList().get(i).getSsbm());
    		list.getList().get(i).setSsbm_name(ssbm_name);
		}
		return list;
	}
	/**
	 * 详情查询
	 */
	@RequestMapping(value="backData")
	public BackInfo backData(@RequestBody HashMap<String,Object> map) {
		return service.backlist(map);
	}
}
