package com.cist.statistics.validdata.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.cist.frame.page.PageInfo;
import com.cist.statistics.validdata.mapper.ValidMapper;
import com.cist.statistics.validdata.model.DataCount;
import com.cist.statistics.validdata.model.DataStatic;
import com.cist.statistics.validdata.service.ValidDataService;
@Service("validdataserviceimpl")
public class ValidDataServiceImpl implements ValidDataService {
	@Autowired
  private ValidMapper  mapper;
	@Override
	public Object selectValidpageList(HashMap<String, Object> map,PageInfo info) {
		return mapper.selectValid(map);
	}
	@Override
	public List<DataCount> selectData(@RequestParam Map<String, Object> map) {
		return mapper.selectData(map);
	}
	@Override
	public List<DataStatic> selectDatas(Map<String, Object> map) {
		return mapper.selectDatas(map);
	}

}
