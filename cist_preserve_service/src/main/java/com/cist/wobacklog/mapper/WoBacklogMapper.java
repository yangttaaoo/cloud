package com.cist.wobacklog.mapper;


import java.util.HashMap;
import java.util.List;

import com.cist.wobacklog.model.JtywJobProcess;
import com.cist.wobacklog.model.VwJtywDbgd;
import com.cist.wobacklog.model.VwJtywJobDev;
import com.cist.wobacklog.model.VwJtywLog;
import com.cist.workorderstats.model.JtywJobOrderInfo;

public interface WoBacklogMapper {
	
	//查询待办工单
	List<VwJtywDbgd> list(HashMap<String,Object> map);
	
	//更新工单任务百分比
	Integer update(HashMap<String,Object> map);
	
	//查询本周完成工单数量和我的待办工单
	VwJtywDbgd selectCount(HashMap<String,Object> map);
	
	//查询我本周完成工单的平均处理时间
	VwJtywDbgd selectAvg(HashMap<String,Object> map);
	
	//更新最新的百分比
	Integer updatePercent(HashMap<String,Object> map);
	
	//更新工单的状态为接收状态
	Integer updateReceive(HashMap<String,Object> map);
	
	//插入工单流程操作
	Integer insert(HashMap<String,Object> map);
	
	//查询工单操作日志
	List<VwJtywLog> selectLog(HashMap<String,Object> map);
	
	//查询工单故障设备
	List<VwJtywJobDev> selectDev(HashMap<String,Object> map);
	
	//插入工单流程操作
	Integer insertReceive(HashMap<String,Object> map);
	
	//插入工单流程操作
	Integer insertPercent(HashMap<String,Object> map);
	
	
}
