package com.cist.trafficSign.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cist.devRegister.util.TempModel;
import com.cist.trafficSign.model.TrafficSign;

public interface TrafficSignMapper {
	/**
	 * 查询交通标识
	 * @param paramMap
	 * @return
	 */
	public List<TrafficSign> SecurityByglbmTocode(HashMap<String, Object> paramMap);
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
	
	public TempModel  queryBaseDateName(@Param("FCT_CODE")String FCT_CODE,@Param("fc_code")String fc_code);
}
