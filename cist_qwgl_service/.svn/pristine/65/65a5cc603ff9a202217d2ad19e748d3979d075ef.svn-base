package com.cist.depttestin.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.depttestin.mapper.TestinMapper;
import com.cist.depttestin.model.Attachment;
import com.cist.depttestin.model.DeptInfo;
import com.cist.depttestin.model.Testin;
import com.cist.depttestin.service.TestinService;
import com.cist.frame.page.PageInfo;
@Service
public class TestinServiceImpl implements TestinService {
@Autowired
 private TestinMapper mapper;
	@Override
	public Object selectDatapageList(HashMap<String, Object> map, PageInfo page) {
		return mapper.selectData(map);
	}

	@Override
	public int addData(HashMap<String, Object> map) {

		return mapper.addData(map);
	}

	@Override
	public int deleteData(HashMap<String, Object> map) {

		return mapper.deleteData(map);
	}

	@Override
	public int updateData(HashMap<String, Object> map) {
		return mapper.updateData(map);
	}

	@Override
	public int addTarget(HashMap<String, Object> map) {
		return mapper.addTarget(map);
	}

	@Override
	public List<DeptInfo> depart_infolist(Object object) {
		return mapper.depart_infolist(object);
	}

	@Override
	public int addBag(HashMap<String, Object> map) {
		return mapper.addBag(map);
	}

	@Override
	public Integer selectPk() {
		return mapper.selectPk();
	}

	@Override
	public List<Attachment> selectAttach(HashMap<String, Object> map) {
		return mapper.selectAttach(map);
	}

	@Override
	public int addLog(HashMap<String, Object> map) {
		return mapper.addLog(map);
	}

	@Override
	public int updateTarget(HashMap<String, Object> map) {
		return mapper.updateTarget(map);
	}

	@Override
	public int updateBag(HashMap<String, Object> map) {

		return mapper.updateBag(map);
	}

	@Override
	public int deleteTarget(HashMap<String, Object> map) {
		return mapper.deleteTarget(map);
	}

	@Override
	public int deleteBag(HashMap<String, Object> map) {
		return mapper.deleteBag(map);
	}

	@Override
	public Integer addCheck(HashMap<String, Object> map) {
		return mapper.addCheck(map);
	}

}
