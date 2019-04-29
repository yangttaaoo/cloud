package com.cist.assessStatisticalRelease.assessTotalityAnalysis.model;

import java.util.HashMap;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;

public class TotalScore {
	// 考核人ID
	private Long fk_user_id;
	// 总扣分
	private Long total_buckle_score;
	// 总加分
	private Long total_add_score;
	// 指标总分
	private Long total_indicator_score;
	// 总考核分
	private Long total_assess_score;
	// 总排行
	private Long total_rank;
	// 是否及格
	private String score_is_pass;
	// 个人栏目考核信息Map
	private HashMap<Long, PersonalScore> personalScoreMap;
	// 考核人姓名
	private String fk_user_name;
	// 考核人部门ID
	private Long fk_dept_id;
	// 考核人部门名称
	private String fk_dept_name;

	public String getFk_dept_name() {
		if(fk_dept_id !=null) 
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT_PK, Long.toString(fk_dept_id));
		return null;
	}

	public void setFk_dept_name(String fk_dept_name) {
		System.out.print(SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT_PK, Long.toString(fk_dept_id)));
		this.fk_dept_name = fk_dept_name;
	}

	public Long getFk_dept_id() {
		return fk_dept_id;
	}

	public void setFk_dept_id(Long fk_dept_id) {
		this.fk_dept_id = fk_dept_id;
	}

	public String getFk_user_name() {
		if("".equals(fk_user_name) ||null==fk_user_name)
			return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT, Long.toString(fk_user_id));
		return fk_user_name;
	}

	public void setFk_user_name(String fk_user_name) {
		this.fk_user_name = fk_user_name;
	}

	public HashMap<Long, PersonalScore> getPersonalScoreMap() {
		return personalScoreMap;
	}

	public void setPersonalScoreMap(HashMap<Long, PersonalScore> personalScoreMap) {
		this.personalScoreMap = personalScoreMap;
	}

	public Long getFk_user_id() {
		return fk_user_id;
	}

	public void setFk_user_id(Long fk_user_id) {
		this.fk_user_id = fk_user_id;
	}

	public Long getTotal_buckle_score() {
		return total_buckle_score;
	}

	public void setTotal_buckle_score(Long total_buckle_score) {
		this.total_buckle_score = total_buckle_score;
	}

	public Long getTotal_add_score() {
		return total_add_score;
	}

	public void setTotal_add_score(Long total_add_score) {
		this.total_add_score = total_add_score;
	}

	public Long getTotal_indicator_score() {
		return total_indicator_score;
	}

	public void setTotal_indicator_score(Long total_indicator_score) {
		this.total_indicator_score = total_indicator_score;
	}

	public Long getTotal_assess_score() {
		return total_assess_score;
	}

	public void setTotal_assess_score(Long total_assess_score) {
		this.total_assess_score = total_assess_score;
	}

	public Long getTotal_rank() {
		return total_rank;
	}

	public void setTotal_rank(Long total_rank) {
		this.total_rank = total_rank;
	}

	public String getScore_is_pass() {
		return score_is_pass;
	}

	public void setScore_is_pass(String score_is_pass) {
		this.score_is_pass = score_is_pass;
	}

}
