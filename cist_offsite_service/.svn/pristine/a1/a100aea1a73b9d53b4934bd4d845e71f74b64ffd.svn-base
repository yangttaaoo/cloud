package com.cist.personalstats.service;

import java.util.HashMap;
import java.util.List;
import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.model.SysDepartInfo;
import com.cist.offsite.invalidtrial.model.TblOffeEvdiInfo;
import com.cist.offsite.invalidtrial.model.VwDevInfo;
import com.cist.personalstats.model.DeptInfo;
import com.cist.personalstats.model.PersonalStats;

/**
 * @ClassName: PersonalStatsService
 * @Description: TODO(个人工作统计业务层)
 * @author yt
 * @date 2018年6月1日
 * 
 */
public interface PersonalStatsService {

	/**
	 * 查询采集单位信息
	 * 
	 * @return List<SysDepartInfo>
	 */
	List<SysDepartInfo> selectBySysDepartInfo();

	/**
	 * 个人工作统计
	 * 
	 * @return Object
	 */
	Object selectPersonalStatspageList(HashMap<String,Object> map,PageInfo p);
	
	/**
	 * 个人工作统计
	 * 
	 * @return List<PersonalStats>
	 */
	List<PersonalStats> selectPersonalStats(HashMap<String,Object> map);
	
	/**
	 * 个人工作统计根据违法行为统计
	 * 
	 * @return List<PersonalStats>
	 */
	List<PersonalStats> statsListByWfxw(HashMap<String,Object> map);
	/**
	 * 初审个人工作统计
	 * 
	 * @return List<PersonalStats>
	 */
	List<PersonalStats> statsListByCs(HashMap<String,Object> map); 
	
	/**
	 * 复审个人工作统计
	 * 
	 * @return List<PersonalStats>
	 */
	List<PersonalStats> statsListByFs(HashMap<String,Object> map); 
	
	/**
	 * 使用单位树
	 * @param dept_superior
	 * @return
	 */
	List<DeptInfo> depart_infolist(Integer dept_superior);
}
