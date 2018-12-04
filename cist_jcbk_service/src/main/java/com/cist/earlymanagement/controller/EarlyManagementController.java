package com.cist.earlymanagement.controller;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cist.earlymanagement.service.EarlyManagementService;
import com.cist.earlywarning.model.WarningInfo;
import com.cist.earlywarning.service.EarlyWarningService;
import com.cist.frame.page.PageInfo;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/earlymanagement")
public class EarlyManagementController {
	@Autowired
	private EarlyManagementService service;
	@Autowired
	private EarlyWarningService iservice;
	
	/**
	 * 实时预警处理首页，预警信息查询
	 * @param map
	 */
	@RequestMapping("earlyminfolist")
    public PageInfo<WarningInfo> earlyinfopageList(@RequestBody HashMap<String,Object> modelMap ){
    	PageInfo pinfo = new PageInfo();
	    pinfo.setPageNum(Integer.parseInt(modelMap.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(modelMap.get("pageSize").toString()));
    	PageInfo<WarningInfo> list= (PageInfo<WarningInfo>)service.earlyminfopageList(modelMap,pinfo);
    	for (int i = 0; i < list.getList().size(); i++) {
    		String hpzl_name = iservice.getHpzlname(list.getList().get(i).getHpzl());
    		list.getList().get(i).setHpzl_name(hpzl_name);
    		String ssbm_name = iservice.getSsbmname(list.getList().get(i).getSsbm());
    		list.getList().get(i).setSsbm_name(ssbm_name);
		}
		return list;
	}
}
