package com.cist.orbit.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.orbit.model.CRoadSegitemInfo;
import com.cist.orbit.model.C_road_item;
import com.cist.orbit.model.Depart_info;
import com.cist.orbit.model.RoadTree;
import com.cist.orbit.model.Sys_frm_code;
import com.cist.orbit.model.TblCarRecoInfo;

public interface OrbitMapper {
	/**
	 * 车辆轨迹查询
	 * 
	 * @param map
	 *            查询条件
	 * @return List<TblCarRecoInfo>
	 */
	List<TblCarRecoInfo> list(HashMap<String, Object> map);

	/**
	 * 查询号牌类别信息
	 * 
	 * @return List<Sys_frm_code>
	 */
	List<Sys_frm_code> selectSysFrmCode(String fct_code);

	/**
	 * 查询所属道路
	 * 
	 * @return List<C_road_item>
	 */
	List<C_road_item> selectRoadList(HashMap<String, Object> map);

	// 上级下级部门
	public List<Depart_info> depart_infolist(Integer dept_superior);

	// 部门下的设备
	public List<Depart_info> clickdepartinfo(String dept_superior);

	// 卡口下的设备
	public List<Depart_info> kakou(String tbec_kkbh);

	// 设备的路段
	public List<Depart_info> yijicdepartinfo(HashMap<String, Object> map);

	// 设备的路段下的设备
	public List<Depart_info> kakouxiabu(HashMap<String, Object> map);
	
	/**
	 * 根据路段代码查询路口名称
	 * 
	 * @return C_road_item
	 */
	CRoadSegitemInfo selectLukou(HashMap<String, Object> map);
	
	/**
	 * 根据条件获取下级行政区域 返回 RoadTree
	 * @param paramMap
	 * @return
	 */
	public List<RoadTree> queryAdministrativeAreas1(HashMap<String, Object> paramMap);
	
	/**
	 * 查询所有道路
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<RoadTree> queryAllRoad(HashMap<String, Object> paramMap);

	/**
	 * 根据道路Code查询路口、路段
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<RoadTree> queryRoadSegiteByRoadCode(HashMap<String, Object> paramMap);
}
