package com.cist.filing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.filing.mapper.FilingMapper;
import com.cist.filing.model.C_Monitor_Point_Ex;
import com.cist.filing.model.C_road_info;
import com.cist.filing.model.Monitor;
import com.cist.filing.model.Sys_frm_code;
import com.cist.filing.model.Sys_frm_code_type;
import com.cist.filing.model.Tbl_dev_vio_config;
import com.cist.filing.model.Vw_dev_info;
import com.cist.filing.service.FilingService;
import com.cist.frame.page.PageInfo;

@Service
public class FilingServiceImpl implements FilingService{

	@Autowired
	private FilingMapper fiMapper;
	

	@Override
	public Integer addMonitor(Map<String, Object> map) {
		return fiMapper.addMonitor(map);
	}

	@Override
	public Integer addVideo(Map<String, Object> map) {
		return fiMapper.addVideo(map);
	}

	@Override
	public Integer deleteVideo(Map<String, Object> map) {
		return fiMapper.deleteVideo(map);
	}

	@Override
	public Integer deleteGssp(Map<String, Object> map) {
		return fiMapper.deleteGssp(map);
	}

	@Override
	public Object queryAllpageList(Map<String, Object> map, PageInfo info) {
		return fiMapper.queryAll(map);
	}

	@Override
	public List<C_Monitor_Point_Ex> queryMonitor() {
		return fiMapper.queryMonitor();
	}

	@Override
	public List<C_road_info> queryXzgh() {
		return fiMapper.queryXzgh();
	}

	@Override
	public List<Tbl_dev_vio_config> queryMv() {
		return fiMapper.queryMv();
	}

	@Override
	public List<Vw_dev_info> queryTwoList(Map<String, Object> map) {
		return fiMapper.queryTwoList(map);
	}

	@Override
	public List<Sys_frm_code> queryFrm() {
		return fiMapper.queryFrm();
	}

	@Override
	public List<Sys_frm_code_type> queryFrmType() {
		return fiMapper.queryFrmType();
	}

	@Override
	public Integer deleteManage(Map<String, Object> map) {
		return fiMapper.deleteManage(map);
	}

	@Override
	public Integer deleteList(Map<String, Object> map) {
		return fiMapper.deleteList(map);
	}

	@Override
	public List<Monitor> queryToMonitor(Map<String, Object> map) {
		return fiMapper.queryToMonitor(map);
	}

	@Override
	public List<Sys_frm_code> queryListAll() {
		return fiMapper.queryListAll();
	}

	@Override
	public List<Tbl_dev_vio_config> queryDetails(Map<String, Object> map) {
		return fiMapper.queryDetails(map);
	}

	@Override
	public Integer update(Map<String, Object> map) {
		return fiMapper.update(map);
	}

	@Override
	public List<Sys_frm_code> queryFrmCode(String fct_name) {
		return fiMapper.queryFrmCode(fct_name);
	}

}
