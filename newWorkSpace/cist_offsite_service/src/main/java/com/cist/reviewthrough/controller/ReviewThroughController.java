package com.cist.reviewthrough.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.model.TblOffeEvdiInfo;
import com.cist.offsite.invalidtrial.model.VwDevInfo;
import com.cist.reviewthrough.model.Creason;
import com.cist.reviewthrough.service.ReviewThroughService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/reviewthrough")
public class ReviewThroughController {
	
	@Autowired
	private ReviewThroughService service;
	
	/**
	 * 复审通过数据审核的多条件查询
	 */
	@RequestMapping(value="reviewThroughList")
	public PageInfo<TblOffeEvdiInfo> reviewThroughpageList(@RequestParam HashMap<String,Object> map) {
		try{	
		    PageInfo pinfo = new PageInfo();
		    pinfo.setPageNum(Integer.parseInt(map.get("pageNum").toString()));
			pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<TblOffeEvdiInfo> pageinfo = (PageInfo<TblOffeEvdiInfo>)service.reviewThroughpageList(map,pinfo);
			return pageinfo;
			}catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	/**
	 * 复审通过数据审核信息
	 */
	@RequestMapping("updatebywfpk")
	public Integer updateByWfpk(@RequestParam HashMap<String,Object> map) {
		try {
			Integer updateByWfpk = service.updateByWfpk(map);
			return updateByWfpk;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 作废原因
	 */
	@RequestMapping(value="selectbycreasoninfo")
	public List<Creason> selectByCReasonInfo() {
		return service.selectByCReasonInfo();
	}
}
