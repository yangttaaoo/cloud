package com.cist.carParkPath.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.businessconfig.bayonetapply.model.Jcbk_control_vehicle;
import com.cist.businessconfig.bayonetapply.model.Sys_frm_code;
import com.cist.businessconfig.bayonetapply.service.BayonetApplyService;
import com.cist.carParkPath.service.CarParkPathService;
import com.cist.frame.page.PageInfo;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 车辆停车轨迹查询
 * 
 * @author 57150
 *
 */
@RestController
@RequestMapping("carParkPath")
public class CarParkPathController {
	@Autowired
	private CarParkPathService service;
	@Autowired
	private BayonetApplyService bayonetApplyService;

	/**
	 * 初始化查询车辆停车轨迹记录列表的查询条件参数
	 * 
	 * @param paramMap
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("initIndexQueryParam")
	public HashMap<String, Object> initIndexQueryParam(@RequestBody HashMap<String, Object> paramMap)
			throws JsonProcessingException {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		paramMap.put("fct_code", "C001");// 号牌种类
		List<Sys_frm_code> hpzl = bayonetApplyService.querySys_frm_code(paramMap);
		resultMap.put("hpzl", hpzl);

		paramMap.put("fct_code", "C002");// 车辆类型
		List<Sys_frm_code> cllx = bayonetApplyService.querySys_frm_code(paramMap);
		resultMap.put("cllx", cllx);
		resultMap.putAll(service.initAdministrativeAreasTree());
		return resultMap;

	}

	/**
	 * 查询车辆停车轨迹记录
	 * 
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("index")
	public PageInfo<Jcbk_control_vehicle> index(@RequestBody HashMap<String, Object> map, HttpServletRequest request) {
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		@SuppressWarnings("unchecked")
		PageInfo<Jcbk_control_vehicle> pageinfo = (PageInfo<Jcbk_control_vehicle>) service.queryCarParkPathpageList(map,
				info);
		return pageinfo;
	}
}
