package com.cist.selectdve.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;

@Service(value="SelectDveServiceImpl")
public interface SelectDveService {

	/**
	 * 查询分配详情
	 * @param map
	 * @param pinfo
	 * @return
	 */
	Object queryListpageList(Map<String, Object> map,PageInfo pinfo);
	
}
