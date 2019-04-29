package com.cist.dwqwkhcx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.dwqwkhcx.model.QWAppraiseFeedbackResponse;
import com.cist.dwqwkhcx.model.QwAssessmentAttachment;
import com.cist.dwqwkhcx.model.Qw_Opertion_Log;
import com.cist.dwqwkhcx.model.Qw_company;
import com.cist.dwqwkhcx.service.DwqwcxService;
import com.cist.frame.page.PageInfo;

@RestController
@RequestMapping("query")
public class DwqwcxController {

	@Autowired
	private DwqwcxService service;
	
	@RequestMapping("index")
	public PageInfo<Qw_company> selectCheckAll(@RequestBody Map<String, Object> map){
		PageInfo pInfo = new PageInfo();
		pInfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pInfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Qw_company> pageInfo = (PageInfo<Qw_company>)service.selectAllpageList(map, pInfo);
		return pageInfo;
	}
	
	@RequestMapping("list")
	public List<QwAssessmentAttachment> selectList(@RequestBody Map<String, Object> map){
		List<QwAssessmentAttachment> list = service.selectList(map);
		return list;
	}
	
	/**
	 * 查询勤务考核反馈详情
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("selectResponse")
	public List<QWAppraiseFeedbackResponse> selectResponse(@RequestBody Map<String, Object> map) {
		return service.selectResponse(map);
		
	}
	@RequestMapping("log")
	public List<Qw_Opertion_Log> selectLog(@RequestBody Map<String, Object> map){
		return service.selectLog(map);
	}
}
 