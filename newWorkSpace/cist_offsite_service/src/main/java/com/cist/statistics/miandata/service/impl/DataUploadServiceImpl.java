package com.cist.statistics.miandata.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.cist.frame.page.PageInfo;
import com.cist.statistics.miandata.mapper.DataUploadMapper;
import com.cist.statistics.miandata.model.DataUpload;
import com.cist.statistics.miandata.service.DataUploadService;

@Service
public class DataUploadServiceImpl implements DataUploadService{

	@Autowired
	private DataUploadMapper dMapper;

	

	public List<DataUpload> queryUpload(Map<String, Object> map) {
		return dMapper.queryUpload(map);
	}

	public List<DataUpload> selectExcel(Map<String, Object> map) {
		return dMapper.selectExcel(map);
	}

	@Override
	public Object querypageList(HashMap<String, Object> map,PageInfo info) {
		return dMapper.queryUpload(map);
	}

	
	

	


	
	
	
}
