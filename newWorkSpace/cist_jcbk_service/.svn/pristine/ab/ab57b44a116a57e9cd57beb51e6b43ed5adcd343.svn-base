package com.cist.earlytrail.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.earlytrail.service.EarlyTrailService;
import com.cist.earlywarning.service.EarlyWarningService;
import com.cist.frame.page.PageInfo;
import com.cist.warningmonitor.model.DeviceInfo;
import com.cist.warningmonitor.model.MonitorInfo;
import com.cist.warningmonitor.service.WarningMonitorService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/earlytrail")
public class EarlyTrailController {
	@Autowired
	private WarningMonitorService iservice;
	@Autowired
	private EarlyTrailService service;
	@Autowired
	private EarlyWarningService eservice;
	
	
	/**
	 * 实时预警监控首页，预警信息查询
	 * @param map
	 */
	@RequestMapping("trailinfoList")
    public PageInfo<MonitorInfo> playbackinfopageList(@RequestBody HashMap<String,Object> modelMap ){
    	PageInfo pinfo = new PageInfo();
	    pinfo.setPageNum(Integer.parseInt(modelMap.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(modelMap.get("pageSize").toString()));
    	PageInfo<MonitorInfo> list= (PageInfo<MonitorInfo>)service.trailinfopageList(modelMap,pinfo);
    	for (int i = 0; i < list.getList().size(); i++) {
    		DeviceInfo jgdd = iservice.getRoadname(list.getList().get(i).getYjsb());
    		list.getList().get(i).setJgdd(jgdd.getRoad_name());
    		list.getList().get(i).setSbmc(jgdd.getDevice_name());
    		list.getList().get(i).setJd(jgdd.getLongitude());
    		list.getList().get(i).setWd(jgdd.getLatitude());
    		list.getList().get(i).setZt("1");
    		String hpzl_name = eservice.getHpzlname(list.getList().get(i).getHpzl());
    		list.getList().get(i).setHpzl_name(hpzl_name);
    		String ssbm_name = eservice.getSsbmname(list.getList().get(i).getSsbm());
    		list.getList().get(i).setSsbm_name(ssbm_name);
		}
		return list;
	}
}
