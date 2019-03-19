package com.cist.businessconfig.bayonetapply.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.businessconfig.bayonetapply.mapper.BayonetApplyMapper;
import com.cist.businessconfig.bayonetapply.model.Jcbk_control_vehicle;
import com.cist.businessconfig.bayonetapply.model.Sys_frm_code;
import com.cist.businessconfig.bayonetapply.service.BayonetApplyService;
import com.cist.frame.page.PageInfo;
@Service
public class BayonetApplyServiceImpl implements BayonetApplyService {
	@Autowired
	private BayonetApplyMapper mapper;

	@Override
	public List<Jcbk_control_vehicle> queryBayonetApplyinfo(HashMap<String, Object> map) {
		return mapper.queryBayonetApplyinfo(map);
	}

	@Override
	public Object queryBayonetApplyinfopageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.queryBayonetApplyinfo(map);
	}

	@Override
	public Integer addBayonetApply(Map<String, Object> map) {
		return mapper.addBayonetApply(map);
	}

	@Override
	public Integer updateBayonetApply(Map<String, Object> map) {
		return mapper.updateBayonetApply(map);
	}

	@Override
	public Integer deleteBayonetApply(HashMap<String, Object> map) {
		return mapper.deleteBayonetApply(map);
	}

	@Override
	public List<Sys_frm_code> querySys_frm_code(HashMap<String, Object> map) {
		return mapper.querySys_frm_code(map);
	}
	
	
}
