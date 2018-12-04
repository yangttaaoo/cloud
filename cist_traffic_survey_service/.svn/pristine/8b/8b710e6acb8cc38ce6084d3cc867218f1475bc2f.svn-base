package com.cist.intervalVelocity.service;

import java.util.HashMap;
import java.util.List;

import com.cist.devRegister.model.Device;
import com.cist.frame.page.PageInfo;
import com.cist.intervalVelocity.model.DevBaseInfo;
import com.cist.intervalVelocity.model.DevConnectBayonet;
import com.cist.intervalVelocity.model.IntervalVelocity;

public interface IntervalVelocityService {
	/**
	 * 获取设备类型为卡口的信息
	 * 
	 * @return
	 */
	public Object queryKKpageList( HashMap<String, Object> paramMap, PageInfo pageInfo);
	/**
	 * 为添加的区间测速备案添加参数
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addIntervalParam(HashMap<String, Object> paramMap);
	/**
	 * 区间测速备案更新参数
	 *  
	 * @param paramMap
	 * @return
	 */
	public int updateIntervalParam(HashMap<String, Object> paramMap);
	/**
	 * 将区间测速备案与卡口设备相关联
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addDevConnectBayonet(HashMap<String, Object> paramMap);
	/**
	 * 获取设备类型为卡口的信息
	 * 
	 * @return
	 */
	public Object querypageList( HashMap<String, Object> paramMap, PageInfo pageInfo);
	
	public List<Device> getCheckKKDevice(HashMap<String, Object> paramMap);
	public List<Integer> getDevConnectBayonet(HashMap<String, Object> paramMap);
	public int delDevConnectBayonet(HashMap<String, Object> paramMap);
	public int deleteParam(HashMap<String, Object> paramMap);
	public int deleteConnect(HashMap<String, Object> paramMap);
	public int delDevByQJCS(HashMap<String, Object> paramMap);
	public Object queryDevicepageList( HashMap<String, Object> paramMap, PageInfo pageInfo);
	public IntervalVelocity queryDeviceById(HashMap<String, Object> paramMap);
}
