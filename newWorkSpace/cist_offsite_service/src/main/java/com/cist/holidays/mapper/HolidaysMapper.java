package com.cist.holidays.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.holidays.model.Holidays;

public interface HolidaysMapper {

	/**
	 * 节假日分页查询
	 * 
	 * @param paramMap
	 * @return
	 */
	List<Holidays> queryList(HashMap<String, Object> paramMap);

	/**
	 * 添加一条节假日记录
	 * 
	 * @param paramMap
	 * @return
	 */
	int insert(HashMap<String, Object> paramMap);

	/**
	 * 更新一条节假日记录
	 * 
	 * @param paramMap
	 * @return
	 */
	int update(HashMap<String, Object> paramMap);
	/**
	 * 删除节假日记录(一条或多条)
	 * @param paramMap
	 * @return
	 */
	int  delete(List<Object> paramList);
}
