package com.cist.controlCarEvacuate.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.businessconfig.bayonetapply.model.Jcbk_control_vehicle;
import com.cist.businessconfig.bayonetapply.service.BayonetApplyService;
import com.cist.controlCarEvacuate.service.ControlCarEvacuateService;
import com.cist.frame.page.PageInfo;

/**
 * 布控车辆撤控
 * 
 * @author 57150
 *
 */
@RestController
@RequestMapping("controlCarEvacuate")
public class ControlCarEvacuateController {
	@Autowired
	private BayonetApplyService bayonetApplyService;
	@Autowired
	private ControlCarEvacuateService service;

	/**
	 * 查询已经审核通过的布控车辆
	 * 
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("index")
	public PageInfo<Jcbk_control_vehicle> index(@RequestBody HashMap<String, Object> map, HttpServletRequest request) {
		map.put("bkzt", "1");
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		@SuppressWarnings("unchecked")
		PageInfo<Jcbk_control_vehicle> pageinfo = (PageInfo<Jcbk_control_vehicle>) bayonetApplyService
				.queryBayonetApplyinfopageList(map, info);
		return pageinfo;
	}

	/**
	 * 布控车辆撤控
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("evacuate")
	public int aduit(@RequestBody HashMap<String, Object> paramMap) {

		return service.ControlCarrEvacuate(paramMap);
	}
}
