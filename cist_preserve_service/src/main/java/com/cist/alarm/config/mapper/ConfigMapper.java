package com.cist.alarm.config.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.alarm.config.model.AlarmConfig;

public interface ConfigMapper {
	/**
	 * 增加数据
	 * @param map
	 * @return
	 */
	Integer  addData(HashMap<String,Object> map);
	   
	 /**
	  * 查询数据
	  * @return
	  */
	List<AlarmConfig>  selectData();
}
