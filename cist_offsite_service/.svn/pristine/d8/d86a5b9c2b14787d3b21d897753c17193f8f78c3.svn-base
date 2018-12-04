package com.cist.reviewthrough.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.reviewthrough.model.Creason;

public interface ReviewThroughService {
	   /**
	    * 多条件查询复审通过数据审核
	    */
		Object reviewThroughpageList(HashMap<String,Object> map,PageInfo p);
		/**
		 * 更新复审通过数据审核
		 */
		Integer updateByWfpk(HashMap<String,Object> map);
		/**
		 * 作废原因
		 */
		List<Creason> selectByCReasonInfo();
}
