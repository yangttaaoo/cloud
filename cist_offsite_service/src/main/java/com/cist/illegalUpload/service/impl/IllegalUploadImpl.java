package com.cist.illegalUpload.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cist.illegalUpload.domain.Tbloffeevdi;
import com.cist.illegalUpload.domain.Vehicle;
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

	@Override
	public int cjgjkfs() {
		return mapper.cjgjkfs();
	}

	@Override
	public Vehicle vehicledate(HashMap<String, String> map) {
		return mapper.vehicledate(map);
	}

	@Override
	public Tbloffeevdi checkOffedvi(Map<String, Object> map) {
		return mapper.checkOffedvi(map);
	}

	@Override
	public int updateOffEdv1(Tbloffeevdi tbl) {
		return mapper.updateOffEdv1(tbl);
	}
	@Transactional
	public int updateOffQue(Tbloffeevdi tbl) throws Exception{
		int re = mapper.updateOffQue(tbl);
		int i = 1/0;
		return re;
	}
}
