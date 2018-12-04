package com.cist.illegalUpload.service.impl;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.illegalUpload.domain.Tbloffeevdi;
import com.cist.illegalUpload.mapper.IllegalUploadMapper;
import com.cist.illegalUpload.service.IllegalUploadService;

@Service
public class IllegalUploadImpl implements IllegalUploadService {

	@Autowired
	private IllegalUploadMapper mapper;

	@Override
	public int automaticupload() {
		return mapper.automaticupload();
	}

	@Override
	public String getfctcode(HashMap<String, Object> map) {
		return mapper.getfctcode(map);
	}

	@Override
	public int updateOffzt(List<Tbloffeevdi> list) {
		return mapper.updateOffzt(list);
	}

	@Override
	public List<Tbloffeevdi> queryAutoOffeInfo() {
		return mapper.queryAutoOffeInfo();
	}

	@Override
	public int updateOffEdv(Tbloffeevdi tbl) {
		return mapper.updateOffEdv(tbl);
	}

}
