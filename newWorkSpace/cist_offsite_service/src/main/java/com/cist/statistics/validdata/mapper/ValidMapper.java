package com.cist.statistics.validdata.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;
import com.cist.statistics.validdata.model.DataCount;
import com.cist.statistics.validdata.model.DataStatic;
public interface ValidMapper {
 /**
  * 查询有效数据
  * 
  */
	List<DataCount> selectValid(HashMap<String, Object> map);
	/**
	 * 查询数据到统计图
	 */
	List<DataCount> selectData(Map<String, Object> map);
	/**
	 * 统计数据
	 */
	List<DataStatic> selectDatas(@RequestParam Map<String, Object> map);
}
