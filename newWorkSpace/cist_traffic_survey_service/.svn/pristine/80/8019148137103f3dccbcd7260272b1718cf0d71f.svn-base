package com.cist.trafficSign.service;

import java.util.HashMap;

import com.cist.devRegister.util.TempModel;
import com.cist.frame.page.PageInfo;

public interface TrafficSignService {
	/**
	 * 分页查询交通标志
	 * 
	 * @param paramMap
	 * @param pageInfo
	 * @return
	 */
	public Object querypageList(HashMap<String, Object> paramMap, PageInfo pageInfo);

	/**
	 * 根据交通标志Id删除交通标志记录
	 * 
	 * @param paramMap
	 * @return
	 */
	public int deleteById(HashMap<String, Object> paramMap);

	/**
	 * 新增一条交通标志记录
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addTrafficSign(HashMap<String, Object> paramMap);

	/**
	 * 根据ID更新一条交通标志记录
	 * 
	 * @param paramMap
	 * @return
	 */
	public int updateTrafficSignById(HashMap<String, Object> paramMap);
	
	public TempModel  queryBaseDateName(String FCT_CODE,String fc_code);

}
