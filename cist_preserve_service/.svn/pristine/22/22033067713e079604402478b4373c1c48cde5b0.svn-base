package com.cist.opsvdt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.opsvdt.mapper.OpsDvtMapper;
import com.cist.opsvdt.model.Jtyw_group;
import com.cist.opsvdt.model.Jtyw_group_member;
import com.cist.opsvdt.model.Tbl_corp_m;
import com.cist.opsvdt.service.OpsDvtService;

@Service
public class OpsDvtServiceImpl implements OpsDvtService{

	@Autowired
	private OpsDvtMapper mapper;

	@Override
	public Object queryAllpageList(Map<String, Object> map, PageInfo pinfo) {
		return mapper.quertAll(map);
	}

	@Override
	public Integer updateVdt(Map<String, Object> map) {
		return mapper.updateVdt(map);
	}

	@Override
	public Integer deleteVdt(Map<String, Object> map) {
		return mapper.deleteVdt(map);
	}

	@Override
	public Integer insertVdt(Map<String, Object> map) {
		return mapper.insertVdt(map);
	}

	@Override
	public List<Jtyw_group_member> queryCorp(Map<String, Object> map) {
		return mapper.queryCorp(map);
	}

	@Override
	public Integer deleteAlls(String[] pk) {
		return mapper.deleteAlls(pk);
	}

	@Override
	public Integer insertVdts(Map<String, Object> map) {
		return mapper.insertVdts(map);
	}

	@Override
	public Integer updateVdts(Map<String, Object> map) {
		return mapper.updateVdts(map);
	}

	@Override
	public List<Jtyw_group> queryGroup(Map<String, Object> map) {
		return mapper.queryGroup(map);
	}

	@Override
	public Integer deleteVdts(Map<String, Object> map) {
		return mapper.deleteVdts(map);
	}
	
}
