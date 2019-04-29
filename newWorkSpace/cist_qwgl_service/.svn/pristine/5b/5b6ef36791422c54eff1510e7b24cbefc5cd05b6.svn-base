package com.cist.qwgl.qylxgl.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.qwgl.qylxgl.mapper.QylxglMapper;
import com.cist.qwgl.qylxgl.model.QWGL_QYLX_TYPE;
import com.cist.qwgl.qylxgl.service.QylxglService;
@Service
public class QylxglServiceImpl implements QylxglService {
	@Autowired
	private QylxglMapper mapper;

	public List<QWGL_QYLX_TYPE> queryqylx(HashMap<String, Object> map) {
		return mapper.queryqylx(map);
	}

	public Object queryqylxpageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.queryqylx(map);
	}

	public Integer addqylx(HashMap<String, Object> map) {
		return mapper.addqylx(map);
	}

	public Integer updateqylx(HashMap<String, Object> map) {
		return mapper.updateqylx(map);
	}

	public Integer deleteqylx(HashMap<String, Object> map) {
		return mapper.deleteqylx(map);
	}

	public Integer querymaxpk() {
		return mapper.querymaxpk();
	}

}
