package com.cist.mymetrics.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.mymetrics.model.Regulations;
@Service(value="MyMetricsServiceImpl")
public interface MyMetricsService {
	/**
	 *  查询登录人的个人指标
	 * @param map
	 * @return
	 */
	Object selectOwnMetricspageList(HashMap<String, Object> map,PageInfo pInfo);
	/**
	 * 查询单个条例的分数
	 * @param map
	 * @return
	 */
	List<Regulations> selectRegulations(HashMap<String, Object> map);
}
