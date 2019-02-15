package com.cist.selectdve.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.dveallot.model.Vw_dev_info;
import com.cist.frame.page.PageInfo;
import com.cist.selectdve.service.SelectDveService;

@RestController
@RequestMapping("query")
public class SelectDveController {

	@Autowired
	private SelectDveService service;
	
	/**
	 * 查询分配详情
	 * @param map
	 * @return
	 */
	@RequestMapping("querylist")
	public PageInfo<Vw_dev_info> selectList(@RequestBody Map<String, Object> map){
		PageInfo info = new PageInfo<>();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));

		PageInfo<Vw_dev_info> pageInfo = (PageInfo<Vw_dev_info>)service.queryListpageList(map, info);
		return pageInfo;
	}
	
}
