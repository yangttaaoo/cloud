package com.cist.messagequery.warningquery.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.messagequery.warningquery.model.WarningQuery;
import com.cist.messagequery.warningquery.service.WarningQueryService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/warningquery")
public class WarningQueryController {
	
	@Autowired
	private WarningQueryService service;
	@RequestMapping("queryallwarning")
	public PageInfo<WarningQuery> queryallwarning(@RequestBody HashMap<String,Object> map){
		WarningQuery war = new WarningQuery();
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        war.setKssj(calendar.getTime());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        war.setJssj(calendar.getTime());
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<WarningQuery> list = (PageInfo<WarningQuery>)service.queryallwarningpageList(war, info);
		for (int i = 0; i < list.getList().size(); i++) {
			if(list.getList().get(i).getTbet_type().equals("1")) {
				list.getList().get(i).setTbet_type_name("卡口");
			}else if(list.getList().get(i).getTbet_type().equals("2")) {
				list.getList().get(i).setTbet_type_name("电警");
			}
		}
		return list;
	}
	@RequestMapping("querypie")
	public List<WarningQuery> querypie(){
		WarningQuery war = new WarningQuery();
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        war.setKssj(calendar.getTime());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        war.setJssj(calendar.getTime());
		List<WarningQuery> list = service.queryallwarning(war);
		return list;
	}
}
