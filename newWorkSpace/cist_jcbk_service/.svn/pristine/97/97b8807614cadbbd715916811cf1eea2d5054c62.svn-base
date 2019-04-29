package com.cist.yjgl.infoStatistics.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.yjgl.infoStatistics.model.StaModel;
import com.cist.yjgl.infoStatistics.model.TableStaModel;

public interface InfoStatisticsMapper {
	/**
	 * 获取表格统计数据
	 * 
	 * @return
	 */
	public List<TableStaModel> getTableStaSum(HashMap<String, Object> paramMap);
	/**
	 * 获取预警数
	 * 
	 * @return
	 */
	public List<StaModel> getEarlyWarnSum(HashMap<String, Object> paramMap);

	/**
	 * 获取签收数
	 * 
	 * @return
	 */
	public List<StaModel> getSignInSum(HashMap<String, Object> paramMap);
	/**
	 * 获取预警折线图统计
	 * 
	 * @return
	 */
	public List<StaModel> getYJSum(HashMap<String,Object> paramMap);
	/**
	 * 获取签收折线图统计
	 * 
	 * @return
	 */
	public List<StaModel> getQSSum(HashMap<String,Object> paramMap);
	
}
