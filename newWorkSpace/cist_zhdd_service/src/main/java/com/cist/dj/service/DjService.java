package com.cist.dj.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.cist.dj.model.TblOffeEvdiInfo;

public interface DjService {
	List<Date> selectAll(HashMap<String, Object> map);
	
	/**
	 * 小时过车辆
	 * @return
	 */
	Integer selectOneHourCount(HashMap<String, Object> map);
	/**
	 * 查询该路口最新的一条数据
	 * @param map
	 * @return
	 */
	TblOffeEvdiInfo selectLastData(HashMap<String, Object> map);
}
