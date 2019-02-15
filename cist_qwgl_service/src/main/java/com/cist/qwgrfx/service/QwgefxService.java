package com.cist.qwgrfx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.khpdgl.model.Qw_Appraise_Reculations;
import com.cist.personageassess.model.Qw_individual_assessment;
import com.cist.qwgrfx.model.Excels;
import com.cist.qwgrfx.model.NumList;
import com.cist.qwgrfx.model.SysPoliceInfo;

@Service(value="QwgefxServiceImpl")
public interface QwgefxService {
	
	Object selectAllpageList(Map<String,Object> map,PageInfo p);
	Object selectAllListpageList(Map<String,Object> map,PageInfo p);
	/**
	 * 警员查询
	 * @return
	 */
	List<SysPoliceInfo> selectPolice();
	List<NumList> selectAll(HashMap<String, Object> map);
	
	 List<Excels> selectAllList(HashMap<String, Object> map);
	
	List<Qw_Appraise_Reculations> selectReculations(Integer pk_id);
	/**
	 * 排名统计
	 * @param map
	 * @return
	 */
	List<Number> selectDesc(HashMap<String, Object> map);
	
	/**
	 * 个人详情
	 * @param pk_id
	 * @return
	 */
	Qw_individual_assessment querypersonageassessinfo(Integer pk_id);
}
