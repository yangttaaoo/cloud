package com.cist.warnCountAnalyze.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.warnCountAnalyze.model.BaseData;
import com.cist.warnCountAnalyze.model.CarAlarmStat;

public interface WarnCountAnalyzeMapper {
	/**
	 * 查询预警统计分析表数据List
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<CarAlarmStat> queryCarAlarmStatList(HashMap<String, Object> paramMap);
	
	/**
	 * 根据数据字典索引查询对应信息
	 * @param FCT_CODE
	 * @return
	 */
	public List<BaseData> queryBaseDataByFct_Code(String FCT_CODE);
	
	
	public List<CarAlarmStat> queryList(HashMap<String, Object> paramMap);
}
