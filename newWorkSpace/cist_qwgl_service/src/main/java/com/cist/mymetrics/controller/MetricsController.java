package com.cist.mymetrics.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.mymetrics.model.Regulations;
import com.cist.mymetrics.service.MyMetricsService;
import com.cist.pddwzb.model.NameAndSocre;
import com.cist.pddwzb.service.DeptService;
import com.cist.pdgrzb.model.Qw_I_C_Metricr;

@RestController
@RequestMapping("/wdzb")
public class MetricsController {

	@Autowired
	private MyMetricsService mService;
	@Autowired
	private DeptService dService;
	
	@RequestMapping("/indexall")
	public PageInfo<Qw_I_C_Metricr> selectOwnMetrics(@RequestBody HashMap<String, Object> map) {
		PageInfo pInfo = new PageInfo();
		pInfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pInfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Qw_I_C_Metricr> pageInfo = (PageInfo<Qw_I_C_Metricr>) mService.selectOwnMetricspageList(map, pInfo);
		List<Qw_I_C_Metricr> list = pageInfo.getList();
		List<Regulations> list4 = null;
		List<NameAndSocre> list2 = null;
		int size = list.size();
		Integer defaulttotalsocre;
		Regulations regulations = null;
		for (int i = 0; i < size; i++) {
			defaulttotalsocre = 0;
			String allscore = list.get(i).getAllsocre();
			String[] scores = allscore.split(",");
			Integer totalsocre = 0;
			for (String string : scores) {
				totalsocre += Integer.valueOf(string);
			}
			list.get(i).setTotalSocre(totalsocre);
			//查询栏目下的条例分值			
			String topicd = list.get(i).getTopicids();
			String[] topicds = topicd.split(",");
			for (int j = 0; j < topicds.length; j++) {
				map.put("id", topicds[j]);
				list4 = mService.selectRegulations(map);
				for (int j2 = 0; j2 < list4.size(); j2++) {
					regulations = list4.get(j2);
					if (regulations.getAssessment_rules().equals("1")) {
						defaulttotalsocre += regulations.getAssessment_num();
					}else {
						defaulttotalsocre -= regulations.getAssessment_num();
					}
				}
			}
			//对应的所有栏目默认分值			
			map.put("ids", topicds);
			list2 = dService.selectTopicById(map);
			for (NameAndSocre nameAndSocre : list2) {
				defaulttotalsocre += nameAndSocre.getDefault_value();
			}
			
			list.get(i).setDefaultSocre(defaulttotalsocre);
			
		}

		pageInfo.setList(list);
		return pageInfo;
	}
}
