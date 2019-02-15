package com.cist.wobacklog.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cist.frame.page.PageInfo;
import com.cist.wobacklog.mapper.WoBacklogMapper;
import com.cist.wobacklog.model.JtywJobProcess;
import com.cist.wobacklog.model.VwJtywDbgd;
import com.cist.wobacklog.model.VwJtywJobDev;
import com.cist.wobacklog.model.VwJtywLog;
import com.cist.wobacklog.service.WoBacklogService;


@Service
public class WoBacklogServiceImpl implements WoBacklogService  {
	@Autowired
	private WoBacklogMapper mapper;

	@Override
	public Object listpageList(HashMap<String, Object> map,PageInfo pinfo) {
		return mapper.list(map);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public Integer update(HashMap<String, Object> map) {
		Integer update = mapper.update(map);
		Integer update1 = mapper.insertReceive(map);
		return update;
	}

	@Override
	public VwJtywDbgd selectCount(HashMap<String, Object> map) {
		return mapper.selectCount(map);
	}

	@Override
	public VwJtywDbgd selectAvg(HashMap<String, Object> map) {
		return mapper.selectAvg(map);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public Integer updatePercent(HashMap<String, Object> map) {
		Integer updatePercent = mapper.updatePercent(map);
		Integer update1 = mapper.insertPercent(map);
		return updatePercent;
	}

	@Override
	public Integer updateReceive(HashMap<String, Object> map) {
		return mapper.updateReceive(map);
	}

	@Override
	public Integer insert(HashMap<String, Object> map) {
		return mapper.insert(map);
	}

	@Override
	public List<VwJtywLog> selectLog(HashMap<String, Object> map) {
		return mapper.selectLog(map);
	}

	@Override
	public List<VwJtywJobDev> selectDev(HashMap<String, Object> map) {
		return mapper.selectDev(map);
	}

	@Override
	public Integer insertReceive(HashMap<String, Object> map) {
		return mapper.insertReceive(map);
	}

	@Override
	public Integer insertPercent(HashMap<String, Object> map) {
		return mapper.insertPercent(map);
	}

	

}
