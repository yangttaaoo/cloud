package com.cist.khpd.target.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.khpd.rules.model.Rule;
import com.cist.khpd.target.mapper.TargetMapper;
import com.cist.khpd.target.model.Depart_info;
import com.cist.khpd.target.model.Police;
import com.cist.khpd.target.model.Target;
import com.cist.khpd.target.model.TargetMannage;
import com.cist.khpd.target.service.TargetService;
@Service
public class TargetServiceImpl implements TargetService {
@Autowired
private TargetMapper mapper;
	@Override
	public Object selectAllpageList(HashMap<String, Object> map,PageInfo page) {
		return mapper.selectAll(map);
	}

	@Override
	public Integer addData(HashMap<String, Object> map) {
		return mapper.addData(map);
	}

	@Override
	public Integer deleteData(HashMap<String, Object> pk) {
		return mapper.deleteData(pk);
	}

	@Override
	public Integer updateData(HashMap<String, Object> pk) {
		return mapper.updateData(pk);
	}

	@Override
	public Integer addPerson(HashMap<String, Object> map) {
		return mapper.addPerson(map);
	}

	@Override
	public List<Depart_info> selectDepart() {
		return mapper.selectDepart();
	}

	@Override
	public Depart_info selectInfo(Integer pk) {
		return mapper.selectInfo(pk);
	}

	@Override
	public Integer deletePolice(HashMap<String, Object> map) {
		return mapper.deletePolice(map);
	}

	@Override
	public List<Rule> selectDepat() {
		return mapper.selectDepat();
	}

	@Override
	public List<Rule> selectPorson() {
		return mapper.selectPorson();
	}

	@Override
	public List<Police> selectPolice(Integer pk) {
		return mapper.selectPolice(pk);
	}

	@Override
	public Target getSypiCodeName(String sypi_pk) {
		return mapper.getSypiCodeName(sypi_pk);
	}

	@Override
	public Target getDeptCodeNameHead(String sypi_pk) {
		return mapper.getDeptCodeNameHead(sypi_pk);
	}

	@Override
	public Target getDeptName(String sypi_pk) {
		return mapper.getDeptName(sypi_pk);
	}

	@Override
	public List<Target> selectTestInfo(HashMap<String, Object> map) {
		return mapper.selectTestInfo(map);
	}

	@Override
	public Integer selectDepatInfo(HashMap<String, Object> map) {
		return mapper.selectDepatInfo(map);
	}

	@Override
	public Integer selectDepatInfos(HashMap<String, Object> map) {
		return mapper.selectDepatInfos(map);
	}

	@Override
	public List<TargetMannage> selectExcel(HashMap<String, Object> map) {
		return mapper.selectExcel(map);
	}

}
