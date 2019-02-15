package com.cist.workorderstats.service;

import java.util.HashMap;
import java.util.List;

import com.cist.workorderstats.model.JtywJobOrderInfo;


public interface WorkOrderStatsService {
	
	//统计工单总数、完成数量、未完成数量
	JtywJobOrderInfo selectCount(HashMap<String,Object> map);
	
	//统计每个公司的完成数量和未完成数量
	List<JtywJobOrderInfo> selectCompany(HashMap<String,Object> map);
	
	//统计每个公司的工单占比
	List<JtywJobOrderInfo> selectPercent(HashMap<String,Object> map);
	
	//统计全年每月平均增量
	JtywJobOrderInfo selectAvgMonth(HashMap<String,Object> map);
	
	//统计全年每月平均增量
	JtywJobOrderInfo selectAvgday(HashMap<String,Object> map);
	
	
}
