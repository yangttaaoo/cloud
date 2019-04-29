package com.cist.illegalbehavior.service;

import java.util.HashMap;
import java.util.List;

import com.cist.illegalbehavior.model.Sys_frm_code;
import com.cist.illegalbehavior.model.TblOffeVioWfxwStat;
import com.cist.illegalbehavior.model.TblWfxwClflStat;
import com.cist.illegalbehavior.model.TblWfxwWfddStat;
import com.cist.illegalbehavior.model.TblWfxwXwStat;
import com.cist.illegalbehavior.model.TblWfxwZdcllStat;

/**  
 * @ClassName: illegalBehaviorService  
 * @Description: TODO(违法行为统计)  
 * @author yt  
 * @date 2018年11月07日  
 *    
 */
public interface IllegalBehaviorService {
	
	//违法行为统计
	List<TblWfxwXwStat> selectWfxw(HashMap<String,Object> map);
	
	//车辆类型统计
	List<TblWfxwClflStat> selectCar(HashMap<String,Object> map);
	
	//重点车辆统计
	List<TblWfxwZdcllStat> selectKeyVehicles(HashMap<String,Object> map);
	
	//违法行为柱状图统计
	List<TblOffeVioWfxwStat> selectByWfxw(HashMap<String,Object> map);
	
	//根据违法地点统计违法量
	List<TblWfxwWfddStat> selectByWfdd(HashMap<String,Object> map);
	
	//查询基础信息，违法行为
	List<Sys_frm_code> selectSysfrmCode(String fct_code);
	
	//违法行为部门分组对应的列表
	List<HashMap<String,Object>> selectList(HashMap<String,Object> map);
	
	//根据违法地点统计违法量
	List<HashMap<String,Object>> selectWfddList(HashMap<String,Object> map);
	
	
}
