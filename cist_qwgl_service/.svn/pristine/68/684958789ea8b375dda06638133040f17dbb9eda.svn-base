package com.cist.khpd.rules.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.khpd.rules.mapper.RuleMapper;
import com.cist.khpd.rules.model.Rule;
import com.cist.khpd.rules.model.RuleMannage;
import com.cist.khpd.rules.service.RuleService;
@Service
public class RuleServiceImpl implements RuleService {
@Autowired
private RuleMapper mapper;
	@Override
	public Object seleteDatapageList(HashMap<String, Object> map,PageInfo page) {
		return mapper.seleteData(map);
	}
	@Override
	public Integer addData(HashMap<String, Object> map) {
		return mapper.addData(map);
	}

	@Override
	public Integer deleteData(HashMap<String,Object>  pk) {
		return mapper.deleteData(pk);
	}
	@Override
	public Integer updateData(HashMap<String, Object> map) {
		return mapper.updateData(map);
	}
	@Override
	public List<Rule> selecteLmmc() {
		return mapper.selecteLmmc();
	}
	@Override
	public List<RuleMannage> selecteDatas(HashMap<String, Object> map) {
		return mapper.seleteDatas(map);
	}
	@Override
	public Integer addBanner(HashMap<String, Object> map) {
		return mapper.addBanner(map);
	}

}
