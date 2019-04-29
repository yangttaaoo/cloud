package com.cist.pdgrzb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.pdgrzb.mapper.PersonMapper;
import com.cist.pdgrzb.model.Depart_info;
import com.cist.pdgrzb.model.DeptInfo;
import com.cist.pdgrzb.model.NumIndex;
import com.cist.pdgrzb.model.Syspoliceinfo;
import com.cist.pdgrzb.service.PersonService;
@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonMapper mapper;

	@Override
	public Object selectAllpageList(Map<String, Object> map, PageInfo p) {
		return mapper.selectPersonAll(map);
	}

	@Override
	public Integer insertPerson(Map<String, Object> map) {
		return mapper.insertPerson(map);
	}

	@Override
	public Integer deletePerson(Map<String, Object> map) {
		return mapper.deletePerson(map);
	}

	@Override
	public Integer updatePerson(Map<String, Object> map) {
		return mapper.updatePerson(map);
	}

	@Override
	public Integer deletePersonAll(String[] pk) {
		return mapper.deletePersonAll(pk);
	}

	@Override
	public List<Depart_info> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}


	@Override
	public List<Depart_info> selectPerson(Integer pk_id) {
		return mapper.selectPerson(pk_id);
	}

	@Override
	public List<DeptInfo> depart_infolists(Integer dept_superior) {
		return mapper.depart_infolists(dept_superior);
	}

	@Override
	public Integer insertZb(Map<String, Object> map) {
		return mapper.insertZb(map);
	}

	@Override
	public Integer updateZb(Map<String, Object> map) {
		return mapper.updateZb(map);
	}

	@Override
	public Integer deletePersons(Map<String, Object> map) {
		return mapper.deletePersons(map);
	}

	@Override
	public List<NumIndex> queryNum(Integer pk_id) {
		return mapper.queryNum(pk_id);
	}

	@Override
	public Integer deletePersonAlls(String[] pk) {
		return mapper.deletePersonAlls(pk);
	}


	
}
