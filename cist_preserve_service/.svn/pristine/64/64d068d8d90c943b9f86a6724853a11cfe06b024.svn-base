package com.cist.alarm.logquery.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.alarm.logquery.model.Alarm_log;
import com.cist.alarm.logquery.service.LogService;
import com.cist.frame.page.PageInfo;

@RestController
@RequestMapping("logquery")
public class LogController {
	@Autowired
	private LogService service;

	@RequestMapping("/all")
	public PageInfo<Alarm_log> select(@RequestBody HashMap<String, Object> map) {
		try {
			PageInfo page = new PageInfo();
			page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<Alarm_log> pag = (PageInfo<Alarm_log>) service.selectDatapageList(map, page);
			return pag;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 删除所有数据
	 * 
	 * @param pk
	 * @return
	 */
	@RequestMapping("deleteAll")
	public Integer deleteAll(@RequestParam("pk") String[] pk) {
		Integer in = service.deleteAll(pk);
		return in;
	}

	/**
	 * 删除单条数据
	 */
	@RequestMapping("/deleteOne")
	public Integer deleteAll(@RequestParam String pk) {
		Integer te = Integer.parseInt(pk);
		Integer in = service.deleteOne(te);
		return in;
	}
}
