package com.cist.logquery.bizoperate.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.logquery.bizoperate.modle.LogBiz;

public interface BizMapper {
   /**
    * 查询业务操作
    */
	List<LogBiz>  selectBiz(HashMap<String,Object> map);
	/**
	 * 删除所有数据
	 */
	Integer deleteAll(String[] pk);
	/**
	 * 删除单一数据
	 */
	Integer deleteOne(Integer pk);
}
