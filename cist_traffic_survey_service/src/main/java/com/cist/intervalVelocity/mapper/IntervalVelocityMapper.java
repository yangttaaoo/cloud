package com.cist.intervalVelocity.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.devRegister.model.Device;
import com.cist.devRegister.model.DeviceList;
import com.cist.intervalVelocity.model.DevBaseInfo;
import com.cist.intervalVelocity.model.DevConnectBayonet;
import com.cist.intervalVelocity.model.IntervalVelocity;

public interface IntervalVelocityMapper {
	/**
	 * 获取设备类型为卡口的信息
	 * 
	 * @return
	 */
	public List<Device> getKKInfoList(HashMap<String, Object> paramMap);

	/**
	 * 为添加的区间测速备案添加参数
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addIntervalParam(HashMap<String, Object> paramMap);
	/**

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
	 * 将区间测速备案与卡口设备相关联
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<IntervalVelocity> queryList(HashMap<String, Object> paramMap);
	public List<Device> getCheckKKDevice(HashMap<String, Object> paramMap);
	public List<Integer> getDevConnectBayonet(HashMap<String, Object> paramMap);
	public int delDevConnectBayonet(HashMap<String, Object> paramMap);
	public int deleteParam(HashMap<String, Object> paramMap);
	public int deleteConnect(HashMap<String, Object> paramMap);
	public int delDevByQJCS(HashMap<String, Object> paramMap);
	public List<DeviceList> queryDeviceList(HashMap<String, Object> paramMap);
	public IntervalVelocity queryDeviceById(HashMap<String, Object> paramMap);
}
