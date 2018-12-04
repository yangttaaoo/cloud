package com.cist.qwgl.xqgl.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.qwgl.qylxgl.model.QWGL_QYLX_TYPE;
import com.cist.qwgl.xqgl.mapper.XqglMapper;
import com.cist.qwgl.xqgl.model.QWGL_QY_TYPE;
import com.cist.qwgl.xqgl.model.QWGL_XQGL_INFO;
import com.cist.qwgl.xqgl.service.XqglService;
@Service
public class XqglServiceImpl implements XqglService {
	@Autowired
	private XqglMapper mapper;
	
	public List<QWGL_XQGL_INFO> queryxq(HashMap<String, Object> map) {
		return mapper.queryxq(map);
	}

	public Object queryxqpageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.queryxq(map);
	}

	public List<QWGL_QY_TYPE> queryqytype(HashMap<String, Object> map) {
		return mapper.queryqytype(map);
	}

	public Integer addxqgl(HashMap<String, Object> map) {
		return mapper.addxqgl(map);
	}

	public Integer updatexqgl(HashMap<String, Object> map) {
		return mapper.updatexqgl(map);
	}

	public Integer deletexqgl(HashMap<String, Object> map) {
		return mapper.deletexqgl(map);
	}

	public Integer querymaxpk() {
		return mapper.querymaxpk();
	}

	@Override
	public String querydeptname(String dept_code) {
		return mapper.querydeptname(dept_code);
	}

	@Override
	public List<QWGL_QYLX_TYPE> queryqylx(HashMap<String, Object> map) {
		return mapper.queryqylx(map);
	}

}
