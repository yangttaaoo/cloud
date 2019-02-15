package com.cist.inspectiontalk.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.inspectiontalk.model.TalkInfo;
import com.cist.inspectiontalk.service.InspectionTalkService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/inspectiontalk")
public class InspectionTalkController {
	
	@Autowired
	private InspectionTalkService service;
	
	/**
	 * 巡检计划审核首页，巡检计划信息查询
	 * @param map
	 */
	@RequestMapping("instalklist")
    public PageInfo<TalkInfo> instalklist(@RequestBody HashMap<String,Object> modelMap ){
    	PageInfo pinfo = new PageInfo();
	    pinfo.setPageNum(Integer.parseInt(modelMap.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(modelMap.get("pageSize").toString()));
		modelMap.put("pk_id",1);
    	PageInfo<TalkInfo> list= (PageInfo<TalkInfo>)service.instalkpageList(modelMap,pinfo);
    	for(int i=0;i<list.getList().size();i++){
    		list.getList().get(i).setStart_time_end(list.getList().get(i).getStart_time().substring(0, 10)+"~"+list.getList().get(i).getEnd_time().substring(0, 10));
    	    if(list.getList().get(i).getFk_rapporteur_id()!=null){
    		String name = service.quebgr(list.getList().get(i).getFk_rapporteur_id());
    	    list.getList().get(i).setFk_rapporteir_name(name);
    	    }
    	}
    	return list;
	}
	/**
	 * 巡检计划确认
	 */
	@RequestMapping("talkqr")
	public int  talkqr(@RequestBody HashMap<String,Object> map){	
		int c = service.talkqr(map);
		return c;
	}
	/**
	 * 巡检计划报告
	 */
	@RequestMapping("talking")
	public int  talking(@RequestBody HashMap<String,Object> map){	
		map.put("bgr",1);
		int c = service.talking(map);
		return c;
	}
}
