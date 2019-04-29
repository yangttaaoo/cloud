package com.cist.isolationfacility.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cist.frame.page.PageInfo;
import com.cist.isolationfacility.model.Jcsj_barrier_facilities;

public interface IsolationFacilityService {
	/**
	 * 新增隔离设施信息
	 * @param map
	 * @return
	 */
	public Integer insertJcsj_barrier_facilities(Map<String,Object> map);
	/**
	 * 查询隔离设施信息（不分页）
	 * @param map
	 * @return
	 */
	public List<Jcsj_barrier_facilities> queryJcsj_barrier_facilities(HashMap<String,Object> map);
	/**
	 * 查询隔离设施信息（分页查询）
	 * @param map
	 * @return
	 */
	public Object queryJcsj_barrier_facilitiespageList(HashMap<String,Object> map,PageInfo info);
	/**
	 * 更新隔离设施信息
	 * @param map
	 * @return
	 */
	public Integer updateJcsj_barrier_facilities(Map<String,Object> map);
	/**
	 * 删除隔离设施信息（单条/批量）
	 * @param map
	 * @return
	 */
	public Integer deleteJcsj_barrier_facilities(HashMap<String,Object> map);
}
