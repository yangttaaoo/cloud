package com.cist.personalstats.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.model.SysDepartInfo;
import com.cist.personalstats.mapper.PersonalStatsMapper;
import com.cist.personalstats.model.DeptInfo;
import com.cist.personalstats.model.PersonalStats;
import com.cist.personalstats.service.PersonalStatsService;

@Service
public class PersonalStatsServiceImpl implements PersonalStatsService {

	@Autowired
	private PersonalStatsMapper mapper;

	public List<SysDepartInfo> selectBySysDepartInfo() {
		
		return mapper.selectSysDepartInfo();
	}
	/**
	 * 个人工作统计
	 * 
	 * @return List<TblOffeEvdiInfo>
	 */
	public Object selectPersonalStatspageList(HashMap<String,Object> map,PageInfo p) {
		return mapper.selectPersonalStats(map);
	}
	
	/**
	 * 个人工作统计根据违法行为统计
	 * 
	 * @return List<PersonalStats>
	 */
	public List<PersonalStats> statsListByWfxw(HashMap<String, Object> map) {
		return mapper.statsListByWfxw(map);
	}
	public List<PersonalStats> statsListByCs(HashMap<String, Object> map) {
		return mapper.statsListByCs(map);
	}
	public List<PersonalStats> statsListByFs(HashMap<String, Object> map) {
		return mapper.statsListByFs(map);
	}
	/**
	 * 个人工作统计图不分页
	 * 
	 * @return List<TblOffeEvdiInfo>
	 */
	public List<PersonalStats> selectPersonalStats(HashMap<String, Object> map) {
		return mapper.selectPersonalStats(map);
	}
	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

}
