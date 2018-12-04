package com.cist.statistics.stataction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.recheck.model.TblOffeCateInfo;
import com.cist.statistics.stataction.mapper.ActionMapper;
import com.cist.statistics.stataction.model.EnsembleJob;
import com.cist.statistics.stataction.model.IllegalBehavior;
import com.cist.statistics.stataction.service.ActionService;

@Service
public class ActionServiceImpl implements ActionService{

	@Autowired
	private ActionMapper mapper;
	
	public List<TblOffeCateInfo> showMap() {
		return mapper.showMap();
	}

	public List<IllegalBehavior> showList() {
		return mapper.showList();
	}

	public List<EnsembleJob> selectZpsl(EnsembleJob job) {
		return mapper.selectZpsl(job);
	}

	public List<EnsembleJob> selectShsl(EnsembleJob job) {
		return mapper.selectShsl(job);
	}


}
