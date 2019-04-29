package com.cist.assessStatisticalRelease.assessTotalityAnalysis.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.assessStatisticalRelease.assessTotalityAnalysis.model.PersonalScore;
import com.cist.assessStatisticalRelease.assessTotalityAnalysis.model.TotalScore;
import com.cist.assessStatisticalRelease.assessTotalityAnalysis.model.UserTopic;

public interface AssessTotalityAnalysisMapper {
	/**
	 * 获取考核栏目信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<UserTopic> queryUserTopic(HashMap<String, Object> paramMap);

	/**
	 * 查询个人考核记录以及各种总累计分
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<TotalScore> queryTotalScore(HashMap<String, Object> paramMap);

	/**
	 * 查询个人分栏目考核的分值信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<PersonalScore> queryPersonalScore(HashMap<String, Object> paramMap);

	/**
	 * 查询部门考核记录以及各种总累计分
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<TotalScore> queryDeptTotalScore(HashMap<String, Object> paramMap);

	/**
	 * 查询部门分栏目考核的分值信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<PersonalScore> queryDeptScore(HashMap<String, Object> paramMap);

}
