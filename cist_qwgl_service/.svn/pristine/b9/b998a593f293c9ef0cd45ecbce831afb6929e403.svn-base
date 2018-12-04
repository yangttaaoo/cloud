package com.cist.khpdgl.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.khpdgl.model.Qw_AppraiseTopic;
import com.cist.khpdgl.model.Qw_Appraise_Reculations;
import com.cist.khpdgl.model.Sys_frm_code;

@Service(value="ManagementServiceImpl")
public interface ManagementService {

	/**
	 * 考核评定规则管理分页及条件查询
	 * @param map
	 * @param p
	 * @return
	 */
	Object selectAllpageList(Map<String,Object> map,PageInfo p);
	
	List<Qw_Appraise_Reculations> selectReculations(Integer pk_id);
	
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
	
	Integer updateCheckTopic(Map<String, Object> map);
	
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
	 * 基础数据
	 * @param fct_code
	 * @return
	 */
	List<Sys_frm_code> selectSysFrmCode(String fct_code);
	
	/**
	 * 栏目
	 * @return
	 */
	List<Qw_AppraiseTopic> selectTopic();
	
	List<Qw_AppraiseTopic> selectTopicList(Integer pk_id);
}
