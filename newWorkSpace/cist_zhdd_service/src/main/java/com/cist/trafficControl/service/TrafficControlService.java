package com.cist.trafficControl.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.trafficControl.model.TempModel;
import com.cist.trafficControl.model.TrafficControl;

public interface TrafficControlService {
	/**
	 * 获取交通管制规则
	 * @return
	 */
	public List<TempModel> getTrafficControlRule();
	/**
	 * 新增交通管制
	 * @param paramMap
	 * @return
	 */
	public int insert(HashMap<String,Object> paramMap);
	/**
	 * 更新交通管制
	 * 
	 * @param paramMap
	 * @return
	 */
	public int update(HashMap<String, Object> paramMap);
	/**
	 * 删除交通管制
	 * 
	 * @param paramMap
	 * @return
	 */
	public int delete(HashMap<String, Object> paramMap);
	/**
	 * 获取交通管制List数据
	 * 
	 * @param paramMap
	 * @return
	 */
	public Object queryTrafficControlpageList(HashMap<String, Object> paramMap,PageInfo pageInf0);
}
