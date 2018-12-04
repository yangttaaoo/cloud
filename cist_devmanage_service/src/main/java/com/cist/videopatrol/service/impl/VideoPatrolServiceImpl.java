package com.cist.videopatrol.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.patrolplan.model.Tbl_Dev_Info;
import com.cist.videopatrol.mapper.VideoPatrolMapper;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CASE;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CONFIG;
import com.cist.videopatrol.service.VideoPatrolService;
@Service
public class VideoPatrolServiceImpl implements VideoPatrolService {
	@Autowired
	private VideoPatrolMapper mapper;
	
	public List<TBL_VIO_CRUISE_CASE> querycruise(HashMap<String, Object> map) {
		return mapper.querycruise(map);
	}

	
	public List<TBL_VIO_CRUISE_CONFIG> querycruiseconf(HashMap<String, Object> map) {
		return mapper.querycruiseconf(map);
	}


	public List<Tbl_Dev_Info> querydev(HashMap<String, Object> map) {
		List<Tbl_Dev_Info> list = mapper.querydev(map);
		return list;
	}



	public List<TBL_VIO_CRUISE_CONFIG> queryinfo(HashMap<String, Object> map) {
		return mapper.queryinfo(map);
	}


	@Override
	public Object queryinfopageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.queryinfo(map);
	}

}
