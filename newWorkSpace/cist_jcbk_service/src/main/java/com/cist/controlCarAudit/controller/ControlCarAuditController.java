package com.cist.controlCarAudit.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.businessconfig.bayonetapply.model.Jcbk_control_vehicle;
import com.cist.businessconfig.bayonetapply.service.BayonetApplyService;
import com.cist.controlCarAudit.service.ControlCarAuditService;
import com.cist.frame.page.PageInfo;

/**
 * 布控车辆审核
 * 
 * @author 57150
 *
 */
@RestController
@RequestMapping("controlCarAudit")
public class ControlCarAuditController {
	@Autowired
	private BayonetApplyService bayonetApplyService;
	@Autowired
	private ControlCarAuditService service;

	/**
	 * 查询车辆状态未待审核的布控车辆
	 * 
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("index")
	public PageInfo<Jcbk_control_vehicle> index(@RequestBody HashMap<String, Object> map, HttpServletRequest request) {
		map.put("bkzt", "2");
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		@SuppressWarnings("unchecked")
		PageInfo<Jcbk_control_vehicle> pageinfo = (PageInfo<Jcbk_control_vehicle>) bayonetApplyService
				.queryBayonetApplyinfopageList(map, info);
		return pageinfo;
	}

	/**
	 * 审核布控车辆
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("aduit")
	public int aduit(@RequestBody HashMap<String, Object> paramMap) {

		return service.AuditControlCar(paramMap);
	}
}
