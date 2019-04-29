package com.cist.assessStatisticalRelease.assessTotalityAnalysis.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.assessStatisticalRelease.assessTotalityAnalysis.mapper.AssessTotalityAnalysisMapper;
import com.cist.assessStatisticalRelease.assessTotalityAnalysis.model.PersonalScore;
import com.cist.assessStatisticalRelease.assessTotalityAnalysis.model.TotalScore;
import com.cist.assessStatisticalRelease.assessTotalityAnalysis.model.UserTopic;
import com.cist.assessStatisticalRelease.assessTotalityAnalysis.service.AssessTotalityAnalysisService;

@Service
public class AssessTotalityAnalysisServiceImpl implements AssessTotalityAnalysisService {
	@Autowired
	private AssessTotalityAnalysisMapper mapper;



	@Override
	public HashMap<Long, String> queryUserTopic(HashMap<String, Object> paramMap) {
		List<UserTopic> userTopicList = mapper.queryUserTopic(paramMap);
		// 获取所有符合条件的考核栏目ID
				HashMap<Long, String> topicIdMap = new HashMap<Long, String>();
				for (UserTopic userTopic : userTopicList) {
					Long topic_id = userTopic.getFk_topic_id();
					String topic_name = userTopic.getFk_topic_name();
					if (!topicIdMap.containsKey(topic_id)) {
						topicIdMap.put(topic_id, topic_name);
					}

				}
		return topicIdMap;
	}

	@Override
	public List<TotalScore> queryTotalScore(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.queryTotalScore(paramMap);
	}

	@Override
	public List<PersonalScore> queryPersonalScore(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.queryPersonalScore(paramMap);
	}

	@Override
	public List<TotalScore> queryDeptTotalScore(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.queryDeptTotalScore(paramMap);
	}

	@Override
	public List<PersonalScore> queryDeptScore(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.queryDeptScore(paramMap);
	}



	@Override
	public void bindPersonTopicScore(List<TotalScore> totalScore, List<PersonalScore> personalScore) {
		for (TotalScore total : totalScore) {
			HashMap<Long, PersonalScore> personScoreMap = new HashMap<Long, PersonalScore>();
			for (PersonalScore person : personalScore) {
				if (Long.compare(total.getFk_user_id(), person.getFk_user_id()) == 0) {
					personScoreMap.put(person.getFk_topic_id(), person);
				}
			}
			total.setPersonalScoreMap(personScoreMap);
			;
		}
		
	}

	@Override
	public void bindDeptTopicScore(List<TotalScore> totalScore, List<PersonalScore> deptScore) {
		for (TotalScore total : totalScore) {
			HashMap<Long, PersonalScore> deptScoreMap = new HashMap<Long, PersonalScore>();
			for (PersonalScore dept : deptScore) {
				if (Long.compare(total.getFk_user_id(), dept.getFk_user_id()) == 0) {
					deptScoreMap.put(dept.getFk_topic_id(), dept);
				}
			}
			total.setPersonalScoreMap(deptScoreMap);
			;
		}
		
	}
}
