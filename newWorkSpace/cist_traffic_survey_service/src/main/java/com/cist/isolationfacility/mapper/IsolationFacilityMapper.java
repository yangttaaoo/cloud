package com.cist.isolationfacility.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cist.isolationfacility.model.Jcsj_barrier_facilities;

public interface IsolationFacilityMapper {
	/**
	 * 新增隔离设施信息
	 * @param map
	 * @return
	 */
	public Integer insertJcsj_barrier_facilities(Map<String,Object> map);
	/**
	 * 查询隔离设施信息
	 * @param map
	 * @return
	 */
	public List<Jcsj_barrier_facilities> SecurityByglbmTocode(HashMap<String,Object> map);
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
