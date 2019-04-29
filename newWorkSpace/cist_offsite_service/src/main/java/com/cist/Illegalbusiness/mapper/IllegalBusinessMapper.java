package com.cist.Illegalbusiness.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.Illegalbusiness.model.DeptInfo;
import com.cist.Illegalbusiness.model.TblOffeVioWorkStat;
import com.cist.Illegalbusiness.model.TblWorkCardStatInfo;
import com.cist.personalstats.model.PersonalStats;

public interface IllegalBusinessMapper {
	
	//根据审核单位分组统计工作量
	TblWorkCardStatInfo list(HashMap<String,Object> map);
	
	//根据审核人员分组统计工作量
	List<TblOffeVioWorkStat> selectByPolice(HashMap<String, Object> map);
	
	//管理部门树
	List<DeptInfo> depart_infolist(Integer dept_superior);
	
	//查询违法总量
	TblOffeVioWorkStat selectIllegal(HashMap<String,Object> map);
	
	//查询12日未审核数据列表
	List<TblOffeVioWorkStat> selectWsh(HashMap<String,Object> map);
	
	//统计时间分组审核总量
	List<TblOffeVioWorkStat> selectShzl(HashMap<String,Object> map);
	
	//根据审核单位分组统计工作量
	List<TblOffeVioWorkStat> selectByDept(HashMap<String,Object> map);
	
	//根据审核单位分组统计工作量
	TblWorkCardStatInfo selectList(HashMap<String,Object> map);
	
	//根据小时分组查询个人今日审核量
	List<TblOffeVioWorkStat> selectDay(HashMap<String,Object> map);
	
	//根据周分组查询个人今日审核量
	List<TblOffeVioWorkStat> selectWeek(HashMap<String,Object> map);
	
	//根据年的月份分组查询个人今日审核量
	List<TblOffeVioWorkStat> selectYear(HashMap<String,Object> map);
	
	//根据月的天数份分组查询个人今日审核量
	List<TblOffeVioWorkStat> selectMonth(HashMap<String,Object> map);
	
	//统计总审核量时间分组
	List<PersonalStats> selectAllCount(HashMap<String,Object> map);

}