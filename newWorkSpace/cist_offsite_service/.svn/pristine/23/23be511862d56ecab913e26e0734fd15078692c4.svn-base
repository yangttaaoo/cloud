package com.cist.statistics.stataction.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.recheck.model.TblOffeCateInfo;
import com.cist.statistics.stataction.model.EnsembleJob;
import com.cist.statistics.stataction.model.IllegalBehavior;
import com.cist.statistics.stataction.service.ActionService;

@RestController
@RequestMapping("action")
public class ActionController {
	
	@Autowired
	private ActionService aService;
	
	@RequestMapping("tomap")
	public List<TblOffeCateInfo> toMap(){
		return aService.showMap();
	}
	
	@RequestMapping("tolist")
	public List<IllegalBehavior> toList(){
		return aService.showList();
	}
	
/*	@RequestMapping("golist")
	public List<EnsembleJob> queryList(@RequestBody EnsembleJob job){
		List<EnsembleJob> zList = aService.selectZpsl(job);
		List<EnsembleJob>  sList = aService.selectShsl(job);
		for (int i = 0; i < sList.size(); i++) {
			for (int j = 0; j < zList.size(); j++) {
				if(list.get(i).getWfxw()==list1.get(j).getWfxw()){
					list.get(i).setShsl(list.get(j).getShsl());
				}
				if(sList.get(i).getWfxw().equals(zList.get(j).getWfxw())&&sList.get(i).getSj().equals(zList.get(j).getSj())){
					sList.get(i).setZpsl(zList.get(j).getZpsl());
				}else{
					sList.get(i).setZpsl(0);
				}
			}
		}
		return sList;
	}*/
	
}
