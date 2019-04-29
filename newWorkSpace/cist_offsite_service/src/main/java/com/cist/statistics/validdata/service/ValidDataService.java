package com.cist.statistics.validdata.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.cist.frame.page.PageInfo;
import com.cist.statistics.validdata.model.DataCount;
import com.cist.statistics.validdata.model.DataStatic;

public interface ValidDataService{
	/**
	 * 查询有效数据
	 * @param map
	 * @return
	 */
	Object selectValidpageList(HashMap<String, Object> map, PageInfo info);
	/**
	 * 查询数据到统计图中
	 */
	List<DataCount> selectData(@RequestParam Map<String, Object> map);
	/**
	 * 统计数据
	 */
	List<DataStatic> selectDatas(@RequestParam Map<String, Object> map);
}
