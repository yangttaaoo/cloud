package com.cist.statistics.stataction.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cist.recheck.model.TblOffeCateInfo;
import com.cist.statistics.stataction.model.EnsembleJob;
import com.cist.statistics.stataction.model.IllegalBehavior;

@Service(value="ActionServiceImpl")
public interface ActionService {

	/**
	 * 
	 * @return
	 */
	List<TblOffeCateInfo> showMap();
	

	List<IllegalBehavior> showList();
	
	List<EnsembleJob> selectZpsl(EnsembleJob job);
	
	List<EnsembleJob> selectShsl(EnsembleJob job);
}

