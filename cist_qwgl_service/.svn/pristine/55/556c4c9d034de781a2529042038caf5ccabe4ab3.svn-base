package com.cist.qwkhgrfb.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.qwkhgrfb.mapper.PublishMapper;
import com.cist.qwkhgrfb.model.Publish;
import com.cist.qwkhgrfb.service.PublishService;
@Service
public class PublicshServiceImp implements PublishService {
@Autowired
private PublishMapper  mapper;
	@Override
	public Object selectDatapageList(HashMap<String, Object> map,PageInfo page) {
		return mapper.selectData(map);
	}
	@Override
	public List<Publish> downloadList(HashMap<String, Object> map) {
		return mapper.downloadList(map);
	}

}
