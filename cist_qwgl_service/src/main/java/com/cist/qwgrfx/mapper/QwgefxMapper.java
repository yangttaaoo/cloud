package com.cist.qwgrfx.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cist.khpdgl.model.Qw_Appraise_Reculations;
import com.cist.personageassess.model.Qw_individual_assessment;
import com.cist.qwgrfx.model.Excels;
import com.cist.qwgrfx.model.IndividualInfo;
import com.cist.qwgrfx.model.NumList;
import com.cist.qwgrfx.model.SysPoliceInfo;
import com.cist.qwkhgrfb.model.Qw_Check_Pub;

public interface QwgefxMapper {

	List<Qw_Check_Pub> selectPersonAll(Map<String, Object> map);
	List<IndividualInfo> selectPersonAllList(Map<String, Object> map);
	/**
	 * 警员查询
	 * @return
	 */
	List<SysPoliceInfo> selectPolice();
	
	 List<Excels> selectAllList(HashMap<String, Object> map);
	
	/**
	 * 个人详情
	 * @param pk_id
	 * @return
	 */
	Qw_individual_assessment querypersonageassessinfo(Integer pk_id);
	 
	List<Qw_Appraise_Reculations> selectReculations(Integer pk_id);
	List<NumList> selectAll(HashMap<String, Object> map);
	
	/**
	 * 排名统计
	 * @param map
	 * @return
	 */
	List<Number> selectDesc(HashMap<String, Object> map);
}
