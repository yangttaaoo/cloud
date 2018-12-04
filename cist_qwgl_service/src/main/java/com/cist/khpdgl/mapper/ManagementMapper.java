package com.cist.khpdgl.mapper;

import java.util.List;
import java.util.Map;

import com.cist.khpdgl.model.Qw_AppraiseTopic;
import com.cist.khpdgl.model.Qw_Appraise_Reculations;
import com.cist.khpdgl.model.Sys_frm_code;

public interface ManagementMapper {

	/**
	 * 考核评定规则管理分页及条件查询
	 * @param map
	 * @return
	 */
	List<Qw_Appraise_Reculations> selectCheckAll(Map<String, Object> map);
	
	Integer updateCheckTopic(Map<String, Object> map);
	
	/**
	 * 基础数据
	 * @param fct_code
	 * @return
	 */
	List<Sys_frm_code> selectSysFrmCode(String fct_code);
	
	/**
	 * 考核评定规则管理 添加
	 * @param map
	 * @return
	 */
	Integer insertCheck(Map<String, Object> map);
	
	/**
	 * 条例 添加
	 * @param map
	 * @return
	 */
	Integer insertCheckTopic(Map<String, Object> map);
	
	/**
	 * 考核评定规则管理 修改
	 * @param map
	 * @return
	 */
	Integer updateCheck(Map<String, Object> map);
	
	/**
	 * 考核评定规则管理 删除
	 * @param map
	 * @return
	 */
	Integer deleteCheck(Map<String, Object> map);
	
	/**
	 * 考核评定规则管理 批量删除
	 * @param pk
	 * @return
	 */
	Integer deleteCheckAll(String[] pk);
	
	/**
	 * 栏目
	 * @return
	 */
	List<Qw_AppraiseTopic> selectTopic();
	
	List<Qw_AppraiseTopic> selectTopicList(Integer pk_id);
	
	List<Qw_Appraise_Reculations> selectReculations(Integer pk_id);
}
