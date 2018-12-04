package com.cist.bayonetRegister.service;

import java.util.HashMap;
import java.util.List;

import com.cist.devRegister.model.Device;
import com.cist.devRegister.util.TempModel;
import com.cist.frame.page.PageInfo;

public interface BayonetRegisterService {
	public Object querypageList(HashMap<String, Object> paramMap, PageInfo pageInfo);
	/**
	 * 分页查询即将过期卡口
	 * 
	 * @param paramMap
	 * @return
	 */

	public Object queryImminentExpirypageList(HashMap<String, Object> paramMap, PageInfo pageInfo);
	/**
	 * 查询卡口可具有的功能类型
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<TempModel> queryBayonetFunType(String FCT_CODE);
	
	public Object queryDevicepageList(HashMap<String, Object> paramMap, PageInfo pageInfo);
	public Device queryBayonetById(HashMap<String, Object> paramMap);
}
