package com.cist.codemaintain.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.codemaintain.mapper.CodeMaintainMapper;
import com.cist.codemaintain.model.Sys_frm_code_type;
import com.cist.codemaintain.service.CodeMaintainService;
import com.cist.frame.page.PageInfo;



@Service
public class CodeMaintainServiceImpl implements CodeMaintainService  {

	@Autowired
	private CodeMaintainMapper mapper;

	@Override
	public Object queryAllpageList(Map<String, Object> map, PageInfo info) {
		return mapper.queryAll(map);
	}

	@Override
	public Integer update(Map<String, Object> map) {
		return mapper.update(map);
	}

	@Override
	public Integer insert(Map<String, Object> map) {
		return mapper.insert(map);
	}

	@Override
	public Integer delete(Map<String, Object> map) {
		return mapper.delete(map);
	}

	@Override
	public List<Sys_frm_code_type> queryFrmType(Map<String, Object> map) {
		return mapper.queryFrmType(map);
	}

}
