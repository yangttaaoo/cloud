package com.cist.bayonetRegister.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.devRegister.model.Device;
import com.cist.devRegister.model.DeviceList;
import com.cist.devRegister.util.TempModel;

public interface BayonetRegisterMapper {
	/**
	 * 分页查询卡口
	 * 
	 * @param paramMap
	 * @return
	 */

	public List<Device> queryList(HashMap<String, Object> paramMap);
	/**
	 * 分页查询即将过期卡口
	 * 
	 * @param paramMap
	 * @return
	 */

	public List<Device> queryImminentExpiryList(HashMap<String, Object> paramMap);
	/**
	 * 查询卡口可具有的功能类型
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<TempModel> queryBayonetFunType(String FCT_CODE);
	
	public List<DeviceList> queryDeviceList(HashMap<String, Object> paramMap);
	
	public Device queryBayonetById(HashMap<String, Object> paramMap);
}
