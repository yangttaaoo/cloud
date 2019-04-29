package com.cist.holidays.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.holidays.model.Holidays;
import com.cist.holidays.service.HolidaysService;

@RestController
@RequestMapping("holidays")
public class HolidaysController {
	@Autowired
	private HolidaysService service;

	@RequestMapping("queryList")
	public PageInfo<Holidays> queryList(@RequestBody HashMap<String, Object> paramMap) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		pageInfo.setPageNum(Integer.parseInt(paramMap.get("currentPage").toString()));
		PageInfo<Holidays> querypageList = (PageInfo<Holidays>) service.querypageList(paramMap, pageInfo);
		return querypageList;
	}

	@RequestMapping("insert")
	public int insert(@RequestBody HashMap<String, Object> paramMap) {

		return service.insert(paramMap);

	}

	@RequestMapping("update")
	public int update(@RequestBody HashMap<String, Object> paramMap) {
		return service.update(paramMap);

	}

	@RequestMapping("delete")
	public int delete(@RequestBody HashMap<String, Object> paramMap) {
		List<Object> list = (List<Object>) paramMap.get("delIds");
		return service.delete(list);

	}
}
