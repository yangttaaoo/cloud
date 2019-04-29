package com.cist.pddwzb.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.khpdgl.model.Qw_AppraiseTopic;
import com.cist.pddwzb.model.NameAndSocre;
import com.cist.pdgrzb.model.DeptInfo;

public interface DeptService {
	List<DeptInfo> depart_infolists(Integer dept_superior);
	
	Object selectDeptAllpageList(HashMap<String, Object> map,PageInfo pageInfo);
	/**
	 * 查询所有条例或者根据pk_id查询
	 * @param pk_id
	 * @return
	 */
	List<Qw_AppraiseTopic> selectTopic(HashMap<String, Object> map);
	/**
	 * 查询所关联的所有栏目
	 * @param map
	 * @return
	 */
	List<NameAndSocre> selectTopicById(HashMap<String, Object> map);
	/**
	 * 添加单位指标
	 * @param map
	 * @return
	 */
	Integer insertDept(HashMap<String, Object> map);
	/**
	 * 查询刚插入数据的pk_id
	 * @param map
	 * @return
	 */
	Integer selectMetricsId(HashMap<String, Object> map);
	/**
	 * 添加评价指标
	 * @param map
	 * @return
	 */
	Integer insertZb(HashMap<String, Object> map);
	/**
	 * 更新单位指标
	 * @param map
	 * @return
	 */
	Integer updateDept(HashMap<String, Object> map);
	/**
	 * 删除单位指标
	 * @param map
	 * @return
	 */
	Integer deleteDept(HashMap<String, Object> map);
	/**
	 * 删除评价指标
	 * @param map
	 * @return
	 */
	Integer deleteMetrics(HashMap<String, Object> map);
	/**
	 * 批量删除单位指标
	 * @param map
	 * @return
	 */
	Integer deleteDeptAll(HashMap<String, Object> map);
	/**
	 * 批量删除评价指标
	 * @param map
	 * @return
	 */
	Integer deleteMetricsAll(HashMap<String, Object> map);
}
